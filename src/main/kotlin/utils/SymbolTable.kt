package utils

import ast.Type
import exceptions.SemanticException.*
import java.util.*

object SymbolTable {
    private val scopeList: Deque<MutableMap<String, VarAttributes>> = ArrayDeque()
    private val functions: MutableMap<String, FuncAttributes> = hashMapOf()

    fun define(ident: String, type: Type, index: Index) {
        val currScope = this.scopeList.last()
        val entry = currScope[ident]
        if (entry != null) {
            throw MultipleVarDefException(ident, entry.type, entry.index)
        }
        currScope[ident] = VarAttributes(type, index)
    }

    fun defineFunc(ident: String, funcType: Type.FuncType, index: Index) {
        val entry = functions[ident]
        if (entry != null) {
            throw MultipleFuncDefException(ident, entry.type, entry.index)
        }
        functions[ident] = FuncAttributes(funcType, index)
    }

    fun push() {
        scopeList.addFirst(hashMapOf())
    }

    fun pop(): MutableMap<String, VarAttributes>? = scopeList.pollFirst()

    fun get(ident: String) : VarAttributes? = scopeList.mapNotNull { it[ident] }.first()


    data class FuncAttributes(val type: Type.FuncType, val index: Index)
    data class VarAttributes(val type: Type, val index: Index)

}