package optimizers
import codegen.InstructionBlock
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Instruction.Terminator.*
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
        LOAD_LARGE_IMM_NUM(3),
        REDUNDANT_LOAD_AFTER_STORE(2)
    }

    private val blockLivenessMap: MutableMap<String, LivenessList> = mutableMapOf()
    private val regToOffsetMap: MutableMap<Offset, Register> = mutableMapOf()
    private val patternToFunc: Map<PeepholePattern, (List<Instruction>) -> List<Instruction>> = mapOf(
            PeepholePattern.MULTIPLY_BY_POWER_OF_TWO to ::multiplyByPowerOfTwo,
            PeepholePattern.DIVIDE_BY_POWER_OF_TWO to ::divideByPowerOfTwo,
            PeepholePattern.LOAD_LARGE_IMM_NUM to ::loadLargeImmNum,
            PeepholePattern.REDUNDANT_LOAD_AFTER_STORE to ::redundantLoadAfterStore
    )

    private val MAX_SHIFT = 32
    var linesReduced = 0

    fun doOptimize(armProgram: ArmProgram): ArmProgram {
        val separatedBlocks = separateBlocks(armProgram)
        val nonPreludeBlocks = separatedBlocks.first
        val preludeBlocks = separatedBlocks.second
        val optimizedBlocks = nonPreludeBlocks.map { it.doPeepHoleOptimize() }
        val usedLabels = optimizedBlocks.flatMap { it.getUsedLabels() }
                                                   .let { preludeBlocks.getLabelTransitiveClosure(it) }
        return ArmProgram(armProgram.stringConsts,
                          optimizedBlocks + preludeBlocks.removeUnusedBlocks(usedLabels))
    }

    private fun List<InstructionBlock>.removeUnusedBlocks(usedLabels: List<Label>): List<InstructionBlock> =
            this.filter { usedLabels.contains(it.label).also { used -> if(!used) { linesReduced += it.getInstrCount() } } }

    private fun List<InstructionBlock>.getLabelTransitiveClosure(usedLabels: List<Label>): List<Label> {
        val result = usedLabels.toMutableList()
        this.forEach {
            if (usedLabels.contains(it.label)) {
                result.addAll(it.getUsedLabels())
            }
        }
        return result
    }

    private fun InstructionBlock.getUsedLabels(): List<Label> = (this.instructions + this.terminator)
                    .filter { it is BL || it is B }
                    .map { ((it as? BL)?.label ?: (it as? B)?.label)!! }

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
                                linesReduced += (instrs.size - it.size)
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
                listOf(Lsr(dest, dest, ImmNum(power)))
            } else { emptyList() }
        } else { emptyList() }
    }

    private fun loadLargeImmNum(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: LDR rn, =n       0: LDR rn, =n
         * 1: MOV rx, rn  or   1: MOV rx, rm
         * 2: MOV ry, rm       2: MOV ry, rn
         */
        var satisfied = true
        val instr0 = instrs[0]
        var num = ImmNum(0)
        var tempReg= Reg(0)
        satisfied = if (instr0 is Ldr && instr0.dest is Reg && instr0.opr is ImmNum) {
            num = instr0.opr
            tempReg = instr0.dest
            true
        } else { false }

        val instr1 = instrs[1]
        if (satisfied && (instr1 is Mov && instr1.opr == tempReg)) {
            return listOf(Ldr(Condition.AL, instr1.dest, num), instrs[2])
        }

        val instr2 = instrs[2]
        if (satisfied && (instr2 is Mov && instr2.opr == tempReg)) {
            return listOf(instr1, Ldr(Condition.AL, instr2.dest, num))
        }
        return emptyList()
    }

    private fun redundantLoadAfterStore(instrs: List<Instruction>): List<Instruction> {
        /**
         * Pattern:
         * 0: LDR rn, [offset]
         * 1: STR rn, [offset]
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
        var separationIndex = arm.blocks.size - 1
        for ((index, instrBlock) in arm.blocks.withIndex()) {
            if (instrBlock.label.name.startsWith("p_")) {
                separationIndex = index
                break;
            }
        }
        return arm.blocks.subList(0, separationIndex) to arm.blocks.subList(separationIndex, arm.blocks.size)
    }

    /**
     * Performs liveness analysis on the given code block
     */
    /*
    private fun InstructionBlock.performLivenessAnalysis() {
        var currLiveness: LivenessList = blockLivenessMap[this.label.name]!!
        var preLiveness: LivenessList
        do {
            preLiveness = clone(currLiveness)
            analyze(currLiveness)
        } while (currLiveness != preLiveness)
    }
    */

    private fun analyze(livenessList: LivenessList) {
        livenessList.forEachIndexed { i, (instr, liveness) ->
            if (instr is Str && instr.dst is Offset && instr.dst.src == SpecialReg(SP)) {
                regToOffsetMap[instr.dst] = instr.src
            }
            if (!instr.isVarDefInstr()) {
                // LiveIn(n) = uses(n) U (LiveOut(n) - defs(n))
                liveness.liveIn().clear()
                liveness.liveIn().addAll(
                        instr.uses().toMutableSet() + (liveness.liveOut() - instr.defs().toMutableSet()))

                // LiveOut(n) = U (s belongs to succ(n)) LiveIn(s)
                liveness.liveOut().clear()
                val liveOut = getSuccessors(i, livenessList).flatMap { it.second.liveIn().also { it } }
                liveness.liveOut().addAll(liveOut)
            }
        }
    }

    /**
     * Remove dead code if the instruction node satisfies the following condition:
     * There is only one virtual register in the defs set of the instruction node and
     * the virtual register defined is not in the liveOut set.
     */
    private fun InstructionBlock.sweepDeadCode(): InstructionBlock {
        val currLivenessList = blockLivenessMap[this.label.name]!!
        val filteredInstrs: MutableList<Instruction> = mutableListOf()
        var isDeadCodeMarker = true
        this.instructions.forEachIndexed { index, instr ->
            if (instr.isCritical()) {
                filteredInstrs += instr
            } else {
                if (instr.isDiscreteInstr()) {
                    isDeadCodeMarker = isDeadCode(index, currLivenessList)
                }
                if (!isDeadCodeMarker) {
                    filteredInstrs += instr
                }
            }
        }
        return InstructionBlock(this.label, filteredInstrs, this.terminator, this.tails)
    }

    private fun isDeadCode(index: Int, livenessList: LivenessList): Boolean {
        val defs = livenessList[index].first.defs()
        return defs.size == 1 && !livenessList[index].second.liveOut().contains(defs[0])
    }

    private fun dumpLivenessMap() {
        val blocks = blockLivenessMap.map { (label, livenessList) ->
            val body = "$label:\n"
            val tp = TablePrinter("#", "Instruction", "LiveIn", "LiveOut").markIntColumn(0).sortBy(0)
            livenessList.mapIndexed{ i, (instr, liveness) ->
                tp.addColumn(i, instr.toString(), liveness.first, liveness.second)
            }
            body + tp.print()
        }
        println(blocks.joinToString("\n"))
    }

    private fun Liveness.liveIn(): MutableSet<Register> = this.first
    private fun Liveness.liveOut(): MutableSet<Register> = this.second

    private fun Instruction.isVarDefInstr(): Boolean = (this is Str && this.dst is Offset)

    private fun Instruction.isDiscreteInstr(): Boolean =
            !(this.usedReservedRegs() || (this is Terminator) || this.isVarDefInstr())

    private fun Instruction.usedReservedRegs(): Boolean =
            this.defs().union(this.uses()).intersect(reservedRegs() + SpecialReg(SP)).isNotEmpty()

    private fun Instruction.isParameterPassing(): Boolean =
            this.defs().size == 1 && this.defs().intersect(reservedRegs()).isNotEmpty()

    private fun Instruction.isCritical(): Boolean = when(this) {
        is Add -> this.dest == SpecialReg(SP) && this.rn == SpecialReg(SP)
        is Sub -> this.dest == SpecialReg(SP) && this.rn == SpecialReg(SP)
        is Push -> this.regList.size == 1 && this.regList[0] == SpecialReg(LR)
        else -> false
    }

    private fun Instruction.defs(): List<Register> = when(this) {
        is Str -> if (this.isVarDefInstr()) {
            listOf(this.src)
        } else { this.getDefs() }
        is Add -> if (this.dest == SpecialReg(SP)) { emptyList() } else {this.getDefs() }
        else -> this.getDefs()
    }

    private fun Instruction.uses(): List<Register> = when(this) {
        is Ldr -> if (this.isVarDefInstr()) {
            listOf(regToOffsetMap[this.opr]!!)
        } else { this.getUses() }
        is Add -> if (this.dest in reservedRegs() && this.rn == SpecialReg(SP) && this.opr is ImmNum) {
            regToOffsetMap[Offset(SpecialReg(SP), (this.opr as ImmNum).num)]?.let { listOf(it) } ?: this.getUses()
        } else if (this.dest == SpecialReg(SP)) { emptyList() } else { this.getDefs() }
        else -> this.getUses()
    }

    /**
     * Obtains the successors of a instruction
     */
    private fun getSuccessors(index: Int, livenessList: LivenessList): List<Pair<Instruction, Liveness>> {
        for (i in index + 1 until livenessList.size) {
            if (livenessList[i].first.isDiscreteInstr() || livenessList[i].first.isParameterPassing()) {
                return listOf(livenessList[i])
            }
        }
        return emptyList()
    }

    private fun clone(originalList: List<Instruction>): MutableList<Instruction> {
        val newList = mutableListOf<Instruction>()
        for (instr in originalList) {
            newList.add(instr)
        }
        return newList
    }

    private fun InstructionBlock.initialize() {
        val livenessList: LivenessList = mutableListOf()
        this.instructions.forEach {
            livenessList += it to (mutableSetOf<Register>() to mutableSetOf())
        }
        blockLivenessMap[this.label.name] = livenessList
    }

}