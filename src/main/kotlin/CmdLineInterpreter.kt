import org.antlr.v4.runtime.*
import org.antlr.runtime.tree.ParseTree

import antlr.WaccLexer
import antlr.WaccParser
import org.antlr.v4.runtime.tree.RuleNode
import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {
    var inputStream = System.`in`
    if (args.isNotEmpty()) {
        try {
            inputStream = FileInputStream(args[0])
        } catch (e: Exception) {
        }
    }
    val input = ANTLRInputStream(inputStream)

    val lexer = WaccLexer(input)

    val tokens = CommonTokenStream(lexer)

    val parser = WaccParser(tokens as TokenStream)

    val tree: ParserRuleContext = parser.prog()


    println("===========")
    println(tree.toStringTree())
    println("===========")
}