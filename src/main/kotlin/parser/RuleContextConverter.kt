package parser

import antlr.WaccParser.*
import ast.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.Type.*
import ast.Type.Companion.anyPairType
import exceptions.SemanticException.ReturnInMainProgramException
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.Interval
import exceptions.SyntacticException
import exceptions.SyntacticException.*
import utils.*
import utils.AstIndexMap
import utils.EscapeCharConverter
import utils.Index
import utils.Parameter
import java.util.*

class RuleContextConverter(val astIndexMap: AstIndexMap) {
    private val stack: Deque<ParserRuleContext> = ArrayDeque()
    private var errorList: MutableList<SyntacticException> = mutableListOf()

    fun convertProgram(program: ProgContext): ProgramAST = program.toAST()
    fun convertFunction(function: FuncContext): Function = function.toAST()
    fun convertStatement(statement: StatContext): Statement = statement.toAST()
    fun convertExpression(expression: ExprContext): Expression = expression.toAST()

    /** ParserRuleContext Extension methods **/

    fun ProgContext.toAST() : ProgramAST {
        stack.push(this)
        val programAST = ProgramAST(func().map { it.toAST() }, stats()?.toMainProgramAST()
            ?: throw SyntacticExceptionBundle(listOf(EmptyMainProgramException()))) record index()
        stack.pop()
        return programAST
    }

    private fun StatsContext.toMainProgramAST(): List<Statement> {
        val returnIndices = containsReturn(this)
        if (returnIndices.isNotEmpty()) {
            throw ReturnInMainProgramException(returnIndices)
        }
        val result = this.toAST()
        /** IF ERROR LIST IS NOT EMPTY, THROW ERROR INSTEAD OF RETURN **/
        if (errorList.isNotEmpty()) {
            throw SyntacticExceptionBundle(errorList)
        }
        return result
    }

    private fun StatsContext.toFuncBodyAST(): Statements {
        fun StatContext.isTerminator(): Boolean = when(this) {
            is BuiltinFuncCallContext ->
                this.builtinFunc().EXIT() != null || this.builtinFunc().RETURN() != null
            is CondBranchContext ->
                this.stats().all { it.stat().last()?.isTerminator()?: false }
            else -> false
        }

        if (!this.stat().last().isTerminator()) {
            logError(LastStatIsNotTerminatorException())
        }
        return this.toAST()
    }

    fun FuncContext.toAST(): Function {
        stack.push(this)
        val result = Function(type().toAST(), ident().text,
                paramList()?.toAST()?: emptyList(),
                stats().toFuncBodyAST()) record index()
        stack.pop()
        return result
    }

    private fun ParserRuleContext.originalText(): String {
        val start = this.start.startIndex
        val stop = this.stop.stopIndex
        val input = this.start.inputStream
        return if(start < stop) {
            input.getText(Interval(start, stop))
        } else {
            "**NOT AVAILABLE**"
        }
    }

    /** Types **/

    private fun TypeContext.toAST(): Type = when {
        baseType() != null -> baseType().toAST()
        arrayType() != null -> arrayType().toAST()
        pairType() != null -> pairType().toAST()
        else -> throw IllegalArgumentException("Unrecognized type: $text")
    }

    private fun BaseTypeContext.toAST() : BaseType = when (text) {
        "int"    -> BaseType(BaseTypeKind.INT)
        "char"   -> BaseType(BaseTypeKind.CHAR)
        "bool"   -> BaseType(BaseTypeKind.BOOL)
        "string" -> BaseType(BaseTypeKind.STRING)
        else -> throw IllegalArgumentException("Unknown base type: $text")
    }

    private fun ArrayTypeContext.toAST(): ArrayType {
        val dimension = LBRA().size
        var tau = ArrayType(when {
            baseType() != null -> baseType().toAST()
            pairType() != null -> pairType().toAST()
            else -> {
                logError(UnsupportedArrayBaseTypeException(this.text))
                BaseType(BaseTypeKind.ANY)
            }
        })
        for (i in 1 until dimension) {
            tau = ArrayType(tau)
        }
        return tau
    }

    private fun PairTypeContext.toAST(): PairType {
        fun pairElemTypeToAST(context : PairElemTypeContext): Type = when {
            context.baseType() != null -> context.baseType().toAST()
            context.arrayType() != null -> context.arrayType().toAST()
            else -> anyPairType()
        }
        return PairType(pairElemTypeToAST(first), pairElemTypeToAST(second))
    }

    /** Statements **/

    private fun ParamListContext.toAST() : List<Parameter> = param().map { it.toAST() }

    private fun ParamContext.toAST(): Pair<String, Type> = Pair(ident().text, type().toAST())

    private fun StatsContext.toAST() : Statements {
        return stat().map { it.toAST() }
    }

