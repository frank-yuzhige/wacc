package codegen.arm

class StringConst(val label: String, val length: Int, val content: String) {
    override fun toString(): String {
        return """
            $label
                .word $length
                .ascii "$content"
        """.trimIndent()
    }
}