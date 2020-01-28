package ast

import exceptions.SyntacticException.UnknownUnaryOpException

enum class UnaryOperator(val op: String) {
    ORD("ord"),
    CHR("chr"),
    LEN("len"),
    NEG("-"),
    NOT("!");

    companion object {
        val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun read(op : String) : UnaryOperator =
                keyValueMap[op]?: throw UnknownUnaryOpException(op)
    }

    override fun toString(): String = op
}