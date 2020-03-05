package ast

import ast.Type.FuncType
import utils.Parameter
import utils.prettyPrint

class FunctionHeader(val returnType: Type,
                     val name: String,
                     val args: List<Parameter>,
                     val typeConstraints: List<TypeConstraint>) {
    fun showHeader(): String =
            "$returnType $name(${args.joinToString(", ") { it.prettyPrint() }}) ${typeConstraints.printInFunction()}"
}