package utils

import ast.Expression.Identifier
import ast.Statement
import ast.Type

typealias Index = Pair<Int, Int>
typealias Parameter = Pair<Type, Identifier>
typealias Statements = List<Statement>

fun Statements.prettyPrint(): String = this.joinToString(" ;\n") { it.prettyPrint() }
fun Parameter.prettyPrint(): String = "${getType()} ${getIdent().prettyPrint()}"

fun Parameter.getType(): Type = first
fun Parameter.getIdent(): Identifier = second