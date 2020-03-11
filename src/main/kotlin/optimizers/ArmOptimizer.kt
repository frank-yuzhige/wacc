package optimizers
import codegen.InstructionBlock
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Instruction.Terminator.*
import codegen.arm.Operand
import codegen.arm.Operand.*
import codegen.arm.Operand.Register.*
import codegen.arm.Operand.Register.Reg.Companion.reservedRegs
import codegen.arm.SpecialRegName.*
import utils.TablePrinter
import kotlin.math.log
import kotlin.math.min

typealias Liveness = Pair<MutableSet<Register>, MutableSet<Register>>
typealias LivenessList = MutableList<Pair<Instruction, Liveness>>

class ArmOptimizer {
    enum class PeepholePattern(val patternSize: Int) {
        MULTIPLY_BY_POWER_OF_TWO(5),
        DIVIDE_BY_POWER_OF_TWO(5),
        LOAD_CONSTANT(3),
        REDUNDANT_LOAD_AFTER_STORE(2)
    }

    private val blockLivenessMap: MutableMap<String, LivenessList> = mutableMapOf()
    private val regToOffsetMap: MutableMap<Offset, Register> = mutableMapOf()
    private val patternToFunc: Map<PeepholePattern, (List<Instruction>) -> List<Instruction>> = mapOf(
            PeepholePattern.MULTIPLY_BY_POWER_OF_TWO to ::multiplyByPowerOfTwo,
            PeepholePattern.DIVIDE_BY_POWER_OF_TWO to ::divideByPowerOfTwo,
            PeepholePattern.LOAD_CONSTANT to ::loadConstant,
            PeepholePattern.REDUNDANT_LOAD_AFTER_STORE to ::redundantLoadAfterStore
    )
    private val removedLabels: MutableSet<Label> = mutableSetOf()
    private val MAX_SHIFT = 32

    fun doOptimize(armProgram: ArmProgram): ArmProgram {
        val separatedBlocks = separateBlocks(armProgram)
        val nonPreludeBlocks = separatedBlocks.first
        val preludeBlocks = separatedBlocks.second
        val optimizedBlocks = nonPreludeBlocks.map { it.doPeepHoleOptimize() }
        return ArmProgram(armProgram.stringConsts,
                          optimizedBlocks + preludeBlocks.removeUnusedBlocks())
    }

    private fun List<InstructionBlock>.removeUnusedBlocks(): List<InstructionBlock> =
            this.filterNot { removedLabels.contains(it.label) }

    private fun InstructionBlock.doPeepHoleOptimize(): InstructionBlock {
        val optimizedInstrs: MutableList<Instruction> = this.instructions.toMutableList()
        var changed: Boolean
        do {
            changed = false
            val tempInstrs = optimizedInstrs.toMutableList()
            var index = 0
            optimizedInstrs.clear()
            while (index < tempInstrs.size) {
                var optimized = false
                fun identifyPattern(patternFun: (List<Instruction>) -> List<Instruction>,
                                    patternSize: Int): List<Instruction> {
                    val lastIndex = min(tempInstrs.size, index + patternSize)
                    return if (!optimized && lastIndex == index + patternSize) {
                        val instrs = tempInstrs.subList(index, lastIndex)
                        patternFun(instrs).also {
                            if (it.isNotEmpty()) {
                                optimized = true
                                changed = true
                                index += instrs.size
                            }
                        }
                    } else {
                        emptyList()
                    }
                }
                PeepholePattern.values().forEach {
                    optimizedInstrs += identifyPattern(patternToFunc[it]!!, it.patternSize)
                }
                if (!optimized) {
                    optimizedInstrs += tempInstrs[index]
                    index++
                }
            }
        } while (changed)
        return InstructionBlock(this.label, optimizedInstrs, this.terminator, this.tails);
    }

    /**
     * Functions for checking patterns in peep hole optimization
     */
    private fun multiplyByPowerOfTwo(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: MOV rn, #n             or 0: LDR rn, =n
         * 1: SMULL rm, rn, rm, rn
         * 2: CMP rn, rm, ASR #31
         * 3: BLNE p_overflow_error
         * 4: STR rm, [offset]
         * where n is a number that is power of two
         */
        var satisfied = true
        val instr0 = instrs[0]
        var num = 0
        var dest: Register = Reg(0)
        satisfied = if ((instr0 is Mov && instr0.dest is Reg && instr0.opr is ImmNum) ||
                        (instr0 is Ldr && instr0.dest is Reg && instr0.opr is ImmNum)) {
            num = (((instr0 as? Mov)?.opr ?: (instr0 as Ldr)?.opr) as ImmNum).num
            num > 0 && (num and (num - 1)) == 0
        } else { false }
        val instr1 = instrs[1]
        satisfied = if (satisfied && (instr1 is Smull)) {
            dest = instr1.rn
            true
        } else { false }
        val instr2 = instrs[2]
        satisfied = satisfied && (instr2 is Cmp)
        val instr3 = instrs[3]
        satisfied = satisfied && (instr3 is BL && instr3.label.name == "p_overflow_error")
        val instr4 = instrs[4]
        satisfied = satisfied && (instr4 is Str && instr4.src == dest)

        return if (satisfied) {
            val power = log(num.toDouble(), 2.toDouble()).toInt()
            if (power < MAX_SHIFT) {
                listOf(Lsl(Condition.S, dest, dest, ImmNum(power)),
                       BL(Condition.E, Label("p_overflow_error"))) + instr4
            } else { emptyList() }
        } else { emptyList() }
    }

