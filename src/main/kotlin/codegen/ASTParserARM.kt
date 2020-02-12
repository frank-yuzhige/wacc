package codegen

import ast.*
import ast.BinaryOperator.*
import ast.BinaryOperator.DIV
import ast.BinaryOperator.EQ
import ast.BinaryOperator.GT
import ast.BinaryOperator.LT
import ast.BinaryOperator.MUL
import ast.Expression.*
import ast.Statement.*
import ast.Statement.BuiltinFunc.RETURN
import ast.Type.BaseType
import ast.Type.BaseTypeKind.*
import ast.Type.Companion.anyPairType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.stringType
import codegen.arm.*
import codegen.arm.DirectiveType.LTORG
import codegen.arm.Instruction.*
import codegen.arm.Instruction.Condition.*
import codegen.arm.Instruction.Terminator.*
import codegen.arm.Operand.*
import codegen.arm.Operand.ImmNum.Companion.immFalse
import codegen.arm.Operand.ImmNum.Companion.immNull
import codegen.arm.Operand.ImmNum.Companion.immTrue
import codegen.arm.Operand.Register.Reg
import codegen.arm.Operand.Register.SpecialReg
import codegen.arm.SpecialRegName.*
import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType
import utils.LabelNameTable
import utils.SymbolTable
import utils.VarWithSID
import java.util.*

class ASTParserARM(val ast: ProgramAST, val symbolTable: SymbolTable) {
    val labelNameTable = LabelNameTable()
    val stringConsts: MutableMap<String, Label> = mutableMapOf()
    val blocks: Deque<InstructionBlock> = ArrayDeque()
    val instructions: MutableList<Instruction> = mutableListOf()
    val varOffsetMap = mutableMapOf<VarWithSID, Int>()
    val firstDefReachedScopes = mutableSetOf<Int>()
    var spOffset = 0           // current stack-pointer offset (in negative form)
    var currScopeOffset = 0    // pre-allocated scope offset for variables

    var currBlockLabel = Label("")
    var currReg: Reg = Reg(4)

    fun printARM(): String = ".data\n\n" +
            StringConst.fromMap(stringConsts).joinToString("\n") + "\n.text\n\n" +
            ".global main\n" +
            blocks.joinToString("\n")

    fun translate(): ASTParserARM = this.also { ast.toARM() }

    private fun ProgramAST.toARM() {
        Function(Type.intType(),
                "main",
                mutableListOf(),
                mainProgram + BuiltinFuncCall(RETURN, IntLit(0))
        ).toARM { Label("main") }
        functions.map { it.toARM() }
    }

    private fun ast.Function.toARM(labelBuilder: (String) -> Label = { getLabel(it) }) {
        spOffset = 0
        args.map { alloca(it.second) }
        setBlock(labelBuilder(name))
        push(SpecialReg(LR))
        body.map { it.toARM() }
        addDirective(LTORG)
    }

