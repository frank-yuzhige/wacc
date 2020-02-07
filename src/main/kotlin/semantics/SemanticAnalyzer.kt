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
import ast.Type.Companion.anyArrayType
import ast.Type.Companion.anyPairType
import ast.Type.Companion.anyoutArrayType
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
    private var containsError = false
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
        containsError = true
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
        functions.map {
            treeStack.push(it)
            try {
                symbolTable.defineFunc(it.name,
                        Type.FuncType(it.returnType, it.args.map { a -> a.first }),
                        it.startIndex)
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
        when (this@check) {
            Skip -> Skip
            is Declaration -> {
                val prevAttr = symbolTable.defineVar(type, variable)
                if (prevAttr != null) {
                    logError(listOf(variableAlreadyDefined(variable, type, symbolTable.lookupVar(variable.name)!!.index)))
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
            is CondBranch -> {
                expr.check(match(boolType()))
                trueBranch.checkBlock(retCheck)
                falseBranch.checkBlock(retCheck)
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
                val attr = symbolTable.lookupVar(name)
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
                    containsError = false
                    expr.check(matchPairByElem(func, tc))
                    if (!containsError) {
                        try {
                            result = expr.getType(symbolTable).unwrapPairType(func)
                        } catch (sme: SemanticException) {
                            logAction(listOf(sme.msg))
                        }
                    }
                }
            }
            is ArrayElem -> {
                symbolTable.lookupVar(arrIdent.name)?.let { attr ->
                    this.arrIdent.scopeId = attr.scopeId
                    attr.type.unwrapArrayType(indices.count())?.let { actual ->
                        val errors = tc.test(actual)
                        if (errors.isNotEmpty()) {
                            logAction(errors)
                        } else {
                            containsError = false
                            indices.map { it.check(match(intType())) }
                            if (!containsError) {
                                val tcErrors = tc.test(actual)
                                if (tcErrors.isEmpty()) {
                                    result = actual
                                }
                                logAction(tcErrors)
                            }
                        }
                    } ?: logAction(listOf(insufficientArrayRankError(arrIdent.name, attr.type, indices.count())))
                } ?: logAction(listOf(accessToUndefinedVar(arrIdent.name)))
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
            is Identifier, is PairElem, is ArrayElem -> checkLhs(tc, false, logAction)
            is BinExpr -> {
                when (op) {
                    EQ, NEQ -> {
                        logAction(tc.test(boolType()))
                        try {
                            left.check(match(right.getType(symbolTable)))
                        } catch (sme: SemanticException) {
                            logAction(listOf(sme.msg))
                        }
                    }
                    else -> {
                        val errors = arrayListOf<List<String>>()
                        for (entry in BinaryOperator.typeMap.getValue(op)) {
                            val retChecker = tc.forwardsError("Unexpected return type for binary operator '${op.op}' ")
                            val temp = mutableListOf<String>()
                            temp += retChecker.test(entry.retType)
                            left.check(entry.lhsChecker) {
                                temp += it.map { err ->
                                    "$err\n${left.getTraceLog()}\n" +
                                            "    on the left-hand-side of '${op.op}'"
                                }
                            }
                            if (temp.isEmpty()) {
                                right.check(entry.rhsChecker) {
                                    temp += it.map { err ->
                                        "$err\n${right.getTraceLog()}" +
                                                "\n    on the right-hand-side of '${op.op}'"
                                    }
                                }
                            }
                            errors += temp
                            if (temp.isEmpty()) {
                                break
                            }
                        }
                        if (!errors.any(List<String>::isEmpty)) {
                            logAction(errors.minBy { it.size }!!)
                        }
                    }
                }
            }
            is ArrayLiteral -> {
                if (elements.isEmpty()) {
                    logAction(tc.test(anyoutArrayType()))
                } else {
                    for (element in elements) {
                        val temp: MutableList<String> = mutableListOf()
                        element.check(unwrapArray(tc)) { temp += it }
                        if (temp.isNotEmpty()) {
                            logAction(temp)
                            break
                        }
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

}

