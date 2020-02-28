package semantics

import ast.Type
import ast.Type.NewType

sealed class UnionDecidability(val type: NewType) {
    class Decidable(type: NewType, val constructor: String): UnionDecidability(type)
    class Undecidable(type: NewType): UnionDecidability(type)
}