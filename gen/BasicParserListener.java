// Generated from /homes/zy7218/wacc_51/antlr_config/BasicParser.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BasicParser}.
 */
public interface BasicParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BasicParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BasicParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#binExpr4}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr4(BasicParser.BinExpr4Context ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#binExpr4}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr4(BasicParser.BinExpr4Context ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#binExpr3}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr3(BasicParser.BinExpr3Context ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#binExpr3}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr3(BasicParser.BinExpr3Context ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#binExpr2}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr2(BasicParser.BinExpr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#binExpr2}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr2(BasicParser.BinExpr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#binExpr1}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr1(BasicParser.BinExpr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#binExpr1}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr1(BasicParser.BinExpr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(BasicParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#atomExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(BasicParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(BasicParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(BasicParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(BasicParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(BasicParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#assignLhs}.
	 * @param ctx the parse tree
	 */
	void enterAssignLhs(BasicParser.AssignLhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#assignLhs}.
	 * @param ctx the parse tree
	 */
	void exitAssignLhs(BasicParser.AssignLhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#assignRhs}.
	 * @param ctx the parse tree
	 */
	void enterAssignRhs(BasicParser.AssignRhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#assignRhs}.
	 * @param ctx the parse tree
	 */
	void exitAssignRhs(BasicParser.AssignRhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(BasicParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(BasicParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#arrayLiter}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiter(BasicParser.ArrayLiterContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#arrayLiter}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiter(BasicParser.ArrayLiterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void enterArrayElem(BasicParser.ArrayElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#arrayElem}.
	 * @param ctx the parse tree
	 */
	void exitArrayElem(BasicParser.ArrayElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#pairElem}.
	 * @param ctx the parse tree
	 */
	void enterPairElem(BasicParser.PairElemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#pairElem}.
	 * @param ctx the parse tree
	 */
	void exitPairElem(BasicParser.PairElemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(BasicParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(BasicParser.ProgContext ctx);
}