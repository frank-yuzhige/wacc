package utils

import java.lang.StringBuilder

class EscapeCharMap {

    companion object {
        private val escCharMap = hashMapOf(
                '\u0000' to "\\0",
                '\b' to "\\b",
                '\t' to "\\t",
                '\n' to "\\n",
                '\u000C' to "\\f",
                '\r' to "\\r",
                '\'' to "\\'",
                '\"' to "\\\"",
                '\\' to "\\\\"
        )

        fun fromEscape(c: Char): String {
            val esc = escCharMap[c]
            return if (esc == null) {
                c.toString()
            } else {
                "\\$esc"
            }
        }

        fun fromEscape(str: CharSequence): CharSequence {
            val sb = StringBuilder()
            str.forEach { sb.append(fromEscape(it)) }
            return sb
        }
    }

}