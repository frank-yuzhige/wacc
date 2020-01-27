import parser.Parser
import java.io.FileInputStream

fun main(args: Array<String>) {
    val inputStream = if (args.isNotEmpty()) {
        FileInputStream(args[0])
    } else {
        System.`in`
    }

    val parser = Parser(inputStream)

    println("===========")
    println(parser.parseProgram())
    println("===========")
}