package semantics

import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.*
import exceptions.SemanticException
import exceptions.SemanticException.TypeException.NoMatchingCandidatesException
import exceptions.SemanticException.TypeException.SingleTypeMismatchException


class TypeChecker private constructor(val check: (Type) -> List<SemanticException>) {

    companion object {
        infix fun ((Type) -> Boolean).throws(error: (Type) -> SemanticException): TypeChecker {
            return TypeChecker { actual ->
                if (this(actual)) {
                    emptyList()
                } else {
                    listOf(error(actual))
                }
            }
        }

        fun pass() = TypeChecker { emptyList() }

        fun isJust(expected: Type) = (expected::equals) throws { actual ->
            SingleTypeMismatchException(expected, actual)
        }

        fun isOneOf(vararg candidates: Type) = (candidates::contains) throws { actual ->
            NoMatchingCandidatesException(actual, candidates.asIterable())
        }

        fun match(expected: Type): TypeChecker = when (expected) {
            is PairType -> TypeChecker { actual ->
                when(actual) {
                    is PairType -> {
                        match(expected.firstElemType).check(actual.firstElemType) +
                                match(expected.secondElemType).check(actual.secondElemType)
                    }
                    else -> listOf(SingleTypeMismatchException(expected, actual))
                }
            }
            BaseType(ANY) -> pass()
            else -> isJust(expected)
        }
    }

}
