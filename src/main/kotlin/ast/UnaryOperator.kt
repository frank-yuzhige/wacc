package ast

class UnaryOperator(val op : String) {
    override fun toString(): String = op
    companion object {
        fun opOrd() = UnaryOperator("ord")
        fun opChr() = UnaryOperator("chr")
        fun opLen() = UnaryOperator("len")
        fun opNeg() = UnaryOperator("-")
        fun opNot() = UnaryOperator("!")
    }
}