import org.antlr.v4.runtime.*

import antlr.WaccLexer
import antlr.WaccParser
import ast.AstIndexMap
import parser.Parser
import parser.exceptions.ParseException
import parser.exceptions.SemanticException
import java.io.FileInputStream
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val inputStream = if (args.isNotEmpty()) {
        FileInputStream(args[0])
    } else {
        System.`in`
    }

    val parser = try {
        Parser(inputStream)
    } catch (pe: ParseException) {
        print(pe.message);
        exitProcess(100)
    } catch (se: SemanticException) {
        print(se.message)
        exitProcess(200)
    }

    println("===========")
    println(parser.parseProgram())
    println("===========")
//    AstIndexMap.map.entries.sortedBy { it.value.first }.forEach { println(it) }
}