package utils

import ast.Expression.Identifier
import ast.Statement
import ast.Trait
import ast.Type
import ast.Type.TypeVar

typealias Index = Pair<Int, Int>
typealias Parameter = Pair<Type, Identifier>
typealias Statements = List<Statement>
typealias VarWithSID = Pair<String, Int>

fun Statements.prettyPrint(): String = this.joinToString(";\n") { it.prettyPrint() } + ";"
fun Parameter.prettyPrint(): String = "${getType()} ${getIdent().prettyPrint()}"

fun Parameter.getType(): Type = first
fun Parameter.getIdent(): Identifier = second