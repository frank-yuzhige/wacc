package semantics

import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.*
import exceptions.SemanticException
import exceptions.SemanticException.TypeException.*


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

        fun fail(se: SemanticException) = TypeChecker { listOf(se) }

        fun isJust(expected: Type) = { actual: Type ->
            when {
                actual is BaseType && actual.kind == ANY -> true
                else -> expected == actual
            }
        } throws { actual ->
            SingleTypeMismatchException(expected, actual)
        }

        fun isOneOf(vararg candidates: Type) = (candidates::contains) throws { actual ->
            NoMatchingCandidatesException(actual, candidates.asIterable())
        }

        fun match(expected: Type): TypeChecker = when (expected) {
            BaseType(ANY) -> pass()
            is PairType -> TypeChecker { actual ->
                when {
                    actual is BaseType && actual.kind == ANY -> emptyList()
                    actual is PairType -> {
                        match(expected.firstElemType).check(actual.firstElemType) +
                                match(expected.secondElemType).check(actual.secondElemType)
                    }
                    else -> listOf(SingleTypeMismatchException(expected, actual))
                }
            }
            is ArrayType -> TypeChecker { actual ->
                when {
                    actual is BaseType && actual.kind == ANY -> emptyList()
                    actual is BaseType && actual.kind == STRING -> {
                        if (expected.type == Type.charType()) {
                            emptyList()
                        } else {
                            listOf(SingleTypeMismatchException(expected, actual))
                        }
                    }
                    actual is ArrayType -> match(expected.type).check(actual.type)
                    else -> listOf(SingleTypeMismatchException(expected, actual))
                }
            }
            else -> isJust(expected)
        }

        fun match(vararg expected: Type): TypeChecker {
            return expected.map { match(it) }.reduceRight{ a, b -> a `||` b}
        }

        fun matchPairByElem(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (actual) {
                is PairType -> when (func) {
                    FST -> tc.check(actual.firstElemType)
                    SND -> tc.check(actual.secondElemType)
                }
                else -> listOf(NotAPairException(actual))
            }
        }

        fun unwrapPair(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (func) {
               FST -> tc.check(PairType(actual, BaseType(ANY)))
               SND -> tc.check(PairType(BaseType(ANY), actual))
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

    fun withError(vararg se: SemanticException): TypeChecker = TypeChecker { actual ->
        if (this.check(actual).isEmpty()) {
            emptyList()
        } else {
            se.asList()
        }
    }

}
