package ast

import ast.Type.TypeVar

class TypeConstraint(val trait: Trait, val typeVar: TypeVar) {
    fun prettyPrint(): String = "$typeVar: $trait"
}

fun List<TypeConstraint>.printInFunction(): String {
    return if(isNotEmpty()) "where ${joinToString(", ") { it.prettyPrint() }}" else ""
}