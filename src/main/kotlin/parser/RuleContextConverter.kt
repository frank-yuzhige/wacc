package parser

import antlr.WaccParser.*
import ast.*
import ast.Expression.*
import ast.Function
import ast.NewTypeDef.*
import ast.Statement.*
import ast.Type.*
import ast.Type.BaseTypeKind.ANY
import ast.Type.Companion.anyPairType
import ast.Type.Companion.anyType
import exceptions.SemanticException.ReturnInMainProgramException
import exceptions.SyntacticException
import exceptions.SyntacticException.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.Interval
import utils.EscapeCharConverter
import utils.Index
import utils.Parameter
import utils.Statements
import java.util.*

class RuleContextConverter() {
    private val stack: Deque<ParserRuleContext> = ArrayDeque()
    private var errorList: MutableList<SyntacticException> = mutableListOf()

    fun convertProgram(program: ProgContext): ProgramAST = program.toAST()
    fun convertFunction(function: FuncContext): Function = function.toAST()
    fun convertStatement(statement: StatContext): Statement = statement.toAST()
    fun convertExpression(expression: ExprContext): Expression = expression.toAST()

    /** ParserRuleContext Extension methods **/

    fun ProgContext.toAST(): ProgramAST {
        stack.push(this)
        val programAST = ProgramAST(
                newtype()?.map { it.toAST() }?: emptyList(),
                traitDef()?.map { it.toAST() } ?: emptyList(),
                traitInstance()?.map { it.toAST() } ?: emptyList(),
                func()?.map { it.toAST() }?: emptyList(),
                stats()?.toMainProgramAST()
                        ?: throw SyntacticExceptionBundle(listOf(EmptyMainProgramException()))
        ).records(start(), end())
        stack.pop()
        return programAST
    }

    private fun StatsContext.toMainProgramAST(): List<Statement> {
        val returnIndices = containsReturn(this)
        if (returnIndices.isNotEmpty()) {
            throw ReturnInMainProgramException(returnIndices)
        }
        val result = this.toAST()
        /** IF ERROR LIST IS NOT EMPTY, THROW ERROR INSTEAD OF RETURN **/
        if (errorList.isNotEmpty()) {
            throw SyntacticExceptionBundle(errorList)
        }
        return result
    }

    private fun StatsContext.toFuncBodyAST(typeVars: Set<String> = emptySet()): Statements {
        fun StatContext.isTerminator(): Boolean = when (this) {
            is BuiltinFuncCallContext ->
                this.builtinFunc().EXIT() != null || this.builtinFunc().RETURN() != null
            is CondBranchContext ->
                this.stats().all { it.stat().last()?.isTerminator() ?: false }
            is WhenClauseContext ->
                this.whenCase().all { it.stats().stat().last()?.isTerminator() ?: false }
            else -> false
        }

        if (!this.stat().last().isTerminator()) {
            logError(LastStatIsNotTerminatorException())
        }
        return this.toAST(typeVars)
    }

    private fun TraitDefContext.toAST(): TraitDef {
        stack.push(this)
        val dependentConstraints = constraintList()?.collectConstraints()?: emptyList()
        val typeVars = constraintList()?.collectTypeVars() ?: mutableSetOf()
        typeVars += tvar.text
        val defaultConstraint = TypeConstraint(Trait(trait.text), tvar.text)
        val totalConstraints = dependentConstraints + defaultConstraint
        val result = TraitDef(
                trait.text,
                dependentConstraints,
                tvar.text,
                requiredFunc()?.map { it.toAST(totalConstraints, typeVars) }?: emptyList(),
                func()?.map { it.toAST(totalConstraints, typeVars) }?: emptyList()
        ).records(start(), end())
        stack.pop()
        return result
    }

    private fun TraitInstanceContext.toAST(): TraitInstance {
        stack.push(this)
        val topConstraints = constraintList()?.collectConstraints() ?: emptyList()
        val typeVars = constraintList()?.collectTypeVars() ?: mutableSetOf()
        val thisTrait = Trait(trait.text)
        val thisType = type().toAST(typeVars)
        val result = TraitInstance(
                thisType,
                thisTrait,
                topConstraints,
                func().map { it.toAST(topConstraints, typeVars) }
        ).records(start(), end())
        stack.pop()
        return result
    }

