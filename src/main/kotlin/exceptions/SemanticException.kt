package exceptions

import ast.Type
import utils.Index
import java.lang.Exception

sealed class SemanticException(var msg: String): Exception() {

    class MultipleVarDefException(variable: String, type: Type, index: Index):
            SemanticException("Variable \"$variable\" with type $type has already been defined at $index!")
    class MultipleFuncDefException(function: String, type: Type, index: Index):
            SemanticException("Function \"$function\" with type $type has already been defined at $index!")

    class ReturnInMainProgramException(indices: List<Index>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}