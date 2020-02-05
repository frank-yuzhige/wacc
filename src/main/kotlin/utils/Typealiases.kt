package utils

import ast.Expression
import ast.Expression.*
import ast.Statement
import ast.Type
import ast.WaccAST
import java.util.*

typealias Index = Pair<Int, Int>
typealias Parameter = Pair<Type, Identifier>
typealias Statements = List<Statement>

fun Statements.prettyPrint(): String = this.joinToString(" ;\n") { it.prettyPrint() }
fun Parameter.prettyPrint(): String = "$first ${second.prettyPrint()}"