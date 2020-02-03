package ast

typealias Statements = List<Statement>

fun Statements.prettyPrint(): String = this.joinToString(" ;\n") { it.prettyPrint() }