package parser

import antlr.WaccParser.*
import ast.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.Type.*
import ast.Type.BaseType.*
import org.antlr.v4.runtime.ParserRuleContext
import kotlin.IllegalArgumentException
import kotlin.concurrent.thread

fun ProgContext.toAST() : ProgramAST =
        ProgramAST(this.func().map { it.toAST() }, this.stats().toMainProgramAST())

private fun FuncContext.toAST(): Function {
    return Function(this.type().toAST(), this.ident().text, this.paramList().toAST(), this.stats().toAST())
}

private fun TypeContext.toAST(): Type {
    return when {
        this.baseType() != null -> this.baseType().toAST()
        this.arrayType() != null -> this.arrayType().toAST()
        this.pairType() != null -> this.pairType().toAST()
        else -> throw IllegalArgumentException("Unrecognized type: ${this.text}")
    }
}

private fun BaseTypeContext.toAST() : BaseType = when (this.text) {
    "int" -> IntType
    "char" -> CharType
    "bool" -> BoolType
    "string" -> StringType
    else -> throw IllegalArgumentException("Unknown base type: ${this.text}")
}

private fun ArrayTypeContext.toAST(): ArrayType {
    val dimension = this.LBRA().size
    var tau = ArrayType(when {
        this.baseType() != null -> this.baseType().toAST()
        this.pairType() != null -> this.pairType().toAST()
        else -> throw IllegalArgumentException("Unsupported array type: ${this.text}")
    })
    for (i in 1 until dimension) {
        tau = ArrayType(tau)
    }
    return tau
}

private fun PairTypeContext.toAST(): PairType {
    fun pairElemToAST(context : PairElemTypeContext): PairElemType = when {
        context.baseType() != null -> context.baseType().toAST()
        context.arrayType() != null -> context.arrayType().toAST()
        else -> PairBaseType
    }
    return PairType(pairElemToAST(this.pairElemType(0)), pairElemToAST(this.pairElemType(1)))
}

private fun ParamListContext.toAST() : List<Parameter> = this.param().map { it.toAST() }

private fun ParamContext.toAST(): Pair<String, Type> = Pair(this.ident().text, this.type().toAST())

private fun StatsContext.toAST() : Statements = this.stat().map { it.toAST() }

private fun StatsContext.toMainProgramAST(): Statements {
    TODO()
}

private fun StatContext.toAST(): Statement = when(this) {
    is SkipContext -> Skip
    is DeclarationContext -> Declaration(this.type().toAST(), this.ident().toAST(), this.assignRhs().toAST())
    is AssignmentContext -> Assignment(this.assignLhs().toAST(), this.assignRhs().toAST())
    is ReadCallContext -> Read(this.assignLhs().toAST())
    is BuiltinFuncCallContext
        -> BuiltinFuncCall(BuiltinFunc.valueOf(this.builtinFunc().toString()), this.expr().toAST())
    is CondBranchContext -> CondBranch(this.expr().toAST(), this.stats(0).toAST(), this.stats(1).toAST())
    is WhileLoopContext -> WhileLoop(this.expr().toAST(), this.stats().toAST())
    is BlockContext -> Block(this.stats().toAST())
    else -> throw IllegalArgumentException("Invalid statement found: $this")
}

private fun AssignLhsContext.toAST(): Expression = when {
    this.ident() != null -> this.ident().toAST()
    this.arrayElem() != null -> this.arrayElem().toAST()
    this.pairElem() != null -> this.pairElem().toAST()
    else -> throw IllegalArgumentException("Unknown left value")
}

private fun AssignRhsContext.toAST(): Expression = when(this) {
    is RhsExprContext -> this.expr().toAST()
    is RhsArrayLiterContext -> this.arrayLiter().toAST()
    is RhsPairElemContext -> this.pairElem().toAST()
    is RhsNewPairContext -> NewPair(this.expr(0).toAST(), this.expr(1).toAST())
    is RhsFuncCallContext -> FunctionCall(this.ident().toString(), this.argList().toAST())
    else -> throw IllegalArgumentException("Unknown right value")
}

private fun ArgListContext.toAST(): List<Expression> = this.expr().map { it.toAST() }

private fun ArrayLiterContext.toAST(): Expression = ArrayLiteral(this.argList().toAST())

private fun PairElemContext.toAST() : Expression =
        PairElem(PairElemFunction.valueOf(this.pairElemFunc().toString())
                , this.expr().toAST())

private fun ArrayElemContext.toAST() : Expression =
        ArrayElem(this.ident().text, this.expr().map { it.toAST() })

private fun IdentContext.toAST(): Identifier = Identifier(this.IDENT().toString())

private fun ExprContext.toAST(): Expression = when (this) {
//    is ExprBinopContext -> BinOp()
    is ExprNullContext    -> NullLit
    is ExprIntContext     -> this.integer().toAST()
    is ExprIdentContext   -> Identifier(this.ident().toString())
    is ExprBoolContext    -> BoolLit(this.boolLit().TRUE() != null)
    is ExprParensContext  -> this.expr().toAST()
    is ExprUnaryopContext -> UnaryOp(this.unaryOp().toAST(), this.expr().toAST())
//    is ExprBinopContext -> BinOp(, BinaryOperator(this.getBinopSign()), )
    else -> throw IllegalArgumentException("")
}

private fun ExprBinopContext.getBinop(): BinaryOperator {
    return BinaryOperator.valueOf(
            listOfNotNull(this.binop1(), this.binop2(), this.binop3(), this.binop4(), this.binop5())
                    .map { it[0] }[0]
                    .toString())
}

private fun UnaryOpContext.toAST(): UnaryOperator {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

private fun IntegerContext.toAST(): Expression = IntLit((this.intsign().toString() + this.INTEGER().toString()).toInt())

private fun<A, B, R> chainl(base : R, listA : Iterable<A>, listB : Iterable<B>, chainFunction: (R, A, B) -> R) : R =
        listA.zip(listB).fold(base) { r, p -> chainFunction(r, p.first, p.second) }
