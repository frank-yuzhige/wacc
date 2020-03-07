package ast

import ast.Type.FuncType
import utils.Parameter
import utils.prettyPrint

class FunctionHeader(val returnType: Type,
                     val name: String,
                     val args: List<Parameter>,
                     val typeConstraints: List<TypeConstraint>): WaccAST() {
    fun showHeader(): String =
            "$returnType $name(${args.joinToString(", ") { it.prettyPrint() }}) ${typeConstraints.printInFunction()}"

    fun getFuncType(): FuncType {
        return FuncType(returnType, args.map { it.first })
    }

    override fun prettyPrint(): String {
        return showHeader()
    }

    override fun tellIdentity(): String {
        return "a function declaration"
    }
}