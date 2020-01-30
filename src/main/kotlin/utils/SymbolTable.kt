package utils

import ast.Type
import exceptions.SemanticException.*
import java.util.*

class SymbolTable {
    private val scopeList: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val functions: MutableMap<String, FuncAttributes> = hashMapOf()

//    init {
//        scopeList.add(hashMapOf())
//    }

    fun defineVar(ident: String, type: Type, index: Index): VarAttributes? {
        val currScope = this.scopeList.last()
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

    fun popScope(): MutableMap<String, VarAttributes>? = scopeList.pollFirst()

    fun lookupVar(ident: String) : VarAttributes? = scopeList.mapNotNull { it[ident] }.firstOrNull()
    fun lookupFunc(ident: String) : FuncAttributes? = functions[ident]

    data class FuncAttributes(val type: Type.FuncType, val index: Index)
    data class VarAttributes(val type: Type, val index: Index)

}