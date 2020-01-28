import exceptions.ParseErrorListener
import parser.Parser
import exceptions.SyntacticException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val program = """
        begin
        int x = -12000000000000000
        end
    """.trimIndent()

    try {
        val parser = Parser(program.byteInputStream())
        println(parser.parseProgram())
        parser.throwsPotentialErrors()
    } catch (pe: SyntacticException) {
        println(pe.msg)
        exitProcess(100)
    }

}
