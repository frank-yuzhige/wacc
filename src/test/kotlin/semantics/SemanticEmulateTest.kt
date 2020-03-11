package semantics

import utils.CompilerEmulator
import CompilerMode
import utils.NullOutputStream
import utils.excludedFiles
import java.io.File
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertTrue

class SemanticEmulateTest {
    @Test
    fun batchSemanticCheckTest() {
        File("src/test/resources/").walkTopDown()
                .filterNot { it.path in excludedFiles() }
                .forEach {
            if (it.path.endsWith(".wacc")) {
                val result = CompilerEmulator(it, CompilerMode.SEM_CHECK , PrintStream(NullOutputStream())).run()
                val exitCode = result.exitCode
                when {
                    it.path.contains("syntaxErr") -> assertTrue(exitCode == 100)
                    it.path.contains("semanticErr") -> assertTrue(exitCode == 200)
                    else -> assertTrue(exitCode == 0)
                }
            }
        }
    }
}