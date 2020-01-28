import parser.Parser
import exceptions.SyntacticException
import exceptions.SemanticException
import java.io.FileInputStream
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val inputStream = if (args.isNotEmpty()) {
        FileInputStream(args[0])
    } else {
        System.`in`
    }

    val ast = try {
        Parser(inputStream).parseProgram()
    } catch (pe: SyntacticException) {
        println(pe.msg);
        exitProcess(100)
    } catch (se: SemanticException) {
        println(se.message)
        exitProcess(200)
    }

    println("===========")
    println(ast)
    println("===========")
//    AstIndexMap.map.entries.sortedBy { it.value.first }.forEach { println(it) }
}