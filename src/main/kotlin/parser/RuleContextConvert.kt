package parser

import antlr.WaccParser.*
import ast.*
import ast.Function

fun ProgContext.toAST() : ProgramAST =
        ProgramAST(this.func().map { it.toAST() }, this.stats().toMainProgramAST())

private fun FuncContext.toAST(): Function {
    return Function(TODO(), this.ident().text, this.paramList().toAST(), this.stats().toFunctionBodyAST())
}

private fun ParamListContext.toAST() : List<Parameter> {
    TODO()
}

private fun StatsContext.toFunctionBodyAST() : Statements {
    return this.stat().map { it.toAST() }
}

private fun StatsContext.toMainProgramAST(): Statements {
    TODO()
}

private fun StatContext.toAST(): Statement {
    TODO()
}

private fun ExprContext.toAST(): Statement {
    TODO()
}
