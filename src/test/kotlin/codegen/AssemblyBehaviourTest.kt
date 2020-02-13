package codegen

import utils.CompilerEmulator
import utils.EmulatorMode
import utils.EmulatorMode.*
import java.io.File
import java.util.concurrent.TimeoutException
import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class AssemblyBehaviourTest {
    data class RefCompilerOutput(val output: String, val exitCode: Int)

    private fun getRefCompilerOutput(file: File): RefCompilerOutput {
        val process = ProcessBuilder("./refCompile", "-x", file.absolutePath).start()
        process.waitFor()
        var expectedOutput = ""
        process.inputStream.reader(Charsets.UTF_8).use {
            expectedOutput += it.readText()
        }
        val pureOutputRegex = """=+\n([^=]*)=+""".toRegex()
        val matchResult = pureOutputRegex.find(expectedOutput)

        return RefCompilerOutput(if (matchResult != null) { matchResult.groups[1]!!.value } else { "" }, process.exitValue())
    }

    @Test
    fun assemblyBehaviourBatchTest() {
        var correctCount = 0
        var totalCount = 0
        val failedTests: MutableList<String> = mutableListOf()
        File("src/test/resources/valid").walkTopDown().forEach { testFile ->
            if (testFile.path.endsWith(".wacc")) {
                println("Current file $testFile")
                try {
                    val emulator = CompilerEmulator(testFile, EXECUTE)
                    val result = emulator.run()
                    val expectedResult = getRefCompilerOutput(testFile)
                    if (result.output != expectedResult.output || result.exitCode != expectedResult.exitCode) {
                        println("Mismatched output: ${testFile.path}")
                    } else {
                        correctCount++
                        println("All is good: ${testFile.path}")
                    }
                } catch (e: Throwable) {
                    failedTests += testFile.relativeTo(File("src/test/resources/valid/")).path
                    if (e is TimeoutException) {
                        println("Timeout: ${testFile.path}")
                    } else {
                        println("Execution failed: ${testFile.path}")
                    }
                } finally {
                    totalCount++
                }
            }
        }
        cleanUp()
        println("\n\nTest passed: $correctCount/$totalCount")
        failedTests.forEach { println(it) }
    }

    private fun cleanUp() {
        val tempFiles: List<File> = listOf(File("src/test/kotlin/utils/temp"), File("src/test/kotlin/utils/temp.s"))
        tempFiles.forEach {
            if (it.exists()) { it.delete() }
        }
    }
}