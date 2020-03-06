package ast

class TraitDef(val traitName: String,
               val typeConstraints: List<TypeConstraint>,
               val traitVar: String,
               val requiredFuncs: List<FunctionHeader>,
               val defaultFuncs: List<Function>): WaccAST() {
    override fun prettyPrint(): String {
        val constraints = typeConstraints.printInFunction()
        return "trait $traitVar: $traitName $constraints is\n" +
                requiredFuncs.joinToString("\n") { it.showHeader() + " is required" }.prependIndent() + "\n" +
                defaultFuncs.joinToString("\n") { it.prettyPrint() }.prependIndent() + "\nend"
    }

    override fun tellIdentity(): String = "a trait definition"

}