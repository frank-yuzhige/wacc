package optimizers
import codegen.InstructionBlock
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Operand.*
import codegen.arm.Operand.Register.*
import utils.TablePrinter

typealias Liveness = Pair<MutableSet<Register>, MutableSet<Register>>
typealias LivenessList = MutableList<Pair<Instruction, Liveness>>

class ArmOptimizer(options: OptimizationOption) {

    private val blockLivenessMap: MutableMap<String, LivenessList> = mutableMapOf()

    fun doOptimize(armProgram: ArmProgram) {
        armProgram.blocks.forEach {
            it.initialize()
            it.performLivenessAnalysis()
        }
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
            if (instr !is Str) {
                // LiveIn(n) = uses(n) U (LiveOut(n) - defs(n))
                liveness.liveIn().clear()
                liveness.liveIn().addAll(
                        instr.getUses().toMutableSet() + (liveness.liveOut() - instr.getDefs().toMutableSet()))

                // LiveOut(n) = U (s belongs to succ(n)) LiveIn(s)
                liveness.liveOut().clear()
                val liveOut = getSuccessors(i, livenessList).flatMap { it.second.liveIn().also { it } }
                liveness.liveOut().addAll(liveOut)
            }
        }
    }

    fun dumpLivenessMap() {
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

    private fun getSuccessors(index: Int, livenessList: LivenessList): List<Pair<Instruction, Liveness>> =
            if (index < livenessList.size - 1) {
                listOf(livenessList[index + 1])
            } else {
                emptyList() // TODO
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