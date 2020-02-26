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

    fun printWithIndex(): String {
        var index = 0
        val header = ".data\n\n" +
                stringConsts.joinToString("\n") +
                "\n.text\n\n" +
                ".global main\n"
        val sb = StringBuilder().append(header.prependIndent())
        blocks.forEach { block ->
            sb.append(block.label.toString().prependIndent())
            sb.append(":\n")
            block.instructions.forEach { instr ->
                sb.append("${index.toString().padEnd(4)}$instr\n")
                index++
            }
            if (block.terminator !is Instruction.Terminator.FallThrough
                    && block.terminator !is Instruction.Terminator.Unreachable) {
                sb.append("${index.toString().padEnd(4)}${block.terminator}\n")
                index++
            }
            block.tails.forEach { tail ->
                sb.append("    $tail\n")
            }
        }
        return sb.toString()
    }
}