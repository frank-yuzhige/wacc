package semantics

import ast.Expression.PairElemFunction
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.ANY
import ast.Type.BaseTypeKind.STRING
import ast.Type.Companion.charType
import ast.Type.Companion.stringType


/* A TypeChecker checks a given type, and gives some errors when type check fails,
*  or an empty list if check successes */
class TypeChecker private constructor(val test: (Type) -> List<String>) {

    companion object {
        /* Basic smart-constructor for TypeChecker.
        *  Returns a TypeChecker which checks the given type by the given predicate
        *  , and generates error based on the given type and @error function when type-check fails. */
        private infix fun ((Type) -> Boolean).throws(error: (Type) -> String): TypeChecker {
            return TypeChecker { actual ->
                if (this(actual)) {
                    emptyList()
                } else {
                    listOf(error(actual))
                }
            }
        }

        /* A TypeChecker which always passes. */
        fun pass() = TypeChecker { emptyList() }

        /* A TypeChecker that does "ALL-EQUAL" tests, should not be used in practice. */
        private fun isJust(expected: Type) = { actual: Type ->
            when {
                actual == BaseType(ANY) || expected == BaseType(ANY) -> true
                else -> expected == actual
            }
        } throws { actual -> typeMismatchError(expected, actual) }

        /* Primary smart constructor of a TypeChecker.
        *  'match' takes an expecting type, and returns the TypeChecker that checks this type
        *  as per the definition from the WACC spec. */
        fun match(expected: Type): TypeChecker = when (expected) {
            BaseType(ANY) -> pass()
            BaseType(STRING) -> TypeChecker { actual ->
                when (actual) {
                    ArrayType(charType()), stringType() -> emptyList()
                    else -> listOf(typeMismatchError(expected, actual))
                }
            }
            is PairType -> TypeChecker { actual ->
                when (actual) {
                    BaseType(ANY) -> emptyList()
                    is PairType -> {
                        match(expected.firstElemType).test(actual.firstElemType) +
                                match(expected.secondElemType).test(actual.secondElemType)
                    }
                    else -> listOf(typeMismatchError(expected, actual))
                }
            }
            is ArrayType -> TypeChecker { actual ->
                when(actual) {
                    BaseType(ANY) -> emptyList()
                    is ArrayType -> match(expected.type)
                            .withError(typeMismatchError(expected, actual))
                            .test(actual.type)
                    else -> listOf(typeMismatchError(expected, actual))
                }
            }
            else -> isJust(expected)
        }

        /* vararg version of match, takes several desiring types, succeeds if any of the candidates succeeds */
        fun match(vararg expected: Type): TypeChecker {
            return expected
                    .map { match(it) }
                    .reduceRight { a, b -> a or b }
                    .changeError { actual -> listOf(typeMismatchManyError(expected.toList(), actual)) }
        }

        /* Lifts @tc checker to a pair-TypeChecker that checks pair(any, tc) or pair(tc, any), determined by @func */
        fun matchPairByElem(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (actual) {
                is PairType -> when (func) {
                    FST -> tc.test(actual.firstElemType)
                    SND -> tc.test(actual.secondElemType)
                }
                else -> listOf("Expecting a pair, but $actual is not a pair!")
            }
        }


        /* Unwrap the given 'pair-checker' @tc, to check the FST/SND element's type */
        fun unwrapPair(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (func) {
                FST -> tc.test(PairType(actual, BaseType(ANY)))
                SND -> tc.test(PairType(BaseType(ANY), actual))
            }
        }

        /* Unwrap the given 'array-checker' @tc, to check the base type of the array (1-rank lower) */
        fun unwrapArray(tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            tc.test(ArrayType(actual))
        }
    }

    /* Combines 2 checkers to form 1 checker which succeed if any of the 2 checkers succeeds
    *  "Alternative" instance of TypeChecker */
    infix fun or(other: TypeChecker): TypeChecker = TypeChecker { actual ->
        val fst = this.test(actual)
        if (fst.isNotEmpty()) {
            other.test(actual)
        } else {
            fst
        }
    }

    /* Change the error message generator of the original TypeChecker to the provided one */
    fun changeError(error: (Type) -> List<String>): TypeChecker = TypeChecker { actual ->
        if (this.test(actual).isEmpty()) {
            emptyList()
        } else {
            error(actual)
        }
    }

    /* Change the error message of the original TypeChecker to the provided message */
    fun withError(vararg se: String): TypeChecker = TypeChecker { actual ->
        if (this.test(actual).isEmpty()) {
            emptyList()
        } else {
            se.asList()
        }
    }

    /* Attach a piece of error message in case when the original TypeChecker fails */
    fun forwardsError(postfix: String): TypeChecker = TypeChecker { actual ->
        this.test(actual).map { "$it \n$postfix" }
    }

}
