package codegen.arm

sealed class Operand {
    sealed class Register: Operand() {
        data class Reg(val id: Int): Register() {
            fun next(offset: Int = 1): Reg = Reg(id + offset)
            fun prev(offset: Int = 1): Reg = Reg(id - offset)
            override fun toString(): String = "r$id"
        }

        object StackPtr: Register() {
            override fun toString(): String = "sp"
        }
    }
    data class ImmNum(val num: Int): Operand() {
        companion object {
            fun immTrue() = ImmNum(1)
            fun immFalse() = ImmNum(0)
            fun immNull() = ImmNum(0)
        }
    }
    data class Label(val name: String): Operand() {
        override fun toString(): String = "$name:"
    }
//    data class AbsString(val value: String): Operand() {
//        override fun toString(): String {
//            return
//        }
//    }

    data class Offset(val src: Register, val offset: Int): Operand() {
        override fun toString(): String {
            return "[$src, #$offset]"
        }
    }
}
