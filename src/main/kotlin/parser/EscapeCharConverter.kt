package parser

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

class EscapeCharConverter(input: CharSequence) {
    private val sequence : Deque<Char>
    private val escapeMap : HashMap<Char, Char>

    init {
        sequence = input.toCollection(ArrayDeque())
        escapeMap = hashMapOf(
                '0'  to '\u0000',
                'b'  to '\b',
                't'  to '\t',
                'n'  to '\n',
                'f'  to '\u000C',
                'r'  to '\r',
                '\'' to '\'',
                '\"' to '\"',
                '\\' to '\\'
        )
    }

    fun getChar() : Char {
        val first = sequence.pop()
        if (first == '\\') {
            val next : Char = sequence.pop() ?: throw EmptyStackException()
            return escapeMap[next] ?: throw IllegalArgumentException("unknown escape character '\\$next'")
        }
        return first
    }

    fun getAll() : String {
        val result = StringBuilder()
        while (sequence.isNotEmpty()) {
            result.append(getChar())
        }
        return result.toString()
    }

}