package optimizers
import codegen.InstructionBlock
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand.*
import codegen.arm.Operand.Register.*
import codegen.arm.Operand.Register.Reg.Companion.reservedRegs
import codegen.arm.SpecialRegName.*
import utils.TablePrinter

typealias Liveness = Pair<MutableSet<Register>, MutableSet<Register>>
typealias LivenessList = MutableList<Pair<Instruction, Liveness>>

class ArmOptimizer(option: OptimizationOption) {
    private val blockLivenessMap: MutableMap<String, LivenessList> = mutableMapOf()
    private val regToOffsetMap: MutableMap<Offset, Register> = mutableMapOf()
    fun doOptimize(armProgram: ArmProgram): ArmProgram {
        val separatedBlocks = separateBlocks(armProgram)
        val nonPreludeBlocks = separatedBlocks.first
        val preludeBlocks = separatedBlocks.second
        nonPreludeBlocks.forEach {
            it.initialize()
            it.performLivenessAnalysis()
        }
        dumpLivenessMap()
        return ArmProgram(armProgram.stringConsts, nonPreludeBlocks.map { it.sweepDeadCode() } + preludeBlocks)
    }

    /**
     * Separate the instruction blocks in the arm program into two sets: the ones that are prelude functions, and
     * the ones that are not
     */
    private fun separateBlocks(arm: ArmProgram): Pair<List<InstructionBlock>, List<InstructionBlock>> {
        var separationIndex = 0
        for ((index, instrBlock) in arm.blocks.withIndex()) {
            if (instrBlock.label.name.startsWith("p_")) {
                separationIndex = index
                break;
            }
        }
        return arm.blocks.subList(0, separationIndex) to arm.blocks.subList(separationIndex, arm.blocks.lastIndex)
    }

    /**
     * Performs liveness analysis on the given code block
     */
    private fun InstructionBlock.performLivenessAnalysis() {
        var currLiveness: LivenessList = blockLivenessMap[this.label.name]!!
        var preLiveness: LivenessList
        do {
            preLiveness = clone(currLiveness)
            analyze(currLiveness)
        } while (currLiveness != preLiveness)
    }

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

    private fun clone(livenessList: LivenessList): LivenessList {
        val newList: LivenessList = mutableListOf()
        livenessList.forEach {
            newList += it.first to (it.second.first.toMutableSet() to it.second.second.toMutableSet())
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