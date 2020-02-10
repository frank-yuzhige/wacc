package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    data class Add(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    data class Sub(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class Mul(val cond: Condition, val dest: Register, val rm: Register, val rs: Register): Instruction()
    // Reference Compiler uses a library function "__aeabi_idiv"
    data class Div(val dest: Register, val rn: Register): Instruction()

    /** Comparison Operation **/
    data class Cmp(val rn: Register, val opr: Operand): Instruction()

    /** Logical Operations **/
    data class Mov(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "MOV$cond $dest, $opr"
    }
    data class And(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "AND$cond $dest, $opr"
    }
    data class Xor(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "XOR$cond $dest, $opr"
    }
    data class Or(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "OR$cond $dest, $opr"
    }

    sealed class Terminator: Instruction() {
        /** Branch Operation **/
        data class B(val cond: Condition, val label: Label): Terminator()
        data class BL(val cond: Condition, val label: Label): Terminator()
        /** Pop Operation **/
        data class POP(val regList: MutableCollection<Register>)
        /** Fall-through operation -- does nothing **/
    }

    /** Load Operation **/
    data class Ldr(val cond: Condition, val dest: Register, val opr: Operand): Instruction()

    /** Store Operation **/
    data class Str(val cond: Condition, val dest: Register, val opr: Operand): Instruction()

    /** Stack Operation **/
    data class Push(val regList:  MutableCollection<Register>): Instruction()

    enum class Condition {
        AL,
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE
    }

//    abstract fun generateCode(): String
}