package optimizers

import ast.*
import ast.BinaryOperator.*
import ast.Expression.*
import ast.Expression.PairElemFunction.*
import ast.Function
import ast.Statement.*
import ast.UnaryOperator.*
import utils.Statements
import java.lang.IllegalArgumentException

class AstOptimizer(option: OptimizationOption) {
    private val optLevel = OptimizationOption.values().indexOf(option)
    private val programState = ProgramState()
    private var updateVar: Boolean = true
    private var overflowOccurred = false

    fun doOptimize(ast: ProgramAST): ProgramAST {
        if (optLevel > 0) {
            var currAst = ast
            var preAst: ProgramAST
            do {
                preAst = currAst
                currAst = currAst.optimize()
                println(currAst.prettyPrint())
            } while (preAst != currAst)
            return currAst
        }
        return ast.optimize()
    }

    private fun ProgramAST.optimize(): ProgramAST =
        ProgramAST(newTypes, traits, instances, functions.map { it.optimize() }, mainProgram.optimize())

    private fun Function.optimize(): Function =
            inScopeDo { Function(returnType, name, args, typeConstraints, body.map { it.optimize() }) } as Function

    private fun Statements.optimize(): Statements {
        programState.enterScope()
        val newStats = this.map { it.optimize() }
        programState.exitScope()
        return newStats
    }

    private fun Statement.optimize(): Statement = when (this) {
        Skip -> Skip
        is Declaration -> {
            val rhsOptimized = rhs.optimize()
            if (optLevel > 0 && rhsOptimized is Literal) {
                programState.defineVarInCurrentScope(variable, rhsOptimized)
                if (rhsOptimized.isPrimitiveLiteral()) {
                    Declaration(isConst, type, variable, rhsOptimized)
                } else {
                    this
                }
            } else {
                this
            }
        }
        is Assignment -> {
            val lhsIdent = lhs.getIdentifier()
            val rhsOptimized = rhs.optimize()
            if (optLevel > 0) {
                if (rhsOptimized is Literal && updateVar) {
                    programState.updateVar(lhsIdent, rhsOptimized)
                } else if (programState.lookupVar(lhsIdent) != null) {
                    programState.removeVar(lhsIdent)
                }
            }
            if (rhsOptimized.isPrimitiveLiteral() && updateVar) {
                Assignment(lhs, rhsOptimized)
            } else {
                this
            }
        }
        is BuiltinFuncCall -> {
            val exprOptimized = expr.optimize()
            if (exprOptimized.isPrimitiveLiteral()) {
                BuiltinFuncCall(func, exprOptimized)
            } else {
                this
            }
        }
        is CondBranch -> {
            if (optLevel > 0) {
                val optimizedConds = condStatsList
                        .map { (expr, stats) -> expr.optimize() to stats }
                        .filterNot { (optimizedExpr, _) -> optimizedExpr is BoolLit && !optimizedExpr.b }
                /* If the 1st valid branch is true */
                val first = optimizedConds.firstOrNull()
                if (first != null && first.let { (expr, _) -> expr is BoolLit && expr.b }) {
                    Block(first.second)
                } else {
                    val optimizedBranches = optimizedConds.map { (expr, stats) ->
                        expr to stats.optimize()
                    }
                    CondBranch(optimizedBranches, elseBody.optimize())
                }
            } else {
                CondBranch(
                        condStatsList.map { (expr, stats) -> expr.optimize() to stats.optimize() },
                        elseBody.optimize()
                )
            }
        }
        is WhileLoop -> {
            var exprOptimized = expr.optimize()
            if (exprOptimized is BoolLit) {
                if (!exprOptimized.b) {
                    Block(emptyList())
                } else {
                    var bodyOptimized = body
                    while (exprOptimized is BoolLit && exprOptimized.b) {
                        bodyOptimized = body.optimize()
                        exprOptimized = expr.optimize()
                    }
                    if (!overflowOccurred) {
                        WhileLoop(exprOptimized, bodyOptimized)
                    } else {
                        WhileLoop(expr, body).also { overflowOccurred = false }
                    }
                }
            } else {
                updateVar = false
                WhileLoop(exprOptimized, body.optimize()).also { updateVar = true }
            }
        }
        is Block -> Block(body.optimize())
        is Read -> {
            val targetIdent = target.getIdentifier()
            if (optLevel > 0) {
                programState.removeVar(targetIdent)
            }
            this
        }
        else -> this
    }

