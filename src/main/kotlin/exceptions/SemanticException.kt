package exceptions

import java.lang.Exception

sealed class SemanticException(var msg: String): Exception() {

    class MultipleDefinitionException(variable: String):
            SemanticException("Variable \"$variable\" has defined twice")

    class ReturnInMainProgramException(indices: List<Pair<Int, Int>>):
            SemanticException("Found return statement(s) in main program! at ${indices.joinToString(", ")}")
}