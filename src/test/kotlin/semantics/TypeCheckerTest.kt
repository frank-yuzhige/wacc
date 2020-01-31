package semantics

import ast.Type.*
import ast.Type.BaseTypeKind.ANY
import ast.Type.Companion.anyPairType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
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
        pass(match(intType()).test(intType()))
        pass(match(charType()).test(charType()))
        pass(match(boolType()).test(boolType()))
        pass(match(stringType()).test(stringType()))
    }

    @Test
    fun checkArrayTypeTest() {
        val candidates = listOf(
                ArrayType(intType()),
                ArrayType(ArrayType(ArrayType(charType()))),
                ArrayType(PairType(intType(), boolType()))
        )
        candidates.forEach { pass(match(it).test(it)) }
    }

    @Test
    fun checkPairTypeTest() {
        val pairs = listOf(
                PairType(intType(), charType()),
                PairType(anyPairType(), boolType()),
                PairType(anyPairType(), anyPairType())
        )
        pairs.forEach { pass(match(it).test(it)) }
    }

    @Test
    fun anyCheckTypeTest() {
        val any = BaseType(ANY)
        pass(match(any).test(intType()))
        pass(match(any).test(ArrayType(ArrayType(ArrayType(charType())))))
        pass(match(any).test(PairType(intType(), intType())))


    }

    @Test
    fun pairBaseTypeTest() {
        val any = BaseType(ANY)
        pass(match(anyPairType()).test(PairType(intType(), intType())))
        pass(match(anyPairType()).test(PairType(intType(), anyPairType())))
        match(anyPairType()).test(anyPairType())
        match(PairType(intType(), anyPairType())).test(anyPairType())
    }

    @Test
    fun checkAnyoutTypeTest() {
        pass(match(intType()).test(BaseType(ANY)))
        pass(match(ArrayType(ArrayType(ArrayType(charType())))).test(BaseType(ANY)))
        pass(match(PairType(anyPairType(), intType())).test(BaseType(ANY)))
    }

}