package ast

import ast.Type.FuncType
import ast.Type.NewType
import utils.Parameter
import utils.prettyPrint

class NewTypeDef private constructor(val type: NewType, val members: List<Parameter>): WaccAST() {
    constructor(typeName: String, members: List<Parameter>): this(NewType(typeName), members)

    override fun prettyPrint(): String = "newtype $type is\n" +
            members.joinToString(";\n") { it.prettyPrint() }.prependIndent() +
            "\nend"
    override fun tellIdentity(): String = "a newtype definition"

    fun name(): String = type.toString()

    fun constructorFuncType(): FuncType {
        return FuncType(type, members.map { it.first })
    }
}