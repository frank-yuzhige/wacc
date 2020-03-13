package semantics

import ast.Expression.Identifier
import ast.Type
import utils.Index


fun typeMismatchError(expected: Type, actual: Type) =
        "Couldn't match expected type '$expected' with actual type '$actual'"

fun accessToUndefinedVar(ident: String): String = "Attempt to access an undefined variable '$ident'"
fun accessToUndefinedFunc(ident: String): String = "Attempt to access an undefined function '$ident'"

fun variableAlreadyDefined(variable: Identifier, type: Type, index: Index): String =
        "Variable '${variable.name}' with type '$type' has already been defined at $index"

fun patternUnmatchedError(expectedCount: Int, actualCount: Int): String =
        "Pattern unmatched! Expected $expectedCount members, yet $actualCount members are found"