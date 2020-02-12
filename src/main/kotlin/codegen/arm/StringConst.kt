package codegen.arm

import codegen.arm.Operand.Label

class StringConst(val label: Label, val content: String) {
    companion object {
        fun fromMap(defMap: Map<String, Label>): Collection<StringConst> {
            return defMap.map { (content, label) ->
                StringConst(label, content)
            }
        }
    }

    override fun toString(): String {
        return """
            ${label.name}
                .word ${content.length}
                .ascii "$content"
        """.trimIndent()
    }

}