    fun FuncContext.toAST(defaultConstraint: List<TypeConstraint> = emptyList(),
                          defaultTypeVars: Set<String> = emptySet()): Function {
        stack.push(this)
        val constraints = (constraintList()?.collectConstraints()?: emptyList()) + defaultConstraint
        val typeVars: MutableSet<String> = constraintList()?.collectTypeVars()?: mutableSetOf()
        // TODO: dup check and error
        typeVars += defaultConstraint.map { it.typeVar }
        typeVars += defaultTypeVars
        val args = paramList()
                ?.toAST(typeVars)
                ?.map { (type, arg) -> type.bindConstraints(constraints) to arg }
                ?: emptyList()
        val result = Function(
                type().toAST(typeVars).bindConstraints(constraints),
                ident().text,
                args,
                constraints,
                stats().toFuncBodyAST(typeVars)
        ).records(start(), end())
        stack.pop()
        return result
    }

    private fun ConstraintListContext.collectConstraints(): List<TypeConstraint> {
        val constraintContexts = constraint()?: emptyList()
        val constraints = constraintContexts.map { it.toAST() }
        return constraints
    }

    private fun ConstraintListContext.collectTypeVars(): MutableSet<String> {
        val set = mutableSetOf<String>()
        val foralls = forallConstraint() ?: emptyList()
        val constraints = constraint() ?: emptyList()
        set += foralls.map { it.capIdent().text }
        set += constraints.map { it.capIdent(0).text }
        // TODO: duplication check and err
        return set
    }

    private fun ConstraintContext.toAST(): TypeConstraint {
        return TypeConstraint(Trait(capIdent(1).text), capIdent(0).text)
    }

    private fun RequiredFuncContext.toAST(defaultConstraints: List<TypeConstraint>,
                                          defaultTypeVars: Set<String>): FunctionHeader {
        stack.push(this)
        val constraints = (constraintList()?.collectConstraints()?: emptyList()) + defaultConstraints
        val typeVars = constraintList()?.collectTypeVars()?: mutableSetOf()
        typeVars += defaultTypeVars
        val args = paramList()
                ?.toAST(typeVars)
                ?.map { (type, arg) -> type.bindConstraints(constraints) to arg }
                ?: emptyList()
        val result = FunctionHeader(
                type().toAST(typeVars).bindConstraints(constraints),
                ident().text,
                args,
                constraints
        ).records(start(), end())
        stack.pop()
        return result
    }

    private fun ParserRuleContext.originalText(): String {
        val start = this.start.startIndex
        val stop = this.stop.stopIndex
        val input = this.start.inputStream
        return if (start < stop) {
            input.getText(Interval(start, stop))
        } else {
            "**NOT AVAILABLE**"
        }
    }

    /** Types **/

    private fun TypeContext.toAST(typeVars: Set<String> = emptySet()): Type = when {
        baseType() != null -> baseType().toAST()
        arrayType() != null -> arrayType().toAST()
        pairType() != null -> pairType().toAST()
        capIdent() != null -> {
            val str = capIdent().text
            if (capIdent().text in typeVars) {
                TypeVar(capIdent().text, emptyList(), false) // add traits later
            } else {
                NewType(capIdent().text, generics()?.toAST(typeVars)?: emptyList())
            }
        }
        else -> throw IllegalArgumentException("Unrecognized type: $text")
    }

    private fun GenericsContext.toAST(typeVars: Set<String>): List<Type> = type().map { it.toAST(typeVars) }

    private fun BaseTypeContext.toAST(): BaseType = when (text) {
        "int" -> BaseType(BaseTypeKind.INT)
        "char" -> BaseType(BaseTypeKind.CHAR)
        "bool" -> BaseType(BaseTypeKind.BOOL)
        "string" -> BaseType(BaseTypeKind.STRING)
        else -> throw IllegalArgumentException("Unknown base type: $text")
    }

    private fun ArrayTypeContext.toAST(): ArrayType {
        val dimension = LBRA().size
        var tau = ArrayType(when {
            baseType() != null -> baseType().toAST()
            pairType() != null -> pairType().toAST()
            else -> {
                logError(UnsupportedArrayBaseTypeException(this.text))
                BaseType(ANY)
            }
        })
        for (i in 1 until dimension) {
            tau = ArrayType(tau)
        }
        return tau
    }

    private fun PairTypeContext.toAST(): PairType {
        fun pairElemTypeToAST(context: PairElemTypeContext): Type = when {
            context.baseType() != null -> context.baseType().toAST()
            context.arrayType() != null -> context.arrayType().toAST()
            else -> anyPairType()
        }
        return PairType(pairElemTypeToAST(first), pairElemTypeToAST(second))
    }

    private fun NewtypeContext.toAST(): NewTypeDef {
        return when {
            structType() != null -> structType().toAST()
            taggedUnion() != null -> taggedUnion().toAST()
            else -> throw IllegalArgumentException("Unknown new type def")
        }
    }

