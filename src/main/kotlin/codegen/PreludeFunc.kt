package codegen

import codegen.arm.Operand

enum class PreludeFunc(val needs: List<PreludeFunc> = emptyList()) {
    RUNTIME_ERROR,
    OVERFLOW_ERROR(listOf(RUNTIME_ERROR)),
    CHECK_DIV_BY_ZERO(listOf(RUNTIME_ERROR)),
    CHECK_ARR_BOUND(listOf(RUNTIME_ERROR)),
    FREE_ARRAY(listOf(RUNTIME_ERROR)),
    FREE_PAIR(listOf(RUNTIME_ERROR));

    fun getLabel(): Operand.Label {
        return Operand.Label("p_" + name.toLowerCase())
    }

    fun findDependencies(): List<PreludeFunc> {
        return needs.flatMap { it.findDependencies() } + this
    }
}
