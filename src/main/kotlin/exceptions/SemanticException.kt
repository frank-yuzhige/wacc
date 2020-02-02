package exceptions

import utils.AstIndexMap
import ast.Expression.PairElemFunction
import ast.Type
import ast.Type.FuncType
import ast.WaccAST
import utils.Index
import java.lang.Exception

sealed class SemanticException(var msg: String): Exception(msg) {

    fun forwardText(message: String): SemanticException {
        this.msg += "\n$message"
        return this
    }

    fun forwardWith(sentenceKind: String, ast: WaccAST, astIndexMap: AstIndexMap): SemanticException {
        val text = ast.prettyPrint()
        val lines = text.split("\n")
        val abbr = if (lines.count() > 3) {
            "\n    ${lines[0]}\n    ${lines[1]}\n    ${lines[2]}\n        ..."
        } else {
            text
        }
        this.msg += "\nin $sentenceKind at ${astIndexMap[ast]}: $abbr"
        return this
    }

    class PureSemanticException(cause: String): SemanticException(cause)

    class SemanticExceptionBundle(errors: Iterable<SemanticException>,
                                  separator: String = "\n",
                                  prefix: String = "",
                                  suffix: String = ""):
            SemanticException(prefix + errors.joinToString("\n") { it.msg } + suffix)

    class MultipleVarDefException(variable: String, type: Type, index: Index):
            SemanticException("Variable \"$variable\" with type $type has already been defined at $index!")

    class UndefinedVarException(variable: String):
            SemanticException("Attempt to access an undefined variable '$variable'!")

    class UndefinedFuncException(variable: String):
            SemanticException("Attempt to access an undefined function '$variable'!")

    class MultipleFuncDefException(function: String, type: Type, index: Index):
            SemanticException("Function \"$function\" with type $type has already been defined at $index!")

    data class NoMatchingCandidatesException(val actual: Type, val candidates: Iterable<Type>):
            SemanticException("couldn't match any of the expecting types:" +
                    " ${candidates.joinToString(", ") { it.toString() }}" +
                    "with actual type: $actual")
    data class TypeMismatchException(val expected: Type, val actual: Type):
            SemanticException("Couldn't match expected type '$expected' with actual type: '$actual'")
    data class OperatorReturnTypeMismatchException(val expected: Type, val actual: Type, val op: String):
            SemanticException("Couldn't match expected type '$expected' with actual type: '$actual' returned by \"$op\"")
    data class InsufficientArrayRankException(val arrType: Type, val attempt: Int):
            SemanticException("$arrType does not have more than $attempt rank")
    data class NotAPairException(val actual: Type):
            SemanticException("Expecting any pair, but $actual is not a pair!")
    data class AccessMemberOfNullLitException(val func: PairElemFunction):
            SemanticException("Cannot access the $func element of a null-literal!")
    data class FuncCallArgCountMismatchException(val func: String,
                                                 val funcType: FuncType,
                                                 val expected: Int,
                                                 val actual: Int):
            SemanticException("A call to function $func : $funcType needs $expected parameters, " +
                    "but only $actual parameters has been provided")


    class OperatorNotSupportTypeException(expected: Type, operator: String):
            SemanticException("'$operator' does not support expected type '$expected'!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}