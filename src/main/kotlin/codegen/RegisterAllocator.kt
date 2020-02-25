package codegen

import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand
import codegen.arm.Operand.*
import codegen.arm.Operand.Register.Reg
import codegen.arm.Operand.Register.Reg.Companion.normalRegs
import codegen.arm.Operand.Register.Reg.Companion.reservedRegs
import codegen.arm.Operand.Register.SpecialReg
import codegen.arm.SpecialRegName.*
import java.util.*

/* RegisterAllocator takes a "raw" ARM program, generates a unification (virtual -> real), and
*  apply such unification to the original arm program to give a truly functional program.
*  Necessary PUSHes and POPs are inserted to the original program as well, and the offset of SP
*  will also be corrected accordingly. */
class RegisterAllocator(val program: ArmProgram) {

    fun run(): ArmProgram {
        return ArmProgram(program.stringConsts, program.blocks.map { it.rename() })
    }

    /* "Rename" all virtual registers in a given instruction block to real registers.
    *  It would automatically generate a unification which is applicable in the context of
    *  the current instruction block, add PUSH and POP instructions where necessary, re-calculates
    *  and updates the SP offset, and finally "renames" (unifies) all virtual registers with the
    *  generated unification.
    *
    *  Each virtual register is assigned to a real register. Each real register can accept multiple virtual
    *  registers. However, if a real register accepts several virtual regs at the same time, it is guaranteed
    *  that each virtual register is pushed to the stack in the order of their occurrence (def), except for
    *  the last virtual register which is currently in use. It is also guaranteed that if a virtual register
    *  "PUSHed" the other register, they must satisfy several rules to ensure no register collision (see method
    *  "LiveRangeMap.findVirtualToPush" in LiveRange.kt). */
    private fun InstructionBlock.rename(): InstructionBlock {
        val availableRealRegs: TreeSet<Int> = normalRegs().map { it.id }.toCollection(TreeSet())
        val liveRangeMap = getLiveRangeMap()
        liveRangeMap.dump()
        /* index to list of regs to be freed at that instruction */
        val freeRegMap = mutableMapOf<Int, MutableList<Reg>>()
        liveRangeMap.forEach { (reg, liveRange) ->
            val last = liveRange.lastUsage()
            if (last in freeRegMap) {
                freeRegMap.getValue(last) += reg
            } else {
                freeRegMap[last] = mutableListOf(reg)
            }
        }
        /* Dynamically construct a virtual register to real register unification, while
        *  doing necessary modifications to the original instructions. */
        val newInstructions = mutableListOf<Instruction>() // collection of instructions.
        val virtualToRealMap = mutableMapOf<Reg, Reg>() // The "unification map" we need to construct.
        val realToVirtualMap // Records all virtual regs unifies with each real register.
                = normalRegs().map { it to mutableSetOf<Reg>() }.toMap()
        val realVirtualStackMap // Simulates the "virtual stack" for each real register.
                = normalRegs().map { it to ArrayDeque<Reg>() }.toMap()
        val virtualsStack = mutableListOf<Reg>()  // Simulates the stack. Shows which virtual has been pushed.
        val popedVirtuals = mutableSetOf<Reg>()   // virtuals that are on the stack, yet no longer needed.
        val deadVirtuals = mutableSetOf<Reg>()
        var spOffset = 0 // additional sp offset adjustment.
        for ((index, instr) in instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs() }
            /* For each un-unified register which has been defined in the current instruction,
            *  unify it with a given real Reg. */
            defs.filterNot { it in virtualToRealMap }.forEach { virtual ->
                val real = availableRealRegs.pollFirst()?.let(::Reg)
                if (real == null) { // if we are running out of registers...
                    /* Find a already unified virtual register which will not be used at all during the live range of
                    *  the current virtual register, push that virtual register, and make the current virtual register
                    *  to be unified with the actual register that the already pushed virtual register unifies to. */
                    val pushedVirtual = liveRangeMap.findVirtualToPush(
                            virtual,
                            virtualToRealMap,
                            virtualsStack,
                            deadVirtuals,
                            realToVirtualMap,
                            instructions
                    )
                    newInstructions += Push(mutableListOf(pushedVirtual))
                    val currReal = virtualToRealMap.getValue(pushedVirtual)
                    virtualToRealMap[virtual] = currReal
                    realVirtualStackMap.getValue(currReal) += virtual
                    realToVirtualMap.getValue(currReal) += virtual
                    virtualsStack.add(0, pushedVirtual)
                    spOffset += 4
                } else {
                    /* Otherwise, simply unifies the currently avaliable real reg with the virtual register */
                    virtualToRealMap[virtual] = real
                    realVirtualStackMap.getValue(real) += virtual
                }
            }
            newInstructions += instr.adjustBySpOffset(spOffset)
            /* For each virtual register that should be dead by the end of this instruction, "kill" it.
            *  [INVARIANT]: each dying reg should not be on the stack (if it is on the stack, that means the virtual
            *     which pushed the current virtual is not yet killed, which contradicts with our live-range reg allocation
            *     policy. Hence it would never happen.)
            *  1. If it has not pushed any virtual, means the real register that is unified with it is now free.
            *  2. If the virtual it pushed is on the top of the stack, simply pop that register down.
            *  3. Otherwise, it has pushed some virtual, yet the pushed virtual is not on the top of the stack.
            *     In this case, find and load the value of the pushed virtual, mark the pushed virtual as "to be poped". */
            freeRegMap[index]?.forEach { dyingReg ->
                val real = virtualToRealMap.getValue(dyingReg)
                val pushed = realVirtualStackMap.getValue(real).lastOrNull { it != dyingReg }
                if (pushed == null) {
                    availableRealRegs += real.id
                } else if (virtualsStack.isNotEmpty() && virtualsStack[0] == pushed) {
                    spOffset -= 4
                    newInstructions += Pop(pushed)
                    virtualsStack.removeAt(0)
                } else {  // case 3
                    val offset = 4 * virtualsStack.indexOf(pushed)
                    newInstructions += Ldr(Condition.AL, dyingReg, Offset(SpecialReg(SP), offset))
                    popedVirtuals += pushed
                }
                realVirtualStackMap.getValue(real) -= dyingReg
                deadVirtuals += dyingReg
            }
            /* Remove any "to-be-poped" virtual regs from the top of the stack.
            *  Move and re-calculate the current sp offset. */
            var acc = 0
            while (virtualsStack.firstOrNull() in popedVirtuals) {
                val virtual = virtualsStack.removeAt(0)
                val real = virtualToRealMap.getValue(virtual)
                realVirtualStackMap.getValue(real) -= virtual
                acc += 4
                popedVirtuals -= virtual
            }
            if (acc > 0) {
                spOffset -= acc
                newInstructions += Add(Condition.AL, SpecialReg(SP), SpecialReg(SP), ImmNum(acc))
            }
        }
        /* Finally, unify the newly-generated instructions with the generated unification.
        *  Then re-pack it to get our final instruction block. */
        return InstructionBlock(label, newInstructions.map { it.unify(virtualToRealMap) }, terminator, tails)
    }

    /* Generate a live range map for all virtual registers appeared in this instruction block. */
    private fun InstructionBlock.getLiveRangeMap(): LiveRangeMap {
        val virtualLiveRangeMap = mutableMapOf<Reg, LiveRange>()
        for ((index, instr) in this.instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs() }
            val uses = instr.getUses().filterIsInstance<Reg>().filterNot { it in reservedRegs() }
            defs.forEach { virtual ->
                if (virtual in virtualLiveRangeMap) {
                    virtualLiveRangeMap[virtual]!!.defs += index
                } else {
                    virtualLiveRangeMap[virtual] = LiveRange(index)
                }
            }
            uses.forEach { virtual ->
                virtualLiveRangeMap[virtual]!!.uses += index
            }
        }
        return virtualLiveRangeMap
    }

    /* Unifies virtual registers in the given instruction by the real instruction, as per the given
    *  virtual-to-real unification map. */
    private fun Instruction.unify(unification: Map<Reg, Reg>): Instruction {
        return when(this) {
            is Add -> Add(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification), setFlag)
            is Sub -> Sub(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification), setFlag)
            is Mul -> Mul(cond, dest.unify(unification), rm.unify(unification), rs.unify(unification), setFlag)
            is Smull ->  Smull(cond, rdLo.unify(unification), rdHi.unify(unification), rn.unify(unification), rm.unify(unification))
            is Div -> Div(dest.unify(unification), rn.unify(unification))
            is Rsb -> Rsb(s, cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Cmp -> Cmp(rn.unify(unification), opr.unify(unification), modifier)
            is Mov -> Mov(cond, dest.unify(unification), opr.unify(unification))
            is And -> And(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Orr -> Orr(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Eor -> Eor(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Ldr -> Ldr(cond, dest.unify(unification), opr.unify(unification))
            is Ldrsb -> Ldrsb(cond, dest.unify(unification), opr.unify(unification))
            is Str -> Str(cond, src.unify(unification), dst.unify(unification))
            is Strb -> Strb(src.unify(unification), dst.unify(unification))
            is Push -> Push(regList.map { it.unify(unification) }.toMutableList())
            is Pop -> Pop(regList.map { it.unify(unification) }.toMutableList())
            is Named -> Named(name, instr.unify(unification))
            else -> this
        }
    }

    @Suppress("UNCHECKED_CAST") // All casts here are guaranteed to be safe, yet kotlin complaint. Make it happy.
    private fun<T: Operand> T.unify(unification: Map<Reg, Reg>): T {
        return when(this) {
            is Reg -> if (this in reservedRegs()) this else unification[this] as T
            is Offset -> Offset(src.unify(unification), offset, wb) as T
            else -> this
        }
    }
}