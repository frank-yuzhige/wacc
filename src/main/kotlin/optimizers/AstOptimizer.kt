package optimizers

import ast.*
import ast.BinaryOperator.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.UnaryOperator.*
import utils.Statements

class AstOptimizer(private val option: OptimizationOption) {
    fun doOptimize(ast: ProgramAST): ProgramAST = ast.optimize()

    private fun ProgramAST.optimize(): ProgramAST  = ProgramAST(functions.map { it.optimize() }, mainProgram.optimize())

    private fun Function.optimize(): Function = Function(returnType, name, args, body.map { it.optimize() })

    private fun Statements.optimize(): Statements = this.map { it.optimize() }

    private fun Statement.optimize(): Statement = when (this) {
        is Declaration -> Declaration(type, variable, rhs.optimize())
        is Assignment -> Assignment(lhs, rhs.optimize())
        else -> this
    }

    private fun Expression.optimize(): Expression = when (this) {
        is Identifier -> this // TODO
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
}
