package codegen

import ast.*
import ast.BinaryOperator.*
import ast.BinaryOperator.EQ
import ast.BinaryOperator.GT
import ast.BinaryOperator.LT
import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Function
import ast.Statement.*
import ast.Statement.BuiltinFunc.*
import ast.Type.*
import ast.Type.BaseTypeKind.*
import ast.Type.Companion.arrayTypeOf
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.stringType
import ast.UnaryOperator.*
import codegen.PreludeFunc.*
import codegen.arm.*
import codegen.arm.DirectiveType.LTORG
import codegen.arm.Instruction.*
import codegen.arm.Instruction.Condition.*
import codegen.arm.Instruction.ShiftModifier.ASR
import codegen.arm.Instruction.Terminator.*
import codegen.arm.Operand.*
import codegen.arm.Operand.ImmNum.Companion.immFalse
import codegen.arm.Operand.ImmNum.Companion.immNull
import codegen.arm.Operand.ImmNum.Companion.immTrue
import codegen.arm.Operand.Register.Reg
import codegen.arm.Operand.Register.SpecialReg
import codegen.arm.Operand.Register.SpecialReg.Companion.sp
import codegen.arm.SpecialRegName.*
import exceptions.SemanticException
import utils.*
import utils.EscapeCharMap.Companion.fromEscape
import java.util.*

/* AstToRawArmConverter takes the program AST and the generated symbol table, returns a "raw" ARM program.
*  The converter will generate a 'sort-of-functional' ARM program (meets ARM's syntax), except that it does
*  not free any registers and do any PUSH/POP to normal registers(R4..).
*  Thus, the generated program could work if it does not contain any normal register with its id > 11.
*  All of the normal registers in the generated raw ARM program are "virtual" registers. Which will be unified
*  with "real" registers by RegisterAllocator */
class AstToRawArmConverter(val ast: ProgramAST, private val symbolTable: SymbolTable) {
    private val labelNameTable = LabelNameTable()
    private val singletonStringConsts: MutableMap<String, Label> = mutableMapOf()
    private val commonStringConsts: MutableList<Pair<String, Label>> = mutableListOf()
    private val blocks: Deque<InstructionBlock> = ArrayDeque()
    private val instructions: MutableList<Instruction> = mutableListOf()
    private val varOffsetMap = mutableMapOf<VarWithSID, Int>()
    private val funcLabelMap = mutableMapOf<String, Label>()
    private val firstDefReachedScopes = mutableSetOf<Int>()
    private var spOffset = 0           // current stack-pointer offset (in negative form)
    private var currScopeOffset = 0    // pre-allocated scope offset for variables
    private val requiredPreludeFuncs = mutableSetOf<PreludeFunc>() // prelude definitions that needs to be run after codegen
    private val maxImmNum = 1024
    private var blockComplete = false
    private var virtualRegIdAcc = 4
    private val groundFunctionList = mutableListOf<GroundFunction>()
    private val groundConstructorList = mutableListOf<GroundConstructor>()
    private var currentGrounding: Grounding = emptyMap()
    private val constructorIsUnionMap = mutableMapOf<String, Boolean>()

    var currBlockLabel = Label("")

    fun export(): ArmProgram = ArmProgram(
            StringConst.fromCodegenCollections(singletonStringConsts, commonStringConsts),
            blocks.toList()
    )

    fun translate(): AstToRawArmConverter = this.also { ast.toARM() }

    /** Converts WaccAst to ARM intermediate representation **/
    private fun ProgramAST.toARM() {
        newTypes.map { it.declareConstructors() }
        funcLabelMap += "main" to Label("main")
        functions.map { funcLabelMap += it.name to getLabel("f_${it.name}") }
        Function(returnType = intType(),
                name = "main",
                args = mutableListOf(),
                body = mainProgram + BuiltinFuncCall(RETURN, IntLit(0)),
                typeConstraints = emptyList()
        ).toARM()
        /* generate all ground functions */
        functions.filter { it.getFuncType().isGround() }.map { it.toARM() }
        while (groundFunctionList.isNotEmpty()) {
            val curr = groundFunctionList.removeAt(0)
            currentGrounding = curr.groundType.findUnifier(curr.function.getFuncType().reified(curr.function.typeConstraints, true))
            curr.function.toARM(curr.groundType)
        }
        while (groundConstructorList.isNotEmpty()) {
            val curr = groundConstructorList.removeAt(0)
            defineConstructor(curr.name, curr.constructorType, curr.isUnion)
        }
        definePreludes()
    }

