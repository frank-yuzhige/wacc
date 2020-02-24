package ast

import utils.Parameter
import utils.prettyPrint

class NewTypeDef(val typeName: String, val members: List<Parameter>): WaccAST() {
    override fun prettyPrint(): String = "newtype $typeName is\n" +
            members.joinToString(";\n") { it.prettyPrint() }.prependIndent() +
            "\nend"
    override fun tellIdentity(): String = "a newtype definition"
}