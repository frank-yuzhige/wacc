package parser.exceptions

sealed class SyntacticException(var msg: String) :
        Exception("[PARSE ERROR!]\n$msg") {


    class SyntacticExceptionBundle(bundle: Iterable<SyntacticException>)
        : SyntacticException(bundle.joinToString("\n===================\n") { it.toString() })

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

    class AntlrLexerGivenException(antlrMsg: String) :
            SyntacticException("Lexing Error $antlrMsg")
    class AntlrParserGivenException(antlrMsg: String) :
            SyntacticException("Parse Error $antlrMsg")


    fun at(index: Any): SyntacticException {
        this.msg += "  [at $index]"
        return this
    }

    fun forwardWith(postfix: String): SyntacticException {
        this.msg += "\n$postfix"
        return this
    }
}