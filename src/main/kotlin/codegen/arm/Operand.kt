package codegen.arm

import ast.WaccAST

sealed class Operand {

    open fun inMOV(): String = toString()
    open fun inLDR(): String = toString()

    sealed class Register: Operand() {
        data class Reg(val id: Int): Register() {
            fun next(offset: Int = 1): Reg = Reg(id + offset)
            fun prev(offset: Int = 1): Reg = Reg(id - offset)
            override fun toString(): String = "r$id"
        }

        data class SpecialReg(val name: SpecialRegName): Register() {
            override fun toString(): String {
                return name.toString().toLowerCase()
            }
        }
    }
    data class ImmNum(val num: Int): Operand() {
        companion object {
            fun immTrue() = ImmNum(1)
            fun immFalse() = ImmNum(0)
            fun immNull() = ImmNum(0)
        }

        override fun toString(): String = num.toString()
        override fun inMOV(): String = "#$this"
        override fun inLDR(): String = "=$this"
    }
    data class Label(val name: String): Operand() {
        override fun toString(): String = name
        override fun inLDR(): String = "=$name"
    }

    data class Offset(val src: Register, val offset: Int = 0, val wb: Boolean = false): Operand() {
        override fun toString(): String {
            return if (offset == 0) {
                "[$src]${if (wb) "!" else "" }"
            } else {
                "[$src, #$offset]${if (wb) "!" else "" }"
            }
        }

        fun shift(amount: Int): Operand = Offset(src, offset + amount, wb)
    }

    /** Reference to a named instruction **/
    data class LocalReference(val name: Int) {
        override fun toString(): String = "%$name"
    }
}
