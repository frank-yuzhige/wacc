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
import java.math.RoundingMode
import kotlin.math.round
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var debug = false
    var optLevel: Int = -1
    var mode: CompilerMode = CompilerMode.EMIT

    val flags = args.filter { it.startsWith("-") }
    flags.forEach{ flag ->
        when {
            flag.startsWith("-o") && flag.last().isDigit() -> {
                optLevel = flag.last().toString().toInt()
                println("** SYSTEM: OPTIMIZE WITH ${OptimizationOption.values()[optLevel].label} **")
            }
            else -> when (flag) {
                "-p" -> {
                    println("** PARSE ONLY **")
                    mode = CompilerMode.PARSE_ONLY
                }
                "-s" ->{
                    println("** SEM CHECK ONLY **")
                    mode = CompilerMode.SEM_CHECK
                }
                "-d" -> {
                    println("** SYSTEM: DEBUG MODE ACTIVATED **")
                    debug = true
                }
                else -> throw UnsupportedOperationException("Unknown flag \"$flag\"!")
            }
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
        val parseOnlyAst = Parser(inputStream).parseProgram()
        if (mode == CompilerMode.PARSE_ONLY) {
            println(parseOnlyAst.prettyPrint())
            exitProcess(0)
        }
        sa.suppressWarning().doCheck(parseOnlyAst)
        if (mode == CompilerMode.SEM_CHECK) {
            println(parseOnlyAst.prettyPrint())
            sa.symbolTable.dump()
            exitProcess(0)
        }
        parseOnlyAst
    } catch (pe: SyntacticException) {
        System.err.println("${ERROR}PARSE ERROR:")
        System.err.println("${pe.msg}$RESET")
        exitProcess(100)
    } catch (se: SemanticException) {
        System.err.println("${ERROR}SEMANTIC ERROR:")
        System.err.println("${se.msg}$RESET")
        sa.symbolTable.dump()
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
    var originalAst = ast.copy()
    if (optLevel >= 0) {
        val astOptimizer = AstOptimizer(OptimizationOption.values()[optLevel])
        ast = astOptimizer.doOptimize(ast)
    }
    val arm = AstToRawArmConverter(ast, sa.symbolTable).translate().export()
    var betterArm = RegisterAllocator(arm).run()
    println("=== Improved ARM ===")
    println(betterArm.printWithIndex())
    if (optLevel > 1) {
        val armOptimizer = ArmOptimizer()
        betterArm = armOptimizer.doOptimize(betterArm)
        println("\n=== Code After Peephole Optimization ===")
        println(betterArm.printWithIndex())
    }
    if (optLevel >= 0) {
        var originalArm = AstToRawArmConverter(originalAst, sa.symbolTable).translate().export()
        originalArm = RegisterAllocator(originalArm).run()
        val originalLineCount = originalArm.blocks.foldRight(0, {
            block, total -> block.getInstrCount() + total
        })
        val optimizedLineCount = betterArm.blocks.foldRight(0, {
            block, total -> block.getInstrCount() + total
        })
        val lineReductionCount = originalLineCount - optimizedLineCount
        println("Reduced a total of $lineReductionCount lines of code")
        println("Optimization rate:" + "${(lineReductionCount / originalLineCount.toDouble())
                .toBigDecimal().setScale(3, RoundingMode.HALF_EVEN)}")
    }
    val output = File(asmPath)
    output.writeText(betterArm.toString())

    println("Compilation Finished!")
}