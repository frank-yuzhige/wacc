package parser

import ast.BinaryOperator
import ast.Expression
import exceptions.SyntacticException
import utils.CompilerEmulator
import CompilerMode.PARSE_ONLY
import utils.NullOutputStream
import utils.excludedFiles
import java.io.File
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ParserEmulateTest {

    @Test
    fun batchParseOnlyTest() {
        File("src/test/resources/").walkTopDown()
                .filterNot { it in excludedFiles() }
                .forEach {
            if (it.path.endsWith(".wacc")) {
                val result = CompilerEmulator(it, PARSE_ONLY ,PrintStream(NullOutputStream())).run()
                val exitCode = result.exitCode
                if (it.path.contains("syntaxErr")) {
                    assertTrue(exitCode == 100)
                } else {
                    assertTrue(exitCode == 0 || exitCode == 200 || exitCode == 100)
                }
            }
        }
    }

}