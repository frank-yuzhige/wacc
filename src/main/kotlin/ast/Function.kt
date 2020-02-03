package ast

import utils.AstIndexMap
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

    override fun tellIdentity(): String = "a function"

    fun showHeader(): String {
        return "$returnType $name(${args.joinToString(", ") { "${it.second} ${it.first}"}})"
    }

    override fun getTraceLog(astIndexMap: AstIndexMap): String {
        return "In a function defined at ${astIndexMap[this]}: ${showHeader()}"
    }
}