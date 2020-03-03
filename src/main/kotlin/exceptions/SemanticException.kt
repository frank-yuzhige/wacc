package exceptions

import ast.Type
import semantics.accessToUndefinedFunc
import semantics.accessToUndefinedVar
import semantics.typeMismatchError
import utils.Index

open class SemanticException(val msg: String) : Exception(msg) {

    class UndefinedVarException(variable: String) :
            SemanticException(accessToUndefinedVar(variable))

    class UndefinedFuncException(funcName: String) :
            SemanticException(accessToUndefinedFunc(funcName))

    class MultipleFuncDefException(function: String, type: Type, index: Index) :
            SemanticException("Function \"$function :: $type\" has already been defined at $index!")

    class TypeMismatchException(expected: Type, actual: Type) :
            SemanticException(typeMismatchError(expected, actual))

    class NotEnoughArrayRankException(arrName: String):
            SemanticException("'$arrName' does not have enough rank!")

    class ReturnInMainProgramException(indices: List<Index>) :
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")

    class WriteToConstVarException(name: String):
            SemanticException("Attempt to write to a constant variable $name")
}