package semantics

import ast.*
import ast.Expression.*
import ast.Function
import ast.Statement.*
import ast.Statement.BuiltinFunc.*
import ast.Type.*
import ast.Type.BaseTypeKind.ANY
import ast.Type.Companion.anyArrayType
import ast.Type.Companion.anyPairType
import ast.Type.Companion.anyType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.stringType
import exceptions.SemanticException
import exceptions.SemanticException.*
import utils.*
import java.util.*

class SemanticAnalyzer() {
    val symbolTable = SymbolTable()
    private val treeStack: Deque<WaccAST> = ArrayDeque()
    private val errorLog: MutableList<String> = arrayListOf()
    private val warningLog: MutableList<String> = arrayListOf()
    private var isInMain = false
    private var allowsWarning = true

    fun doCheck(ast: ProgramAST) {
        ast.check()
        if (allowsWarning && warningLog.isNotEmpty()) {
            printWarningMessages()
        }
        if (errorLog.isNotEmpty()) {
            val count = errorLog.size
            val plural = if (count == 1) "" else "s"
            throw SemanticException("$count semantic error$plural:\n${errorLog.joinToString("\n\n\n")}")
        }
    }

    private fun printWarningMessages() {
        logWarning(symbolTable.functions
                .filter { (_, attr) -> attr.occurrences == 1 }
                .map { (ident, attr) ->
                    "Unused function $ident at ${attr.index}: function defined but never called"
                })
        val count = warningLog.size
        val plural = if (count == 1) "" else "s"
        println("$WARNING$count warning$plural:$RESET")
        warningLog.forEach { println("$WARNING[Warning]: $it\n$RESET") }
    }

    fun suppressWarning(): SemanticAnalyzer = this.also { allowsWarning = false }

    private fun logError(causes: List<String>) {
        if (causes.isNotEmpty()) {
            logError(causes.joinToString("\n"))
        }
    }

    private fun logError(cause: String) {
        logMessage(cause, errorLog)
    }

    private fun logWarning(causes: List<String>) {
        if (causes.isNotEmpty()) {
            logMessage(causes.joinToString("\n"), warningLog)
        }
    }

    private fun logMessage(cause: String, log: MutableList<String>) {
        val message = cause + treeStack.joinToString("") { "\n${it.getTraceLog()}" }
        val inMain = if (isInMain) "\nIn the main program" else ""
        log += message + inMain
    }

