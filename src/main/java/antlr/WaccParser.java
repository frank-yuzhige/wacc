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
		RULE_boolLit = 4, RULE_type = 5, RULE_arrayType = 6, RULE_baseType = 7, 
		RULE_pairType = 8, RULE_newType = 9, RULE_generics = 10, RULE_member = 11, 
		RULE_newTypeDef = 12, RULE_genericTVars = 13, RULE_structType = 14, RULE_unionEntry = 15, 
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
		"baseType", "pairType", "newType", "generics", "member", "newTypeDef", 
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
		public NewTypeContext newType() {
			return getRuleContext(NewTypeContext.class,0);
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
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
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
				newType();
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
		public NewTypeContext newType() {
			return getRuleContext(NewTypeContext.class,0);
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
				setState(119);
				baseType();
				}
				break;
			case PAIR:
				{
				setState(120);
				pairType();
				}
				break;
			case CAP_IDENT:
				{
				setState(121);
				newType();
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
		enterRule(_localctx, 14, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
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
		public TypeContext first;
		public TypeContext second;
		public TerminalNode PAIR() { return getToken(WaccParser.PAIR, 0); }
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(WaccParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
		enterRule(_localctx, 16, RULE_pairType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(PAIR);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(133);
				match(LPAR);
				setState(134);
				((PairTypeContext)_localctx).first = type();
				setState(135);
				match(COMMA);
				setState(136);
				((PairTypeContext)_localctx).second = type();
				setState(137);
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

	public static class NewTypeContext extends ParserRuleContext {
		public CapIdentContext capIdent() {
			return getRuleContext(CapIdentContext.class,0);
		}
		public GenericsContext generics() {
			return getRuleContext(GenericsContext.class,0);
		}
		public NewTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNewType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypeContext newType() throws RecognitionException {
		NewTypeContext _localctx = new NewTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_newType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			capIdent();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(142);
				generics();
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
			setState(145);
			match(LT);
			setState(146);
			type();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(147);
				match(COMMA);
				setState(148);
				type();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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

	public static class NewTypeDefContext extends ParserRuleContext {
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public TaggedUnionContext taggedUnion() {
			return getRuleContext(TaggedUnionContext.class,0);
		}
		public NewTypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTypeDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitNewTypeDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTypeDefContext newTypeDef() throws RecognitionException {
		NewTypeDefContext _localctx = new NewTypeDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_newTypeDef);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				structType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
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
			setState(163);
			match(LT);
			setState(164);
			((GenericTVarsContext)_localctx).tvar = capIdent();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(165);
				match(COMMA);
				setState(166);
				((GenericTVarsContext)_localctx).tvar = capIdent();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
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
			setState(174);
			match(NEWTYPE);
			setState(175);
			capIdent();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(176);
				genericTVars();
				}
			}

			setState(179);
			match(IS);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				{
				setState(180);
				member();
				setState(181);
				match(SEMICOLON);
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
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
			setState(190);
			capIdent();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OF) {
				{
				setState(191);
				match(OF);
				setState(192);
				match(LPAR);
				setState(193);
				member();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(194);
					match(COMMA);
					setState(195);
					member();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
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
			setState(205);
			match(NEWTYPE);
			setState(206);
			capIdent();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(207);
				genericTVars();
				}
			}

			setState(210);
			match(IS);
			setState(211);
			match(UNION);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAP_IDENT) {
				{
				{
				setState(212);
				unionEntry();
				setState(213);
				match(SEMICOLON);
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
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
			setState(222);
			match(INSTANCE);
			setState(223);
			type();
			setState(224);
			match(COLON);
			setState(225);
			((TraitInstanceContext)_localctx).trait = capIdent();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(226);
				match(WHERE);
				setState(227);
				constraintList();
				}
			}

			setState(230);
			match(IS);
			setState(232); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(231);
				func();
				}
				}
				setState(234); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0) );
			setState(236);
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
		public ExprContext from;
		public ExprContext to;
		public TerminalNode DOTDOT() { return getToken(WaccParser.DOTDOT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EnumRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumRange; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitEnumRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumRangeContext enumRange() throws RecognitionException {
		EnumRangeContext _localctx = new EnumRangeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_enumRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			((EnumRangeContext)_localctx).from = expr(0);
			setState(239);
			match(DOTDOT);
			setState(240);
			((EnumRangeContext)_localctx).to = expr(0);
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
			setState(242);
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
			setState(244);
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
			setState(246);
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
			setState(248);
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
			setState(250);
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
			setState(252);
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
			setState(254);
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
			setState(256);
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
	public static class ExprTypeConstructorContext extends ExprContext {
		public TypeConstructorContext typeConstructor() {
			return getRuleContext(TypeConstructorContext.class,0);
		}
		public ExprTypeConstructorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNewPairContext extends ExprContext {
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
		public ExprNewPairContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprNewPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprArrayLiterContext extends ExprContext {
		public ArrayLiterContext arrayLiter() {
			return getRuleContext(ArrayLiterContext.class,0);
		}
		public ExprArrayLiterContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprArrayLiter(this);
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
	public static class ExprVarMemberContext extends ExprContext {
		public IdentContext v;
		public IdentContext m;
		public TerminalNode DOT() { return getToken(WaccParser.DOT, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public ExprVarMemberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitExprVarMember(this);
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
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(259);
				match(LPAR);
				setState(260);
				expr(0);
				setState(261);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new ExprVarMemberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				((ExprVarMemberContext)_localctx).v = ident();
				setState(264);
				match(DOT);
				setState(265);
				((ExprVarMemberContext)_localctx).m = ident();
				}
				break;
			case 3:
				{
				_localctx = new ExprFuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				ident();
				setState(268);
				match(LPAR);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << LBRA) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << NEWPAIR))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)) | (1L << (CAP_IDENT - 69)))) != 0)) {
					{
					setState(269);
					argList();
					}
				}

				setState(272);
				match(RPAR);
				}
				break;
			case 4:
				{
				_localctx = new ExprTypeConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				typeConstructor();
				}
				break;
			case 5:
				{
				_localctx = new ExprArrayLiterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				arrayLiter();
				}
				break;
			case 6:
				{
				_localctx = new ExprNewPairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(NEWPAIR);
				setState(277);
				match(LPAR);
				setState(278);
				expr(0);
				setState(279);
				match(COMMA);
				setState(280);
				expr(0);
				setState(281);
				match(RPAR);
				}
				break;
			case 7:
				{
				_localctx = new ExprIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(IF);
				setState(284);
				((ExprIfContext)_localctx).cond = expr(0);
				setState(285);
				match(THEN);
				setState(286);
				((ExprIfContext)_localctx).tr = expr(0);
				setState(287);
				match(ELSE);
				setState(288);
				((ExprIfContext)_localctx).fl = expr(0);
				setState(289);
				match(FI);
				}
				break;
			case 8:
				{
				_localctx = new ExprIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				integer();
				}
				break;
			case 9:
				{
				_localctx = new ExprBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				boolLit();
				}
				break;
			case 10:
				{
				_localctx = new ExprCharContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				match(CHARLIT);
				}
				break;
			case 11:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				match(STRLIT);
				}
				break;
			case 12:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				match(NULL);
				}
				break;
			case 13:
				{
				_localctx = new ExprUnaryopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(296);
				unaryOp();
				setState(297);
				expr(3);
				}
				break;
			case 14:
				{
				_localctx = new ExprArrElemContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				arrayElem();
				}
				break;
			case 15:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				ident();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(327);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(303);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(304);
						binop1();
						setState(305);
						((ExprBinopContext)_localctx).right = expr(22);
						}
						break;
					case 2:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(308);
						binop2();
						setState(309);
						((ExprBinopContext)_localctx).right = expr(21);
						}
						break;
					case 3:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(311);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(312);
						binop3();
						setState(313);
						((ExprBinopContext)_localctx).right = expr(20);
						}
						break;
					case 4:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(315);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(316);
						binop4();
						setState(317);
						((ExprBinopContext)_localctx).right = expr(19);
						}
						break;
					case 5:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(320);
						binop5();
						setState(321);
						((ExprBinopContext)_localctx).right = expr(18);
						}
						break;
					case 6:
						{
						_localctx = new ExprBinopContext(new ExprContext(_parentctx, _parentState));
						((ExprBinopContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(323);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(324);
						binop6();
						setState(325);
						((ExprBinopContext)_localctx).right = expr(17);
						}
						break;
					}
					} 
				}
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
			setState(332);
			type();
			setState(333);
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
			setState(335);
			param();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(336);
				match(COMMA);
				setState(337);
				param();
				}
				}
				setState(342);
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
			setState(343);
			capIdent();
			setState(344);
			match(COLON);
			setState(345);
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
			setState(347);
			match(FORALL);
			setState(348);
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
		public List<TerminalNode> COMMA() { return getTokens(WaccParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WaccParser.COMMA, i);
		}
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
			setState(352);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CAP_IDENT:
				{
				setState(350);
				constraint();
				}
				break;
			case FORALL:
				{
				setState(351);
				forallConstraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(354);
				match(COMMA);
				setState(357);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CAP_IDENT:
					{
					setState(355);
					constraint();
					}
					break;
				case FORALL:
					{
					setState(356);
					forallConstraint();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(363);
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
			setState(364);
			type();
			setState(365);
			ident();
			setState(366);
			match(LPAR);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(367);
				paramList();
				}
			}

			setState(370);
			match(RPAR);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(371);
				match(WHERE);
				setState(372);
				constraintList();
				}
			}

			setState(375);
			match(IS);
			setState(376);
			stats();
			setState(377);
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
			setState(379);
			type();
			setState(380);
			ident();
			setState(381);
			match(LPAR);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
				{
				setState(382);
				paramList();
				}
			}

			setState(385);
			match(RPAR);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(386);
				match(WHERE);
				setState(387);
				constraintList();
				}
			}

			setState(390);
			match(IS);
			setState(391);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			match(TRAIT);
			setState(394);
			((TraitDefContext)_localctx).tvar = capIdent();
			setState(395);
			match(COLON);
			setState(396);
			((TraitDefContext)_localctx).trait = capIdent();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(397);
				match(WHERE);
				setState(398);
				constraintList();
				}
			}

			setState(401);
			match(IS);
			setState(403); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(402);
				requiredFunc();
				}
				}
				setState(405); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0) );
			setState(407);
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
			setState(409);
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
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public TerminalNode FI() { return getToken(WaccParser.FI, 0); }
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
	public static class VoidFuncCallContext extends StatContext {
		public TerminalNode CALL() { return getToken(WaccParser.CALL, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(WaccParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(WaccParser.RPAR, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public VoidFuncCallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WaccParserVisitor ) return ((WaccParserVisitor<? extends T>)visitor).visitVoidFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_stat);
		int _la;
		try {
			int _alt;
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new SkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(SKIP_STAT);
				}
				break;
			case 2:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(412);
					type();
					}
					break;
				case VAR:
					{
					setState(413);
					match(VAR);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(416);
				ident();
				setState(417);
				match(ASSIGN);
				setState(418);
				assignRhs();
				}
				break;
			case 3:
				_localctx = new ConstDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				match(CONST);
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (PAIR - 56)) | (1L << (BASE_TYPE - 56)) | (1L << (CAP_IDENT - 56)))) != 0)) {
					{
					setState(421);
					type();
					}
				}

				setState(424);
				ident();
				setState(425);
				match(ASSIGN);
				setState(426);
				assignRhs();
				}
				break;
			case 4:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(428);
				assignLhs();
				setState(429);
				match(ASSIGN);
				setState(430);
				assignRhs();
				}
				break;
			case 5:
				_localctx = new ReadCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(432);
				match(READ);
				setState(433);
				assignLhs();
				}
				break;
			case 6:
				_localctx = new BuiltinFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(434);
				builtinFunc();
				setState(435);
				expr(0);
				}
				break;
			case 7:
				_localctx = new CondBranchContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(437);
				match(IF);
				setState(438);
				expr(0);
				setState(439);
				match(THEN);
				setState(440);
				stats();
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(441);
						match(ELSE);
						setState(442);
						match(IF);
						setState(443);
						expr(0);
						setState(444);
						match(THEN);
						setState(445);
						stats();
						}
						} 
					}
					setState(451);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(452);
					match(ELSE);
					setState(453);
					stats();
					}
				}

				setState(456);
				match(FI);
				}
				break;
			case 8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(458);
				match(WHILE);
				setState(459);
				expr(0);
				setState(460);
				match(DO);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << LBRA) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << NEWPAIR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << CALL) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(461);
					stats();
					}
				}

				setState(464);
				match(DONE);
				}
				break;
			case 9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(466);
				match(FOR);
				setState(469);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PAIR:
				case BASE_TYPE:
				case CAP_IDENT:
					{
					setState(467);
					type();
					}
					break;
				case VAR:
					{
					setState(468);
					match(VAR);
					}
					break;
				case IDENT:
					break;
				default:
					break;
				}
				setState(471);
				ident();
				setState(472);
				match(IN);
				setState(473);
				enumRange();
				setState(474);
				match(DO);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << LBRA) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << NEWPAIR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << CALL) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(475);
					stats();
					}
				}

				setState(478);
				match(DONE);
				}
				break;
			case 10:
				_localctx = new WhenClauseContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(480);
				match(WHEN);
				setState(481);
				expr(0);
				setState(482);
				match(COLON);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IS) {
					{
					{
					setState(483);
					whenCase();
					}
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(489);
				match(END);
				}
				break;
			case 11:
				_localctx = new VoidFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(491);
				match(CALL);
				setState(492);
				ident();
				setState(493);
				match(LPAR);
				setState(495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << LBRA) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << NEWPAIR))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)) | (1L << (CAP_IDENT - 69)))) != 0)) {
					{
					setState(494);
					argList();
					}
				}

				setState(497);
				match(RPAR);
				}
				break;
			case 12:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(499);
				match(BEGIN);
				setState(501);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << LBRA) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << NEWPAIR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << CALL) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
					{
					setState(500);
					stats();
					}
				}

				setState(503);
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
			setState(506);
			capIdent();
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(507);
				match(LPAR);
				setState(508);
				ident();
				setState(513);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(509);
					match(COMMA);
					setState(510);
					ident();
					}
					}
					setState(515);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(516);
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
			setState(520);
			match(IS);
			setState(521);
			pattern();
			setState(522);
			match(ARROW);
			setState(523);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			stat();
			setState(530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(526);
					match(SEMICOLON);
					setState(527);
					stat();
					}
					} 
				}
				setState(532);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(533);
				match(SEMICOLON);
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
			setState(540);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(536);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(537);
				arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(538);
				pairElem();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(539);
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
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				_localctx = new RhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(542);
				expr(0);
				}
				break;
			case 2:
				_localctx = new RhsArrayLiterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
				arrayLiter();
				}
				break;
			case 3:
				_localctx = new RhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(544);
				match(NEWPAIR);
				setState(545);
				match(LPAR);
				setState(546);
				expr(0);
				setState(547);
				match(COMMA);
				setState(548);
				expr(0);
				setState(549);
				match(RPAR);
				}
				break;
			case 4:
				_localctx = new RhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(551);
				pairElem();
				}
				break;
			case 5:
				_localctx = new RhsTypeMemberContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(552);
				typeMember();
				}
				break;
			case 6:
				_localctx = new RhsFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(553);
				match(CALL);
				setState(554);
				ident();
				setState(555);
				match(LPAR);
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << LBRA) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << NEWPAIR))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)) | (1L << (CAP_IDENT - 69)))) != 0)) {
					{
					setState(556);
					argList();
					}
				}

				setState(559);
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
			setState(563);
			expr(0);
			setState(568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(564);
				match(COMMA);
				setState(565);
				expr(0);
				}
				}
				setState(570);
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
			setState(571);
			match(LBRA);
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << LBRA) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << NEWPAIR))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)) | (1L << (CAP_IDENT - 69)))) != 0)) {
				{
				setState(572);
				argList();
				}
			}

			setState(575);
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
			setState(577);
			ident();
			setState(582); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(578);
					match(LBRA);
					setState(579);
					expr(0);
					setState(580);
					match(RBRA);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(584); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
			setState(586);
			pairElemFunc();
			setState(587);
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
			setState(589);
			expr(0);
			setState(590);
			match(DOT);
			setState(591);
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
			setState(593);
			capIdent();
			setState(594);
			match(LPAR);
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << LPAR) | (1L << LBRA) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << NEWPAIR))) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (INTEGER - 69)) | (1L << (STRLIT - 69)) | (1L << (CHARLIT - 69)) | (1L << (IDENT - 69)) | (1L << (CAP_IDENT - 69)))) != 0)) {
				{
				setState(595);
				argList();
				}
			}

			setState(598);
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
		public List<NewTypeDefContext> newTypeDef() {
			return getRuleContexts(NewTypeDefContext.class);
		}
		public NewTypeDefContext newTypeDef(int i) {
			return getRuleContext(NewTypeDefContext.class,i);
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
			setState(600);
			match(BEGIN);
			setState(607);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(605);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NEWTYPE:
						{
						setState(601);
						newTypeDef();
						}
						break;
					case PAIR:
					case BASE_TYPE:
					case CAP_IDENT:
						{
						setState(602);
						func();
						}
						break;
					case TRAIT:
						{
						setState(603);
						traitDef();
						}
						break;
					case INSTANCE:
						{
						setState(604);
						traitInstance();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(611);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << FST) | (1L << SND) | (1L << SKIP_STAT) | (1L << LPAR) | (1L << LBRA) | (1L << BEGIN) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << NEWPAIR) | (1L << READ) | (1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN) | (1L << CALL) | (1L << PAIR) | (1L << VAR) | (1L << CONST) | (1L << WHEN))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (BASE_TYPE - 68)) | (1L << (INTEGER - 68)) | (1L << (STRLIT - 68)) | (1L << (CHARLIT - 68)) | (1L << (IDENT - 68)) | (1L << (CAP_IDENT - 68)))) != 0)) {
				{
				setState(610);
				stats();
				}
			}

			setState(613);
			match(END);
			setState(614);
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
			return precpred(_ctx, 21);
		case 1:
			return precpred(_ctx, 20);
		case 2:
			return precpred(_ctx, 19);
		case 3:
			return precpred(_ctx, 18);
		case 4:
			return precpred(_ctx, 17);
		case 5:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u026b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\3\5\3j\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\5\7x\n\7"+
		"\3\b\3\b\3\b\5\b}\n\b\3\b\3\b\6\b\u0081\n\b\r\b\16\b\u0082\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008e\n\n\3\13\3\13\5\13\u0092\n\13\3\f\3"+
		"\f\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\5\16\u00a4\n\16\3\17\3\17\3\17\3\17\7\17\u00aa\n\17\f\17\16\17\u00ad"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b4\n\20\3\20\3\20\3\20\3\20\7"+
		"\20\u00ba\n\20\f\20\16\20\u00bd\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\7\21\u00c7\n\21\f\21\16\21\u00ca\13\21\3\21\3\21\5\21\u00ce\n"+
		"\21\3\22\3\22\3\22\5\22\u00d3\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u00da"+
		"\n\22\f\22\16\22\u00dd\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u00e7\n\23\3\23\3\23\6\23\u00eb\n\23\r\23\16\23\u00ec\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0111\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0130\n\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u014a\n\35\f\35\16\35\u014d\13"+
		"\35\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u0155\n\37\f\37\16\37\u0158\13"+
		"\37\3 \3 \3 \3 \3!\3!\3!\3\"\3\"\5\"\u0163\n\"\3\"\3\"\3\"\5\"\u0168\n"+
		"\"\7\"\u016a\n\"\f\"\16\"\u016d\13\"\3#\3#\3#\3#\5#\u0173\n#\3#\3#\3#"+
		"\5#\u0178\n#\3#\3#\3#\3#\3$\3$\3$\3$\5$\u0182\n$\3$\3$\3$\5$\u0187\n$"+
		"\3$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u0192\n%\3%\3%\6%\u0196\n%\r%\16%\u0197"+
		"\3%\3%\3&\3&\3\'\3\'\3\'\5\'\u01a1\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01a9"+
		"\n\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01c2\n\'\f\'\16\'\u01c5\13\'\3\'\3\'\5"+
		"\'\u01c9\n\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01d1\n\'\3\'\3\'\3\'\3\'\3\'"+
		"\5\'\u01d8\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u01df\n\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\7\'\u01e7\n\'\f\'\16\'\u01ea\13\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01f2"+
		"\n\'\3\'\3\'\3\'\3\'\5\'\u01f8\n\'\3\'\5\'\u01fb\n\'\3(\3(\3(\3(\3(\7"+
		"(\u0202\n(\f(\16(\u0205\13(\3(\3(\5(\u0209\n(\3)\3)\3)\3)\3)\3*\3*\3*"+
		"\7*\u0213\n*\f*\16*\u0216\13*\3*\5*\u0219\n*\3+\3+\3+\3+\5+\u021f\n+\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0230\n,\3,\3,\5,\u0234"+
		"\n,\3-\3-\3-\7-\u0239\n-\f-\16-\u023c\13-\3.\3.\5.\u0240\n.\3.\3.\3/\3"+
		"/\3/\3/\3/\6/\u0249\n/\r/\16/\u024a\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\5\62\u0257\n\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\7\63"+
		"\u0260\n\63\f\63\16\63\u0263\13\63\3\63\5\63\u0266\n\63\3\63\3\63\3\63"+
		"\3\63\2\38\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bd\2\n\3\2\7\b\3\2\'(\4\2\b\b\25\30\3\2\31\32"+
		"\3\2\t\13\3\2\f\17\3\2\20\21\3\2\648\2\u0297\2f\3\2\2\2\4i\3\2\2\2\6m"+
		"\3\2\2\2\bo\3\2\2\2\nq\3\2\2\2\fw\3\2\2\2\16|\3\2\2\2\20\u0084\3\2\2\2"+
		"\22\u0086\3\2\2\2\24\u008f\3\2\2\2\26\u0093\3\2\2\2\30\u009e\3\2\2\2\32"+
		"\u00a3\3\2\2\2\34\u00a5\3\2\2\2\36\u00b0\3\2\2\2 \u00c0\3\2\2\2\"\u00cf"+
		"\3\2\2\2$\u00e0\3\2\2\2&\u00f0\3\2\2\2(\u00f4\3\2\2\2*\u00f6\3\2\2\2,"+
		"\u00f8\3\2\2\2.\u00fa\3\2\2\2\60\u00fc\3\2\2\2\62\u00fe\3\2\2\2\64\u0100"+
		"\3\2\2\2\66\u0102\3\2\2\28\u012f\3\2\2\2:\u014e\3\2\2\2<\u0151\3\2\2\2"+
		">\u0159\3\2\2\2@\u015d\3\2\2\2B\u0162\3\2\2\2D\u016e\3\2\2\2F\u017d\3"+
		"\2\2\2H\u018b\3\2\2\2J\u019b\3\2\2\2L\u01fa\3\2\2\2N\u01fc\3\2\2\2P\u020a"+
		"\3\2\2\2R\u020f\3\2\2\2T\u021e\3\2\2\2V\u0233\3\2\2\2X\u0235\3\2\2\2Z"+
		"\u023d\3\2\2\2\\\u0243\3\2\2\2^\u024c\3\2\2\2`\u024f\3\2\2\2b\u0253\3"+
		"\2\2\2d\u025a\3\2\2\2fg\t\2\2\2g\3\3\2\2\2hj\5\2\2\2ih\3\2\2\2ij\3\2\2"+
		"\2jk\3\2\2\2kl\7G\2\2l\5\3\2\2\2mn\7L\2\2n\7\3\2\2\2op\7M\2\2p\t\3\2\2"+
		"\2qr\t\3\2\2r\13\3\2\2\2sx\5\16\b\2tx\5\20\t\2ux\5\22\n\2vx\5\24\13\2"+
		"ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\r\3\2\2\2y}\5\20\t\2z}\5\22"+
		"\n\2{}\5\24\13\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~\177\7\36"+
		"\2\2\177\u0081\7\37\2\2\u0080~\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\17\3\2\2\2\u0084\u0085\7F\2\2\u0085"+
		"\21\3\2\2\2\u0086\u008d\7:\2\2\u0087\u0088\7\34\2\2\u0088\u0089\5\f\7"+
		"\2\u0089\u008a\7K\2\2\u008a\u008b\5\f\7\2\u008b\u008c\7\35\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u0087\3\2\2\2\u008d\u008e\3\2\2\2\u008e\23\3\2\2\2\u008f"+
		"\u0091\5\b\5\2\u0090\u0092\5\26\f\2\u0091\u0090\3\2\2\2\u0091\u0092\3"+
		"\2\2\2\u0092\25\3\2\2\2\u0093\u0094\7\17\2\2\u0094\u0099\5\f\7\2\u0095"+
		"\u0096\7K\2\2\u0096\u0098\5\f\7\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009d\7\r\2\2\u009d\27\3\2\2\2\u009e\u009f\5\f\7"+
		"\2\u009f\u00a0\5\6\4\2\u00a0\31\3\2\2\2\u00a1\u00a4\5\36\20\2\u00a2\u00a4"+
		"\5\"\22\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\33\3\2\2\2\u00a5"+
		"\u00a6\7\17\2\2\u00a6\u00ab\5\b\5\2\u00a7\u00a8\7K\2\2\u00a8\u00aa\5\b"+
		"\5\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\r"+
		"\2\2\u00af\35\3\2\2\2\u00b0\u00b1\7=\2\2\u00b1\u00b3\5\b\5\2\u00b2\u00b4"+
		"\5\34\17\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2"+
		"\u00b5\u00bb\7$\2\2\u00b6\u00b7\5\30\r\2\u00b7\u00b8\7\"\2\2\u00b8\u00ba"+
		"\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7%"+
		"\2\2\u00bf\37\3\2\2\2\u00c0\u00cd\5\b\5\2\u00c1\u00c2\7?\2\2\u00c2\u00c3"+
		"\7\34\2\2\u00c3\u00c8\5\30\r\2\u00c4\u00c5\7K\2\2\u00c5\u00c7\5\30\r\2"+
		"\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7\35\2\2"+
		"\u00cc\u00ce\3\2\2\2\u00cd\u00c1\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce!\3"+
		"\2\2\2\u00cf\u00d0\7=\2\2\u00d0\u00d2\5\b\5\2\u00d1\u00d3\5\34\17\2\u00d2"+
		"\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7$"+
		"\2\2\u00d5\u00db\7>\2\2\u00d6\u00d7\5 \21\2\u00d7\u00d8\7\"\2\2\u00d8"+
		"\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00df\7%\2\2\u00df#\3\2\2\2\u00e0\u00e1\7E\2\2\u00e1\u00e2\5\f\7\2\u00e2"+
		"\u00e3\7\5\2\2\u00e3\u00e6\5\b\5\2\u00e4\u00e5\7A\2\2\u00e5\u00e7\5B\""+
		"\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea"+
		"\7$\2\2\u00e9\u00eb\5D#\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7%"+
		"\2\2\u00ef%\3\2\2\2\u00f0\u00f1\58\35\2\u00f1\u00f2\7\24\2\2\u00f2\u00f3"+
		"\58\35\2\u00f3\'\3\2\2\2\u00f4\u00f5\t\4\2\2\u00f5)\3\2\2\2\u00f6\u00f7"+
		"\t\5\2\2\u00f7+\3\2\2\2\u00f8\u00f9\t\6\2\2\u00f9-\3\2\2\2\u00fa\u00fb"+
		"\t\2\2\2\u00fb/\3\2\2\2\u00fc\u00fd\t\7\2\2\u00fd\61\3\2\2\2\u00fe\u00ff"+
		"\t\b\2\2\u00ff\63\3\2\2\2\u0100\u0101\7\22\2\2\u0101\65\3\2\2\2\u0102"+
		"\u0103\7\23\2\2\u0103\67\3\2\2\2\u0104\u0105\b\35\1\2\u0105\u0106\7\34"+
		"\2\2\u0106\u0107\58\35\2\u0107\u0108\7\35\2\2\u0108\u0130\3\2\2\2\u0109"+
		"\u010a\5\6\4\2\u010a\u010b\7\6\2\2\u010b\u010c\5\6\4\2\u010c\u0130\3\2"+
		"\2\2\u010d\u010e\5\6\4\2\u010e\u0110\7\34\2\2\u010f\u0111\5X-\2\u0110"+
		"\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\35"+
		"\2\2\u0113\u0130\3\2\2\2\u0114\u0130\5b\62\2\u0115\u0130\5Z.\2\u0116\u0117"+
		"\7\62\2\2\u0117\u0118\7\34\2\2\u0118\u0119\58\35\2\u0119\u011a\7K\2\2"+
		"\u011a\u011b\58\35\2\u011b\u011c\7\35\2\2\u011c\u0130\3\2\2\2\u011d\u011e"+
		"\7)\2\2\u011e\u011f\58\35\2\u011f\u0120\7*\2\2\u0120\u0121\58\35\2\u0121"+
		"\u0122\7+\2\2\u0122\u0123\58\35\2\u0123\u0124\7,\2\2\u0124\u0130\3\2\2"+
		"\2\u0125\u0130\5\4\3\2\u0126\u0130\5\n\6\2\u0127\u0130\7I\2\2\u0128\u0130"+
		"\7H\2\2\u0129\u0130\7&\2\2\u012a\u012b\5(\25\2\u012b\u012c\58\35\5\u012c"+
		"\u0130\3\2\2\2\u012d\u0130\5\\/\2\u012e\u0130\5\6\4\2\u012f\u0104\3\2"+
		"\2\2\u012f\u0109\3\2\2\2\u012f\u010d\3\2\2\2\u012f\u0114\3\2\2\2\u012f"+
		"\u0115\3\2\2\2\u012f\u0116\3\2\2\2\u012f\u011d\3\2\2\2\u012f\u0125\3\2"+
		"\2\2\u012f\u0126\3\2\2\2\u012f\u0127\3\2\2\2\u012f\u0128\3\2\2\2\u012f"+
		"\u0129\3\2\2\2\u012f\u012a\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2"+
		"\2\2\u0130\u014b\3\2\2\2\u0131\u0132\f\27\2\2\u0132\u0133\5,\27\2\u0133"+
		"\u0134\58\35\30\u0134\u014a\3\2\2\2\u0135\u0136\f\26\2\2\u0136\u0137\5"+
		".\30\2\u0137\u0138\58\35\27\u0138\u014a\3\2\2\2\u0139\u013a\f\25\2\2\u013a"+
		"\u013b\5\60\31\2\u013b\u013c\58\35\26\u013c\u014a\3\2\2\2\u013d\u013e"+
		"\f\24\2\2\u013e\u013f\5\62\32\2\u013f\u0140\58\35\25\u0140\u014a\3\2\2"+
		"\2\u0141\u0142\f\23\2\2\u0142\u0143\5\64\33\2\u0143\u0144\58\35\24\u0144"+
		"\u014a\3\2\2\2\u0145\u0146\f\22\2\2\u0146\u0147\5\66\34\2\u0147\u0148"+
		"\58\35\23\u0148\u014a\3\2\2\2\u0149\u0131\3\2\2\2\u0149\u0135\3\2\2\2"+
		"\u0149\u0139\3\2\2\2\u0149\u013d\3\2\2\2\u0149\u0141\3\2\2\2\u0149\u0145"+
		"\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"9\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\5\f\7\2\u014f\u0150\5\6\4\2"+
		"\u0150;\3\2\2\2\u0151\u0156\5:\36\2\u0152\u0153\7K\2\2\u0153\u0155\5:"+
		"\36\2\u0154\u0152\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157=\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\5\b\5\2"+
		"\u015a\u015b\7\5\2\2\u015b\u015c\5\b\5\2\u015c?\3\2\2\2\u015d\u015e\7"+
		"B\2\2\u015e\u015f\5\b\5\2\u015fA\3\2\2\2\u0160\u0163\5> \2\u0161\u0163"+
		"\5@!\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u016b\3\2\2\2\u0164"+
		"\u0167\7K\2\2\u0165\u0168\5> \2\u0166\u0168\5@!\2\u0167\u0165\3\2\2\2"+
		"\u0167\u0166\3\2\2\2\u0168\u016a\3\2\2\2\u0169\u0164\3\2\2\2\u016a\u016d"+
		"\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016cC\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016e\u016f\5\f\7\2\u016f\u0170\5\6\4\2\u0170\u0172\7\34"+
		"\2\2\u0171\u0173\5<\37\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173"+
		"\u0174\3\2\2\2\u0174\u0177\7\35\2\2\u0175\u0176\7A\2\2\u0176\u0178\5B"+
		"\"\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017a\7$\2\2\u017a\u017b\5R*\2\u017b\u017c\7%\2\2\u017cE\3\2\2\2\u017d"+
		"\u017e\5\f\7\2\u017e\u017f\5\6\4\2\u017f\u0181\7\34\2\2\u0180\u0182\5"+
		"<\37\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"\u0186\7\35\2\2\u0184\u0185\7A\2\2\u0185\u0187\5B\"\2\u0186\u0184\3\2"+
		"\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\7$\2\2\u0189"+
		"\u018a\7D\2\2\u018aG\3\2\2\2\u018b\u018c\7C\2\2\u018c\u018d\5\b\5\2\u018d"+
		"\u018e\7\5\2\2\u018e\u0191\5\b\5\2\u018f\u0190\7A\2\2\u0190\u0192\5B\""+
		"\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0195"+
		"\7$\2\2\u0194\u0196\5F$\2\u0195\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\7%"+
		"\2\2\u019aI\3\2\2\2\u019b\u019c\t\t\2\2\u019cK\3\2\2\2\u019d\u01fb\7\33"+
		"\2\2\u019e\u01a1\5\f\7\2\u019f\u01a1\7;\2\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a3\5\6\4\2\u01a3\u01a4\7J"+
		"\2\2\u01a4\u01a5\5V,\2\u01a5\u01fb\3\2\2\2\u01a6\u01a8\7<\2\2\u01a7\u01a9"+
		"\5\f\7\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ab\5\6\4\2\u01ab\u01ac\7J\2\2\u01ac\u01ad\5V,\2\u01ad\u01fb\3\2\2"+
		"\2\u01ae\u01af\5T+\2\u01af\u01b0\7J\2\2\u01b0\u01b1\5V,\2\u01b1\u01fb"+
		"\3\2\2\2\u01b2\u01b3\7\63\2\2\u01b3\u01fb\5T+\2\u01b4\u01b5\5J&\2\u01b5"+
		"\u01b6\58\35\2\u01b6\u01fb\3\2\2\2\u01b7\u01b8\7)\2\2\u01b8\u01b9\58\35"+
		"\2\u01b9\u01ba\7*\2\2\u01ba\u01c3\5R*\2\u01bb\u01bc\7+\2\2\u01bc\u01bd"+
		"\7)\2\2\u01bd\u01be\58\35\2\u01be\u01bf\7*\2\2\u01bf\u01c0\5R*\2\u01c0"+
		"\u01c2\3\2\2\2\u01c1\u01bb\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2"+
		"\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c8\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6"+
		"\u01c7\7+\2\2\u01c7\u01c9\5R*\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\7,\2\2\u01cb\u01fb\3\2\2\2\u01cc\u01cd"+
		"\7-\2\2\u01cd\u01ce\58\35\2\u01ce\u01d0\7\60\2\2\u01cf\u01d1\5R*\2\u01d0"+
		"\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\7\61"+
		"\2\2\u01d3\u01fb\3\2\2\2\u01d4\u01d7\7.\2\2\u01d5\u01d8\5\f\7\2\u01d6"+
		"\u01d8\7;\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2"+
		"\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01da\5\6\4\2\u01da\u01db\7/\2\2\u01db"+
		"\u01dc\5&\24\2\u01dc\u01de\7\60\2\2\u01dd\u01df\5R*\2\u01de\u01dd\3\2"+
		"\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\7\61\2\2\u01e1"+
		"\u01fb\3\2\2\2\u01e2\u01e3\7@\2\2\u01e3\u01e4\58\35\2\u01e4\u01e8\7\5"+
		"\2\2\u01e5\u01e7\5P)\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6"+
		"\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb"+
		"\u01ec\7%\2\2\u01ec\u01fb\3\2\2\2\u01ed\u01ee\79\2\2\u01ee\u01ef\5\6\4"+
		"\2\u01ef\u01f1\7\34\2\2\u01f0\u01f2\5X-\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2"+
		"\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\7\35\2\2\u01f4\u01fb\3\2\2\2"+
		"\u01f5\u01f7\7#\2\2\u01f6\u01f8\5R*\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8"+
		"\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\7%\2\2\u01fa\u019d\3\2\2\2\u01fa"+
		"\u01a0\3\2\2\2\u01fa\u01a6\3\2\2\2\u01fa\u01ae\3\2\2\2\u01fa\u01b2\3\2"+
		"\2\2\u01fa\u01b4\3\2\2\2\u01fa\u01b7\3\2\2\2\u01fa\u01cc\3\2\2\2\u01fa"+
		"\u01d4\3\2\2\2\u01fa\u01e2\3\2\2\2\u01fa\u01ed\3\2\2\2\u01fa\u01f5\3\2"+
		"\2\2\u01fbM\3\2\2\2\u01fc\u0208\5\b\5\2\u01fd\u01fe\7\34\2\2\u01fe\u0203"+
		"\5\6\4\2\u01ff\u0200\7K\2\2\u0200\u0202\5\6\4\2\u0201\u01ff\3\2\2\2\u0202"+
		"\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0206\3\2"+
		"\2\2\u0205\u0203\3\2\2\2\u0206\u0207\7\35\2\2\u0207\u0209\3\2\2\2\u0208"+
		"\u01fd\3\2\2\2\u0208\u0209\3\2\2\2\u0209O\3\2\2\2\u020a\u020b\7$\2\2\u020b"+
		"\u020c\5N(\2\u020c\u020d\7\3\2\2\u020d\u020e\5R*\2\u020eQ\3\2\2\2\u020f"+
		"\u0214\5L\'\2\u0210\u0211\7\"\2\2\u0211\u0213\5L\'\2\u0212\u0210\3\2\2"+
		"\2\u0213\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0218"+
		"\3\2\2\2\u0216\u0214\3\2\2\2\u0217\u0219\7\"\2\2\u0218\u0217\3\2\2\2\u0218"+
		"\u0219\3\2\2\2\u0219S\3\2\2\2\u021a\u021f\5\6\4\2\u021b\u021f\5\\/\2\u021c"+
		"\u021f\5^\60\2\u021d\u021f\5`\61\2\u021e\u021a\3\2\2\2\u021e\u021b\3\2"+
		"\2\2\u021e\u021c\3\2\2\2\u021e\u021d\3\2\2\2\u021fU\3\2\2\2\u0220\u0234"+
		"\58\35\2\u0221\u0234\5Z.\2\u0222\u0223\7\62\2\2\u0223\u0224\7\34\2\2\u0224"+
		"\u0225\58\35\2\u0225\u0226\7K\2\2\u0226\u0227\58\35\2\u0227\u0228\7\35"+
		"\2\2\u0228\u0234\3\2\2\2\u0229\u0234\5^\60\2\u022a\u0234\5`\61\2\u022b"+
		"\u022c\79\2\2\u022c\u022d\5\6\4\2\u022d\u022f\7\34\2\2\u022e\u0230\5X"+
		"-\2\u022f\u022e\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0232\7\35\2\2\u0232\u0234\3\2\2\2\u0233\u0220\3\2\2\2\u0233\u0221\3"+
		"\2\2\2\u0233\u0222\3\2\2\2\u0233\u0229\3\2\2\2\u0233\u022a\3\2\2\2\u0233"+
		"\u022b\3\2\2\2\u0234W\3\2\2\2\u0235\u023a\58\35\2\u0236\u0237\7K\2\2\u0237"+
		"\u0239\58\35\2\u0238\u0236\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2"+
		"\2\2\u023a\u023b\3\2\2\2\u023bY\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u023f"+
		"\7\36\2\2\u023e\u0240\5X-\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0242\7\37\2\2\u0242[\3\2\2\2\u0243\u0248\5\6\4\2"+
		"\u0244\u0245\7\36\2\2\u0245\u0246\58\35\2\u0246\u0247\7\37\2\2\u0247\u0249"+
		"\3\2\2\2\u0248\u0244\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u0248\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b]\3\2\2\2\u024c\u024d\5*\26\2\u024d\u024e\58\35\2"+
		"\u024e_\3\2\2\2\u024f\u0250\58\35\2\u0250\u0251\7\6\2\2\u0251\u0252\5"+
		"\6\4\2\u0252a\3\2\2\2\u0253\u0254\5\b\5\2\u0254\u0256\7\34\2\2\u0255\u0257"+
		"\5X-\2\u0256\u0255\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\3\2\2\2\u0258"+
		"\u0259\7\35\2\2\u0259c\3\2\2\2\u025a\u0261\7#\2\2\u025b\u0260\5\32\16"+
		"\2\u025c\u0260\5D#\2\u025d\u0260\5H%\2\u025e\u0260\5$\23\2\u025f\u025b"+
		"\3\2\2\2\u025f\u025c\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u025e\3\2\2\2\u0260"+
		"\u0263\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0265\3\2"+
		"\2\2\u0263\u0261\3\2\2\2\u0264\u0266\5R*\2\u0265\u0264\3\2\2\2\u0265\u0266"+
		"\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u0268\7%\2\2\u0268\u0269\7\2\2\3\u0269"+
		"e\3\2\2\2:iw|\u0082\u008d\u0091\u0099\u00a3\u00ab\u00b3\u00bb\u00c8\u00cd"+
		"\u00d2\u00db\u00e6\u00ec\u0110\u012f\u0149\u014b\u0156\u0162\u0167\u016b"+
		"\u0172\u0177\u0181\u0186\u0191\u0197\u01a0\u01a8\u01c3\u01c8\u01d0\u01d7"+
		"\u01de\u01e8\u01f1\u01f7\u01fa\u0203\u0208\u0214\u0218\u021e\u022f\u0233"+
		"\u023a\u023f\u024a\u0256\u025f\u0261\u0265";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}