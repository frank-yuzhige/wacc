package ast

import ast.Type.BaseTypeKind.*

sealed class Type {

    enum class BaseTypeKind(val symbol: String) {
        INT("int"),
        BOOL("bool"),
        CHAR("char"),
        STRING("string"),
        ANY("?")
    }

    companion object {
        fun pairBaseType(): PairType =
                PairType(BaseType(ANY), BaseType(ANY))
    }

    data class BaseType(val kind: BaseTypeKind) : Type() {
        override fun toString(): String = kind.symbol
    }

    data class ArrayType(val type: Type) : Type() {
        override fun toString(): String = "$type[]"
    }
    data class PairType(val firstElemType: Type, val secondElemType: Type) : Type() {
        override fun toString(): String =
        if (firstElemType != BaseType(ANY) || secondElemType != BaseType(ANY)) {
            "pair($firstElemType, $secondElemType)"
        } else {
            "pair"
        }
    }
    data class FuncType(val retType: Type, val paramTypes: List<Type>): Type() {
        override fun toString(): String =
                "(${paramTypes.joinToString(", ") { it.toString() }}) -> $retType"
    }
}

