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
		INSTANCE=67, BASE_TYPE=68, INTEGER=69, STRLIT=70, CHARLIT=71, ASSIGN=72, 
		COMMA=73, IDENT=74, CAP_IDENT=75, COMMENT=76, WS=77;
	public static final int
		RULE_intsign = 0, RULE_integer = 1, RULE_ident = 2, RULE_capIdent = 3, 
		RULE_boolLit = 4, RULE_type = 5, RULE_arrayType = 6, RULE_pairElemType = 7, 
		RULE_baseType = 8, RULE_pairType = 9, RULE_generics = 10, RULE_member = 11, 
		RULE_newtype = 12, RULE_genericTVars = 13, RULE_structType = 14, RULE_unionEntry = 15, 
		RULE_taggedUnion = 16, RULE_traitInstance = 17, RULE_enumRange = 18, RULE_unaryOp = 19, 
		RULE_pairElemFunc = 20, RULE_binop1 = 21, RULE_binop2 = 22, RULE_binop3 = 23, 
		RULE_binop4 = 24, RULE_binop5 = 25, RULE_binop6 = 26, RULE_expr = 27, 
		RULE_param = 28, RULE_paramList = 29, RULE_constraint = 30, RULE_forallConstraint = 31, 
		RULE_constraintList = 32, RULE_func = 33, RULE_requiredFunc = 34, RULE_traitDef = 35, 
		RULE_builtinFunc = 36, RULE_stat = 37, RULE_pattern = 38, RULE_whenCase = 39, 
		RULE_stats = 40, RULE_assignLhs = 41, RULE_assignRhs = 42, RULE_argList = 43, 
		RULE_arrayLiter = 44, RULE_arrayElem = 45, RULE_pairElem = 46, RULE_typeMember = 47, 
		RULE_typeConstructor = 48, RULE_prog = 49;
	public static final String[] ruleNames = {
		"intsign", "integer", "ident", "capIdent", "boolLit", "type", "arrayType", 
		"pairElemType", "baseType", "pairType", "generics", "member", "newtype", 
		"genericTVars", "structType", "unionEntry", "taggedUnion", "traitInstance", 
		"enumRange", "unaryOp", "pairElemFunc", "binop1", "binop2", "binop3", 
		"binop4", "binop5", "binop6", "expr", "param", "paramList", "constraint", 
		"forallConstraint", "constraintList", "func", "requiredFunc", "traitDef", 
		"builtinFunc", "stat", "pattern", "whenCase", "stats", "assignLhs", "assignRhs", 
		"argList", "arrayLiter", "arrayElem", "pairElem", "typeMember", "typeConstructor", 
		"prog"
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
		"'required'", "'instance'", null, null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ARROW", "DOUBLE_ARROW", "COLON", "DOT", "ADD", "SUB", "MUL", "DIV", 
		"MOD", "GTE", "GT", "LTE", "LT", "EQ", "NEQ", "AND", "OR", "DOTDOT", "NOT", 
		"LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
		"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
		"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "FOR", "IN", "DO", "DONE", 
		"NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", 
		"PAIR", "VAR", "CONST", "NEWTYPE", "UNION", "OF", "WHEN", "WHERE", "FORALL", 
		"TRAIT", "REQUIRED", "INSTANCE", "BASE_TYPE", "INTEGER", "STRLIT", "CHARLIT", 
		"ASSIGN", "COMMA", "IDENT", "CAP_IDENT", "COMMENT", "WS"
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
			setState(100);
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(102);
				intsign();
				}
			}

			setState(105);
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
			setState(107);
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
			setState(109);
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
			setState(111);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				pairType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				capIdent();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(117);
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
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				setState(122);
				baseType();
				}
				break;
			case PAIR:
				{
				setState(123);
				pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				match(LBRA);
				setState(127);
				match(RBRA);
				}
				}
				setState(130); 
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
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
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
			setState(137);
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
			setState(139);
			match(PAIR);
			setState(140);
			match(LPAR);
			setState(141);
			((PairTypeContext)_localctx).first = pairElemType();
			setState(142);
			match(COMMA);
			setState(143);
			((PairTypeContext)_localctx).second = pairElemType();
			setState(144);
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
			setState(146);
			match(LT);
			setState(147);
			type();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(148);
				match(COMMA);
				setState(149);
				type();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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
			setState(157);
			type();
			setState(158);
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
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				structType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
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
			setState(164);
			match(LT);
			setState(165);
			((GenericTVarsContext)_localctx).tvar = capIdent();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(166);
				match(COMMA);
				setState(167);
				((GenericTVarsContext)_localctx).tvar = capIdent();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
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
			setState(175);
			match(NEWTYPE);
			setState(176);
			capIdent();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(177);
				genericTVars();
				}
			}

			setState(180);
			match(IS);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(181);
				member();
				setState(182);
				match(SEMICOLON);
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(189);
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
			setState(191);
			capIdent();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(192);
				match(OF);
				setState(193);
				match(LPAR);
				setState(194);
				member();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(195);
					match(COMMA);
					setState(196);
					member();
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(202);
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
			setState(206);
			match(NEWTYPE);
			setState(207);
			capIdent();
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(208);
				genericTVars();
				}
			}

			setState(211);
			match(IS);
			setState(212);
			match(UNION);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAP_IDENT) {
				{
				{
				setState(213);
				unionEntry();
				setState(214);
				match(SEMICOLON);
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
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

	public static class TraitInstanceContext extends ParserRuleContext {
		public CapIdentContext trait;
		public TerminalNode INSTANCE() { return getToken(WaccParser.INSTANCE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode COLON() { return getToken(WaccParser.COLON, 0); }
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(WaccParser.WHERE, 0); }
		public ConstraintListContext constraintList() {
			return getRuleContext(ConstraintListContext.class,0);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TraitInstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitInstance; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitTraitInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitInstanceContext traitInstance() throws RecognitionException {
		TraitInstanceContext _localctx = new TraitInstanceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_traitInstance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(INSTANCE);
			setState(224);
			type();
			setState(225);
			match(COLON);
			setState(226);
			((TraitInstanceContext)_localctx).trait = capIdent();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(227);
				match(WHERE);
				setState(228);
				constraintList();
				}
			}

			setState(231);
			match(IS);
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				func();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0) );
			setState(237);
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
		enterRule(_localctx, 36, RULE_enumRange);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new RangeFromToContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((RangeFromToContext)_localctx).from = expr(0);
				setState(240);
				match(DOTDOT);
				setState(241);
				((RangeFromToContext)_localctx).to = expr(0);
				}
				break;
			case 2:
				_localctx = new RangeFromThenToContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				((RangeFromThenToContext)_localctx).from = expr(0);
				setState(244);
				match(COMMA);
				setState(245);
				((RangeFromThenToContext)_localctx).then = expr(0);
				setState(246);
				match(DOTDOT);
				setState(247);
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
		enterRule(_localctx, 38, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
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
		enterRule(_localctx, 40, RULE_pairElemFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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
		enterRule(_localctx, 42, RULE_binop1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
		enterRule(_localctx, 44, RULE_binop2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
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
		enterRule(_localctx, 46, RULE_binop3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
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
		enterRule(_localctx, 48, RULE_binop4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		enterRule(_localctx, 50, RULE_binop5);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 52, RULE_binop6);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(268);
				match(LPAR);
				setState(269);
				expr(0);
				setState(270);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				ident();
				setState(273);
				match(LPAR);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)))) != 0)) {
					{
					setState(274);
					argList();
					}
				}

				setState(277);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExprIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(IF);
				setState(280);
				((ExprIfContext)_localctx).cond = expr(0);
				setState(281);
				match(THEN);
				setState(282);
				((ExprIfContext)_localctx).tr = expr(0);
				setState(283);
				match(ELSE);
				setState(284);
				((ExprIfContext)_localctx).fl = expr(0);
				setState(285);
				match(FI);
				}
				break;
			case 4:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				integer();
				}
				break;
			case 5:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				boolLit();
				}
				break;
			case 6:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(CHARLIT);
				}
				break;
			case 7:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(STRLIT);
				}
				break;
			case 8:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(NULL);
				}
				break;
			case 9:
				{
				_localctx = new ExprUnaryopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				unaryOp();
				setState(293);
				expr(3);
				}
				break;
			case 10:
				{
				_localctx = new ExprArrElemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				arrayElem();
				}
				break;
			case 11:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				ident();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(323);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(299);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(300);
						binop1();
						setState(301);
						((ExprBinopContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(304);
						binop2();
						setState(305);
						((ExprBinopContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(308);
						binop3();
						setState(309);
						((ExprBinopContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(312);
						binop4();
						setState(313);
						((ExprBinopContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(315);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(316);
						binop5();
						setState(317);
						((ExprBinopContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(320);
						binop6();
						setState(321);
						((ExprBinopContext)_localctx).right = expr(13);
						}
						break;
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 56, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			type();
			setState(329);
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
		enterRule(_localctx, 58, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			param();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(332);
				match(COMMA);
				setState(333);
				param();
				}
				}
				setState(338);
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
		enterRule(_localctx, 60, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			capIdent();
			setState(340);
			match(COLON);
			setState(341);
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
		enterRule(_localctx, 62, RULE_forallConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(FORALL);
			setState(344);
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
		enterRule(_localctx, 64, RULE_constraintList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP_IDENT:
				{
				setState(346);
				constraint();
				}
				break;
			case FORALL:
				{
				setState(347);
				forallConstraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(350);
				match(COMMA);
				setState(353);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CAP_IDENT:
					{
					setState(351);
					constraint();
					}
					break;
				case FORALL:
					{
					setState(352);
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
		enterRule(_localctx, 66, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			type();
			setState(358);
			ident();
			setState(359);
			match(LPAR);
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(360);
				paramList();
				}
			}

			setState(363);
			match(RPAR);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(364);
				match(WHERE);
				setState(365);
				constraintList();
				}
			}

			setState(368);
			match(IS);
			setState(369);
			stats();
			setState(370);
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
		enterRule(_localctx, 68, RULE_requiredFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			type();
			setState(373);
			ident();
			setState(374);
			match(LPAR);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(375);
				paramList();
				}
			}

			setState(378);
			match(RPAR);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(379);
				match(WHERE);
				setState(380);
				constraintList();
				}
			}

			setState(383);
			match(IS);
			setState(384);
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
		enterRule(_localctx, 70, RULE_traitDef);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(TRAIT);
			setState(387);
			((TraitDefContext)_localctx).tvar = capIdent();
			setState(388);
			match(COLON);
			setState(389);
			((TraitDefContext)_localctx).trait = capIdent();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(390);
				match(WHERE);
				setState(391);
				constraintList();
				}
			}

			setState(394);
			match(IS);
			setState(396); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(395);
					requiredFunc();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(398); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(400);
				func();
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406);
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
		enterRule(_localctx, 72, RULE_builtinFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
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
		enterRule(_localctx, 74, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(SKIP_STAT);
				}
				break;
			case 2:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(411);
					type();
					}
					break;
				case VAR:
					{
					setState(412);
					match(VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(415);
				ident();
				setState(416);
				match(ASSIGN);
				setState(417);
				assignRhs();
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				match(CONST);
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
					{
					setState(420);
					type();
					}
				}

				setState(423);
				ident();
				setState(424);
				match(ASSIGN);
				setState(425);
				assignRhs();
				}
				break;
			case 4:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				assignLhs();
				setState(428);
				match(ASSIGN);
				setState(429);
				assignRhs();
				}
				break;
			case 5:
				_localctx = new ReadCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(431);
				match(READ);
				setState(432);
				assignLhs();
				}
				break;
			case 6:
				_localctx = new BuiltinFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(433);
				builtinFunc();
				setState(434);
				expr(0);
				}
				break;
			case 7:
				_localctx = new CondBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(436);
				match(IF);
				setState(437);
				expr(0);
				setState(438);
				match(THEN);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(439);
					stats();
					}
				}

				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(450);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(442);
							match(ELSE);
							setState(443);
							match(IF);
							setState(444);
							expr(0);
							setState(445);
							match(THEN);
							setState(446);
							stats();
							}
							} 
						}
						setState(452);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
					}
					setState(453);
					match(ELSE);
					setState(455);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
						{
						setState(454);
						stats();
						}
					}

					}
				}

				setState(459);
				match(FI);
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(461);
				match(WHILE);
				setState(462);
				expr(0);
				setState(463);
				match(DO);
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(464);
					stats();
					}
				}

				setState(467);
				match(DONE);
				}
				break;
			case 9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(469);
				match(FOR);
				setState(472);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(470);
					type();
					}
					break;
				case VAR:
					{
					setState(471);
					match(VAR);
					}
					break;
				case IDENT:
					break;
				default:
					break;
				}
				setState(474);
				ident();
				setState(475);
				match(IN);
				setState(476);
				enumRange();
				setState(477);
				match(DO);
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(478);
					stats();
					}
				}

				setState(481);
				match(DONE);
				}
				break;
			case 10:
				_localctx = new WhenClauseContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(483);
				match(WHEN);
				setState(484);
				expr(0);
				setState(485);
				match(COLON);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IS) {
					{
					{
					setState(486);
					whenCase();
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(492);
				match(END);
				}
				break;
			case 11:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(494);
				match(BEGIN);
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(495);
					stats();
					}
				}

				setState(498);
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
		enterRule(_localctx, 76, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			capIdent();
			setState(513);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(502);
				match(LPAR);
				setState(503);
				ident();
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(504);
					match(COMMA);
					setState(505);
					ident();
					}
					}
					setState(510);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(511);
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
		enterRule(_localctx, 78, RULE_whenCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(IS);
			setState(516);
			pattern();
			setState(517);
			match(ARROW);
			setState(518);
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
		enterRule(_localctx, 80, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			stat();
			setState(521);
			match(SEMICOLON);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
				{
				{
				setState(522);
				stat();
				setState(523);
				match(SEMICOLON);
				}
				}
				setState(529);
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
		enterRule(_localctx, 82, RULE_assignLhs);
		try {
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(530);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(532);
				pairElem();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(533);
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
		enterRule(_localctx, 84, RULE_assignRhs);
		int _la;
		try {
			setState(556);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				expr(0);
				}
				break;
			case 2:
				_localctx = new RhsArrayLiterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				arrayLiter();
				}
				break;
			case 3:
				_localctx = new RhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				match(NEWPAIR);
				setState(539);
				match(LPAR);
				setState(540);
				expr(0);
				setState(541);
				match(COMMA);
				setState(542);
				expr(0);
				setState(543);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new RhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(545);
				pairElem();
				}
				break;
			case 5:
				_localctx = new RhsTypeMemberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(546);
				typeMember();
				}
				break;
			case 6:
				_localctx = new RhsTypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(547);
				typeConstructor();
				}
				break;
			case 7:
				_localctx = new RhsFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(548);
				match(CALL);
				setState(549);
				ident();
				setState(550);
				match(LPAR);
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)))) != 0)) {
					{
					setState(551);
					argList();
					}
				}

				setState(554);
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
		enterRule(_localctx, 86, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			expr(0);
			setState(563);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(559);
				match(COMMA);
				setState(560);
				expr(0);
				}
				}
				setState(565);
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
		enterRule(_localctx, 88, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			match(LBRA);
			setState(568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)))) != 0)) {
				{
				setState(567);
				argList();
				}
			}

			setState(570);
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
		enterRule(_localctx, 90, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			ident();
			setState(577); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(573);
					match(LBRA);
					setState(574);
					expr(0);
					setState(575);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(579); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
		enterRule(_localctx, 92, RULE_pairElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			pairElemFunc();
			setState(582);
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
		enterRule(_localctx, 94, RULE_typeMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			expr(0);
			setState(585);
			match(DOT);
			setState(586);
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
		enterRule(_localctx, 96, RULE_typeConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			capIdent();
			setState(589);
			match(LPAR);
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)))) != 0)) {
				{
				setState(590);
				argList();
				}
			}

			setState(593);
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
		public List<TraitInstanceContext> traitInstance() {
			return getRuleContexts(TraitInstanceContext.class);
		}
		public TraitInstanceContext traitInstance(int i) {
			return getRuleContext(TraitInstanceContext.class,i);
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
		enterRule(_localctx, 98, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(BEGIN);
			setState(602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(600);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NEWTYPE:
						{
						setState(596);
						newtype();
						}
						break;
					case PAIR:
					case BASE_TYPE:
					case CAP_IDENT:
						{
						setState(597);
						func();
						}
						break;
					case TRAIT:
						{
						setState(598);
						traitDef();
						}
						break;
					case INSTANCE:
						{
						setState(599);
						traitInstance();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(604);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
				{
				setState(605);
				stats();
				}
			}

			setState(608);
			match(END);
			setState(609);
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
		case 27:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u0266\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\3\5\3j\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7"+
		"y\n\7\5\7{\n\7\3\b\3\b\5\b\177\n\b\3\b\3\b\6\b\u0083\n\b\r\b\16\b\u0084"+
		"\3\t\3\t\3\t\5\t\u008a\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\5\16\u00a5\n\16\3\17\3\17\3\17\3\17\7\17\u00ab\n\17\f\17\16"+
		"\17\u00ae\13\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b5\n\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00bb\n\20\f\20\16\20\u00be\13\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00c8\n\21\f\21\16\21\u00cb\13\21\3\21\3\21\5\21"+
		"\u00cf\n\21\3\22\3\22\3\22\5\22\u00d4\n\22\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u00db\n\22\f\22\16\22\u00de\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00e8\n\23\3\23\3\23\6\23\u00ec\n\23\r\23\16\23\u00ed\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00fc"+
		"\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0116\n\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u012c\n\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\7\35\u0146\n\35\f\35\16\35\u0149\13\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\7\37\u0151\n\37\f\37\16\37\u0154\13\37\3 \3"+
		" \3 \3 \3!\3!\3!\3\"\3\"\5\"\u015f\n\"\3\"\3\"\3\"\5\"\u0164\n\"\5\"\u0166"+
		"\n\"\3#\3#\3#\3#\5#\u016c\n#\3#\3#\3#\5#\u0171\n#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\5$\u017b\n$\3$\3$\3$\5$\u0180\n$\3$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u018b"+
		"\n%\3%\3%\6%\u018f\n%\r%\16%\u0190\3%\7%\u0194\n%\f%\16%\u0197\13%\3%"+
		"\3%\3&\3&\3\'\3\'\3\'\5\'\u01a0\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01a8"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\5\'\u01bb\n\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01c3\n\'\f\'\16\'\u01c6"+
		"\13\'\3\'\3\'\5\'\u01ca\n\'\5\'\u01cc\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'"+
		"\u01d4\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u01db\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u01e2"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01ea\n\'\f\'\16\'\u01ed\13\'\3\'\3\'"+
		"\3\'\3\'\5\'\u01f3\n\'\3\'\5\'\u01f6\n\'\3(\3(\3(\3(\3(\7(\u01fd\n(\f"+
		"(\16(\u0200\13(\3(\3(\5(\u0204\n(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\7*\u0210"+
		"\n*\f*\16*\u0213\13*\3+\3+\3+\3+\5+\u0219\n+\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\5,\u022b\n,\3,\3,\5,\u022f\n,\3-\3-\3-\7-\u0234"+
		"\n-\f-\16-\u0237\13-\3.\3.\5.\u023b\n.\3.\3.\3/\3/\3/\3/\3/\6/\u0244\n"+
		"/\r/\16/\u0245\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\5\62"+
		"\u0252\n\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\7\63\u025b\n\63\f\63\16"+
		"\63\u025e\13\63\3\63\5\63\u0261\n\63\3\63\3\63\3\63\3\63\2\38\64\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"+
		"VXZ\\^`bd\2\n\3\2\7\b\3\2\'(\4\2\b\b\25\30\3\2\31\32\3\2\t\13\3\2\f\17"+
		"\3\2\20\21\3\2\648\2\u0290\2f\3\2\2\2\4i\3\2\2\2\6m\3\2\2\2\bo\3\2\2\2"+
		"\nq\3\2\2\2\fz\3\2\2\2\16~\3\2\2\2\20\u0089\3\2\2\2\22\u008b\3\2\2\2\24"+
		"\u008d\3\2\2\2\26\u0094\3\2\2\2\30\u009f\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6"+
		"\3\2\2\2\36\u00b1\3\2\2\2 \u00c1\3\2\2\2\"\u00d0\3\2\2\2$\u00e1\3\2\2"+
		"\2&\u00fb\3\2\2\2(\u00fd\3\2\2\2*\u00ff\3\2\2\2,\u0101\3\2\2\2.\u0103"+
		"\3\2\2\2\60\u0105\3\2\2\2\62\u0107\3\2\2\2\64\u0109\3\2\2\2\66\u010b\3"+
		"\2\2\28\u012b\3\2\2\2:\u014a\3\2\2\2<\u014d\3\2\2\2>\u0155\3\2\2\2@\u0159"+
		"\3\2\2\2B\u015e\3\2\2\2D\u0167\3\2\2\2F\u0176\3\2\2\2H\u0184\3\2\2\2J"+
		"\u019a\3\2\2\2L\u01f5\3\2\2\2N\u01f7\3\2\2\2P\u0205\3\2\2\2R\u020a\3\2"+
		"\2\2T\u0218\3\2\2\2V\u022e\3\2\2\2X\u0230\3\2\2\2Z\u0238\3\2\2\2\\\u023e"+
		"\3\2\2\2^\u0247\3\2\2\2`\u024a\3\2\2\2b\u024e\3\2\2\2d\u0255\3\2\2\2f"+
		"g\t\2\2\2g\3\3\2\2\2hj\5\2\2\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2kl\7G\2\2"+
		"l\5\3\2\2\2mn\7L\2\2n\7\3\2\2\2op\7M\2\2p\t\3\2\2\2qr\t\3\2\2r\13\3\2"+
		"\2\2s{\5\16\b\2t{\5\22\n\2u{\5\24\13\2vx\5\b\5\2wy\5\26\f\2xw\3\2\2\2"+
		"xy\3\2\2\2y{\3\2\2\2zs\3\2\2\2zt\3\2\2\2zu\3\2\2\2zv\3\2\2\2{\r\3\2\2"+
		"\2|\177\5\22\n\2}\177\5\24\13\2~|\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2"+
		"\u0080\u0081\7\36\2\2\u0081\u0083\7\37\2\2\u0082\u0080\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086"+
		"\u008a\5\16\b\2\u0087\u008a\5\22\n\2\u0088\u008a\7:\2\2\u0089\u0086\3"+
		"\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\21\3\2\2\2\u008b"+
		"\u008c\7F\2\2\u008c\23\3\2\2\2\u008d\u008e\7:\2\2\u008e\u008f\7\34\2\2"+
		"\u008f\u0090\5\20\t\2\u0090\u0091\7K\2\2\u0091\u0092\5\20\t\2\u0092\u0093"+
		"\7\35\2\2\u0093\25\3\2\2\2\u0094\u0095\7\17\2\2\u0095\u009a\5\f\7\2\u0096"+
		"\u0097\7K\2\2\u0097\u0099\5\f\7\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7\r\2\2\u009e\27\3\2\2\2\u009f\u00a0\5\f\7"+
		"\2\u00a0\u00a1\5\6\4\2\u00a1\31\3\2\2\2\u00a2\u00a5\5\36\20\2\u00a3\u00a5"+
		"\5\"\22\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\33\3\2\2\2\u00a6"+
		"\u00a7\7\17\2\2\u00a7\u00ac\5\b\5\2\u00a8\u00a9\7K\2\2\u00a9\u00ab\5\b"+
		"\5\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7\r"+
		"\2\2\u00b0\35\3\2\2\2\u00b1\u00b2\7=\2\2\u00b2\u00b4\5\b\5\2\u00b3\u00b5"+
		"\5\34\17\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2"+
		"\u00b6\u00bc\7$\2\2\u00b7\u00b8\5\30\r\2\u00b8\u00b9\7\"\2\2\u00b9\u00bb"+
		"\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7%"+
		"\2\2\u00c0\37\3\2\2\2\u00c1\u00ce\5\b\5\2\u00c2\u00c3\7?\2\2\u00c3\u00c4"+
		"\7\34\2\2\u00c4\u00c9\5\30\r\2\u00c5\u00c6\7K\2\2\u00c6\u00c8\5\30\r\2"+
		"\u00c7\u00c5\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\35\2\2"+
		"\u00cd\u00cf\3\2\2\2\u00ce\u00c2\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf!\3"+
		"\2\2\2\u00d0\u00d1\7=\2\2\u00d1\u00d3\5\b\5\2\u00d2\u00d4\5\34\17\2\u00d3"+
		"\u00d2\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7$"+
		"\2\2\u00d6\u00dc\7>\2\2\u00d7\u00d8\5 \21\2\u00d8\u00d9\7\"\2\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df"+
		"\u00e0\7%\2\2\u00e0#\3\2\2\2\u00e1\u00e2\7E\2\2\u00e2\u00e3\5\f\7\2\u00e3"+
		"\u00e4\7\5\2\2\u00e4\u00e7\5\b\5\2\u00e5\u00e6\7A\2\2\u00e6\u00e8\5B\""+
		"\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb"+
		"\7$\2\2\u00ea\u00ec\5D#\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\7%"+
		"\2\2\u00f0%\3\2\2\2\u00f1\u00f2\58\35\2\u00f2\u00f3\7\24\2\2\u00f3\u00f4"+
		"\58\35\2\u00f4\u00fc\3\2\2\2\u00f5\u00f6\58\35\2\u00f6\u00f7\7K\2\2\u00f7"+
		"\u00f8\58\35\2\u00f8\u00f9\7\24\2\2\u00f9\u00fa\58\35\2\u00fa\u00fc\3"+
		"\2\2\2\u00fb\u00f1\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fc\'\3\2\2\2\u00fd\u00fe"+
		"\t\4\2\2\u00fe)\3\2\2\2\u00ff\u0100\t\5\2\2\u0100+\3\2\2\2\u0101\u0102"+
		"\t\6\2\2\u0102-\3\2\2\2\u0103\u0104\t\2\2\2\u0104/\3\2\2\2\u0105\u0106"+
		"\t\7\2\2\u0106\61\3\2\2\2\u0107\u0108\t\b\2\2\u0108\63\3\2\2\2\u0109\u010a"+
		"\7\22\2\2\u010a\65\3\2\2\2\u010b\u010c\7\23\2\2\u010c\67\3\2\2\2\u010d"+
		"\u010e\b\35\1\2\u010e\u010f\7\34\2\2\u010f\u0110\58\35\2\u0110\u0111\7"+
		"\35\2\2\u0111\u012c\3\2\2\2\u0112\u0113\5\6\4\2\u0113\u0115\7\34\2\2\u0114"+
		"\u0116\5X-\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2"+
		"\2\u0117\u0118\7\35\2\2\u0118\u012c\3\2\2\2\u0119\u011a\7)\2\2\u011a\u011b"+
		"\58\35\2\u011b\u011c\7*\2\2\u011c\u011d\58\35\2\u011d\u011e\7+\2\2\u011e"+
		"\u011f\58\35\2\u011f\u0120\7,\2\2\u0120\u012c\3\2\2\2\u0121\u012c\5\4"+
		"\3\2\u0122\u012c\5\n\6\2\u0123\u012c\7I\2\2\u0124\u012c\7H\2\2\u0125\u012c"+
		"\7&\2\2\u0126\u0127\5(\25\2\u0127\u0128\58\35\5\u0128\u012c\3\2\2\2\u0129"+
		"\u012c\5\\/\2\u012a\u012c\5\6\4\2\u012b\u010d\3\2\2\2\u012b\u0112\3\2"+
		"\2\2\u012b\u0119\3\2\2\2\u012b\u0121\3\2\2\2\u012b\u0122\3\2\2\2\u012b"+
		"\u0123\3\2\2\2\u012b\u0124\3\2\2\2\u012b\u0125\3\2\2\2\u012b\u0126\3\2"+
		"\2\2\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\u0147\3\2\2\2\u012d"+
		"\u012e\f\23\2\2\u012e\u012f\5,\27\2\u012f\u0130\58\35\24\u0130\u0146\3"+
		"\2\2\2\u0131\u0132\f\22\2\2\u0132\u0133\5.\30\2\u0133\u0134\58\35\23\u0134"+
		"\u0146\3\2\2\2\u0135\u0136\f\21\2\2\u0136\u0137\5\60\31\2\u0137\u0138"+
		"\58\35\22\u0138\u0146\3\2\2\2\u0139\u013a\f\20\2\2\u013a\u013b\5\62\32"+
		"\2\u013b\u013c\58\35\21\u013c\u0146\3\2\2\2\u013d\u013e\f\17\2\2\u013e"+
		"\u013f\5\64\33\2\u013f\u0140\58\35\20\u0140\u0146\3\2\2\2\u0141\u0142"+
		"\f\16\2\2\u0142\u0143\5\66\34\2\u0143\u0144\58\35\17\u0144\u0146\3\2\2"+
		"\2\u0145\u012d\3\2\2\2\u0145\u0131\3\2\2\2\u0145\u0135\3\2\2\2\u0145\u0139"+
		"\3\2\2\2\u0145\u013d\3\2\2\2\u0145\u0141\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u01489\3\2\2\2\u0149\u0147\3\2\2\2"+
		"\u014a\u014b\5\f\7\2\u014b\u014c\5\6\4\2\u014c;\3\2\2\2\u014d\u0152\5"+
		":\36\2\u014e\u014f\7K\2\2\u014f\u0151\5:\36\2\u0150\u014e\3\2\2\2\u0151"+
		"\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153=\3\2\2\2"+
		"\u0154\u0152\3\2\2\2\u0155\u0156\5\b\5\2\u0156\u0157\7\5\2\2\u0157\u0158"+
		"\5\b\5\2\u0158?\3\2\2\2\u0159\u015a\7B\2\2\u015a\u015b\5\b\5\2\u015bA"+
		"\3\2\2\2\u015c\u015f\5> \2\u015d\u015f\5@!\2\u015e\u015c\3\2\2\2\u015e"+
		"\u015d\3\2\2\2\u015f\u0165\3\2\2\2\u0160\u0163\7K\2\2\u0161\u0164\5> "+
		"\2\u0162\u0164\5@!\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164\u0166"+
		"\3\2\2\2\u0165\u0160\3\2\2\2\u0165\u0166\3\2\2\2\u0166C\3\2\2\2\u0167"+
		"\u0168\5\f\7\2\u0168\u0169\5\6\4\2\u0169\u016b\7\34\2\2\u016a\u016c\5"+
		"<\37\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u0170\7\35\2\2\u016e\u016f\7A\2\2\u016f\u0171\5B\"\2\u0170\u016e\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0173\7$\2\2\u0173"+
		"\u0174\5R*\2\u0174\u0175\7%\2\2\u0175E\3\2\2\2\u0176\u0177\5\f\7\2\u0177"+
		"\u0178\5\6\4\2\u0178\u017a\7\34\2\2\u0179\u017b\5<\37\2\u017a\u0179\3"+
		"\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\7\35\2\2\u017d"+
		"\u017e\7A\2\2\u017e\u0180\5B\"\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2"+
		"\2\u0180\u0181\3\2\2\2\u0181\u0182\7$\2\2\u0182\u0183\7D\2\2\u0183G\3"+
		"\2\2\2\u0184\u0185\7C\2\2\u0185\u0186\5\b\5\2\u0186\u0187\7\5\2\2\u0187"+
		"\u018a\5\b\5\2\u0188\u0189\7A\2\2\u0189\u018b\5B\"\2\u018a\u0188\3\2\2"+
		"\2\u018a\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018e\7$\2\2\u018d\u018f"+
		"\5F$\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0195\3\2\2\2\u0192\u0194\5D#\2\u0193\u0192\3\2\2"+
		"\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198"+
		"\3\2\2\2\u0197\u0195\3\2\2\2\u0198\u0199\7%\2\2\u0199I\3\2\2\2\u019a\u019b"+
		"\t\t\2\2\u019bK\3\2\2\2\u019c\u01f6\7\33\2\2\u019d\u01a0\5\f\7\2\u019e"+
		"\u01a0\7;\2\2\u019f\u019d\3\2\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3\2"+
		"\2\2\u01a1\u01a2\5\6\4\2\u01a2\u01a3\7J\2\2\u01a3\u01a4\5V,\2\u01a4\u01f6"+
		"\3\2\2\2\u01a5\u01a7\7<\2\2\u01a6\u01a8\5\f\7\2\u01a7\u01a6\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\5\6\4\2\u01aa\u01ab\7J"+
		"\2\2\u01ab\u01ac\5V,\2\u01ac\u01f6\3\2\2\2\u01ad\u01ae\5T+\2\u01ae\u01af"+
		"\7J\2\2\u01af\u01b0\5V,\2\u01b0\u01f6\3\2\2\2\u01b1\u01b2\7\63\2\2\u01b2"+
		"\u01f6\5T+\2\u01b3\u01b4\5J&\2\u01b4\u01b5\58\35\2\u01b5\u01f6\3\2\2\2"+
		"\u01b6\u01b7\7)\2\2\u01b7\u01b8\58\35\2\u01b8\u01ba\7*\2\2\u01b9\u01bb"+
		"\5R*\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01cb\3\2\2\2\u01bc"+
		"\u01bd\7+\2\2\u01bd\u01be\7)\2\2\u01be\u01bf\58\35\2\u01bf\u01c0\7*\2"+
		"\2\u01c0\u01c1\5R*\2\u01c1\u01c3\3\2\2\2\u01c2\u01bc\3\2\2\2\u01c3\u01c6"+
		"\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7\u01c9\7+\2\2\u01c8\u01ca\5R*\2\u01c9\u01c8\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01c4\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01ce\7,\2\2\u01ce\u01f6\3\2\2\2\u01cf"+
		"\u01d0\7-\2\2\u01d0\u01d1\58\35\2\u01d1\u01d3\7\60\2\2\u01d2\u01d4\5R"+
		"*\2\u01d3\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d6\7\61\2\2\u01d6\u01f6\3\2\2\2\u01d7\u01da\7.\2\2\u01d8\u01db\5\f"+
		"\7\2\u01d9\u01db\7;\2\2\u01da\u01d8\3\2\2\2\u01da\u01d9\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01dd\5\6\4\2\u01dd\u01de\7/"+
		"\2\2\u01de\u01df\5&\24\2\u01df\u01e1\7\60\2\2\u01e0\u01e2\5R*\2\u01e1"+
		"\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\7\61"+
		"\2\2\u01e4\u01f6\3\2\2\2\u01e5\u01e6\7@\2\2\u01e6\u01e7\58\35\2\u01e7"+
		"\u01eb\7\5\2\2\u01e8\u01ea\5P)\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2"+
		"\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb"+
		"\3\2\2\2\u01ee\u01ef\7%\2\2\u01ef\u01f6\3\2\2\2\u01f0\u01f2\7#\2\2\u01f1"+
		"\u01f3\5R*\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2\2"+
		"\2\u01f4\u01f6\7%\2\2\u01f5\u019c\3\2\2\2\u01f5\u019f\3\2\2\2\u01f5\u01a5"+
		"\3\2\2\2\u01f5\u01ad\3\2\2\2\u01f5\u01b1\3\2\2\2\u01f5\u01b3\3\2\2\2\u01f5"+
		"\u01b6\3\2\2\2\u01f5\u01cf\3\2\2\2\u01f5\u01d7\3\2\2\2\u01f5\u01e5\3\2"+
		"\2\2\u01f5\u01f0\3\2\2\2\u01f6M\3\2\2\2\u01f7\u0203\5\b\5\2\u01f8\u01f9"+
		"\7\34\2\2\u01f9\u01fe\5\6\4\2\u01fa\u01fb\7K\2\2\u01fb\u01fd\5\6\4\2\u01fc"+
		"\u01fa\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2"+
		"\2\2\u01ff\u0201\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0202\7\35\2\2\u0202"+
		"\u0204\3\2\2\2\u0203\u01f8\3\2\2\2\u0203\u0204\3\2\2\2\u0204O\3\2\2\2"+
		"\u0205\u0206\7$\2\2\u0206\u0207\5N(\2\u0207\u0208\7\3\2\2\u0208\u0209"+
		"\5R*\2\u0209Q\3\2\2\2\u020a\u020b\5L\'\2\u020b\u0211\7\"\2\2\u020c\u020d"+
		"\5L\'\2\u020d\u020e\7\"\2\2\u020e\u0210\3\2\2\2\u020f\u020c\3\2\2\2\u0210"+
		"\u0213\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212S\3\2\2\2"+
		"\u0213\u0211\3\2\2\2\u0214\u0219\5\6\4\2\u0215\u0219\5\\/\2\u0216\u0219"+
		"\5^\60\2\u0217\u0219\5`\61\2\u0218\u0214\3\2\2\2\u0218\u0215\3\2\2\2\u0218"+
		"\u0216\3\2\2\2\u0218\u0217\3\2\2\2\u0219U\3\2\2\2\u021a\u022f\58\35\2"+
		"\u021b\u022f\5Z.\2\u021c\u021d\7\62\2\2\u021d\u021e\7\34\2\2\u021e\u021f"+
		"\58\35\2\u021f\u0220\7K\2\2\u0220\u0221\58\35\2\u0221\u0222\7\35\2\2\u0222"+
		"\u022f\3\2\2\2\u0223\u022f\5^\60\2\u0224\u022f\5`\61\2\u0225\u022f\5b"+
		"\62\2\u0226\u0227\79\2\2\u0227\u0228\5\6\4\2\u0228\u022a\7\34\2\2\u0229"+
		"\u022b\5X-\2\u022a\u0229\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022c\3\2\2"+
		"\2\u022c\u022d\7\35\2\2\u022d\u022f\3\2\2\2\u022e\u021a\3\2\2\2\u022e"+
		"\u021b\3\2\2\2\u022e\u021c\3\2\2\2\u022e\u0223\3\2\2\2\u022e\u0224\3\2"+
		"\2\2\u022e\u0225\3\2\2\2\u022e\u0226\3\2\2\2\u022fW\3\2\2\2\u0230\u0235"+
		"\58\35\2\u0231\u0232\7K\2\2\u0232\u0234\58\35\2\u0233\u0231\3\2\2\2\u0234"+
		"\u0237\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0236\3\2\2\2\u0236Y\3\2\2\2"+
		"\u0237\u0235\3\2\2\2\u0238\u023a\7\36\2\2\u0239\u023b\5X-\2\u023a\u0239"+
		"\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023d\7\37\2\2"+
		"\u023d[\3\2\2\2\u023e\u0243\5\6\4\2\u023f\u0240\7\36\2\2\u0240\u0241\5"+
		"8\35\2\u0241\u0242\7\37\2\2\u0242\u0244\3\2\2\2\u0243\u023f\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246]\3\2\2\2"+
		"\u0247\u0248\5*\26\2\u0248\u0249\58\35\2\u0249_\3\2\2\2\u024a\u024b\5"+
		"8\35\2\u024b\u024c\7\6\2\2\u024c\u024d\5\6\4\2\u024da\3\2\2\2\u024e\u024f"+
		"\5\b\5\2\u024f\u0251\7\34\2\2\u0250\u0252\5X-\2\u0251\u0250\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\7\35\2\2\u0254c\3\2\2\2"+
		"\u0255\u025c\7#\2\2\u0256\u025b\5\32\16\2\u0257\u025b\5D#\2\u0258\u025b"+
		"\5H%\2\u0259\u025b\5$\23\2\u025a\u0256\3\2\2\2\u025a\u0257\3\2\2\2\u025a"+
		"\u0258\3\2\2\2\u025a\u0259\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2"+
		"\2\2\u025c\u025d\3\2\2\2\u025d\u0260\3\2\2\2\u025e\u025c\3\2\2\2\u025f"+
		"\u0261\5R*\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0262\3\2\2"+
		"\2\u0262\u0263\7%\2\2\u0263\u0264\7\2\2\3\u0264e\3\2\2\2<ixz~\u0084\u0089"+
		"\u009a\u00a4\u00ac\u00b4\u00bc\u00c9\u00ce\u00d3\u00dc\u00e7\u00ed\u00fb"+
		"\u0115\u012b\u0145\u0147\u0152\u015e\u0163\u0165\u016b\u0170\u017a\u017f"+
		"\u018a\u0190\u0195\u019f\u01a7\u01ba\u01c4\u01c9\u01cb\u01d3\u01da\u01e1"+
		"\u01eb\u01f2\u01f5\u01fe\u0203\u0211\u0218\u022a\u022e\u0235\u023a\u0245"+
		"\u0251\u025a\u025c\u0260";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}