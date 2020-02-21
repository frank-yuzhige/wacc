package codegen.arm

import codegen.arm.Operand.Register
import codegen.arm.Operand.Label

sealed class Instruction {

    open fun getDefs(): List<Register> = emptyList()
    open fun getUses(): List<Register> = emptyList()
    open fun adjustBySpOffset(offset: Int): Instruction = this

    /** Arithmetic Operations **/
    // Rd := Rn + Op
    class Add(val cond: Condition, val dest: Register, val rn: Register, var opr: Operand, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "ADD${if(setFlag) "S" else ""}$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
        override fun adjustBySpOffset(offset: Int): Instruction {
            return this.also { opr = opr.adjustBySpOffset(offset) }
        }
    }
    data class Sub(val cond: Condition, val dest: Register, val rn: Register, var opr: Operand, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "SUB${if(setFlag) "S" else ""}$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
        override fun adjustBySpOffset(offset: Int): Instruction {
            return this.also { opr = opr.adjustBySpOffset(offset) }
        }
    }
    // Reference compiler did not use MUL, but uses SMULL instead, @TODO: Investigate this
    data class Mul(val cond: Condition, val dest: Register, val rm: Register, val rs: Register, val setFlag: Boolean = false): Instruction() {
        override fun toString(): String = "MUL${if(setFlag) "S" else ""}$cond $dest, $rm, $rs"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = listOf(rm, rs)
    }

    data class Smull(val cond: Condition, val rdLo: Register, val rdHi: Register, val rn: Register, val rm: Register): Instruction() {
        override fun toString(): String = "SMULL$cond $rdLo, $rdHi, $rn, $rm"
        override fun getDefs(): List<Register> = listOf(rdLo, rdHi)
        override fun getUses(): List<Register> = listOf(rn, rm)
    }

    // Reference Compiler uses a library function "__aeabi_idiv"
    data class Div(val dest: Register, val rn: Register): Instruction() {
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = listOf(rn)
    }

    // Reverse-sub
    data class Rsb(val s: Boolean, val cond: Condition, val dest: Register, val rn: Register, var opr: Operand): Instruction() {
        override fun toString(): String = "RSB${if(s) "S" else ""}$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs()
        override fun adjustBySpOffset(offset: Int): Instruction {
            return this.also { opr = opr.adjustBySpOffset(offset) }
        }
    }

    /** Comparison Operation **/
    data class Cmp(val rn: Register, var opr: Operand, val modifier: Pair<ShiftModifier, Int>? = null): Instruction() {
        override fun toString(): String = "CMP ${rn.inMOV()}, ${opr.inMOV()}${if(modifier != null) ", ${modifier.first} #${modifier.second}" else ""}"
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
        override fun adjustBySpOffset(offset: Int): Instruction {
            return this.also { opr = opr.adjustBySpOffset(offset) }
        }
    }

    /** Logical Operations **/
    data class Mov(val cond: Condition, val dest: Register, var opr: Operand): Instruction() {
        override fun toString(): String = "MOV$cond $dest, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs()
    }
    data class And(val cond: Condition, val dest: Register, val rn: Register, var opr: Operand): Instruction() {
        override fun toString(): String = "AND$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
    }
    data class Orr(val cond: Condition, val dest: Register, val rn: Register, var opr: Operand): Instruction() {
        override fun toString(): String = "ORR$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
    }
    data class Eor(val cond: Condition, val dest: Register, val rn: Register, var opr: Operand): Instruction() {
        override fun toString(): String = "EOR$cond $dest, $rn, ${opr.inMOV()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = opr.getAllRegs() + rn
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
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = if (opr is Register) listOf(opr) else emptyList()
        override fun adjustBySpOffset(offset: Int): Instruction {
            return Ldr(cond, dest, opr.adjustBySpOffset(offset))
        }
    }

    data class Ldrsb(val cond: Condition, val dest: Register, val opr: Operand): Instruction() {
        override fun toString(): String = "LDRSB$cond ${dest.inLDR()}, ${opr.inLDR()}"
        override fun getDefs(): List<Register> = listOf(dest)
        override fun getUses(): List<Register> = if (opr is Register) listOf(opr) else emptyList()
        override fun adjustBySpOffset(offset: Int): Instruction {
            return Ldrsb(cond, dest, opr.adjustBySpOffset(offset))
        }
    }

    /** Store Operation **/
    data class Str(val cond: Condition, val src: Register, val dst: Operand): Instruction() {
        override fun toString(): String = "STR$cond ${src.inLDR()}, ${dst.inLDR()}"
        override fun getDefs(): List<Register> = emptyList()
        override fun getUses(): List<Register> = listOf(src) + dst.getAllRegs()
        override fun adjustBySpOffset(offset: Int): Instruction {
            return Str(cond, src, dst.adjustBySpOffset(offset))
        }
    }

    data class Strb(val src: Register, val dst: Operand): Instruction() {
        override fun toString(): String = "STRB ${src.inLDR()}, ${dst.inLDR()}"
        override fun getDefs(): List<Register> = emptyList()
        override fun getUses(): List<Register> = listOf(src) + dst.getAllRegs()
        override fun adjustBySpOffset(offset: Int): Instruction {
            return Strb(src, dst.adjustBySpOffset(offset))
        }
    }

    /** Stack Operation **/
    data class Push(val regList: MutableList<out Register>): Instruction() {
        override fun toString(): String {
            return "PUSH ${regList.joinToString(prefix = "{", separator = ", ", postfix = "}") { it.toString() }}"
        }
        override fun getUses(): List<Register> = regList
    }

    data class Pop(val regList: MutableList<out Register>): Instruction() {
        override fun toString(): String {
            return "POP ${regList.joinToString(prefix = "{", separator = ", ", postfix = "}") { it.toString() }}"
        }
        override fun getDefs(): List<Register> = regList
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

    /** Named instruction which can be referenced as operands **/
    class Named (val name: Int, val instr: Instruction): Instruction() {
        override fun toString(): String {
            return "%$name = $instr"
        }
    }
}