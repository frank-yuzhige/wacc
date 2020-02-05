package exceptions

sealed class SyntacticException(var msg: String) : Exception() {

    class SyntacticExceptionBundle(bundle: Iterable<SyntacticException>)
        : SyntacticException(bundle.joinToString("\n===================\n") { it.msg }) {
        val count: Int = bundle.count()
    }

    class UnrecognizedTypeException(typeName: String) :
            SyntacticException("Unrecognized type \"$typeName\"!")

    class UnsupportedArrayBaseTypeException(typeName: String) :
            SyntacticException("\"$typeName\" is not a valid base type for array!")

    class IntegerSyntacticException(intString: String) :
            SyntacticException("$intString is not a valid integer!")

    class InvalidEscapeCharException(char: Char?) : SyntacticException(
            if (char == null) {
                "No character after a single \\!"
            } else {
                "'\\$char' is not a valid escape character!"
            })

    class UnknownUnaryOpException(op: String) :
            SyntacticException("Unknown unary operator \"$op\"")

    class UnknownBinaryOpException(op: String) :
            SyntacticException("Unknown unary operator \"$op\"")

    class UnknownStatTypeException() :
            SyntacticException("Unknown type of statement!")

    class UnknownExprTypeException() :
            SyntacticException("Unknown type of expression!")

    class EmptyMainProgramException():
            SyntacticException("Program body is empty!")

    class LastStatIsNotTerminatorException:
            SyntacticException("The last statement should be a return, exit, " +
                    "\n  or an if-statement with both branches end with a terminator")

    class AntlrLexerGivenException(antlrMsg: String) :
            SyntacticException("Lexing Error $antlrMsg")
    class AntlrParserGivenException(antlrMsg: String) :
            SyntacticException("Parse Error $antlrMsg")

    fun forwardWith(postfix: String): SyntacticException {
        this.msg += "\n$postfix"
        return this
    }
}