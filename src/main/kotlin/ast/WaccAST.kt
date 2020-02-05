package ast

import utils.Index

abstract class WaccAST {
    var startIndex: Index = -1 to -1
    var endIndex: Index = -1 to -1

    abstract fun prettyPrint(): String
    abstract fun tellIdentity(): String
    open fun getTraceLog(): String {
        val lines = prettyPrint().split("\n")
        val abbrev = when {
            lines.size > 3 -> ('\n' + lines[0] + '\n' +  lines[1] + "\n    ...\n" + lines.last()).prependIndent()
            lines.size >= 2 -> "\n${prettyPrint()}".prependIndent()
            else -> prettyPrint()
        }
        return "In ${tellIdentity()} at ${startIndex}: $abbrev"
    }
}

