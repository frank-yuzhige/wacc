package ast

import ast.Expression.Identifier

sealed class Statement {
    enum class BuiltinFunc(val functionName: String) {
        FREE("free"),
        RETURN("return"),
        EXIT("exit"),
        PRINT("print"),
        PRINTLN("println")
    }

    object Skip : Statement()
    data class Declaration(val type : Type, val variable: Identifier, val rhs : Expression) : Statement()
    data class Assignment(val lhs: Expression, val rhs : Expression) : Statement()
    data class Read(val variable: Identifier) : Statement()
    data class BuiltinFuncCall(val func : BuiltinFunc, val expr: Expression) : Statement()
    data class CondBranch(val expr: Expression, val trueBranch: Statements, val falseBranch: Statements) : Statement()
    data class WhileLoop(val expr: Expression, val body: Statements) : Statement()
    data class Block(val body: Statements) : Statement()
}

typealias Statements = List<Statement>
