package ast

import utils.Parameter
import utils.Statements
import utils.prettyPrint

data class Function(
        val returnType: Type,
        val name: String,
        val args: List<Parameter>,
        val typeConstraints: List<TypeConstraint>,
        val body: Statements
) : WaccAST() {

    override fun prettyPrint(): String =
            "${extractHeader().showHeader()} is\n" +
                    "${body.prettyPrint().prependIndent()}\n" +
                    "end\n"

    override fun tellIdentity(): String = "a function"

    override fun getTraceLog(): String = "In a function defined at ${startIndex}: ${extractHeader().showHeader()}"

    fun extractHeader(): FunctionHeader = FunctionHeader(returnType, name, args, typeConstraints)

    fun isGenericFunc(): Boolean = typeConstraints.isNotEmpty()

    fun reifiedFunc(): Function = Function(
            returnType.reified(typeConstraints, true),
            name,
            args.map { (type, arg) -> type.reified(typeConstraints, true) to arg },
            typeConstraints,
            body
    )

    fun getFuncType(): Type.FuncType {
        return Type.FuncType(returnType, args.map { it.first })
    }
}