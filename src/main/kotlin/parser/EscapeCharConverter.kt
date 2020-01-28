package parser

import exceptions.SyntacticException.InvalidEscapeCharException
import java.lang.StringBuilder
import java.util.*
import kotlin.NoSuchElementException
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
        if (sequence.isEmpty()) throw NoSuchElementException()
        val first = sequence.pop()
        if (first == '\\') {
            if (sequence.isEmpty()) throw InvalidEscapeCharException(null)
            val next  = sequence.pop()
            return escapeMap[next] ?: throw InvalidEscapeCharException(next)
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