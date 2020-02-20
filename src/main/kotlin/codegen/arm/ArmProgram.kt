package codegen.arm

import codegen.InstructionBlock

class ArmProgram(val stringConsts: List<StringConst>, val blocks: List<InstructionBlock>) {
    override fun toString(): String =
        ".data\n\n" +
                stringConsts.joinToString("\n") + "\n.text\n\n" +
                ".global main\n" +
                blocks.joinToString("\n")
}