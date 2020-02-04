package exceptions

import utils.AstIndexMap
import ast.Expression.PairElemFunction
import ast.Type
import ast.Type.FuncType
import ast.WaccAST
import utils.Index
import java.lang.Exception

sealed class SemanticException(val msg: String): Exception(msg) {

    class PureSemanticException(cause: String): SemanticException(cause)


    class UndefinedVarException(variable: String):
            SemanticException("Attempt to access an undefined variable '$variable'!")

    class UndefinedFuncException(variable: String):
            SemanticException("Attempt to access an undefined function '$variable'!")

    class MultipleFuncDefException(function: String, type: Type, index: Index):
            SemanticException("Function \"$function\" with type $type has already been defined at $index!")

    data class TypeMismatchException(val expected: Type, val actual: Type):
            SemanticException("Couldn't match expected type '$expected' with actual type: '$actual'")

    class OperatorNotSupportTypeException(expected: Type, operator: String):
            SemanticException("'$operator' does not support expected type '$expected'!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}