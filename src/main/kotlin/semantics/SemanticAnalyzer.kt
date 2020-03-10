package semantics

import ast.*
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
import ast.Type.Companion.arrLitConstructorType
import ast.Type.Companion.arrayTypeOf
import ast.Type.Companion.boolType
import ast.Type.Companion.charType
import ast.Type.Companion.intType
import ast.Type.Companion.newPairConstructorType
import ast.Type.Companion.stringType
import ast.Type.TypeVar.Companion.newTypeVar
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

    private fun Statements.checkBlock(
            returnType: Type = anyType(),
            typeconstraints: List<TypeConstraint> = emptyList(),
            preDefinitons: () -> Unit = {}
    ) {
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
                            val duplicates = pattern.matchVars.countDuplicates()
                            if (duplicates.isNotEmpty()) {
                                throw MultipleVarDefInPatternException(duplicates.keys.map { it.name })
                            }
                            stmts.checkBlock(returnType, typeconstraints) {
                                pattern.matchVars.withIndex().forEach { (i, match) ->
                                    symbolTable.defineVar(realFuncType.paramTypes[i], match, isConst = true)
                                    match.reifiedType = realFuncType.paramTypes[i]
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
                    arrIdent.reifiedType = arrAttribute.type
                    val type = arrAttribute.type.unwrapArrayType(indices.size)
                            ?: throw NotEnoughArrayRankException(arrIdent.name)
                    indices.map { it.checkExpr(intType()) }
                    type inferFrom expecting
                }
                is PairElem -> {
                    val exprType = expr.checkExpr(anyPairType())
                    if (exprType !is NewType) throw TypeMismatchException(anyPairType(), exprType)
                    val memberType = when(func) {
                        FST -> exprType.generics[0]
                        SND -> exprType.generics[1]
                    }
                    memberType inferFrom expecting
                }
                is TypeMember -> {
                    val exprType = expr.checkExpr(anyType())
                    if (exprType !is NewType && exprType !is ErrorType) throw NotAStructTypeException(exprType)
                    val memberType = symbolTable.getTypeMemberType(exprType, memberName)
                    memberType inferFrom expecting
                }
                else -> TODO()
            }
        } catch (sme: SemanticException) {
            logAction(listOf(sme.msg))
            ErrorType
        } finally {
            if (isPush) {
                treeStack.pop()
            }
        }
        this.reifiedType = inferredType
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
                    val funcType = BinaryOperator.funcTypeMap.getValue(op)
                    unifyFuncType(expecting, funcType, listOf(left, right), logAction)
                }
                is UnaryExpr -> {
                    val funcType = UnaryOperator.funcTypeMap.getValue(op)
                    unifyFuncType(expecting, funcType, listOf(expr), logAction)
                }
                is ArrayLiteral -> when {
                    elements.isEmpty() -> anyArrayType() inferFrom expecting
                    else -> {
                        unifyFuncType(expecting, arrLitConstructorType(elements.size), elements, logAction)
                    }
                }
                is NewPair -> {
                    unifyFuncType(expecting, newPairConstructorType(), listOf(first, second), logAction)
                }
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
                    if (args.size != funcType.paramTypes.size) {
                        throw FuncCallArgsMismatchException(ident, funcType.paramTypes.size, args.size)
                    }
                    unifyFuncType(expecting, funcType, args, logAction)
                }
            }
        } catch (sme: SemanticException) {
            logAction(listOf(sme.msg))
            System.err.println("$$> logging: ${sme.msg}")
            ErrorType
        }
        reifiedType = inferredType
        System.err.println("*** finish: ${this.prettyPrint()} is $inferredType ***")
        if (!inferredType.isDetermined()) {
            logAction(listOf(UngroundTypeException(inferredType).msg))
        }
        treeStack.pop()
        return inferredType
    }

    /* Unifies the given function type, by the expected return type, and the arguments provided.
    *  This method calls checkExpr on all arguments, then unifies the given func type by types of args.
    *  Returns the actual return type */
    private fun unifyFuncType(expecting: Type,
                              funcType: FuncType,
                              args: List<Expression>,
                              logAction: (List<String>) -> Unit): Type {
        val newFuncType = funcType unifyReturn expecting
        val argsGrounds = args.zip(newFuncType.paramTypes) { arg, type -> arg.checkExpr(type, logAction) }
        val sub: Grounding = FuncType(newFuncType.retType, argsGrounds).findUnifier(newFuncType)
        return newFuncType.retType.substitutes(sub)
    }

    private infix fun FuncType.unifyReturn(expecting: Type): FuncType {
        val newRet = retType inferFrom expecting
        val sub = newRet.findUnifier(retType)
        return (this.substitutes(sub) as FuncType)
    }

    private infix fun Type.inferFrom(expecting: Type): Type = this.inferFrom(expecting, symbolTable)

    private fun Type.validated(): Type = if(this is NewType) {
        symbolTable.lookupType(this)?.let{ this }?: throw UndefinedTypeException(this.name)
    } else {
        this
    }

}

