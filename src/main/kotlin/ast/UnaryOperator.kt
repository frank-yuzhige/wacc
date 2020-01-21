package ast

enum class UnaryOperator(val op: String) {
    ORD("ord"),
    CHR("chr"),
    LEN("len"),
    NEG("-"),
    NOT("!");

    override fun toString(): String = op
}