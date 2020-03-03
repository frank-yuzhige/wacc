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
		UNION=60, OF=61, WHEN=62, BASE_TYPE=63, INTEGER=64, STRLIT=65, CHARLIT=66, 
		ASSIGN=67, COMMA=68, IDENT=69, CAP_IDENT=70, COMMENT=71, WS=72;
	public static final int
		RULE_intsign = 0, RULE_integer = 1, RULE_ident = 2, RULE_capIdent = 3, 
		RULE_boolLit = 4, RULE_type = 5, RULE_arrayType = 6, RULE_pairElemType = 7, 
		RULE_baseType = 8, RULE_pairType = 9, RULE_member = 10, RULE_newtype = 11, 
		RULE_structType = 12, RULE_unionEntry = 13, RULE_taggedUnion = 14, RULE_enumRange = 15, 
		RULE_unaryOp = 16, RULE_pairElemFunc = 17, RULE_binop1 = 18, RULE_binop2 = 19, 
		RULE_binop3 = 20, RULE_binop4 = 21, RULE_binop5 = 22, RULE_binop6 = 23, 
		RULE_expr = 24, RULE_param = 25, RULE_paramList = 26, RULE_func = 27, 
		RULE_builtinFunc = 28, RULE_stat = 29, RULE_pattern = 30, RULE_whenCase = 31, 
		RULE_stats = 32, RULE_assignLhs = 33, RULE_assignRhs = 34, RULE_argList = 35, 
		RULE_arrayLiter = 36, RULE_arrayElem = 37, RULE_pairElem = 38, RULE_typeMember = 39, 
		RULE_typeConstructor = 40, RULE_prog = 41;
	public static final String[] ruleNames = {
		"intsign", "integer", "ident", "capIdent", "boolLit", "type", "arrayType", 
		"pairElemType", "baseType", "pairType", "member", "newtype", "structType", 
		"unionEntry", "taggedUnion", "enumRange", "unaryOp", "pairElemFunc", "binop1", 
		"binop2", "binop3", "binop4", "binop5", "binop6", "expr", "param", "paramList", 
		"func", "builtinFunc", "stat", "pattern", "whenCase", "stats", "assignLhs", 
		"assignRhs", "argList", "arrayLiter", "arrayElem", "pairElem", "typeMember", 
		"typeConstructor", "prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'->'", "'=>'", "':'", "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'>='", "'>'", "'<='", "'<'", "'=='", "'!='", "'&&'", "'||'", "'..'", 
		"'!'", "'len'", "'ord'", "'chr'", "'fst'", "'snd'", "'skip'", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "'begin'", "'is'", "'end'", "'null'", 
		"'true'", "'false'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'for'", 
		"'in'", "'do'", "'done'", "'newpair'", "'read'", "'free'", "'return'", 
		"'exit'", "'print'", "'println'", "'call'", "'pair'", "'var'", "'const'", 
		"'newtype'", "'union'", "'of'", "'when'", null, null, null, null, "'='", 
		"','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ARROW", "DOUBLE_ARROW", "COLON", "DOT", "ADD", "SUB", "MUL", "DIV", 
		"MOD", "GTE", "GT", "LTE", "LT", "EQ", "NEQ", "AND", "OR", "DOTDOT", "NOT", 
		"LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
		"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
		"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "FOR", "IN", "DO", "DONE", 
		"NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", 
		"PAIR", "VAR", "CONST", "NEWTYPE", "UNION", "OF", "WHEN", "BASE_TYPE", 
		"INTEGER", "STRLIT", "CHARLIT", "ASSIGN", "COMMA", "IDENT", "CAP_IDENT", 
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
			setState(84);
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
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(86);
				intsign();
				}
			}

			setState(89);
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
			setState(93);
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
			setState(95);
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
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				pairType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				capIdent();
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
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BASE_TYPE:
				{
				setState(103);
				baseType();
				}
				break;
			case PAIR:
				{
				setState(104);
				pairType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				match(LBRA);
				setState(108);
				match(RBRA);
				}
				}
				setState(111); 
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
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
			setState(118);
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
			setState(120);
			match(PAIR);
			setState(121);
			match(LPAR);
			setState(122);
			((PairTypeContext)_localctx).first = pairElemType();
			setState(123);
			match(COMMA);
			setState(124);
			((PairTypeContext)_localctx).second = pairElemType();
			setState(125);
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
		enterRule(_localctx, 20, RULE_member);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			type();
			setState(128);
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
		enterRule(_localctx, 22, RULE_newtype);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				structType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
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

	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode NEWTYPE() { return getToken(WaccParser.NEWTYPE, 0); }
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public TerminalNode IS() { return getToken(WaccParser.IS, 0); }
		public TerminalNode END() { return getToken(WaccParser.END, 0); }
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
		enterRule(_localctx, 24, RULE_structType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(NEWTYPE);
			setState(135);
			capIdent();
			setState(136);
			match(IS);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(137);
				member();
				setState(138);
				match(SEMICOLON);
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
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
		enterRule(_localctx, 26, RULE_unionEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			capIdent();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(148);
				match(OF);
				setState(149);
				match(LPAR);
				setState(150);
				member();
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(151);
					match(COMMA);
					setState(152);
					member();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158);
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
		enterRule(_localctx, 28, RULE_taggedUnion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(NEWTYPE);
			setState(163);
			capIdent();
			setState(164);
			match(IS);
			setState(165);
			match(UNION);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAP_IDENT) {
				{
				{
				setState(166);
				unionEntry();
				setState(167);
				match(SEMICOLON);
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
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
		enterRule(_localctx, 30, RULE_enumRange);
		try {
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new RangeFromToContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((RangeFromToContext)_localctx).from = expr(0);
				setState(177);
				match(DOTDOT);
				setState(178);
				((RangeFromToContext)_localctx).to = expr(0);
				}
				break;
			case 2:
				_localctx = new RangeFromThenToContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				((RangeFromThenToContext)_localctx).from = expr(0);
				setState(181);
				match(COMMA);
				setState(182);
				((RangeFromThenToContext)_localctx).then = expr(0);
				setState(183);
				match(DOTDOT);
				setState(184);
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
		enterRule(_localctx, 32, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 34, RULE_pairElemFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		enterRule(_localctx, 36, RULE_binop1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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
		enterRule(_localctx, 38, RULE_binop2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
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
		enterRule(_localctx, 40, RULE_binop3);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
		enterRule(_localctx, 42, RULE_binop4);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
		enterRule(_localctx, 44, RULE_binop5);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
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
		enterRule(_localctx, 46, RULE_binop6);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(205);
				match(LPAR);
				setState(206);
				expr(0);
				setState(207);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new ExprFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				ident();
				setState(210);
				match(LPAR);
				setState(211);
				argList();
				setState(212);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new ExprIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(IF);
				setState(215);
				((ExprIfContext)_localctx).cond = expr(0);
				setState(216);
				match(THEN);
				setState(217);
				((ExprIfContext)_localctx).tr = expr(0);
				setState(218);
				match(ELSE);
				setState(219);
				((ExprIfContext)_localctx).fl = expr(0);
				setState(220);
				match(FI);
				}
				break;
			case 4:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				integer();
				}
				break;
			case 5:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				boolLit();
				}
				break;
			case 6:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(CHARLIT);
				}
				break;
			case 7:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(STRLIT);
				}
				break;
			case 8:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(NULL);
				}
				break;
			case 9:
				{
				_localctx = new ExprUnaryopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				unaryOp();
				setState(228);
				expr(3);
				}
				break;
			case 10:
				{
				_localctx = new ExprArrElemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				arrayElem();
				}
				break;
			case 11:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				ident();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(235);
						binop1();
						setState(236);
						((ExprBinopContext)_localctx).right = expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(239);
						binop2();
						setState(240);
						((ExprBinopContext)_localctx).right = expr(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(243);
						binop3();
						setState(244);
						((ExprBinopContext)_localctx).right = expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(247);
						binop4();
						setState(248);
						((ExprBinopContext)_localctx).right = expr(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(251);
						binop5();
						setState(252);
						((ExprBinopContext)_localctx).right = expr(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(255);
						binop6();
						setState(256);
						((ExprBinopContext)_localctx).right = expr(13);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 50, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			type();
			setState(264);
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
		enterRule(_localctx, 52, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			param();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267);
				match(COMMA);
				setState(268);
				param();
				}
				}
				setState(273);
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
		enterRule(_localctx, 54, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			type();
			setState(275);
			ident();
			setState(276);
			match(LPAR);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(277);
				paramList();
				}
			}

			setState(280);
			match(RPAR);
			setState(281);
			match(IS);
			setState(282);
			stats();
			setState(283);
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
		enterRule(_localctx, 56, RULE_builtinFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		enterRule(_localctx, 58, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(SKIP_STAT);
				}
				break;
			case 2:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(288);
					type();
					}
					break;
				case VAR:
					{
					setState(289);
					match(VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(292);
				ident();
				setState(293);
				match(ASSIGN);
				setState(294);
				assignRhs();
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(CONST);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
					{
					setState(297);
					type();
					}
				}

				setState(300);
				ident();
				setState(301);
				match(ASSIGN);
				setState(302);
				assignRhs();
				}
				break;
			case 4:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				assignLhs();
				setState(305);
				match(ASSIGN);
				setState(306);
				assignRhs();
				}
				break;
			case 5:
				_localctx = new ReadCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(308);
				match(READ);
				setState(309);
				assignLhs();
				}
				break;
			case 6:
				_localctx = new BuiltinFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(310);
				builtinFunc();
				setState(311);
				expr(0);
				}
				break;
			case 7:
				_localctx = new CondBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(313);
				match(IF);
				setState(314);
				expr(0);
				setState(315);
				match(THEN);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
					{
					setState(316);
					stats();
					}
				}

				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(327);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(319);
							match(ELSE);
							setState(320);
							match(IF);
							setState(321);
							expr(0);
							setState(322);
							match(THEN);
							setState(323);
							stats();
							}
							} 
						}
						setState(329);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					}
					setState(330);
					match(ELSE);
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
						{
						setState(331);
						stats();
						}
					}

					}
				}

				setState(336);
				match(FI);
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(338);
				match(WHILE);
				setState(339);
				expr(0);
				setState(340);
				match(DO);
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
					{
					setState(341);
					stats();
					}
				}

				setState(344);
				match(DONE);
				}
				break;
			case 9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(346);
				match(FOR);
				setState(349);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(347);
					type();
					}
					break;
				case VAR:
					{
					setState(348);
					match(VAR);
					}
					break;
				case IDENT:
					break;
				default:
					break;
				}
				setState(351);
				ident();
				setState(352);
				match(IN);
				setState(353);
				enumRange();
				setState(354);
				match(DO);
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
					{
					setState(355);
					stats();
					}
				}

				setState(358);
				match(DONE);
				}
				break;
			case 10:
				_localctx = new WhenClauseContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(360);
				match(WHEN);
				setState(361);
				expr(0);
				setState(362);
				match(COLON);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IS) {
					{
					{
					setState(363);
					whenCase();
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				match(END);
				}
				break;
			case 11:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(371);
				match(BEGIN);
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
					{
					setState(372);
					stats();
					}
				}

				setState(375);
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
		enterRule(_localctx, 60, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			capIdent();
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(379);
				match(LPAR);
				setState(380);
				ident();
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(381);
					match(COMMA);
					setState(382);
					ident();
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(388);
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
		enterRule(_localctx, 62, RULE_whenCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(IS);
			setState(393);
			pattern();
			setState(394);
			match(ARROW);
			setState(395);
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
		enterRule(_localctx, 64, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			stat();
			setState(398);
			match(SEMICOLON);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
				{
				{
				setState(399);
				stat();
				setState(400);
				match(SEMICOLON);
				}
				}
				setState(406);
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
		enterRule(_localctx, 66, RULE_assignLhs);
		try {
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(409);
				pairElem();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(410);
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
		enterRule(_localctx, 68, RULE_assignRhs);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				expr(0);
				}
				break;
			case 2:
				_localctx = new RhsArrayLiterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				arrayLiter();
				}
				break;
			case 3:
				_localctx = new RhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				match(NEWPAIR);
				setState(416);
				match(LPAR);
				setState(417);
				expr(0);
				setState(418);
				match(COMMA);
				setState(419);
				expr(0);
				setState(420);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new RhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				pairElem();
				}
				break;
			case 5:
				_localctx = new RhsTypeMemberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(423);
				typeMember();
				}
				break;
			case 6:
				_localctx = new RhsTypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				typeConstructor();
				}
				break;
			case 7:
				_localctx = new RhsFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(425);
				match(CALL);
				setState(426);
				ident();
				setState(427);
				match(LPAR);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)))) != 0)) {
					{
					setState(428);
					argList();
					}
				}

				setState(431);
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
		enterRule(_localctx, 70, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			expr(0);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(436);
				match(COMMA);
				setState(437);
				expr(0);
				}
				}
				setState(442);
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
		enterRule(_localctx, 72, RULE_arrayLiter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(LBRA);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)))) != 0)) {
				{
				setState(444);
				argList();
				}
			}

			setState(447);
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
		enterRule(_localctx, 74, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			ident();
			setState(454); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(450);
					match(LBRA);
					setState(451);
					expr(0);
					setState(452);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(456); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 76, RULE_pairElem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			pairElemFunc();
			setState(459);
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
		enterRule(_localctx, 78, RULE_typeMember);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			expr(0);
			setState(462);
			match(DOT);
			setState(463);
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
		enterRule(_localctx, 80, RULE_typeConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			capIdent();
			setState(466);
			match(LPAR);
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)))) != 0)) {
				{
				setState(467);
				argList();
				}
			}

			setState(470);
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
		enterRule(_localctx, 82, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(BEGIN);
			setState(476);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWTYPE) {
				{
				{
				setState(473);
				newtype();
				}
				}
				setState(478);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(482);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(479);
					func();
					}
					} 
				}
				setState(484);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN) | (1L << BASE_TYPE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (INTEGER - 64)) | (1L << (STRLIT - 64)) | (1L << (CHARLIT - 64)) | (1L << (IDENT - 64)) | (1L << (CAP_IDENT - 64)))) != 0)) {
				{
				setState(485);
				stats();
				}
			}

			setState(488);
			match(END);
			setState(489);
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
		case 24:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3J\u01ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\5\3Z\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5"+
		"\7h\n\7\3\b\3\b\5\bl\n\b\3\b\3\b\6\bp\n\b\r\b\16\bq\3\t\3\t\3\t\5\tw\n"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\5\r"+
		"\u0087\n\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u008f\n\16\f\16\16\16\u0092"+
		"\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u009c\n\17\f\17\16"+
		"\17\u009f\13\17\3\17\3\17\5\17\u00a3\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00ac\n\20\f\20\16\20\u00af\13\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00bd\n\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00eb"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0105\n\32"+
		"\f\32\16\32\u0108\13\32\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0110\n\34"+
		"\f\34\16\34\u0113\13\34\3\35\3\35\3\35\3\35\5\35\u0119\n\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3\37\5\37\u0125\n\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\5\37\u012d\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0140\n\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\7\37\u0148\n\37\f\37\16\37\u014b\13\37\3\37\3\37"+
		"\5\37\u014f\n\37\5\37\u0151\n\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0159"+
		"\n\37\3\37\3\37\3\37\3\37\3\37\5\37\u0160\n\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u0167\n\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u016f\n\37\f\37\16"+
		"\37\u0172\13\37\3\37\3\37\3\37\3\37\5\37\u0178\n\37\3\37\5\37\u017b\n"+
		"\37\3 \3 \3 \3 \3 \7 \u0182\n \f \16 \u0185\13 \3 \3 \5 \u0189\n \3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u0195\n\"\f\"\16\"\u0198\13\"\3#\3"+
		"#\3#\3#\5#\u019e\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5"+
		"$\u01b0\n$\3$\3$\5$\u01b4\n$\3%\3%\3%\7%\u01b9\n%\f%\16%\u01bc\13%\3&"+
		"\3&\5&\u01c0\n&\3&\3&\3\'\3\'\3\'\3\'\3\'\6\'\u01c9\n\'\r\'\16\'\u01ca"+
		"\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\5*\u01d7\n*\3*\3*\3+\3+\7+\u01dd\n+\f+"+
		"\16+\u01e0\13+\3+\7+\u01e3\n+\f+\16+\u01e6\13+\3+\5+\u01e9\n+\3+\3+\3"+
		"+\3+\2\3\62,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRT\2\n\3\2\7\b\3\2\'(\4\2\b\b\25\30\3\2\31\32\3\2\t\13"+
		"\3\2\f\17\3\2\20\21\3\2\648\2\u020d\2V\3\2\2\2\4Y\3\2\2\2\6]\3\2\2\2\b"+
		"_\3\2\2\2\na\3\2\2\2\fg\3\2\2\2\16k\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2\24"+
		"z\3\2\2\2\26\u0081\3\2\2\2\30\u0086\3\2\2\2\32\u0088\3\2\2\2\34\u0095"+
		"\3\2\2\2\36\u00a4\3\2\2\2 \u00bc\3\2\2\2\"\u00be\3\2\2\2$\u00c0\3\2\2"+
		"\2&\u00c2\3\2\2\2(\u00c4\3\2\2\2*\u00c6\3\2\2\2,\u00c8\3\2\2\2.\u00ca"+
		"\3\2\2\2\60\u00cc\3\2\2\2\62\u00ea\3\2\2\2\64\u0109\3\2\2\2\66\u010c\3"+
		"\2\2\28\u0114\3\2\2\2:\u011f\3\2\2\2<\u017a\3\2\2\2>\u017c\3\2\2\2@\u018a"+
		"\3\2\2\2B\u018f\3\2\2\2D\u019d\3\2\2\2F\u01b3\3\2\2\2H\u01b5\3\2\2\2J"+
		"\u01bd\3\2\2\2L\u01c3\3\2\2\2N\u01cc\3\2\2\2P\u01cf\3\2\2\2R\u01d3\3\2"+
		"\2\2T\u01da\3\2\2\2VW\t\2\2\2W\3\3\2\2\2XZ\5\2\2\2YX\3\2\2\2YZ\3\2\2\2"+
		"Z[\3\2\2\2[\\\7B\2\2\\\5\3\2\2\2]^\7G\2\2^\7\3\2\2\2_`\7H\2\2`\t\3\2\2"+
		"\2ab\t\3\2\2b\13\3\2\2\2ch\5\16\b\2dh\5\22\n\2eh\5\24\13\2fh\5\b\5\2g"+
		"c\3\2\2\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2h\r\3\2\2\2il\5\22\n\2jl\5\24\13"+
		"\2ki\3\2\2\2kj\3\2\2\2lo\3\2\2\2mn\7\36\2\2np\7\37\2\2om\3\2\2\2pq\3\2"+
		"\2\2qo\3\2\2\2qr\3\2\2\2r\17\3\2\2\2sw\5\16\b\2tw\5\22\n\2uw\7:\2\2vs"+
		"\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\21\3\2\2\2xy\7A\2\2y\23\3\2\2\2z{\7:\2\2"+
		"{|\7\34\2\2|}\5\20\t\2}~\7F\2\2~\177\5\20\t\2\177\u0080\7\35\2\2\u0080"+
		"\25\3\2\2\2\u0081\u0082\5\f\7\2\u0082\u0083\5\6\4\2\u0083\27\3\2\2\2\u0084"+
		"\u0087\5\32\16\2\u0085\u0087\5\36\20\2\u0086\u0084\3\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\31\3\2\2\2\u0088\u0089\7=\2\2\u0089\u008a\5\b\5\2\u008a"+
		"\u0090\7$\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7\"\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u008b\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7%"+
		"\2\2\u0094\33\3\2\2\2\u0095\u00a2\5\b\5\2\u0096\u0097\7?\2\2\u0097\u0098"+
		"\7\34\2\2\u0098\u009d\5\26\f\2\u0099\u009a\7F\2\2\u009a\u009c\5\26\f\2"+
		"\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\35\2\2"+
		"\u00a1\u00a3\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\35"+
		"\3\2\2\2\u00a4\u00a5\7=\2\2\u00a5\u00a6\5\b\5\2\u00a6\u00a7\7$\2\2\u00a7"+
		"\u00ad\7>\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\7\"\2\2\u00aa\u00ac\3"+
		"\2\2\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7%"+
		"\2\2\u00b1\37\3\2\2\2\u00b2\u00b3\5\62\32\2\u00b3\u00b4\7\24\2\2\u00b4"+
		"\u00b5\5\62\32\2\u00b5\u00bd\3\2\2\2\u00b6\u00b7\5\62\32\2\u00b7\u00b8"+
		"\7F\2\2\u00b8\u00b9\5\62\32\2\u00b9\u00ba\7\24\2\2\u00ba\u00bb\5\62\32"+
		"\2\u00bb\u00bd\3\2\2\2\u00bc\u00b2\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bd!"+
		"\3\2\2\2\u00be\u00bf\t\4\2\2\u00bf#\3\2\2\2\u00c0\u00c1\t\5\2\2\u00c1"+
		"%\3\2\2\2\u00c2\u00c3\t\6\2\2\u00c3\'\3\2\2\2\u00c4\u00c5\t\2\2\2\u00c5"+
		")\3\2\2\2\u00c6\u00c7\t\7\2\2\u00c7+\3\2\2\2\u00c8\u00c9\t\b\2\2\u00c9"+
		"-\3\2\2\2\u00ca\u00cb\7\22\2\2\u00cb/\3\2\2\2\u00cc\u00cd\7\23\2\2\u00cd"+
		"\61\3\2\2\2\u00ce\u00cf\b\32\1\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\5\62"+
		"\32\2\u00d1\u00d2\7\35\2\2\u00d2\u00eb\3\2\2\2\u00d3\u00d4\5\6\4\2\u00d4"+
		"\u00d5\7\34\2\2\u00d5\u00d6\5H%\2\u00d6\u00d7\7\35\2\2\u00d7\u00eb\3\2"+
		"\2\2\u00d8\u00d9\7)\2\2\u00d9\u00da\5\62\32\2\u00da\u00db\7*\2\2\u00db"+
		"\u00dc\5\62\32\2\u00dc\u00dd\7+\2\2\u00dd\u00de\5\62\32\2\u00de\u00df"+
		"\7,\2\2\u00df\u00eb\3\2\2\2\u00e0\u00eb\5\4\3\2\u00e1\u00eb\5\n\6\2\u00e2"+
		"\u00eb\7D\2\2\u00e3\u00eb\7C\2\2\u00e4\u00eb\7&\2\2\u00e5\u00e6\5\"\22"+
		"\2\u00e6\u00e7\5\62\32\5\u00e7\u00eb\3\2\2\2\u00e8\u00eb\5L\'\2\u00e9"+
		"\u00eb\5\6\4\2\u00ea\u00ce\3\2\2\2\u00ea\u00d3\3\2\2\2\u00ea\u00d8\3\2"+
		"\2\2\u00ea\u00e0\3\2\2\2\u00ea\u00e1\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea"+
		"\u00e3\3\2\2\2\u00ea\u00e4\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00eb\u0106\3\2\2\2\u00ec\u00ed\f\23\2\2\u00ed"+
		"\u00ee\5&\24\2\u00ee\u00ef\5\62\32\24\u00ef\u0105\3\2\2\2\u00f0\u00f1"+
		"\f\22\2\2\u00f1\u00f2\5(\25\2\u00f2\u00f3\5\62\32\23\u00f3\u0105\3\2\2"+
		"\2\u00f4\u00f5\f\21\2\2\u00f5\u00f6\5*\26\2\u00f6\u00f7\5\62\32\22\u00f7"+
		"\u0105\3\2\2\2\u00f8\u00f9\f\20\2\2\u00f9\u00fa\5,\27\2\u00fa\u00fb\5"+
		"\62\32\21\u00fb\u0105\3\2\2\2\u00fc\u00fd\f\17\2\2\u00fd\u00fe\5.\30\2"+
		"\u00fe\u00ff\5\62\32\20\u00ff\u0105\3\2\2\2\u0100\u0101\f\16\2\2\u0101"+
		"\u0102\5\60\31\2\u0102\u0103\5\62\32\17\u0103\u0105\3\2\2\2\u0104\u00ec"+
		"\3\2\2\2\u0104\u00f0\3\2\2\2\u0104\u00f4\3\2\2\2\u0104\u00f8\3\2\2\2\u0104"+
		"\u00fc\3\2\2\2\u0104\u0100\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\63\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a"+
		"\5\f\7\2\u010a\u010b\5\6\4\2\u010b\65\3\2\2\2\u010c\u0111\5\64\33\2\u010d"+
		"\u010e\7F\2\2\u010e\u0110\5\64\33\2\u010f\u010d\3\2\2\2\u0110\u0113\3"+
		"\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\67\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0115\5\f\7\2\u0115\u0116\5\6\4\2\u0116\u0118\7\34"+
		"\2\2\u0117\u0119\5\66\34\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\7\35\2\2\u011b\u011c\7$\2\2\u011c\u011d\5B"+
		"\"\2\u011d\u011e\7%\2\2\u011e9\3\2\2\2\u011f\u0120\t\t\2\2\u0120;\3\2"+
		"\2\2\u0121\u017b\7\33\2\2\u0122\u0125\5\f\7\2\u0123\u0125\7;\2\2\u0124"+
		"\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\5\6"+
		"\4\2\u0127\u0128\7E\2\2\u0128\u0129\5F$\2\u0129\u017b\3\2\2\2\u012a\u012c"+
		"\7<\2\2\u012b\u012d\5\f\7\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\5\6\4\2\u012f\u0130\7E\2\2\u0130\u0131\5F$"+
		"\2\u0131\u017b\3\2\2\2\u0132\u0133\5D#\2\u0133\u0134\7E\2\2\u0134\u0135"+
		"\5F$\2\u0135\u017b\3\2\2\2\u0136\u0137\7\63\2\2\u0137\u017b\5D#\2\u0138"+
		"\u0139\5:\36\2\u0139\u013a\5\62\32\2\u013a\u017b\3\2\2\2\u013b\u013c\7"+
		")\2\2\u013c\u013d\5\62\32\2\u013d\u013f\7*\2\2\u013e\u0140\5B\"\2\u013f"+
		"\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0150\3\2\2\2\u0141\u0142\7+"+
		"\2\2\u0142\u0143\7)\2\2\u0143\u0144\5\62\32\2\u0144\u0145\7*\2\2\u0145"+
		"\u0146\5B\"\2\u0146\u0148\3\2\2\2\u0147\u0141\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014e\7+\2\2\u014d\u014f\5B\"\2\u014e\u014d\3\2\2"+
		"\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u0149\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\7,\2\2\u0153\u017b\3\2\2\2\u0154"+
		"\u0155\7-\2\2\u0155\u0156\5\62\32\2\u0156\u0158\7\60\2\2\u0157\u0159\5"+
		"B\"\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015b\7\61\2\2\u015b\u017b\3\2\2\2\u015c\u015f\7.\2\2\u015d\u0160\5\f"+
		"\7\2\u015e\u0160\7;\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162\5\6\4\2\u0162\u0163\7/"+
		"\2\2\u0163\u0164\5 \21\2\u0164\u0166\7\60\2\2\u0165\u0167\5B\"\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\7\61"+
		"\2\2\u0169\u017b\3\2\2\2\u016a\u016b\7@\2\2\u016b\u016c\5\62\32\2\u016c"+
		"\u0170\7\5\2\2\u016d\u016f\5@!\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2"+
		"\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0173\u0174\7%\2\2\u0174\u017b\3\2\2\2\u0175\u0177\7#\2\2\u0176"+
		"\u0178\5B\"\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017b\7%\2\2\u017a\u0121\3\2\2\2\u017a\u0124\3\2\2\2\u017a"+
		"\u012a\3\2\2\2\u017a\u0132\3\2\2\2\u017a\u0136\3\2\2\2\u017a\u0138\3\2"+
		"\2\2\u017a\u013b\3\2\2\2\u017a\u0154\3\2\2\2\u017a\u015c\3\2\2\2\u017a"+
		"\u016a\3\2\2\2\u017a\u0175\3\2\2\2\u017b=\3\2\2\2\u017c\u0188\5\b\5\2"+
		"\u017d\u017e\7\34\2\2\u017e\u0183\5\6\4\2\u017f\u0180\7F\2\2\u0180\u0182"+
		"\5\6\4\2\u0181\u017f\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\35"+
		"\2\2\u0187\u0189\3\2\2\2\u0188\u017d\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"?\3\2\2\2\u018a\u018b\7$\2\2\u018b\u018c\5> \2\u018c\u018d\7\3\2\2\u018d"+
		"\u018e\5B\"\2\u018eA\3\2\2\2\u018f\u0190\5<\37\2\u0190\u0196\7\"\2\2\u0191"+
		"\u0192\5<\37\2\u0192\u0193\7\"\2\2\u0193\u0195\3\2\2\2\u0194\u0191\3\2"+
		"\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"C\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019e\5\6\4\2\u019a\u019e\5L\'\2\u019b"+
		"\u019e\5N(\2\u019c\u019e\5P)\2\u019d\u0199\3\2\2\2\u019d\u019a\3\2\2\2"+
		"\u019d\u019b\3\2\2\2\u019d\u019c\3\2\2\2\u019eE\3\2\2\2\u019f\u01b4\5"+
		"\62\32\2\u01a0\u01b4\5J&\2\u01a1\u01a2\7\62\2\2\u01a2\u01a3\7\34\2\2\u01a3"+
		"\u01a4\5\62\32\2\u01a4\u01a5\7F\2\2\u01a5\u01a6\5\62\32\2\u01a6\u01a7"+
		"\7\35\2\2\u01a7\u01b4\3\2\2\2\u01a8\u01b4\5N(\2\u01a9\u01b4\5P)\2\u01aa"+
		"\u01b4\5R*\2\u01ab\u01ac\79\2\2\u01ac\u01ad\5\6\4\2\u01ad\u01af\7\34\2"+
		"\2\u01ae\u01b0\5H%\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1"+
		"\3\2\2\2\u01b1\u01b2\7\35\2\2\u01b2\u01b4\3\2\2\2\u01b3\u019f\3\2\2\2"+
		"\u01b3\u01a0\3\2\2\2\u01b3\u01a1\3\2\2\2\u01b3\u01a8\3\2\2\2\u01b3\u01a9"+
		"\3\2\2\2\u01b3\u01aa\3\2\2\2\u01b3\u01ab\3\2\2\2\u01b4G\3\2\2\2\u01b5"+
		"\u01ba\5\62\32\2\u01b6\u01b7\7F\2\2\u01b7\u01b9\5\62\32\2\u01b8\u01b6"+
		"\3\2\2\2\u01b9\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"I\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01bf\7\36\2\2\u01be\u01c0\5H%\2\u01bf"+
		"\u01be\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\7\37"+
		"\2\2\u01c2K\3\2\2\2\u01c3\u01c8\5\6\4\2\u01c4\u01c5\7\36\2\2\u01c5\u01c6"+
		"\5\62\32\2\u01c6\u01c7\7\37\2\2\u01c7\u01c9\3\2\2\2\u01c8\u01c4\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cbM"+
		"\3\2\2\2\u01cc\u01cd\5$\23\2\u01cd\u01ce\5\62\32\2\u01ceO\3\2\2\2\u01cf"+
		"\u01d0\5\62\32\2\u01d0\u01d1\7\6\2\2\u01d1\u01d2\5\6\4\2\u01d2Q\3\2\2"+
		"\2\u01d3\u01d4\5\b\5\2\u01d4\u01d6\7\34\2\2\u01d5\u01d7\5H%\2\u01d6\u01d5"+
		"\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\7\35\2\2"+
		"\u01d9S\3\2\2\2\u01da\u01de\7#\2\2\u01db\u01dd\5\30\r\2\u01dc\u01db\3"+
		"\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df"+
		"\u01e4\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e3\58\35\2\u01e2\u01e1\3\2"+
		"\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5"+
		"\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e9\5B\"\2\u01e8\u01e7\3\2"+
		"\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01eb\7%\2\2\u01eb"+
		"\u01ec\7\2\2\3\u01ecU\3\2\2\2+Ygkqv\u0086\u0090\u009d\u00a2\u00ad\u00bc"+
		"\u00ea\u0104\u0106\u0111\u0118\u0124\u012c\u013f\u0149\u014e\u0150\u0158"+
		"\u015f\u0166\u0170\u0177\u017a\u0183\u0188\u0196\u019d\u01af\u01b3\u01ba"+
		"\u01bf\u01ca\u01d6\u01de\u01e4\u01e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}