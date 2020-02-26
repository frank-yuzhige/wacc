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
import ast.Type.BaseType
import ast.Type.BaseTypeKind.ANY
import ast.Type.Companion.anyArrayType
import ast.Type.Companion.anyPairType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.stringType
import exceptions.SemanticException
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
        functions.map { it.checkFunc(match(it.returnType)) }
        isInMain = true
        mainProgram.checkBlock()
    }

    private fun Function.checkFunc(retCheck: TypeChecker) {
        treeStack.push(this)
        symbolTable.pushScope()
        args.map { param ->
            symbolTable.defineVar(param.getType(), param.getIdent())
        }
        this.body.map { it.check(retCheck) }
        symbolTable.popScope()?.let { logWarning(it) }
        treeStack.pop()
    }

    private fun Statements.checkBlock(retCheck: TypeChecker = pass()) {
        symbolTable.pushScope()
        this.map { it.check(retCheck) }
        symbolTable.popScope()?.let { logWarning(it) }
    }

    private fun Statement.check(retCheck: TypeChecker) {
        treeStack.push(this)
        when (this) {
            Skip -> Skip
            is Declaration -> {
                val defType = if (type == BaseType(ANY)) {
                    rhs.getType().normalize()
                } else {
                    type
                }
                val prevAttr = symbolTable.defineVar(defType, variable)
                if (prevAttr != null) {
                    logError(listOf(variableAlreadyDefined(variable, prevAttr.type, symbolTable.lookupVar(variable)!!.index)))
                }
                rhs.check(match(type))
            }
            is Assignment -> {
                val lhsType = lhs.checkLhs()
                lhsType?.let { rhs.check(match(it)) } ?: rhs.check(pass())
            }
            is Read -> {
                val lhsType = target.checkLhs()
                val readChecker = match(intType(), charType(), stringType())
                lhsType?.let { logError(readChecker.test(it)) }
            }
            is BuiltinFuncCall -> when (func) {
                PRINT, PRINTLN -> expr.check(pass())
                FREE -> expr.check(match(anyArrayType(), anyPairType()))
                EXIT -> expr.check(match(intType()))
                RETURN -> expr.check(retCheck)
            }
            is IfThen -> {
                expr.check(match(boolType()))
                thenBody.checkBlock(retCheck)
            }
            is CondBranch -> {
                condStatsList.forEach { (expr, stats) ->
                    expr.check(match(boolType()))
                    stats.checkBlock(retCheck)
                }
                elseBody.checkBlock(retCheck)
            }
            is ForLoop -> {
                TODO()
            }
            is WhileLoop -> {
                expr.check(match(boolType()))
                body.checkBlock(retCheck)
            }
            is Block -> body.checkBlock(retCheck)
        }
        treeStack.pop()
    }

    private fun Expression.checkLhs(tc: TypeChecker = pass(),
                                    isPush: Boolean = true,
                                    logAction: (List<String>) -> Unit = { logError(it) }): Type? {
        var result: Type? = null
        if (isPush) {
            treeStack.push(this)
        }
        when (this) {
            is Identifier -> {
                val attr = symbolTable.lookupVar(this)
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
                symbolTable.lookupVar(arrIdent)?.let { attr ->
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
            is Identifier, is PairElem, is ArrayElem, is TypeMember -> checkLhs(tc, false, logAction)
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

    fun Expression.getType(): Type = symbolTable.getType(this, SymbolTable.AccessType.IN_SEM_CHECK)
}

