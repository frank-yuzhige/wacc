package ast

import utils.AstIndexMap

interface WaccAST {
    fun prettyPrint(): String
    fun tellIdentity(): String
    fun getTraceLog(astIndexMap: AstIndexMap): String {
        val lines = prettyPrint().split("\n")
        val abbrev = when {
            lines.size > 3 -> '\n' + lines[0] + '\n' +  lines[1] + "\n    ...\n" + lines.last()
            lines.size >= 2 -> "\n${prettyPrint()}"
            else -> prettyPrint()
        }
        return "In ${tellIdentity()} at ${astIndexMap[this]}: $abbrev"
    }
}