    private fun NewTypeDef.declareConstructors() {
        when(this) {
            is NewTypeDef.StructTypeDef -> {
                constructorIsUnionMap[name()] = false
            }
            is NewTypeDef.UnionTypeDef -> {
                memberMap.forEach { (constructor, _) ->
                    constructorIsUnionMap[constructor] = true
                }
            }
        }
    }

    private fun defineConstructor(name: String, constructorType: FuncType, isTaggedUnion: Boolean) {
        funcLabelMap += name to getConstructorLabel(name, constructorType)

        setBlock(funcLabelMap.getValue(name))
        push(SpecialReg(LR))
        callMalloc(mallocSize(constructorType, isTaggedUnion))

        var structOffsetAcc = 0
        if (isTaggedUnion) {
            load(Reg(1), ImmNum(symbolTable.unionIdMap.getValue(name)))
            store(Reg(1), Offset(Reg(0)))
            structOffsetAcc += 4
        }
        var paramOffsetAcc = 4
        constructorType.paramTypes.forEach { t ->
            val size = sizeof(t)
            load(Reg(1), Offset(sp(), paramOffsetAcc), size)
            store(Reg(1), Offset(Reg(0), structOffsetAcc), size)
            structOffsetAcc += size
            paramOffsetAcc += size
        }
        packBlock(PopPC)
        addDirective(LTORG)
    }

    private fun Function.toARM(type: FuncType? = null) {
        spOffset = 0
        currScopeOffset = 0
        firstDefReachedScopes.clear() // functions don't share scopes, safe to clear.
        if(type == null) {
            setBlock(funcLabelMap.getValue(this.name))
        } else {
            setBlock(funcLabelMap.getValue("f_" + name + "_" + type.printAsLabel()))
        }
        push(SpecialReg(LR))
        args.firstOrNull()?.let { scopeEnterDef(it.second, args.toSet()) }
        var offsetAcc = -4
        args.map { arg ->
            markParam(arg.second, offsetAcc)
            offsetAcc -= sizeof(arg.first.reified(emptyList()))
        }
        body.map { it.toARM() }
        if (!blockComplete) {
            packBlock(Unreachable)
        }
        addDirective(LTORG)
    }

