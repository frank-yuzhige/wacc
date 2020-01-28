import parser.Parser
import parser.exceptions.ParseException
import parser.toAST
import utils.Catcher
import utils.catchError
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import java.util.*

fun main(args: Array<String>) {
    val program = """
        begin
        int foo(int x, char y) is
            int k = x + 100;
            return k;
        end
        int x = foo(1);
        println x + 11100000000000;
        end
    """.trimIndent()

    try {
        println(Parser(program.byteInputStream()).parseProgram())
    } catch (pe: ParseException) {
        println(pe.msg)
    }

}
