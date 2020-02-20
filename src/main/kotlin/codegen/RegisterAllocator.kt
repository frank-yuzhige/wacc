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
        val realRegSet: TreeSet<Int> = (4..100).toCollection(TreeSet())
        val liveRangeMap = getLiveRangeMap()
        val freeRegMap = mutableMapOf<Int, MutableList<Reg>>()
        liveRangeMap.forEach { (reg, range) ->
            val last = range.last
            if (last !in freeRegMap) {
                freeRegMap[last] = mutableListOf(reg)
            } else {
                freeRegMap.getValue(last) += reg
            }
        }
        val virtualToRealMap = mutableMapOf<Reg, Reg>()
        for ((index, instr) in instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs }
            defs.filterNot { it in virtualToRealMap }.forEach { virtual ->
                val real = realRegSet.pollFirst()?.let(::Reg)
                virtualToRealMap[virtual] = real!!
            }
            freeRegMap[index]?.forEach { virtual -> virtualToRealMap[virtual]?.let { real -> realRegSet += real.id } }
        }
        return InstructionBlock(label, instructions.map { it.unify(virtualToRealMap) }, terminator, tails)
    }

    private fun InstructionBlock.getLiveRangeMap(): Map<Reg, IntRange> {
        val virtualLiveRangeMap = mutableMapOf<Reg, IntRange>()
        for ((index, instr) in this.instructions.withIndex()) {
            val defs = instr.getDefs().filterIsInstance<Reg>().filterNot { it in reservedRegs }
            val uses = instr.getUses().filterIsInstance<Reg>().filterNot { it in reservedRegs }
            defs.forEach { virtual ->
                virtualLiveRangeMap[virtual] = (index..-1)
            }
            uses.forEach { virtual ->
                val start = virtualLiveRangeMap[virtual]!!.first
                virtualLiveRangeMap[virtual] = start..index
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