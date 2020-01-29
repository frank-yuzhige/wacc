package semantics

import ast.*
import ast.Expression.*
import ast.Function
import ast.Statement.Declaration
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.pairBaseType
import ast.Type.Companion.stringType
import exceptions.SemanticException
import exceptions.SemanticException.*
import exceptions.SemanticException.TypeException.InsufficientArrayRankException
import semantics.TypeChecker.Companion.match
import semantics.TypeChecker.Companion.pass
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
        functions.map { symbolTable.define(
                        it.name,
                        Type.FuncType(it.returnType, it.args.map { a -> a.second }),
                        AstIndexMap.map[it] ?: throw UnknownError())
                }
        return functions.flatMap { it.checkBody(match(it.returnType)) } + mainProgram.flatMap { it.check() }
    }

    private fun Function.checkBody(retCheck: TypeChecker): List<SemanticException> {
        return this.body.flatMap { it.check(retCheck) }
    }

    private fun Statement.check(retCheck: TypeChecker = pass()): List<SemanticException> {
        val exceptions: MutableList<SemanticException> = mutableListOf()
        when(this@check) {
            is Declaration -> {
                val prevAttr
                        = symbolTable.define(variable.ident, type, AstIndexMap.map.getValue(this))
                if (prevAttr != null) {
                    exceptions += MultipleVarDefException(variable.ident, prevAttr.type, prevAttr.index)
                }
                exceptions.addAll(rhs.check(match(type)))
            }
            else -> TODO()
        }
        return exceptions
    }

    private fun Expression.check(tc: TypeChecker): List<SemanticException> {
        return when(this) {
            is NullLit -> tc.check(pairBaseType())
            is IntLit -> tc.check(intType())
            is BoolLit -> tc.check(boolType())
            is CharLit -> tc.check(charType())
            is StringLit -> tc.check(stringType())
            is Identifier -> {
                val actual = symbolTable.lookupVar(ident)?.type
                if (actual != null) {
                    tc.check(actual)
                } else {
                    listOf(UndefinedVarException(ident))
                }
            }
            is BinExpr -> {
                val allCases = BinaryOperator.typeMap.getValue(op).map { entry ->
                    tc.check(entry.type) + left.check(entry.lhsChecker) + right.check(entry.rhsChecker)
                }
                if(allCases.count { it.isEmpty() } != 0) {
                    allCases.flatten()
                } else {
                    emptyList()
                }
            }
            is ArrayElem -> {
                symbolTable.lookupVar(arrayName)
                        ?.let { entry -> entry.type.unwrapArrayType(indices.count())
                                ?.let { newtype -> tc.check(newtype) }
                                ?:listOf(InsufficientArrayRankException(entry.type, indices.count())) }
                        ?: listOf(UndefinedVarException(arrayName))
            }
            else -> TODO()

        }.map { err -> err.forwardWith("an expression", this) }
    }


}

