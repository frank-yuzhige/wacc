package semantics

import ast.Expression
import ast.Type

fun<T> List<List<T>>.ifNotEmptyDo(handler: (List<List<T>>) -> List<T> = { it.flatten() }): List<T> {
    return if (this.any { it.isEmpty() }) {
        emptyList()
    } else {
        handler(this)
    }
}

fun<T> List<T>.ifEmptyJust(next: List<T>): List<T> {
    return if(this.isNotEmpty()) {
        this
    } else {
        next
    }
}