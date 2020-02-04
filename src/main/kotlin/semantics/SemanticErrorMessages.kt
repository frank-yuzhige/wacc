package semantics

import ast.Expression
import ast.Expression.Identifier
import ast.Type
import ast.Type.*
import utils.Index

fun insufficientArrayRankError(type: Type, rank: Int): String = when(type) {
    is ArrayType -> "Array-type '$type' does not have $rank ranks"
    else -> "Expecting an array, yet '$type' is not an array"
}

fun accessToUndefinedVar(ident: String): String = "Attempt to access an undefined variable '$ident'"
fun accessToUndefinedFunc(ident: String): String = "Attempt to access an undefined function '$ident'"
fun accessToNullLiteral(pairFunc: String): String = "Cannot access the $pairFunc element of a null-literal"
fun parameterNumMismatch(ident: String, funcType: Type, expectedCount: Int, actualCount: Int): String =
        "A call to function $ident : $funcType needs $expectedCount parameters, but $actualCount parameters are given"
fun variableAlreadyDefined(variable: Identifier, type: Type, index: Index): String =
        "Variable \"${variable.ident}\" with type $type has already been defined at $index"