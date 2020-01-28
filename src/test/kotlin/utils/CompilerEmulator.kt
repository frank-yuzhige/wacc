package utils

import exceptions.SemanticException
import exceptions.SyntacticException
import parser.Parser
import java.io.File
import java.io.PrintStream
import java.lang.Exception

class CompilerEmulator(private val inputFile: File, private val errorStream: PrintStream) {
    fun getExitCode(): Int {
        val parser = Parser(inputFile.inputStream(), errorStream = errorStream)
        try {
            parser.parseProgram()
        } catch (sye: SyntacticException) {
            System.err.println("PARSE ERROR: ${inputFile.path}")
            return 100  //100 as parse error exit code
        } catch (sme: SemanticException) {
            System.err.println("SEM ERROR: ${inputFile.path}")
            return 200 // 200 as semantic error exit code
        } catch (e: Exception) {
            System.err.println("FATAL ERROR: ${inputFile.path}")
            System.err.println("A non-syntactic, non-semantic exception was thrown!")
            System.err.println(e.message)
            System.err.println(e.stackTrace)
            return 1 //  error output
        }
        println("ALL IS GOOD: ${inputFile.path}")
        return 0
    }
}