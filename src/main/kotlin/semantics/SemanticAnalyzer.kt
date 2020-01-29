package semantics

import ast.*
import ast.Function
import ast.Statement.Declaration
import exceptions.SemanticException
import exceptions.SemanticException.MultipleVarDefException
import exceptions.SemanticException.SemanticExceptionBundle
import utils.SymbolTable

class SemanticAnalyzer {

    val symbolTable = SymbolTable()

    fun doCheck(ast: ProgramAST) {
        val errors = ast.check()
        if (errors.isNotEmpty()) {
            throw SemanticExceptionBundle(errors)
        }
    }

    private fun ProgramAST.check(): List<SemanticException> {
        this@check.functions.map { symbolTable.define(
                        it.name,
                        Type.FuncType(it.returnType, it.args.map { a -> a.second }),
                        AstIndexMap.map[it] ?: throw UnknownError())
                }
        return this@check.functions.flatMap { it.checkBody() } + this@check.mainProgram.flatMap { it.check() }
    }

    private fun Function.checkBody(): List<SemanticException> {
        return this.body.flatMap { it.check() }
    }

    private fun Statement.check(): List<SemanticException> {
        val exceptions: MutableList<SemanticException> = mutableListOf()
        when(this@check) {
            is Declaration -> {
                val prevAttr
                        = symbolTable.define(variable.ident, type, AstIndexMap.map.getValue(this))
                if (prevAttr != null) {
                    exceptions += MultipleVarDefException(variable.ident, prevAttr.type, prevAttr.index)
                }
                TypeChecker(symbolTable, type).check(rhs)
            }
            else -> TODO()
        }
        return exceptions
    }

}