    private fun Statement.toARM() {
        when (this) {
            is Skip -> Skip
            is Declaration -> {
                scopeEnterDef(variable)
                val reg = rhs.toARM().toReg()
                alloca(variable, reg, sizeof(rhs.getType()))
            }

            is Assignment -> {
                lhs.ground(currentGrounding)
                val reg = rhs.toARM().toReg()
                val offset = getLhsAddress(lhs)
                val size = sizeof(lhs.getType())
                store(reg, offset, size)
            }

            is Read -> callScanf(target)

            is BuiltinFuncCall -> {
                when (func) {
                    RETURN -> {
                        val op = expr.toARM()
                        moveSP(spOffset, false)
                        op.toReg(Reg(0))
                        pop(SpecialReg(PC))
                    }
                    FREE -> {
                        val reg = expr.toARM().toReg()
                        mov(Reg(0), reg)
                        when (expr.getType()) {
                            is NewType -> callPrelude(FREE_STRUCT)
                            else -> throw IllegalArgumentException("Cannot free a non-heap-allocated object!")
                        }
                    }
                    EXIT -> {
                        val reg = expr.toARM()
                        mov(Reg(0), reg)
                        bl(AL, Label("exit"))
                    }
                    PRINT -> callPrintf(expr, false)
                    PRINTLN -> callPrintf(expr, true)
                }
            }

            is CondBranch -> {
                val ifend = getLabel("if_end")
                var nextCase = getLabel("if_case")
                packBlock()
                condStatsList.forEach { (expr, stats) ->
                    setBlock(nextCase)
                    nextCase = getLabel("if_case")
                    val cond = expr.toARM().toReg()
                    cmp(cond, immFalse())
                    branch(Condition.EQ, nextCase)

                    inScopeDo { stats.map { it.toARM() } }
                    branch(ifend)
                }
                setBlock(nextCase)
                inScopeDo { elseBody.map { it.toARM() } }
                branch(ifend)

                setBlock(ifend)
            }

            is WhileLoop -> {
                val lCheck = getLabel("loop_check")
                val lBody = getLabel("loop_body")
                val lEnd = getLabel("loop_end")
                branch(lCheck)

                setBlock(lBody)
                inScopeDo {
                    body.map { it.toARM() }
                }
                branch(lCheck)

                setBlock(lCheck)
                val cond = expr.toARM().toReg()
                cmp(cond, immTrue())
                branch(Condition.EQ, lBody)

                setBlock(lEnd)
            }

            is ForLoop -> inScopeDo {
                loopVar.ground(currentGrounding)
                scopeEnterDef(loopVar)
                val eval = from.toARM().toReg()
                var varOffset = findVar(loopVar)
                store(eval, varOffset, sizeof(loopVar.getType()))
                val fCheck = getLabel("for_check")
                val fBody = getLabel("for_body")
                val fEnd = getLabel("for_end")
                branch(fCheck)
                setBlock(fBody)
                body.map { it.toARM() }
                varOffset = findVar(loopVar)
                val loopVarValue = load(getReg(), varOffset, sizeof(loopVar.getType()))
                binop(ADD, loopVarValue, loopVarValue, ImmNum(1))
                store(loopVarValue, varOffset, sizeof(loopVar.getType()))
                packBlock(FallThrough)

                setBlock(fCheck)
                val toEval = to.toARM()
                val lVar = load(getReg(), findVar(loopVar), sizeof(loopVar.getType()))
                cmp(lVar, toEval)
                branch(Condition.LE, fBody)
                setBlock(fEnd)

            }

            is VoidFuncCall -> function.toARM()

            is Block -> inScopeDo { body.map { it.toARM() } }

            is WhenClause -> {
                val wEnd = getLabel("when_end")
                val wLabels = whenCases.map { (pattern, _) -> getLabel("when_${pattern.constructor}") } + wEnd
                val matching = expr.toARM().toReg()
                matching.toReg(Reg(0))
                callPrelude(CHECK_NULL_PTR)
                packBlock()
                for (i in whenCases.indices) {
                    whenCases[i].let { (pattern, stats) ->
                        setBlock(wLabels[i])
                        val constructorID = symbolTable.unionIdMap.getValue(pattern.constructor)
                        val realConstructorID = Offset(matching).toReg()
                        cmp(realConstructorID, ImmNum(constructorID))
                        branch(NE, wLabels[i + 1])
                        inScopeDo {
                            pattern.defineConsts(matching)
                            stats.map { it.toARM() }
                        }
                        branch(wEnd)
                    }
                }
                setBlock(wEnd)
            }
        }
    }

