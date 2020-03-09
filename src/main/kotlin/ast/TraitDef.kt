package ast

class TraitDef(val traitName: String,
               val typeConstraints: List<TypeConstraint>,
               val traitVar: String,
               val requiredFuncs: List<FunctionHeader>): WaccAST() {
    override fun prettyPrint(): String {
        val constraints = typeConstraints.printInFunction()
        return "trait $traitVar: $traitName $constraints is\n" +
                requiredFuncs.joinToString("\n") { it.showHeader() + " is required" }.prependIndent() + "\n" +
                "\nend"
    }

    override fun tellIdentity(): String = "a trait definition"

}