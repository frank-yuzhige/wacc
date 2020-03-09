package ast

import ast.Type.Companion.boolType
import ast.Type.Companion.intType
import ast.Type.FuncType
import ast.Type.TypeVar
import exceptions.SyntacticException.UnknownBinaryOpException

enum class BinaryOperator(val op: String, val retType: Type) {

    MUL("*", intType()),
    DIV("/", intType()),
    MOD("%", intType()),
    ADD("+", intType()),
    SUB("-", intType()),
    GTE(">=", boolType()),
    LTE("<=", boolType()),
    GT(">", boolType()),
    LT("<", boolType()),
    EQ("==", boolType()),
    NEQ("!=", boolType()),
    AND("&&", boolType()),
    OR("||", boolType());

    companion object {
        private val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun read(op: String): BinaryOperator =
                keyValueMap[op] ?: throw UnknownBinaryOpException(op)

        val funcTypeMap = mapOf(
                MUL to FuncType.binOpOf(TypeVar("A", Trait("Num"))),
                DIV to FuncType.binOpOf(TypeVar("A", Trait("Num"))),
                MOD to FuncType.binOpOf(TypeVar("A", Trait("Num"))),
                ADD to FuncType.binOpOf(TypeVar("A", Trait("Num"))),
                SUB to FuncType.binOpOf(TypeVar("A", Trait("Num"))),
                GTE to FuncType.binCheckOf(TypeVar("A", Trait("Ord"))),
                GT to FuncType.binCheckOf(TypeVar("A", Trait("Ord"))),
                LTE to FuncType.binCheckOf(TypeVar("A", Trait("Ord"))),
                LT to FuncType.binCheckOf(TypeVar("A", Trait("Ord"))),
                EQ to FuncType.binCheckOf(TypeVar("A", Trait("Eq"))),
                NEQ to FuncType.binCheckOf(TypeVar("A", Trait("Eq"))),
                AND to FuncType.binOpOf(boolType()),
                OR to FuncType.binOpOf(boolType())
        )
    }
}