package ast

import ast.Type.FuncType
import utils.Parameter
import utils.prettyPrint

data class FunctionHeader(val returnType: Type,
                         val name: String,
                         val args: List<Parameter>,
                         val typeConstraints: List<TypeConstraint>): WaccAST() {
    fun showHeader(): String =
            "$returnType $name(${args.joinToString(", ") { it.prettyPrint() }}) ${typeConstraints.printInFunction()}"

    fun getFuncType(): FuncType {
        return FuncType(returnType, args.map { it.first })
    }

    fun substitutes(sub: Map<Pair<String, Boolean>, Type>): FunctionHeader {
        return FunctionHeader(
                returnType.substitutes(sub),
                name,
                args.map { (t, v) -> t.substitutes(sub) to v },
                typeConstraints
        )
    }

    override fun prettyPrint(): String {
        return showHeader()
    }

    override fun tellIdentity(): String {
        return "a function declaration"
    }
}