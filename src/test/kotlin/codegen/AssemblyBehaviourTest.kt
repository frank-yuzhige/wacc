package codegen

import utils.CompilerEmulator
import utils.EmulatorMode
import utils.EmulatorMode.*
import java.io.File
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
        File("src/test/resources/valid/if").walkTopDown().forEach { testFile ->
            if (testFile.path.endsWith(".wacc") && !testFile.path.contains("IO")) {
                println("Current file $testFile")
                try {
                    val emulator = CompilerEmulator(testFile, EXECUTE)
                    val result = emulator.run()
                    val expectedResult = getRefCompilerOutput(testFile)
                    if (result.output != expectedResult.output || result.exitCode != expectedResult.exitCode) {
                        correctCount++
                        println("Mismatched output: ${testFile.path}")
                    } else {
                        println("All is good: ${testFile.path}")
                    }
                } catch (e: Throwable) {
                    println("Failed to compile: ${testFile.path}")
                } finally {
                    totalCount++
                }
            }
        }
        println("Test passed: $correctCount/$totalCount")
    }
}