    private fun Expression.toARM(): Operand {
        this.ground(currentGrounding)
        return when (this) {
            NullLit -> immNull()
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
            is StringLit -> defString(fromEscape(string).toString(), false)
            is Identifier -> load(getReg(), findVar(this), sizeof(this.getType()))
            is BinExpr -> {
                val op1 = left.toARM().toReg()
                val op2 = right.toARM()
                binop(op, op1, op1, op2, op2Destructive = true, setFlag = true)
            }
            is UnaryExpr -> when (op) {
                ORD -> expr.toARM()
                CHR -> expr.toARM()
                LEN -> load(getReg(), Offset(expr.toARM().toReg(), 0, false))
                NEG -> {
                    val reg = expr.toARM().toReg()
                    rsbs(reg, reg, ImmNum(0))
                    callPrelude(OVERFLOW_ERROR, VS)
                    reg
                }
                NOT -> not(expr.toARM().toReg())
            }
            is ArrayElem -> {
                var result = load(getReg(), findVar(arrIdent))
                for (expr in indices) {
                    val currType = arrIdent.ground(currentGrounding).getType().unwrapArrayType()!!
                    val indexReg = expr.toARM().toReg()
                    callCheckArrBound(indexReg, result)
                    val offset = binop(MUL, indexReg, indexReg, ImmNum(sizeof(currType)), op2Destructive = true)
                    result = binop(ADD, result, result, offset)
                    load(result, Offset(result, 4), sizeof(currType))
                }
                result
            }
            is PairElem -> {
                val temp = expr.toARM().toReg()
                mov(Reg(0), temp)
                callPrelude(CHECK_NULL_PTR)
                val fstElemType = (expr.getType() as NewType).generics[0]
                val offset = Offset(temp, when (func) { FST -> 0; SND -> sizeof(fstElemType) })
                load(temp, offset, sizeof(getType()))
            }
            is TypeMember -> {
                val reg = expr.toARM().toReg()
                mov(Reg(0), reg)
                callPrelude(CHECK_NULL_PTR)
                val shift = getMemberOffset(memberName, expr.getType())
                val offset = Offset(reg, shift)
                load(reg, offset, sizeof(getType()))
            }
            is IfExpr -> {
                val resultReg = getReg()
                val ifend = getLabel("if_expr_end")
                var nextCase = getLabel("if_expr")
                packBlock()
                condStatsList.forEach { (cond, expr) ->
                    setBlock(nextCase)
                    nextCase = getLabel("if_expr")
                    cmp(cond.toARM().toReg(), immFalse())
                    branch(Condition.EQ, nextCase)
                    expr.toARM().toReg(resultReg)
                    branch(ifend)
                }
                setBlock(nextCase)
                elseExpr.toARM().toReg(resultReg)
                branch(ifend)
                setBlock(ifend)
                resultReg
            }
            is ArrayLiteral -> {
                // Malloc the memory for each element in the array
                val elemSize = elements.getOrNull(0)?.let { sizeof(it.ground(currentGrounding).getType()) } ?: 0
                val totalSize = elements.size * elemSize + 4

                val baseAddressReg = mov(getReg(), callMalloc(totalSize))

                // Store each element in the array
                elements.forEachIndexed { index, it ->
                    val tempElemReg = it.toARM().toReg()
                    store(tempElemReg, Offset(baseAddressReg, 4 + index * elemSize, false), elemSize)
                }
                // Store the size of the array at the end
                val tmp = getReg()
                load(AL, tmp, ImmNum(elements.size))
                store(tmp, Offset(baseAddressReg, 0, false))
                baseAddressReg
            }
            is NewPair -> {
                first.ground(currentGrounding)
                second.ground(currentGrounding)
                val fstSize = sizeof(first.getType())
                val sndSize = sizeof(second.getType())
                callMalloc(fstSize + sndSize)
                val pairAddr = mov(getReg(), Reg(0))
                val fst = first.toARM().toReg()
                store(fst, Offset(pairAddr), fstSize)
                val snd = second.toARM().toReg()
                store(snd, Offset(pairAddr, fstSize), sndSize)
                pairAddr
            }
            is FunctionCall -> {
                val oldSPOffset = spOffset
                notifyCompiler(CompilerNotifier.CallerSavePush)
                // push args to the stack in reversed order.
                for (arg in args.reversed()) {
                    val reg = arg.toARM().toReg()
                    val size = sizeof(arg.getType())
                    store(reg, Offset(SpecialReg(SP), -size, true), size)
                    spOffset += size
                }
                val funcAttr = symbolTable.lookupFunc(ident)!!
                if (!this.isConstructor() && funcAttr.type.isGround()) {
                    bl(AL, funcLabelMap.getValue(ident))
                } else {
                    val actualFuncType = FuncType(getType(), args.map { it.getType() })
                    val fLabel = groundGenericFunc(ident, actualFuncType)
                    bl(AL, fLabel)
                }
                moveSP(spOffset - oldSPOffset)
                notifyCompiler(CompilerNotifier.CallerSavePop)
                mov(getReg(), Reg(0))
            }
        }
    }

    /* Generate a ground function entry, push it to the queue. Return its label.*/
    private fun groundGenericFunc(fname: String, actualFuncType: FuncType): Label {
        if (fname[0].isUpperCase()) {
            // constructor
            assert(actualFuncType.isGround())
            val label = getConstructorLabel(fname, actualFuncType)
            if (label.name in funcLabelMap) {
                return label
            }
            groundConstructorList += GroundConstructor(fname, actualFuncType, constructorIsUnionMap.getValue(fname))
            funcLabelMap[label.name] = label
            return label
        } else {
            // non-constructor
            val labelName = "f_" + fname + "_" + actualFuncType.printAsLabel()
            if(labelName in funcLabelMap) {
                return Label(labelName)
            }
            val def = ast.functions.firstOrNull { it.name == fname }  // top-level normal function
                    ?: symbolTable.findTraitFuncDef(fname, actualFuncType)     // trait impl
            // normal function
            groundFunctionList += GroundFunction(def, actualFuncType)
            funcLabelMap[labelName] = Label(labelName)
            return Label(labelName)
        }
    }

    private fun Pattern.defineConsts(unionAtReg: Register) {
        var offsetAcc = 4
        matchVars.forEach { ident ->
            scopeEnterDef(ident)
            val type = ident.ground(currentGrounding).getType()
            val value = load(AL, getReg(), Offset(unionAtReg, offsetAcc), sizeof(type))
            alloca(ident, value, sizeof(type))
            offsetAcc += sizeof(type)
        }
    }

