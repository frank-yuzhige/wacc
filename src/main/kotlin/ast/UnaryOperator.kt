package ast

enum class UnaryOperator(val op: String) : WaccAST {
    ORD("ord"),
    CHR("chr"),
    LEN("len"),
    NEG("-"),
    NOT("!");

    override fun toString(): String = op
}