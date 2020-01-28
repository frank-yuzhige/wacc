package exceptions

import exceptions.SyntacticException.*
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import java.io.PrintStream

class ParseErrorListener : BaseErrorListener() {
    val errorBundle: MutableCollection<AntlrParserGivenException> = mutableListOf()

    override fun syntaxError(recognizer: Recognizer<*, *>?,
                             offendingSymbol: Any?,
                             line: Int,
                             charPositionInLine: Int,
                             msg: String?,
                             e: RecognitionException?) {
        errorBundle += AntlrParserGivenException("at ${Pair(line, charPositionInLine)}: $msg")
    }
}