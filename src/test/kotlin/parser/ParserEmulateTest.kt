package parser

import ast.BinaryOperator
import ast.Expression
import utils.CompilerEmulator
import utils.NullOutputStream
import java.io.File
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ParserEmulateTest {

    @Test
    fun batchTestParseError() {
        File("src/test/resources/").walkTopDown().forEach {
            if (it.path.endsWith(".wacc")) {
                val exitCode = CompilerEmulator(it, PrintStream(NullOutputStream())).run().exitCode
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
                val result = CompilerEmulator(it).run()
                if (result.exception != null) {
                    fail("program at ${it.path} fail to parse due to exception: ${result.exception.javaClass.canonicalName}")
                }
                val progString = result.ast!!.prettyPrint()
                val tempFile = createTempFile(directory = File("src/test"))
                tempFile.writeText(progString)
                val result2 = CompilerEmulator(tempFile).run()
                tempFile.delete()
                if (result2.exception != null) {
                    fail("program at ${it.path} fail to parse due to exception: ${result2.exception.javaClass.canonicalName}")
                }
                assertEquals(Expression.BinExpr(Expression.Identifier("x"), BinaryOperator.ADD, Expression.IntLit(1))
                , Expression.BinExpr(Expression.Identifier("x"), BinaryOperator.ADD, Expression.IntLit(1)))
                assertEquals(result.ast, result2.ast)
            }
        }
    }

}