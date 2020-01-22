package ast

import ast.Type.*
import ast.Type.BaseType.*

sealed class Expression : WaccAST {
    enum class PairElemFunction {
        FST, SND
    }

    data class IntLit(val x : Int) : Expression()
    data class BoolLit(val b : Boolean) : Expression()
    data class CharLit(val c : Char) : Expression()
    data class StringLit(val string : String) : Expression()
    data class Identifier(val ident : String) : Expression()
    data class BinOp(val left : Expression, val op : BinaryOperator, val right : Expression) : Expression()
    data class UnaryOp(val op : UnaryOperator, val expr : Expression) : Expression()

    data class ArrayElem(val arrayName : String, val indices : List<Expression>)
    data class PairElem(val func : PairElemFunction, val expr: Expression)
    data class ArrayLiteral(val elements : List<Expression>)
    data class NewPair(val first : Expression, val second : Expression)
    data class FunctionCall(val ident: String, val args : List<Expression>)



    fun getType() : Type  = when (this) {
        is IntLit -> IntType
        is BoolLit -> BoolType
        is CharLit -> CharType
        is StringLit -> StringType
        else -> IntType
    }
}