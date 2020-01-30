import parser.Parser
import exceptions.SyntacticException
import exceptions.SemanticException
import semantics.SemanticAnalyzer
import java.io.FileInputStream
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val inputStream = if (args.isNotEmpty()) {
        try {
            FileInputStream(args[0])
        } catch (fnfe: FileNotFoundException) {
            println("File not found!")
            println("Unable to locate file at ${args[0]}")
            exitProcess(1)
        }
    } else {
        System.`in`
    }

    val ast = try {
        val temp = Parser(inputStream).parseProgram()
        SemanticAnalyzer().doCheck(temp)
        temp
    } catch (pe: SyntacticException) {
        System.err.println(pe.msg);
        exitProcess(100)
    } catch (se: SemanticException) {
        System.err.println(se.message)
        exitProcess(200)
    }

    println("===========")
    println(ast.prettyPrint())
    println("===========")
}