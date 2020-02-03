package semantics

import ast.Type
import javax.lang.model.type.ArrayType

fun insufficientArrayRankError(type: Type, rank: Int): String = when(type) {
    is ArrayType -> "$type does not have more than $rank rank"
    else -> "$type is not an array"
}

fun accessToUndefinedVar(ident: String): String = "Attempt to access an undefined variable '$ident'!"
fun accessToUndefinedFunc(ident: String): String = "Attempt to access an undefined function '$ident'!"