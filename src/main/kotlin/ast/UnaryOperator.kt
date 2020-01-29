package ast

import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import exceptions.SyntacticException.UnknownUnaryOpException

enum class UnaryOperator(val op: String, val retType: Type) {
    ORD("ord", intType()),
    CHR("chr", charType()),
    LEN("len", intType()),
    NEG("-", intType()),
    NOT("!", boolType());

    companion object {
        val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun read(op : String) : UnaryOperator =
                keyValueMap[op]?: throw UnknownUnaryOpException(op)
    }

    override fun toString(): String = op
}