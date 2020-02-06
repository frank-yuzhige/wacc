package ast

import ast.Type.Companion.anyArrayType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import exceptions.SyntacticException.UnknownUnaryOpException
import semantics.TypeChecker.Companion.match

enum class UnaryOperator(val op: String, val retType: Type) {
    ORD("ord", intType()),
    CHR("chr", charType()),
    LEN("len", intType()),
    NEG("-", intType()),
    NOT("!", boolType());

    companion object {
        val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun typeMap() = hashMapOf(
                ORD to (match(charType()) to intType()),
                CHR to (match(intType()) to charType()),
                LEN to (match(anyArrayType()) to intType()),
                NEG to (match(intType()) to intType()),
                NOT to (match(boolType()) to boolType())
        )

        fun read(op: String): UnaryOperator =
                keyValueMap[op] ?: throw UnknownUnaryOpException(op)
    }

    override fun toString(): String = op
}