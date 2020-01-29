package ast

import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import exceptions.SemanticException
import exceptions.SemanticException.OperatorNotSupportTypeException
import exceptions.SemanticException.TypeMismatchException
import exceptions.SyntacticException.UnknownBinaryOpException
import sun.tools.jstat.Operator

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
    }

    fun getPriority(): Int = when (this) {
        MUL, DIV, MOD -> 1
        ADD, SUB -> 2
        GTE, GT, LTE, LT -> 3
        EQ, NEQ -> 4
        AND, OR -> 5
    }

    fun getOperandTypes(expecting: Type): List<Pair<Type, Type>> {
        val typeMap = hashMapOf(
                MUL to hashMapOf(
                        binOpOf(intType())
                ),
                DIV to hashMapOf(
                        binOpOf(intType())
                ),
                MOD to hashMapOf(
                        binOpOf(intType())
                ),
                ADD to hashMapOf(
                        binOpOf(intType())
                ),
                SUB to hashMapOf(
                        binOpOf(intType())
                ),
                GTE to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                GT to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                LTE to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                LT to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                EQ to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                NEQ to hashMapOf(
                        comparisonOf(intType(), boolType(), charType())
                ),
                AND to hashMapOf(
                        binOpOf(boolType())
                ),
                OR to hashMapOf(
                        binOpOf(boolType())
                )
        )
        return typeMap[this]?.get(expecting)?: throw OperatorNotSupportTypeException(expecting, this.op)
    }

    private fun binOpOf(expecting: Type): Pair<Type, List<Pair<Type, Type>>> {
        return expecting to listOf(expecting to expecting)
    }

    private fun comparisonOf(vararg expecting: Type): Pair<Type, List<Pair<Type, Type>>> {
        return boolType() to expecting.map { it to it }
    }


}