    private fun ProgramAST.check() {
        newTypes.map {
            treeStack.push(it)
            try {
                symbolTable.defineType(it)
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            treeStack.pop()
        }
        traits.map {
            treeStack.push(it)
            try {
                symbolTable.defineTrait(it)
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            treeStack.pop()
        }
        instances.map {
            treeStack.push(it)
            try {
                symbolTable.implementTrait(it)
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            treeStack.pop()
        }
        functions.map {
            treeStack.push(it)
            try {
                symbolTable.defineFunc(it)
                it.args.map { arg -> arg.first.validated() }
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            treeStack.pop()
        }
        instances.map { it.functions.map { f -> f.reified().checkFunc() } }
        functions.map { it.reified().checkFunc() }
        isInMain = true
        mainProgram.checkBlock()
    }

    private fun Function.checkFunc() {
        treeStack.push(this)
        symbolTable.pushScope()
        args.map { param ->
            symbolTable.defineVar(param.getType(), param.getIdent(), isConst = false)
        }
        this.body.map { it.check(returnType, typeConstraints) }
        symbolTable.popScope()?.let { logWarning(it) }
        treeStack.pop()
    }

    private fun Statements.checkBlock(returnType: Type = anyType(), typeconstraints: List<TypeConstraint> = emptyList(), preDefinitons: () -> Unit = {}) {
        symbolTable.pushScope()
        preDefinitons()
        this.map { it.check(returnType, typeconstraints) }
        symbolTable.popScope()?.let { logWarning(it) }
    }

    private fun Statement.check(returnType: Type, typeconstraints: List<TypeConstraint>) {
        treeStack.push(this)
        when (this) {
            Skip -> Skip
            is Declaration -> {
                val defType = if (type == BaseType(ANY)) {
                    anyType()
                } else {
                    type.reified(typeconstraints).validated()
                }
                val realType = rhs.checkExpr(defType)
                val prevAttr = symbolTable.defineVar(realType, variable, isConst)
                if (prevAttr != null) {
                    logError(listOf(variableAlreadyDefined(variable, prevAttr.type, symbolTable.lookupVar(variable, false)!!.index)))
                }
            }
            is Assignment -> {
                val lhsType = try {
                    lhs.checkLhsExpr(anyType(), isPush = true, isWrite = true)
                } catch (sme: SemanticException) {
                    logError(sme.msg)
                    anyType()
                }
                rhs.checkExpr(lhsType)
            }
            is Read -> try {
                target.checkLhsExpr(TypeVar("A", Trait("Read")), isPush = true, isWrite = true)
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            is BuiltinFuncCall -> when (func) {
                PRINT, PRINTLN -> expr.checkExpr(anyType())
                FREE -> expr.checkExpr(TypeVar("A", Trait("Malloc")))
                EXIT -> expr.checkExpr(intType())
                RETURN -> expr.checkExpr(returnType)
            }
            is IfThen -> {
                expr.checkExpr(boolType())
                thenBody.checkBlock(returnType, typeconstraints)
            }
            is CondBranch -> {
                condStatsList.forEach { (expr, stats) ->
                    expr.checkExpr(boolType())
                    stats.checkBlock(returnType, typeconstraints)
                }
                elseBody.checkBlock(returnType, typeconstraints)
            }
            is ForLoop -> {
                TODO()
            }
            is WhileLoop -> {
                expr.checkExpr(boolType())
                body.checkBlock(returnType, typeconstraints)
            }
            is WhenClause -> try {
                val matchingType = expr.checkExpr(anyType())
                if (!matchingType.isDetermined()) {
                    throw UngroundTypeException(matchingType)
                }
                whenCases.forEach { (pattern, stmts) ->
                    val entry = symbolTable.lookupFunc(pattern.constructor)
                    when {
                        entry == null -> throw UndefinedFuncException(pattern.constructor)
                        entry.type.paramTypes.size != pattern.matchVars.size ->
                            logError(patternUnmatchedError(entry.type.paramTypes.size, pattern.matchVars.size))
                        else -> {
                            val realFuncType = entry.type unifyReturn matchingType
                            val duplicates = pattern.matchVars.groupingBy { it }.eachCount().filter { it.value > 1 }
                            if (duplicates.isNotEmpty()) {
                                throw MultipleVarDefInPatternException(duplicates.keys.map { it.name })
                            }
                            stmts.checkBlock(returnType, typeconstraints) {
                                pattern.matchVars.withIndex().forEach { (i, match) ->
                                    symbolTable.defineVar(realFuncType.paramTypes[i], match, isConst = true)
                                }
                            }
                        }
                    }
                }
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            is Block -> body.checkBlock(returnType, typeconstraints)
        }
        treeStack.pop()
    }

    private fun Expression.checkLhsExpr(expecting: Type,
                                        isPush: Boolean,
                                        isWrite: Boolean,
                                        logAction: (List<String>) -> Unit = { logError(it) }): Type {
        if(isPush) {
            treeStack.push(this)
        }
        val inferredType = try {
            when(this) {
                is Identifier -> {
                    val attr = symbolTable.lookupVar(this, isWrite)
                            ?:throw UndefinedVarException(name)
                    (attr.type inferFrom expecting).also {
                        this.scopeId = attr.scopeId
                    }
                }
                is ArrayElem -> {
                    val arrAttribute = symbolTable.lookupVar(arrIdent, false)
                            ?:throw UndefinedVarException(arrIdent.name)
                    val type = arrAttribute.type.unwrapArrayType(indices.size)
                            ?: throw NotEnoughArrayRankException(arrIdent.name)
                    indices.map { it.checkExpr(intType()) }
                    type inferFrom expecting
                }
                is PairElem -> TODO()
                is TypeMember -> {
                    val exprType = expr.checkExpr(anyType())
                    if (exprType !is NewType) throw NotAStructTypeException(exprType)
                    val memberType = symbolTable.getTypeMemberType(exprType, memberName)
                    memberType inferFrom expecting
                }
                else -> TODO()
            }
        } catch (sme: SemanticException) {
            logAction(listOf(sme.msg))
            type
        } finally {
            if (isPush) {
                treeStack.pop()
            }
        }
        this.type = inferredType
        return inferredType
    }

    private fun Expression.checkExpr(expecting: Type,
                                     logAction: (List<String>) -> Unit = { logError(it) }): Type {
        treeStack.push(this)
        System.err.println("**** checking: ${this.prettyPrint()} against: $expecting")
        val inferredType = try {
            when(this) {
                NullLit -> anyPairType() inferFrom expecting
                is IntLit -> intType() inferFrom expecting
                is BoolLit -> boolType() inferFrom expecting
                is CharLit -> charType() inferFrom expecting
                is StringLit -> stringType() inferFrom expecting
                is Identifier, is ArrayElem, is PairElem, is TypeMember ->
                    checkLhsExpr(expecting, isPush = false, isWrite = false, logAction = logAction)
                is BinExpr -> {
                    val funcType = BinaryOperator.funcTypeMap.getValue(op) unifyReturn expecting
                    val lt = left.checkExpr(funcType.paramTypes[0], logAction)
                    val rt = right.checkExpr(funcType.paramTypes[1], logAction)
                    val lu = lt.findUnifier(funcType.paramTypes[0])
                    val ru = rt.findUnifier(funcType.paramTypes[0])
                    funcType.retType.substitutes(lu).substitutes(ru)
                }
                is UnaryExpr -> {
                    val funcType = UnaryOperator.funcTypeMap.getValue(op) unifyReturn expecting
                    val childType = expr.checkExpr(funcType.paramTypes[0], logAction)
                    val sub = childType.findUnifier(funcType.paramTypes[0])
                    funcType.retType.substitutes(sub)
                }
                is ArrayLiteral -> when {
                    elements.isEmpty() -> anyArrayType() inferFrom expecting
                    else -> {
                        val temp: MutableList<String> = mutableListOf()
                        val elemExpecting = expecting.unwrapArrayType()
                                ?: throw TypeMismatchException(expecting, anyArrayType())
                        val fstType = elements.first().checkExpr(elemExpecting) { temp += it }
                        elements.drop(1).forEach { elem -> elem.checkExpr(fstType) { temp += it } }
                        if(temp.isNotEmpty()) {
                            logAction(temp)
                        }
                        ArrayType(fstType)
                    }
                }
                is NewPair -> TODO()
                is EnumRange -> TODO()
                is IfExpr -> {
                    val conds = condStatsList.map { it.first }
                    conds.map { it.checkExpr(boolType()) }
                    val exprs = condStatsList.map { it.second } + elseExpr
                    exprs.fold(expecting) { expect, actual -> actual.checkExpr(expect) }
                }
                is FunctionCall -> {
                    val funcType = symbolTable.lookupFunc(ident)?.type
                            ?: throw UndefinedFuncException(ident)
                    val newFuncType = funcType unifyReturn expecting
                    if (args.size != newFuncType.paramTypes.size) {
                        throw FuncCallArgsMismatchException(ident, newFuncType.paramTypes.size, args.size)
                    }
                    val argsGrounds = args.zip(newFuncType.paramTypes) { arg, type -> arg.checkExpr(type, logAction) }
                    val sub: Grounding = argsGrounds
                            .zip(newFuncType.paramTypes) { ground, type -> ground.findUnifier(type)  }
                            .fold(mutableMapOf()) { a, b -> a.also { it.putAll(b) } }

                    newFuncType.retType.substitutes(sub)
                }
            }
        } catch (sme: SemanticException) {
            logAction(listOf(sme.msg))
            System.err.println("$$> logging: ${sme.msg}")
            TypeVar("A")
        }
        type = inferredType
        System.err.println("*** finish: ${this.prettyPrint()} is $inferredType ***")
        if (!inferredType.isDetermined()) {
            logAction(listOf(UngroundTypeException(inferredType).msg))
        }
        treeStack.pop()
        return inferredType
    }

    private infix fun Type.instanceOf(traits: List<Trait>): Type {
        return if (traits.all { symbolTable.isInstance(this, it) }) {
            this
        } else {
            throw TypeNotSatisfyingTraitsException(this, traits)
        }
    }

    private infix fun FuncType.unifyReturn(expecting: Type): FuncType {
        val newRet = retType inferFrom expecting
        val sub = newRet.findUnifier(retType)
        return (this.substitutes(sub) as FuncType)
    }

    private infix fun Type.inferFrom(expecting: Type): Type {
        val actual = this
        System.err.println("Inferring expected: $expecting <==> actual: $actual")
        return when(expecting) {
            is BaseType -> when(actual) {
                is BaseType -> if (expecting == actual) actual else throw TypeMismatchException(expecting, actual)
                is TypeVar -> expecting instanceOf actual.traits
                else -> throw TypeMismatchException(expecting, actual)
            }
            is ArrayType -> when(actual) {
                is ArrayType -> ArrayType(actual.type inferFrom expecting.type)
                is TypeVar -> expecting instanceOf actual.traits
                else -> throw TypeMismatchException(expecting, actual)
            }
            is PairType -> when(actual) {
                is PairType -> PairType(
                        actual.firstElemType inferFrom expecting.firstElemType,
                        actual.secondElemType inferFrom expecting.secondElemType
                )
                is TypeVar -> expecting instanceOf actual.traits
                else -> throw TypeMismatchException(expecting, actual)
            }
            is NewType -> when(actual) {
                is NewType -> {
                    if (actual.name == expecting.name && actual.generics.size == expecting.generics.size) {
                        NewType(actual.name, actual.generics.zip(expecting.generics) { ga, ge -> ga inferFrom ge })
                    } else {
                        throw TypeMismatchException(expecting, actual)
                    }
                }
                is TypeVar -> expecting instanceOf actual.traits
                else -> throw TypeMismatchException(expecting, actual)
            }
            is TypeVar -> if(expecting.isReified) {
                when(actual) {
                    is TypeVar -> if(actual.isReified) {
                        if(actual == expecting) expecting else throw TypeMismatchException(expecting, actual)
                    } else {
                        expecting instanceOf actual.traits
                    }
                    else -> throw TypeMismatchException(expecting, actual)
                }

            } else {
                actual instanceOf expecting.traits
            }
            is FuncType -> when(actual) {
                is TypeVar -> expecting instanceOf actual.traits
                is FuncType -> TODO()
                else -> throw TypeMismatchException(expecting, actual)
            }
        }.also { System.err.println("We get: $it") }
    }

    private fun Type.validated(): Type = if(this is NewType) {
        symbolTable.lookupType(this)?.let{ this }?: throw UndefinedTypeException(this.name)
    } else {
        this
    }

}

