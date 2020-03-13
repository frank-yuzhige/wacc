package codegen
import utils.CompilerEmulator
import CompilerMode.*
import utils.RefCompiler
import utils.cleanUp
import utils.excludedFiles
import java.io.*
import java.util.concurrent.TimeoutException
import kotlin.test.Test
import kotlin.test.fail

class AssemblyBehaviourTest {
    private val failedTestsInfo: MutableMap<String, String> = mutableMapOf()
    enum class FailureType(val cause: String) {
        OUTPUT_MISMATCH("Mismatched output"),
        TIMEOUT("Execution timeout"),
        EXECUTION_FAILURE("Execution failed")
    }

    private val notApplicableCases = setOf(
            "src/test/resources/valid/advanced/ticTacToe.wacc",
            "src/test/resources/valid/mine/varvarvar.wacc",
            "src/test/resources/valid/mine/kata.wacc"
    )

    @Test
    fun assemblyBehaviourBatchTest() {
        var correctCount = 0
        var totalCount = 0
        File("src/test/resources/valid/").walkTopDown()
                .filter { it.path.endsWith(".wacc") }
                .filterNot { it in excludedFiles() }
                .forEach { testFile ->
            println("Current file $testFile")
            try {
                val emulator = CompilerEmulator(testFile, EXECUTE)
                val inputData = requiresInput(testFile.nameWithoutExtension)
                val result = emulator.run(inputData)
                val expectedResult = RefCompiler.getRefCompilerOutput(testFile, inputData)
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
            fail()
        }
    }


    private fun logFailedTest(testFile: File, cause: FailureType) = failedTestsInfo.set(testFile.path, cause.cause)

    private fun requiresInput(filename: String): List<String> {
        val inputFile = File("src/test/resources/inputs/${filename}.txt")
        if (!inputFile.exists()) {
            return emptyList()
        }
        return inputFile.readLines()
    }
}