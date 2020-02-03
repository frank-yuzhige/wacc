package semantics

import ast.Type
import javax.lang.model.type.ArrayType

class SemanticErrorFactory {
    companion object {
        fun insufficientArrayRankError(type: Type, rank: Int): String = when(type) {
            is ArrayType -> "$type does not have more than $rank rank"
            else -> "$type is not an array"
        }
    }
}