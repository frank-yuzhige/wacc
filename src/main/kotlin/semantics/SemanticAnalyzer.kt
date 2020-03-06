package semantics

import ast.*
import ast.BinaryOperator.EQ
import ast.BinaryOperator.NEQ
import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
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
import semantics.TypeChecker.Companion.match
import semantics.TypeChecker.Companion.matchPairByElem
import semantics.TypeChecker.Companion.pass
import semantics.TypeChecker.Companion.unwrapArray
import semantics.TypeChecker.Companion.unwrapPair
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
        functions.map {
            treeStack.push(it)
            try {
                symbolTable.defineFunc(it)
            } catch (sme: SemanticException) {
                logError(sme.msg)
            }
            treeStack.pop()
        }
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
        this.body.map { it.check(returnType) }
        symbolTable.popScope()?.let { logWarning(it) }
        treeStack.pop()
    }

    private fun Statements.checkBlock(returnType: Type = anyType(), preDefinitons: () -> Unit = {}) {
        symbolTable.pushScope()
        preDefinitons()
        this.map { it.check(returnType) }
        symbolTable.popScope()?.let { logWarning(it) }
    }

    private fun Statement.check(returnType: Type) {
        treeStack.push(this)
        when (this) {
            Skip -> Skip
            is Declaration -> {
                val defType = if (type == BaseType(ANY)) {
                    rhs.getType().normalize()
                } else {
                    type
                }
                val prevAttr = symbolTable.defineVar(defType, variable, isConst)
                if (prevAttr != null) {
                    logError(listOf(variableAlreadyDefined(variable, prevAttr.type, symbolTable.lookupVar(variable, false)!!.index)))
                }
                rhs.checkExpr(defType)
            }
            is Assignment -> try {
                val lhsType = lhs.checkLhsExpr(anyType(), isPush = true, isWrite = true)
                rhs.checkExpr(lhsType)
            } catch (sme: SemanticException) {
                logError(sme.msg)
                rhs.checkExpr(anyType())
            }
            is Read -> try {
                val lhsType = target.checkLhsExpr(anyType(), isPush = true, isWrite = true)
                TODO()
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
                thenBody.checkBlock(returnType)
            }
            is CondBranch -> {
                condStatsList.forEach { (expr, stats) ->
                    expr.checkExpr(boolType())
                    stats.checkBlock(returnType)
                }
                elseBody.checkBlock(returnType)
            }
            is ForLoop -> {
                TODO()
            }
            is WhileLoop -> {
                expr.checkExpr(boolType())
                body.checkBlock(returnType)
            }
            is WhenClause -> {
                expr.checkExpr(anyType())
                val matchingType = expr.getType()
                whenCases.forEach { (pattern, stmts) ->
                    val entry = symbolTable.lookupFunc(pattern.constructor)
                    when {
                        entry == null ->
                            logError(accessToUndefinedFunc(pattern.constructor))
                        entry.type.retType != matchingType ->
                            logError(typeMismatchError(entry.type.retType, matchingType))
                        entry.type.paramTypes.size != pattern.matchVars.size ->
                            logError(patternUnmatchedError(entry.type.paramTypes.size, pattern.matchVars.size))
                        else -> {
                            val duplicates = pattern.matchVars.groupingBy { it }.eachCount().filter { it.value > 1 }
                            if (duplicates.isNotEmpty()) {
                                logError("sdsdsads")
                            } else {
                                val preDefs = {
                                    pattern.matchVars.withIndex().forEach { (i, match) ->
                                        symbolTable.defineVar(entry.members[i].getType(), match, isConst = true)
                                    }
                                }
                                stmts.checkBlock(returnType, preDefs)
                            }
                        }
                    }
                }
            }
            is Block -> body.checkBlock(returnType)
        }
        treeStack.pop()
    }

    private fun Expression.checkLhs(tc: TypeChecker,
                                    isPush: Boolean,
                                    isWrite: Boolean,
                                    logAction: (List<String>) -> Unit = { logError(it) }): Type? {
        var result: Type? = null
        if (isPush) {
            treeStack.push(this)
        }
        when (this) {
            is Identifier -> {
                val attr = symbolTable.lookupVar(this, isWrite)
                if (attr != null) {
                    val actual = attr.type
                    val scopeId = attr.scopeId
                    val errors = tc.test(actual)
                    if (errors.isEmpty()) {
                        this.scopeId = scopeId
                        result = actual
                    } else {
                        logAction(errors)
                    }
                } else {
                    logAction(listOf(accessToUndefinedVar(name)))
                }
            }
            is PairElem -> {
                if (expr == NullLit) {
                    logAction(listOf(accessToNullLiteral(func.value)))
                } else {
                    var hasError = false
                    expr.check(matchPairByElem(func, tc)) { logAction(it); hasError = true }
                    if (!hasError) {
                        try {
                            result = expr.getType().unwrapPairType(func)
                        } catch (sme: SemanticException) {
                            logAction(listOf(sme.msg))
                        }
                    }
                }
            }
            is ArrayElem -> {
                /* Check if the array var is in scope */
                symbolTable.lookupVar(arrIdent, isWrite = false)?.let { attr ->
                    this.arrIdent.scopeId = attr.scopeId
                    attr.type.unwrapArrayType(indices.count())?.let { actual ->
                        /* Check each index is int */
                        var hasError = false
                        indices.map { expr ->
                            expr.check(match(intType())) { err -> logAction(err); hasError = true }
                        }
                        if (!hasError) {
                            /* Test expected array type with actual unwrapped type */
                            val tcErrors = tc.test(actual)
                            if (tcErrors.isEmpty()) {
                                result = actual
                            }
                            logAction(tcErrors)
                        }
                    } ?: logAction(listOf(insufficientArrayRankError(arrIdent.name, attr.type, indices.count())))
                } ?: logAction(listOf(accessToUndefinedVar(arrIdent.name)))
            }
            is TypeMember -> {
                var hasError = false
                expr.check(pass()) { logAction(it); hasError = true }
                if (!hasError) {
                    try {
                        result = getType()
                    } catch (sme: SemanticException) {
                        logAction(listOf(sme.msg))
                    }
                }
            }
            else -> logAction(listOf("Not a proper assign-lhs statement!")) // Should never reach here...
        }
        if (isPush) {
            treeStack.pop()
        }
        return result
    }

    private fun Expression.check(tc: TypeChecker,
                                 logAction: (List<String>) -> Unit = { logError(it) }) {
        treeStack.push(this)
        when (this) {
            is NullLit -> logAction(tc.test(anyPairType()))
            is IntLit -> logAction(tc.test(intType()))
            is BoolLit -> logAction(tc.test(boolType()))
            is CharLit -> logAction(tc.test(charType()))
            is StringLit -> logAction(tc.test(stringType()))
            is Identifier, is PairElem, is ArrayElem, is TypeMember ->
                checkLhs(tc, isPush = false, isWrite = false, logAction = logAction)
            is BinExpr -> {
                when (op) {
                    EQ, NEQ -> {
                        logAction(tc.test(boolType()))
                        try {
                            left.check(match(right.getType()))
                        } catch (sme: SemanticException) {
                            logAction(listOf(sme.msg))
                        }
                    }
                    else -> {
                        val errors = arrayListOf<List<String>>()
                        for (entry in BinaryOperator.typeMap.getValue(op)) {
                            val retChecker = tc.forwardsError(
                                    "    unexpected return type for binary operator '${op.op}' ")
                            val temp = mutableListOf<String>()
                            /* Check return type */
                            temp += retChecker.test(entry.retType)
                            /* Check lhs */
                            left.check(entry.lhsChecker) {
                                temp += it.map { err ->
                                    "$err\n${left.getTraceLog()}\n" +
                                            "    on the left-hand-side of '${op.op}'"
                                }
                            }
                            /* Check rhs */
                            right.check(entry.rhsChecker) {
                                temp += it.map { err ->
                                    "$err\n${right.getTraceLog()}" +
                                            "\n    on the right-hand-side of '${op.op}'"
                                }
                            }
                            errors += temp
                            if (temp.isEmpty()) {
                                break
                            }
                        }
                        /* If any of the cases passed (an empty error list), do nothing.
                         * otherwise we log the error list with the fewest errors */
                        if (!errors.any(List<String>::isEmpty)) {
                            logAction(errors.minBy { it.size }!!)
                        }
                    }
                }
            }
            is IfExpr -> {
                condStatsList.forEach { (cond, expr) ->
                    cond.check(match(boolType()))
                    expr.check(tc)
                }
                elseExpr.check(tc)
            }
            is ArrayLiteral -> {
                if (elements.isEmpty()) {
                    logAction(tc.test(anyArrayType()))
                } else {
                    val temp: MutableList<String> = mutableListOf()
                    /* Take the first element's type as the type of the array */
                    /* Check the first element's type */
                    elements.first().check(unwrapArray(tc)) { temp += it }
                    /* if there is an error, log immediately, so the error logs won't get squashed together */
                    if (temp.isNotEmpty()) {
                        logAction(temp)
                        temp.clear()
                    }
                    /* Check if all elements in the array are of the same type */
                    val fstElemType = elements.first().getType()
                    for ((index, element) in elements.drop(1).withIndex()) {
                        val checker = match(fstElemType)
                                .forwardsError("    at the ${NumberFormatter.get(index + 1)} element in the array")
                        element.check(checker) { temp += it }
                    }
                    if (temp.isNotEmpty()) {
                        logAction(temp)
                    }
                }
            }
            is NewPair -> {
                first.check(unwrapPair(FST, tc))
                second.check(unwrapPair(SND, tc))
            }
            is UnaryExpr -> {
                val entry = UnaryOperator.typeMap().getValue(op)
                val checker = entry.first
                val retType = entry.second
                tc.test(retType) + expr.check(checker)
            }
            is EnumRange -> {

            }
            is FunctionCall -> {
                val funcEntry = symbolTable.lookupFunc(ident)
                if (funcEntry == null) {
                    logAction(listOf(accessToUndefinedFunc(ident)))
                } else {
                    val funcType = funcEntry.type
                    val retType = funcType.retType
                    val expectedCount = funcType.paramTypes.size
                    val actualCount = args.size
                    if (expectedCount != actualCount) {
                        logAction(listOf(parameterNumMismatch(ident, funcType, expectedCount, actualCount)))
                    } else {
                        logAction(tc.test(retType))
                        args.zip(funcType.paramTypes) { arg, t -> arg.check(match(t)) }
                    }
                }
            }
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
                    if (exprType !is NewType) TODO()
                    getType() inferFrom expecting
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
                    left.checkExpr(funcType.paramTypes[0], logAction)
                    right.checkExpr(funcType.paramTypes[1], logAction)
                    funcType.retType
                }
                is UnaryExpr -> {
                    val funcType = UnaryOperator.funcTypeMap.getValue(op) unifyReturn expecting
                    expr.checkExpr(funcType.paramTypes[0], logAction)
                    funcType.retType
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
                    args.zip(newFuncType.paramTypes) { arg, type -> arg.checkExpr(type, logAction) }
                    newFuncType.retType
                }
            }
        } catch (sme: SemanticException) {
            logAction(listOf(sme.msg))
            throw sme
        } finally {
            treeStack.pop()
        }
        type = inferredType
        return inferredType
    }

    private fun Expression.getType(): Type = symbolTable.getType(this, SymbolTable.AccessType.IN_SEM_CHECK)

    private infix fun Type.instanceOf(traits: List<Trait>): Boolean {
        return traits.all { symbolTable.isInstance(this, it) }
    }

    private infix fun FuncType.unifyReturn(expecting: Type): FuncType {
        System.err.println("expecting: $expecting")
        val newRet = retType inferFrom expecting
        System.err.println("after infer: $newRet")
        val sub = newRet.findUnifier(retType)
        return (this.substitutes(sub) as FuncType)
    }

    private fun Type.findUnifier(original: Type): Map<Pair<String, Boolean>, Type> {
        return when(original) {
            is BaseType -> emptyMap()
            is ArrayType -> when {
                this is ArrayType -> type.findUnifier(original.type)
                else -> emptyMap()
            }
            is PairType -> TODO()
            is NewType -> when {
                this is NewType && name == original.name -> {
                    val map = mutableMapOf<Pair<String, Boolean>, Type>()
                    generics.zip(original.generics).forEach { (new, old) ->
                        map.putAll(new.findUnifier(old))
                    }
                    map
                }
                else -> emptyMap()
            }
            is TypeVar -> mapOf((original.name to original.isReified) to this)
            is FuncType -> TODO()
        }
    }

    private infix fun Type.inferFrom(expecting: Type): Type {
        val actual = this
        System.err.println("Inferring expected: $expecting <==> actual: $actual")
        return when(expecting) {
            is BaseType -> when(actual) {
                is BaseType -> if (expecting == actual) actual else throw TypeMismatchException(expecting, actual)
                is TypeVar -> if (expecting instanceOf actual.traits) expecting else throw TypeMismatchException(expecting, actual)
                else -> throw TypeMismatchException(expecting, actual)
            }
            is ArrayType -> when(actual) {
                is ArrayType -> ArrayType(actual.type inferFrom expecting.type)
                is TypeVar -> if (expecting instanceOf actual.traits) expecting else throw TypeMismatchException(expecting, actual)
                else -> throw TypeMismatchException(expecting, actual)
            }
            is PairType -> when(actual) {
                is PairType -> PairType(
                        actual.firstElemType inferFrom expecting.firstElemType,
                        actual.secondElemType inferFrom expecting.secondElemType
                )
                is TypeVar -> if (expecting instanceOf actual.traits) expecting else throw TypeMismatchException(expecting, actual)
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
                is TypeVar -> if (expecting instanceOf actual.traits) expecting else throw TypeMismatchException(expecting, actual)
                else -> throw TypeMismatchException(expecting, actual)
            }
            is TypeVar -> if(expecting.isReified) {
                if (actual instanceOf expecting.traits) expecting else throw TypeMismatchException(expecting, actual)
            } else {
                if (actual instanceOf expecting.traits) actual else throw TypeMismatchException(expecting, actual)
            }
            is FuncType -> when(actual) {
                is TypeVar -> if(expecting instanceOf actual.traits) expecting else throw TypeMismatchException(expecting, actual)
                is FuncType -> TODO()
                else -> throw TypeMismatchException(expecting, actual)
            }
        }
    }

}

