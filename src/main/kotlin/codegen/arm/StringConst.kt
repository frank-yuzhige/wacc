package codegen.arm

import codegen.arm.Operand.Label

class StringConst(val label: Label, val content: String) {
    override fun toString(): String {
        return """
            ${label.name}
                .word ${content.length}
                .ascii "$content"
        """.trimIndent()
    }
}