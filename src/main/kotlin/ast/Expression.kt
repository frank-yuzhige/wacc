package ast

import utils.EscapeCharMap.Companion.fromEscape
import utils.Grounding
import utils.VarWithSID

interface Literal
interface HeapType {
    var reference: String
}

sealed class Expression(var reifiedType: Type = Type.TypeVar("A"), // reified type, decided during semantic check. Not changed after that.
                        var groundedType: Type = Type.TypeVar("A"),// grounded type (for codegen only), to avoid re-use of expression
                        var inParens: Boolean = false) : WaccAST() {

    fun ground(grounding: Grounding): Expression {
        return this.also { groundedType = reifiedType.substitutes(grounding) }
    }

    override fun tellIdentity(): String = "an expression"
    enum class PairElemFunction(val value: String) {
        FST("fst"), SND("snd")
    }

    object NullLit : Expression(), Literal {
        override fun prettyPrint(): String = "null"
    }

    data class IntLit(val x: Int) : Expression(), Literal {
        override fun prettyPrint(): String = x.toString()
        override fun tellIdentity(): String = "an int literal"
    }

    data class BoolLit(val b: Boolean) : Expression(), Literal {
        override fun prettyPrint(): String = b.toString()
        override fun tellIdentity(): String = "a boolean literal"
    }

    data class CharLit(val c: Char) : Expression(), Literal {
        override fun prettyPrint(): String = "'${fromEscape(c)}'"
        override fun tellIdentity(): String = "an char literal"
    }

    data class StringLit(val string: String, override var reference: String = "") : Expression(), Literal, HeapType {
        override fun prettyPrint(): String = "\"${fromEscape(string)}\""
        override fun tellIdentity(): String = "an string literal"
    }

    data class Identifier(val name: String) : Expression() {
        var scopeId = -1
        override fun equals(other: Any?): Boolean = other is Identifier && other.name == name
        override fun hashCode(): Int = name.hashCode()
        override fun prettyPrint(): String = name
        override fun tellIdentity(): String = "an identifier"
        fun getVarSID(): VarWithSID = name to scopeId
    }

    data class BinExpr(val left: Expression, val op: BinaryOperator, val right: Expression) : Expression() {
        override fun prettyPrint(): String {
            val content = "${left.prettyPrint()} ${op.op} ${right.prettyPrint()}"
            return if (super.inParens) "($content)" else content
        }
    }

    data class UnaryExpr(val op: UnaryOperator, val expr: Expression) : Expression() {
        override fun prettyPrint(): String = "${op.op} ${expr.prettyPrint()}"
    }

    data class ArrayElem(val arrIdent: Identifier, val indices: List<Expression>) : Expression() {
        override fun prettyPrint(): String =
                "${arrIdent.prettyPrint()}${indices.joinToString("") { "[${it.prettyPrint()}]" }}"
    }

    data class PairElem(val func: PairElemFunction, val expr: Expression) : Expression() {
        override fun prettyPrint(): String = "${func.value} ${expr.prettyPrint()}"
    }

    data class TypeMember(val expr: Expression, val memberName: String): Expression() {
        override fun prettyPrint(): String = "${expr.prettyPrint()}.$memberName"
    }

    data class ArrayLiteral(val elements: List<Expression>, override var reference: String = "") : Expression(), Literal, HeapType {
        override fun prettyPrint(): String = "[${elements.joinToString(", ") { it.prettyPrint() }}]"
        override fun tellIdentity(): String = "an array literal"
    }

    data class NewPair(val first: Expression, val second: Expression, override var reference: String = "") : Expression(), Literal, HeapType {
        override fun prettyPrint(): String = "newpair(${first.prettyPrint()}, ${second.prettyPrint()})"
        override fun tellIdentity(): String = "a newpair declaration"
    }

    data class IfExpr(val condStatsList: List<Pair<Expression, Expression>>, val elseExpr: Expression) : Expression() {
        override fun tellIdentity(): String = "an if-expression"
        override fun prettyPrint(): String {
            return condStatsList.joinToString { (cond, expr) ->
                "if ${cond.prettyPrint()} then\n" +
                        "${expr.prettyPrint().prependIndent()}\n" +
                        "else"
            } + "\n" + elseExpr.prettyPrint().prependIndent() + "\nfi"
        }
    }

    data class FunctionCall(val ident: String, val args: List<Expression>) : Expression() {
        override fun prettyPrint(): String = "$ident(${args.joinToString(", ") { it.prettyPrint() }})"
        override fun tellIdentity(): String = "a function call"
        fun isConstructor(): Boolean = ident[0].isUpperCase()
    }
}