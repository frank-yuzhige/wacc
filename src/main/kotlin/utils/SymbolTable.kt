package utils

import ast.Expression.Identifier
import ast.Type
import exceptions.SemanticException.*
import java.util.*

class SymbolTable {
    private val scopeStack: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val scopeIdStack: Deque<Int> = ArrayDeque()
    private val functions: MutableMap<String, FuncAttributes> = hashMapOf()
    private val collect: MutableMap<Pair<String, Int>, VarAttributes> = hashMapOf()
    private var scopeIdGen = 0

    fun defineVar(type: Type, identNode: Identifier): VarAttributes? {
        val name = identNode.name
        val currScope = this.scopeStack.first()
        val entry = currScope[name]
        if (entry != null) {
            return entry
        }
        identNode.scopeId = getCurrScopeId()
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
                ?.map { (ident, attrs) ->
                    "Unused variable $ident at ${attrs.index}: variable defined but its value is never used" }

    }


    fun lookupVar(ident: String) : VarAttributes? = scopeStack
            .mapNotNull { it[ident] }
            .firstOrNull()
            ?.addOccurence()

    fun lookupFunc(ident: String) : FuncAttributes? = functions[ident]

    fun dumpTable(): String = "${getFuncTable()}\n${getVarTable()}"

    fun dump() {
        println(getVarTable())
        println(getFuncTable())
    }

    fun getVarTable(): String {
        val tp = TablePrinter("variable", "scope id", "type", "position", "occurrences")
        collect.map { (pair, attr) ->
            tp.addColumn(pair.first, pair.second, attr.type, attr.index, attr.occurrences)
        }
        return tp.print()
    }

    fun getFuncTable(): String {
        val tp = TablePrinter("function name", "type", "position")
        functions.map { (name, attr) ->
            tp.addColumn(name, attr.type, attr.index)
        }
        return tp.print()
    }


    private fun getCurrScopeId(): Int = scopeIdStack.peekFirst()

    private fun collectPrevScope(prevId: Int, prev: MutableMap<String, VarAttributes>) {
        prev.forEach{ (ident, attr) ->
            collect[ident to prevId] = attr
        }
    }

    data class FuncAttributes(val type: Type.FuncType, val index: Index)
    data class VarAttributes(val type: Type, val index: Index, val scopeId: Int, var occurrences: Int = 1) {
        fun addOccurence(): VarAttributes = this.also { occurrences++ }
    }

}