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
}
