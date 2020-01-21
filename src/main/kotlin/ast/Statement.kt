package ast

import ast.Expression.Identifier

typealias Statements = List<Statement>

sealed class Statement {
    object Skip : Statement()
    data class Read(val variable: Identifier) : Statement()
    data class BuiltinFunc(val expr: Expression) : Statement()
    data class CondBranch(val expr: Expression, val trueBranch: Statements, val falseBranch: Statements) : Statement()
//    data class WhileLoop(val expr: Expression, val body: List)
}