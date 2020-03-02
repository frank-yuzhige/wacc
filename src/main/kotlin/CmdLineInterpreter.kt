import codegen.AstToRawArmConverter
import codegen.RegisterAllocator
import exceptions.SemanticException
import exceptions.SyntacticException
import optimizers.ArmOptimizer
import optimizers.AstOptimizer
import optimizers.OptimizationOption
import parser.Parser
import semantics.SemanticAnalyzer
import utils.ERROR
import utils.RESET
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var debug = false
    var optLevel: Int = -1
    val flags = args.filter { it.startsWith("-") }
    flags.forEach{ flag ->
        when {
            flag.startsWith("-o") && flag.last().isDigit() -> {
                optLevel = flag.last().toString().toInt()
                println("** SYSTEM: OPTIMIZE WITH ${OptimizationOption.values()[optLevel!!].label} **")
            }
            flag == "-d" -> {
                println("** SYSTEM: DEBUG MODE ACTIVATED **")
                debug = true
            }
            else -> throw UnsupportedOperationException("Unknown flag \"$flag\"!")
        }
    }

    val filePath = args.getOrNull(flags.size)
            ?: throw FileNotFoundException("Empty file path!")
    val inputStream = try {
        FileInputStream(filePath)
    } catch (fnfe: FileNotFoundException) {
        println("File not found!")
        println("Unable to locate file at $filePath")
        exitProcess(1)
    }

    val sa = SemanticAnalyzer()
    var ast = try {
        Parser(inputStream).parseProgram()
                .also { sa.suppressWarning().doCheck(it) }
    } catch (pe: SyntacticException) {
        System.err.println("${ERROR}PARSE ERROR:")
        System.err.println("${pe.msg}$RESET")
        exitProcess(100)
    } catch (se: SemanticException) {
        System.err.println("${ERROR}SEMANTIC ERROR:")
        System.err.println("${se.msg}$RESET")
        exitProcess(200)
    }
    val asmPath = if (debug) {
        "src/test/resources/valid/mine/gen.s"
    } else {
        File(filePath).nameWithoutExtension + ".s"
    }

    println("===========")
    println(ast.prettyPrint())
    sa.symbolTable.dump()
    println("===========")
    if (optLevel >= 0) {
        val astOptimizer = AstOptimizer(OptimizationOption.values()[optLevel])
        ast = astOptimizer.doOptimize(ast)
    }
    var arm = AstToRawArmConverter(ast, sa.symbolTable).translate().export()
    println(arm)
    if (optLevel > 1) {
        val armOptimizer = ArmOptimizer(OptimizationOption.values()[optLevel])
        arm = armOptimizer.doOptimize(arm)
        println("\n=== Code After Dead Code Elimination ===")
        println(arm.toString())
    }
    println("\n=== Improved ARM ===")
    val betterArm = RegisterAllocator(arm).run()
    if (debug) {
        println("=== Improved ARM ===")
        println(betterArm)
    }
    val output = File(asmPath)
    output.writeText(betterArm.toString())

    println("Compilation Finished!")
}