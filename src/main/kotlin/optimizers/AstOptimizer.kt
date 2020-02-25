package optimizers

import ast.*
import ast.BinaryOperator.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.UnaryOperator.*
import utils.Statements

class AstOptimizer(option: OptimizationOption) {
    private val optLevel = OptimizationOption.values().indexOf(option)
    private val programState = ProgramState()

    fun doOptimize(ast: ProgramAST): ProgramAST {
        println(optLevel)
        if (optLevel > 0) {
            var currAst = ast
            var preAst: ProgramAST
            do {
                preAst = currAst
                currAst = currAst.optimize()
            } while (preAst != currAst)
            currAst.prettyPrint()
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
        is Declaration -> Declaration(type, variable, rhs.optimize())
        is Assignment -> Assignment(lhs, rhs.optimize())
        is BuiltinFuncCall -> BuiltinFuncCall(func, expr.optimize())
        is CondBranch -> CondBranch(expr.optimize(), trueBranch.optimize(), falseBranch.optimize())
        is WhileLoop -> WhileLoop(expr.optimize(), body.optimize())
        is Block -> Block(body.optimize())
        else -> this
    }

    private fun Expression.optimize(): Expression = when (this) {
        is Identifier -> {
            if (optLevel > 0) {
                programState.lookupVar(this)!! as Expression
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


    private inline fun inScopeDo(action: () -> WaccAST): WaccAST {
        programState.enterScope()
        val newAst = action()
        programState.exitScope()
        return newAst
    }
}