    /* Pre-allocate space on stack for all variables defined in this scope, except for function parameters.
    *  It would be called on the first occurrence of any declaration of any variable in this scope.
    *  Calling this method twice would do no effect. */
    private fun scopeEnterDef(variable: Identifier, params: Set<Parameter> = emptySet()) {
        if (variable.scopeId !in firstDefReachedScopes) {
            val defs = symbolTable.scopeDefs[variable.scopeId]!! - params.map { it.second.name }
            var offsetAcc = 0
            defs.forEach { v ->
                val pair = v to variable.scopeId
                val size = sizeof(symbolTable.collect[pair]!!.type)
                varOffsetMap[v to variable.scopeId] = spOffset + offsetAcc + size
                offsetAcc += size
                currScopeOffset += size
            }
            moveSP(-currScopeOffset)
            firstDefReachedScopes += variable.scopeId
        }
    }

    /* Define all prelude functions that are used in this code. */
    private fun definePreludes() {
        for (func in requiredPreludeFuncs) {
            setBlock(func.getLabel())
            when (func) {
                RUNTIME_ERROR -> {
                    mov(Reg(0), ImmNum(-1))
                    bl(AL, Label("exit"))
                    packBlock()
                }
                OVERFLOW_ERROR -> {
                    printString("OverflowError: " +
                            "the result is too small/large to store in a 4-byte signed-integer.",
                            true)
                    bl(AL, RUNTIME_ERROR.getLabel(), Unreachable)
                }
                CHECK_ARR_BOUND -> {
                    val label1 = getLabel("check_too_large")
                    val label2 = getLabel("check_finish")
                    push(SpecialReg(LR))
                    cmp(Reg(0), ImmNum(0))
                    branch(GE, label1)
                    printString("ArrayIndexOutOfBoundsError: negative index", true)
                    bl(AL, RUNTIME_ERROR.getLabel(), Unreachable)
                    setBlock(label1)
                    load(Reg(1), Offset(Reg(1)))
                    cmp(Reg(0), Reg(1))
                    branch(Condition.LT, label2)
                    printString("ArrayIndexOutOfBoundsError: index too large", true)
                    bl(AL, RUNTIME_ERROR.getLabel(), Unreachable)
                    setBlock(label2)
                    pop(SpecialReg(PC))
                }
                CHECK_DIV_BY_ZERO -> {
                    val noErr = getLabel("no_err")
                    push(SpecialReg(LR))
                    cmp(Reg(1), immFalse())
                    branch(NE, noErr)
                    printString("DivideByZeroError: divide or modulo by zero", true)
                    bl(Condition.EQ, RUNTIME_ERROR.getLabel(), Unreachable)
                    setBlock(noErr)
                    pop(SpecialReg(PC))
                }
                CHECK_NULL_PTR -> {
                    push(SpecialReg(LR))
                    val notNullLabel = getLabel("not_null")
                    cmp(Reg(0), immNull())
                    branch(NE, notNullLabel)
                    printString("NullReferenceError: dereference a null reference", true)
                    bl(AL, RUNTIME_ERROR.getLabel(), Unreachable)
                    setBlock(notNullLabel)
                    pop(SpecialReg(PC))
                }
                FREE_STRUCT -> {
                    push(SpecialReg(LR))
                    bl(AL, CHECK_NULL_PTR.getLabel())
                    bl(AL, Label("free"))
                    pop(SpecialReg(PC))
                }
                FREE_PAIR -> {
                    push(SpecialReg(LR))
                    bl(AL, CHECK_NULL_PTR.getLabel())
                    push(Reg(0))
                    load(Reg(0), Offset(Reg(0), 0))
                    bl(AL, Label("free"))
                    load(Reg(0), Offset(SpecialReg(SP), 0))
                    load(Reg(0), Offset(Reg(0), 4))
                    bl(AL, Label("free"))
                    pop(Reg(0))
                    bl(AL, Label("free"))
                    pop(SpecialReg(PC))
                }
            }
        }
    }

    /* Move the current position of sp by the given offset. */
    private fun moveSP(offset: Int, record: Boolean = true) {
        if (offset < 0) {
            binop(SUB, SpecialReg(SP), SpecialReg(SP), ImmNum(-offset))
        } else if (offset > 0) {
            binop(ADD, SpecialReg(SP), SpecialReg(SP), ImmNum(offset))
        }
        if (record) {
            spOffset -= offset
        }
    }

