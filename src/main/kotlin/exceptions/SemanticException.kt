package exceptions

import utils.AstIndexMap
import ast.Expression.PairElemFunction
import ast.Type
import ast.Type.FuncType
import ast.WaccAST
import utils.Index
import java.lang.Exception

sealed class SemanticException(var msg: String): Exception(msg) {

    fun forwardWith(sentenceKind: String, ast: WaccAST, astIndexMap: AstIndexMap): SemanticException {
        this.msg += "\nin $sentenceKind at ${astIndexMap[ast]}: ${ast.prettyPrint()}"
        return this
    }

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
    sealed class TypeException(msg: String):
            SemanticException("Type mismatch!\n$msg") {
        data class NoMatchingCandidatesException(val actual: Type, val candidates: Iterable<Type>):
                TypeException("couldn't match any of the expecting types:" +
                        " ${candidates.joinToString(", ") { it.toString() }}" +
                        "with actual type: $actual")
        data class SingleTypeMismatchException(val expected: Type, val actual: Type):
                TypeException("Couldn't match expected type '$expected' with actual type: '$actual'")
        data class InsufficientArrayRankException(val arrType: Type, val attempt: Int):
                TypeException("$arrType does not have more than $attempt rank")
        data class NotAPairException(val actual: Type):
                TypeException("Expecting any pair, but $actual is not a pair!")
        data class AccessMemberOfNullLitException(val func: PairElemFunction):
                TypeException("Cannot access the $func element of a null-literal!")
        data class FuncCallArgCountMismatchException(val func: String,
                                                     val funcType: FuncType,
                                                     val expected: Int,
                                                     val actual: Int):
                TypeException("A call to function $func : $funcType needs $expected parameters, " +
                        "but only $actual parameters has been provided")
    }

    class OperatorNotSupportTypeException(expected: Type, operator: String):
            SemanticException("'$operator' does not support expected type '$expected'!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}