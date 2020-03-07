package optimizers

import ast.Expression
import ast.Expression.*
import ast.Expression.PairElemFunction.*
import ast.Literal
import jdk.nashorn.internal.runtime.arrays.ArrayIndex
import utils.Index
import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException
import java.util.*

class ProgramState {
    private val currentState: Deque<MutableMap<String, Literal>> = ArrayDeque()
    fun enterScope(): Unit = currentState.addFirst(hashMapOf())
    fun exitScope(): MutableMap<String, Literal> = currentState.pop()

    private fun getNearestScope(ident: Identifier): MutableMap<String, Literal>? {
        currentState.forEach {
            if (it[ident.name] != null) {
                return it
            }
        }
        return null
    }

    fun updateVar(ident: Identifier, lit: Literal) {
        getNearestScope(ident)?.also { it[ident.name] = lit } ?: also { currentState.first[ident.name] = lit }
    }

    fun defineVarInCurrentScope(ident: Identifier, lit: Literal) {
        currentState.first[ident.name] = lit
    }

    fun removeVar(ident: Identifier) {
        getNearestScope(ident)?.remove(ident.name) ?: also { throw IllegalArgumentException("Should never be here!") }
    }

    @Throws(IndexOutOfBoundsException::class)
    fun removeArrayElemAtIndex(ident: Identifier, indices: List<Int>) {
        var tempArray: ArrayLiteral? = null
        var tempIdent: Identifier = ident
        for (index in indices) {
            tempArray = lookupVar(tempIdent) as ArrayLiteral
            if (tempArray.elements[index] is Identifier) {
                tempIdent = tempArray.elements[index] as Identifier
            }
        }
        val newArray: MutableList<Expression> = tempArray?.elements?.toMutableList().also { it!![indices.last()] = ident }!!
        updateVar(tempIdent, ArrayLiteral(newArray))
    }

    fun removePairElem(pairElemFunction: PairElemFunction, ident: Identifier) {
        val originalPair = lookupVar(ident) as NewPair
        val newPair = when (pairElemFunction) {
            FST -> NewPair(ident, originalPair.second)
            SND -> NewPair(originalPair.first, ident)
        }
        updateVar(ident, newPair)
    }

    fun lookupVar(ident: Identifier): Literal? =
            currentState.mapNotNull { it[ident.name] }.firstOrNull()
}