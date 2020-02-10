package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    data class ADD(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    data class SUB(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class MUL(val cond: Condition, val dest: Register, val rm: Register, val rs: Register): Instruction()
    // Reference Compiler uses a library function "__aeabi_idiv"
    data class DIV(val dest: Register, val rn: Register): Instruction()

    /** Comparison Operation **/
    data class CMP(val rn: Register, val opr: Operand): Instruction()

    /** Logical Operations **/
    data class MOV(val cond: Condition, val dest: Register, val opr: Operand): Instruction()
    data class AND(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    data class XOR(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()
    data class OR(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction()

    sealed class Terminator: Instruction() {
        /** Branch Operation **/
        data class B(val cond: Condition, val label: Label): Terminator()
        data class BL(val cond: Condition, val label: Label): Terminator()
        /** Pop Operation **/
        data class POP(val regList: MutableCollection<Register>)
        /** Fall-through operation -- does nothing **/
    }

    /** Load Operation **/
    data class LDR(val cond: Condition, val dest: Register, val opr: Operand): Instruction()

    /** Store Operation **/
    data class STR(val cond: Condition, val dest: Register, val opr: Operand): Instruction()

    /** Stack Operation **/
    data class PUSH(val regList:  MutableCollection<Register>): Instruction()

    enum class Condition {
        AL, EQ, NE, GT, GE, LT, LE
    }

//    abstract fun generateCode(): String
}