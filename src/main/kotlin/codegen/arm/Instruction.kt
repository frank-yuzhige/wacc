package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    data class ADD(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand)
    data class SUB(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand)
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class MUL(val cond: Condition, val dest: Register, val rm: Register, val rs: Register)
    // Reference Compiler uses a library function "__aeabi_idiv"
    data class DIV(val dest: Register, val rn: Register)

    /** Comparison Operation **/
    data class CMP(val cond: Condition, val rn: Register, val opr: Operand)

    /** Logical Operations **/
    data class MOV(val cond: Condition, val dest: Register, val opr: Operand)
    data class AND(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand)
    data class XOR(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand)
    data class OR(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand)

    /** Branch Operation **/
    data class BL(val cond: Condition, val label: Label)

    /** Load Operation **/
    data class LDR(val cond: Condition, val dest: Register, val opr: Operand)

    /** Store Operation **/
    data class STR(val cond: Condition, val dest: Register, val opr: Operand)

    /** Stack Operation **/
    data class PUSH(val regList:  MutableCollection<Register>)

    /** Pop Operation **/
    data class POP(val regList: MutableCollection<Register>)

    enum class Condition {
        NONE, EQ, NE, GT, GE, LT, LE
    }

    abstract fun generateCode(): String
}