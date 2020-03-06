package ast

import ast.Type.FuncType
import ast.Type.NewType
import utils.Parameter
import utils.prettyPrint

sealed class NewTypeDef: WaccAST() {
    class StructTypeDef private constructor(val type: NewType, val members: List<Parameter>): NewTypeDef() {
        constructor(typeName: String, generics: List<String>, members: List<Parameter>):
                this(NewType(typeName, generics.map { Type.TypeVar(it) }), members)

        override fun prettyPrint(): String = "newtype $type is\n" +
                members.joinToString(";\n") { it.prettyPrint() }.prependIndent() +
                ";\nend"
        override fun tellIdentity(): String = "a newtype definition"

        fun name(): String = type.toString()

        fun constructorFuncType(): FuncType {
            return FuncType(type, members.map { it.first })
        }
    }

    class UnionTypeDef private constructor(val type: NewType, val memberMap: Map<String, List<Parameter>>): NewTypeDef() {
        constructor(typeName: String, members: Map<String, List<Parameter>> = emptyMap()): this(NewType(typeName), members)
        constructor(typeName: String, generics: List<String>, members: Map<String, List<Parameter>> = emptyMap()):
                this(NewType(typeName, generics.map { Type.TypeVar(it) }), members)

        override fun prettyPrint(): String = "newtype $type is union\n" +
                memberMap.entries.joinToString(";\n") { (constructor, params) ->
                    if (params.isEmpty()) {
                        constructor
                    } else {
                        "$constructor of (${params.joinToString(", ") { it.prettyPrint() }})"
                    }
                }.prependIndent() +
                ";\nend"

        override fun tellIdentity(): String = "a newtype definition"

    }
}

