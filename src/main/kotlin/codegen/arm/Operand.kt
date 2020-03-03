package codegen.arm

import ast.WaccAST
import codegen.arm.SpecialRegName.SP

sealed class Operand {

    open fun inMOV(): String = toString()
    open fun inLDR(): String = toString()
    open fun getAllRegs(): List<Register> = emptyList()
    open fun adjustBySpOffset(offset: Int): Operand = this

    sealed class Register: Operand() {
        override fun getAllRegs(): List<Register> = listOf(this)
        data class Reg(val id: Int): Register() {
            companion object {
                fun reservedRegs(): List<Reg> = (0..3).map(::Reg)
                fun normalRegs(): List<Reg> = (4..11).map(::Reg)
            }

            fun next(offset: Int = 1): Reg = Reg(id + offset)
            fun prev(offset: Int = 1): Reg = Reg(id - offset)
            override fun toString(): String = "r$id"
        }

        data class VReg(val id: Int): Register() {
            override fun toString(): String = "v$id"
        }

        data class SpecialReg(val name: SpecialRegName): Register() {
            companion object {
                fun sp(): SpecialReg = SpecialReg(SP)
            }
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
        override fun getAllRegs(): List<Register> = listOf(src)
        override fun toString(): String {
            return if (offset == 0) {
                "[$src]${if (wb) "!" else "" }"
            } else {
                "[$src, #$offset]${if (wb) "!" else "" }"
            }
        }

        override fun adjustBySpOffset(offset: Int) = if(src == Register.SpecialReg(SP)) shift(offset) else this

        fun shift(amount: Int): Operand = Offset(src, offset + amount, wb)
    }
}
