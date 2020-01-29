import ast.*
import ast.Expression.*
import ast.Statement.Declaration
import ast.Type.*
import ast.Type.BaseTypeKind.*
import parser.Parser
import exceptions.SyntacticException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val stat1 = Declaration(BaseType(INT), Identifier("x"), IntLit(1))
    val stat2 = Declaration(BaseType(INT), Identifier("y"), IntLit(2))
    val stats: Statements = listOf<Statement>(stat1, stat2)

    val program = "begin\n${ stats.joinToString("\n") { it.prettyPrint() }.prependIndent() }\nend"

    println(program)

    try {
        val parser = Parser(program.byteInputStream())
        println(parser.parseProgram().prettyPrint())
        parser.throwsPotentialErrors()
    } catch (pe: SyntacticException) {
        println(pe.msg)
        exitProcess(100)
    }

}
