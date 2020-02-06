package utils

import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.asciitable.CWC_LongestLine
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.CENTER

class TablePrinter(vararg title: String) {
    private val titles: List<String> = title.toList()
    private val entries: MutableList<List<String>> = arrayListOf()
    private val intColumns: MutableSet<Int> = hashSetOf()
    private val sortByList: MutableList<Int> = arrayListOf(0)

    fun addColumn(vararg data: Any): TablePrinter = this.also {
        entries += data.map { it.toString() }
    }

    fun markIntColumn(vararg column: Int): TablePrinter = this.also {
        intColumns += column.toList()
    }

    fun sortBy(vararg column: Int): TablePrinter = this.also {
        sortByList.clear()
        sortByList += column.toList()
    }

    fun print(): String {
        val table = AsciiTable()

        table.addRule()
        table.addRow(titles).setTextAlignment(CENTER).setPaddingLeftRight(1)
        table.addRule()
        entries.sortedWith(compareStrategy())
                .forEach { table.addRow(it).setTextAlignment(CENTER).setPaddingLeftRight(1); table.addRule() }

        table.renderer.cwc = CWC_LongestLine()
        return table.render()
    }

    private fun compareStrategy(): Comparator<List<String>> {
        val existingCols = sortByList.filter { it < titles.size && it >= 0 }
        val comparators = existingCols.map { col ->
            if (intColumns.contains(col)) {
                compareBy { list: List<String> -> list[col].toInt() }
            } else {
                compareBy { list: List<String> -> list[col] }
            }
        }
        return comparators.reduce { a, b -> a then b }
    }
}