package codegen

import codegen.arm.Instruction
import codegen.arm.Instruction.Terminator
import codegen.arm.Operand.Label

class InstructionBlock(val label: Label,
                       val instructions: List<Instruction>,
                       var terminator: Terminator) {
}
