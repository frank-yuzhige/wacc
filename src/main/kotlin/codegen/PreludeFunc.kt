package codegen

import codegen.arm.Operand

enum class PreludeFunc(val needs: List<PreludeFunc> = emptyList()) {
    RUNTIME_ERROR,
    OVERFLOW_ERROR(listOf(RUNTIME_ERROR));

    fun getLabel(): Operand.Label {
        return Operand.Label(name.toLowerCase())
    }

    fun findDependencies(): List<PreludeFunc> {
        return needs.flatMap { it.findDependencies() } + this
    }
}