    private fun TaggedUnionContext.toAST(): NewTypeDef {
        return if (unionEntry() == null || unionEntry().isEmpty()) {
            UnionTypeDef(this.capIdent().text)
        } else {
            val typeVars = this.genericTVars().toAST()
            UnionTypeDef(
                    this.capIdent().text,
                    typeVars,
                    this.unionEntry().map { it.toAST(typeVars.toSet()) }.toMap()
            ).records(start(), end())
        }
    }

    private fun GenericTVarsContext.toAST(): List<String> = this.capIdent().map { it.text }
            .also { if (it.toHashSet().size < it.size) logError(MultipleTVarsWithSameNameException()) }

    private fun UnionEntryContext.toAST(typeVars: Set<String>): Pair<String, List<Parameter>> {
        return capIdent().text to member().map { it.toAST(typeVars) }
    }

    private fun StructTypeContext.toAST(): NewTypeDef {
        val typeVars = this.genericTVars()?.toAST()?: emptyList()
        return StructTypeDef(
                capIdent().text,
                typeVars,
                member().map { it.toAST(typeVars.toSet()) }
        ).records(start(), end())
    }

    private fun MemberContext.toAST(typeVars: Set<String>): Parameter {
        return type().toAST(typeVars) to ident().toAST()
    }

    /** Statements **/

    private fun ParamListContext.toAST(typeVars: Set<String> = emptySet()): List<Parameter>
            = param().map { it.toAST(typeVars) }

    private fun ParamContext.toAST(typeVars: Set<String>): Parameter = type().toAST(typeVars) to ident().toAST()

    private fun StatsContext.toAST(typeVars: Set<String> = emptySet()): Statements {
        return stat().map { it.toAST(typeVars) }
    }

    private fun StatContext.toAST(typeVars: Set<String> = emptySet()): Statement {
        stack.push(this)
        val result = when (this) {
            is SkipContext -> Skip
            is DeclarationContext ->
                Declaration(false, type()?.toAST(typeVars)?:BaseType(ANY), ident().toAST(), assignRhs().toAST())
            is ConstDeclarationContext ->
                Declaration(true, type()?.toAST(typeVars)?:BaseType(ANY), ident().toAST(), assignRhs().toAST())
            is AssignmentContext -> Assignment(assignLhs().toAST(), assignRhs().toAST())
            is ReadCallContext -> Read(assignLhs().toAST())
            is BuiltinFuncCallContext ->
                BuiltinFuncCall(BuiltinFunc.valueOf(builtinFunc().text.toUpperCase()), expr().toAST())
            is CondBranchContext -> {
                if (ELSE() == null) {
                    IfThen(expr(0).toAST(), stats(0).toAST())
                } else {
                    val list = expr().zip(stats()) { expr, stats -> expr.toAST() to stats.toAST() }
                    CondBranch(list, stats().last().toAST())
                }
            }
            is ForLoopContext -> {
                val defType = if (type() == null && VAR() == null) {
                    null
                } else {
                    type()?.toAST(typeVars)?: anyType()
                }
                ForLoop(defType, ident().toAST(), enumRange().toAST(), stats().toAST())
            }
            is WhileLoopContext -> WhileLoop(expr().toAST(), stats().toAST())
            is WhenClauseContext -> WhenClause(expr().toAST(), whenCase()?.map { it.toAST() }?: emptyList())
            is BlockContext -> Block(stats().toAST())
            else -> throw IllegalArgumentException("Invalid statement found: ${originalText()}")
        }.records(start(), end())
        stack.pop()
        return result
    }

    private fun AssignLhsContext.toAST(): Expression = when {
        ident() != null -> ident().toAST()
        arrayElem() != null -> arrayElem().toAST()
        pairElem() != null -> pairElem().toAST()
        typeMember() != null -> typeMember().toAST()
        else -> throw IllegalArgumentException("Unknown left value")
    }.records(start(), end())

    private fun AssignRhsContext.toAST(): Expression = when (this) {
        is RhsExprContext -> expr().toAST()
        is RhsArrayLiterContext -> arrayLiter().toAST()
        is RhsPairElemContext -> pairElem().toAST()
        is RhsTypeMemberContext -> typeMember().toAST()
        is RhsNewPairContext -> NewPair(expr(0).toAST(), expr(1).toAST())
        is RhsFuncCallContext -> FunctionCall(ident().text, argList()?.toAST() ?: listOf())
        else -> throw IllegalArgumentException("Unknown right value")
    }.records(start(), end())


