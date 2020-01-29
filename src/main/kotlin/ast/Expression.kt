package ast

import ast.BaseTypeKind.*
import ast.Type.*
import utils.EscapeCharMap.Companion.fromEscape

sealed class Expression() : WaccAST {

    enum class PairElemFunction(val value : String) {
        FST("fst"), SND("snd")

    }
    class NullLit: Expression() {
        override fun prettyPrint(): String = "null"

        override fun equals(other: Any?): Boolean = this === other

        override fun hashCode(): Int = System.identityHashCode(this)
    }

    data class IntLit(val x : Int) : Expression() {
        override fun prettyPrint(): String = x.toString()
    }

    data class BoolLit(val b : Boolean) : Expression() {
        override fun prettyPrint(): String = b.toString()
    }

    data class CharLit(val c : Char) : Expression() {
        override fun prettyPrint(): String = "'${fromEscape(c)}'"
    }

    data class StringLit(val string : String) : Expression() {
        override fun prettyPrint(): String = "\"${fromEscape(string)}\""
    }

    data class Identifier(val ident : String) : Expression() {
        override fun prettyPrint(): String = ident
    }

    data class BinExpr(val left : Expression, val op : BinaryOperator, val right : Expression) : Expression() {
        override fun prettyPrint(): String = "${left.prettyPrint()} ${op.op} ${right.prettyPrint()}"
    }

    data class UnaryExpr(val op : UnaryOperator, val expr : Expression) : Expression() {
        override fun prettyPrint(): String = "${op.op} ${expr.prettyPrint()}"
    }

    data class ArrayElem(val arrayName : String, val indices : List<Expression>) : Expression() {
        override fun prettyPrint(): String = "$arrayName${indices.joinToString{ "[${it.prettyPrint()}]" }}"
    }

    data class PairElem(val func : PairElemFunction, val expr: Expression) : Expression() {
        override fun prettyPrint(): String = "${func.value} ${expr.prettyPrint()}"
    }

    data class ArrayLiteral(val elements : List<Expression>) : Expression() {
        override fun prettyPrint(): String = "[${elements.joinToString(", ") { it.prettyPrint() }}]"
    }

    data class NewPair(val first : Expression, val second : Expression) : Expression() {
        override fun prettyPrint(): String = "newpair(${first.prettyPrint()}, ${second.prettyPrint()})"
    }

    data class FunctionCall(val ident: String, val args : List<Expression>) : Expression() {
        override fun prettyPrint(): String = "call $ident(${args.joinToString(", ") { it.prettyPrint() }})"
    }

    fun getType() : Type  = when (this) {
        is IntLit -> BaseType(INT)
        is BoolLit -> BaseType(CHAR)
        is CharLit -> BaseType(CHAR)
        is StringLit -> BaseType(STRING)
        else -> TODO()
    }
}