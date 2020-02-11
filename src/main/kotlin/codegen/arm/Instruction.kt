package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    data class Add(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "ADD$cond $dest, $rn, $opr"
    }
    data class Sub(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "SUB$cond $dest, $rn, $opr"
    }
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class Mul(val cond: Condition, val dest: Register, val rm: Register, val rs: Register): Instruction() {
        override fun toString(): String = "MUL$cond $dest, $rm, $rs"
    }
    // Reference Compiler uses a library function "__aeabi_idiv"
    data class Div(val dest: Register, val rn: Register): Instruction()

    /** Comparison Operation **/
    data class Cmp(val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "CMP $rn, $opr"
    }

    /** Logical Operations **/
    data class Mov(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "MOV$cond $dest, ${opr.inMOV()}"
    }
    data class And(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "AND$cond $dest, ${opr.inMOV()}"
    }
    data class Xor(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "XOR$cond $dest, $opr"
    }
    data class Or(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "OR$cond $dest, $opr"
    }

    sealed class Terminator: Instruction() {
        /** Branch Operation **/
        data class B(val cond: Condition, val label: Label): Terminator() {
            override fun toString(): String = "B$cond ${label.name}"
        }
        data class BL(val cond: Condition, val label: Label): Terminator() {
            override fun toString(): String = "BL$cond ${label.name}"
        }
        /** Pop Operation **/
        object PopPC: Terminator() {
            override fun toString(): String {
                return "POP {pc}"
            }
        }
        /** Fall-through operation -- does nothing **/
    }

    /** Load Operation **/
    data class Ldr(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "LDR$cond ${dest.inLDR()}, ${opr.inLDR()}"
    }

    /** Store Operation **/
    data class Str(val cond: Condition, val dest: Register, val opr: Operand): Instruction()

    /** Stack Operation **/
    data class Push(val regList: MutableList<Register>): Instruction() {
        override fun toString(): String {
            return "PUSH ${regList.joinToString(prefix = "{", separator = ", ", postfix = "}") { it.toString() }}"
        }
    }

    data class Pop(val regList: MutableList<Register>): Instruction() {
        override fun toString(): String {
            return "POP ${regList.joinToString(prefix = "{", separator = ", ", postfix = "}") { it.toString() }}"
        }
    }


    enum class Condition {
        AL {
            override fun toString(): String = ""
        },
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE
    }


    /** ARM directive **/
    data class Directive(val type: DirectiveType): Instruction() {
        override fun toString(): String = when(type) {
            DirectiveType.LTORG -> ".ltorg"
        }
    }

//    abstract fun generateCode(): String
}