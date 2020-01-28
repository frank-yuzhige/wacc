package exceptions

import exceptions.SyntacticException.*
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class ParseErrorListener: BaseErrorListener() {
    private val errorBundle: MutableCollection<AntlrParserGivenException> = mutableListOf()

    override fun syntaxError(recognizer: Recognizer<*, *>?,
                             offendingSymbol: Any?,
                             line: Int,
                             charPositionInLine: Int,
                             msg: String?,
                             e: RecognitionException?) {
        println(msg)
        errorBundle += AntlrParserGivenException("at ${Pair(line, charPositionInLine)}: $msg")
    }

    fun throwPotentialErrors() {
        if (errorBundle.isNotEmpty()) {
            println("${errorBundle.size} syntax error(s) found when constructing antlr parse tree!")
            throw SyntacticExceptionBundle(errorBundle)
        }
    }
}