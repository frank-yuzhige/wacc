package parser

import ast.Expression
import ast.Expression.*
import java.lang.AssertionError
import java.lang.StringBuilder
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ExpressionParserTest {

    fun<T> batchCheck(candidates : Iterable<T>
                      , predicate: (T) -> Boolean
                      , prettyPrinter : (T) -> String = { it.toString() }) {
        val failCases = mutableListOf<T>()
        candidates
                .filterNot { predicate(it) }
                .forEach { failCases += it }
        if (failCases.isNotEmpty()) {
            fail(" Failed cases: ${failCases.joinToString("") { prettyPrinter(it) }}")
        }
    }

    @Test
    fun parseIntLitTest() {
        val ints = listOf(1, 43, -28, 223, 141552, -2023, Int.MAX_VALUE, Int.MIN_VALUE)
        batchCheck(ints, { Parser(it.toString()).parseExpression() == IntLit(it) })
    }

    @Test
    fun parseBoolLitTest() {
        assertEquals(Parser("true").parseExpression(), BoolLit(true))
        assertEquals(Parser("false").parseExpression(), BoolLit(false))
    }

    @Test
    fun parseCharLitTest() {
        val chars = "abAB123 @#<>:;?/\b\t\n\r\"\'\\\u000C\u0000"
        batchCheck(chars.toList(), { Parser(it.toString()).parseExpression() == CharLit(it) }, { "'$it'"})
    }

    @Test
    fun parseStringLitTest() {
        val strings = listOf("hello world", "hello \n\t\\ world", "hello \\\"world\\\"")
        batchCheck(strings, { Parser("\"$it\"").parseExpression() == StringLit(it) }, { "\"$it\""})
    }

    @Test
    fun parseIdentifierTest() {
        val idents = listOf("x", "y", "_a", "PascalCase", "camelCase", "snake_case", "INSANE_CAPITALISM", "x1", "l33t", "_")
        batchCheck(idents, { Parser(it).parseExpression() == Identifier(it) })
    }

    fun parseUnaryOperatorTest() {
        
    }
}