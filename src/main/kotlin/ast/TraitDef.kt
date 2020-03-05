package ast

import ast.Type.TypeVar

class TraitDef(val traitName: String,
               val typeConstraints: List<TypeConstraint>,
               val traitVar: TypeVar,
               val requiredFuncs: List<FunctionHeader>,
               val defaultFuncs: List<Function>): WaccAST() {
    override fun prettyPrint(): String {
        val constraints = typeConstraints.printInFunction()
        return "trait $traitVar $constraints is\n" +
                requiredFuncs.joinToString(" required\n") { it.showHeader() } + "\n" +
                defaultFuncs.joinToString("\n") { it.prettyPrint() } + "\nend"
    }

    override fun tellIdentity(): String = "a trait definition"

}