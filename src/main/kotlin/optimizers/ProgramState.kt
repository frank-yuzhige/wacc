package optimizers

import ast.Expression.*
import ast.Literal
import java.lang.IllegalArgumentException
import java.util.*

class ProgramState {
    private val currentState: Deque<MutableMap<String, Literal>> = ArrayDeque()
    fun enterScope(): Unit = currentState.addFirst(hashMapOf())
    fun exitScope(): Unit {
        currentState.pop()
    }

    private fun getNearestScope(ident: Identifier): MutableMap<String, Literal>? {
        currentState.forEach {
            if (it[ident.name] != null) {
                return it
            }
        }
        return null
    }

    fun defineVar(ident: Identifier, lit: Literal) {
        getNearestScope(ident)?.also { it[ident.name] = lit } ?: also { currentState.first[ident.name] = lit }
    }

    fun removeVar(ident: Identifier) {
        getNearestScope(ident)?.remove(ident.name) ?: also { throw IllegalArgumentException("Should never be here!") }
    }

    fun lookupVar(ident: Identifier): Literal? =
            currentState.mapNotNull { it[ident.name] }.firstOrNull()
}