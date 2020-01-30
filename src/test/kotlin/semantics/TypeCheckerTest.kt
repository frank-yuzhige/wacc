package semantics

import ast.Type
import ast.Type.*
import ast.Type.BaseTypeKind.ANY
import ast.Type.BaseTypeKind.ANYOUT
import ast.Type.Companion.anyPairType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.nullType
import ast.Type.Companion.stringType
import semantics.TypeChecker.Companion.match
import java.lang.Exception
import kotlin.test.Test
import kotlin.test.assertTrue

class TypeCheckerTest {

    fun pass(errors: List<Exception>) = assertTrue(errors.isEmpty())
    fun fail(errors: List<Exception>) = assertTrue(errors.isNotEmpty())

    @Test
    fun checkBasicTypeTest() {
        pass(match(intType()).check(intType()))
        pass(match(charType()).check(charType()))
        pass(match(boolType()).check(boolType()))
        pass(match(stringType()).check(stringType()))
    }

    @Test
    fun checkArrayTypeTest() {
        val candidates = listOf(
                ArrayType(intType()),
                ArrayType(ArrayType(ArrayType(charType()))),
                ArrayType(PairType(intType(), boolType()))
        )
        candidates.forEach { pass(match(it).check(it)) }
    }

    @Test
    fun checkPairTypeTest() {
        val pairs = listOf(
                PairType(intType(), charType()),
                PairType(anyPairType(), boolType()),
                PairType(anyPairType(), anyPairType())
        )
        pairs.forEach { pass(match(it).check(it)) }
    }

    @Test
    fun anyCheckTypeTest() {
        val any = BaseType(ANY)
        pass(match(any).check(intType()))
        pass(match(any).check(ArrayType(ArrayType(ArrayType(charType())))))
        pass(match(any).check(PairType(intType(), intType())))


    }

    @Test
    fun pairBaseTypeTest() {
        val any = BaseType(ANY)
        pass(match(anyPairType()).check(PairType(intType(), intType())))
        pass(match(anyPairType()).check(PairType(intType(), anyPairType())))
        match(anyPairType()).check(anyPairType())
        match(PairType(intType(), anyPairType())).check(anyPairType())
    }

    @Test
    fun checkAnyoutTypeTest() {
        pass(match(intType()).check(BaseType(ANYOUT)))
        pass(match(ArrayType(ArrayType(ArrayType(charType())))).check(BaseType(ANYOUT)))
        pass(match(PairType(anyPairType(), intType())).check(BaseType(ANYOUT)))
    }

}