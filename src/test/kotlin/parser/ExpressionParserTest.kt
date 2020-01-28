package parser

import ast.Expression.*
import ast.UnaryOperator
import cartesianProduct
import toInputStream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class ExpressionParserTest {

    private val commonExprs = listOf("x", "12", "'c'", "\"hello world\"")

    fun <T> batchCheck(candidates: Iterable<T>,
                       predicate: (T) -> Boolean,
                       prettyPrinter: (T) -> String = { it.toString() }) {
        val failCases = candidates.filterNot { predicate(it) }
        if (failCases.isNotEmpty()) {
            fail(" Failed cases: ${failCases.joinToString("") { prettyPrinter(it) }}")
        }
    }

    @Test
    fun parseIntLitTest() {
        val ints = listOf(1, 43, -28, 223, 141552, -2023, Int.MAX_VALUE, Int.MIN_VALUE)
        batchCheck(ints, { Parser(toInputStream(it)).parseExpression() == IntLit(it) })
    }

    @Test
    fun parseBoolLitTest() {
        assertEquals(Parser("true".byteInputStream()).parseExpression(), BoolLit(true))
        assertEquals(Parser("false".byteInputStream()).parseExpression(), BoolLit(false))
    }

    @Test
    fun parseCharLitTest() {
        val chars = "abAB123 @#<>:;?/^&".toList()
        batchCheck(chars, { Parser("'$it'".byteInputStream()).parseExpression() == CharLit(it) }, { "'$it'" })
        val escapeMap : Map<Char, Char> = hashMapOf(
                'b' to '\b',
                't' to '\t',
                'n' to '\n',
                'r' to '\r',
                '"' to '\"',
                '\'' to '\'',
                'f' to '\u000c',
                '0' to '\u0000'
        )
        batchCheck(escapeMap.keys, { Parser("'\\$it'".byteInputStream()).parseExpression() == CharLit(escapeMap.getValue(it)) }, { "'$it'" })
    }

    @Test
    fun parseStringLitTest() {
        val strings = listOf("hello world", "hello \n\t world", "hello \\\"world\\\"")
        batchCheck(strings,
                { Parser("\"$it\"".byteInputStream()).parseExpression() == StringLit(EscapeCharConverter(it).getAll()) },
                { "\"$it\"" })
    }

    @Test
    fun parseIdentifierTest() {
        val idents = listOf("x", "y", "_a", "PascalCase", "camelCase", "snake_case", "INSANE_CAPITALISM", "x1", "l33t", "_")
        batchCheck(idents, { Parser(it.byteInputStream()).parseExpression() == Identifier(it) })
    }

    @Test
    fun parseUnaryOperatorTest() {
        val unaryOps = UnaryOperator.keyValueMap
        val candidates = cartesianProduct(unaryOps.keys, commonExprs)
        val batchChecker : (Pair<String, String>) -> Boolean = { pair ->
            val fullExpr = pair.first + " " + pair.second
            val parsedExpr = Parser(fullExpr.byteInputStream()).parseExpression()
            val op = unaryOps.getValue(pair.first)
            val expr = Parser(pair.second.byteInputStream()).parseExpression()
            parsedExpr == UnaryExpr(op, expr)
        }
        /** Exclude "- 12" case since it will be parsed to intlit -12 **/
        batchCheck(candidates.filterNot{ it == "-" to "12" }, batchChecker)
    }
}