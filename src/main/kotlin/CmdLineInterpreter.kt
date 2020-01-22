import org.antlr.v4.runtime.*
import org.antlr.runtime.tree.ParseTree

import antlr.BasicParser
import antlr.BasicLexer
import org.antlr.v4.runtime.tree.RuleNode
import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {
    var inputStream = System.`in`
    if (args.size > 0) {
        try {
            inputStream = FileInputStream(args[0])
        } catch (e: Exception) {
        }
    }
    val input = ANTLRInputStream(inputStream)

    val lexer = BasicLexer(input)

    val tokens = CommonTokenStream(lexer)

    val parser = BasicParser(tokens as TokenStream)

    val tree: ParserRuleContext = parser.prog()


    println("===========")
    println(tree.toStringTree())
    println("===========")
}