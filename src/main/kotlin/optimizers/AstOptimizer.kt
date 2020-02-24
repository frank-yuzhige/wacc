package optimizers

import ast.*
import ast.BinaryOperator.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import utils.Statements

class AstOptimizer(val options: List<OptimizationOptions>) {
    fun doOptimize(ast: ProgramAST) {
        ast.optimize()
    }

    private fun ProgramAST.optimize() {
        functions.map {
            it.optimize()
        }
        mainProgram.optimize()
    }

    private fun Function.optimize() = body.forEach() { it.optimize() }

    private fun Statements.optimize() = this.forEach { it.optimize() }

    private fun Statement.optimize() = when (this) {
        is Declaration -> rhs.optimize()
        is Assignment -> rhs.optimize()
        else -> {}
    }

    private fun Expression.optimize(): Unit = when (this) {
        NullLit -> TODO()
        is IntLit -> TODO()
        is BoolLit -> TODO()
        is CharLit -> TODO()
        is StringLit -> TODO()
        is Identifier -> TODO()
        is BinExpr -> when (op) {
            MUL -> TODO()
            DIV -> TODO()
            MOD -> TODO()
            ADD -> TODO()
            SUB -> TODO()
            GTE -> TODO()
            LTE -> TODO()
            GT -> TODO()
            LT -> TODO()
            EQ -> TODO()
            NEQ -> TODO()
            AND -> TODO()
            OR -> TODO()
        }
        is UnaryExpr -> TODO()
        is ArrayElem -> TODO()
        is PairElem -> TODO()
        is ArrayLiteral -> TODO()
        is NewPair -> TODO()
        is FunctionCall -> TODO()
    }
}
