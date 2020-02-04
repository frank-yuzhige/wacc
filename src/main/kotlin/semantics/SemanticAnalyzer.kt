package semantics

import ast.*
import ast.BinaryOperator.EQ
import ast.BinaryOperator.NEQ
import ast.Expression.*
import ast.Expression.PairElemFunction.FST
import ast.Expression.PairElemFunction.SND
import ast.Function
import ast.Statement.BuiltinFunc.*
import ast.Statement.Declaration
import ast.Type.Companion.anyArrayType
import ast.Type.Companion.anyoutArrayType
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.anyPairType
import ast.Type.Companion.nullType
import ast.Type.Companion.stringType
import exceptions.SemanticException
import exceptions.SemanticException.*
import semantics.TypeChecker.Companion.match
import semantics.TypeChecker.Companion.matchPairByElem
import semantics.TypeChecker.Companion.pass
import semantics.TypeChecker.Companion.unwrapArray
import semantics.TypeChecker.Companion.unwrapPair
import utils.AstIndexMap
import utils.Statements
import utils.SymbolTable
import java.util.*

class SemanticAnalyzer(private val astIndexMap: AstIndexMap) {

    private val symbolTable = SymbolTable()
    private val treeStack: Deque<WaccAST> = ArrayDeque()
    private val errorLog: MutableList<String> = arrayListOf()
    private var isInMain = false
    private var containsError = false

    fun doCheck(ast: ProgramAST) {
        ast.check()
        if (errorLog.isNotEmpty()) {
            throw PureSemanticException(errorLog.joinToString("\n\n\n"))
        }
    }

    private fun logError(causes: List<String>) {
        if (causes.isNotEmpty()) {
            logError(causes.joinToString("\n"))
        }
    }

    private fun logError(cause: String) {
        val log = cause + "\n" + treeStack.joinToString("\n") { it.getTraceLog(astIndexMap) }
        val inMain = if (isInMain) {"\nIn the main program"} else {""}
        errorLog += log + inMain
        containsError = true
    }

    private fun ProgramAST.check() {
        functions.map { symbolTable.defineFunc(
                        it.name,
                        Type.FuncType(it.returnType, it.args.map { a -> a.second }),
                        astIndexMap.getValue(it))
        }
        functions.map { it.checkFunc(match(it.returnType)) }
        isInMain = true
        mainProgram.checkBlock()
    }

    private fun Function.checkFunc(retCheck: TypeChecker) {
        treeStack.push(this)
        symbolTable.pushScope()
        args.map { param ->
            symbolTable.defineVar(param.first, param.second, astIndexMap.getValue(this))
        }
        this.body.map { it.check(retCheck) }
        symbolTable.popScope()
        treeStack.pop()
    }

    private fun Statements.checkBlock(retCheck: TypeChecker = pass()) {
        symbolTable.pushScope()
        this.map { it.check(retCheck) }
        symbolTable.popScope()
    }

    private fun Statement.check(retCheck: TypeChecker) {
        treeStack.push(this)
        when(this@check) {
            Statement.Skip -> Statement.Skip
            is Declaration -> {
                val prevAttr
                        = symbolTable.defineVar(variable.ident, type, astIndexMap.getValue(this))
                if (prevAttr != null) {
                    logError(listOf(variableAlreadyDefined(variable, type, symbolTable.lookupVar(variable.ident)!!.index)))
                } else {
                    rhs.check(match(type))
                }
            }
            is Statement.Assignment -> {
                val lhsType = lhs.checkLhs()
                lhsType?.let { rhs.check(match(it)) }
            }
            is Statement.Read -> {
                val lhsType =  target.checkLhs()
                val readChecker = match(intType()) `||` match(charType()) `||` match(stringType())
                lhsType?.let { logError(readChecker.test(it)) }
            }
            is Statement.BuiltinFuncCall -> when (func) {
                PRINT, PRINTLN -> expr.check(pass())
                FREE -> expr.check(match(anyArrayType()) `||` match(anyPairType()))
                EXIT -> expr.check(match(intType()))
                RETURN -> expr.check(retCheck)
            }
            is Statement.CondBranch -> {
                expr.check(match(boolType()))
                trueBranch.checkBlock(retCheck)
                falseBranch.checkBlock(retCheck)
            }
            is Statement.WhileLoop ->  {
                expr.check(match(boolType()))
                body.checkBlock(retCheck)
            }
            is Statement.Block -> body.checkBlock(retCheck)
        }
        treeStack.pop()
    }

