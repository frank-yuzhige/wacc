package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    data class Add(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "ADD${if(setFlag) "S" else ""}$cond $dest, $rn, ${opr.inMOV()}"
    }
    data class Sub(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "SUB${if(setFlag) "S" else ""}$cond $dest, $rn, ${opr.inMOV()}"
    }
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class Mul(val cond: Condition, val dest: Register, val rm: Register, val rs: Register, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "MUL${if(setFlag) "S" else ""}$cond $dest, $rm, $rs"
    }

    data class Smull(val cond: Condition, val rdLo: Register, val rdHi: Register, val rn: Register, val rm: Register): Instruction() {
        override fun toString(): String = "SMULL$cond $rdLo, $rdHi, $rn, $rm"
    }

    // Reference Compiler uses a library function "__aeabi_idiv"
    data class Div(val dest: Register, val rn: Register): Instruction()

    // Reverse-sub
    data class Rsb(val s: Boolean, val cond: Condition, val dest: Register, val rn: Register, val op2: Operand): Instruction() {
        override fun toString(): String = "RSB${if(s) "S" else ""}$cond $dest, $rn, ${op2.inMOV()}"
    }

    /** Comparison Operation **/
    data class Cmp(val rn: Register, val opr: Operand, val modifier: Pair<ShiftModifier, Int>? = null): Instruction() {
        override fun toString(): String = "CMP ${rn.inMOV()}, ${opr.inMOV()}${if(modifier != null) ", ${modifier.first} #${modifier.second}" else ""}"
    }

    /** Logical Operations **/
    data class Mov(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "MOV$cond $dest, ${opr.inMOV()}"
    }
    data class And(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "AND$cond $dest, $rn, ${opr.inMOV()}"
    }
    data class Orr(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "ORR$cond $dest, $rn, ${opr.inMOV()}"
    }
    data class Eor(val cond: Condition, val dest: Register, val rn: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "EOR$cond $dest, $rn, ${opr.inMOV()}"
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
            override fun toString(): String = "POP {pc}"
        }
        /** Fall-through operation -- does nothing **/
        object FallThrough: Terminator() {
            override fun toString(): String = ""
        }
        object Unreachable: Terminator() {
            override fun toString(): String = ""
        }
    }

    /** Load Operation **/
    data class Ldr(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "LDR$cond ${dest.inLDR()}, ${opr.inLDR()}"
    }

    /** Store Operation **/
    data class Str(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "STR$cond ${dest.inLDR()}, ${opr.inLDR()}"
    }

    data class Strb(val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "STRB ${dest.inLDR()}, ${opr.inLDR()}"
    }

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
        LE,
        VS,
        CS
    }

    enum class ShiftModifier {
        ASR
    }


    /** ARM directive **/
    data class Directive(val type: DirectiveType): Instruction() {
        override fun toString(): String = when(type) {
            DirectiveType.LTORG -> ".ltorg"
        }
    }

//    abstract fun generateCode(): String
}