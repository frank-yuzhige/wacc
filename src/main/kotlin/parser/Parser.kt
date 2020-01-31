package parser

import antlr.WaccLexer
import antlr.WaccParser
import ast.*
import ast.Function
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.TokenStream
import exceptions.ParseErrorListener
import exceptions.SyntacticException.SyntacticExceptionBundle
import utils.AstIndexMap
import java.io.InputStream
import java.io.PrintStream
import java.util.*

class Parser(private val inputStream: InputStream,
             private val outputStream: PrintStream = System.out,
             private val errorStream: PrintStream = System.err,
             val astIndexMap: AstIndexMap = IdentityHashMap()) {

    private val parseErrorListener = ParseErrorListener()

    fun runParser(): WaccParser {
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
        val program = runParser().prog()
        throwsPotentialErrors()
        return RuleContextConverter(astIndexMap).convertProgram(program)
    }

    fun parseFunction(): Function {
        val function = runParser().func()
        throwsPotentialErrors()
        return RuleContextConverter(astIndexMap).convertFunction(function)
    }

    fun parseStatement(): Statement {
        val statement = runParser().stat()
        throwsPotentialErrors()
        return RuleContextConverter(astIndexMap).convertStatement(statement)
    }

    fun parseExpression(): Expression {
        val expression = runParser().expr()
        throwsPotentialErrors()
        return RuleContextConverter(astIndexMap).convertExpression(expression)
    }

    fun throwsPotentialErrors() {
        if (parseErrorListener.errorBundle.isNotEmpty()) {
            val errorCount = parseErrorListener.errorBundle.size
            val errorText = "error" + if (errorCount == 1) { "" } else { "s" }
            errorStream.println("$errorCount syntax $errorText found when constructing antlr parse tree!")
            throw SyntacticExceptionBundle(parseErrorListener.errorBundle)
        }
    }

}