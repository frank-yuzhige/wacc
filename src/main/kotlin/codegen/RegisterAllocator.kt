package codegen

import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand
import codegen.arm.Operand.Register.Reg
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
        val newInstructions = mutableListOf<Instruction>()
        val popMap = mutableMapOf<Int, MutableList<Reg>>()
        val pushedVirtuals = mutableSetOf<Reg>()
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
                    val pushedVirtual = liveRangeMap.findVirtualToPush(virtual, virtualToRealMap, pushedVirtuals, deadVirtuals)
                    System.err.println("$virtual: pushed $pushedVirtual, which unifies real ${virtualToRealMap.getValue(pushedVirtual)}")
                    newInstructions += Push(mutableListOf(pushedVirtual))
                    virtualToRealMap[virtual] = virtualToRealMap.getValue(pushedVirtual)
                    pushedVirtuals += pushedVirtual
                    spOffset += 4
                    val popIndex = liveRangeMap.getValue(virtual).lastUsage()
                    if (popIndex in popMap) {
                        popMap.getValue(popIndex) += pushedVirtual
                    } else {
                        popMap[popIndex] = mutableListOf(pushedVirtual)
                    }
                } else {
                    System.err.println("$virtual unifies with $real")
                    virtualToRealMap[virtual] = real
                }
            }
            newInstructions += instr.adjustBySpOffset(spOffset)
            /* Free any used registers */
            freeRegMap[index]?.forEach { virtual ->
                virtualToRealMap[virtual]?.let { real -> realRegSet += real.id }
                deadVirtuals += virtual
            }
            popMap[index]?.let {
                /* TODO: instead of poping directly, load the pushed stuff to the dest reg if the first on the stack is not
                *   the loaded stuff, then ... */
                val pops = it.asReversed().toMutableList()
                spOffset -= 4 * pops.size
                pushedVirtuals -= pops
                newInstructions += Pop(pops)
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
            is Operand.Offset -> Operand.Offset(src.unify(unification), offset, wb) as T
            else -> this
        }
    }
}