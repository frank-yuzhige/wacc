package ast

import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type.*
import ast.Type.BaseTypeKind.*
import ast.Type.Companion.intType
import ast.Type.Companion.anyPairType
import ast.Type.Companion.nullType
import exceptions.SemanticException.*
import utils.EscapeCharMap.Companion.fromEscape
import utils.SymbolTable

sealed class Expression(var inParens: Boolean = false) : WaccAST {

    override fun tellIdentity(): String = "an expression"

    enum class PairElemFunction(val value : String) {
        FST("fst"), SND("snd")

    }

    object NullLit : Expression() {
        override fun prettyPrint(): String = "null"
    }

    data class IntLit(val x : Int) : Expression() {
        override fun prettyPrint(): String = x.toString()
        override fun tellIdentity(): String = "an int literal"
    }

    data class BoolLit(val b : Boolean) : Expression() {
        override fun prettyPrint(): String = b.toString()
        override fun tellIdentity(): String = "a boolean literal"
    }

    data class CharLit(val c : Char) : Expression() {
        override fun prettyPrint(): String = "'${fromEscape(c)}'"
        override fun tellIdentity(): String = "an char literal"
    }

    data class StringLit(val string : String) : Expression() {
        override fun prettyPrint(): String = "\"${fromEscape(string)}\""
        override fun tellIdentity(): String = "an string literal"
    }

    data class Identifier(val ident : String) : Expression() {
        override fun prettyPrint(): String = ident
        override fun tellIdentity(): String = "an identifier"
    }

    data class BinExpr(val left : Expression, val op : BinaryOperator, val right : Expression) : Expression() {
        override fun prettyPrint(): String {
            val content = "${left.prettyPrint()} ${op.op} ${right.prettyPrint()}"
            return if (super.inParens) {
                "($content)"
            } else {
                content
            }
        }
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
        override fun tellIdentity(): String = "an array literal"
    }

    data class NewPair(val first : Expression, val second : Expression) : Expression() {
        override fun prettyPrint(): String = "newpair(${first.prettyPrint()}, ${second.prettyPrint()})"
        override fun tellIdentity(): String = "a newpair declaration"
    }

    data class FunctionCall(val ident: String, val args : List<Expression>) : Expression() {
        override fun prettyPrint(): String = "call $ident(${args.joinToString(", ") { it.prettyPrint() }})"
        override fun tellIdentity(): String = "a function call"
    }

    fun getType(symbolTable: SymbolTable) : Type  = when (this) {
        is NullLit -> nullType()
        is IntLit -> BaseType(INT)
        is BoolLit -> BaseType(BOOL)
        is CharLit -> BaseType(CHAR)
        is StringLit -> BaseType(STRING)
        is Identifier -> symbolTable.lookupVar(ident)?.type?: throw UndefinedVarException(ident)
        is BinExpr -> op.retType
        is UnaryExpr -> op.retType
        is ArrayElem -> {
            var type = symbolTable.lookupVar(arrayName)?.type?: throw UndefinedVarException(arrayName)
            for (expr in indices) {
                val actual = expr.getType(symbolTable)
                if (actual != intType()) {
                    throw TypeMismatchException(intType(), actual)
                }
                type = type.unwrapArrayType()?: throw TypeMismatchException(type, type)
            }
            type
        }
        is PairElem -> {
            val exprType = expr.getType(symbolTable)
            when(exprType) {
                is PairType -> when(func) {
                    FST -> exprType.firstElemType
                    SND -> exprType.secondElemType
                }
                else -> throw TypeMismatchException(anyPairType(), exprType)
            }
        }
        is ArrayLiteral -> {
            if (elements.isEmpty()) {
                ArrayType(BaseType(ANY))
            } else {
                val fstType = elements[0].getType(symbolTable)
                for (expr in elements.drop(1)) {
                    val sndType = expr.getType(symbolTable)
                    if (sndType != fstType) {
                        throw TypeMismatchException(fstType, sndType)
                    }
                }
                fstType
            }
        }
        is NewPair -> {
            PairType(first.getType(symbolTable), second.getType(symbolTable))
        }
        is FunctionCall -> {
            symbolTable.lookupFunc(ident)?.type?.retType?: throw UndefinedFuncException(ident)
        }
    }
}