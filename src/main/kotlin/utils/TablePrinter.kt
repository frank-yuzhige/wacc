package utils

import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.asciitable.AsciiTableTheme
import de.vandermeer.asciitable.CWC_LongestLine
import de.vandermeer.asciitable.CWC_LongestWord
import de.vandermeer.asciithemes.TA_Border
import de.vandermeer.asciithemes.TA_GridThemes
import de.vandermeer.skb.interfaces.document.TableRowStyle
import de.vandermeer.skb.interfaces.document.TableRowStyle.*
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment.*
import de.vandermeer.skb.interfaces.translators.TargetTranslator
import semantics.variableAlreadyDefined
import java.lang.StringBuilder
import kotlin.math.max

class TablePrinter (vararg title: String) {
    private val titles: List<String> = title.toList()
    private val entries: MutableList<List<String>> = arrayListOf()

    fun addColumn(vararg data: Any) {
        entries += data.map { it.toString() }
    }

    fun print(): String {
        val table = AsciiTable()

        table.addRule()
        table.addRow(titles).setTextAlignment(CENTER).setPaddingLeftRight(1)
        table.addRule()
        entries.sortedBy { it[0] }
                .forEach { table.addRow(it).setTextAlignment(CENTER).setPaddingLeftRight(1); table.addRule() }

        table.renderer.cwc = CWC_LongestLine()
        return table.render()
    }
}