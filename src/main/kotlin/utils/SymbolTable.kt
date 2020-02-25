package utils

import ast.Expression
import ast.Expression.Identifier
import ast.Type
import ast.Type.Companion.anyArrayType
import exceptions.SemanticException
import exceptions.SemanticException.MultipleFuncDefException
import java.util.*

class SymbolTable {
    private val scopeStack: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val scopeIdStack: Deque<Int> = ArrayDeque()
    val functions: MutableMap<String, FuncAttributes> = hashMapOf()
    val collect: MutableMap<VarWithSID, VarAttributes> = hashMapOf()
    val scopeDefs: MutableMap<Int, Set<String>> = hashMapOf()
    private var scopeIdGen = 0

    fun defineVar(type: Type, identNode: Identifier): VarAttributes? {
        val name = identNode.name
        val currScope = this.scopeStack.first()
        val entry = currScope[name]
        if (entry != null) {
            return entry
        }
        val sid = getCurrScopeId()
        identNode.scopeId = sid
        currScope[name] = VarAttributes(type, identNode.startIndex, getCurrScopeId())
        return null
    }

    fun defineFunc(ident: String, funcType: Type.FuncType, index: Index) {
        val entry = functions[ident]
        if (entry != null) {
            throw MultipleFuncDefException(ident, entry.type, entry.index)
        }
        functions[ident] = FuncAttributes(funcType, index)
    }

    fun pushScope() {
        scopeStack.addFirst(hashMapOf())
        scopeIdStack.addFirst(scopeIdGen++)
    }

    fun popScope(): List<String>? {
        val prevId = scopeIdStack.pollFirst()
        return scopeStack.pollFirst()
                ?.also { prev -> collectPrevScope(prevId, prev) }
                ?.filter { (_, attrs) -> attrs.occurrences == 1 }
                ?.map { (ident, attr) ->
                    "Unused variable $ident at ${attr.index}: variable defined but its value is never used"
                }

    }


    fun lookupVar(ident: Identifier): VarAttributes? = scopeStack
            .mapNotNull { it[ident.name] }
            .firstOrNull()
            ?.addOccurrence()
            ?.also { ident.scopeId = it.scopeId }

    fun lookupFunc(ident: String): FuncAttributes? = functions[ident]?.addOccurrence()

    fun dumpTable(): String = "${getFuncTable()}\n${getVarTable()}"

    fun dump() {
        println(getVarTable())
        println(getFuncTable())
    }

    fun getVarTable(): String {
        val tp = TablePrinter("variable", "scope id", "type", "defined at", "ref count")
                .markIntColumn(1, 4)
                .sortBy(0, 1)
        collect.map { (pair, attr) ->
            tp.addColumn(pair.first, pair.second, attr.type, attr.index, attr.occurrences)
        }

        return tp.print()
    }

    fun getFuncTable(): String {
        val tp = TablePrinter("function", "type", "defined at", "ref count")
                .sortBy(0, 2)
        functions.map { (name, attr) ->
            tp.addColumn(name, attr.type, attr.index, attr.occurrences)
        }
        return tp.print()
    }

    fun getType(expr: Expression, accessType: AccessType): Type {
        return when(expr) {
            Expression.NullLit -> Type.anyPairType()
            is Expression.IntLit -> Type.intType()
            is Expression.BoolLit -> Type.boolType()
            is Expression.CharLit -> Type.charType()
            is Expression.StringLit -> Type.stringType()
            is Identifier -> {
                if (accessType == AccessType.IN_SEM_CHECK){
                    lookupVar(expr)?.type?: throw SemanticException.UndefinedVarException(expr.name)
                } else {
                    collect[expr.getVarSID()]!!.type
                }
            }
            is Expression.BinExpr -> expr.op.retType
            is Expression.UnaryExpr -> expr.op.retType
            is Expression.ArrayElem -> {
                val arrType = if (accessType == AccessType.IN_SEM_CHECK) {
                    lookupVar(expr.arrIdent)?.type
                            ?: throw SemanticException.UndefinedVarException(expr.arrIdent.name)
                } else {
                    collect[expr.arrIdent.getVarSID()]!!.type
                }
                arrType.unwrapArrayType(expr.indices.size)
                        ?: throw SemanticException.NotEnoughArrayRankException(expr.arrIdent.name)
            }
            is Expression.PairElem -> {
                getType(expr.expr, accessType).let { exprType ->
                    exprType.unwrapPairType(expr.func)
                            ?: throw SemanticException.TypeMismatchException(Type.anyPairType(), exprType)
                }
            }
            is Expression.ArrayLiteral -> {
                if (expr.elements.isEmpty()) {
                    anyArrayType()
                } else {
                    if (expr.elements.isEmpty()) {
                        Type.ArrayType(Type.BaseType(Type.BaseTypeKind.ANY))
                    } else {
                        val fstType = getType(expr.elements[0], accessType)
                        for (e in expr.elements.drop(1)) {
                            val sndType = getType(e, accessType)
                            if (sndType != fstType) {
                                throw SemanticException.TypeMismatchException(fstType, sndType)
                            }
                        }
                        Type.ArrayType(fstType)
                    }
                }
            }
            is Expression.NewPair -> {
                getType(expr.first, accessType).let { t1 ->
                    getType(expr.second, accessType).let { t2 ->
                        Type.PairType(t1, t2)
                    }
                }
            }
            is Expression.FunctionCall -> {
                if (accessType == AccessType.IN_SEM_CHECK) {
                    lookupFunc(expr.ident)?.type?.retType ?: throw SemanticException.UndefinedFuncException(expr.ident)
                } else {
                    functions[expr.ident]!!.type.retType
                }
            }
        }
    }


    private fun getCurrScopeId(): Int = scopeIdStack.peekFirst()

    private fun collectPrevScope(prevId: Int, prev: MutableMap<String, VarAttributes>) {
        prev.forEach { (ident, attr) ->
            collect[ident to prevId] = attr
        }
        scopeDefs[prevId] = prev.keys
    }

    data class FuncAttributes(val type: Type.FuncType, val index: Index, var occurrences: Int = 1) {
        fun addOccurrence(): FuncAttributes = this.also { occurrences++ }
    }
    data class VarAttributes(val type: Type, val index: Index, val scopeId: Int, var occurrences: Int = 1) {
        fun addOccurrence(): VarAttributes = this.also { occurrences++ }
    }
    enum class AccessType {
        IN_SEM_CHECK, IN_CODE_GEN
    }

}