    private fun Expression.optimize(): Expression = when (this) {
        is Identifier -> {
            val varLiteral = programState.lookupVar(this)
            if (optLevel > 0 && varLiteral != null) {
                varLiteral as Expression
            } else {
                this
            }
        }
        is ArrayElem -> {
            if (optLevel > 0) {
                val elements= ((programState.lookupVar(arrIdent) as Expression).optimize() as ArrayLiteral).elements.map { it.optimize() }
                val indicesOptimized = indices.map { it.optimize() }
                var currentArray = elements
                var currentElem: Expression = this
                for (expr in indicesOptimized) {
                    if (expr is IntLit) {
                        if (expr.x < currentArray.size) {
                            currentElem = currentArray[expr.x]
                        } else { this }
                        if (currentElem is ArrayLiteral) {
                            currentArray = currentElem.elements
                        }
                    } else { this }
                }
                currentElem
            } else {
                this
            }
        }
        is ArrayLiteral -> ArrayLiteral(elements.map {
            val exprOptimized = it.optimize()
            if (exprOptimized.isPrimitiveLiteral()) { exprOptimized } else { it }
        })
        is NewPair -> NewPair(
                (first.optimize()).let { if (it.isPrimitiveLiteral()) it else first },
                (second.optimize()).let { if (it.isPrimitiveLiteral()) it else second })
        is PairElem -> {
            val pair: NewPair? = programState.lookupVar(expr.getIdentifier())?.let { it as NewPair }
            if (pair == null) {
                this
            } else {
                if (optLevel > 0) {
                    when (func) {
                        FST -> pair.first.optimize()
                        SND -> pair.second.optimize()
                    }
                } else {
                    this
                }
            }
        }
        is BinExpr -> this.optimize()
        is UnaryExpr -> this.optimize()
        else -> this
    }

    private fun UnaryExpr.optimize(): Expression {
        val exprOptimized = expr.optimize()
        var result: Expression = this
        if (exprOptimized is BoolLit) {
            result = when (op) {
                NOT -> BoolLit(!exprOptimized.b)
                else -> this
            }
        }
        if (exprOptimized is IntLit) {
            result = when (op) {
                NEG -> IntLit(-exprOptimized.x)
                CHR -> CharLit(exprOptimized.x.toChar())
                else -> this
            }
        }

        if (exprOptimized is ArrayLiteral) {
            result = when (op) {
                LEN -> IntLit(exprOptimized.elements.size)
                else -> this
            }
        }

        if (exprOptimized is CharLit) {
            result = when (op) {
                ORD -> IntLit(exprOptimized.c.toInt())
                else -> this
            }
        }
        return result
    }


    private fun BinExpr.optimize(): Expression {
        val leftOptimized = left.optimize()
        val rightOptimized = right.optimize()
        // val optLevel = OptimizationOption.values().indexOf(option)
        var result: Expression = this

        if (leftOptimized is IntLit && rightOptimized is IntLit) {
            val x = leftOptimized.x
            val y = rightOptimized.x
            result = when (op) {
                MUL -> if (!isValueOverflow(x * y.toLong())) {
                    IntLit(x * y)
                } else { this }
                DIV -> if (y != 0) {
                    IntLit(x / y)
                } else { this }
                MOD -> IntLit(x % y)
                ADD -> if (!isValueOverflow(x + y.toLong())) {
                    IntLit(x + y)
                } else { this }
                SUB -> if (!isValueOverflow(x - y.toLong())) {
                    IntLit(x - y)
                } else { this }
                GTE -> BoolLit(x >= y)
                LTE -> BoolLit(x <= y)
                GT -> BoolLit(x > y)
                LT -> BoolLit(x < y)
                else -> result
            }
        }

        if (leftOptimized is CharLit && rightOptimized is CharLit) {
            val c1 = leftOptimized.c
            val c2 = rightOptimized.c
            result = when(op) {
                GTE -> BoolLit(c1 >= c2)
                LTE -> BoolLit(c1 <= c2)
                GT -> BoolLit(c1 > c2)
                LT -> BoolLit(c1 < c2)
                else -> result
            }
        }

        if (leftOptimized is BoolLit && rightOptimized is BoolLit) {
            val b1 = leftOptimized.b
            val b2 = rightOptimized.b
            result = when(op) {
                AND -> BoolLit(b1 && b2)
                OR -> BoolLit(b1 || b2)
                else -> result
            }
        }

        if (leftOptimized::class == rightOptimized::class) {
            result = when(op) {
                EQ -> BoolLit(leftOptimized == rightOptimized)
                NEQ -> BoolLit(leftOptimized != rightOptimized)
                else -> result
            }
        }
        return result
    }

    /**
     * Get the identifier from an expression assuming is expression has the
     * type assign-lhs
     */
    private fun Expression.getIdentifier(): Identifier = when(this) {
        is Identifier -> this
        is PairElem -> expr.getIdentifier()
        is ArrayElem -> arrIdent
        else -> throw IllegalArgumentException("Something went horribly wrong, this error should never occur!")
    }

    private fun isValueOverflow(n: Long): Boolean = (n > Int.MAX_VALUE || n < Int.MIN_VALUE)
            .also { if (it) { overflowOccurred = it } }

    private fun Expression.isPrimitiveLiteral(): Boolean =
            this is Literal && this !is ArrayLiteral && this !is NewPair

    private inline fun inScopeDo(action: () -> WaccAST): WaccAST {
        programState.enterScope()
        val newAst = action()
        programState.exitScope()
        return newAst
    }
}
