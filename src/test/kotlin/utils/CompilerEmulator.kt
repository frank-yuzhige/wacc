package utils

import ast.WaccAST
import codegen.ASTParserARM
import exceptions.SemanticException
import exceptions.SyntacticException
import parser.Parser
import semantics.SemanticAnalyzer
import utils.EmulatorMode.*
import java.io.*
import java.lang.Exception

class CompilerEmulator(private val inputFile: File,
                       private val mode: EmulatorMode,
                       private val errorStream: PrintStream = PrintStream(NullOutputStream())) {

    class EmulatorResult(val exitCode: Int, val ast: WaccAST?, val exception: Exception?, val output: String?)
    fun run(): EmulatorResult {
        val parser = Parser(inputFile.inputStream(), errorStream = errorStream)
        var exitCode = 0
        var exception: Exception? = null
        val sa = SemanticAnalyzer()
        val ast = try {
            val temp = parser.parseProgram()
            if (mode != PARSE_ONLY) {
                sa.suppressWarning().doCheck(temp)
            }
            println("Compilation completed: ${inputFile.path}")
            temp
        } catch (sye: SyntacticException) {
            System.err.println("PARSE ERROR: ${inputFile.path}")
            exception = sye
            exitCode = 100
            null
        } catch (sme: SemanticException) {
            System.err.println("SEM ERROR: ${inputFile.path}")
            exception = sme
            exitCode = 200 // 200 as semantic error exit code
            null
        } catch (e: Exception) {
            System.err.println("FATAL ERROR: ${inputFile.path}")
            System.err.println("A non-syntactic, non-semantic exception was thrown!")
            System.err.println(e.message)
            System.err.println(e.localizedMessage)
            System.err.println(e.cause)
            e.printStackTrace(System.err)
            exception = e
            exitCode = 1 //  error output
            null
        }
        var programOutput: String? = null
        if (mode == EXECUTE && ast != null) {
            val assembly = ASTParserARM(ast, sa.symbolTable).translate().printARM()
            val temp = File("src/test/kotlin/utils/temp.wacc")
            if (!temp.exists()) {
                temp.createNewFile()
            }
            temp.bufferedWriter().use { it.write(assembly) }
            val process = ProcessBuilder("ruby", "-x", temp.path).start()
            process.inputStream.reader(Charsets.UTF_8).use {
                println(it.readText())
                // TODO turn println into string
            }
            process.waitFor()
        }
        return EmulatorResult(exitCode, ast, exception, programOutput)
    }

}