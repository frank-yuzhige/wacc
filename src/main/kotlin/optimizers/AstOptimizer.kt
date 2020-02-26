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
import java.util.*

class AstOptimizer(option: OptimizationOption) {
    private val optLevel = OptimizationOption.values().indexOf(option)
    private val programState = ProgramState()

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
        ProgramAST(functions.map { it.optimize() }, mainProgram.optimize())

    private fun Function.optimize(): Function =
            inScopeDo { Function(returnType, name, args, body.map { it.optimize() }) } as Function

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
                programState.defineVar(variable, rhsOptimized)
                if (rhsOptimized.isPrimitiveLiteral()) {
                    Declaration(type, variable, rhsOptimized)
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
                if (rhsOptimized is Literal) {
                    programState.defineVar(lhsIdent, rhsOptimized)
                } else {
                    programState.removeVar(lhsIdent)
                }
            }
            Assignment(lhs, rhsOptimized)
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
            val exprOptimized = expr.optimize()
            if (exprOptimized is BoolLit && optLevel > 0) {
                if (exprOptimized.b) { Block(trueBranch.optimize()) } else { Block(falseBranch.optimize()) }
            } else {
                CondBranch(expr.optimize(), trueBranch.optimize(), falseBranch.optimize())
            }
        }
        is WhileLoop -> WhileLoop(expr.optimize(), body.optimize())
        is Block -> Block(body.optimize())
        is Read -> {
            val targetIdent = target.getIdentifier()
            if (optLevel > 0) {
                programState.removeVar(targetIdent)
            }
            this
        }
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
            val pair = programState.lookupVar(expr.getIdentifier()) as NewPair
            if (optLevel > 0) {
                when (func) {
                    FST -> pair.first.optimize()
                    SND -> pair.second.optimize()
                }
            } else {
                this
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
                MUL -> IntLit(x * y)
                DIV -> IntLit(x / y)
                MOD -> IntLit(x % y)
                ADD -> IntLit(x + y)
                SUB -> IntLit(x - y)
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

    private fun Expression.isPrimitiveLiteral(): Boolean =
            this is Literal && this !is ArrayLiteral && this !is NewPair && this !is PairElem

    private inline fun inScopeDo(action: () -> WaccAST): WaccAST {
        programState.enterScope()
        val newAst = action()
        programState.exitScope()
        return newAst
    }
}
