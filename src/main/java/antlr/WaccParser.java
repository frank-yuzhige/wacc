// Generated from ./WaccParser.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BINOP1=1, BINOP2=2, BINOP3=3, BINOP4=4, BINOP5=5, NOT=6, LEN=7, ORD=8, 
		CHR=9, FST=10, SND=11, UNARYOP=12, SKIP_STAT=13, LPAR=14, RPAR=15, LBRA=16, 
		RBRA=17, LCUR=18, RCUR=19, SEMICOLON=20, BEGIN=21, IS=22, END=23, NULL=24, 
		TRUE=25, FALSE=26, IF=27, THEN=28, ELSE=29, FI=30, WHILE=31, DO=32, DONE=33, 
		NEWPAIR=34, READ=35, FREE=36, RETURN=37, EXIT=38, PRINT=39, PRINTLN=40, 
		CALL=41, TYPE=42, INTEGER=43, STRLIT=44, CHARLIT=45, ASSIGN=46, COMMA=47, 
		IDENT=48, COMMENT=49, WS=50;
	public static final int
		RULE_expr = 0, RULE_binExpr4 = 1, RULE_binExpr3 = 2, RULE_binExpr2 = 3, 
		RULE_binExpr1 = 4, RULE_atomExpr = 5, RULE_param = 6, RULE_paramList = 7, 
		RULE_func = 8, RULE_stat = 9, RULE_stats = 10, RULE_assignLhs = 11, RULE_assignRhs = 12, 
		RULE_argList = 13, RULE_arrayLiter = 14, RULE_arrayElem = 15, RULE_pairElem = 16, 
		RULE_prog = 17;
	public static final String[] ruleNames = {
		"expr", "binExpr4", "binExpr3", "binExpr2", "binExpr1", "atomExpr", "param", 
		"paramList", "func", "stat", "stats", "assignLhs", "assignRhs", "argList", 
		"arrayLiter", "arrayElem", "pairElem", "prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'!'", "'len'", "'ord'", "'chr'", 
		"'fst'", "'snd'", null, "'skip'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"';'", "'begin'", "'is'", "'end'", "'null'", "'true'", "'false'", "'if'", 
		"'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'newpair'", 
		"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'call'", 
		null, null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BINOP1", "BINOP2", "BINOP3", "BINOP4", "BINOP5", "NOT", "LEN", 
		"ORD", "CHR", "FST", "SND", "UNARYOP", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
		"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
		"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "NEWPAIR", 
		"READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", "TYPE", 
		"INTEGER", "STRLIT", "CHARLIT", "ASSIGN", "COMMA", "IDENT", "COMMENT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "WaccParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WaccParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public List<BinExpr4Context> binExpr4() {
			return getRuleContexts(BinExpr4Context.class);
		}
		public BinExpr4Context binExpr4(int i) {
			return getRuleContext(BinExpr4Context.class,i);
		}
		public List<TerminalNode> BINOP5() { return getTokens(WaccParser.BINOP5); }
		public TerminalNode BINOP5(int i) {
			return getToken(WaccParser.BINOP5, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			binExpr4();
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37);
					match(BINOP5);
					setState(38);
					binExpr4();
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinExpr4Context extends ParserRuleContext {
		public List<BinExpr3Context> binExpr3() {
			return getRuleContexts(BinExpr3Context.class);
		}
		public BinExpr3Context binExpr3(int i) {
			return getRuleContext(BinExpr3Context.class,i);
		}
		public List<TerminalNode> BINOP4() { return getTokens(WaccParser.BINOP4); }
		public TerminalNode BINOP4(int i) {
			return getToken(WaccParser.BINOP4, i);
		}
		public BinExpr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinExpr4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinExpr4Context binExpr4() throws RecognitionException {
		BinExpr4Context _localctx = new BinExpr4Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_binExpr4);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			binExpr3();
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45);
					match(BINOP4);
					setState(46);
					binExpr3();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinExpr3Context extends ParserRuleContext {
		public List<BinExpr2Context> binExpr2() {
			return getRuleContexts(BinExpr2Context.class);
		}
		public BinExpr2Context binExpr2(int i) {
			return getRuleContext(BinExpr2Context.class,i);
		}
		public List<TerminalNode> BINOP3() { return getTokens(WaccParser.BINOP3); }
		public TerminalNode BINOP3(int i) {
			return getToken(WaccParser.BINOP3, i);
		}
		public BinExpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinExpr3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinExpr3Context binExpr3() throws RecognitionException {
		BinExpr3Context _localctx = new BinExpr3Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_binExpr3);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			binExpr2();
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(53);
					match(BINOP3);
					setState(54);
					binExpr2();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinExpr2Context extends ParserRuleContext {
		public List<BinExpr1Context> binExpr1() {
			return getRuleContexts(BinExpr1Context.class);
		}
		public BinExpr1Context binExpr1(int i) {
			return getRuleContext(BinExpr1Context.class,i);
		}
		public List<TerminalNode> BINOP2() { return getTokens(WaccParser.BINOP2); }
		public TerminalNode BINOP2(int i) {
			return getToken(WaccParser.BINOP2, i);
		}
		public BinExpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinExpr2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinExpr2Context binExpr2() throws RecognitionException {
		BinExpr2Context _localctx = new BinExpr2Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_binExpr2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			binExpr1();
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					match(BINOP2);
					setState(62);
					binExpr1();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinExpr1Context extends ParserRuleContext {
		public List<AtomExprContext> atomExpr() {
			return getRuleContexts(AtomExprContext.class);
		}
		public AtomExprContext atomExpr(int i) {
			return getRuleContext(AtomExprContext.class,i);
		}
		public List<TerminalNode> BINOP1() { return getTokens(WaccParser.BINOP1); }
		public TerminalNode BINOP1(int i) {
			return getToken(WaccParser.BINOP1, i);
		}
		public BinExpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinExpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinExpr1Context binExpr1() throws RecognitionException {
		BinExpr1Context _localctx = new BinExpr1Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_binExpr1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			atomExpr();
			setState(73);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(69);
					match(BINOP1);
					setState(70);
					atomExpr();
					}
					} 
				}
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomExprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public TerminalNode INTEGER() { return getToken(WaccParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(WaccParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(WaccParser.FALSE, 0); }
		public TerminalNode CHARLIT() { return getToken(WaccParser.CHARLIT, 0); }
		public TerminalNode STRLIT() { return getToken(WaccParser.STRLIT, 0); }
		public TerminalNode NULL() { return getToken(WaccParser.NULL, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode UNARYOP() { return getToken(WaccParser.UNARYOP, 0); }
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomExpr);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(LPAR);
				setState(77);
				expr();
				setState(78);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(INTEGER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				match(CHARLIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				match(STRLIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				match(NULL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(86);
				match(IDENT);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(87);
				arrayElem();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(88);
				match(UNARYOP);
				setState(89);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(WaccParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(TYPE);
			setState(93);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			param();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(96);
				match(COMMA);
				setState(97);
				param();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(WaccParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(TYPE);
			setState(104);
			match(IDENT);
			setState(105);
			match(LPAR);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(106);
				paramList();
				}
			}

			setState(109);
			match(RPAR);
			setState(110);
			match(IS);
			setState(111);
			stats();
			setState(112);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public TerminalNode SKIP_STAT() { return getToken(WaccParser.SKIP_STAT, 0); }
		public TerminalNode TYPE() { return getToken(WaccParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stat);
		int _la;
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(SKIP_STAT);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(TYPE);
				setState(116);
				match(IDENT);
				setState(117);
				match(ASSIGN);
				setState(118);
				assignRhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				assignLhs();
				setState(120);
				match(ASSIGN);
				setState(121);
				assignRhs();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(READ);
				setState(124);
				assignRhs();
				}
				break;
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(126);
				expr();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				match(IF);
				setState(128);
				expr();
				setState(129);
				match(THEN);
				setState(130);
				stats();
				setState(131);
				match(ELSE);
				setState(132);
				stats();
				setState(133);
				match(FI);
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(WHILE);
				setState(136);
				expr();
				setState(137);
				match(DO);
				setState(138);
				stats();
				setState(139);
				match(DONE);
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 8);
				{
				setState(141);
				match(BEGIN);
				setState(142);
				stats();
				setState(143);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatsContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(WaccParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(WaccParser.SEMICOLON, i);
		}
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << TYPE) | (1L << IDENT))) != 0)) {
				{
				setState(147);
				stat();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(148);
					match(SEMICOLON);
					setState(149);
					stat();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignLhsContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignLhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLhsContext assignLhs() throws RecognitionException {
		AssignLhsContext _localctx = new AssignLhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignLhs);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				pairElem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignRhsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public AssignRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRhsContext assignRhs() throws RecognitionException {
		AssignRhsContext _localctx = new AssignRhsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignRhs);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				arrayLiter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(NEWPAIR);
				setState(165);
				match(LPAR);
				setState(166);
				expr();
				setState(167);
				match(COMMA);
				setState(168);
				expr();
				setState(169);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				pairElem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				match(CALL);
				setState(173);
				match(IDENT);
				setState(174);
				match(LPAR);
				setState(175);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(CALL);
				setState(177);
				match(IDENT);
				setState(178);
				match(LPAR);
				setState(179);
				argList();
				setState(180);
				match(RPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			expr();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185);
				match(COMMA);
				setState(186);
				expr();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLiterContext extends ParserRuleContext {
		public TerminalNode LBRA() { return getToken(WaccParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(WaccParser.RBRA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public ArrayLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiterContext arrayLiter() throws RecognitionException {
		ArrayLiterContext _localctx = new ArrayLiterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayLiter);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(LBRA);
				setState(193);
				match(RBRA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(LBRA);
				setState(195);
				expr();
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(196);
					match(COMMA);
					setState(197);
					expr();
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				match(RBRA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayElemContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public List<TerminalNode> LBRA() { return getTokens(WaccParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(WaccParser.LBRA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBRA() { return getTokens(WaccParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(WaccParser.RBRA, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(IDENT);
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(208);
				match(LBRA);
				setState(209);
				expr();
				setState(210);
				match(RBRA);
				}
				}
				setState(214); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pairElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(217);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(BEGIN);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220);
					func();
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(226);
			stats();
			setState(227);
			match(END);
			setState(228);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\7\3\62\n\3"+
		"\f\3\16\3\65\13\3\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\5\3\5\3\5\7\5"+
		"B\n\5\f\5\16\5E\13\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\7\te\n\t\f\t\16\th\13\t\3\n\3\n\3\n\3\n\5\nn\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0094\n\13\3\f\3\f\3\f\7\f\u0099\n\f\f\f\16"+
		"\f\u009c\13\f\5\f\u009e\n\f\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00b9\n\16\3\17\3\17\3\17\7\17\u00be\n\17\f\17\16\17"+
		"\u00c1\13\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00c9\n\20\f\20\16\20"+
		"\u00cc\13\20\3\20\3\20\5\20\u00d0\n\20\3\21\3\21\3\21\3\21\3\21\6\21\u00d7"+
		"\n\21\r\21\16\21\u00d8\3\22\3\22\3\22\3\23\3\23\7\23\u00e0\n\23\f\23\16"+
		"\23\u00e3\13\23\3\23\3\23\3\23\3\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$\2\4\3\2&*\3\2\f\r\2\u00fb\2&\3\2\2\2\4.\3\2\2\2\6"+
		"\66\3\2\2\2\b>\3\2\2\2\nF\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20a\3\2\2\2"+
		"\22i\3\2\2\2\24\u0093\3\2\2\2\26\u009d\3\2\2\2\30\u00a2\3\2\2\2\32\u00b8"+
		"\3\2\2\2\34\u00ba\3\2\2\2\36\u00cf\3\2\2\2 \u00d1\3\2\2\2\"\u00da\3\2"+
		"\2\2$\u00dd\3\2\2\2&+\5\4\3\2\'(\7\7\2\2(*\5\4\3\2)\'\3\2\2\2*-\3\2\2"+
		"\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2\2.\63\5\6\4\2/\60\7\6\2\2\60"+
		"\62\5\6\4\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\5"+
		"\3\2\2\2\65\63\3\2\2\2\66;\5\b\5\2\678\7\5\2\28:\5\b\5\29\67\3\2\2\2:"+
		"=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=;\3\2\2\2>C\5\n\6\2?@\7\4\2\2"+
		"@B\5\n\6\2A?\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2"+
		"\2FK\5\f\7\2GH\7\3\2\2HJ\5\f\7\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2"+
		"\2L\13\3\2\2\2MK\3\2\2\2NO\7\20\2\2OP\5\2\2\2PQ\7\21\2\2Q]\3\2\2\2R]\7"+
		"-\2\2S]\7\33\2\2T]\7\34\2\2U]\7/\2\2V]\7.\2\2W]\7\32\2\2X]\7\62\2\2Y]"+
		"\5 \21\2Z[\7\16\2\2[]\5\2\2\2\\N\3\2\2\2\\R\3\2\2\2\\S\3\2\2\2\\T\3\2"+
		"\2\2\\U\3\2\2\2\\V\3\2\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2"+
		"]\r\3\2\2\2^_\7,\2\2_`\7\62\2\2`\17\3\2\2\2af\5\16\b\2bc\7\61\2\2ce\5"+
		"\16\b\2db\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\21\3\2\2\2hf\3\2\2\2"+
		"ij\7,\2\2jk\7\62\2\2km\7\20\2\2ln\5\20\t\2ml\3\2\2\2mn\3\2\2\2no\3\2\2"+
		"\2op\7\21\2\2pq\7\30\2\2qr\5\26\f\2rs\7\31\2\2s\23\3\2\2\2t\u0094\7\17"+
		"\2\2uv\7,\2\2vw\7\62\2\2wx\7\60\2\2x\u0094\5\32\16\2yz\5\30\r\2z{\7\60"+
		"\2\2{|\5\32\16\2|\u0094\3\2\2\2}~\7%\2\2~\u0094\5\32\16\2\177\u0080\t"+
		"\2\2\2\u0080\u0094\5\2\2\2\u0081\u0082\7\35\2\2\u0082\u0083\5\2\2\2\u0083"+
		"\u0084\7\36\2\2\u0084\u0085\5\26\f\2\u0085\u0086\7\37\2\2\u0086\u0087"+
		"\5\26\f\2\u0087\u0088\7 \2\2\u0088\u0094\3\2\2\2\u0089\u008a\7!\2\2\u008a"+
		"\u008b\5\2\2\2\u008b\u008c\7\"\2\2\u008c\u008d\5\26\f\2\u008d\u008e\7"+
		"#\2\2\u008e\u0094\3\2\2\2\u008f\u0090\7\27\2\2\u0090\u0091\5\26\f\2\u0091"+
		"\u0092\7\31\2\2\u0092\u0094\3\2\2\2\u0093t\3\2\2\2\u0093u\3\2\2\2\u0093"+
		"y\3\2\2\2\u0093}\3\2\2\2\u0093\177\3\2\2\2\u0093\u0081\3\2\2\2\u0093\u0089"+
		"\3\2\2\2\u0093\u008f\3\2\2\2\u0094\25\3\2\2\2\u0095\u009a\5\24\13\2\u0096"+
		"\u0097\7\26\2\2\u0097\u0099\5\24\13\2\u0098\u0096\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u0095\3\2\2\2\u009d\u009e\3\2\2\2\u009e\27\3\2\2"+
		"\2\u009f\u00a3\7\62\2\2\u00a0\u00a3\5 \21\2\u00a1\u00a3\5\"\22\2\u00a2"+
		"\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\31\3\2\2"+
		"\2\u00a4\u00b9\5\2\2\2\u00a5\u00b9\5\36\20\2\u00a6\u00a7\7$\2\2\u00a7"+
		"\u00a8\7\20\2\2\u00a8\u00a9\5\2\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\5"+
		"\2\2\2\u00ab\u00ac\7\21\2\2\u00ac\u00b9\3\2\2\2\u00ad\u00b9\5\"\22\2\u00ae"+
		"\u00af\7+\2\2\u00af\u00b0\7\62\2\2\u00b0\u00b1\7\20\2\2\u00b1\u00b9\7"+
		"\21\2\2\u00b2\u00b3\7+\2\2\u00b3\u00b4\7\62\2\2\u00b4\u00b5\7\20\2\2\u00b5"+
		"\u00b6\5\34\17\2\u00b6\u00b7\7\21\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00a4"+
		"\3\2\2\2\u00b8\u00a5\3\2\2\2\u00b8\u00a6\3\2\2\2\u00b8\u00ad\3\2\2\2\u00b8"+
		"\u00ae\3\2\2\2\u00b8\u00b2\3\2\2\2\u00b9\33\3\2\2\2\u00ba\u00bf\5\2\2"+
		"\2\u00bb\u00bc\7\61\2\2\u00bc\u00be\5\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\35\3\2\2"+
		"\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\22\2\2\u00c3\u00d0\7\23\2\2\u00c4"+
		"\u00c5\7\22\2\2\u00c5\u00ca\5\2\2\2\u00c6\u00c7\7\61\2\2\u00c7\u00c9\5"+
		"\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\23"+
		"\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00c2\3\2\2\2\u00cf\u00c4\3\2\2\2\u00d0"+
		"\37\3\2\2\2\u00d1\u00d6\7\62\2\2\u00d2\u00d3\7\22\2\2\u00d3\u00d4\5\2"+
		"\2\2\u00d4\u00d5\7\23\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9!\3\2\2\2"+
		"\u00da\u00db\t\3\2\2\u00db\u00dc\5\2\2\2\u00dc#\3\2\2\2\u00dd\u00e1\7"+
		"\27\2\2\u00de\u00e0\5\22\n\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e5\5\26\f\2\u00e5\u00e6\7\31\2\2\u00e6\u00e7\7\2\2\3\u00e7"+
		"%\3\2\2\2\24+\63;CK\\fm\u0093\u009a\u009d\u00a2\u00b8\u00bf\u00ca\u00cf"+
		"\u00d8\u00e1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}