package parser.exceptions

import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import parser.exceptions.SyntacticException.AntlrParserGivenException

object ParserErrorListener: BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?,
                             offendingSymbol: Any?,
                             line: Int,
                             charPositionInLine: Int,
                             msg: String?,
                             e: RecognitionException?) {
        throw AntlrParserGivenException("at ${Pair(line, charPositionInLine)}: $msg")
    }
}