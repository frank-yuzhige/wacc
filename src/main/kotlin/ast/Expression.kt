package ast

import ast.Type.*
import ast.Type.BaseType.*

sealed class Expression : WaccAST {
    enum class PairElemFunction(val value : String) {
        FST("fst"), SND("snd")
    }

    object NullLit : Expression()
    data class IntLit(val x : Int) : Expression()
    data class BoolLit(val b : Boolean) : Expression()
    data class CharLit(val c : Char) : Expression()
    data class StringLit(val string : String) : Expression()
    data class Identifier(val ident : String) : Expression()
    data class BinExpr(val left : Expression, val op : BinaryOperator, val right : Expression) : Expression()
    data class UnaryExpr(val op : UnaryOperator, val expr : Expression) : Expression()

    data class ArrayElem(val arrayName : String, val indices : List<Expression>) : Expression()
    data class PairElem(val func : PairElemFunction, val expr: Expression) : Expression()
    data class ArrayLiteral(val elements : List<Expression>) : Expression()
    data class NewPair(val first : Expression, val second : Expression) : Expression()
    data class FunctionCall(val ident: String, val args : List<Expression>) : Expression()



    fun getType() : Type  = when (this) {
        is IntLit -> IntType
        is BoolLit -> BoolType
        is CharLit -> CharType
        is StringLit -> StringType
        else -> IntType
    }
}