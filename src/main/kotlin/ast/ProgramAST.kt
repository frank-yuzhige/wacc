package ast

import utils.Statements
import utils.prettyPrint

data class ProgramAST (val functions: List<Function>, val mainProgram : Statements) : WaccAST() {
    override fun prettyPrint(): String {
        return "begin\n" +
                functions.joinToString("\n") { it.prettyPrint().prependIndent() } +
                (if (functions.isNotEmpty()) "\n" else "") +
                "${mainProgram.prettyPrint().prependIndent()}\n" +
                "end"
    }

    override fun tellIdentity(): String = "a program"
}