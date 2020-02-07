package utils

class NumberFormatter {
    companion object {
        private val suffixes = listOf("th", "st", "nd", "rd") + (4..9).map { "th" }
        fun get(x: Int): String = "$x${suffixes[x % 10]}"
    }
}