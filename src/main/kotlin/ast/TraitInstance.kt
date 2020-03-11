package ast

class TraitInstance(
        val targetType: Type,
        val trait: Trait,
        val typeConstraints: List<TypeConstraint>,
        val functions: List<Function>
): WaccAST() {
    override fun prettyPrint(): String {
        return "instance $targetType: $trait where ${typeConstraints.printInFunction()} is\n" +
                functions.joinToString("\n") { it.prettyPrint() } + "\nend"
    }

    override fun tellIdentity(): String {
        return "a trait implementation"
    }

}
