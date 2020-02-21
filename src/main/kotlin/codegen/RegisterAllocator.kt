package codegen

import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand
import codegen.arm.Operand.Offset
import codegen.arm.Operand.Register.Reg
import codegen.arm.Operand.Register.SpecialReg
import codegen.arm.SpecialRegName.*
import java.util.*

class RegisterAllocator(val program: ArmProgram) {

    private val reservedRegs = (0..3).map(::Reg)

    fun run(): ArmProgram {
        return ArmProgram(program.stringConsts, program.blocks.map { it.rename() })
    }

    private fun InstructionBlock.rename(): InstructionBlock {
        /* All currently available 'normal' registers */
        val realRegSet: TreeSet<Int> = (4..11).toCollection(TreeSet())
        val liveRangeMap = getLiveRangeMap()
        println("In block <${this.label}>:")
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
        /* Dynamically construct a virtual register to real register unification */
        val virtualToRealMap = mutableMapOf<Reg, Reg>()
        val realToVirtualMap = (4..11).map { Reg(it) to mutableListOf<Reg>() }.toMap()
        val newInstructions = mutableListOf<Instruction>()
        val virtualsStack = mutableListOf<Reg>()
        val deadVirtuals = mutableSetOf<Reg>()
        var spOffset = 0
        for ((index, instr) in instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs }
            /* For each un-unified register which has been defined in the current instruction,
            *  unify it with a given real Reg. */
            defs.filterNot { it in virtualToRealMap }.forEach { virtual ->
                val real = realRegSet.pollFirst()?.let(::Reg)
                if (real == null) { // if we are running out of registers...
                    /* Find a already unified virtual register which will not be used at all during the live range of
                    *  the current virtual register, push that virtual register, make the current virtual register to
                    *  be unified with the actual register that the already pushed virtual register unifies to,
                    *  and pop the pushed virtual back when the current register finishes its life. */
                    val pushedVirtual = liveRangeMap.findVirtualToPush(virtual, virtualToRealMap, virtualsStack, deadVirtuals)
                    System.err.println("$virtual: pushed $pushedVirtual, which unifies real ${virtualToRealMap.getValue(pushedVirtual)}")
                    newInstructions += Push(mutableListOf(pushedVirtual))
                    val currReal = virtualToRealMap.getValue(pushedVirtual)
                    virtualToRealMap[virtual] = currReal
                    realToVirtualMap.getValue(currReal) += virtual
                    virtualsStack.add(0, pushedVirtual)
                    spOffset += 4
                } else {
                    System.err.println("$virtual unifies with $real")
                    virtualToRealMap[virtual] = real
                    realToVirtualMap.getValue(real) += virtual
                }
            }
            newInstructions += instr.adjustBySpOffset(spOffset)
            /* According to the freeRegMap, "kill" all virtual registers by:
            *  1. If it is on the top of the virtual stack, pop it, mark it as dead.
            *  2. If it is in, yet not on the top of the virtual stack, load its address to the real register,
            *     and mark it as dead.
            *  3. Otherwise, add the id of the real reg that it is unified with to the set of available real
            *     regs, and mark it as dead.   */
            freeRegMap[index]?.forEach { dying ->
                val real = virtualToRealMap.getValue(dying)
                realToVirtualMap.getValue(real) -= dying
                if (virtualsStack[0] == dying) {
                    spOffset -= 4
                    newInstructions += Pop(dying)
                    virtualsStack.removeAt(0)
                } else if (dying in virtualsStack) {
                    val offset = 4 * virtualsStack.indexOf(dying)
                    newInstructions += Ldr(Condition.AL, dying, Offset(SpecialReg(SP), offset))
                } else {
                    realRegSet += real.id
                }
                deadVirtuals += dying
            }
            /* Remove already dead virtual regs on the top of the stack. */
            while (virtualsStack.firstOrNull() in deadVirtuals) {
                virtualsStack.removeAt(0)
            }
        }
        /* Finally, unify the newly-generated instructions with the generated unification.
        *  Then re-pack it to the same instruction block. */
        return InstructionBlock(label, newInstructions.map { it.unify(virtualToRealMap) }, terminator, tails)
    }

    private fun InstructionBlock.getLiveRangeMap(): LiveRangeMap {
        val virtualLiveRangeMap = mutableMapOf<Reg, LiveRange>()
        for ((index, instr) in this.instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs }
            val uses = instr.getUses().filterIsInstance<Reg>().filterNot { it in reservedRegs }
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

    private fun Instruction.unify(unification: Map<Reg, Reg>): Instruction {
        return when(this) {
            is Add -> Add(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Sub -> Sub(cond, dest.unify(unification), rn.unify(unification), opr.unify(unification))
            is Mul -> Mul(cond, dest.unify(unification), rm.unify(unification), rs.unify(unification))
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

    private fun<T: Operand> T.unify(unification: Map<Reg, Reg>): T {
        return when(this) {
            is Reg -> if (this in reservedRegs) this else unification[this] as T
            is Offset -> Offset(src.unify(unification), offset, wb) as T
            else -> this
        }
    }
}