package parser

import antlr.WaccParser.*
import ast.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.Type.*
import ast.Type.BaseType.*
import kotlin.IllegalArgumentException
import org.antlr.v4.runtime.ParserRuleContext
import parser.exceptions.ParseException
import parser.exceptions.ParseException.IntegerParseException
import parser.exceptions.ParseException.UnsupportedArrayBaseTypeException
import java.lang.NumberFormatException

fun ProgContext.toAST() : ProgramAST =
        ProgramAST(func().map { it.toAST() }, stats().toAST()) record index()

fun FuncContext.toAST(): Function = try {
        Function(type().toAST(), ident().text,
                paramList()?.toAST()?: emptyList(),
                stats().toAST()) record index()
} catch (pe : ParseException) {
    val params = paramList()?.param()?.joinToString("") { it.text } ?: ""
    val funcDef = "${type().text} ${ident().text} ($params)"
    throw pe.forwardWith("In a function defined at ${index()}: $funcDef")
}

/** Types **/

private fun TypeContext.toAST(): Type = when {
    baseType() != null -> baseType().toAST()
    arrayType() != null -> arrayType().toAST()
    pairType() != null -> pairType().toAST()
    else -> throw IllegalArgumentException("Unrecognized type: $text")
}

private fun BaseTypeContext.toAST() : BaseType = when (text) {
    "int"    -> IntType
    "char"   -> CharType
    "bool"   -> BoolType
    "string" -> StringType
    else -> throw IllegalArgumentException("Unknown base type: $text")
}

private fun ArrayTypeContext.toAST(): ArrayType {
    val dimension = LBRA().size
    var tau = ArrayType(when {
        baseType() != null -> baseType().toAST()
        pairType() != null -> pairType().toAST()
        else -> throw UnsupportedArrayBaseTypeException(this.text)
    })
    for (i in 1 until dimension) {
        tau = ArrayType(tau)
    }
    return tau
}

private fun PairTypeContext.toAST(): PairType {
    fun pairElemTypeToAST(context : PairElemTypeContext): PairElemType = when {
        context.baseType() != null -> context.baseType().toAST()
        context.arrayType() != null -> context.arrayType().toAST()
        else -> PairBaseType
    }
    return PairType(pairElemTypeToAST(first), pairElemTypeToAST(second))
}

/** Statements **/

private fun ParamListContext.toAST() : List<Parameter> = param().map { it.toAST() }

private fun ParamContext.toAST(): Pair<String, Type> = Pair(ident().text, type().toAST())

private fun StatsContext.toAST() : Statements = stat().map { it.toAST() }

fun StatContext.toAST(): Statement = try {
    when(this) {
        is SkipContext -> Skip
        is DeclarationContext -> Declaration(type().toAST(), ident().toAST(), assignRhs().toAST())
        is AssignmentContext -> Assignment(assignLhs().toAST(), assignRhs().toAST())
        is ReadCallContext -> Read(assignLhs().toAST())
        is BuiltinFuncCallContext
        -> BuiltinFuncCall(BuiltinFunc.valueOf(builtinFunc().text.toUpperCase()), expr().toAST())
        is CondBranchContext -> CondBranch(expr().toAST(), stats(0).toAST(), stats(1).toAST())
        is WhileLoopContext -> WhileLoop(expr().toAST(), stats().toAST())
        is BlockContext -> Block(stats().toAST())
        else -> throw IllegalArgumentException("Invalid statement found: $this")
    } record index()
} catch (pe: ParseException) {
    throw pe.forwardWith("In a statement at ${index()}: \"$text\"")
}


private fun AssignLhsContext.toAST(): Expression = when {
    ident() != null     -> ident().toAST()
    arrayElem() != null -> arrayElem().toAST()
    pairElem() != null  -> pairElem().toAST()
    else                -> throw IllegalArgumentException("Unknown left value")
} record index()

private fun AssignRhsContext.toAST(): Expression =
    when(this) {
        is RhsExprContext       -> expr().toAST()
        is RhsArrayLiterContext -> arrayLiter().toAST()
        is RhsPairElemContext   -> pairElem().toAST()
        is RhsNewPairContext    -> NewPair(expr(0).toAST(), expr(1).toAST())
        is RhsFuncCallContext   -> FunctionCall(ident().text, argList()?.toAST()?: listOf())
        else                    -> throw IllegalArgumentException("Unknown right value")
    } record index()


fun ExprContext.toAST(): Expression = try {
    when (this) {
        is ExprNullContext    -> NullLit
        is ExprIntContext     -> integer().toAST()
        is ExprBoolContext    -> BoolLit(boolLit().TRUE() != null)
        is ExprCharContext    -> {
            CharLit(EscapeCharConverter(getContent(CHARLIT().text)).getChar())
        }
        is ExprStringContext  -> StringLit(EscapeCharConverter(getContent(STRLIT().text)).getAll())
        is ExprIdentContext   -> Identifier(ident().text)
        is ExprParensContext  -> expr().toAST()
        is ExprUnaryopContext -> UnaryExpr(UnaryOperator.read(unaryOp().text), expr().toAST())
        is ExprBinopContext   -> BinExpr(left.toAST(), getBinOp(), right.toAST())
        is ExprArrElemContext -> ArrayElem(arrayElem().ident().text, arrayElem().expr().map { it.toAST() })
        else -> throw IllegalArgumentException("Unknown expression context! $javaClass")
    } record index()
} catch (pe: ParseException) {
    throw pe.forwardWith("In a pure expression at ${index()}: \"$text\"")
}

private fun ArgListContext.toAST(): List<Expression> = expr().map { it.toAST() }

private fun ArrayLiterContext.toAST(): Expression = ArrayLiteral(argList()?.toAST()?: arrayListOf())

private fun PairElemContext.toAST() : Expression =
        PairElem(PairElemFunction.valueOf(pairElemFunc().text.toUpperCase())
                , expr().toAST())

private fun ArrayElemContext.toAST() : Expression =
        ArrayElem(ident().text, expr().map { it.toAST() })

private fun IdentContext.toAST(): Identifier = Identifier(IDENT().text) record index()

private fun IntegerContext.toAST(): Expression = try {
    IntLit(this.text.toInt())
} catch (e: NumberFormatException) {
    throw IntegerParseException(this.text).at(index())
}

private fun ExprBinopContext.getBinOp(): BinaryOperator {
    val opContext = listOfNotNull(binop1(), binop2(), binop3(), binop4(), binop5())[0]
    return BinaryOperator.read(opContext.text)
}

private fun getContent(quotedString: CharSequence) : CharSequence {
    val len = quotedString.length
    return quotedString.subSequence(1, len - 1)
}

infix fun<T : WaccAST> T.record(index: Pair<Int, Int>): T {
    AstIndexMap.map[this] = index
    return this
}

private fun ParserRuleContext.index(): Pair<Int, Int> = this.start.line to this.start.charPositionInLine

private fun<T, R> chainl(base : R, elems : Iterable<T>, nodes : Iterable<R>, chainFunction: (R, T, R) -> R) : R =
        elems.zip(nodes).fold(base) { r, p -> chainFunction(r, p.first, p.second) }

