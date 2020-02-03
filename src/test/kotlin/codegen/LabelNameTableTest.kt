package codegen

import utils.LabelNameTable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LabelNameTableTest {

    private val table = LabelNameTable()

    @Test
    fun NoDuplicateLabelNamesTest() {
        val testCount = 100
        assertEquals((0 until testCount).map { table.getName("some") }.distinct().count(), testCount)
    }

    @Test
    fun PreservePrefixTest() {
        val testCount = 100
        assertTrue((0 until testCount).map { table.getName("blabla") }.all { it.startsWith("blabla") })
    }

    @Test
    fun SimilarNamesNoClashTest() {
        val names = arrayOf(
                table.getName("s"),
                table.getName("ss"),
                table.getName("s0"),
                table.getName("s1"),
                table.getName("s_"),
                table.getName("s__")
        )

        assertEquals(names.distinct().count(), names.count())
    }
}