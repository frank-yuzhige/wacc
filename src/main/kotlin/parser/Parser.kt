package parser

import antlr.WaccLexer
import antlr.WaccParser
import ast.*
import ast.Function
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.TokenStream
import exceptions.ParseErrorListener
import java.io.InputStream

class Parser(private val inputStream: InputStream) {

    private val parseErrorListener = ParseErrorListener()

    fun doParse(): WaccParser {
        val input = CharStreams.fromStream(inputStream)
        val lexer = WaccLexer(input)
        lexer.removeErrorListeners()
        lexer.addErrorListener(parseErrorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = WaccParser(tokens as TokenStream)
        parser.removeErrorListeners()
        parser.addErrorListener(parseErrorListener)
        parser.errorHandler
        return parser
    }


    fun parseProgram(): ProgramAST {
        val ruleContext = doParse().prog()
        throwsPotentialErrors()
        return ruleContext.toAST()
    }

    fun parseFunction(): Function = doParse().func().toAST()

    fun parseStatement(): Statement = doParse().stat().toAST()

    fun parseExpression(): Expression = doParse().expr().toAST()

    fun throwsPotentialErrors(): Parser {
        this.parseErrorListener.throwPotentialErrors()
        return this
    }

}