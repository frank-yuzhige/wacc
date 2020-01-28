package parser

import utils.CompilerEmulator
import utils.NullOutputStream
import java.io.File
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertTrue

class ParserEmulateTest {

    @Test
    fun batchTestParseError() {
        File("src/test/resources/").walkTopDown().forEach {
            if (it.path.endsWith(".wacc")) {
                val exitCode = CompilerEmulator(it, PrintStream(NullOutputStream())).getExitCode()
                if (it.path.contains("syntaxErr")) {
                    assertTrue(exitCode == 100)
                } else {
                    assertTrue(exitCode == 0 || exitCode == 200)
                }
            }
        }
    }
}