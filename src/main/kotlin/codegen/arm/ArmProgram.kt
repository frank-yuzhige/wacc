package codegen.arm

import codegen.InstructionBlock

class ArmProgram(val stringConsts: List<StringConst>, val blocks: List<InstructionBlock>) {
    override fun toString(): String =
        ".data\n\n" +
                stringConsts.joinToString("\n") +
                "\n.text\n\n" +
                ".global main\n" +
                blocks.joinToString("\n") + "\n"

    fun findInstrAt(index: Int): Instruction {
        var i = index
        for (block in blocks) {
            if (i < block.getInstrCount()) {
                return block.findInstrAt(i)
            }
            i -= block.getInstrCount()
        }
        throw ArrayIndexOutOfBoundsException("Couldn't find instr at $index")
    }
}