    private fun divideByPowerOfTwo(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: MOV r0, rm
         * 1: MOV r1, #n                or 1: LDR r1, =n
         * 2: BL p_check_div_by_zero
         * 3: BL __aeabi_idiv
         * 4: MOV rx, r0
         * where n is a number that is power of two
         */
        var satisfied = true
        val instr0 = instrs[0]
        var num = 0
        satisfied = instr0 is Mov && instr0.dest == Reg(0) && instr0.opr is Register
        val instr1 = instrs[1]
        satisfied = if (satisfied && ((instr1 is Mov && instr1.dest == Reg(1) && instr1.opr is ImmNum) ||
                        (instr1 is Ldr && instr1.dest == Reg(1) && instr1.opr is ImmNum))) {
            num = (((instr1 as? Mov)?.opr ?: (instr1 as Ldr).opr) as ImmNum).num
            satisfied && (num > 0 && (num and (num - 1)) == 0)
        } else { false }
        val instr2 = instrs[2]
        satisfied = satisfied && (instr2 is BL && instr2.label.name == "p_check_div_by_zero")
        val instr3 = instrs[3]
        satisfied = satisfied && (instr3 is BL && instr3.label.name == "__aeabi_idiv")
        val instr4 = instrs[4]
        satisfied = satisfied && (instr4 is Mov && instr4.opr == Reg(0))
        return if (satisfied) {
            val dest: Register = ((instr0 as? Mov)?.opr ?: (instr0 as Ldr).opr) as Register
            val power= log(num.toDouble(), 2.toDouble()).toInt()
            if (power < MAX_SHIFT) {
                removedLabels += Label("p_check_div_by_zero")
                listOf(Lsr(dest, dest, ImmNum(power)))
            } else { emptyList() }
        } else { emptyList() }
    }

    private fun loadConstant(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: MOV rn, #n       0: MOV rn, #n
         * 1: MOV rx, rn  or   1: MOV rx, rm
         * 2: MOV ry, rm       2: MOV ry, rn
         *
         * 0: LDR rn, =n       0: LDR rn, =n
         * 1: MOV rx, rn  or   1: MOV rx, rm
         * 2: MOV ry, rm       2: MOV ry, rn
         * where n is a constant
         */
        var satisfied = true
        val instr0 = instrs[0]
        var opr: Operand = ImmNum(0)
        var tempReg= Reg(0)
        satisfied = if ((instr0 is Ldr && instr0.dest is Reg) ||
                        (instr0 is Mov && instr0.dest is Reg)) {
            opr = ((instr0 as? Mov)?.opr ?: (instr0 as? Ldr)?.opr) as Operand
            tempReg = ((instr0 as? Mov)?.dest ?: (instr0 as? Ldr)?.dest) as Reg
            true
        } else { false }

        val instr1 = instrs[1]
        if (satisfied && (instr1 is Mov && instr1.opr == tempReg)) {
            return if (instr0 is Ldr) listOf(Ldr(Condition.AL, instr1.dest, opr), instrs[2]) else
                                      listOf(Mov(Condition.AL, instr1.dest, opr), instrs[2])
        } else {
            satisfied = satisfied && (instr1 is Mov && instr1.opr == tempReg)
        }

        val instr2 = instrs[2]
        if (satisfied && (instr2 is Mov && instr2.opr == tempReg)) {
            return if (instr0 is Ldr) listOf(instr1, Ldr(Condition.AL, instr2.dest, opr)) else
                                      listOf(instr1, Mov(Condition.AL, instr2.dest, opr))
        }
        return emptyList()
    }

    private fun redundantLoadAfterStore(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: STR rn, [offset]
         * 1: LDR rn, [offset]
         */
        var satisfied = true
        val instr0 = instrs[0]
        var reg: Register = Reg(0)
        var offset: Offset = Offset(SpecialReg(SP), 0)
        satisfied = if (instr0 is Str && instr0.dst is Offset && instr0.dst.src == SpecialReg(SP)) {
            reg = instr0.src
            offset = instr0.dst
            true
        } else { false }
        val instr1 = instrs[1]
        satisfied = satisfied && (instr1 is Ldr && instr1.dest == reg && instr1.opr == offset)
        return if (satisfied) {
            instrs.subList(0, 1)
        } else { emptyList() }
    }


    /**
     * Separate the instruction blocks in the arm program into two sets: the ones that are prelude functions, and
     * the ones that are not
     */
    private fun separateBlocks(arm: ArmProgram): Pair<List<InstructionBlock>, List<InstructionBlock>> {
        if (arm.blocks.size == 1) {
            return arm.blocks to emptyList()
        }
        var separationIndex = arm.blocks.size
        for ((index, instrBlock) in arm.blocks.withIndex()) {
            if (instrBlock.label.name.startsWith("p_")) {
                separationIndex = index
                break;
            }
        }
        return arm.blocks.subList(0, separationIndex) to arm.blocks.subList(separationIndex, arm.blocks.size)
    }
}