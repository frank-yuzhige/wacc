package parser

import kotlin.test.Test
import exceptions.SyntacticException
import exceptions.SyntacticException.*
import kotlin.test.assertTrue
import kotlin.test.fail

class LexerParserFailureTest {

    @Test
    fun antlrParseFailOnUndefinedType() {
        val prog = "begin auto x = 66 end"
        try {
            Parser(prog.byteInputStream()).parseProgram()
            fail("An error should have been thrown here!")
        } catch (ipe: SyntacticException) {
            assertTrue(ipe.msg.contains("Parse Error at \\(\\d+, \\d+\\):".toRegex()))
        }
    }

    @Test
    fun antlrParseFailCatchMultipleErrors() {
        val prog = "begin auto x = 128; int x == 1 end"
        try {
            Parser(prog.byteInputStream()).parseProgram()
            fail("An error should have been thrown here!")
        } catch (ipe: SyntacticExceptionBundle) {
            assertTrue(ipe.count == 2)
            assertTrue(ipe.msg.contains("Parse Error at \\(\\d+, \\d+\\):".toRegex()))
        }
    }


    @Test
    fun parseFailOnLargeInteger() {
        val prog = "begin int x = 10000000000000000000 end"
        try {
            Parser(prog.byteInputStream()).parseProgram()
            fail("An error should have been thrown here!")
        } catch (ipe: SyntacticExceptionBundle) {
            assertTrue(ipe.msg.contains("not a valid integer"))
            assertTrue(ipe.msg.contains("pure expression"))
            assertTrue(ipe.msg.contains("statement"))
        }
    }
}