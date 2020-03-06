// Generated from ./WaccParser.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WaccParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WaccParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WaccParser#intsign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntsign(WaccParser.IntsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(WaccParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(WaccParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#capIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapIdent(WaccParser.CapIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#boolLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLit(WaccParser.BoolLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(WaccParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(WaccParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pairElemType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemType(WaccParser.PairElemTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(WaccParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pairType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairType(WaccParser.PairTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#generics}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerics(WaccParser.GenericsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(WaccParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#newtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewtype(WaccParser.NewtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#genericTVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericTVars(WaccParser.GenericTVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(WaccParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#unionEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionEntry(WaccParser.UnionEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#taggedUnion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaggedUnion(WaccParser.TaggedUnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeFromTo}
	 * labeled alternative in {@link WaccParser#enumRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeFromTo(WaccParser.RangeFromToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeFromThenTo}
	 * labeled alternative in {@link WaccParser#enumRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeFromThenTo(WaccParser.RangeFromThenToContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(WaccParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pairElemFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemFunc(WaccParser.PairElemFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop1(WaccParser.Binop1Context ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop2(WaccParser.Binop2Context ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop3(WaccParser.Binop3Context ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop4(WaccParser.Binop4Context ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop5(WaccParser.Binop5Context ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#binop6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinop6(WaccParser.Binop6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInt(WaccParser.ExprIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprNull}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNull(WaccParser.ExprNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBinop}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBinop(WaccParser.ExprBinopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprString(WaccParser.ExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprBool}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprBool(WaccParser.ExprBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArrElem}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArrElem(WaccParser.ExprArrElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParens}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParens(WaccParser.ExprParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIdent}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIdent(WaccParser.ExprIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprUnaryop}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnaryop(WaccParser.ExprUnaryopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprIf}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIf(WaccParser.ExprIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprChar}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprChar(WaccParser.ExprCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFuncCall}
	 * labeled alternative in {@link WaccParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFuncCall(WaccParser.ExprFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(WaccParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(WaccParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(WaccParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#forallConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForallConstraint(WaccParser.ForallConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#constraintList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintList(WaccParser.ConstraintListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(WaccParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#requiredFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequiredFunc(WaccParser.RequiredFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#traitDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitDef(WaccParser.TraitDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#builtinFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunc(WaccParser.BuiltinFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skip}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(WaccParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(WaccParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constDeclaration}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDeclaration(WaccParser.ConstDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignment}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(WaccParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readCall}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(WaccParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code builtinFuncCall}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFuncCall(WaccParser.BuiltinFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condBranch}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBranch(WaccParser.CondBranchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(WaccParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(WaccParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whenClause}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenClause(WaccParser.WhenClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link WaccParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(WaccParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(WaccParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#whenCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenCase(WaccParser.WhenCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#stats}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStats(WaccParser.StatsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#assignLhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignLhs(WaccParser.AssignLhsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsExpr}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsExpr(WaccParser.RhsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsArrayLiter}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsArrayLiter(WaccParser.RhsArrayLiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsNewPair}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsNewPair(WaccParser.RhsNewPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsPairElem}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsPairElem(WaccParser.RhsPairElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsTypeMember}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsTypeMember(WaccParser.RhsTypeMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsTypeConstructor}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsTypeConstructor(WaccParser.RhsTypeConstructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rhsFuncCall}
	 * labeled alternative in {@link WaccParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhsFuncCall(WaccParser.RhsFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(WaccParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#arrayLiter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiter(WaccParser.ArrayLiterContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(WaccParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#pairElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElem(WaccParser.PairElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#typeMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeMember(WaccParser.TypeMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#typeConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstructor(WaccParser.TypeConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link WaccParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(WaccParser.ProgContext ctx);
}