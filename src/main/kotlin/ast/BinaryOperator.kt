package ast

enum class BinaryOperator(val op : String) : WaccAST {
    MUL("*"),
    DIV("/"),
    MOD("%"),
    ADD("+"),
    SUB("-"),
    GTE(">="),
    LTE("<="),
    GT (">"),
    LT ("<"),
    EQ ("=="),
    NEQ("!="),
    AND("&&"),
    OR ("||");

    fun getPriority() : Int = when(this) {
        MUL, DIV, MOD -> 1
        ADD, SUB -> 2
        GTE, GT, LTE, LT -> 3
        EQ, NEQ -> 4
        AND, OR -> 5
    }

    override fun toString(): String = op
}