    /* Move the content within the given operand to a register.
    *  If the given operand is already a register, it would do nothing
    *  In other situations, it would automatically move its content to a reg using either MOV or LDR
    *  Return the register that stores the value of the operand. */
    private fun Operand.toReg(dst: Register? = null): Register = when (this) {
        is Register -> dst?.let { mov(dst, this) } ?: this
        is ImmNum -> if (num in 0..255) mov(dst ?: getReg(), this) else load(dst ?: getReg(), this)
        is Label, is Offset -> {
            load(dst ?: getReg(), this)
        }
        else -> mov(dst ?: getReg(), this)
    }

    /* This method allocates some space on stack for a variable,
    *  returns the offset from the initial sp. */
    private fun alloca(varNode: Identifier, reg: Register? = null, byte: Int = 4) {
        val offset = spOffset - varOffsetMap[varNode.getVarSID()]!!
        val dest = Offset(SpecialReg(SP), offset)
        reg?.let { store(reg, dest, byte) }
    }

    /* Find the alloca-ed variable's offset from the current position of the sp
    *  by the given var node. */
    private fun findVar(varNode: Identifier): Offset =
            Offset(SpecialReg(SP), spOffset - varOffsetMap[varNode.name to varNode.scopeId]!!)

    /* Define a string constant and return its label. */
    private fun defString(content: String, isSingleton: Boolean = true): Label {
        val msgLabel = getLabel(if (isSingleton) "singleton" else "msg")
        if (isSingleton) {
            val prevDef = singletonStringConsts[content]
            if (prevDef != null) {
                return prevDef
            }
            singletonStringConsts[content] = msgLabel
        } else {
            commonStringConsts += content to msgLabel
        }
        return msgLabel
    }

    /* Run the provided action in the context of a new scope.
    *  The original scope offset is recorded and sp is moved back to it
    *  after the action is finished. */
    private inline fun inScopeDo(action: () -> Unit) {
        val prevScopeOffset = currScopeOffset
        currScopeOffset = 0
        action()
        moveSP(currScopeOffset)
        currScopeOffset = prevScopeOffset
    }

    /* Get the next avaliable register */
    private fun getReg(): Register = Reg(virtualRegIdAcc++)

    /* Set the current block's label to the given label.
    *  Indicates the beginning of a new instruction block. */
    private fun setBlock(label: Label) {
        if (blocks.isNotEmpty() && blocks.last.terminator == B(AL, label)) {
            blocks.last.terminator = FallThrough
        }
        currBlockLabel = label
        blockComplete = false
    }

    /* Finish building the current block, pack it up and record it. */
    private fun packBlock(terminator: Terminator = FallThrough) {
        val block = InstructionBlock(currBlockLabel, instructions.toMutableList(), terminator)
        blocks.addLast(block)
        instructions.clear()
        currBlockLabel = getLabel("${currBlockLabel.name}_seq")
        blockComplete = true
    }

    /* Get a new label based on the given name prefix */
    private fun getLabel(name: String): Label = Label(labelNameTable.getName(name))

    /* Mark the relative offset for a parameter. */
    private fun markParam(paramIdent: Identifier, offset: Int) {
        varOffsetMap[paramIdent.getVarSID()] = offset
    }

    /** Instruction helper methods **/
    /* These methods are helper methods that inserts instructions, change block state, etc. */

    private fun branch(label: Label) {
        packBlock(B(AL, label))
    }

    private fun branch(cond: Condition, label: Label) {
        packBlock(B(cond, label))
    }

    private fun bl(cond: Condition, label: Label) {
        instructions += BL(cond, label)
    }

    private fun bl(cond: Condition, label: Label, terminator: Terminator) {
        bl(cond, label)
        packBlock(terminator)
    }

    private fun load(cond: Condition, dst: Register, src: Operand, byte: Int = 4): Register {
        instructions += if (src is ImmNum && src.num in 0..255) {
            Mov(cond, dst, src)
        } else if (byte == 1) {
            Ldrsb(cond, dst, src)
        } else {
            Ldr(cond, dst, src)
        }
        return dst
    }

    private fun load(dst: Register, src: Operand, byte: Int = 4): Register = load(AL, dst, src, byte)

