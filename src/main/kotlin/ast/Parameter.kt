package ast

typealias Parameter = Pair<String, Type>

fun Parameter.getVar() = this.first
fun Parameter.getType() = this.second