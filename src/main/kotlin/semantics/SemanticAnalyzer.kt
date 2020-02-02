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
import semantics.LhsTypeCheckResult.Failure
import semantics.LhsTypeCheckResult.Success
import semantics.TypeChecker.Companion.match
import semantics.TypeChecker.Companion.matchPairByElem
import semantics.TypeChecker.Companion.pass
import semantics.TypeChecker.Companion.unwrapArray
import semantics.TypeChecker.Companion.unwrapPair
import utils.AstIndexMap
import utils.SymbolTable
import java.util.*

class SemanticAnalyzer(val astIndexMap: AstIndexMap) {

    val symbolTable = SymbolTable()
    val treeStack: Deque<WaccAST> = ArrayDeque()
    val errorLog: MutableList<String> = arrayListOf()
    var isInMain = false
    var containsError = false

    fun doCheck(ast: ProgramAST) {
        ast.check()
        if (errorLog.isNotEmpty()) {
            throw PureSemanticException(errorLog.joinToString("\n======\n"))
        }
    }

    private fun logError(causes: List<String>) {
        if (causes.isNotEmpty()) {
            logError(causes.joinToString("\n"))
        }
    }

    private fun logError(cause: String) {
        val log = cause + treeStack.joinToString("\n") { it.getTraceLog(astIndexMap) }
        errorLog += log
        containsError = true
    }

    private fun ProgramAST.check() {
        functions.map { symbolTable.defineFunc(
                        it.name,
                        Type.FuncType(it.returnType, it.args.map { a -> a.second }),
                        astIndexMap.getValue(it))
        }
        functions.map { it.checkFunc(match(it.returnType)) }
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
                    logError("Variable \"$variable\" with type $type " +
                            "has already been defined at ${astIndexMap[this]}!")
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
                val readChecker = match(intType())`||` match(charType()) `||` match(stringType())
                lhsType?.let { readChecker.test(it) }
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

    private fun Expression.checkLhs(tc: TypeChecker = pass()): Type? {
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
                        logError(errors)
                    }
                } else {
                    logError("Attempt to access an undefined variable '$ident'!")
                }
            }
            is PairElem -> {
                containsError = false
                expr.check(matchPairByElem(func, tc))
                if (containsError) {
                    result = expr.getType(symbolTable).unwrapPairType(func)
                }
            }
            is ArrayElem -> {
                val entry = symbolTable.lookupVar(arrayName)
                if (entry != null) {
                    val actual = entry.type.unwrapArrayType(indices.count())
                    if (actual != null) {
                        val errors = tc.test(actual)
                        if (errors.isEmpty()) {
                            result = actual
                        } else {
                            logError(errors)
                        }
                    } else {
                        logError("${entry.type} does not have more than ${indices.count()} rank")
                    }
                } else {
                    logError("Attempt to access an undefined variable '$arrayName'!")
                }
            }
            else -> logError("Some error")
        }
        treeStack.pop()
        return result
    }

    private fun Expression.check(tc: TypeChecker) {
        treeStack.push(this)
        when(this) {
            is NullLit -> logError(tc.test(nullType()))
            is IntLit -> logError(tc.test(intType()))
            is BoolLit -> logError(tc.test(boolType()))
            is CharLit -> logError(tc.test(charType()))
            is StringLit -> logError(tc.test(stringType()))
            is Identifier -> {
                val actual = symbolTable.lookupVar(ident)?.type
                if (actual != null) {
                    logError(tc.test(actual))
                } else {
                    logError("Attempt to access an undefined variable '$ident'!")
                }
            }
            is BinExpr -> {
                when (op) {
                    EQ, NEQ -> {
                        val pred = tc.test(boolType())
                        if (pred.isEmpty()) {
                            logError(pred)
                        } else {
                            left.check(match(right.getType(symbolTable)))
                        }
                    }
                    else -> {
                        for (entry in BinaryOperator.typeMap.getValue(op)) {
                            val retChecker = tc.forwardsError("Unexpected return type for binary operator: \"${op.op}\" ")
                            val err = retChecker.test(entry.retType)
                            logError(err)
                            if (err.isEmpty()) {
                                left.check(entry.lhsChecker)
                                right.check(entry.rhsChecker)
                            }
                        }
                    }
                }
//                when (op) {
//                    EQ, NEQ -> tc.test(boolType()).ifEmptyJust(listOf(
//                            left.check(match(right.getType(symbolTable)))
//                    ).ifNotEmptyDo { listOf(SemanticExceptionBundle(it.flatten())) })
//                    else -> {
//                        val allCases = BinaryOperator.typeMap.getValue(op).map { entry ->
//                            val returnChecker = tc.forwardsError("Unexpected return type for binary operator: \"${op.op}\" ")
//                            returnChecker.test(entry.retType)
//                                    .ifEmptyJust(left.check(entry.lhsChecker)
//                                            .ifEmptyJust(right.check(entry.rhsChecker)))
//                        }
//                        allCases.ifNotEmptyDo { listOf(SemanticExceptionBundle(it.flatten())) }
//                    }
//                }
            }
            is ArrayElem -> {
                val entry = symbolTable.lookupVar(arrayName)
                if (entry != null) {
                    val newtype = entry.type.unwrapArrayType(indices.count())
                    if (newtype != null) {
                        tc.test(newtype)
                    } else {
                        logError("${entry.type} does not have more than ${indices.count()} rank")
                    }
                } else {
                    listOf("Attempt to access an undefined variable '$arrayName'!")
                }

//                symbolTable.lookupVar(arrayName)
//                        ?.let { entry -> entry.type.unwrapArrayType(indices.count())
//                                ?.let { newtype -> tc.check(newtype) }
//                                ?:listOf(InsufficientArrayRankException(entry.type, indices.count())) }
//                        ?: listOf(UndefinedVarException(arrayName))
            }
            is PairElem -> {
                if (expr == NullLit) {
                    logError("Cannot access the $func element of a null-literal!")
                } else {
                    expr.check(matchPairByElem(func, tc))
                }
            }
            is ArrayLiteral -> {
                if (elements.isEmpty()) {
                    logError(tc.test(anyoutArrayType()))
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
                    logError("\"Attempt to access an undefined function '$ident'!\"")
                } else {
                    val funcType = funcEntry.type
                    val retType = funcType.retType
                    val expectedCount = args.size
                    val actualCount = funcType.paramTypes.size
                    if (expectedCount != actualCount) {
                        logError("A call to function $ident : $funcType needs $expectedCount parameters, " +
                                "but only $actualCount parameters has been provided")
                    } else {
                        tc.test(retType) + args.zip(funcType.paramTypes) { arg, t -> arg.check(match(t))}
                    }
                }
            }
        }
        treeStack.pop()
    }

}

