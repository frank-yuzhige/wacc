package ast

import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type.BaseTypeKind.*

sealed class Type {

    enum class BaseTypeKind(val symbol: String) {
        INT("int"),
        BOOL("bool"),
        CHAR("char"),
        STRING("string"),
        ANY("?"),
        ANYOUT("_")
    }

    companion object {
        fun anyoutArrayType(): ArrayType = ArrayType(BaseType(ANYOUT))
        fun anyArrayType(): ArrayType = ArrayType(BaseType(ANY))
        fun nullType(): PairType = PairType(BaseType(ANYOUT), BaseType(ANYOUT))
        fun anyPairType(): PairType =
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
    
    fun unwrapArrayType(count: Int): Type? {
        var t: Type? = this
        for (i in 0 until count) {
            t = t?.unwrapArrayType()
            if(t == null) {
                return null
            }
        }
        return t
    }

    fun unwrapPairType(elem: PairElemFunction): Type? = when(this) {
        is PairType -> when (elem) {
            FST -> this.firstElemType
            SND -> this.secondElemType
        }
        else -> null
    }

}

