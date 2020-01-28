import parser.Parser
import parser.exceptions.SyntacticException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val program = """
        begin
        int foo(int x, char y) is
            int k = x + 100;
            return k
        end
        int x = call foo(1);
        println "hello \ "
        end
    """.trimIndent()

    try {
        println(Parser(program.byteInputStream()).parseProgram())
    } catch (pe: SyntacticException) {
        println(pe.message)
        exitProcess(100)
    }

}
