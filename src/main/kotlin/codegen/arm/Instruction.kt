package codegen.arm

sealed class Instruction {

    data class Mov(val src: Register, val dest: Register): Instruction()
    data class Push(val reg: Register): Instruction()
    data class Pop(val reg: Register): Instruction()
    data class Br(val type: BranchType, val label: String)

    enum class BranchType {
        B, BEQ, BNE, BL, BLE, BG, BGE
    }
}