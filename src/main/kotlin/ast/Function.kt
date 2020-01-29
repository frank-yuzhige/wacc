package ast

import utils.Parameter

data class Function (
        val returnType : Type,
        val name : String,
        val args : List<Parameter>,
        val body : Statements
) : WaccAST {
    override fun prettyPrint(): String =
            "${showHeader()} is\n" +
            "${body.prettyPrint().prependIndent()}\n" +
            "end\n"

    private fun showHeader(): String {
        return "$returnType $name (${args.joinToString(",") { "${it.second} ${it.first}"}})"
    }
}