    fun StatContext.toAST(): Statement {
        stack.push(this)
        val result = when(this) {
            is SkipContext -> Skip
            is DeclarationContext -> Declaration(type().toAST(), ident().toAST(), assignRhs().toAST())
            is AssignmentContext -> Assignment(assignLhs().toAST(), assignRhs().toAST())
            is ReadCallContext -> Read(assignLhs().toAST())
            is BuiltinFuncCallContext
            -> BuiltinFuncCall(BuiltinFunc.valueOf(builtinFunc().text.toUpperCase()), expr().toAST())
            is CondBranchContext -> CondBranch(expr().toAST(), stats(0).toAST(), stats(1).toAST())
            is WhileLoopContext -> WhileLoop(expr().toAST(), stats().toAST())
            is BlockContext -> Block(stats().toAST())
            else -> throw IllegalArgumentException("Invalid statement found: ${originalText()}")
        } record index()
        stack.pop()
        return result
    }

    private fun AssignLhsContext.toAST(): Expression = when {
        ident() != null     -> ident().toAST()
        arrayElem() != null -> arrayElem().toAST()
        pairElem() != null  -> pairElem().toAST()
        else                -> throw IllegalArgumentException("Unknown left value")
    } record index()

    private fun AssignRhsContext.toAST(): Expression = when(this) {
        is RhsExprContext       -> expr().toAST()
        is RhsArrayLiterContext -> arrayLiter().toAST()
        is RhsPairElemContext   -> pairElem().toAST()
        is RhsNewPairContext    -> NewPair(expr(0).toAST(), expr(1).toAST())
        is RhsFuncCallContext   -> FunctionCall(ident().text, argList()?.toAST()?: listOf())
        else                    -> throw IllegalArgumentException("Unknown right value")
    } record index()


    fun ExprContext.toAST(): Expression {
        stack.push(this)
        val result = when (this) {
            is ExprNullContext    -> NullLit
            is ExprIntContext     -> integer().toAST()
            is ExprBoolContext    -> BoolLit(boolLit().TRUE() != null)
            is ExprCharContext    -> {
                CharLit(EscapeCharConverter(getContent(CHARLIT().text)).getChar())
            }
            is ExprStringContext  -> StringLit(EscapeCharConverter(getContent(STRLIT().text)).getAll())
            is ExprIdentContext   -> Identifier(ident().text)
            is ExprParensContext  -> expr().toAST().markParens()
            is ExprUnaryopContext -> UnaryExpr(UnaryOperator.read(unaryOp().text), expr().toAST())
            is ExprBinopContext   -> BinExpr(left.toAST(), getBinOp(), right.toAST())
            is ExprArrElemContext -> ArrayElem(arrayElem().ident().text, arrayElem().expr().map { it.toAST() })
            else -> {
                logError(UnknownExprTypeException())
                NullLit
            }
        } record index()
        stack.pop()
        return result
    }

    private fun ArgListContext.toAST(): List<Expression> = expr().map { it.toAST() }

    private fun ArrayLiterContext.toAST(): Expression = ArrayLiteral(argList()?.toAST()?: arrayListOf())

    private fun PairElemContext.toAST() : Expression =
            PairElem(PairElemFunction.valueOf(pairElemFunc().text.toUpperCase()), expr().toAST())

    private fun ArrayElemContext.toAST() : Expression =
            ArrayElem(ident().text, expr().map { it.toAST() })

    private fun IdentContext.toAST(): Identifier = Identifier(IDENT().text) record index()

    private fun IntegerContext.toAST(): Expression = try {
        IntLit(this.text.toInt())
    } catch (e: NumberFormatException) {
        logError(IntegerSyntacticException(this.text))
        NullLit
    }

    private fun ExprBinopContext.getBinOp(): BinaryOperator {
        val opContext = listOfNotNull(binop1(), binop2(), binop3(), binop4(), binop5())[0]
        return BinaryOperator.read(opContext.text)
    }

    private fun containsReturn(context: StatsContext): List<Index> = context.stat().flatMap {
        when (it) {
            is BuiltinFuncCallContext -> if (it.builtinFunc().RETURN() != null) {
                listOf(it.index())
            } else {
                emptyList()
            }
            is CondBranchContext -> it.stats().flatMap(::containsReturn)
            is WhileLoopContext -> containsReturn(it.stats())
            is BlockContext -> containsReturn(it.stats())
            else -> emptyList()
        }
    }

    private fun getContent(quotedString: CharSequence) : CharSequence {
        val len = quotedString.length
        return quotedString.subSequence(1, len - 1)
    }

    infix fun<T : WaccAST> T.record(index: Index): T = this.also { astIndexMap[it] = index }

    private fun ParserRuleContext.index(): Index = this.start.line to this.start.charPositionInLine

    fun<T: Expression> T.markParens(): T = this.also { it.inParens = true }

    private fun logError(error: SyntacticException) {
        for (context in stack) {
            error.forwardWith(context.getErrorString())
        }
        errorList.add(error)
    }

    private fun ParserRuleContext.getErrorString(): String {
        return when (this) {
            is ProgContext -> "In the main program"
            is FuncContext -> {
                val params = paramList()?.param()?.joinToString(", ")
                    { it.originalText() } ?: ""
                val funcDef = "${type().text} ${ident().text} ($params)"
                "In a function defined at ${index()}: $funcDef"
            }
            is StatContext -> "In a statement at ${index()}: \"${originalText()}"
            is ExprContext -> "In a pure expression at ${index()}: \"${originalText()}\""
            else -> throw IllegalArgumentException()
        }
    }
}