    private fun Statement.toARM() {
        when(this) {
            is Skip -> Skip
            is Declaration -> {
                if (variable.scopeId !in firstDefReachedScopes) {
                    val defs = symbolTable.scopeDefs[variable.scopeId]!!
                    currScopeOffset = 4 * defs.size
                    defs.withIndex().forEach { (i, v) ->
                        varOffsetMap[v to variable.scopeId] = spOffset + (i + 1) * 4
                    }
                    moveSP(-currScopeOffset)
                    firstDefReachedScopes += variable.scopeId
                }
                val reg = rhs.toARM().toReg()
                alloca(variable, reg)
            }

            is Assignment -> {
                val reg = rhs.toARM().toReg()
                when(lhs) {
                    is Identifier -> store(reg, findVar(lhs))
                    is ArrayElem -> TODO()
                    is PairElem -> TODO()
                }
            }

            is Read -> {

            }

            is BuiltinFuncCall -> {

                when(func) {
                    RETURN -> {
                        val reg = expr.toARM()
                        moveSP(spOffset)
                        mov(Reg(0), reg)
                        pop(SpecialReg(PC))
                    }
                    BuiltinFunc.FREE -> TODO()
                    BuiltinFunc.EXIT -> {
                        val reg = expr.toARM()
                        mov(Reg(0), reg)
                        bl(AL, Label("exit"))
                    }
                    BuiltinFunc.PRINT -> {
                        callPrintf(expr, false)
                    }
                    BuiltinFunc.PRINTLN -> {
                        callPrintf(expr, true)
                    }
                }
            }

            is CondBranch -> {
                val ifthen = getLabel("if_then")
                val ifelse = getLabel("if_else")
                val ifend  = getLabel("if_end")
                expr.toARM()
                val cond = currReg
                cmp(cond, immFalse())
                branch(Condition.EQ, ifelse)

                setBlock(ifthen)
                inScopeDo {
                    trueBranch.map { it.toARM() }
                }
                branch(ifend)

                setBlock(ifelse)
                inScopeDo {
                    falseBranch.map { it.toARM() }
                }
                branch(ifend)

                setBlock(ifend)
            }

            is WhileLoop -> {
                val lCheck = getLabel("loop_check")
                val lBody = getLabel("loop_body")
                val lEnd  = getLabel("loop_end")
                branch(lCheck)

                setBlock(lCheck)
                val cond = expr.toARM()
                cmp(cond.toReg(), immFalse())
                branch(lEnd)

                setBlock(lBody)
                inScopeDo {
                    body.map { it.toARM() }
                }
                branch(lBody)

                setBlock(lEnd)
            }

            is Block -> inScopeDo { body.map { it.toARM() } }
        }
    }

    private fun moveSP(offset: Int) {
        if (offset < 0) {
            binop(SUB, SpecialReg(SP), SpecialReg(SP), ImmNum(-offset))
            spOffset -= offset
        } else if (offset > 0) {
            binop(ADD, SpecialReg(SP), SpecialReg(SP), ImmNum(offset))
            spOffset -= offset
        }
    }

    /* This method allocates some space on stack for a variable,
    *  returns the offset from the initial sp */
    private fun alloca(varNode: Identifier, reg: Register? = null) {
        val offset = spOffset - varOffsetMap[varNode.getVarSID()]!!
        val dest = Offset(SpecialReg(SP), offset)
        reg?.let { store(reg, dest) }
    }

    private fun findVar(varNode: Identifier): Offset {
        return Offset(SpecialReg(SP), varOffsetMap[varNode.name to varNode.scopeId]!! - spOffset)
    }

    private fun inScopeDo(action: () -> Unit) {
        val prevScopeOffset = currScopeOffset
        action()
        moveSP(currScopeOffset)
        currScopeOffset = prevScopeOffset
    }

    private fun Expression.toARM(): Operand {
        return when(this) {
            NullLit   -> immNull()
            is IntLit -> {
                if (x in 0..255) {
                    ImmNum(x)
                } else {
                    val reg = getReg()
                    load(reg, ImmNum(x))
                }
            }
            is BoolLit -> if (b) immTrue() else immFalse()
            is CharLit -> ImmNum(c.toInt())
            is StringLit -> defString(string)
            is Identifier -> load(getReg(), findVar(this))
            is BinExpr -> {
                val op1 = left.toARM().toReg()
                val op2 = right.toARM()
                binop(op, op1, op1, op2)
            }
            is UnaryExpr -> TODO()
            is ArrayElem -> TODO()
            is PairElem -> TODO()
            is ArrayLiteral -> TODO()
            is NewPair -> TODO()
            is FunctionCall -> {
                for (arg in args) {
                    val reg = arg.toARM().toReg()
                    store(reg, Offset(SpecialReg(SP), 4, true))
                }
                bl(AL, Label(ident))
                binop(ADD, SpecialReg(SP), SpecialReg(SP), ImmNum(args.size))
                Reg(0)
            }
        }
    }

