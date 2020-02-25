package optimizers

import ast.Expression.*
import ast.Literal
import java.util.*

class ProgramState {
    private val currentState: Deque<MutableMap<String, Literal>> = ArrayDeque()
    fun enterScope(): Unit = currentState.addFirst(hashMapOf())
    fun exitScope(): Unit {
        currentState.pop()
    }
    fun defineVarInCurrentScope(ident: Identifier, lit: Literal) {
        currentState.first[ident.name] = lit
    }
    fun removeVarFromCurrentScope(ident: Identifier) {
        currentState.first.remove(ident.name)
    }
    fun lookupVar(ident: Identifier): Literal? =
            currentState.mapNotNull { it[ident.name] }.firstOrNull()
}