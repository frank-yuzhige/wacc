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
		ARROW=1, DOUBLE_ARROW=2, COLON=3, DOT=4, ADD=5, SUB=6, MUL=7, DIV=8, MOD=9, 
		GTE=10, GT=11, LTE=12, LT=13, EQ=14, NEQ=15, AND=16, OR=17, DOTDOT=18, 
		NOT=19, LEN=20, ORD=21, CHR=22, FST=23, SND=24, SKIP_STAT=25, LPAR=26, 
		RPAR=27, LBRA=28, RBRA=29, LCUR=30, RCUR=31, SEMICOLON=32, BEGIN=33, IS=34, 
		END=35, NULL=36, TRUE=37, FALSE=38, IF=39, THEN=40, ELSE=41, FI=42, WHILE=43, 
		FOR=44, IN=45, DO=46, DONE=47, NEWPAIR=48, READ=49, FREE=50, RETURN=51, 
		EXIT=52, PRINT=53, PRINTLN=54, CALL=55, PAIR=56, VAR=57, CONST=58, NEWTYPE=59, 
		UNION=60, OF=61, WHEN=62, WHERE=63, FORALL=64, TRAIT=65, REQUIRED=66, 
		BASE_TYPE=67, INTEGER=68, STRLIT=69, CHARLIT=70, ASSIGN=71, COMMA=72, 
		IDENT=73, CAP_IDENT=74, COMMENT=75, WS=76;
	public static final int
		RULE_intsign = 0, RULE_integer = 1, RULE_ident = 2, RULE_capIdent = 3, 
		RULE_boolLit = 4, RULE_type = 5, RULE_arrayType = 6, RULE_pairElemType = 7, 
		RULE_baseType = 8, RULE_pairType = 9, RULE_generics = 10, RULE_member = 11, 
		RULE_newtype = 12, RULE_genericTVars = 13, RULE_structType = 14, RULE_unionEntry = 15, 
		RULE_taggedUnion = 16, RULE_enumRange = 17, RULE_unaryOp = 18, RULE_pairElemFunc = 19, 
		RULE_binop1 = 20, RULE_binop2 = 21, RULE_binop3 = 22, RULE_binop4 = 23, 
		RULE_binop5 = 24, RULE_binop6 = 25, RULE_expr = 26, RULE_param = 27, RULE_paramList = 28, 
		RULE_constraint = 29, RULE_forallConstraint = 30, RULE_constraintList = 31, 
		RULE_func = 32, RULE_requiredFunc = 33, RULE_traitDef = 34, RULE_builtinFunc = 35, 
		RULE_stat = 36, RULE_pattern = 37, RULE_whenCase = 38, RULE_stats = 39, 
		RULE_assignLhs = 40, RULE_assignRhs = 41, RULE_argList = 42, RULE_arrayLiter = 43, 
		RULE_arrayElem = 44, RULE_pairElem = 45, RULE_typeMember = 46, RULE_typeConstructor = 47, 
		RULE_prog = 48;
	public static final String[] ruleNames = {
		"intsign", "integer", "ident", "capIdent", "boolLit", "type", "arrayType", 
		"pairElemType", "baseType", "pairType", "generics", "member", "newtype", 
		"genericTVars", "structType", "unionEntry", "taggedUnion", "enumRange", 
		"unaryOp", "pairElemFunc", "binop1", "binop2", "binop3", "binop4", "binop5", 
		"binop6", "expr", "param", "paramList", "constraint", "forallConstraint", 
		"constraintList", "func", "requiredFunc", "traitDef", "builtinFunc", "stat", 
		"pattern", "whenCase", "stats", "assignLhs", "assignRhs", "argList", "arrayLiter", 
		"arrayElem", "pairElem", "typeMember", "typeConstructor", "prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'->'", "'=>'", "':'", "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'>='", "'>'", "'<='", "'<'", "'=='", "'!='", "'&&'", "'||'", "'..'", 
		"'!'", "'len'", "'ord'", "'chr'", "'fst'", "'snd'", "'skip'", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "'begin'", "'is'", "'end'", "'null'", 
		"'true'", "'false'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'for'", 
		"'in'", "'do'", "'done'", "'newpair'", "'read'", "'free'", "'return'", 
		"'exit'", "'print'", "'println'", "'call'", "'pair'", "'var'", "'const'", 
		"'newtype'", "'union'", "'of'", "'when'", "'where'", "'forall'", "'trait'", 
		"'required'", null, null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ARROW", "DOUBLE_ARROW", "COLON", "DOT", "ADD", "SUB", "MUL", "DIV", 
		"MOD", "GTE", "GT", "LTE", "LT", "EQ", "NEQ", "AND", "OR", "DOTDOT", "NOT", 
		"LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
		"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
		"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "FOR", "IN", "DO", "DONE", 
		"NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", 
		"PAIR", "VAR", "CONST", "NEWTYPE", "UNION", "OF", "WHEN", "WHERE", "FORALL", 
		"TRAIT", "REQUIRED", "BASE_TYPE", "INTEGER", "STRLIT", "CHARLIT", "ASSIGN", 
		"COMMA", "IDENT", "CAP_IDENT", "COMMENT", "WS"
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
			setState(98);
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(100);
				intsign();
				}
			}

			setState(103);
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
			setState(105);
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

	public static class CapIdentContext extends ParserRuleContext {
		public TerminalNode CAP_IDENT() { return getToken(WaccParser.CAP_IDENT, 0); }
		public CapIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capIdent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitCapIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CapIdentContext capIdent() throws RecognitionException {
		CapIdentContext _localctx = new CapIdentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_capIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(CAP_IDENT);
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
		enterRule(_localctx, 8, RULE_boolLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
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
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public GenericsContext generics() {
			return getRuleContext(GenericsContext.class,0);
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
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				pairType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				capIdent();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(115);
					generics();
					}
				}

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
		enterRule(_localctx, 12, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				setState(120);
				baseType();
				}
				break;
			case PAIR:
				{
				setState(121);
				pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				match(LBRA);
				setState(125);
				match(RBRA);
				}
				}
				setState(128); 
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
		enterRule(_localctx, 14, RULE_pairElemType);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
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
		enterRule(_localctx, 16, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
		enterRule(_localctx, 18, RULE_pairType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(PAIR);
			setState(138);
			match(LPAR);
			setState(139);
			((PairTypeContext)_localctx).first = pairElemType();
			setState(140);
			match(COMMA);
			setState(141);
			((PairTypeContext)_localctx).second = pairElemType();
			setState(142);
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

	public static class GenericsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(WaccParser.LT, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode GT() { return getToken(WaccParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public GenericsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generics; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitGenerics(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericsContext generics() throws RecognitionException {
		GenericsContext _localctx = new GenericsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_generics);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(LT);
			setState(145);
			type();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(146);
				match(COMMA);
				setState(147);
				type();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(GT);
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

	public static class MemberContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_member);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			type();
			setState(156);
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

	public static class NewtypeContext extends ParserRuleContext {
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public TaggedUnionContext taggedUnion() {
			return getRuleContext(TaggedUnionContext.class,0);
		}
		public NewtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNewtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewtypeContext newtype() throws RecognitionException {
		NewtypeContext _localctx = new NewtypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_newtype);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				structType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				taggedUnion();
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

	public static class GenericTVarsContext extends ParserRuleContext {
		public CapIdentContext tvar;
		public TerminalNode LT() { return getToken(WaccParser.LT, 0); }
		public TerminalNode GT() { return getToken(WaccParser.GT, 0); }
		public List<CapIdentContext> capIdent() {
			return getRuleContexts(CapIdentContext.class);
		}
		public CapIdentContext capIdent(int i) {
			return getRuleContext(CapIdentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public GenericTVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericTVars; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitGenericTVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericTVarsContext genericTVars() throws RecognitionException {
		GenericTVarsContext _localctx = new GenericTVarsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_genericTVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LT);
			setState(163);
			((GenericTVarsContext)_localctx).tvar = capIdent();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(164);
				match(COMMA);
				setState(165);
				((GenericTVarsContext)_localctx).tvar = capIdent();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			match(GT);
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

	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode NEWTYPE() { return getToken(WaccParser.NEWTYPE, 0); }
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public GenericTVarsContext genericTVars() {
			return getRuleContext(GenericTVarsContext.class,0);
		}
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(WaccParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(WaccParser.SEMICOLON, i);
		}
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(NEWTYPE);
			setState(174);
			capIdent();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(175);
				genericTVars();
				}
			}

			setState(178);
			match(IS);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(179);
				member();
				setState(180);
				match(SEMICOLON);
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
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

	public static class UnionEntryContext extends ParserRuleContext {
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode OF() { return getToken(WaccParser.OF, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public UnionEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitUnionEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionEntryContext unionEntry() throws RecognitionException {
		UnionEntryContext _localctx = new UnionEntryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unionEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			capIdent();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(190);
				match(OF);
				setState(191);
				match(LPAR);
				setState(192);
				member();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(193);
					match(COMMA);
					setState(194);
					member();
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(RPAR);
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

	public static class TaggedUnionContext extends ParserRuleContext {
		public TerminalNode NEWTYPE() { return getToken(WaccParser.NEWTYPE, 0); }
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode UNION() { return getToken(WaccParser.UNION, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public GenericTVarsContext genericTVars() {
			return getRuleContext(GenericTVarsContext.class,0);
		}
		public List<UnionEntryContext> unionEntry() {
			return getRuleContexts(UnionEntryContext.class);
		}
		public UnionEntryContext unionEntry(int i) {
			return getRuleContext(UnionEntryContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(WaccParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(WaccParser.SEMICOLON, i);
		}
		public TaggedUnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taggedUnion; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitTaggedUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaggedUnionContext taggedUnion() throws RecognitionException {
		TaggedUnionContext _localctx = new TaggedUnionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_taggedUnion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(NEWTYPE);
			setState(205);
			capIdent();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(206);
				genericTVars();
				}
			}

			setState(209);
			match(IS);
			setState(210);
			match(UNION);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAP_IDENT) {
				{
				{
				setState(211);
				unionEntry();
				setState(212);
				match(SEMICOLON);
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
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

	public static class EnumRangeContext extends ParserRuleContext {
		public EnumRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumRange; }
	 
		public EnumRangeContext() { }
		public void copyFrom(EnumRangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RangeFromThenToContext extends EnumRangeContext {
		public ExprContext from;
		public ExprContext then;
		public ExprContext to;
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode DOTDOT() { return getToken(WaccParser.DOTDOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RangeFromThenToContext(EnumRangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRangeFromThenTo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RangeFromToContext extends EnumRangeContext {
		public ExprContext from;
		public ExprContext to;
		public TerminalNode DOTDOT() { return getToken(WaccParser.DOTDOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RangeFromToContext(EnumRangeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRangeFromTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumRangeContext enumRange() throws RecognitionException {
		EnumRangeContext _localctx = new EnumRangeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_enumRange);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new RangeFromToContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				((RangeFromToContext)_localctx).from = expr(0);
				setState(222);
				match(DOTDOT);
				setState(223);
				((RangeFromToContext)_localctx).to = expr(0);
				}
				break;
			case 2:
				_localctx = new RangeFromThenToContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				((RangeFromThenToContext)_localctx).from = expr(0);
				setState(226);
				match(COMMA);
				setState(227);
				((RangeFromThenToContext)_localctx).then = expr(0);
				setState(228);
				match(DOTDOT);
				setState(229);
				((RangeFromThenToContext)_localctx).to = expr(0);
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
		enterRule(_localctx, 36, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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
		enterRule(_localctx, 38, RULE_pairElemFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		enterRule(_localctx, 40, RULE_binop1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
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
		enterRule(_localctx, 42, RULE_binop2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
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
		enterRule(_localctx, 44, RULE_binop3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
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
		enterRule(_localctx, 46, RULE_binop4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
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
		enterRule(_localctx, 48, RULE_binop5);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(AND);
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

	public static class Binop6Context extends ParserRuleContext {
		public TerminalNode OR() { return getToken(WaccParser.OR, 0); }
		public Binop6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop6; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitBinop6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binop6Context binop6() throws RecognitionException {
		Binop6Context _localctx = new Binop6Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_binop6);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(OR);
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
		public Binop6Context binop6() {
			return getRuleContext(Binop6Context.class,0);
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
	public static class ExprIfContext extends ExprContext {
		public ExprContext cond;
		public ExprContext tr;
		public ExprContext fl;
		public TerminalNode IF() { return getToken(WaccParser.IF, 0); }
		public TerminalNode THEN() { return getToken(WaccParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(WaccParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprIfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprIf(this);
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
	public static class ExprFuncCallContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ExprFuncCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprFuncCall(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(250);
				match(LPAR);
				setState(251);
				expr(0);
				setState(252);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				ident();
				setState(255);
				match(LPAR);
				setState(256);
				argList();
				setState(257);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExprIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(259);
				match(IF);
				setState(260);
				((ExprIfContext)_localctx).cond = expr(0);
				setState(261);
				match(THEN);
				setState(262);
				((ExprIfContext)_localctx).tr = expr(0);
				setState(263);
				match(ELSE);
				setState(264);
				((ExprIfContext)_localctx).fl = expr(0);
				setState(265);
				match(FI);
				}
				break;
			case 4:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				integer();
				}
				break;
			case 5:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				boolLit();
				}
				break;
			case 6:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				match(CHARLIT);
				}
				break;
			case 7:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(STRLIT);
				}
				break;
			case 8:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				match(NULL);
				}
				break;
			case 9:
				{
				_localctx = new ExprUnaryopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				unaryOp();
				setState(273);
				expr(3);
				}
				break;
			case 10:
				{
				_localctx = new ExprArrElemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				arrayElem();
				}
				break;
			case 11:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				ident();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(303);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(280);
						binop1();
						setState(281);
						((ExprBinopContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(284);
						binop2();
						setState(285);
						((ExprBinopContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(287);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(288);
						binop3();
						setState(289);
						((ExprBinopContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(291);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(292);
						binop4();
						setState(293);
						((ExprBinopContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(296);
						binop5();
						setState(297);
						((ExprBinopContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(299);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(300);
						binop6();
						setState(301);
						((ExprBinopContext)_localctx).right = expr(13);
						}
						break;
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 54, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			type();
			setState(309);
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
		enterRule(_localctx, 56, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			param();
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(312);
				match(COMMA);
				setState(313);
				param();
				}
				}
				setState(318);
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

	public static class ConstraintContext extends ParserRuleContext {
		public List<CapIdentContext> capIdent() {
			return getRuleContexts(CapIdentContext.class);
		}
		public CapIdentContext capIdent(int i) {
			return getRuleContext(CapIdentContext.class,i);
		}
		public TerminalNode COLON() { return getToken(WaccParser.COLON, 0); }
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			capIdent();
			setState(320);
			match(COLON);
			setState(321);
			capIdent();
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

	public static class ForallConstraintContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(WaccParser.FORALL, 0); }
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public ForallConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forallConstraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitForallConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForallConstraintContext forallConstraint() throws RecognitionException {
		ForallConstraintContext _localctx = new ForallConstraintContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forallConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(FORALL);
			setState(324);
			capIdent();
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

	public static class ConstraintListContext extends ParserRuleContext {
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public List<ForallConstraintContext> forallConstraint() {
			return getRuleContexts(ForallConstraintContext.class);
		}
		public ForallConstraintContext forallConstraint(int i) {
			return getRuleContext(ForallConstraintContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public ConstraintListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitConstraintList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintListContext constraintList() throws RecognitionException {
		ConstraintListContext _localctx = new ConstraintListContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constraintList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP_IDENT:
				{
				setState(326);
				constraint();
				}
				break;
			case FORALL:
				{
				setState(327);
				forallConstraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(330);
				match(COMMA);
				setState(333);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CAP_IDENT:
					{
					setState(331);
					constraint();
					}
					break;
				case FORALL:
					{
					setState(332);
					forallConstraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
		public TerminalNode WHERE() { return getToken(WaccParser.WHERE, 0); }
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
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
		enterRule(_localctx, 64, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			type();
			setState(338);
			ident();
			setState(339);
			match(LPAR);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(340);
				paramList();
				}
			}

			setState(343);
			match(RPAR);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(344);
				match(WHERE);
				setState(345);
				constraintList();
				}
			}

			setState(348);
			match(IS);
			setState(349);
			stats();
			setState(350);
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

	public static class RequiredFuncContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode REQUIRED() { return getToken(WaccParser.REQUIRED, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(WaccParser.WHERE, 0); }
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
		}
		public RequiredFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requiredFunc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRequiredFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequiredFuncContext requiredFunc() throws RecognitionException {
		RequiredFuncContext _localctx = new RequiredFuncContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_requiredFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			type();
			setState(353);
			ident();
			setState(354);
			match(LPAR);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(355);
				paramList();
				}
			}

			setState(358);
			match(RPAR);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(359);
				match(WHERE);
				setState(360);
				constraintList();
				}
			}

			setState(363);
			match(IS);
			setState(364);
			match(REQUIRED);
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

	public static class TraitDefContext extends ParserRuleContext {
		public CapIdentContext tvar;
		public CapIdentContext trait;
		public TerminalNode TRAIT() { return getToken(WaccParser.TRAIT, 0); }
		public TerminalNode COLON() { return getToken(WaccParser.COLON, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public List<CapIdentContext> capIdent() {
			return getRuleContexts(CapIdentContext.class);
		}
		public CapIdentContext capIdent(int i) {
			return getRuleContext(CapIdentContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(WaccParser.WHERE, 0); }
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
		}
		public List<RequiredFuncContext> requiredFunc() {
			return getRuleContexts(RequiredFuncContext.class);
		}
		public RequiredFuncContext requiredFunc(int i) {
			return getRuleContext(RequiredFuncContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TraitDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitTraitDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitDefContext traitDef() throws RecognitionException {
		TraitDefContext _localctx = new TraitDefContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_traitDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(TRAIT);
			setState(367);
			((TraitDefContext)_localctx).tvar = capIdent();
			setState(368);
			match(COLON);
			setState(369);
			((TraitDefContext)_localctx).trait = capIdent();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(370);
				match(WHERE);
				setState(371);
				constraintList();
				}
			}

			setState(374);
			match(IS);
			setState(376); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(375);
					requiredFunc();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(378); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(380);
				func();
				}
				}
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(386);
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
		enterRule(_localctx, 70, RULE_builtinFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
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
	public static class WhenClauseContext extends StatContext {
		public TerminalNode WHEN() { return getToken(WaccParser.WHEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(WaccParser.COLON, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public List<WhenCaseContext> whenCase() {
			return getRuleContexts(WhenCaseContext.class);
		}
		public WhenCaseContext whenCase(int i) {
			return getRuleContext(WhenCaseContext.class,i);
		}
		public WhenClauseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWhenClause(this);
			else return visitor.visitChildren(this);
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
	public static class ConstDeclarationContext extends StatContext {
		public TerminalNode CONST() { return getToken(WaccParser.CONST, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConstDeclarationContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitConstDeclaration(this);
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
		public List<TerminalNode> IF() { return getTokens(WaccParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(WaccParser.IF, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> THEN() { return getTokens(WaccParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(WaccParser.THEN, i);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(WaccParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(WaccParser.ELSE, i);
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(WaccParser.ASSIGN, 0); }
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(WaccParser.VAR, 0); }
		public DeclarationContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoopContext extends StatContext {
		public TerminalNode FOR() { return getToken(WaccParser.FOR, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode IN() { return getToken(WaccParser.IN, 0); }
		public EnumRangeContext enumRange() {
			return getRuleContext(EnumRangeContext.class,0);
		}
		public TerminalNode DO() { return getToken(WaccParser.DO, 0); }
		public TerminalNode DONE() { return getToken(WaccParser.DONE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(WaccParser.VAR, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public ForLoopContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				match(SKIP_STAT);
				}
				break;
			case 2:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(391);
					type();
					}
					break;
				case VAR:
					{
					setState(392);
					match(VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(395);
				ident();
				setState(396);
				match(ASSIGN);
				setState(397);
				assignRhs();
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(399);
				match(CONST);
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
					{
					setState(400);
					type();
					}
				}

				setState(403);
				ident();
				setState(404);
				match(ASSIGN);
				setState(405);
				assignRhs();
				}
				break;
			case 4:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(407);
				assignLhs();
				setState(408);
				match(ASSIGN);
				setState(409);
				assignRhs();
				}
				break;
			case 5:
				_localctx = new ReadCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(411);
				match(READ);
				setState(412);
				assignLhs();
				}
				break;
			case 6:
				_localctx = new BuiltinFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(413);
				builtinFunc();
				setState(414);
				expr(0);
				}
				break;
			case 7:
				_localctx = new CondBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(416);
				match(IF);
				setState(417);
				expr(0);
				setState(418);
				match(THEN);
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
					{
					setState(419);
					stats();
					}
				}

				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(430);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(422);
							match(ELSE);
							setState(423);
							match(IF);
							setState(424);
							expr(0);
							setState(425);
							match(THEN);
							setState(426);
							stats();
							}
							} 
						}
						setState(432);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
					}
					setState(433);
					match(ELSE);
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
						{
						setState(434);
						stats();
						}
					}

					}
				}

				setState(439);
				match(FI);
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(441);
				match(WHILE);
				setState(442);
				expr(0);
				setState(443);
				match(DO);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
					{
					setState(444);
					stats();
					}
				}

				setState(447);
				match(DONE);
				}
				break;
			case 9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(449);
				match(FOR);
				setState(452);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(450);
					type();
					}
					break;
				case VAR:
					{
					setState(451);
					match(VAR);
					}
					break;
				case IDENT:
					break;
				default:
					break;
				}
				setState(454);
				ident();
				setState(455);
				match(IN);
				setState(456);
				enumRange();
				setState(457);
				match(DO);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
					{
					setState(458);
					stats();
					}
				}

				setState(461);
				match(DONE);
				}
				break;
			case 10:
				_localctx = new WhenClauseContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(463);
				match(WHEN);
				setState(464);
				expr(0);
				setState(465);
				match(COLON);
				setState(469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IS) {
					{
					{
					setState(466);
					whenCase();
					}
					}
					setState(471);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(472);
				match(END);
				}
				break;
			case 11:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(474);
				match(BEGIN);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
					{
					setState(475);
					stats();
					}
				}

				setState(478);
				match(END);
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

	public static class PatternContext extends ParserRuleContext {
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			capIdent();
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(482);
				match(LPAR);
				setState(483);
				ident();
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(484);
					match(COMMA);
					setState(485);
					ident();
					}
					}
					setState(490);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(491);
				match(RPAR);
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

	public static class WhenCaseContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(WaccParser.ARROW, 0); }
		public StatsContext stats() {
			return getRuleContext(StatsContext.class,0);
		}
		public WhenCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenCase; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitWhenCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenCaseContext whenCase() throws RecognitionException {
		WhenCaseContext _localctx = new WhenCaseContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_whenCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(IS);
			setState(496);
			pattern();
			setState(497);
			match(ARROW);
			setState(498);
			stats();
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
		enterRule(_localctx, 78, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			stat();
			setState(501);
			match(SEMICOLON);
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
				{
				{
				setState(502);
				stat();
				setState(503);
				match(SEMICOLON);
				}
				}
				setState(509);
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
		public TypeMemberContext typeMember() {
			return getRuleContext(TypeMemberContext.class,0);
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
		enterRule(_localctx, 80, RULE_assignLhs);
		try {
			setState(514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(510);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(512);
				pairElem();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(513);
				typeMember();
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
	public static class RhsTypeMemberContext extends AssignRhsContext {
		public TypeMemberContext typeMember() {
			return getRuleContext(TypeMemberContext.class,0);
		}
		public RhsTypeMemberContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsTypeMember(this);
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
	public static class RhsTypeConstructorContext extends AssignRhsContext {
		public TypeConstructorContext typeConstructor() {
			return getRuleContext(TypeConstructorContext.class,0);
		}
		public RhsTypeConstructorContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitRhsTypeConstructor(this);
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
		enterRule(_localctx, 82, RULE_assignRhs);
		int _la;
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				expr(0);
				}
				break;
			case 2:
				_localctx = new RhsArrayLiterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				arrayLiter();
				}
				break;
			case 3:
				_localctx = new RhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				match(NEWPAIR);
				setState(519);
				match(LPAR);
				setState(520);
				expr(0);
				setState(521);
				match(COMMA);
				setState(522);
				expr(0);
				setState(523);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new RhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(525);
				pairElem();
				}
				break;
			case 5:
				_localctx = new RhsTypeMemberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(526);
				typeMember();
				}
				break;
			case 6:
				_localctx = new RhsTypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(527);
				typeConstructor();
				}
				break;
			case 7:
				_localctx = new RhsFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(528);
				match(CALL);
				setState(529);
				ident();
				setState(530);
				match(LPAR);
				setState(532);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)))) != 0)) {
					{
					setState(531);
					argList();
					}
				}

				setState(534);
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
		enterRule(_localctx, 84, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			expr(0);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(539);
				match(COMMA);
				setState(540);
				expr(0);
				}
				}
				setState(545);
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
		enterRule(_localctx, 86, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(LBRA);
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)))) != 0)) {
				{
				setState(547);
				argList();
				}
			}

			setState(550);
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
		enterRule(_localctx, 88, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			ident();
			setState(557); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(553);
					match(LBRA);
					setState(554);
					expr(0);
					setState(555);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(559); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		enterRule(_localctx, 90, RULE_pairElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			pairElemFunc();
			setState(562);
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

	public static class TypeMemberContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(WaccParser.DOT, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeMember; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitTypeMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeMemberContext typeMember() throws RecognitionException {
		TypeMemberContext _localctx = new TypeMemberContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typeMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			expr(0);
			setState(565);
			match(DOT);
			setState(566);
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

	public static class TypeConstructorContext extends ParserRuleContext {
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TypeConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeConstructorContext typeConstructor() throws RecognitionException {
		TypeConstructorContext _localctx = new TypeConstructorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_typeConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			capIdent();
			setState(569);
			match(LPAR);
			setState(571);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)))) != 0)) {
				{
				setState(570);
				argList();
				}
			}

			setState(573);
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

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(WaccParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public TerminalNode EOF() { return getToken(WaccParser.EOF, 0); }
		public List<NewtypeContext> newtype() {
			return getRuleContexts(NewtypeContext.class);
		}
		public NewtypeContext newtype(int i) {
			return getRuleContext(NewtypeContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<TraitDefContext> traitDef() {
			return getRuleContexts(TraitDefContext.class);
		}
		public TraitDefContext traitDef(int i) {
			return getRuleContext(TraitDefContext.class,i);
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
		enterRule(_localctx, 96, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			match(BEGIN);
			setState(581);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(579);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NEWTYPE:
						{
						setState(576);
						newtype();
						}
						break;
					case PAIR:
					case BASE_TYPE:
					case CAP_IDENT:
						{
						setState(577);
						func();
						}
						break;
					case TRAIT:
						{
						setState(578);
						traitDef();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(583);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (BASE_TYPE - 67)) | (1L << (INTEGER - 67)) | (1L << (STRLIT - 67)) | (1L << (CHARLIT - 67)) | (1L << (IDENT - 67)) | (1L << (CAP_IDENT - 67)))) != 0)) {
				{
				setState(584);
				stats();
				}
			}

			setState(587);
			match(END);
			setState(588);
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
		case 26:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3N\u0251\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\5\3h"+
		"\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7w\n\7\5\7"+
		"y\n\7\3\b\3\b\5\b}\n\b\3\b\3\b\6\b\u0081\n\b\r\b\16\b\u0082\3\t\3\t\3"+
		"\t\5\t\u0088\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\5\16\u00a3\n\16\3\17\3\17\3\17\3\17\7\17\u00a9\n\17\f\17\16\17\u00ac"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b3\n\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00b9\n\20\f\20\16\20\u00bc\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u00c6\n\21\f\21\16\21\u00c9\13\21\3\21\3\21\5\21\u00cd\n"+
		"\21\3\22\3\22\3\22\5\22\u00d2\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u00d9"+
		"\n\22\f\22\16\22\u00dc\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00ea\n\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0118\n\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0132\n\34\f\34\16\34\u0135"+
		"\13\34\3\35\3\35\3\35\3\36\3\36\3\36\7\36\u013d\n\36\f\36\16\36\u0140"+
		"\13\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\5!\u014b\n!\3!\3!\3!\5!\u0150"+
		"\n!\5!\u0152\n!\3\"\3\"\3\"\3\"\5\"\u0158\n\"\3\"\3\"\3\"\5\"\u015d\n"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\5#\u0167\n#\3#\3#\3#\5#\u016c\n#\3#\3#"+
		"\3#\3$\3$\3$\3$\3$\3$\5$\u0177\n$\3$\3$\6$\u017b\n$\r$\16$\u017c\3$\7"+
		"$\u0180\n$\f$\16$\u0183\13$\3$\3$\3%\3%\3&\3&\3&\5&\u018c\n&\3&\3&\3&"+
		"\3&\3&\3&\5&\u0194\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\5&\u01a7\n&\3&\3&\3&\3&\3&\3&\7&\u01af\n&\f&\16&\u01b2\13&\3&\3&\5"+
		"&\u01b6\n&\5&\u01b8\n&\3&\3&\3&\3&\3&\3&\5&\u01c0\n&\3&\3&\3&\3&\3&\5"+
		"&\u01c7\n&\3&\3&\3&\3&\3&\5&\u01ce\n&\3&\3&\3&\3&\3&\3&\7&\u01d6\n&\f"+
		"&\16&\u01d9\13&\3&\3&\3&\3&\5&\u01df\n&\3&\5&\u01e2\n&\3\'\3\'\3\'\3\'"+
		"\3\'\7\'\u01e9\n\'\f\'\16\'\u01ec\13\'\3\'\3\'\5\'\u01f0\n\'\3(\3(\3("+
		"\3(\3(\3)\3)\3)\3)\3)\7)\u01fc\n)\f)\16)\u01ff\13)\3*\3*\3*\3*\5*\u0205"+
		"\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0217\n+\3+\3+"+
		"\5+\u021b\n+\3,\3,\3,\7,\u0220\n,\f,\16,\u0223\13,\3-\3-\5-\u0227\n-\3"+
		"-\3-\3.\3.\3.\3.\3.\6.\u0230\n.\r.\16.\u0231\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\5\61\u023e\n\61\3\61\3\61\3\62\3\62\3\62\3\62\7\62"+
		"\u0246\n\62\f\62\16\62\u0249\13\62\3\62\5\62\u024c\n\62\3\62\3\62\3\62"+
		"\3\62\2\3\66\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\n\3\2\7\b\3\2\'(\4\2\b\b\25\30\3\2\31"+
		"\32\3\2\t\13\3\2\f\17\3\2\20\21\3\2\648\2\u0278\2d\3\2\2\2\4g\3\2\2\2"+
		"\6k\3\2\2\2\bm\3\2\2\2\no\3\2\2\2\fx\3\2\2\2\16|\3\2\2\2\20\u0087\3\2"+
		"\2\2\22\u0089\3\2\2\2\24\u008b\3\2\2\2\26\u0092\3\2\2\2\30\u009d\3\2\2"+
		"\2\32\u00a2\3\2\2\2\34\u00a4\3\2\2\2\36\u00af\3\2\2\2 \u00bf\3\2\2\2\""+
		"\u00ce\3\2\2\2$\u00e9\3\2\2\2&\u00eb\3\2\2\2(\u00ed\3\2\2\2*\u00ef\3\2"+
		"\2\2,\u00f1\3\2\2\2.\u00f3\3\2\2\2\60\u00f5\3\2\2\2\62\u00f7\3\2\2\2\64"+
		"\u00f9\3\2\2\2\66\u0117\3\2\2\28\u0136\3\2\2\2:\u0139\3\2\2\2<\u0141\3"+
		"\2\2\2>\u0145\3\2\2\2@\u014a\3\2\2\2B\u0153\3\2\2\2D\u0162\3\2\2\2F\u0170"+
		"\3\2\2\2H\u0186\3\2\2\2J\u01e1\3\2\2\2L\u01e3\3\2\2\2N\u01f1\3\2\2\2P"+
		"\u01f6\3\2\2\2R\u0204\3\2\2\2T\u021a\3\2\2\2V\u021c\3\2\2\2X\u0224\3\2"+
		"\2\2Z\u022a\3\2\2\2\\\u0233\3\2\2\2^\u0236\3\2\2\2`\u023a\3\2\2\2b\u0241"+
		"\3\2\2\2de\t\2\2\2e\3\3\2\2\2fh\5\2\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2"+
		"ij\7F\2\2j\5\3\2\2\2kl\7K\2\2l\7\3\2\2\2mn\7L\2\2n\t\3\2\2\2op\t\3\2\2"+
		"p\13\3\2\2\2qy\5\16\b\2ry\5\22\n\2sy\5\24\13\2tv\5\b\5\2uw\5\26\f\2vu"+
		"\3\2\2\2vw\3\2\2\2wy\3\2\2\2xq\3\2\2\2xr\3\2\2\2xs\3\2\2\2xt\3\2\2\2y"+
		"\r\3\2\2\2z}\5\22\n\2{}\5\24\13\2|z\3\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~"+
		"\177\7\36\2\2\177\u0081\7\37\2\2\u0080~\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\17\3\2\2\2\u0084\u0088\5\16\b"+
		"\2\u0085\u0088\5\22\n\2\u0086\u0088\7:\2\2\u0087\u0084\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0086\3\2\2\2\u0088\21\3\2\2\2\u0089\u008a\7E\2\2\u008a"+
		"\23\3\2\2\2\u008b\u008c\7:\2\2\u008c\u008d\7\34\2\2\u008d\u008e\5\20\t"+
		"\2\u008e\u008f\7J\2\2\u008f\u0090\5\20\t\2\u0090\u0091\7\35\2\2\u0091"+
		"\25\3\2\2\2\u0092\u0093\7\17\2\2\u0093\u0098\5\f\7\2\u0094\u0095\7J\2"+
		"\2\u0095\u0097\5\f\7\2\u0096\u0094\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\7\r\2\2\u009c\27\3\2\2\2\u009d\u009e\5\f\7\2\u009e\u009f\5\6\4"+
		"\2\u009f\31\3\2\2\2\u00a0\u00a3\5\36\20\2\u00a1\u00a3\5\"\22\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\7\17\2\2\u00a5"+
		"\u00aa\5\b\5\2\u00a6\u00a7\7J\2\2\u00a7\u00a9\5\b\5\2\u00a8\u00a6\3\2"+
		"\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\r\2\2\u00ae\35\3\2\2"+
		"\2\u00af\u00b0\7=\2\2\u00b0\u00b2\5\b\5\2\u00b1\u00b3\5\34\17\2\u00b2"+
		"\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00ba\7$"+
		"\2\2\u00b5\u00b6\5\30\r\2\u00b6\u00b7\7\"\2\2\u00b7\u00b9\3\2\2\2\u00b8"+
		"\u00b5\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\7%\2\2\u00be"+
		"\37\3\2\2\2\u00bf\u00cc\5\b\5\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7\34\2"+
		"\2\u00c2\u00c7\5\30\r\2\u00c3\u00c4\7J\2\2\u00c4\u00c6\5\30\r\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\35\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00c0\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd!\3\2\2\2"+
		"\u00ce\u00cf\7=\2\2\u00cf\u00d1\5\b\5\2\u00d0\u00d2\5\34\17\2\u00d1\u00d0"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7$\2\2\u00d4"+
		"\u00da\7>\2\2\u00d5\u00d6\5 \21\2\u00d6\u00d7\7\"\2\2\u00d7\u00d9\3\2"+
		"\2\2\u00d8\u00d5\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7%"+
		"\2\2\u00de#\3\2\2\2\u00df\u00e0\5\66\34\2\u00e0\u00e1\7\24\2\2\u00e1\u00e2"+
		"\5\66\34\2\u00e2\u00ea\3\2\2\2\u00e3\u00e4\5\66\34\2\u00e4\u00e5\7J\2"+
		"\2\u00e5\u00e6\5\66\34\2\u00e6\u00e7\7\24\2\2\u00e7\u00e8\5\66\34\2\u00e8"+
		"\u00ea\3\2\2\2\u00e9\u00df\3\2\2\2\u00e9\u00e3\3\2\2\2\u00ea%\3\2\2\2"+
		"\u00eb\u00ec\t\4\2\2\u00ec\'\3\2\2\2\u00ed\u00ee\t\5\2\2\u00ee)\3\2\2"+
		"\2\u00ef\u00f0\t\6\2\2\u00f0+\3\2\2\2\u00f1\u00f2\t\2\2\2\u00f2-\3\2\2"+
		"\2\u00f3\u00f4\t\7\2\2\u00f4/\3\2\2\2\u00f5\u00f6\t\b\2\2\u00f6\61\3\2"+
		"\2\2\u00f7\u00f8\7\22\2\2\u00f8\63\3\2\2\2\u00f9\u00fa\7\23\2\2\u00fa"+
		"\65\3\2\2\2\u00fb\u00fc\b\34\1\2\u00fc\u00fd\7\34\2\2\u00fd\u00fe\5\66"+
		"\34\2\u00fe\u00ff\7\35\2\2\u00ff\u0118\3\2\2\2\u0100\u0101\5\6\4\2\u0101"+
		"\u0102\7\34\2\2\u0102\u0103\5V,\2\u0103\u0104\7\35\2\2\u0104\u0118\3\2"+
		"\2\2\u0105\u0106\7)\2\2\u0106\u0107\5\66\34\2\u0107\u0108\7*\2\2\u0108"+
		"\u0109\5\66\34\2\u0109\u010a\7+\2\2\u010a\u010b\5\66\34\2\u010b\u010c"+
		"\7,\2\2\u010c\u0118\3\2\2\2\u010d\u0118\5\4\3\2\u010e\u0118\5\n\6\2\u010f"+
		"\u0118\7H\2\2\u0110\u0118\7G\2\2\u0111\u0118\7&\2\2\u0112\u0113\5&\24"+
		"\2\u0113\u0114\5\66\34\5\u0114\u0118\3\2\2\2\u0115\u0118\5Z.\2\u0116\u0118"+
		"\5\6\4\2\u0117\u00fb\3\2\2\2\u0117\u0100\3\2\2\2\u0117\u0105\3\2\2\2\u0117"+
		"\u010d\3\2\2\2\u0117\u010e\3\2\2\2\u0117\u010f\3\2\2\2\u0117\u0110\3\2"+
		"\2\2\u0117\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0116\3\2\2\2\u0118\u0133\3\2\2\2\u0119\u011a\f\23\2\2\u011a\u011b\5"+
		"*\26\2\u011b\u011c\5\66\34\24\u011c\u0132\3\2\2\2\u011d\u011e\f\22\2\2"+
		"\u011e\u011f\5,\27\2\u011f\u0120\5\66\34\23\u0120\u0132\3\2\2\2\u0121"+
		"\u0122\f\21\2\2\u0122\u0123\5.\30\2\u0123\u0124\5\66\34\22\u0124\u0132"+
		"\3\2\2\2\u0125\u0126\f\20\2\2\u0126\u0127\5\60\31\2\u0127\u0128\5\66\34"+
		"\21\u0128\u0132\3\2\2\2\u0129\u012a\f\17\2\2\u012a\u012b\5\62\32\2\u012b"+
		"\u012c\5\66\34\20\u012c\u0132\3\2\2\2\u012d\u012e\f\16\2\2\u012e\u012f"+
		"\5\64\33\2\u012f\u0130\5\66\34\17\u0130\u0132\3\2\2\2\u0131\u0119\3\2"+
		"\2\2\u0131\u011d\3\2\2\2\u0131\u0121\3\2\2\2\u0131\u0125\3\2\2\2\u0131"+
		"\u0129\3\2\2\2\u0131\u012d\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\67\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137"+
		"\5\f\7\2\u0137\u0138\5\6\4\2\u01389\3\2\2\2\u0139\u013e\58\35\2\u013a"+
		"\u013b\7J\2\2\u013b\u013d\58\35\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2"+
		"\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f;\3\2\2\2\u0140\u013e"+
		"\3\2\2\2\u0141\u0142\5\b\5\2\u0142\u0143\7\5\2\2\u0143\u0144\5\b\5\2\u0144"+
		"=\3\2\2\2\u0145\u0146\7B\2\2\u0146\u0147\5\b\5\2\u0147?\3\2\2\2\u0148"+
		"\u014b\5<\37\2\u0149\u014b\5> \2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2"+
		"\2\u014b\u0151\3\2\2\2\u014c\u014f\7J\2\2\u014d\u0150\5<\37\2\u014e\u0150"+
		"\5> \2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u014c\3\2\2\2\u0151\u0152\3\2\2\2\u0152A\3\2\2\2\u0153\u0154\5\f\7\2"+
		"\u0154\u0155\5\6\4\2\u0155\u0157\7\34\2\2\u0156\u0158\5:\36\2\u0157\u0156"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015c\7\35\2\2"+
		"\u015a\u015b\7A\2\2\u015b\u015d\5@!\2\u015c\u015a\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\7$\2\2\u015f\u0160\5P)\2\u0160"+
		"\u0161\7%\2\2\u0161C\3\2\2\2\u0162\u0163\5\f\7\2\u0163\u0164\5\6\4\2\u0164"+
		"\u0166\7\34\2\2\u0165\u0167\5:\36\2\u0166\u0165\3\2\2\2\u0166\u0167\3"+
		"\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\7\35\2\2\u0169\u016a\7A\2\2\u016a"+
		"\u016c\5@!\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2"+
		"\2\u016d\u016e\7$\2\2\u016e\u016f\7D\2\2\u016fE\3\2\2\2\u0170\u0171\7"+
		"C\2\2\u0171\u0172\5\b\5\2\u0172\u0173\7\5\2\2\u0173\u0176\5\b\5\2\u0174"+
		"\u0175\7A\2\2\u0175\u0177\5@!\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2"+
		"\2\u0177\u0178\3\2\2\2\u0178\u017a\7$\2\2\u0179\u017b\5D#\2\u017a\u0179"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u0181\3\2\2\2\u017e\u0180\5B\"\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2"+
		"\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183"+
		"\u0181\3\2\2\2\u0184\u0185\7%\2\2\u0185G\3\2\2\2\u0186\u0187\t\t\2\2\u0187"+
		"I\3\2\2\2\u0188\u01e2\7\33\2\2\u0189\u018c\5\f\7\2\u018a\u018c\7;\2\2"+
		"\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e"+
		"\5\6\4\2\u018e\u018f\7I\2\2\u018f\u0190\5T+\2\u0190\u01e2\3\2\2\2\u0191"+
		"\u0193\7<\2\2\u0192\u0194\5\f\7\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2"+
		"\2\2\u0194\u0195\3\2\2\2\u0195\u0196\5\6\4\2\u0196\u0197\7I\2\2\u0197"+
		"\u0198\5T+\2\u0198\u01e2\3\2\2\2\u0199\u019a\5R*\2\u019a\u019b\7I\2\2"+
		"\u019b\u019c\5T+\2\u019c\u01e2\3\2\2\2\u019d\u019e\7\63\2\2\u019e\u01e2"+
		"\5R*\2\u019f\u01a0\5H%\2\u01a0\u01a1\5\66\34\2\u01a1\u01e2\3\2\2\2\u01a2"+
		"\u01a3\7)\2\2\u01a3\u01a4\5\66\34\2\u01a4\u01a6\7*\2\2\u01a5\u01a7\5P"+
		")\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01b7\3\2\2\2\u01a8"+
		"\u01a9\7+\2\2\u01a9\u01aa\7)\2\2\u01aa\u01ab\5\66\34\2\u01ab\u01ac\7*"+
		"\2\2\u01ac\u01ad\5P)\2\u01ad\u01af\3\2\2\2\u01ae\u01a8\3\2\2\2\u01af\u01b2"+
		"\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b3\u01b5\7+\2\2\u01b4\u01b6\5P)\2\u01b5\u01b4\3\2\2"+
		"\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8\3\2\2\2\u01b7\u01b0\3\2\2\2\u01b7\u01b8"+
		"\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\7,\2\2\u01ba\u01e2\3\2\2\2\u01bb"+
		"\u01bc\7-\2\2\u01bc\u01bd\5\66\34\2\u01bd\u01bf\7\60\2\2\u01be\u01c0\5"+
		"P)\2\u01bf\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1"+
		"\u01c2\7\61\2\2\u01c2\u01e2\3\2\2\2\u01c3\u01c6\7.\2\2\u01c4\u01c7\5\f"+
		"\7\2\u01c5\u01c7\7;\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\5\6\4\2\u01c9\u01ca\7/"+
		"\2\2\u01ca\u01cb\5$\23\2\u01cb\u01cd\7\60\2\2\u01cc\u01ce\5P)\2\u01cd"+
		"\u01cc\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\7\61"+
		"\2\2\u01d0\u01e2\3\2\2\2\u01d1\u01d2\7@\2\2\u01d2\u01d3\5\66\34\2\u01d3"+
		"\u01d7\7\5\2\2\u01d4\u01d6\5N(\2\u01d5\u01d4\3\2\2\2\u01d6\u01d9\3\2\2"+
		"\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01da\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01da\u01db\7%\2\2\u01db\u01e2\3\2\2\2\u01dc\u01de\7#\2\2\u01dd"+
		"\u01df\5P)\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2"+
		"\2\u01e0\u01e2\7%\2\2\u01e1\u0188\3\2\2\2\u01e1\u018b\3\2\2\2\u01e1\u0191"+
		"\3\2\2\2\u01e1\u0199\3\2\2\2\u01e1\u019d\3\2\2\2\u01e1\u019f\3\2\2\2\u01e1"+
		"\u01a2\3\2\2\2\u01e1\u01bb\3\2\2\2\u01e1\u01c3\3\2\2\2\u01e1\u01d1\3\2"+
		"\2\2\u01e1\u01dc\3\2\2\2\u01e2K\3\2\2\2\u01e3\u01ef\5\b\5\2\u01e4\u01e5"+
		"\7\34\2\2\u01e5\u01ea\5\6\4\2\u01e6\u01e7\7J\2\2\u01e7\u01e9\5\6\4\2\u01e8"+
		"\u01e6\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ee\7\35\2\2\u01ee"+
		"\u01f0\3\2\2\2\u01ef\u01e4\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0M\3\2\2\2"+
		"\u01f1\u01f2\7$\2\2\u01f2\u01f3\5L\'\2\u01f3\u01f4\7\3\2\2\u01f4\u01f5"+
		"\5P)\2\u01f5O\3\2\2\2\u01f6\u01f7\5J&\2\u01f7\u01fd\7\"\2\2\u01f8\u01f9"+
		"\5J&\2\u01f9\u01fa\7\"\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fc"+
		"\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01feQ\3\2\2\2"+
		"\u01ff\u01fd\3\2\2\2\u0200\u0205\5\6\4\2\u0201\u0205\5Z.\2\u0202\u0205"+
		"\5\\/\2\u0203\u0205\5^\60\2\u0204\u0200\3\2\2\2\u0204\u0201\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0204\u0203\3\2\2\2\u0205S\3\2\2\2\u0206\u021b\5\66\34"+
		"\2\u0207\u021b\5X-\2\u0208\u0209\7\62\2\2\u0209\u020a\7\34\2\2\u020a\u020b"+
		"\5\66\34\2\u020b\u020c\7J\2\2\u020c\u020d\5\66\34\2\u020d\u020e\7\35\2"+
		"\2\u020e\u021b\3\2\2\2\u020f\u021b\5\\/\2\u0210\u021b\5^\60\2\u0211\u021b"+
		"\5`\61\2\u0212\u0213\79\2\2\u0213\u0214\5\6\4\2\u0214\u0216\7\34\2\2\u0215"+
		"\u0217\5V,\2\u0216\u0215\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\3\2\2"+
		"\2\u0218\u0219\7\35\2\2\u0219\u021b\3\2\2\2\u021a\u0206\3\2\2\2\u021a"+
		"\u0207\3\2\2\2\u021a\u0208\3\2\2\2\u021a\u020f\3\2\2\2\u021a\u0210\3\2"+
		"\2\2\u021a\u0211\3\2\2\2\u021a\u0212\3\2\2\2\u021bU\3\2\2\2\u021c\u0221"+
		"\5\66\34\2\u021d\u021e\7J\2\2\u021e\u0220\5\66\34\2\u021f\u021d\3\2\2"+
		"\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222W"+
		"\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0226\7\36\2\2\u0225\u0227\5V,\2\u0226"+
		"\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u0229\7\37"+
		"\2\2\u0229Y\3\2\2\2\u022a\u022f\5\6\4\2\u022b\u022c\7\36\2\2\u022c\u022d"+
		"\5\66\34\2\u022d\u022e\7\37\2\2\u022e\u0230\3\2\2\2\u022f\u022b\3\2\2"+
		"\2\u0230\u0231\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2\2\2\u0232["+
		"\3\2\2\2\u0233\u0234\5(\25\2\u0234\u0235\5\66\34\2\u0235]\3\2\2\2\u0236"+
		"\u0237\5\66\34\2\u0237\u0238\7\6\2\2\u0238\u0239\5\6\4\2\u0239_\3\2\2"+
		"\2\u023a\u023b\5\b\5\2\u023b\u023d\7\34\2\2\u023c\u023e\5V,\2\u023d\u023c"+
		"\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\7\35\2\2"+
		"\u0240a\3\2\2\2\u0241\u0247\7#\2\2\u0242\u0246\5\32\16\2\u0243\u0246\5"+
		"B\"\2\u0244\u0246\5F$\2\u0245\u0242\3\2\2\2\u0245\u0243\3\2\2\2\u0245"+
		"\u0244\3\2\2\2\u0246\u0249\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2"+
		"\2\2\u0248\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u024a\u024c\5P)\2\u024b\u024a"+
		"\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\7%\2\2\u024e"+
		"\u024f\7\2\2\3\u024fc\3\2\2\29gvx|\u0082\u0087\u0098\u00a2\u00aa\u00b2"+
		"\u00ba\u00c7\u00cc\u00d1\u00da\u00e9\u0117\u0131\u0133\u013e\u014a\u014f"+
		"\u0151\u0157\u015c\u0166\u016b\u0176\u017c\u0181\u018b\u0193\u01a6\u01b0"+
		"\u01b5\u01b7\u01bf\u01c6\u01cd\u01d7\u01de\u01e1\u01ea\u01ef\u01fd\u0204"+
		"\u0216\u021a\u0221\u0226\u0231\u023d\u0245\u0247\u024b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}