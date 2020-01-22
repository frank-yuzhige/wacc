// Generated from ./BasicParser.g4 by ANTLR 4.7
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
public class BasicParser extends Parser {
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
		RULE_func = 8, RULE_stat = 9, RULE_assignLhs = 10, RULE_assignRhs = 11, 
		RULE_argList = 12, RULE_arrayLiter = 13, RULE_arrayElem = 14, RULE_pairElem = 15, 
		RULE_prog = 16;
	public static final String[] ruleNames = {
		"expr", "binExpr4", "binExpr3", "binExpr2", "binExpr1", "atomExpr", "param", 
		"paramList", "func", "stat", "assignLhs", "assignRhs", "argList", "arrayLiter", 
		"arrayElem", "pairElem", "prog"
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
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
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
		public List<TerminalNode> BINOP5() { return getTokens(BasicParser.BINOP5); }
		public TerminalNode BINOP5(int i) {
			return getToken(BasicParser.BINOP5, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExpr(this);
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
			setState(34);
			binExpr4();
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					match(BINOP5);
					setState(36);
					binExpr4();
					}
					} 
				}
				setState(41);
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
		public List<TerminalNode> BINOP4() { return getTokens(BasicParser.BINOP4); }
		public TerminalNode BINOP4(int i) {
			return getToken(BasicParser.BINOP4, i);
		}
		public BinExpr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinExpr4(this);
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
			setState(42);
			binExpr3();
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					match(BINOP4);
					setState(44);
					binExpr3();
					}
					} 
				}
				setState(49);
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
		public List<TerminalNode> BINOP3() { return getTokens(BasicParser.BINOP3); }
		public TerminalNode BINOP3(int i) {
			return getToken(BasicParser.BINOP3, i);
		}
		public BinExpr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinExpr3(this);
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
			setState(50);
			binExpr2();
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(51);
					match(BINOP3);
					setState(52);
					binExpr2();
					}
					} 
				}
				setState(57);
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
		public List<TerminalNode> BINOP2() { return getTokens(BasicParser.BINOP2); }
		public TerminalNode BINOP2(int i) {
			return getToken(BasicParser.BINOP2, i);
		}
		public BinExpr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinExpr2(this);
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
			setState(58);
			binExpr1();
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					match(BINOP2);
					setState(60);
					binExpr1();
					}
					} 
				}
				setState(65);
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
		public List<TerminalNode> BINOP1() { return getTokens(BasicParser.BINOP1); }
		public TerminalNode BINOP1(int i) {
			return getToken(BasicParser.BINOP1, i);
		}
		public BinExpr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binExpr1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBinExpr1(this);
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
			setState(66);
			atomExpr();
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					match(BINOP1);
					setState(68);
					atomExpr();
					}
					} 
				}
				setState(73);
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
		public TerminalNode LPAR() { return getToken(BasicParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(BasicParser.RPAR, 0); }
		public TerminalNode INTEGER() { return getToken(BasicParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
		public TerminalNode CHARLIT() { return getToken(BasicParser.CHARLIT, 0); }
		public TerminalNode STRLIT() { return getToken(BasicParser.STRLIT, 0); }
		public TerminalNode NULL() { return getToken(BasicParser.NULL, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode UNARYOP() { return getToken(BasicParser.UNARYOP, 0); }
		public AtomExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExprContext atomExpr() throws RecognitionException {
		AtomExprContext _localctx = new AtomExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomExpr);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(LPAR);
				setState(75);
				expr();
				setState(76);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(INTEGER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(TRUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(FALSE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(CHARLIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				match(STRLIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				match(NULL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
				match(IDENT);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(85);
				arrayElem();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(86);
				match(UNARYOP);
				setState(87);
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
		public TerminalNode TYPE() { return getToken(BasicParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TYPE);
			setState(91);
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
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParamList(this);
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
			setState(93);
			param();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(94);
				match(COMMA);
				setState(95);
				param();
				}
				}
				setState(100);
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
		public TerminalNode TYPE() { return getToken(BasicParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode LPAR() { return getToken(BasicParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(BasicParser.RPAR, 0); }
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
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
			setState(101);
			match(TYPE);
			setState(102);
			match(IDENT);
			setState(103);
			match(LPAR);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(104);
				paramList();
				}
			}

			setState(107);
			match(RPAR);
			setState(108);
			match(IS);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << TYPE) | (1L << IDENT))) != 0)) {
				{
				{
				setState(109);
				stat(0);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
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
		public TerminalNode SKIP_STAT() { return getToken(BasicParser.SKIP_STAT, 0); }
		public TerminalNode TYPE() { return getToken(BasicParser.TYPE, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(BasicParser.ASSIGN, 0); }
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_stat, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				{
				setState(118);
				match(SKIP_STAT);
				}
				break;
			case TYPE:
				{
				setState(119);
				match(TYPE);
				setState(120);
				match(IDENT);
				setState(121);
				match(ASSIGN);
				setState(122);
				assignRhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(123);
				assignLhs();
				setState(124);
				match(ASSIGN);
				setState(125);
				assignRhs();
				}
				break;
			case READ:
				{
				setState(127);
				match(READ);
				setState(128);
				assignRhs();
				}
				break;
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
				{
				setState(129);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(130);
				expr();
				}
				break;
			case IF:
				{
				setState(131);
				match(IF);
				setState(132);
				expr();
				setState(133);
				match(THEN);
				setState(134);
				stat(0);
				setState(135);
				match(ELSE);
				setState(136);
				stat(0);
				setState(137);
				match(FI);
				}
				break;
			case WHILE:
				{
				setState(139);
				match(WHILE);
				setState(140);
				expr();
				setState(141);
				match(DO);
				setState(142);
				stat(0);
				setState(143);
				match(DONE);
				}
				break;
			case BEGIN:
				{
				setState(145);
				match(BEGIN);
				setState(146);
				stat(0);
				setState(147);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(156);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(151);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(152);
					match(SEMICOLON);
					setState(153);
					stat(2);
					}
					} 
				}
				setState(158);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignLhsContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
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
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLhsContext assignLhs() throws RecognitionException {
		AssignLhsContext _localctx = new AssignLhsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignLhs);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
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
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode LPAR() { return getToken(BasicParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(BasicParser.RPAR, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public AssignRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRhsContext assignRhs() throws RecognitionException {
		AssignRhsContext _localctx = new AssignRhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignRhs);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				arrayLiter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(NEWPAIR);
				setState(167);
				match(LPAR);
				setState(168);
				expr();
				setState(169);
				match(COMMA);
				setState(170);
				expr();
				setState(171);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(173);
				pairElem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(174);
				match(CALL);
				setState(175);
				match(IDENT);
				setState(176);
				match(LPAR);
				setState(177);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(178);
				match(CALL);
				setState(179);
				match(IDENT);
				setState(180);
				match(LPAR);
				setState(181);
				argList();
				setState(182);
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
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			expr();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(187);
				match(COMMA);
				setState(188);
				expr();
				}
				}
				setState(193);
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
		public TerminalNode LBRA() { return getToken(BasicParser.LBRA, 0); }
		public TerminalNode RBRA() { return getToken(BasicParser.RBRA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArrayLiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayLiter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiterContext arrayLiter() throws RecognitionException {
		ArrayLiterContext _localctx = new ArrayLiterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayLiter);
		int _la;
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(LBRA);
				setState(195);
				match(RBRA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(LBRA);
				setState(197);
				expr();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					expr();
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
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
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public List<TerminalNode> LBRA() { return getTokens(BasicParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(BasicParser.LBRA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBRA() { return getTokens(BasicParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(BasicParser.RBRA, i);
		}
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(IDENT);
			setState(214); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(210);
					match(LBRA);
					setState(211);
					expr();
					setState(212);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(216); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pairElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(219);
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
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
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
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(BEGIN);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(222);
					func();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(228);
			stat(0);
			setState(229);
			match(END);
			setState(230);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return stat_sempred((StatContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u00eb\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\5\3\5\3\5\7\5@\n\5\f\5\16"+
		"\5C\13\5\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\t\3\t\3\t\7\tc\n"+
		"\t\f\t\16\tf\13\t\3\n\3\n\3\n\3\n\5\nl\n\n\3\n\3\n\3\n\7\nq\n\n\f\n\16"+
		"\nt\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0098\n\13\3\13\3\13\3\13\7\13"+
		"\u009d\n\13\f\13\16\13\u00a0\13\13\3\f\3\f\3\f\5\f\u00a5\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00bb\n\r\3\16\3\16\3\16\7\16\u00c0\n\16\f\16\16\16\u00c3\13\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\7\17\u00cb\n\17\f\17\16\17\u00ce\13\17\3"+
		"\17\3\17\5\17\u00d2\n\17\3\20\3\20\3\20\3\20\3\20\6\20\u00d9\n\20\r\20"+
		"\16\20\u00da\3\21\3\21\3\21\3\22\3\22\7\22\u00e2\n\22\f\22\16\22\u00e5"+
		"\13\22\3\22\3\22\3\22\3\22\3\22\2\3\24\23\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"\2\4\3\2&*\3\2\f\r\2\u00fe\2$\3\2\2\2\4,\3\2\2\2\6\64\3\2"+
		"\2\2\b<\3\2\2\2\nD\3\2\2\2\fZ\3\2\2\2\16\\\3\2\2\2\20_\3\2\2\2\22g\3\2"+
		"\2\2\24\u0097\3\2\2\2\26\u00a4\3\2\2\2\30\u00ba\3\2\2\2\32\u00bc\3\2\2"+
		"\2\34\u00d1\3\2\2\2\36\u00d3\3\2\2\2 \u00dc\3\2\2\2\"\u00df\3\2\2\2$)"+
		"\5\4\3\2%&\7\7\2\2&(\5\4\3\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2"+
		"*\3\3\2\2\2+)\3\2\2\2,\61\5\6\4\2-.\7\6\2\2.\60\5\6\4\2/-\3\2\2\2\60\63"+
		"\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\5\3\2\2\2\63\61\3\2\2\2\649\5\b"+
		"\5\2\65\66\7\5\2\2\668\5\b\5\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3"+
		"\2\2\2:\7\3\2\2\2;9\3\2\2\2<A\5\n\6\2=>\7\4\2\2>@\5\n\6\2?=\3\2\2\2@C"+
		"\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2\2CA\3\2\2\2DI\5\f\7\2EF\7\3\2\2"+
		"FH\5\f\7\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\13\3\2\2\2KI\3\2\2"+
		"\2LM\7\20\2\2MN\5\2\2\2NO\7\21\2\2O[\3\2\2\2P[\7-\2\2Q[\7\33\2\2R[\7\34"+
		"\2\2S[\7/\2\2T[\7.\2\2U[\7\32\2\2V[\7\62\2\2W[\5\36\20\2XY\7\16\2\2Y["+
		"\5\2\2\2ZL\3\2\2\2ZP\3\2\2\2ZQ\3\2\2\2ZR\3\2\2\2ZS\3\2\2\2ZT\3\2\2\2Z"+
		"U\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2\2\2[\r\3\2\2\2\\]\7,\2\2]^\7\62\2"+
		"\2^\17\3\2\2\2_d\5\16\b\2`a\7\61\2\2ac\5\16\b\2b`\3\2\2\2cf\3\2\2\2db"+
		"\3\2\2\2de\3\2\2\2e\21\3\2\2\2fd\3\2\2\2gh\7,\2\2hi\7\62\2\2ik\7\20\2"+
		"\2jl\5\20\t\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\7\21\2\2nr\7\30\2\2oq\5"+
		"\24\13\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2u"+
		"v\7\31\2\2v\23\3\2\2\2wx\b\13\1\2x\u0098\7\17\2\2yz\7,\2\2z{\7\62\2\2"+
		"{|\7\60\2\2|\u0098\5\30\r\2}~\5\26\f\2~\177\7\60\2\2\177\u0080\5\30\r"+
		"\2\u0080\u0098\3\2\2\2\u0081\u0082\7%\2\2\u0082\u0098\5\30\r\2\u0083\u0084"+
		"\t\2\2\2\u0084\u0098\5\2\2\2\u0085\u0086\7\35\2\2\u0086\u0087\5\2\2\2"+
		"\u0087\u0088\7\36\2\2\u0088\u0089\5\24\13\2\u0089\u008a\7\37\2\2\u008a"+
		"\u008b\5\24\13\2\u008b\u008c\7 \2\2\u008c\u0098\3\2\2\2\u008d\u008e\7"+
		"!\2\2\u008e\u008f\5\2\2\2\u008f\u0090\7\"\2\2\u0090\u0091\5\24\13\2\u0091"+
		"\u0092\7#\2\2\u0092\u0098\3\2\2\2\u0093\u0094\7\27\2\2\u0094\u0095\5\24"+
		"\13\2\u0095\u0096\7\31\2\2\u0096\u0098\3\2\2\2\u0097w\3\2\2\2\u0097y\3"+
		"\2\2\2\u0097}\3\2\2\2\u0097\u0081\3\2\2\2\u0097\u0083\3\2\2\2\u0097\u0085"+
		"\3\2\2\2\u0097\u008d\3\2\2\2\u0097\u0093\3\2\2\2\u0098\u009e\3\2\2\2\u0099"+
		"\u009a\f\3\2\2\u009a\u009b\7\26\2\2\u009b\u009d\5\24\13\4\u009c\u0099"+
		"\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\25\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a5\7\62\2\2\u00a2\u00a5\5\36"+
		"\20\2\u00a3\u00a5\5 \21\2\u00a4\u00a1\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\27\3\2\2\2\u00a6\u00bb\5\2\2\2\u00a7\u00bb\5\34\17"+
		"\2\u00a8\u00a9\7$\2\2\u00a9\u00aa\7\20\2\2\u00aa\u00ab\5\2\2\2\u00ab\u00ac"+
		"\7\61\2\2\u00ac\u00ad\5\2\2\2\u00ad\u00ae\7\21\2\2\u00ae\u00bb\3\2\2\2"+
		"\u00af\u00bb\5 \21\2\u00b0\u00b1\7+\2\2\u00b1\u00b2\7\62\2\2\u00b2\u00b3"+
		"\7\20\2\2\u00b3\u00bb\7\21\2\2\u00b4\u00b5\7+\2\2\u00b5\u00b6\7\62\2\2"+
		"\u00b6\u00b7\7\20\2\2\u00b7\u00b8\5\32\16\2\u00b8\u00b9\7\21\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00a6\3\2\2\2\u00ba\u00a7\3\2\2\2\u00ba\u00a8\3\2"+
		"\2\2\u00ba\u00af\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb"+
		"\31\3\2\2\2\u00bc\u00c1\5\2\2\2\u00bd\u00be\7\61\2\2\u00be\u00c0\5\2\2"+
		"\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7\22\2\2\u00c5"+
		"\u00d2\7\23\2\2\u00c6\u00c7\7\22\2\2\u00c7\u00cc\5\2\2\2\u00c8\u00c9\7"+
		"\61\2\2\u00c9\u00cb\5\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d0\7\23\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00c4\3\2\2\2\u00d1"+
		"\u00c6\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d8\7\62\2\2\u00d4\u00d5\7\22"+
		"\2\2\u00d5\u00d6\5\2\2\2\u00d6\u00d7\7\23\2\2\u00d7\u00d9\3\2\2\2\u00d8"+
		"\u00d4\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\37\3\2\2\2\u00dc\u00dd\t\3\2\2\u00dd\u00de\5\2\2\2\u00de!\3"+
		"\2\2\2\u00df\u00e3\7\27\2\2\u00e0\u00e2\5\22\n\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\5\24\13\2\u00e7\u00e8\7\31\2\2\u00e8"+
		"\u00e9\7\2\2\3\u00e9#\3\2\2\2\24)\619AIZdkr\u0097\u009e\u00a4\u00ba\u00c1"+
		"\u00cc\u00d1\u00da\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}