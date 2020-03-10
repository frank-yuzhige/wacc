package extension

import CompilerMode.EXECUTE
import codegen.AssemblyBehaviourTest
import utils.CompilerEmulator
import java.io.File
import java.util.concurrent.TimeoutException
import kotlin.test.Test

class ExtensionBehaviourTest {
    private val failedTestsInfo: MutableMap<String, String> = mutableMapOf()


    @Test
    fun valids() = testAll("src/test/resources/extension/valid/", 0)

    @Test
    fun invalids() = testAll("src/test/resources/extension/invalid/", 200)

    fun testAll(path: String, expectedExitCode: Int) {
        var correctCount = 0
        var totalCount = 0
        File(path).walkTopDown()
                .filter { it.extension == "awsl" }
                .forEach { testFile ->
                    println("Current file $testFile")
                    try {
                        val emulator = CompilerEmulator(testFile, EXECUTE)
                        val result = emulator.run()
                        if (result.exitCode == expectedExitCode) {
                            correctCount++
                            println("All is good: ${testFile.path}")
                        } else {
                            logFailedTest(testFile.relativeTo(File(path)),
                                    AssemblyBehaviourTest.FailureType.OUTPUT_MISMATCH)
                            println("Mismatch exit code, expected $expectedExitCode, but actual: ${result.exitCode}")
                        }
                    } catch (e: Throwable) {
                        if (e is TimeoutException) {
                            logFailedTest(testFile.relativeTo(File(path)),
                                    AssemblyBehaviourTest.FailureType.TIMEOUT)
                            println("Timeout: ${testFile.path}")
                        } else {
                            logFailedTest(testFile.relativeTo(File(path)),
                                    AssemblyBehaviourTest.FailureType.EXECUTION_FAILURE)
                            println(e.message)
                            println("Execution failed: ${testFile.path}")
                        }
                    } finally {
                        totalCount++
                    }
                }
        cleanUp()
        println("\n\nTest passed: $correctCount/$totalCount")
        if (correctCount < totalCount) {
            var errorMsg = ""
            failedTestsInfo.forEach {(file, cause) -> errorMsg += "$file: $cause\n"}
            println(errorMsg)
        }
    }

    private fun logFailedTest(testFile: File, cause: AssemblyBehaviourTest.FailureType) = failedTestsInfo.set(testFile.path, cause.cause)

    private fun cleanUp() {
        val tempFiles: List<File> = listOf(File("src/test/kotlin/utils/temp"),
                File("src/test/kotlin/utils/temp.s"))
        tempFiles.forEach {
            if (it.exists()) { it.delete() }
        }
    }
}