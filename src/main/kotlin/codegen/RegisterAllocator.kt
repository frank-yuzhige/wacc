package codegen

import codegen.arm.StringConst

class RegisterAllocator(val program: List<InstructionBlock>, val stringConsts: List<StringConst>) {

    fun run(): Pair<List<InstructionBlock>, List<StringConst>> {
        TODO()
    }

    private fun InstructionBlock.rename(): InstructionBlock {

    }
}