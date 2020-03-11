package semantics

import ast.Expression.Identifier
import ast.Type
import utils.Index


fun typeMismatchError(expected: Type, actual: Type) =
        "Couldn't match expected type '$expected' with actual type '$actual'"
fun typeMismatchManyError(expected: List<Type>, actual: Type) =
        "Couldn't match any of the expected types [${expected.joinToString(", ") { "'$it'" }}] " +
                "with actual type '$actual'"

fun accessToUndefinedVar(ident: String): String = "Attempt to access an undefined variable '$ident'"
fun accessToUndefinedFunc(ident: String): String = "Attempt to access an undefined function '$ident'"
fun accessToNullLiteral(pairFunc: String): String = "Cannot access the $pairFunc element of a null-literal"
fun parameterNumMismatch(ident: String, funcType: Type, expectedCount: Int, actualCount: Int): String =
        "A call to function '$ident :: $funcType' needs $expectedCount parameters, but $actualCount parameters are given"

fun variableAlreadyDefined(variable: Identifier, type: Type, index: Index): String =
        "Variable '${variable.name}' with type '$type' has already been defined at $index"

fun patternUnmatchedError(expectedCount: Int, actualCount: Int): String =
        "Pattern unmatched! Expected $expectedCount members, yet $actualCount members are found"