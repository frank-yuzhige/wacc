package semantics

import ast.Expression
import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
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
                when {
                    actual is BaseType && actual.kind == ANYOUT -> emptyList()
                    actual is PairType -> {
                        match(expected.firstElemType).check(actual.firstElemType) +
                                match(expected.secondElemType).check(actual.secondElemType)
                    }
                    else -> listOf(SingleTypeMismatchException(expected, actual))
                }
            }
            BaseType(ANY) -> pass()
            else -> isJust(expected)
        }

        fun matchPair(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (actual) {
                is PairType -> when (func) {
                    FST -> tc.check(actual.firstElemType)
                    SND -> tc.check(actual.secondElemType)
                }
                else -> TODO() // throw not a type
            }
        }

        fun unwrapPair(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (func) {
               FST -> tc.check(PairType(actual, BaseType(ANYOUT)))
               SND -> tc.check(PairType(BaseType(ANYOUT), actual))
            }
        }

        fun unwrapArray(tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            tc.check(ArrayType(actual))
        }
    }

    infix fun `||`(other: TypeChecker): TypeChecker = TypeChecker { actual ->
        val fst = this.check(actual)
        if (fst.isNotEmpty()) {
            other.check(actual)
        } else {
            fst
        }
    }

}
