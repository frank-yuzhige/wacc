package exceptions

import utils.AstIndexMap
import ast.Expression.PairElemFunction
import ast.Type
import ast.Type.FuncType
import ast.WaccAST
import utils.Index
import java.lang.Exception

open class SemanticException(val msg: String): Exception(msg) {

    class UndefinedVarException(variable: String):
            SemanticException("Attempt to access an undefined variable '$variable'!")

    class UndefinedFuncException(variable: String):
            SemanticException("Attempt to access an undefined function '$variable'!")

    class MultipleFuncDefException(function: String, type: Type, index: Index):
            SemanticException("Function \"$function\" with type '$type' has already been defined at $index!")

    class TypeMismatchException(expected: Type, actual: Type):
            SemanticException("Couldn't match expected type '$expected' with actual type: '$actual'")

    class OperatorNotSupportTypeException(expected: Type, operator: String):
            SemanticException("'$operator' does not support expected type '$expected'!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}