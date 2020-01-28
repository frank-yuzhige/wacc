package utils

import exceptions.SemanticException
import exceptions.SemanticException.MultipleDefinitionException
import java.util.*

typealias Scope = MutableMap<String, Attributes>

object SymbolTable {
    private val scopeList: Deque<Scope> = ArrayDeque()

    fun define(ident: String, attr: Attributes) {
        val currScope = this.scopeList.last()
        if (currScope.containsKey(ident)) {
            throw MultipleDefinitionException(ident)
        }
        currScope[ident] = attr
    }

    fun push() {
        scopeList.addFirst(hashMapOf())
    }

    fun pop(): Scope? = scopeList.pollFirst()

    fun get(ident: String) : Attributes? = scopeList.mapNotNull { it[ident] }.first()


}