    fun ExprContext.toAST(): Expression {
        stack.push(this)
        val result = when (this) {
            is ExprNullContext -> NullLit
            is ExprIntContext -> integer().toAST()
            is ExprBoolContext -> BoolLit(boolLit().TRUE() != null)
            is ExprCharContext -> CharLit(EscapeCharConverter(getContent(CHARLIT().text)).getChar())
            is ExprStringContext -> StringLit(EscapeCharConverter(getContent(STRLIT().text)).getAll())
            is ExprIdentContext -> Identifier(ident().text)
            is ExprParensContext -> expr().toAST().markParens()
            is ExprUnaryopContext -> UnaryExpr(UnaryOperator.read(unaryOp().text), expr().toAST())
            is ExprBinopContext -> BinExpr(left.toAST(), getBinOp(), right.toAST())
            is ExprArrElemContext -> ArrayElem(arrayElem().ident().toAST(), arrayElem().expr().map { it.toAST() })
            is ExprIfContext -> IfExpr(listOf(cond.toAST() to tr.toAST()), fl.toAST())
            is ExprFuncCallContext -> FunctionCall(ident().text, argList()?.toAST() ?: listOf())
            is ExprTypeConstructorContext -> typeConstructor().toAST()
            is ExprVarMemberContext -> TypeMember(v.toAST(), m.text)
            else -> {
                logError(UnknownExprTypeException())
                NullLit
            }
        }.records(start(), end())
        stack.pop()
        return result
    }

    private fun ArgListContext.toAST(): List<Expression> = expr().map { it.toAST() }

    private fun ArrayLiterContext.toAST(): Expression = ArrayLiteral(argList()?.toAST() ?: arrayListOf())

    private fun PairElemContext.toAST(): Expression =
            PairElem(PairElemFunction.valueOf(pairElemFunc().text.toUpperCase()), expr().toAST())

    private fun TypeMemberContext.toAST(): Expression = TypeMember(expr().toAST(), ident().text)

    private fun TypeConstructorContext.toAST(): Expression = FunctionCall(capIdent().text, argList()?.toAST()?: emptyList())

    private fun ArrayElemContext.toAST(): Expression =
            ArrayElem(ident().toAST(), expr().map { it.toAST() })

    private fun IdentContext.toAST(): Identifier = Identifier(IDENT().text).records(start(), end())

    private fun IntegerContext.toAST(): Expression = try {
        IntLit(this.text.toInt())
    } catch (e: NumberFormatException) {
        logError(IntegerSyntacticException(this.text))
        NullLit
    }

    private fun EnumRangeContext.toAST(): EnumRange = when(this) {
        is RangeFromToContext -> EnumRange(from.toAST(), to.toAST())
        is RangeFromThenToContext -> EnumRange(from.toAST(), then.toAST(), to.toAST())
        else -> throw IllegalArgumentException("Unknown enum type")
    }

    private fun ExprBinopContext.getBinOp(): BinaryOperator {
        val opContext = listOfNotNull(binop1(), binop2(), binop3(), binop4(), binop5(), binop6())[0]
        return BinaryOperator.read(opContext.text)
    }

    private fun WhenCaseContext.toAST(): Pair<Pattern, Statements> = pattern().toAST() to stats().toAST()

    private fun PatternContext.toAST(): Pattern = Pattern(capIdent().text, ident().map { it.toAST() }).records(start(), end())

    private fun containsReturn(context: StatsContext): List<Index> = context.stat().flatMap {
        when (it) {
            is BuiltinFuncCallContext -> if (it.builtinFunc().RETURN() != null) {
                listOf(it.start())
            } else {
                emptyList()
            }
            is CondBranchContext -> it.stats().flatMap(::containsReturn)
            is WhileLoopContext -> containsReturn(it.stats())
            is BlockContext -> containsReturn(it.stats())
            else -> emptyList()
        }
    }

    private fun getContent(quotedString: CharSequence): CharSequence {
        val len = quotedString.length
        return quotedString.subSequence(1, len - 1)
    }

    private fun <T : WaccAST> T.records(start: Index, end: Index): T = this.also {
        startIndex = start
        endIndex = end
    }

    private fun ParserRuleContext.start(): Index = this.start.line to this.start.charPositionInLine
    private fun ParserRuleContext.end(): Index = this.stop.line to this.stop.charPositionInLine

    private fun <T : Expression> T.markParens(): T = this.also { it.inParens = true }

    private fun logError(error: SyntacticException) {
        for (context in stack) {
            error.forwardWith(context.getErrorString())
        }
        errorList.add(error)
    }

    private fun ParserRuleContext.getErrorString(): String {
        return when (this) {
            is ProgContext -> "In the main program"
            is FuncContext -> {
                val params = paramList()?.param()?.joinToString(", ")
                { it.originalText() } ?: ""
                val funcDef = "${type().text} ${ident().text} ($params)"
                "In a function defined at ${start()}: $funcDef"
            }
            is StatContext -> "In a statement at ${start()}: \"${originalText()}"
            is ExprContext -> "In a pure expression at ${start()}: \"${originalText()}\""
            else -> throw IllegalArgumentException()
        }
    }
}
