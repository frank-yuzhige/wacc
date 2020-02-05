package semantics

import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.*


class TypeChecker private constructor(val test: (Type) -> List<String>) {

    companion object {
        private infix fun ((Type) -> Boolean).throws(error: (Type) -> String): TypeChecker {
            return TypeChecker { actual ->
                if (this(actual)) {
                    emptyList()
                } else {
                    listOf(error(actual))
                }
            }
        }

        fun pass() = TypeChecker { emptyList() }

        fun fail(error: String) = TypeChecker { listOf(error) }

        private fun isJust(expected: Type) = { actual: Type ->
            when {
                actual == BaseType(ANY) || expected == BaseType(ANY) -> true
                else -> expected == actual
            }
        } throws { actual ->
            typeMismatchError(expected, actual)
        }

        fun isOneOf(vararg candidates: Type) = (candidates::contains) throws { actual ->
            "couldn't match any of the expecting types:" +
                    " ${candidates.joinToString(", ") { it.toString() }}" +
                    "with actual type: $actual"
        }

        fun match(expected: Type): TypeChecker = when (expected) {
            BaseType(ANY) -> pass()
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
                when {
                    actual is BaseType && actual.kind == ANY -> emptyList()
                    actual is BaseType && actual.kind == STRING -> {
                        if (expected.type == Type.charType()) {
                            emptyList()
                        } else {
                            listOf(typeMismatchError(expected, actual))
                        }
                    }
                    actual is ArrayType -> match(expected.type)
                            .withError(typeMismatchError(expected, actual))
                            .test(actual.type)
                    else -> listOf(typeMismatchError(expected, actual))
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
                    FST -> tc.test(actual.firstElemType)
                    SND -> tc.test(actual.secondElemType)
                }
                else -> listOf("Expecting a pair, but $actual is not a pair!")
            }
        }

        fun unwrapPair(func: PairElemFunction, tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            when (func) {
               FST -> tc.test(PairType(actual, BaseType(ANY)))
               SND -> tc.test(PairType(BaseType(ANY), actual))
            }
        }

        fun unwrapArray(tc: TypeChecker): TypeChecker = TypeChecker { actual ->
            tc.test(ArrayType(actual))
        }
    }

    infix fun `||`(other: TypeChecker): TypeChecker = TypeChecker { actual ->
        val fst = this.test(actual)
        if (fst.isNotEmpty()) {
            other.test(actual)
        } else {
            fst
        }
    }

    fun withError(vararg se: String): TypeChecker = TypeChecker { actual ->
        if (this.test(actual).isEmpty()) {
            emptyList()
        } else {
            se.asList()
        }
    }

    fun forwardsError(postfix: String): TypeChecker = TypeChecker {  actual ->
        this.test(actual).map { "$it \n$postfix" }
    }

}
