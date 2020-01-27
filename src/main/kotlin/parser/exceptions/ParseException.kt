package parser.exceptions

import java.lang.Exception

sealed class ParseException(var msg: String): Exception() {

    override fun toString(): String {
        return "PARSE ERROR!: \n${this.javaClass.canonicalName}!\n${this.msg}"
    }

    class ParseExceptionBundle(bundle: Iterable<ParseException>)
        : ParseException (bundle.joinToString(";\n") { it.toString() })

    class UnrecognizedTypeException(typeName: String) :
            ParseException("Unrecognized type \"$typeName\"!")
    class UnsupportedArrayBaseTypeException(typeName: String) :
            ParseException("\"$typeName\" is not a valid base type for array!")
    class IntegerParseException(intString: String) :
            ParseException("$intString is not a valid integer!")
    class InvalidEscapeCharException(char: Char?): ParseException(
            if (char == null) {
                "No character after a single \\!"
            } else {
                "'\\$char' is not a valid escape character!"
            })
    class UnknownUnaryOpException(op: String):
            ParseException("Unknown unary operator \"$op\"")
    class UnknownBinaryOpException(op: String):
            ParseException("Unknown unary operator \"$op\"")


    fun at(index: Any): ParseException {
        this.msg += "  [at $index]"
        return this
    }

    fun forwardWith(postfix: String) : ParseException {
        this.msg += "\n$postfix"
        return this
    }
}