package extension

import codegen.AstToRawArmConverter
import codegen.RegisterAllocator
import optimizers.ArmOptimizer
import optimizers.AstOptimizer
import parser.Parser
import semantics.SemanticAnalyzer
import utils.NullOutputStream
import utils.RefCompiler
import utils.RefCompiler.*
import utils.cleanUp
import utils.excludedFiles
import java.io.File
import java.io.PrintStream
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import kotlin.test.Test
import kotlin.test.fail

class OptimizationBehaviourTest {
    private val failedTestsInfo: MutableMap<String, String> = mutableMapOf()

    @Test
    fun constantFoldingTest() = runAllTests(0)

    @Test
    fun constantPropagationTest() = runAllTests(1)

    @Test
    fun peepholeOptimizationTest() = runAllTests(2)

    private fun runAllTests(optLevel: Int) {
        var correctCount = 0
        var totalCount = 0
        File("src/test/resources/valid/").walkTopDown()
                .filter { it.extension == "wacc" }
                .filterNot { it in excludedFiles() }
                .forEach { testFile ->
                    val loggedFile: File = testFile.relativeTo(File("src/test/resources/valid/"))
                    println("Current file $testFile")
                    try {
                        val emulator = OptimizationEmulator(testFile, optLevel)
                        val inputData = requiresInput(testFile.nameWithoutExtension)
                        val result = emulator.run(inputData)
                        val expectedResult: RefCompilerOutput = RefCompiler.getRefCompilerOutput(testFile, inputData)
                        if (result.output != expectedResult.output || result.exitCode != expectedResult.exitCode) {
                            logFailedTest(loggedFile, "mismatched output")
                            println("Mismatched output: ${loggedFile.path}")
                        } else {
                            correctCount++
                            println("All is good: ${loggedFile.path}")
                        }
                    } catch (e: Throwable) {
                        if (e is TimeoutException) {
                            logFailedTest(loggedFile, "Time out")
                            println("Timeout: ${loggedFile.path}")
                        } else {
                            logFailedTest(loggedFile, "Execution Failure")
                            println("Execution failed: ${loggedFile.path}")
                        }
                    } finally {
                        totalCount++
                    }
                }
        cleanUp()
        println("\n\nTest passed: $correctCount/$totalCount")
        if (correctCount < totalCount){
            var errorMsg = ""
            failedTestsInfo.forEach { (file, cause) -> errorMsg += "$file: $cause\n" }
            println(errorMsg)
            fail()
        }
    }

    private fun logFailedTest(testFile: File, cause: String) = failedTestsInfo.set(testFile.path, cause)

    class OptimizationEmulator(private val file: File, private val optLevel: Int = -1) {
        data class EmulatorResult(val output: String, val exitCode: Int)

        fun run(inputData: List<String> = emptyList()): EmulatorResult {
            val parser = Parser(file.inputStream(), errorStream = PrintStream(NullOutputStream()))
            val sa = SemanticAnalyzer()
            var ast = parser.parseProgram()
            sa.suppressWarning().doCheck(ast)
            /*
             * Since we know the file has to be syntactically and semantically correct,
             * we do not need to do semantic analysis
             */
            if (optLevel > 0) {
                val astOptimizer = AstOptimizer(optLevel)
                ast = astOptimizer.doOptimize(ast)
            }
            val arm = AstToRawArmConverter(ast, sa.symbolTable).translate().export()
            var betterArm = RegisterAllocator(arm).run()
            if (optLevel > 1) {
                val armOptimizer = ArmOptimizer()
                betterArm = armOptimizer.doOptimize(betterArm)
            }
            val assembly = betterArm.toString()
            val outputFile = File("src/test/kotlin/utils/temp.s")
            if (!outputFile.exists()) {
                outputFile.createNewFile()
            }

            outputFile.bufferedWriter().use { it.write(assembly + "\n") }
            val command = "ruby refEmulate ${outputFile.path} ${inputData.joinToString()}"
            val process = Runtime.getRuntime().exec(command)

            var programOutput = ""
            process.inputStream.reader(Charsets.UTF_8).use {
                programOutput += it.readText()
            }

            if (!process.waitFor(3, TimeUnit.SECONDS)) {
                process.destroy()
                throw TimeoutException("Program timed out!")
            }

            val pureOutputPattern = """Emulation Output:\n([\s\S]*)-{63}""".toRegex()
            val matchResult: MatchResult? = pureOutputPattern.find(programOutput)
            var resultString: String? = null
            if (matchResult != null) {
                val addressRegex = """0x\w{5,8}""".toRegex()
                resultString = matchResult.groups[1]!!.value.replace(addressRegex, "0x*****")
            }
            val exitCodeRegex = """exit code is: (\d+)""".toRegex()
            val exitCodeMatchResult = exitCodeRegex.find(programOutput)
            return EmulatorResult(resultString ?: "", exitCodeMatchResult!!.groups[1]!!.value.toInt())
        }
    }
    private fun requiresInput(filename: String): List<String> {
        val inputFile = File("src/test/resources/inputs/${filename}.txt")
        if (!inputFile.exists()) {
            return emptyList()
        }
        return inputFile.readLines()
    }
}