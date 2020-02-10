package codegen.arm

import ast.*
import ast.Statement.*
import codegen.InstructionBlock
import codegen.arm.Instruction.CMP
import codegen.arm.Instruction.Condition.AL
import codegen.arm.Instruction.Terminator
import codegen.arm.Instruction.Terminator.*
import codegen.arm.Operand.*
import codegen.arm.Operand.ImmNum.Companion.immFalse
import codegen.arm.Operand.ImmNum.Companion.immNull
import codegen.arm.Operand.ImmNum.Companion.immTrue
import utils.LabelNameTable
import java.util.*

class ASTParserARM() {
    val labelNameTable = LabelNameTable()
    val stringConsts: List<StringConst> = mutableListOf()
    val blocks: Deque<InstructionBlock> = ArrayDeque()
    val instructions: MutableList<Instruction> = mutableListOf()
    val identRegMap = mutableMapOf<Pair<String, Int>, Int>()

    var currBlockLabel = Label("")
    var currReg: Register = Register("")

    private fun setBlock(label: Label) {
        currBlockLabel = label
        instructions.clear()
    }

    private fun packBlock(terminator: Terminator) {
        val block = InstructionBlock(currBlockLabel, instructions, terminator)
        blocks.addLast(block)
    }

    private fun label(name: String): Label = Label(labelNameTable.getName(name))

    private fun br(label: Label) {
        val br = B(AL, label)
        packBlock(br)
    }

    fun translateASTToARM(ast: ProgramAST): ArmProgram {
        return ArmProgram(stringConsts, ast.toARM())
    }

    fun ProgramAST.toARM(): List<InstructionBlock> {
        val acc = ast.Function(Type.intType(),"main", mutableListOf(), mainProgram).toARM().toMutableList()
        functions.forEach{ f ->
            acc += f.toARM()
        }
        return acc
    }

    fun ast.Function.toARM(): List<InstructionBlock> {
        setBlock(label(name))
//        push(LR)
        body.map { it.toARM() }
        TODO()
    }

    fun Statement.toARM() {
        when(this) {
            is Skip -> Skip
            is Declaration -> {

            }

            is Assignment -> {

            }

            is CondBranch -> {
                val ifthen = label("if-then")
                val ifelse = label("if-else")
                val ifend  = label("if-end")
                expr.toARM()
                val cond = Register(currReg.toString())
                cmp(cond, immFalse())
                br(ifelse)

                setBlock(ifthen)
                trueBranch.map { it.toARM() }
                br(ifend)

                setBlock(ifelse)
                falseBranch.map { it.toARM() }
                br(ifend)

                setBlock(ifend)
            }
            is WhileLoop -> {
                val lchk = label("loop-check")
                val lbdy = label("loop-body")
                val lend  = label("loop-end")
                br(lchk)

                setBlock(lchk)
                val cond = expr.toARM()
                cmp(cond, immFalse())
                br(lend)

                setBlock(lbdy)
                body.map { it.toARM() }
                br(lbdy)

                setBlock(lend)
            }
        }
    }

    private fun cmp(op1: Register, op2: Operand) {
        instructions.add(CMP(op1, op2))
    }

    private fun Expression.toARM(): Register {
        return when(this) {
            Expression.NullLit   -> mov(currReg, immNull())
            is Expression.IntLit -> mov(currReg, ImmNum(x))
            is Expression.BoolLit -> mov(currReg, if (b) immTrue() else immFalse())
            is Expression.CharLit -> mov(currReg, ImmNum(c.toInt()))
            is Expression.StringLit -> TODO()
            is Expression.Identifier -> mov(currReg, Register(identRegMap[name to scopeId].toString()))
            is Expression.BinExpr -> {
                TODO()
            }
            is Expression.UnaryExpr -> TODO()
            is Expression.ArrayElem -> TODO()
            is Expression.PairElem -> TODO()
            is Expression.ArrayLiteral -> TODO()
            is Expression.NewPair -> TODO()
            is Expression.FunctionCall -> TODO()
        }
    }

    private fun mov(dst: Register, src: Operand): Register {
        instructions.add(Instruction.MOV(AL, dst, src))
        return dst
    }


}

