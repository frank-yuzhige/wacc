package codegen

import codegen.arm.Instruction
import codegen.arm.Instruction.Terminator
import codegen.arm.Operand.Label

class InstructionBlock(val label: Label,
                       val instructions: List<Instruction>,
                       var terminator: Terminator,
                       val tails: MutableList<Instruction> = mutableListOf()) {
    override fun toString(): String {
        val body = when (terminator) {
            is Terminator.FallThrough,
            is Terminator.Unreachable -> instructions + tails
            else -> instructions + terminator + tails
        }
        return "$label:\n" + body.joinToString("\n").prependIndent()
    }

    fun getInstrCount() = instructions.size +
            when(terminator) { is Terminator.FallThrough, is Terminator.Unreachable -> 0; else -> 1}

    fun findInstrAt(index: Int): Instruction {
        return if (index in instructions.indices) {
            instructions[index]
        } else if (index == instructions.size) {
            when (terminator) {
                is Terminator.FallThrough,
                is Terminator.Unreachable -> throw ArrayIndexOutOfBoundsException("Instr at $index is a null-terminator")
                else -> terminator
            }
        } else {
            throw ArrayIndexOutOfBoundsException("Couldn't find instr at $index")
        }
    }
}
