package ast

class BinaryOperator(val op : String, val precedence : Int) {
    override fun toString(): String = op
    companion object {
        fun opMul() = BinaryOperator("*", 1)
        fun opDiv() = BinaryOperator("/", 1)
        fun opMod() = BinaryOperator("%", 1)
        fun opAdd() = BinaryOperator("+", 2)
        fun opSub() = BinaryOperator("-", 2)
    }
}