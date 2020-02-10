package codegen

import codegen.arm.Instruction
import codegen.arm.Register

class InstructionBlock(val label: String, val instructions: List<Instruction>, val successors: List<InstructionBlock>) {
    fun getTerminator(): Instruction = instructions.last()
}
