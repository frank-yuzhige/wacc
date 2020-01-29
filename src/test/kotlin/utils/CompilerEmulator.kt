package utils

import ast.ProgramAST
import ast.WaccAST
import exceptions.SemanticException
import exceptions.SyntacticException
import parser.Parser
import java.io.File
import java.io.PrintStream
import java.lang.Exception

class CompilerEmulator(private val inputFile: File, private val errorStream: PrintStream = PrintStream(NullOutputStream())) {

    class EmulatorResult(val exitCode: Int, val ast: WaccAST?, val exception: Exception?)

    fun run(): EmulatorResult {
        val parser = Parser(inputFile.inputStream(), errorStream = errorStream)
        var exitCode = 0
        var exception: Exception? = null
        val ast = try {
            val temp = parser.parseProgram()
            println("ALL IS GOOD: ${inputFile.path}")
            temp
        } catch (sye: SyntacticException) {
            System.err.println("PARSE ERROR: ${inputFile.path}")
            exception = sye
            exitCode = 100
            null
        } catch (sme: SemanticException) {
            System.err.println("SEM ERROR: ${inputFile.path}")
            exception =sme
            exitCode = 200 // 200 as semantic error exit code
            null
        } catch (e: Exception) {
            System.err.println("FATAL ERROR: ${inputFile.path}")
            System.err.println("A non-syntactic, non-semantic exception was thrown!")
            System.err.println(e.message)
            System.err.println(e.stackTrace)
            exception = e
            exitCode = 1 //  error output
            null
        }
        return EmulatorResult(exitCode, ast, exception)
    }

}