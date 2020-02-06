package ast

import ast.BinaryOperator.BinOpType.Companion.binOpOf
import ast.BinaryOperator.BinOpType.Companion.compareOf
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import exceptions.SyntacticException.UnknownBinaryOpException
import semantics.TypeChecker
import semantics.TypeChecker.Companion.match

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

    data class BinOpType(val lhsChecker: TypeChecker, val retType: Type, val rhsChecker: TypeChecker) {
        companion object {
            fun binOpOf(type: Type): BinOpType = BinOpType(match(type), type, match(type))
            fun compareOf(type: Type): BinOpType = BinOpType(match(type), boolType(), match(type))
        }
    }

    companion object {
        private val keyValueMap = values().map { it.op }.zip(values()).toMap()
        fun read(op: String): BinaryOperator =
                keyValueMap[op] ?: throw UnknownBinaryOpException(op)

        val typeMap = mapOf(
                MUL to listOf(binOpOf(intType())),
                DIV to listOf(binOpOf(intType())),
                MOD to listOf(binOpOf(intType())),
                ADD to listOf(binOpOf(intType())),
                SUB to listOf(binOpOf(intType())),
                GTE to listOf(compareOf(intType()), compareOf(charType())),
                LTE to listOf(compareOf(intType()), compareOf(charType())),
                GT to listOf(compareOf(intType()), compareOf(charType())),
                LT to listOf(compareOf(intType()), compareOf(charType())),
                /** EQ and NEQ will not be queried, see SemanticAnalyzer **/
                AND to listOf(binOpOf(boolType())),
                OR to listOf(binOpOf(boolType()))
        )
    }

    private fun binOpOf(expecting: Type): Pair<Type, List<Pair<Type, Type>>> {
        return expecting to listOf(expecting to expecting)
    }

    private fun comparisonOf(vararg expecting: Type): Pair<Type, List<Pair<Type, Type>>> {
        return boolType() to expecting.map { it to it }
    }


}