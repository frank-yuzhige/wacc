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
		ADD=1, SUB=2, MUL=3, DIV=4, MOD=5, GTE=6, GT=7, LTE=8, LT=9, EQ=10, NEQ=11, 
		AND=12, OR=13, NOT=14, LEN=15, ORD=16, CHR=17, FST=18, SND=19, SKIP_STAT=20, 
		LPAR=21, RPAR=22, LBRA=23, RBRA=24, LCUR=25, RCUR=26, SEMICOLON=27, BEGIN=28, 
		IS=29, END=30, NULL=31, TRUE=32, FALSE=33, IF=34, THEN=35, ELSE=36, FI=37, 
		WHILE=38, DO=39, DONE=40, NEWPAIR=41, READ=42, FREE=43, RETURN=44, EXIT=45, 
		PRINT=46, PRINTLN=47, CALL=48, PAIR=49, BASE_TYPE=50, INTEGER=51, STRLIT=52, 
		CHARLIT=53, ASSIGN=54, COMMA=55, IDENT=56, COMMENT=57, WS=58;
	public static final int
		RULE_intsign = 0, RULE_integer = 1, RULE_ident = 2, RULE_type = 3, RULE_arrayType = 4, 
		RULE_pairElemType = 5, RULE_baseType = 6, RULE_pairType = 7, RULE_boolLit = 8, 
		RULE_unaryOp = 9, RULE_pairElemFunc = 10, RULE_binop1 = 11, RULE_binop2 = 12, 
		RULE_binop3 = 13, RULE_binop4 = 14, RULE_binop5 = 15, RULE_expr = 16, 
		RULE_param = 17, RULE_paramList = 18, RULE_func = 19, RULE_builtinFunc = 20, 
		RULE_stat = 21, RULE_stats = 22, RULE_assignLhs = 23, RULE_assignRhs = 24, 
		RULE_argList = 25, RULE_arrayLiter = 26, RULE_arrayElem = 27, RULE_pairElem = 28, 
		RULE_prog = 29;
	public static final String[] ruleNames = {
		"intsign", "integer", "ident", "type", "arrayType", "pairElemType", "baseType", 
		"pairType", "boolLit", "unaryOp", "pairElemFunc", "binop1", "binop2", 
		"binop3", "binop4", "binop5", "expr", "param", "paramList", "func", "builtinFunc", 
		"stat", "stats", "assignLhs", "assignRhs", "argList", "arrayLiter", "arrayElem", 
		"pairElem", "prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>='", "'>'", "'<='", "'<'", 
		"'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", "'fst'", 
		"'snd'", "'skip'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "'begin'", 
		"'is'", "'end'", "'null'", "'true'", "'false'", "'if'", "'then'", "'else'", 
		"'fi'", "'while'", "'do'", "'done'", "'newpair'", "'read'", "'free'", 
		"'return'", "'exit'", "'print'", "'println'", "'call'", "'pair'", null, 
		null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADD", "SUB", "MUL", "DIV", "MOD", "GTE", "GT", "LTE", "LT", "EQ", 
		"NEQ", "AND", "OR", "NOT", "LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", 
		"LPAR", "RPAR", "LBRA", "RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", 
		"IS", "END", "NULL", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", 
		"DO", "DONE", "NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
		"CALL", "PAIR", "BASE_TYPE", "INTEGER", "STRLIT", "CHARLIT", "ASSIGN", 
		"COMMA", "IDENT", "COMMENT", "WS"
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
	public static class IntsignContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(WaccParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(WaccParser.SUB, 0); }
		public IntsignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intsign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitIntsign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntsignContext intsign() throws RecognitionException {
		IntsignContext _localctx = new IntsignContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_intsign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(WaccParser.INTEGER, 0); }
		public IntsignContext intsign() {
			return getRuleContext(IntsignContext.class,0);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(62);
				intsign();
				}
			}

			setState(65);
			match(INTEGER);
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
		enterRule(_localctx, 4, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
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
		public PairTypeContext pairType() {
			return getRuleContext(PairTypeContext.class,0);
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
		enterRule(_localctx, 8, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				setState(74);
				baseType();
				}
				break;
			case PAIR:
				{
				setState(75);
				pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				match(LBRA);
				setState(79);
				match(RBRA);
				}
				}
				setState(82); 
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
		enterRule(_localctx, 10, RULE_pairElemType);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
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
		enterRule(_localctx, 12, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
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
		public PairElemTypeContext first;
		public PairElemTypeContext second;
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
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
		enterRule(_localctx, 14, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(PAIR);
			setState(92);
			match(LPAR);
			setState(93);
			((PairTypeContext)_localctx).first = pairElemType();
			setState(94);
			match(COMMA);
			setState(95);
			((PairTypeContext)_localctx).second = pairElemType();
			setState(96);
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
		enterRule(_localctx, 16, RULE_boolLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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

	public static class UnaryOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(WaccParser.NOT, 0); }
		public TerminalNode LEN() { return getToken(WaccParser.LEN, 0); }
		public TerminalNode ORD() { return getToken(WaccParser.ORD, 0); }
		public TerminalNode CHR() { return getToken(WaccParser.CHR, 0); }
		public TerminalNode SUB() { return getToken(WaccParser.SUB, 0); }
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
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

	public static class PairElemFuncContext extends ParserRuleContext {
		public TerminalNode FST() { return getToken(WaccParser.FST, 0); }
		public TerminalNode SND() { return getToken(WaccParser.SND, 0); }
		public PairElemFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemFunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPairElemFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemFuncContext pairElemFunc() throws RecognitionException {
		PairElemFuncContext _localctx = new PairElemFuncContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pairElemFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
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

	public static class Binop1Context extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(WaccParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(WaccParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(WaccParser.MOD, 0); }
		public Binop1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop1Context binop1() throws RecognitionException {
		Binop1Context _localctx = new Binop1Context(_ctx, getState());
		enterRule(_localctx, 22, RULE_binop1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
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

	public static class Binop2Context extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(WaccParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(WaccParser.SUB, 0); }
		public Binop2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop2Context binop2() throws RecognitionException {
		Binop2Context _localctx = new Binop2Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_binop2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
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

	public static class Binop3Context extends ParserRuleContext {
		public TerminalNode LTE() { return getToken(WaccParser.LTE, 0); }
		public TerminalNode LT() { return getToken(WaccParser.LT, 0); }
		public TerminalNode GTE() { return getToken(WaccParser.GTE, 0); }
		public TerminalNode GT() { return getToken(WaccParser.GT, 0); }
		public Binop3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop3Context binop3() throws RecognitionException {
		Binop3Context _localctx = new Binop3Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_binop3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTE) | (1L << GT) | (1L << LTE) | (1L << LT))) != 0)) ) {
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

	public static class Binop4Context extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(WaccParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(WaccParser.NEQ, 0); }
		public Binop4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop4Context binop4() throws RecognitionException {
		Binop4Context _localctx = new Binop4Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_binop4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
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

	public static class Binop5Context extends ParserRuleContext {
		public TerminalNode AND() { return getToken(WaccParser.AND, 0); }
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public Binop5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop5Context binop5() throws RecognitionException {
		Binop5Context _localctx = new Binop5Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_binop5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprIntContext extends ExprContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public ExprIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNullContext extends ExprContext {
		public TerminalNode NULL() { return getToken(WaccParser.NULL, 0); }
		public ExprNullContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBinopContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public Binop1Context binop1() {
			return getRuleContext(Binop1Context.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Binop2Context binop2() {
			return getRuleContext(Binop2Context.class,0);
		}
		public Binop3Context binop3() {
			return getRuleContext(Binop3Context.class,0);
		}
		public Binop4Context binop4() {
			return getRuleContext(Binop4Context.class,0);
		}
		public Binop5Context binop5() {
			return getRuleContext(Binop5Context.class,0);
		}
		public ExprBinopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStringContext extends ExprContext {
		public TerminalNode STRLIT() { return getToken(WaccParser.STRLIT, 0); }
		public ExprStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprBoolContext extends ExprContext {
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public ExprBoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrElemContext extends ExprContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public ExprArrElemContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprArrElem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParensContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ExprParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIdentContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprIdentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprUnaryopContext extends ExprContext {
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnaryopContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCharContext extends ExprContext {
		public TerminalNode CHARLIT() { return getToken(WaccParser.CHARLIT, 0); }
		public ExprCharContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(115);
				match(LPAR);
				setState(116);
				expr(0);
				setState(117);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				integer();
				}
				break;
			case 3:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				boolLit();
				}
				break;
			case 4:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(CHARLIT);
				}
				break;
			case 5:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(STRLIT);
				}
				break;
			case 6:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(NULL);
				}
				break;
			case 7:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				ident();
				}
				break;
			case 8:
				{
				_localctx = new ExprUnaryopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				unaryOp();
				setState(126);
				expr(2);
				}
				break;
			case 9:
				{
				_localctx = new ExprArrElemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				arrayElem();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(151);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(132);
						binop1();
						setState(133);
						((ExprBinopContext)_localctx).right = expr(15);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(136);
						binop2();
						setState(137);
						((ExprBinopContext)_localctx).right = expr(14);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(140);
						binop3();
						setState(141);
						((ExprBinopContext)_localctx).right = expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(144);
						binop4();
						setState(145);
						((ExprBinopContext)_localctx).right = expr(12);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(148);
						binop5();
						setState(149);
						((ExprBinopContext)_localctx).right = expr(11);
						}
						break;
					}
					} 
				}
				setState(155);
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
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 34, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			type();
			setState(157);
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
		enterRule(_localctx, 36, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			param();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(160);
				match(COMMA);
				setState(161);
				param();
				}
				}
				setState(166);
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
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
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
		enterRule(_localctx, 38, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			type();
			setState(168);
			ident();
			setState(169);
			match(LPAR);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PAIR || _la==BASE_TYPE) {
				{
				setState(170);
				paramList();
				}
			}

			setState(173);
			match(RPAR);
			setState(174);
			match(IS);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
				{
				setState(175);
				stats();
				}
			}

			setState(178);
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

	public static class BuiltinFuncContext extends ParserRuleContext {
		public TerminalNode FREE() { return getToken(WaccParser.FREE, 0); }
		public TerminalNode RETURN() { return getToken(WaccParser.RETURN, 0); }
		public TerminalNode EXIT() { return getToken(WaccParser.EXIT, 0); }
		public TerminalNode PRINT() { return getToken(WaccParser.PRINT, 0); }
		public TerminalNode PRINTLN() { return getToken(WaccParser.PRINTLN, 0); }
		public BuiltinFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBuiltinFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinFuncContext builtinFunc() throws RecognitionException {
		BuiltinFuncContext _localctx = new BuiltinFuncContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_builtinFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileLoopContext extends StatContext {
		public TerminalNode WHILE() { return getToken(WaccParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public WhileLoopContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BuiltinFuncCallContext extends StatContext {
		public BuiltinFuncContext builtinFunc() {
			return getRuleContext(BuiltinFuncContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BuiltinFuncCallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBuiltinFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondBranchContext extends StatContext {
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public CondBranchContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCondBranch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentContext extends StatContext {
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public AssignmentContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadCallContext extends StatContext {
		public TerminalNode READ() { return getToken(WaccParser.READ, 0); }
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public ReadCallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitReadCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends StatContext {
		public TerminalNode SKIP_STAT() { return getToken(WaccParser.SKIP_STAT, 0); }
		public SkipContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public BlockContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationContext extends StatContext {
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
		public DeclarationContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_stat);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(SKIP_STAT);
				}
				break;
			case PAIR:
			case BASE_TYPE:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				type();
				setState(184);
				ident();
				setState(185);
				match(ASSIGN);
				setState(186);
				assignRhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				assignLhs();
				setState(189);
				match(ASSIGN);
				setState(190);
				assignRhs();
				}
				break;
			case READ:
				_localctx = new ReadCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(READ);
				setState(193);
				assignLhs();
				}
				break;
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
				_localctx = new BuiltinFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				builtinFunc();
				setState(195);
				expr(0);
				}
				break;
			case IF:
				_localctx = new CondBranchContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(197);
				match(IF);
				setState(198);
				expr(0);
				setState(199);
				match(THEN);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
					{
					setState(200);
					stats();
					}
				}

				setState(203);
				match(ELSE);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
					{
					setState(204);
					stats();
					}
				}

				setState(207);
				match(FI);
				}
				break;
			case WHILE:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				match(WHILE);
				setState(210);
				expr(0);
				setState(211);
				match(DO);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
					{
					setState(212);
					stats();
					}
				}

				setState(215);
				match(DONE);
				}
				break;
			case BEGIN:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(217);
				match(BEGIN);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
					{
					setState(218);
					stats();
					}
				}

				setState(221);
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
		enterRule(_localctx, 44, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			stat();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(225);
				match(SEMICOLON);
				setState(226);
				stat();
				}
				}
				setState(231);
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
		enterRule(_localctx, 46, RULE_assignLhs);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
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
		public AssignRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRhs; }
	 
		public AssignRhsContext() { }
		public void copyFrom(AssignRhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RhsFuncCallContext extends AssignRhsContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public RhsFuncCallContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsArrayLiterContext extends AssignRhsContext {
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public RhsArrayLiterContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsArrayLiter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsExprContext extends AssignRhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RhsExprContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsNewPairContext extends AssignRhsContext {
		public TerminalNode NEWPAIR() { return getToken(WaccParser.NEWPAIR, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public RhsNewPairContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsNewPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RhsPairElemContext extends AssignRhsContext {
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public RhsPairElemContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRhsContext assignRhs() throws RecognitionException {
		AssignRhsContext _localctx = new AssignRhsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignRhs);
		int _la;
		try {
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case NOT:
			case LEN:
			case ORD:
			case CHR:
			case LPAR:
			case NULL:
			case TRUE:
			case FALSE:
			case INTEGER:
			case STRLIT:
			case CHARLIT:
			case IDENT:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				expr(0);
				}
				break;
			case LBRA:
				_localctx = new RhsArrayLiterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				arrayLiter();
				}
				break;
			case NEWPAIR:
				_localctx = new RhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(NEWPAIR);
				setState(240);
				match(LPAR);
				setState(241);
				expr(0);
				setState(242);
				match(COMMA);
				setState(243);
				expr(0);
				setState(244);
				match(RPAR);
				}
				break;
			case FST:
			case SND:
				_localctx = new RhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				pairElem();
				}
				break;
			case CALL:
				_localctx = new RhsFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
				match(CALL);
				setState(248);
				ident();
				setState(249);
				match(LPAR);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRLIT) | (1L << CHARLIT) | (1L << IDENT))) != 0)) {
					{
					setState(250);
					argList();
					}
				}

				setState(253);
				match(RPAR);
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
		enterRule(_localctx, 50, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			expr(0);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(258);
				match(COMMA);
				setState(259);
				expr(0);
				}
				}
				setState(264);
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
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
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
		enterRule(_localctx, 52, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(LBRA);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << INTEGER) | (1L << STRLIT) | (1L << CHARLIT) | (1L << IDENT))) != 0)) {
				{
				setState(266);
				argList();
				}
			}

			setState(269);
			match(RBRA);
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
		enterRule(_localctx, 54, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			ident();
			setState(276); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(272);
					match(LBRA);
					setState(273);
					expr(0);
					setState(274);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public PairElemFuncContext pairElemFunc() {
			return getRuleContext(PairElemFuncContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 56, RULE_pairElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			pairElemFunc();
			setState(281);
			expr(0);
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
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
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
		enterRule(_localctx, 58, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(BEGIN);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(284);
					func();
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << BEGIN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << BASE_TYPE) | (1L << IDENT))) != 0)) {
				{
				setState(290);
				stats();
				}
			}

			setState(293);
			match(END);
			setState(294);
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
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\5\3B\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\5\5K\n\5\3\6\3\6\5\6O\n\6\3\6"+
		"\3\6\6\6S\n\6\r\6\16\6T\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u0084\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u009a\n\22\f\22\16\22\u009d\13\22\3\23\3\23\3\23\3\24\3\24\3\24\7\24"+
		"\u00a5\n\24\f\24\16\24\u00a8\13\24\3\25\3\25\3\25\3\25\5\25\u00ae\n\25"+
		"\3\25\3\25\3\25\5\25\u00b3\n\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00cc\n\27\3\27\3\27\5\27\u00d0\n\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\5\27\u00d8\n\27\3\27\3\27\3\27\3\27\5\27\u00de\n\27\3\27\5\27"+
		"\u00e1\n\27\3\30\3\30\3\30\7\30\u00e6\n\30\f\30\16\30\u00e9\13\30\3\31"+
		"\3\31\3\31\5\31\u00ee\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u00fe\n\32\3\32\3\32\5\32\u0102\n\32\3"+
		"\33\3\33\3\33\7\33\u0107\n\33\f\33\16\33\u010a\13\33\3\34\3\34\5\34\u010e"+
		"\n\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\6\35\u0117\n\35\r\35\16\35\u0118"+
		"\3\36\3\36\3\36\3\37\3\37\7\37\u0120\n\37\f\37\16\37\u0123\13\37\3\37"+
		"\5\37\u0126\n\37\3\37\3\37\3\37\3\37\2\3\" \2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\13\3\2\3\4\3\2\"#\4\2\4\4\20\23"+
		"\3\2\24\25\3\2\5\7\3\2\b\13\3\2\f\r\3\2\16\17\3\2-\61\2\u013b\2>\3\2\2"+
		"\2\4A\3\2\2\2\6E\3\2\2\2\bJ\3\2\2\2\nN\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2"+
		"\20]\3\2\2\2\22d\3\2\2\2\24f\3\2\2\2\26h\3\2\2\2\30j\3\2\2\2\32l\3\2\2"+
		"\2\34n\3\2\2\2\36p\3\2\2\2 r\3\2\2\2\"\u0083\3\2\2\2$\u009e\3\2\2\2&\u00a1"+
		"\3\2\2\2(\u00a9\3\2\2\2*\u00b6\3\2\2\2,\u00e0\3\2\2\2.\u00e2\3\2\2\2\60"+
		"\u00ed\3\2\2\2\62\u0101\3\2\2\2\64\u0103\3\2\2\2\66\u010b\3\2\2\28\u0111"+
		"\3\2\2\2:\u011a\3\2\2\2<\u011d\3\2\2\2>?\t\2\2\2?\3\3\2\2\2@B\5\2\2\2"+
		"A@\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\65\2\2D\5\3\2\2\2EF\7:\2\2F\7\3\2\2"+
		"\2GK\5\n\6\2HK\5\16\b\2IK\5\20\t\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2K\t\3"+
		"\2\2\2LO\5\16\b\2MO\5\20\t\2NL\3\2\2\2NM\3\2\2\2OR\3\2\2\2PQ\7\31\2\2"+
		"QS\7\32\2\2RP\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VZ\5\n"+
		"\6\2WZ\5\16\b\2XZ\7\63\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\r\3\2\2\2[\\"+
		"\7\64\2\2\\\17\3\2\2\2]^\7\63\2\2^_\7\27\2\2_`\5\f\7\2`a\79\2\2ab\5\f"+
		"\7\2bc\7\30\2\2c\21\3\2\2\2de\t\3\2\2e\23\3\2\2\2fg\t\4\2\2g\25\3\2\2"+
		"\2hi\t\5\2\2i\27\3\2\2\2jk\t\6\2\2k\31\3\2\2\2lm\t\2\2\2m\33\3\2\2\2n"+
		"o\t\7\2\2o\35\3\2\2\2pq\t\b\2\2q\37\3\2\2\2rs\t\t\2\2s!\3\2\2\2tu\b\22"+
		"\1\2uv\7\27\2\2vw\5\"\22\2wx\7\30\2\2x\u0084\3\2\2\2y\u0084\5\4\3\2z\u0084"+
		"\5\22\n\2{\u0084\7\67\2\2|\u0084\7\66\2\2}\u0084\7!\2\2~\u0084\5\6\4\2"+
		"\177\u0080\5\24\13\2\u0080\u0081\5\"\22\4\u0081\u0084\3\2\2\2\u0082\u0084"+
		"\58\35\2\u0083t\3\2\2\2\u0083y\3\2\2\2\u0083z\3\2\2\2\u0083{\3\2\2\2\u0083"+
		"|\3\2\2\2\u0083}\3\2\2\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0082"+
		"\3\2\2\2\u0084\u009b\3\2\2\2\u0085\u0086\f\20\2\2\u0086\u0087\5\30\r\2"+
		"\u0087\u0088\5\"\22\21\u0088\u009a\3\2\2\2\u0089\u008a\f\17\2\2\u008a"+
		"\u008b\5\32\16\2\u008b\u008c\5\"\22\20\u008c\u009a\3\2\2\2\u008d\u008e"+
		"\f\16\2\2\u008e\u008f\5\34\17\2\u008f\u0090\5\"\22\17\u0090\u009a\3\2"+
		"\2\2\u0091\u0092\f\r\2\2\u0092\u0093\5\36\20\2\u0093\u0094\5\"\22\16\u0094"+
		"\u009a\3\2\2\2\u0095\u0096\f\f\2\2\u0096\u0097\5 \21\2\u0097\u0098\5\""+
		"\22\r\u0098\u009a\3\2\2\2\u0099\u0085\3\2\2\2\u0099\u0089\3\2\2\2\u0099"+
		"\u008d\3\2\2\2\u0099\u0091\3\2\2\2\u0099\u0095\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c#\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u009f\5\b\5\2\u009f\u00a0\5\6\4\2\u00a0%\3\2\2\2\u00a1"+
		"\u00a6\5$\23\2\u00a2\u00a3\79\2\2\u00a3\u00a5\5$\23\2\u00a4\u00a2\3\2"+
		"\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\'\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\5\b\5\2\u00aa\u00ab\5\6\4\2"+
		"\u00ab\u00ad\7\27\2\2\u00ac\u00ae\5&\24\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\30\2\2\u00b0\u00b2\7\37\2\2"+
		"\u00b1\u00b3\5.\30\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\7 \2\2\u00b5)\3\2\2\2\u00b6\u00b7\t\n\2\2\u00b7+"+
		"\3\2\2\2\u00b8\u00e1\7\26\2\2\u00b9\u00ba\5\b\5\2\u00ba\u00bb\5\6\4\2"+
		"\u00bb\u00bc\78\2\2\u00bc\u00bd\5\62\32\2\u00bd\u00e1\3\2\2\2\u00be\u00bf"+
		"\5\60\31\2\u00bf\u00c0\78\2\2\u00c0\u00c1\5\62\32\2\u00c1\u00e1\3\2\2"+
		"\2\u00c2\u00c3\7,\2\2\u00c3\u00e1\5\60\31\2\u00c4\u00c5\5*\26\2\u00c5"+
		"\u00c6\5\"\22\2\u00c6\u00e1\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8\u00c9\5\""+
		"\22\2\u00c9\u00cb\7%\2\2\u00ca\u00cc\5.\30\2\u00cb\u00ca\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\7&\2\2\u00ce\u00d0\5.\30"+
		"\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2"+
		"\7\'\2\2\u00d2\u00e1\3\2\2\2\u00d3\u00d4\7(\2\2\u00d4\u00d5\5\"\22\2\u00d5"+
		"\u00d7\7)\2\2\u00d6\u00d8\5.\30\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7*\2\2\u00da\u00e1\3\2\2\2\u00db"+
		"\u00dd\7\36\2\2\u00dc\u00de\5.\30\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\7 \2\2\u00e0\u00b8\3\2\2\2\u00e0"+
		"\u00b9\3\2\2\2\u00e0\u00be\3\2\2\2\u00e0\u00c2\3\2\2\2\u00e0\u00c4\3\2"+
		"\2\2\u00e0\u00c7\3\2\2\2\u00e0\u00d3\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1"+
		"-\3\2\2\2\u00e2\u00e7\5,\27\2\u00e3\u00e4\7\35\2\2\u00e4\u00e6\5,\27\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8/\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ee\5\6\4\2\u00eb"+
		"\u00ee\58\35\2\u00ec\u00ee\5:\36\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2"+
		"\2\2\u00ed\u00ec\3\2\2\2\u00ee\61\3\2\2\2\u00ef\u0102\5\"\22\2\u00f0\u0102"+
		"\5\66\34\2\u00f1\u00f2\7+\2\2\u00f2\u00f3\7\27\2\2\u00f3\u00f4\5\"\22"+
		"\2\u00f4\u00f5\79\2\2\u00f5\u00f6\5\"\22\2\u00f6\u00f7\7\30\2\2\u00f7"+
		"\u0102\3\2\2\2\u00f8\u0102\5:\36\2\u00f9\u00fa\7\62\2\2\u00fa\u00fb\5"+
		"\6\4\2\u00fb\u00fd\7\27\2\2\u00fc\u00fe\5\64\33\2\u00fd\u00fc\3\2\2\2"+
		"\u00fd\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7\30\2\2\u0100\u0102"+
		"\3\2\2\2\u0101\u00ef\3\2\2\2\u0101\u00f0\3\2\2\2\u0101\u00f1\3\2\2\2\u0101"+
		"\u00f8\3\2\2\2\u0101\u00f9\3\2\2\2\u0102\63\3\2\2\2\u0103\u0108\5\"\22"+
		"\2\u0104\u0105\79\2\2\u0105\u0107\5\"\22\2\u0106\u0104\3\2\2\2\u0107\u010a"+
		"\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\65\3\2\2\2\u010a"+
		"\u0108\3\2\2\2\u010b\u010d\7\31\2\2\u010c\u010e\5\64\33\2\u010d\u010c"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\7\32\2\2"+
		"\u0110\67\3\2\2\2\u0111\u0116\5\6\4\2\u0112\u0113\7\31\2\2\u0113\u0114"+
		"\5\"\22\2\u0114\u0115\7\32\2\2\u0115\u0117\3\2\2\2\u0116\u0112\3\2\2\2"+
		"\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u01199\3"+
		"\2\2\2\u011a\u011b\5\26\f\2\u011b\u011c\5\"\22\2\u011c;\3\2\2\2\u011d"+
		"\u0121\7\36\2\2\u011e\u0120\5(\25\2\u011f\u011e\3\2\2\2\u0120\u0123\3"+
		"\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0126\5.\30\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127\u0128\7 \2\2\u0128\u0129\7\2\2\3\u0129"+
		"=\3\2\2\2\33AJNTY\u0083\u0099\u009b\u00a6\u00ad\u00b2\u00cb\u00cf\u00d7"+
		"\u00dd\u00e0\u00e7\u00ed\u00fd\u0101\u0108\u010d\u0118\u0121\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}