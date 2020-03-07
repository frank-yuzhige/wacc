package ast

import ast.Type.TypeVar

data class TypeConstraint(val trait: Trait, val typeVar: String) {
    override fun toString(): String = "$typeVar: $trait"
}

fun List<TypeConstraint>.printInFunction(): String {
    return if(isNotEmpty()) "where ${joinToString(", ")}" else ""
}