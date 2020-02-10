package codegen

import ast.*
import ast.BinaryOperator.*
import ast.BinaryOperator.DIV
import ast.BinaryOperator.MUL
import ast.Expression.*
import ast.Statement.*
import codegen.arm.ArmProgram
import codegen.arm.Instruction
import codegen.arm.Instruction.*
import codegen.arm.Instruction.Condition.AL
import codegen.arm.Instruction.Terminator.*
import codegen.arm.Operand
import codegen.arm.Operand.*
import codegen.arm.Operand.ImmNum.Companion.immFalse
import codegen.arm.Operand.ImmNum.Companion.immNull
import codegen.arm.Operand.ImmNum.Companion.immTrue
import codegen.arm.Operand.Register.Reg
import codegen.arm.StringConst
import utils.LabelNameTable
import java.util.*

class ASTParserARM() {
    val labelNameTable = LabelNameTable()
    val stringConsts: MutableList<StringConst> = mutableListOf()
    val blocks: Deque<InstructionBlock> = ArrayDeque()
    val instructions: MutableList<Instruction> = mutableListOf()
    val identRegMap = mutableMapOf<Pair<String, Int>, Register>()

    var currBlockLabel = Label("")
    var currReg: Reg = Reg(0)

    private fun getReg(): Register = currReg.also { currReg = currReg.next() }

    private fun setBlock(label: Label) {
        currBlockLabel = label
        instructions.clear()
    }

    private fun packBlock(terminator: Terminator) {
        val block = InstructionBlock(currBlockLabel, instructions, terminator)
        blocks.addLast(block)
    }

    private fun getLabel(name: String): Label = Label(labelNameTable.getName(name))

    private fun branch(label: Label) {
        packBlock(B(AL, label))
    }

    private fun bl(cond: Condition = AL, label: Label) {
        packBlock(BL(cond, label))
    }

    private fun load(dst: Register, src: Operand) {
        instructions += Ldr(AL, dst, src)
    }

    private fun store(dst: Register, src: Operand) {
        instructions += Str(AL, dst, src)
    }

    private fun mov(src: Operand): Register {
        val dst = getReg()
        instructions += Mov(AL, dst, src)
        return dst
    }

    private fun binop(opType: BinaryOperator, rn: Register, op2: Operand): Register {
        val dst = getReg()
        val instr = when (opType) {
            ADD -> Add(AL, dst, rn, op2)
            SUB -> Sub(AL, dst, rn, op2)
            MUL -> TODO()
            DIV -> TODO()
            MOD -> TODO()
            GTE -> TODO()
            LTE -> TODO()
            GT -> TODO()
            LT -> TODO()
            EQ -> TODO()
            NEQ -> TODO()
            AND -> TODO()
            OR -> TODO()
        }
        instructions += instr
        return dst
    }

    private fun cmp(op1: Register, op2: Operand) {
        instructions += Cmp(op1, op2)
    }

    private fun throwOverflowError() {
        TODO()
    }

    fun translateASTToARM(ast: ProgramAST): ArmProgram {
        TODO()
    }

    fun ProgramAST.toARM() {
        Function(Type.intType(),"main", mutableListOf(), mainProgram).toARM()
        functions.map { f -> f.toARM() }

    }

    fun ast.Function.toARM() {
        setBlock(getLabel(name))
//        push(LR)
        body.map { it.toARM() }
        TODO()
    }

    private fun Statement.toARM() {
        when(this) {
            is Skip -> Skip
            is Declaration -> {
                identRegMap[variable.name to variable.scopeId] = rhs.toARM().toReg()
            }

            is Assignment -> {
                val reg = rhs.toARM().toReg()
                when(lhs) {
                    is Identifier -> identRegMap[lhs.name to lhs.scopeId] = reg
                    is ArrayElem -> TODO()
                    is PairElem -> TODO()
                }
            }

            is Read -> {

            }

            is BuiltinFuncCall -> {

            }


            is CondBranch -> {
                val ifthen = getLabel("if-then")
                val ifelse = getLabel("if-else")
                val ifend  = getLabel("if-end")
                expr.toARM()
                val cond = currReg
                cmp(cond, immFalse())
                branch(ifelse)

                setBlock(ifthen)
                trueBranch.map { it.toARM() }
                branch(ifend)

                setBlock(ifelse)
                falseBranch.map { it.toARM() }
                branch(ifend)

                setBlock(ifend)
            }
            is WhileLoop -> {
                val lchk = getLabel("loop-check")
                val lbdy = getLabel("loop-body")
                val lend  = getLabel("loop-end")
                branch(lchk)

                setBlock(lchk)
                val cond = expr.toARM()
                cmp(cond.toReg(), immFalse())
                branch(lend)

                setBlock(lbdy)
                body.map { it.toARM() }
                branch(lbdy)

                setBlock(lend)
            }
        }
    }

    private fun Expression.toARM(): Operand {
        return when(this) {
            NullLit   -> immNull()
            is IntLit -> ImmNum(x)
            is BoolLit -> if (b) immTrue() else immFalse()
            is CharLit -> ImmNum(c.toInt())
            is StringLit -> defString(string)
            is Identifier -> identRegMap.getValue(name to scopeId)
            is BinExpr -> {
                val op1 = left.toARM()
                val op2 = right.toARM()
                binop(op, op1.toReg(), op2)
            }
            is UnaryExpr -> TODO()
            is ArrayElem -> TODO()
            is PairElem -> TODO()
            is ArrayLiteral -> TODO()
            is NewPair -> TODO()
            is FunctionCall -> TODO()
        }
    }

    private fun defString(content: String): Label {
        val msgLabel = getLabel("msg")
        stringConsts += StringConst(msgLabel, content)
        return msgLabel
    }

    private fun Expression.weight(): Int {
        return when(this) {
            NullLit -> 1
            is IntLit -> 1
            is BoolLit -> 1
            is CharLit -> 1
            is StringLit -> 1
            is Identifier -> 1
            is BinExpr -> TODO()
            is UnaryExpr -> TODO()
            is ArrayElem -> TODO()
            is PairElem -> TODO()
            is ArrayLiteral -> TODO()
            is NewPair -> TODO()
            is FunctionCall -> TODO()
        }
    }

    private fun Operand.toReg(): Register = when(this) {
        is Register -> this
        else -> mov(this)
    }
}



