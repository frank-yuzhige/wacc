package utils

import ast.Statement
import ast.Type
import ast.WaccAST
import java.util.*

typealias Index = Pair<Int, Int>
typealias Parameter = Pair<String, Type>
typealias Statements = List<Statement>

fun Statements.prettyPrint(): String = this.joinToString(" ;\n") { it.prettyPrint() }
fun Parameter.getVar() = this.first
fun Parameter.getType() = this.second