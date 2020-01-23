package parser

import antlr.WaccLexer
import antlr.WaccParser
import antlr.WaccParser.ProgContext
import ast.*
import ast.Function
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.TokenStream
import java.io.InputStream

class Parser(private val inputStream: InputStream) {

    fun doParse(): WaccParser {
        val input = CharStreams.fromStream(inputStream)
        val lexer = WaccLexer(input)
        val tokens = CommonTokenStream(lexer)
        return WaccParser(tokens as TokenStream)
    }


    fun parseProgram(): ProgramAST {

        TODO()
    }

    fun parseFunction(): Function {
        TODO()
    }

    fun parseStatement(): Statement {
        TODO()
    }

    fun parseExpression(): Expression {
        TODO()
    }
//
//    fun ParserRuleContext.toAST() : WaccAST {
//        return when(this) {
//            is ProgContext -> ProgramAST(this.func().map { it.toAST() }, this.stats().toAST())
//        }
//    }

}