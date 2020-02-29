package optimizers
import codegen.InstructionBlock
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand.*
import codegen.arm.Operand.Register.*
import codegen.arm.Operand.Register.Reg.Companion.reservedRegs
import codegen.arm.SpecialRegName
import codegen.arm.SpecialRegName.*
import utils.TablePrinter

typealias Liveness = Pair<MutableSet<Register>, MutableSet<Register>>
typealias LivenessList = MutableList<Pair<Instruction, Liveness>>

class ArmOptimizer(options: OptimizationOption) {
    private val blockLivenessMap: MutableMap<String, LivenessList> = mutableMapOf()
    private val regToOffsetMap: MutableMap<Offset, Register> = mutableMapOf()
    fun doOptimize(armProgram: ArmProgram): ArmProgram {
        armProgram.blocks.forEach {
            it.initialize()
            it.performLivenessAnalysis()
        }
        dumpLivenessMap()
        return ArmProgram(armProgram.stringConsts, armProgram.blocks.map { it.sweepDeadCode() })
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
            if (instr.shouldBeAnalyzed()) {
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
     * Remove dead code if the instruction node satisfies one of the following conditions:
     * 1. There is only one virtual register in the defs set of the instruction node and
     *    the virtual register defined is not in the liveOut set.
     * 2.
     */
    private fun InstructionBlock.sweepDeadCode(): InstructionBlock {
        val currLivenessList = blockLivenessMap[this.label.name]!!
        val filteredInstrs = this.instructions.filterIndexed { i, instr ->
            val defs = instr.defs()
            val liveOut = currLivenessList[i].second.liveOut()
            (!(defs.size == 1 && (!liveOut.contains(defs[0])))) || instr.isCritical()
        }
        return InstructionBlock(this.label, filteredInstrs, this.terminator, this.tails)
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

    private fun Instruction.shouldBeAnalyzed(): Boolean = !this.isVarDefInstr() && isDiscreteInstr()

    private fun Instruction.isVarDefInstr(): Boolean = (this is Str && this.dst is Offset)

    private fun Instruction.isDiscreteInstr(): Boolean = !(this.isCritical() && (this is Terminator))

    private fun Instruction.isCritical(): Boolean =
            this.defs().intersect(reservedRegs() + SpecialReg(SP)).isNotEmpty()

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
            listOf(regToOffsetMap[Offset(SpecialReg(SP), (this.opr as ImmNum).num)]!!)
        } else if (this.dest == SpecialReg(SP)) { emptyList() } else { this.getDefs() }
        else -> this.getUses()
    }

    /**
     * Obtains the successors of a instruction
     */
    private fun getSuccessors(index: Int, livenessList: LivenessList): List<Pair<Instruction, Liveness>> {
        for (i in index + 1 until livenessList.size) {
            if (livenessList[i].first.isDiscreteInstr()) {
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