package ast

import utils.AstIndexMap

interface WaccAST {
    fun prettyPrint(): String
    fun tellIdentity(): String
    fun getTraceLog(astIndexMap: AstIndexMap): String {
        return "In ${tellIdentity()} at ${astIndexMap[this]}: ${prettyPrint()}"
    }
}

