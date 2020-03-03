package ast

import ast.Expression.Identifier

class Pattern(val constructor: String, val matchVars: List<Identifier> = emptyList()): WaccAST() {
    override fun prettyPrint(): String {
        return if (matchVars.isEmpty()) {
            constructor
        } else {
            "$constructor(${matchVars.joinToString(", ") { it.prettyPrint() }})"
        }
    }

    override fun tellIdentity(): String {
        return "a pattern"
    }

}
