package codegen.arm

sealed class Operand {
    data class Register(val regName: String): Operand()
    data class ImmNum(val num: Int): Operand() {
        companion object {
            fun immTrue() = ImmNum(1)
            fun immFalse() = ImmNum(0)
            fun immNull() = ImmNum(0)
        }
    }
    data class Label(val label: String): Operand()
    data class AbsString(val value: String): Operand()
}
