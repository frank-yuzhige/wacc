package ast

import java.lang.IllegalArgumentException

enum class UnaryOperator(val op: String) : WaccAST {
    ORD("ord"),
    CHR("chr"),
    LEN("len"),
    NEG("-"),
    NOT("!");

    companion object {
        val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun read(op : String) : UnaryOperator =
                keyValueMap[op]?: throw IllegalArgumentException("Unknown unary operator: $op")
    }

    override fun toString(): String = op
}