package ast

import ast.Expression.*
import ast.Type.BaseTypeKind.ANY
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

    data class Declaration(val isConst: Boolean, val type: Type, val variable: Identifier, val rhs: Expression) : Statement() {
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

    data class CondBranch(val condStatsList: List<Pair<Expression, Statements>>, val elseBody: Statements) : Statement() {
        override fun tellIdentity(): String = "an if-statement"
        override fun prettyPrint(): String {
            return condStatsList.joinToString { (expr, stmt) ->
                "if ${expr.prettyPrint()} then\n" +
                        "${stmt.prettyPrint().prependIndent()}\n" +
                        "else"
            } + "\n" + elseBody.prettyPrint().prependIndent() + "\nfi"
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

    data class ForLoop(val defType: Type?, val loopVar: Identifier, val from: Expression, val to: Expression, val body: Statements): Statement() {
        override fun tellIdentity(): String = "a for loop"
        override fun prettyPrint(): String {
            val def= defType?.let { if (defType == Type.BaseType(ANY)) "var " else "$defType " }?:""
            return "for ${def}${loopVar.prettyPrint()} in ${from.prettyPrint()}..${to.prettyPrint()} do\n" +
                    "${body.prettyPrint().prependIndent()}\n" +
                    "done"
        }
    }

    data class WhenClause(val expr: Expression, val whenCases: List<Pair<Pattern, Statements>>): Statement() {
        override fun tellIdentity(): String {
            return "a when-clause"
        }

        override fun prettyPrint(): String {
            return "when ${expr.prettyPrint()}:\n" +
                    whenCases.joinToString("\n") { (pm, stmts) ->
                        "${pm.prettyPrint()} -> ${stmts.prettyPrint()}"
                    }.prependIndent() +
                    "\nend"
        }

    }



    data class VoidFuncCall(val function: FunctionCall): Statement() {
        override fun tellIdentity(): String {
            return "a no-return function call"
        }

        override fun prettyPrint(): String {
            return "call ${function.prettyPrint()}"
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

