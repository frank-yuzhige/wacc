package semantics

import ast.Expression
import ast.Expression.Identifier
import ast.Expression.IntLit
import ast.ProgramAST
import ast.Statement
import ast.Statement.*
import ast.Type
import ast.Type.Companion.intType
import parser.Parser
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class SymbolTableTest {
    private val x1 = Identifier("x")
    private val x2 = Identifier("x")
    private val x3 = Identifier("x")
    private val y = Identifier("y")
    private val def = Declaration(intType(), x1, IntLit(1))

    @Test
    fun symbolTableRecordsIndexTest() {
        x1.scopeId = -1
        SemanticAnalyzer().doCheck(ProgramAST(emptyList(), listOf(def)))
        assertNotEquals(x1.scopeId, -1)
    }

    @Test
    fun sameVarHaveSameIdTest() {
        val mainProg = listOf(
                Declaration(intType(), x1, IntLit(1)),
                Assignment(x2, IntLit(2)),
                Block(listOf(
                        Assignment(x3, IntLit(3))
                ))
        )
        val prog = ProgramAST(emptyList(), mainProg)
        SemanticAnalyzer().doCheck(prog)
        assertEquals(x1.scopeId, x2.scopeId)
        assertEquals(x1.scopeId, x3.scopeId)
    }

    @Test
    fun sameVarInDiffScopeTest() {
        val mainProg = listOf(
                Declaration(intType(), x1, IntLit(1)),
                Assignment(x2, IntLit(2)),
                Block(listOf(
                        Declaration(intType(), Identifier("x"), IntLit(1)),
                        Assignment(x3, IntLit(3))
                ))
        )
        val prog = ProgramAST(emptyList(), mainProg)
        SemanticAnalyzer().doCheck(prog)
        assertNotEquals(x2.scopeId, x3.scopeId)
    }

}