package utils

import ast.Type
import exceptions.SemanticException.*
import java.util.*

class SymbolTable {
    private val scopeList: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val functions: MutableMap<String, FuncAttributes> = hashMapOf()

    fun defineVar(ident: String, type: Type, index: Index): VarAttributes? {
        val currScope = this.scopeList.first()
        val entry = currScope[ident]
        if (entry != null) {
            return entry
        }
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

    fun pushScope() = scopeList.addFirst(hashMapOf())

    fun popScope(): List<String>? =
        scopeList.pollFirst()
                ?.filter { (_, attrs) -> attrs.occurrences == 1 }
                ?.map { (ident, attrs) ->
            "Unused variable $ident at ${attrs.index}: variable defined but its value is never used"
        }

    fun lookupVar(ident: String) : VarAttributes? = scopeList
            .mapNotNull { it[ident]?.incrementOccurrences() }
            .firstOrNull()
    fun lookupFunc(ident: String) : FuncAttributes? = functions[ident]

    private fun VarAttributes.incrementOccurrences(): VarAttributes = this.also { occurrences++ }
    data class FuncAttributes(val type: Type.FuncType, val index: Index)
    data class VarAttributes(val type: Type, val index: Index, var occurrences: Int = 1)

}