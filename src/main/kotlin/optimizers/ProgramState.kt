package optimizers

import ast.Expression
import ast.Expression.*
import ast.Expression.PairElemFunction.*
import ast.Literal
import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException
import java.util.*

class ProgramState() {
    private val currentState: Deque<MutableMap<String, Literal>> = ArrayDeque()
    private val previousState: Deque<MutableMap<String, Literal>> = ArrayDeque()
    fun enterScope(): Unit = currentState.push(hashMapOf())
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
    private fun updateArrayLiteral(ident: Identifier, indices: List<Int>, newLiteral: Expression) {
        var tempArray: ArrayLiteral? = null
        var tempIdent: Identifier = ident
        for (index in indices) {
            tempArray = lookupVar(tempIdent) as ArrayLiteral
            if (tempArray.elements[index] is Identifier) {
                tempIdent = tempArray.elements[index] as Identifier
            }
        }
        val newArray: MutableList<Expression> = tempArray?.elements?.toMutableList().also { it!![indices.last()] = newLiteral }!!
        updateVar(tempIdent, ArrayLiteral(newArray) as Literal)
    }


    @Throws(IndexOutOfBoundsException::class)
    fun updateArrayElemAtIndex(ident: Identifier, indices: List<Int>, newLiteral: Literal) {
        updateArrayLiteral(ident, indices, newLiteral as Expression)
    }


    @Throws(IndexOutOfBoundsException::class)
    fun removeArrayElemAtIndex(ident: Identifier, indices: List<Int>) {
        updateArrayLiteral(ident, indices, ident)
    }

    private fun updateNewPair(pairElemFunction: PairElemFunction, ident: Identifier, newLiteral: Expression) {
        val originalPair = lookupVar(ident) as NewPair
        val newPair = when (pairElemFunction) {
            FST -> NewPair(newLiteral, originalPair.second)
            SND -> NewPair(originalPair.first, newLiteral)
        }
        updateVar(ident, newPair)
    }

    fun updatePairElem(pairElemFunction: PairElemFunction, ident: Identifier, newLiteral: Literal) {
        updateNewPair(pairElemFunction, ident, newLiteral as Expression)
    }

    fun removePairElem(pairElemFunction: PairElemFunction, ident: Identifier) {
        updateNewPair(pairElemFunction, ident, ident)
    }

    fun lookupVar(ident: Identifier): Literal? =
            currentState.mapNotNull { it[ident.name] }.firstOrNull()

    fun recordCurrentState() = currentState.forEach { previousState.add(it.toMutableMap()) }
    fun restorePreviousState() = currentState.clear().also { previousState.forEach { currentState.add(it.toMutableMap()) } }
}