    private fun Expression.checkLhs(tc: TypeChecker = pass(),
                                    logAction: (List<String>) -> Unit = { logError(it) }): Type? {
        var result: Type? = null
        treeStack.push(this)
        when(this) {
            is Identifier -> {
                val actual = symbolTable.lookupVar(ident)?.type
                if (actual != null) {
                    val errors = tc.test(actual)
                    if (errors.isEmpty()) {
                        result = actual
                    } else {
                        logAction(errors)
                    }
                } else {
                    logAction(listOf(accessToUndefinedVar(ident)))
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
                symbolTable.lookupVar(arrayName)?.let { entry ->
                    entry.type.unwrapArrayType(indices.count())?.let { actual ->
                        val errors = tc.test(actual)
                        if (errors.isEmpty()) {
                            containsError = false
                            indices.map { it.check(match(intType())) }
                            if (!containsError) {
                                val tcErrors = tc.test(actual)
                                if (tcErrors.isEmpty()) {
                                    result = actual
                                }
                                logAction(tcErrors)
                            }
                        } else {
                            logAction(errors)
                        }
                    }?: logAction(listOf(insufficientArrayRankError(entry.type, indices.count())))
                }?: logAction(listOf(accessToUndefinedVar(arrayName)))
            }
            else -> logAction(listOf("Not a proper assign-lhs statement!")) // Should never reach here...
        }
        treeStack.pop()
        return result
    }

    private fun Expression.check(tc: TypeChecker,
                                 logAction: (List<String>) -> Unit = { logError(it) }) {
        treeStack.push(this)
        when(this) {
            is NullLit -> logAction(tc.test(nullType()))
            is IntLit -> logAction(tc.test(intType()))
            is BoolLit -> logAction(tc.test(boolType()))
            is CharLit -> logAction(tc.test(charType()))
            is StringLit -> logAction(tc.test(stringType()))
            is Identifier, is PairElem, is ArrayElem -> checkLhs(tc, logAction)
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
                            val retChecker =
                                    tc.forwardsError("Unexpected return type for binary operator: \"${op.op}\" ")
                            val temp = mutableListOf<String>()
                            temp += retChecker.test(entry.retType)
                            left.check(entry.lhsChecker) { temp += it.map { err ->
                                "$err\n${left.getTraceLog(astIndexMap)}\n" +
                                        "    on the left-hand-side of \"${op.op}\"" } }
                            if (temp.isEmpty()) {
                                right.check(entry.rhsChecker) { temp += it.map { err ->
                                    "$err\n${right.getTraceLog(astIndexMap)}" +
                                            "\n    on the right-hand-side of \"${op.op}\"" } }
                            }
                            errors += temp
                            if (temp.isEmpty()) {
                                break
                            }
                        }
                        if (!errors.any(List<String>::isEmpty)) {
                            logAction(errors.flatten())
                        }
                    }
                }
            }
            is ArrayLiteral -> {
                if (elements.isEmpty()) {
                    logAction(tc.test(anyoutArrayType()))
                } else {
                    elements.map { it.check(unwrapArray(tc)) }
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
                    val expectedCount = args.size
                    val actualCount = funcType.paramTypes.size
                    if (expectedCount != actualCount) {
                        logAction(listOf(parameterNumMismatch(ident, funcType, expectedCount, actualCount)))
                    } else {
                        logAction(tc.test(retType))
                        args.zip(funcType.paramTypes) { arg, t -> arg.check(match(t))}
                    }
                }
            }
        }
        treeStack.pop()
    }

}