    private fun store(src: Register, dst: Offset, byte: Int = 4): Operand {
        instructions += if (byte == 1) {
            Strb(src, dst)
        } else {
            Str(AL, src, dst)
        }
        return dst
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

    private fun notifyCompiler(notifier: CompilerNotifier) {
        instructions += notifier
    }

    private fun addDirective(type: DirectiveType) {
        blocks.last.tails += Directive(type)
    }

    private fun binop(opType: BinaryOperator,
                      dst: Register,
                      rn: Register,
                      op2: Operand,
                      op2Destructive: Boolean = false,    // op2 can be used in a destructive way if it is a reg.
                      setFlag: Boolean = false): Register {
        var overflow = false
        // If the immediate value is greater than 1024, load it into a separate register first
        var tempOp2: Operand = op2
        if (op2 is ImmNum && op2.num > maxImmNum) {
            tempOp2 = load(getReg(), op2)
        }
        when (opType) {
            ADD -> instructions += Add(AL, dst, rn, tempOp2, setFlag).also { overflow = true }
            SUB -> instructions += Sub(AL, dst, rn, tempOp2, setFlag).also { overflow = true }
            MUL -> {
                val op2Reg = op2.toReg()
                val rdHi = if (op2Destructive) op2Reg else getReg()
                instructions += Smull(AL, dst, rdHi, rn, op2Reg)
                instructions += Cmp(rdHi, dst, ASR to 31)
                callPrelude(OVERFLOW_ERROR, NE)
            }
            DIV -> {
                mov(Reg(0), rn)
                mov(Reg(1), op2)
                callPrelude(CHECK_DIV_BY_ZERO)
                bl(AL, Label("__aeabi_idiv"))
                mov(dst, Reg(0))
            }
            MOD -> {
                mov(Reg(0), rn)
                mov(Reg(1), op2)
                callPrelude(CHECK_DIV_BY_ZERO)
                bl(AL, Label("__aeabi_idivmod"))
                mov(dst, Reg(1))
            }
            GTE -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.GE, dst, immTrue()),
                    Mov(Condition.LT, dst, immFalse()))
            LTE -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.LE, dst, immTrue()),
                    Mov(Condition.GT, dst, immFalse()))
            GT -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.GT, dst, immTrue()),
                    Mov(Condition.LE, dst, immFalse()))
            LT -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.LT, dst, immTrue()),
                    Mov(Condition.GE, dst, immFalse()))
            EQ -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.EQ, dst, immTrue()),
                    Mov(Condition.NE, dst, immFalse()))
            NEQ -> instructions += listOf(
                    Cmp(rn, op2),
                    Mov(Condition.NE, dst, immTrue()),
                    Mov(Condition.EQ, dst, immFalse()))
            AND -> instructions += And(AL, dst, rn, op2)
            OR -> instructions += Orr(AL, dst, rn, op2)
        }
        if (setFlag && overflow) {
            callPrelude(OVERFLOW_ERROR, VS)
        }
        return dst
    }

    private fun cmp(op1: Register, op2: Operand) {
        instructions += Cmp(op1, op2)
    }

    private fun not(reg: Register): Register {
        instructions += Eor(AL, reg, reg, immTrue())
        return reg
    }

    private fun rsbs(dst: Register, src: Register, op2: Operand): Register {
        instructions += Rsb(true, AL, dst, src, op2)
        return dst
    }

    /** Call Prelude Function Helper Methods **/

    private fun callCheckArrBound(expected: Operand, arrayPtr: Register) {
        mov(Reg(0), expected.toReg())
        mov(Reg(1), arrayPtr)
        callPrelude(CHECK_ARR_BOUND)
    }

    private fun callMalloc(size: Int): Register {
        mov(Reg(0), ImmNum(size))
        bl(AL, Label("malloc"))
        return Reg(0)
    }

    private fun callScanf(expr: Expression) {
        val exprOffset: Offset = getLhsAddress(expr)
        binop(ADD, Reg(1), exprOffset.src, ImmNum(exprOffset.offset))
        val type = expr.getType()
        val fmtStr = (if (type == charType()) " " else "") +
                getFormatString(type, false)
        load(Reg(0), defString(fmtStr, true))
        binop(ADD, Reg(0), Reg(0), ImmNum(4))
        bl(AL, Label("scanf"))
    }

    private fun printString(str: String, newline: Boolean) {
        callPrintf(StringLit(str).also {
            it.reifiedType = stringType()
            it.groundedType = stringType()
        }, newline)
    }

    private fun callPrintf(expr: Expression, newline: Boolean) {
        val operand = expr.toARM().toReg()
        val exprType = expr.getType()
        when (exprType) {
            boolType() -> {
                cmp(operand, immFalse())
                load(NE, Reg(1), defString("true"))
                load(Condition.EQ, Reg(1), defString("false"))
                binop(ADD, Reg(1), Reg(1), ImmNum(4), false)
                load(Reg(0), defString(getFormatString(exprType, newline)))
                binop(ADD, Reg(0), Reg(0), ImmNum(4), false)
            }
            stringType(),
            arrayTypeOf(charType()) -> {
                mov(Reg(1), operand)
                binop(ADD, Reg(1), Reg(1), ImmNum(4), false)
                load(Reg(0), defString(getFormatString(exprType, newline)))
                binop(ADD, Reg(0), Reg(0), ImmNum(4), false)
            }
            else -> {
                mov(Reg(1), operand)
                load(Reg(0), defString(getFormatString(exprType, newline)))
                binop(ADD, Reg(0), Reg(0), ImmNum(4))
            }
        }
        bl(AL, Label("printf"))
        mov(Reg(0), ImmNum(0))
        bl(AL, Label("fflush"))
    }

    /* Call a prelude function. */
    private fun callPrelude(func: PreludeFunc, cond: Condition = AL) {
        requiredPreludeFuncs += func.findDependencies()
        bl(cond, func.getLabel())
    }

    /* Get the address of a lhs expression, returns an offset. */
    private fun getLhsAddress(lhs: Expression): Offset {
        lhs.ground(currentGrounding)
        return when (lhs) {
            is Identifier -> findVar(lhs)
            is ArrayElem -> {
                var result = findVar(lhs.arrIdent)
                val arrReg = getReg()
                var currType = lhs.arrIdent.ground(currentGrounding).getType()
                for (expr in lhs.indices) {
                    val indexReg = expr.toARM().toReg()
                    load(AL, arrReg, result)
                    callCheckArrBound(indexReg, arrReg)
                    currType = currType.unwrapArrayType()!!
                    binop(MUL, indexReg, indexReg, ImmNum(sizeof(currType)), op2Destructive = true)
                    binop(ADD, indexReg, indexReg, ImmNum(4))
                    binop(ADD, arrReg, arrReg, indexReg)
                    result = Offset(arrReg)
                }
                result
            }
            is PairElem -> {
                val pairAddr = lhs.expr.toARM().toReg()
                mov(Reg(0), pairAddr)
                callPrelude(CHECK_NULL_PTR)
                // lhs type in codegen is guaranteed to be a "pair" NewType
                val lhsType = lhs.expr.getType() as NewType
                Offset(pairAddr, when (lhs.func) {
                    FST -> 0; SND -> sizeof(lhsType.generics[0])
                })
            }
            is TypeMember -> {
                val addr = lhs.expr.toARM().toReg()
                mov(Reg(0), addr)
                callPrelude(CHECK_NULL_PTR)
                val offset = getMemberOffset(lhs.memberName, lhs.expr.getType())
                Offset(addr, offset)
            }
            else -> {
                throw IllegalArgumentException("Target has to be a left-hand-side expression")
            }
        }
    }

    private fun getFormatString(type: Type, newline: Boolean): String {
        val format = when (type) {
            is BaseType -> when (type.kind) {
                INT -> "%d"
                CHAR -> "%c"
                BOOL -> "%s"
                STRING -> "%s"
                else -> "%p"
            }
            arrayTypeOf(charType()) -> "%s"
            else -> "%p"
        }
        return format + if (newline) "\\n" else ""
    }

    private fun getConstructorLabel(name: String, type: FuncType): Label =
            Label("c_${name}_${type.printAsLabel()}")

    private fun Expression.getType(): Type = this.groundedType

    private fun sizeof(type: Type): Int = when (type) {
        charType(), boolType() -> 1
        is TypeVar -> sizeof(currentGrounding[type.name to true]
                ?: throw IllegalArgumentException("type var ${type.name} not found in grounding $currentGrounding"))
        else -> 4
    }

    private fun mallocSize(constructorType: FuncType, isTaggedUnion: Boolean = false): Int {
        val s = constructorType.paramTypes.sumBy { sizeof(it) }
        return s + if (isTaggedUnion) 4 else 0
    }

    private fun getMemberOffset(name: String, type: Type): Int {
        if (type is NewType) {
            var acc = 0
            val constructorFunc = symbolTable.functions.getValue(type.name)
            val sub = type.findUnifier(constructorFunc.type.retType)
            val groundFuncType = constructorFunc.type.substitutes(sub) as FuncType
            for ((i, member) in constructorFunc.members.withIndex()) {
                if (member.second.name == name) {
                    return acc
                }
                acc += sizeof(groundFuncType.paramTypes[i])
            }
        }
        throw SemanticException.UndefinedFuncException(type.toString()) // should never reach here
    }
}