package ast

sealed class Type {
    override fun toString(): String = when (this) {
        is BaseType.IntType -> "int"
        is BaseType.CharType -> "char"
        is BaseType.StringType -> "string"
        is BaseType.BoolType -> "bool"
        is BaseType.PairBaseType -> "pair"
        is ArrayType -> "$type[]"
        is PairType -> "pair($firstElemType, $secondElemType)"
    }

    sealed class BaseType : Type() {
        object IntType : BaseType()
        object CharType : BaseType()
        object StringType : BaseType()
        object BoolType : BaseType()
        object PairBaseType : BaseType()
    }

    data class ArrayType(val type: Type) : Type()
    data class PairType(val firstElemType: BaseType, val secondElemType: BaseType) : Type()
}