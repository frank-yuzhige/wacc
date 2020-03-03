package parser

import ast.BinaryOperator
import ast.Expression
import exceptions.SyntacticException
import utils.CompilerEmulator
import CompilerMode.PARSE_ONLY
import utils.NullOutputStream
import java.io.File
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ParserEmulateTest {

    @Test
    fun batchParseOnlyTest() {
        File("src/test/resources/").walkTopDown().forEach {
            if (it.path.endsWith(".wacc")) {
                val result = CompilerEmulator(it, PARSE_ONLY ,PrintStream(NullOutputStream())).run()
                val exitCode = result.exitCode
                if (it.path.contains("syntaxErr")) {
                    assertTrue(exitCode == 100)
                } else {
                    assertTrue(exitCode == 0 || exitCode == 200)
                }
            }
        }
    }

    @Test
    fun parserMetamorphicTest() {
        File("src/test/resources/valid/advanced").walkTopDown().forEach {
            if (it.path.endsWith(".wacc")) {
                val result = CompilerEmulator(it, PARSE_ONLY).run()
                if (result.exception != null) {
                    System.err.println("program at ${it.path} fail to parse due to exception: ")
                    result.exception.printStackTrace(System.err)
                    fail()
                }
                val progString = result.ast!!.prettyPrint()
                val tempFile = createTempFile(directory = File("src/test"))
                tempFile.writeText(progString)
                val result2 = CompilerEmulator(tempFile, PARSE_ONLY).run()
                tempFile.delete()
                if (result2.exception != null) {
                    if (result2.exception is SyntacticException) {
                        System.err.println(result2.exception.msg)
                    }
                    fail("program at ${it.path} fail to parse due to exception: " +
                            "${result2.exception.javaClass.canonicalName}\n")
                }
                assertEquals(Expression.BinExpr(Expression.Identifier("x"), BinaryOperator.ADD, Expression.IntLit(1)),
                        Expression.BinExpr(Expression.Identifier("x"), BinaryOperator.ADD, Expression.IntLit(1)))
                assertEquals(result.ast, result2.ast)
            }
        }
    }

}