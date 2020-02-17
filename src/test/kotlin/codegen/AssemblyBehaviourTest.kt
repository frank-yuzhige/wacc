package codegen

import utils.CompilerEmulator
import utils.EmulatorMode.*
import java.io.File
import java.util.concurrent.TimeoutException
import kotlin.test.Test
import kotlin.test.fail

class AssemblyBehaviourTest {
    data class RefCompilerOutput(val output: String, val exitCode: Int)
    private val failedTestsInfo: MutableMap<String, String> = mutableMapOf()
    enum class FailureType(val cause: String) {
        OUTPUT_MISMATCH("Mismatched output"),
        TIMEOUT("Execution timeout"),
        EXECUTION_FAILURE("Execution failed")
    }

    private fun getRefCompilerOutput(file: File): RefCompilerOutput {
        val process = ProcessBuilder("./refCompile", "-x", file.absolutePath).start()
        process.waitFor()
        var expectedOutput = ""
        process.inputStream.reader(Charsets.UTF_8).use {
            expectedOutput += it.readText()
        }
        val pureOutputRegex = """={59}\n([\s\S]*)={59}""".toRegex()
        val matchResult = pureOutputRegex.find(expectedOutput)

        val exitCodeRegex = """exit code is (\d+)""".toRegex()
        val exitCodeMatchResult = exitCodeRegex.find(expectedOutput)
        return RefCompilerOutput(if (matchResult != null) { matchResult.groups[1]!!.value } else { "" },
                exitCodeMatchResult!!.groups[1]!!.value.toInt())
    }

    @Test
    fun assemblyBehaviourBatchTest() {
        var correctCount = 0
        var totalCount = 0
        File("src/test/resources/valid/").walkTopDown().forEach { testFile ->
            if (testFile.path.endsWith(".wacc")) {
                println("Current file $testFile")
                try {
                    val emulator = CompilerEmulator(testFile, EXECUTE)
                    val result = emulator.run()
                    val expectedResult = getRefCompilerOutput(testFile)
                    if (result.output != expectedResult.output || result.exitCode != expectedResult.exitCode) {
                        logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                                FailureType.OUTPUT_MISMATCH)
                        println("Mismatched output: ${testFile.path}")
                    } else {
                        correctCount++
                        println("All is good: ${testFile.path}")
                    }
                } catch (e: Throwable) {
                    if (e is TimeoutException) {
                        logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                                FailureType.TIMEOUT)
                        println("Timeout: ${testFile.path}")
                    } else {
                        logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                                FailureType.EXECUTION_FAILURE)
                        println("Execution failed: ${testFile.path}")
                    }
                } finally {
                    totalCount++
                }
            }
        }
        cleanUp()
        if (correctCount < totalCount) {
            var errorMsg = "\n\nTest passed: $correctCount/$totalCount\n\n"
            failedTestsInfo.forEach {(file, cause) -> errorMsg += "$file: $cause\n"}
            fail(errorMsg)
        }
        println("\n\nTest passed: $correctCount/$totalCount")
    }

    private fun logFailedTest(testFile: File, cause: FailureType) = failedTestsInfo.set(testFile.path, cause.cause)

    private fun cleanUp() {
        val tempFiles: List<File> = listOf(File("src/test/kotlin/utils/temp"), File("src/test/kotlin/utils/temp.s"))
        tempFiles.forEach {
            if (it.exists()) { it.delete() }
        }
    }
}