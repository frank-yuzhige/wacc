package ast

import utils.Parameter
import utils.Statements
import utils.prettyPrint

data class Function(
        val returnType: Type,
        val name: String,
        val args: List<Parameter>,
        val body: Statements
) : WaccAST() {
    override fun prettyPrint(): String =
            "${showHeader()} is\n" +
                    "${body.prettyPrint().prependIndent()}\n" +
                    "end\n"

    override fun tellIdentity(): String = "a function"

    fun showHeader(): String = "$returnType $name(${args.joinToString(", ") { it.prettyPrint() }})"

    override fun getTraceLog(): String = "In a function defined at ${startIndex}: ${showHeader()}"
}