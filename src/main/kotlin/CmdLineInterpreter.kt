import org.antlr.v4.runtime.*

import antlr.WaccLexer
import antlr.WaccParser
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