    private fun defString(content: String): Label {
        val prevDef = stringConsts[content]
        if (prevDef != null) {
            return prevDef
        }
        val msgLabel = getLabel("msg")
        stringConsts[content] = msgLabel
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

    private fun getReg(): Register = currReg.also { currReg = currReg.next() }

    private fun setBlock(label: Label) {
        currBlockLabel = label
    }

    private fun packBlock(terminator: Terminator) {
        val block = InstructionBlock(currBlockLabel, instructions.toMutableList(), terminator)
        blocks.addLast(block)
        instructions.clear()
        currBlockLabel = getLabel("${currBlockLabel.name}-seq")
    }

    private fun getLabel(name: String): Label = Label(labelNameTable.getName(name))

    private fun branch(label: Label) {
        packBlock(B(AL, label))
    }

    private fun branch(cond: Condition, label: Label) {
        packBlock(B(cond, label))
    }

    private fun bl(cond: Condition = AL, label: Label) {
        instructions += BL(cond, label)
    }

    private fun load(cond: Condition, dst: Register, src: Operand): Register {
        instructions += Ldr(cond, dst, src)
        return dst
    }

    private fun load(dst: Register, src: Operand): Register = load(AL, dst, src)

    private fun store(src: Register, dst: Operand): Operand {
        instructions += Str(AL, src, dst)
        return dst
    }

    private fun mov(src: Operand): Register{
        val reg = currReg
        currReg = currReg.next()
        return mov(reg, src)
    }

    private fun mov(dst: Register, src: Operand): Register {
        if (dst != src) {
            instructions += Mov(AL, dst, src)
        }
        return dst
    }

    private fun push(vararg regs: Register) {
        instructions += Push(regs.toMutableList())
    }

    private fun pop(vararg regs: Register) {
        if (regs.contentEquals(arrayOf(SpecialReg(PC)))) {
            packBlock(PopPC)
        } else {
            instructions += Pop(regs.toMutableList())
        }
    }

    private fun addDirective(type: DirectiveType) {
        blocks.last.tails += Directive(type)
    }

    private fun binop(opType: BinaryOperator, dst: Register, rn: Register, op2: Operand): Register {
        val instr = when (opType) {
            ADD -> Add(AL, dst, rn, op2)
            SUB -> Sub(AL, dst, rn, op2)
            MUL -> Mul(AL, dst, rn, op2.toReg())
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

    private fun Operand.toReg(): Register = when(this) {
        is Register -> this
        is ImmNum -> if (num in 0..255) mov(this) else load(getReg(), this)
        is Label -> {
            val reg = getReg()
            load(reg, this)
            binop(ADD, reg, reg, ImmNum(4));
        }
        else -> mov(this)
    }

    private fun callPrintf(expr: Expression, newline: Boolean) {
        val operand = expr.toARM()
        val exprType = expr.getType(symbolTable) // TODO Symbol Table needs to be persistent
        when(exprType) {
            boolType() -> {
                cmp(operand.toReg(), immFalse())
                load(NE, Reg(1), defString("true"))
                load(Condition.EQ, Reg(1), defString("false"))
                binop(ADD, Reg(1), Reg(1), ImmNum(4))
                load(Reg(0), defString(getFormatString(exprType, newline)))
                binop(ADD, Reg(0), Reg(0), ImmNum(4))
            }
            else -> {
                mov(Reg(1), operand.toReg())
                load(Reg(0), defString(getFormatString(exprType, newline)))
                binop(ADD, Reg(0), Reg(0), ImmNum(4))
            }
        }
        bl(AL, Label("printf"))
        mov(Reg(0), ImmNum(0))
        bl(AL, Label("fflush"))
    }

    fun getFormatString(type: Type, newline: Boolean): String {
        val format = when(type) {
            is BaseType -> when(type.kind) {
                INT -> "%d"
                CHAR -> "%c"
                BOOL -> "%s"
                STRING -> "%s"
                else -> "%p"
            }
            is Type.ArrayType -> if (type.type == charType()) "%s" else "%p"
            is Type.PairType -> "%p"
            is Type.FuncType -> "%p"
        }
        return format + if (newline) "\\n\u0000" else "\u0000"
    }

    private fun Expression.getType(symbolTable: SymbolTable): Type {
        val map = symbolTable.collect
        return when (this) {
            NullLit -> anyPairType()
            is IntLit -> intType()
            is BoolLit -> boolType()
            is CharLit -> charType()
            is StringLit -> stringType()
            is Identifier -> map[getVarSID()]!!.type
            is BinExpr -> TODO()
            is UnaryExpr -> TODO()
            is ArrayElem -> TODO()
            is PairElem -> TODO()
            is ArrayLiteral -> TODO()
            is NewPair -> TODO()
            is FunctionCall -> TODO()
        }
    }
}





