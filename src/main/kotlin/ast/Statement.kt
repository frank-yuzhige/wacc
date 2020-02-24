package ast

import ast.Expression.Identifier
import utils.Statements
import utils.prettyPrint

sealed class Statement : WaccAST() {

    override fun tellIdentity(): String = "an statement"

    enum class BuiltinFunc(val functionName: String) {
        FREE("free"),
        RETURN("return"),
        EXIT("exit"),
        PRINT("print"),
        PRINTLN("println")
    }

    object Skip : Statement() {
        override fun prettyPrint(): String = "skip"
    }

    data class Declaration(val type: Type, val variable: Identifier, val rhs: Expression) : Statement() {
        override fun prettyPrint(): String
                = "${if(type == Type.anyType()) "var" else "$type" } ${variable.name} = ${rhs.prettyPrint()}"
        override fun tellIdentity(): String = "a declaration statement"
    }

    data class Assignment(val lhs: Expression, val rhs: Expression) : Statement() {
        override fun prettyPrint(): String = "${lhs.prettyPrint()} = ${rhs.prettyPrint()}"
        override fun tellIdentity(): String = "an assignment"
    }

    data class Read(val target: Expression) : Statement() {
        override fun prettyPrint(): String = "read ${target.prettyPrint()}"
    }

    data class BuiltinFuncCall(val func: BuiltinFunc, val expr: Expression) : Statement() {
        override fun prettyPrint(): String = "${func.functionName} ${expr.prettyPrint()}"
    }

    data class CondBranch(val expr: Expression, val trueBranch: Statements, val falseBranch: Statements) : Statement() {
        override fun tellIdentity(): String = "an if-then-else statement"
        override fun prettyPrint(): String {
            return "if ${expr.prettyPrint()} then\n" +
                    "${trueBranch.prettyPrint().prependIndent()}\n" +
                    "else\n" +
                    "${falseBranch.prettyPrint().prependIndent()}\n" +
                    "fi"
        }
    }

    data class WhileLoop(val expr: Expression, val body: Statements) : Statement() {
        override fun tellIdentity(): String = "a while loop"
        override fun prettyPrint(): String {
            return "while ${expr.prettyPrint()} do\n" +
                    "${body.prettyPrint().prependIndent()}\n" +
                    "done"
        }
    }

    data class Block(val body: Statements) : Statement() {
        override fun tellIdentity(): String = "a code block"
        override fun prettyPrint(): String {
            return "begin\n" +
                    "${body.prettyPrint().prependIndent()}\n" +
                    "end"
        }
    }
}

