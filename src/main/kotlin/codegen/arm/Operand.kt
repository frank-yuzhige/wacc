package codegen.arm

sealed class Operand {
    data class Register(val regName: String): Operand()
    data class ImmNum(val num: Int): Operand()
    data class Label(val label: String): Operand()
    data class AbsString(val value: String): Operand()
}
