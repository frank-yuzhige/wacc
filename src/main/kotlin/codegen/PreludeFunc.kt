package codegen

import codegen.arm.Operand

enum class PreludeFunc(val needs: List<PreludeFunc> = emptyList()) {
    RUNTIME_ERROR,
    OVERFLOW_ERROR(listOf(RUNTIME_ERROR)),
    CHECK_DIV_BY_ZERO(listOf(RUNTIME_ERROR)),
    CHECK_NULL_PTR(listOf(RUNTIME_ERROR)),
    CHECK_ARR_BOUND(listOf(CHECK_NULL_PTR)),
    FREE_STRUCT(listOf(CHECK_NULL_PTR)),
    FREE_PAIR(listOf(CHECK_NULL_PTR));

    fun getLabel(): Operand.Label {
        return Operand.Label("p_" + name.toLowerCase())
    }

    fun findDependencies(): List<PreludeFunc> {
        return needs.flatMap { it.findDependencies() } + this
    }
}
