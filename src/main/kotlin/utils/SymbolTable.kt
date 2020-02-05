package utils

import ast.Type
import ast.WaccAST
import exceptions.SemanticException.*
import java.util.*

class SymbolTable {
    private val scopeList: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val scopeIdStack: Deque<Int> = ArrayDeque()
    private val functions: MutableMap<String, FuncAttributes> = hashMapOf()
    private val idMap: MutableMap<Pair<String, Int>, VarAttributes> = hashMapOf()
    private var scopeIdGen = -1

    fun defineVar(ident: String, type: Type, index: Index, astModifier: (Int) -> Unit): VarAttributes? {
        val currScope = this.scopeList.first()
        val entry = currScope[ident]
        if (entry != null) {
            return entry
        }
        astModifier(getCurrScopeId())
        currScope[ident] = VarAttributes(type, index)
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
        scopeList.addFirst(hashMapOf())
        scopeIdStack.addFirst(scopeIdGen++)
    }

    fun popScope(): List<String>? {
        val prevId = scopeIdStack.pollFirst()
        return scopeList.pollFirst()
                ?.also { prev -> collectPrevScope(prevId, prev) }
                ?.filter { (_, attrs) -> attrs.occurrences == 1 }
                ?.map { (ident, attrs) ->
                    "Unused variable $ident at ${attrs.index}: variable defined but its value is never used" }

    }


    fun lookupVar(ident: String, astModifier: (Int) -> Unit) : VarAttributes? = scopeList
            .mapNotNull { it[ident] }
            .firstOrNull()
            ?.also { it.incrementOccurrences() }
            ?.also { astModifier(getCurrScopeId()) }

    fun lookupFunc(ident: String) : FuncAttributes? = functions[ident]

    private fun getCurrScopeId(): Int = scopeIdStack.peekFirst()

    private fun collectPrevScope(prevId: Int, prev: MutableMap<String, VarAttributes>) {
        prev.forEach{ (ident, attr) ->
            idMap[ident to prevId] = attr
        }
    }

    private fun VarAttributes.incrementOccurrences(): VarAttributes = this.also { occurrences++ }
    data class FuncAttributes(val type: Type.FuncType, val index: Index)
    data class VarAttributes(val type: Type, val index: Index, var occurrences: Int = 1)

}