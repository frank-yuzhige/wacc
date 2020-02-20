package codegen
import utils.CompilerEmulator
import utils.EmulatorMode.*
import java.io.*
import java.util.concurrent.TimeoutException
import kotlin.test.Test

class AssemblyBehaviourTest {
    data class RefCompilerOutput(val output: String, val exitCode: Int)
    private val failedTestsInfo: MutableMap<String, String> = mutableMapOf()
    enum class FailureType(val cause: String) {
        OUTPUT_MISMATCH("Mismatched output"),
        TIMEOUT("Execution timeout"),
        EXECUTION_FAILURE("Execution failed")
    }

    private fun getRefCompilerOutput(file: File, inputData: List<String>): RefCompilerOutput {
        val process = ProcessBuilder("./refCompile", "-x", file.absolutePath).start()
        val writer = BufferedWriter(OutputStreamWriter(process.outputStream))
        if (inputData.isNotEmpty()) {
            for (line in inputData) {
                writer.write(line)
                writer.flush()
            }
        } else {
            writer.newLine()
        }
        writer.close()
        process.waitFor()
        var expectedOutput = ""
        process.inputStream.reader(Charsets.UTF_8).use {
            expectedOutput += it.readText()
        }
        val pureOutputRegex = """={59}\n([\s\S]*)={59}""".toRegex()
        val matchResult: MatchResult? = pureOutputRegex.find(expectedOutput)
        val addressRegex = """0x\w{5,8}""".toRegex()
        var resultString: String? = null
        if (matchResult != null) {
            resultString = matchResult.groups[1]!!.value.replace(addressRegex, "0x*****")
        }
        val exitCodeRegex = """exit code is (\d+)""".toRegex()
        val exitCodeMatchResult = exitCodeRegex.find(expectedOutput)
        return RefCompilerOutput(resultString ?: "", exitCodeMatchResult!!.groups[1]!!.value.toInt())
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
                    val inputData = requiresInput(testFile.nameWithoutExtension)
                    val result = emulator.run(inputData)
                    val expectedResult = getRefCompilerOutput(testFile, inputData)
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
        println("\n\nTest passed: $correctCount/$totalCount")
        if (correctCount < totalCount) {
            var errorMsg = ""
            failedTestsInfo.forEach {(file, cause) -> errorMsg += "$file: $cause\n"}
            println(errorMsg)
        }
    }

    @Test
    fun inputBehaviourSingularTest() {
        var testFile = File("src/test/resources/valid/while/fibonacciFullIt.wacc")
        println("File is found ${testFile.exists()}")
        try {
            val emulator = CompilerEmulator(testFile, EXECUTE)
            val inputData = requiresInput(testFile.nameWithoutExtension)
            val result = emulator.run(inputData)
            val expectedResult = getRefCompilerOutput(testFile, inputData)
            if (result.output != expectedResult.output || result.exitCode != expectedResult.exitCode) {
                logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                        FailureType.OUTPUT_MISMATCH)
                println("Mismatched output: ${testFile.path}")
            } else {
                println("All is good: ${testFile.path}")
            }
        } catch (e: Throwable) {
            if (e is TimeoutException) {
                logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                        FailureType.TIMEOUT)
                println("Timeout: ${testFile.path}")
            } else {
                println("===================================")
                println(e.message)
                logFailedTest(testFile.relativeTo(File("src/test/resources/valid/")),
                        FailureType.EXECUTION_FAILURE)
                println("Execution failed: ${testFile.path}")
            }
        } finally {
        }
    }

    private fun logFailedTest(testFile: File, cause: FailureType) = failedTestsInfo.set(testFile.path, cause.cause)

    private fun cleanUp() {
        val tempFiles: List<File> = listOf(File("src/test/kotlin/utils/temp"),
                File("src/test/kotlin/utils/temp.s"))
        tempFiles.forEach {
            if (it.exists()) { it.delete() }
        }
    }

    private fun requiresInput(filename: String): List<String> {
        val inputFile = File("src/test/resources/inputs/${filename}.txt")
        if (!inputFile.exists()) {
            return emptyList()
        }
        return inputFile.readLines()
    }

    private fun executableWriteInput(process: Process, data: List<String>) {
        val writer = OutputStreamWriter(process.outputStream, "UTF-8")
        if (data.isNotEmpty()) {
            for (line in data) {
                writer.write(line)
                writer.flush()
            }
        } else {
            writer.write("")
            writer.flush()
        }
    }

    private fun getInputPath(filename: String): String {
        val inputFile = File("src/test/resources/inputs/${filename}.txt")
        if (inputFile.exists()) {
            return inputFile.absolutePath
        }
        return ""
    }
}