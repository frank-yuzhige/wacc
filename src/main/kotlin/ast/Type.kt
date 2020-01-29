package ast

import ast.Expression.*
import ast.Type.BaseTypeKind.*
import com.sun.org.apache.bcel.internal.generic.BALOAD
import com.sun.org.apache.xpath.internal.operations.Bool
import kotlin.math.exp

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
        fun intType(): BaseType = BaseType(INT)
        fun boolType(): BaseType = BaseType(BOOL)
        fun charType(): BaseType = BaseType(CHAR)
        fun stringType(): BaseType = BaseType(STRING)
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

    fun unwrapArrayType(): Type? = when (this) {
        is ArrayType -> type
        else -> null
    }

}

