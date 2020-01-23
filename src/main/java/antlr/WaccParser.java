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
		CALL=41, PAIR=42, BASE_TYPE=43, INTEGER=44, STRLIT=45, CHARLIT=46, ASSIGN=47, 
		COMMA=48, IDENT=49, COMMENT=50, WS=51;
	public static final int
		RULE_ident = 0, RULE_type = 1, RULE_arrayType = 2, RULE_pairElemType = 3, 
		RULE_baseType = 4, RULE_pairType = 5, RULE_boolLit = 6, RULE_expr = 7, 
		RULE_binExpr4 = 8, RULE_binExpr3 = 9, RULE_binExpr2 = 10, RULE_binExpr1 = 11, 
		RULE_atomExpr = 12, RULE_param = 13, RULE_paramList = 14, RULE_func = 15, 
		RULE_stat = 16, RULE_stats = 17, RULE_assignLhs = 18, RULE_assignRhs = 19, 
		RULE_argList = 20, RULE_arrayLiter = 21, RULE_arrayElem = 22, RULE_pairElem = 23, 
		RULE_prog = 24;
	public static final String[] ruleNames = {
		"ident", "type", "arrayType", "pairElemType", "baseType", "pairType", 
		"boolLit", "expr", "binExpr4", "binExpr3", "binExpr2", "binExpr1", "atomExpr", 
		"param", "paramList", "func", "stat", "stats", "assignLhs", "assignRhs", 
		"argList", "arrayLiter", "arrayElem", "pairElem", "prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'!'", "'len'", "'ord'", "'chr'", 
		"'fst'", "'snd'", null, "'skip'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
		"';'", "'begin'", "'is'", "'end'", "'null'", "'true'", "'false'", "'if'", 
		"'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'newpair'", 
		"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'call'", 
		"'pair'", null, null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BINOP1", "BINOP2", "BINOP3", "BINOP4", "BINOP5", "NOT", "LEN", 
		"ORD", "CHR", "FST", "SND", "UNARYOP", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
		"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
		"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "NEWPAIR", 
		"READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", "PAIR", 
		"BASE_TYPE", "INTEGER", "STRLIT", "CHARLIT", "ASSIGN", "COMMA", "IDENT", 
		"COMMENT", "WS"
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
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(WaccParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
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

	public static class TypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				pairType();
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public List<TerminalNode> LBRA() { return getTokens(WaccParser.LBRA); }
		public TerminalNode LBRA(int i) {
			return getToken(WaccParser.LBRA, i);
		}
		public List<TerminalNode> RBRA() { return getTokens(WaccParser.RBRA); }
		public TerminalNode RBRA(int i) {
			return getToken(WaccParser.RBRA, i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			baseType();
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				match(LBRA);
				setState(59);
				match(RBRA);
				}
				}
				setState(62); 
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

	public static class PairElemTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pairElemType);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(PAIR);
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

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode BASE_TYPE() { return getToken(WaccParser.BASE_TYPE, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(BASE_TYPE);
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

	public static class PairTypeContext extends ParserRuleContext {
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public PairTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairTypeContext pairType() throws RecognitionException {
		PairTypeContext _localctx = new PairTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(PAIR);
			setState(72);
			match(LPAR);
			setState(73);
			pairElemType();
			setState(74);
			match(COMMA);
			setState(75);
			pairElemType();
			setState(76);
			match(RPAR);
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

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(WaccParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(WaccParser.FALSE, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_boolLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		enterRule(_localctx, 14, RULE_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			binExpr4();
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					match(BINOP5);
					setState(82);
					binExpr4();
					}
					} 
				}
				setState(87);
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
		enterRule(_localctx, 16, RULE_binExpr4);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			binExpr3();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					match(BINOP4);
					setState(90);
					binExpr3();
					}
					} 
				}
				setState(95);
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
		enterRule(_localctx, 18, RULE_binExpr3);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			binExpr2();
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					match(BINOP3);
					setState(98);
					binExpr2();
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		enterRule(_localctx, 20, RULE_binExpr2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			binExpr1();
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(105);
					match(BINOP2);
					setState(106);
					binExpr1();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 22, RULE_binExpr1);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			atomExpr();
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					match(BINOP1);
					setState(114);
					atomExpr();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public TerminalNode CHARLIT() { return getToken(WaccParser.CHARLIT, 0); }
		public TerminalNode STRLIT() { return getToken(WaccParser.STRLIT, 0); }
		public TerminalNode NULL() { return getToken(WaccParser.NULL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_atomExpr);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(LPAR);
				setState(121);
				expr();
				setState(122);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(INTEGER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				boolLit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(CHARLIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(STRLIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				match(NULL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				ident();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(130);
				arrayElem();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(131);
				match(UNARYOP);
				setState(132);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			type();
			setState(136);
			ident();
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
		enterRule(_localctx, 28, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			param();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139);
				match(COMMA);
				setState(140);
				param();
				}
				}
				setState(145);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			type();
			setState(147);
			ident();
			setState(148);
			match(LPAR);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PAIR || _la==BASE_TYPE) {
				{
				setState(149);
				paramList();
				}
			}

			setState(152);
			match(RPAR);
			setState(153);
			match(IS);
			setState(154);
			stats();
			setState(155);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_stat);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(SKIP_STAT);
				}
				break;
			case PAIR:
			case BASE_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				type();
				setState(159);
				ident();
				setState(160);
				match(ASSIGN);
				setState(161);
				assignRhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				assignLhs();
				setState(164);
				match(ASSIGN);
				setState(165);
				assignRhs();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				match(READ);
				setState(168);
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
				setState(169);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(170);
				expr();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(171);
				match(IF);
				setState(172);
				expr();
				setState(173);
				match(THEN);
				setState(174);
				stats();
				setState(175);
				match(ELSE);
				setState(176);
				stats();
				setState(177);
				match(FI);
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(179);
				match(WHILE);
				setState(180);
				expr();
				setState(181);
				match(DO);
				setState(182);
				stats();
				setState(183);
				match(DONE);
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 8);
				{
				setState(185);
				match(BEGIN);
				setState(186);
				stats();
				setState(187);
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
		enterRule(_localctx, 34, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
				{
				setState(191);
				stat();
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMICOLON) {
					{
					{
					setState(192);
					match(SEMICOLON);
					setState(193);
					stat();
					}
					}
					setState(198);
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_assignLhs);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_assignRhs);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				arrayLiter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				match(NEWPAIR);
				setState(209);
				match(LPAR);
				setState(210);
				expr();
				setState(211);
				match(COMMA);
				setState(212);
				expr();
				setState(213);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				pairElem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				match(CALL);
				setState(217);
				ident();
				setState(218);
				match(LPAR);
				setState(219);
				match(RPAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(221);
				match(CALL);
				setState(222);
				ident();
				setState(223);
				match(LPAR);
				setState(224);
				argList();
				setState(225);
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
		enterRule(_localctx, 40, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			expr();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(230);
				match(COMMA);
				setState(231);
				expr();
				}
				}
				setState(236);
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
		enterRule(_localctx, 42, RULE_arrayLiter);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(LBRA);
				setState(238);
				match(RBRA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(LBRA);
				setState(240);
				expr();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(241);
					match(COMMA);
					setState(242);
					expr();
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(248);
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_arrayElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			ident();
			setState(257); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(253);
				match(LBRA);
				setState(254);
				expr();
				setState(255);
				match(RBRA);
				}
				}
				setState(259); 
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
		enterRule(_localctx, 46, RULE_pairElem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(262);
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
		enterRule(_localctx, 48, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(BEGIN);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(265);
					func();
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(271);
			stats();
			setState(272);
			match(END);
			setState(273);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u0116\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\6\4?\n\4\r\4\16\4"+
		"@\3\5\3\5\3\5\5\5F\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\t\7\tV\n\t\f\t\16\tY\13\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13\n\3"+
		"\13\3\13\3\13\7\13f\n\13\f\13\16\13i\13\13\3\f\3\f\3\f\7\fn\n\f\f\f\16"+
		"\fq\13\f\3\r\3\r\3\r\7\rv\n\r\f\r\16\ry\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0088\n\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\21\3\21\3\21"+
		"\3\21\5\21\u0099\n\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00c0\n\22\3\23\3\23\3\23\7\23\u00c5\n\23\f\23\16\23\u00c8\13\23\5\23"+
		"\u00ca\n\23\3\24\3\24\3\24\5\24\u00cf\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u00e6\n\25\3\26\3\26\3\26\7\26\u00eb\n\26\f\26\16\26\u00ee"+
		"\13\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00f6\n\27\f\27\16\27\u00f9"+
		"\13\27\3\27\3\27\5\27\u00fd\n\27\3\30\3\30\3\30\3\30\3\30\6\30\u0104\n"+
		"\30\r\30\16\30\u0105\3\31\3\31\3\31\3\32\3\32\7\32\u010d\n\32\f\32\16"+
		"\32\u0110\13\32\3\32\3\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\2\5\3\2\33\34\3\2&*\3\2\f\r\2\u0125\2\64"+
		"\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bE\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2\16P\3"+
		"\2\2\2\20R\3\2\2\2\22Z\3\2\2\2\24b\3\2\2\2\26j\3\2\2\2\30r\3\2\2\2\32"+
		"\u0087\3\2\2\2\34\u0089\3\2\2\2\36\u008c\3\2\2\2 \u0094\3\2\2\2\"\u00bf"+
		"\3\2\2\2$\u00c9\3\2\2\2&\u00ce\3\2\2\2(\u00e5\3\2\2\2*\u00e7\3\2\2\2,"+
		"\u00fc\3\2\2\2.\u00fe\3\2\2\2\60\u0107\3\2\2\2\62\u010a\3\2\2\2\64\65"+
		"\7\63\2\2\65\3\3\2\2\2\66:\5\6\4\2\67:\5\n\6\28:\5\f\7\29\66\3\2\2\29"+
		"\67\3\2\2\298\3\2\2\2:\5\3\2\2\2;>\5\n\6\2<=\7\22\2\2=?\7\23\2\2><\3\2"+
		"\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\7\3\2\2\2BF\5\6\4\2CF\5\n\6\2DF\7"+
		",\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\t\3\2\2\2GH\7-\2\2H\13\3\2\2\2IJ"+
		"\7,\2\2JK\7\20\2\2KL\5\b\5\2LM\7\62\2\2MN\5\b\5\2NO\7\21\2\2O\r\3\2\2"+
		"\2PQ\t\2\2\2Q\17\3\2\2\2RW\5\22\n\2ST\7\7\2\2TV\5\22\n\2US\3\2\2\2VY\3"+
		"\2\2\2WU\3\2\2\2WX\3\2\2\2X\21\3\2\2\2YW\3\2\2\2Z_\5\24\13\2[\\\7\6\2"+
		"\2\\^\5\24\13\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\23\3\2\2\2a_"+
		"\3\2\2\2bg\5\26\f\2cd\7\5\2\2df\5\26\f\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2"+
		"gh\3\2\2\2h\25\3\2\2\2ig\3\2\2\2jo\5\30\r\2kl\7\4\2\2ln\5\30\r\2mk\3\2"+
		"\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\27\3\2\2\2qo\3\2\2\2rw\5\32\16\2s"+
		"t\7\3\2\2tv\5\32\16\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\31\3\2"+
		"\2\2yw\3\2\2\2z{\7\20\2\2{|\5\20\t\2|}\7\21\2\2}\u0088\3\2\2\2~\u0088"+
		"\7.\2\2\177\u0088\5\16\b\2\u0080\u0088\7\60\2\2\u0081\u0088\7/\2\2\u0082"+
		"\u0088\7\32\2\2\u0083\u0088\5\2\2\2\u0084\u0088\5.\30\2\u0085\u0086\7"+
		"\16\2\2\u0086\u0088\5\20\t\2\u0087z\3\2\2\2\u0087~\3\2\2\2\u0087\177\3"+
		"\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082\3\2\2\2\u0087"+
		"\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0088\33\3\2\2"+
		"\2\u0089\u008a\5\4\3\2\u008a\u008b\5\2\2\2\u008b\35\3\2\2\2\u008c\u0091"+
		"\5\34\17\2\u008d\u008e\7\62\2\2\u008e\u0090\5\34\17\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\37\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\5\4\3\2\u0095\u0096\5\2\2"+
		"\2\u0096\u0098\7\20\2\2\u0097\u0099\5\36\20\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\21\2\2\u009b\u009c\7"+
		"\30\2\2\u009c\u009d\5$\23\2\u009d\u009e\7\31\2\2\u009e!\3\2\2\2\u009f"+
		"\u00c0\7\17\2\2\u00a0\u00a1\5\4\3\2\u00a1\u00a2\5\2\2\2\u00a2\u00a3\7"+
		"\61\2\2\u00a3\u00a4\5(\25\2\u00a4\u00c0\3\2\2\2\u00a5\u00a6\5&\24\2\u00a6"+
		"\u00a7\7\61\2\2\u00a7\u00a8\5(\25\2\u00a8\u00c0\3\2\2\2\u00a9\u00aa\7"+
		"%\2\2\u00aa\u00c0\5(\25\2\u00ab\u00ac\t\3\2\2\u00ac\u00c0\5\20\t\2\u00ad"+
		"\u00ae\7\35\2\2\u00ae\u00af\5\20\t\2\u00af\u00b0\7\36\2\2\u00b0\u00b1"+
		"\5$\23\2\u00b1\u00b2\7\37\2\2\u00b2\u00b3\5$\23\2\u00b3\u00b4\7 \2\2\u00b4"+
		"\u00c0\3\2\2\2\u00b5\u00b6\7!\2\2\u00b6\u00b7\5\20\t\2\u00b7\u00b8\7\""+
		"\2\2\u00b8\u00b9\5$\23\2\u00b9\u00ba\7#\2\2\u00ba\u00c0\3\2\2\2\u00bb"+
		"\u00bc\7\27\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\7\31\2\2\u00be\u00c0\3"+
		"\2\2\2\u00bf\u009f\3\2\2\2\u00bf\u00a0\3\2\2\2\u00bf\u00a5\3\2\2\2\u00bf"+
		"\u00a9\3\2\2\2\u00bf\u00ab\3\2\2\2\u00bf\u00ad\3\2\2\2\u00bf\u00b5\3\2"+
		"\2\2\u00bf\u00bb\3\2\2\2\u00c0#\3\2\2\2\u00c1\u00c6\5\"\22\2\u00c2\u00c3"+
		"\7\26\2\2\u00c3\u00c5\5\"\22\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2"+
		"\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6"+
		"\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca%\3\2\2\2\u00cb"+
		"\u00cf\5\2\2\2\u00cc\u00cf\5.\30\2\u00cd\u00cf\5\60\31\2\u00ce\u00cb\3"+
		"\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\'\3\2\2\2\u00d0\u00e6"+
		"\5\20\t\2\u00d1\u00e6\5,\27\2\u00d2\u00d3\7$\2\2\u00d3\u00d4\7\20\2\2"+
		"\u00d4\u00d5\5\20\t\2\u00d5\u00d6\7\62\2\2\u00d6\u00d7\5\20\t\2\u00d7"+
		"\u00d8\7\21\2\2\u00d8\u00e6\3\2\2\2\u00d9\u00e6\5\60\31\2\u00da\u00db"+
		"\7+\2\2\u00db\u00dc\5\2\2\2\u00dc\u00dd\7\20\2\2\u00dd\u00de\7\21\2\2"+
		"\u00de\u00e6\3\2\2\2\u00df\u00e0\7+\2\2\u00e0\u00e1\5\2\2\2\u00e1\u00e2"+
		"\7\20\2\2\u00e2\u00e3\5*\26\2\u00e3\u00e4\7\21\2\2\u00e4\u00e6\3\2\2\2"+
		"\u00e5\u00d0\3\2\2\2\u00e5\u00d1\3\2\2\2\u00e5\u00d2\3\2\2\2\u00e5\u00d9"+
		"\3\2\2\2\u00e5\u00da\3\2\2\2\u00e5\u00df\3\2\2\2\u00e6)\3\2\2\2\u00e7"+
		"\u00ec\5\20\t\2\u00e8\u00e9\7\62\2\2\u00e9\u00eb\5\20\t\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"+\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\22\2\2\u00f0\u00fd\7\23\2"+
		"\2\u00f1\u00f2\7\22\2\2\u00f2\u00f7\5\20\t\2\u00f3\u00f4\7\62\2\2\u00f4"+
		"\u00f6\5\20\t\2\u00f5\u00f3\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3"+
		"\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\7\23\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00ef\3\2\2\2\u00fc\u00f1\3"+
		"\2\2\2\u00fd-\3\2\2\2\u00fe\u0103\5\2\2\2\u00ff\u0100\7\22\2\2\u0100\u0101"+
		"\5\20\t\2\u0101\u0102\7\23\2\2\u0102\u0104\3\2\2\2\u0103\u00ff\3\2\2\2"+
		"\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106/\3"+
		"\2\2\2\u0107\u0108\t\4\2\2\u0108\u0109\5\20\t\2\u0109\61\3\2\2\2\u010a"+
		"\u010e\7\27\2\2\u010b\u010d\5 \21\2\u010c\u010b\3\2\2\2\u010d\u0110\3"+
		"\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0112\5$\23\2\u0112\u0113\7\31\2\2\u0113\u0114\7"+
		"\2\2\3\u0114\63\3\2\2\2\279@EW_gow\u0087\u0091\u0098\u00bf\u00c6\u00c9"+
		"\u00ce\u00e5\u00ec\u00f7\u00fc\u0105\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}