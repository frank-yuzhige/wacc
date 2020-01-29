package exceptions

import ast.Type
import utils.Index
import java.lang.Exception

sealed class SemanticException(var msg: String): Exception() {

    class SemanticExceptionBundle(variable: Iterable<SemanticException>):
            SemanticException("SEM ERROR: ${variable.joinToString("\n==========\n") { it.msg }}")

    class MultipleVarDefException(variable: String, type: Type, index: Index):
            SemanticException("Variable \"$variable\" with type $type has already been defined at $index!")

    class UndefinedVarException(variable: String):
            SemanticException("Attempt to access an undefined variable '$variable'!")

    class UndefinedFuncException(variable: String):
            SemanticException("Attempt to access an undefined function '$variable'!")

    class MultipleFuncDefException(function: String, type: Type, index: Index):
            SemanticException("Function \"$function\" with type $type has already been defined at $index!")

    class TypeMismatchException(expected: Type, actual: Type):
            SemanticException("Couldn't match expected type '$expected' with actual type: '$actual'")

    class OperatorNotSupportTypeException(expected: Type, operator: String):
            SemanticException("'$operator' does not support expected type '$expected'!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}