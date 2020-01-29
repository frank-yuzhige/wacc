package semantics

import ast.Expression
import ast.Type

infix fun Type.check(actual: Type): Boolean {
    if(this is Type.BaseType && this.kind == Type.BaseTypeKind.ANY) {
        return true
    }
    return when(this) {
        is Type.BaseType -> this.kind == Type.BaseTypeKind.ANY || this == actual
        is Type.ArrayType -> when (actual) {
            is Type.ArrayType -> this.type check actual.type
            else -> false
        }
        is Type.PairType -> when (actual) {
            is Type.PairType -> this.firstElemType check actual.firstElemType
                    && this.secondElemType check actual.secondElemType
            else -> false
        }
        is Type.FuncType -> when (actual) {
            is Type.FuncType -> this.retType check actual.retType
                    && this.paramTypes.size == actual.paramTypes.size
                    && this.paramTypes
                    .zip(actual.paramTypes) { a, b -> a check b}
                    .reduce {a, b -> a && b}
            else -> false
        }
    }
}

