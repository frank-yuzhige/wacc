// Generated from /homes/zy7218/wacc_51/antlr_config/WaccLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WaccLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ADD", "SUB", "MUL", "DIV", "MOD", "GTE", "GT", "LTE", "LT", "EQ", "NEQ", 
			"AND", "OR", "BINOP1", "BINOP2", "BINOP3", "BINOP4", "BINOP5", "NOT", 
			"LEN", "ORD", "CHR", "FST", "SND", "UNARYOP", "SKIP_STAT", "LPAR", "RPAR", 
			"LBRA", "RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", 
			"TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "NEWPAIR", 
			"READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", "TYPE", 
			"PAIR_ELEM_TYPE", "PAIR_TYPE", "ARR_TYPE", "BASE_TYPE", "DIGIT", "INTEGER", 
			"STRLIT", "CHARLIT", "NORMAL_CHAR", "ESC_CHAR", "ASSIGN", "COMMA", "IDENT_HEAD", 
			"IDENT_TAIL", "IDENT", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'!'", "'len'", "'ord'", "'chr'", 
			"'fst'", "'snd'", null, "'skip'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "';'", "'begin'", "'is'", "'end'", "'null'", "'true'", "'false'", 
			"'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", "'newpair'", 
			"'read'", "'free'", "'return'", "'exit'", "'print'", "'println'", "'call'", 
			null, null, null, null, "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BINOP1", "BINOP2", "BINOP3", "BINOP4", "BINOP5", "NOT", "LEN", 
			"ORD", "CHR", "FST", "SND", "UNARYOP", "SKIP_STAT", "LPAR", "RPAR", "LBRA", 
			"RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", 
			"FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", "NEWPAIR", 
			"READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", "TYPE", 
			"INTEGER", "STRLIT", "CHARLIT", "ASSIGN", "COMMA", "IDENT", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public WaccLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WaccLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01e0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\5\17\u00b7\n\17\3\20\3\20\5\20\u00bb\n\20\3\21\3\21\3\21"+
		"\3\21\5\21\u00c1\n\21\3\22\3\22\5\22\u00c5\n\22\3\23\3\23\5\23\u00c9\n"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u00e7\n\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3*"+
		"\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/"+
		"\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\58\u016b\n8\39"+
		"\39\39\39\39\39\59\u0173\n9\3:\3:\3:\3:\3:\3:\5:\u017b\n:\3:\3:\3:\3:"+
		"\5:\u0181\n:\3:\3:\3:\3;\3;\3;\6;\u0189\n;\r;\16;\u018a\3<\3<\3<\3<\3"+
		"<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u019e\n<\3=\3=\3>\5>\u01a3\n"+
		">\3>\6>\u01a6\n>\r>\16>\u01a7\3?\3?\3?\7?\u01ad\n?\f?\16?\u01b0\13?\3"+
		"?\3?\3@\3@\3@\5@\u01b7\n@\3@\3@\3A\3A\3B\3B\3B\3C\3C\3D\3D\3E\3E\3F\3"+
		"F\5F\u01c8\nF\3G\3G\7G\u01cc\nG\fG\16G\u01cf\13G\3H\3H\7H\u01d3\nH\fH"+
		"\16H\u01d6\13H\3H\3H\3I\6I\u01db\nI\rI\16I\u01dc\3I\3I\2\2J\3\2\5\2\7"+
		"\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\3\37\4!\5#\6%\7"+
		"\'\b)\t+\n-\13/\f\61\r\63\16\65\17\67\209\21;\22=\23?\24A\25C\26E\27G"+
		"\30I\31K\32M\33O\34Q\35S\36U\37W Y![\"]#_$a%c&e\'g(i)k*m+o,q\2s\2u\2w"+
		"\2y\2{-}.\177/\u0081\2\u0083\2\u0085\60\u0087\61\u0089\2\u008b\2\u008d"+
		"\62\u008f\63\u0091\64\3\2\b\4\2--//\5\2$$))^^\13\2$$))\62\62^^ddhhppt"+
		"tvv\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u01e9\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0095\3\2\2\2\7\u0097\3\2\2\2\t\u0099"+
		"\3\2\2\2\13\u009b\3\2\2\2\r\u009d\3\2\2\2\17\u00a0\3\2\2\2\21\u00a2\3"+
		"\2\2\2\23\u00a5\3\2\2\2\25\u00a7\3\2\2\2\27\u00aa\3\2\2\2\31\u00ad\3\2"+
		"\2\2\33\u00b0\3\2\2\2\35\u00b6\3\2\2\2\37\u00ba\3\2\2\2!\u00c0\3\2\2\2"+
		"#\u00c4\3\2\2\2%\u00c8\3\2\2\2\'\u00ca\3\2\2\2)\u00cc\3\2\2\2+\u00d0\3"+
		"\2\2\2-\u00d4\3\2\2\2/\u00d8\3\2\2\2\61\u00dc\3\2\2\2\63\u00e6\3\2\2\2"+
		"\65\u00e8\3\2\2\2\67\u00ed\3\2\2\29\u00ef\3\2\2\2;\u00f1\3\2\2\2=\u00f3"+
		"\3\2\2\2?\u00f5\3\2\2\2A\u00f7\3\2\2\2C\u00f9\3\2\2\2E\u00fb\3\2\2\2G"+
		"\u0101\3\2\2\2I\u0104\3\2\2\2K\u0108\3\2\2\2M\u010d\3\2\2\2O\u0112\3\2"+
		"\2\2Q\u0118\3\2\2\2S\u011b\3\2\2\2U\u0120\3\2\2\2W\u0125\3\2\2\2Y\u0128"+
		"\3\2\2\2[\u012e\3\2\2\2]\u0131\3\2\2\2_\u0136\3\2\2\2a\u013e\3\2\2\2c"+
		"\u0143\3\2\2\2e\u0148\3\2\2\2g\u014f\3\2\2\2i\u0154\3\2\2\2k\u015a\3\2"+
		"\2\2m\u0162\3\2\2\2o\u016a\3\2\2\2q\u0172\3\2\2\2s\u0174\3\2\2\2u\u0185"+
		"\3\2\2\2w\u019d\3\2\2\2y\u019f\3\2\2\2{\u01a2\3\2\2\2}\u01a9\3\2\2\2\177"+
		"\u01b3\3\2\2\2\u0081\u01ba\3\2\2\2\u0083\u01bc\3\2\2\2\u0085\u01bf\3\2"+
		"\2\2\u0087\u01c1\3\2\2\2\u0089\u01c3\3\2\2\2\u008b\u01c7\3\2\2\2\u008d"+
		"\u01c9\3\2\2\2\u008f\u01d0\3\2\2\2\u0091\u01da\3\2\2\2\u0093\u0094\7-"+
		"\2\2\u0094\4\3\2\2\2\u0095\u0096\7/\2\2\u0096\6\3\2\2\2\u0097\u0098\7"+
		",\2\2\u0098\b\3\2\2\2\u0099\u009a\7\61\2\2\u009a\n\3\2\2\2\u009b\u009c"+
		"\7\'\2\2\u009c\f\3\2\2\2\u009d\u009e\7@\2\2\u009e\u009f\7?\2\2\u009f\16"+
		"\3\2\2\2\u00a0\u00a1\7@\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\7>\2\2\u00a3"+
		"\u00a4\7?\2\2\u00a4\22\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6\24\3\2\2\2\u00a7"+
		"\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9\26\3\2\2\2\u00aa\u00ab\7#\2\2\u00ab"+
		"\u00ac\7?\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7(\2\2\u00ae\u00af\7(\2\2\u00af"+
		"\32\3\2\2\2\u00b0\u00b1\7~\2\2\u00b1\u00b2\7~\2\2\u00b2\34\3\2\2\2\u00b3"+
		"\u00b7\5\7\4\2\u00b4\u00b7\5\t\5\2\u00b5\u00b7\5\13\6\2\u00b6\u00b3\3"+
		"\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\36\3\2\2\2\u00b8"+
		"\u00bb\5\3\2\2\u00b9\u00bb\5\5\3\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00bb \3\2\2\2\u00bc\u00c1\5\21\t\2\u00bd\u00c1\5\23\n\2\u00be\u00c1"+
		"\5\r\7\2\u00bf\u00c1\5\17\b\2\u00c0\u00bc\3\2\2\2\u00c0\u00bd\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\"\3\2\2\2\u00c2\u00c5\5"+
		"\25\13\2\u00c3\u00c5\5\27\f\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5$\3\2\2\2\u00c6\u00c9\5\31\r\2\u00c7\u00c9\5\33\16\2\u00c8\u00c6"+
		"\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb("+
		"\3\2\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"*\3\2\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7f\2\2\u00d3"+
		",\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7\7t\2\2\u00d7"+
		".\3\2\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7v\2\2\u00db"+
		"\60\3\2\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7f\2\2\u00df"+
		"\62\3\2\2\2\u00e0\u00e7\5\'\24\2\u00e1\u00e7\5)\25\2\u00e2\u00e7\5+\26"+
		"\2\u00e3\u00e7\5-\27\2\u00e4\u00e7\5/\30\2\u00e5\u00e7\5\61\31\2\u00e6"+
		"\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\64\3\2\2\2\u00e8\u00e9"+
		"\7u\2\2\u00e9\u00ea\7m\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec\7r\2\2\u00ec"+
		"\66\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee8\3\2\2\2\u00ef\u00f0\7+\2\2\u00f0"+
		":\3\2\2\2\u00f1\u00f2\7]\2\2\u00f2<\3\2\2\2\u00f3\u00f4\7_\2\2\u00f4>"+
		"\3\2\2\2\u00f5\u00f6\7}\2\2\u00f6@\3\2\2\2\u00f7\u00f8\7\177\2\2\u00f8"+
		"B\3\2\2\2\u00f9\u00fa\7=\2\2\u00faD\3\2\2\2\u00fb\u00fc\7d\2\2\u00fc\u00fd"+
		"\7g\2\2\u00fd\u00fe\7i\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100"+
		"F\3\2\2\2\u0101\u0102\7k\2\2\u0102\u0103\7u\2\2\u0103H\3\2\2\2\u0104\u0105"+
		"\7g\2\2\u0105\u0106\7p\2\2\u0106\u0107\7f\2\2\u0107J\3\2\2\2\u0108\u0109"+
		"\7p\2\2\u0109\u010a\7w\2\2\u010a\u010b\7n\2\2\u010b\u010c\7n\2\2\u010c"+
		"L\3\2\2\2\u010d\u010e\7v\2\2\u010e\u010f\7t\2\2\u010f\u0110\7w\2\2\u0110"+
		"\u0111\7g\2\2\u0111N\3\2\2\2\u0112\u0113\7h\2\2\u0113\u0114\7c\2\2\u0114"+
		"\u0115\7n\2\2\u0115\u0116\7u\2\2\u0116\u0117\7g\2\2\u0117P\3\2\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7h\2\2\u011aR\3\2\2\2\u011b\u011c\7v\2\2\u011c"+
		"\u011d\7j\2\2\u011d\u011e\7g\2\2\u011e\u011f\7p\2\2\u011fT\3\2\2\2\u0120"+
		"\u0121\7g\2\2\u0121\u0122\7n\2\2\u0122\u0123\7u\2\2\u0123\u0124\7g\2\2"+
		"\u0124V\3\2\2\2\u0125\u0126\7h\2\2\u0126\u0127\7k\2\2\u0127X\3\2\2\2\u0128"+
		"\u0129\7y\2\2\u0129\u012a\7j\2\2\u012a\u012b\7k\2\2\u012b\u012c\7n\2\2"+
		"\u012c\u012d\7g\2\2\u012dZ\3\2\2\2\u012e\u012f\7f\2\2\u012f\u0130\7q\2"+
		"\2\u0130\\\3\2\2\2\u0131\u0132\7f\2\2\u0132\u0133\7q\2\2\u0133\u0134\7"+
		"p\2\2\u0134\u0135\7g\2\2\u0135^\3\2\2\2\u0136\u0137\7p\2\2\u0137\u0138"+
		"\7g\2\2\u0138\u0139\7y\2\2\u0139\u013a\7r\2\2\u013a\u013b\7c\2\2\u013b"+
		"\u013c\7k\2\2\u013c\u013d\7t\2\2\u013d`\3\2\2\2\u013e\u013f\7t\2\2\u013f"+
		"\u0140\7g\2\2\u0140\u0141\7c\2\2\u0141\u0142\7f\2\2\u0142b\3\2\2\2\u0143"+
		"\u0144\7h\2\2\u0144\u0145\7t\2\2\u0145\u0146\7g\2\2\u0146\u0147\7g\2\2"+
		"\u0147d\3\2\2\2\u0148\u0149\7t\2\2\u0149\u014a\7g\2\2\u014a\u014b\7v\2"+
		"\2\u014b\u014c\7w\2\2\u014c\u014d\7t\2\2\u014d\u014e\7p\2\2\u014ef\3\2"+
		"\2\2\u014f\u0150\7g\2\2\u0150\u0151\7z\2\2\u0151\u0152\7k\2\2\u0152\u0153"+
		"\7v\2\2\u0153h\3\2\2\2\u0154\u0155\7r\2\2\u0155\u0156\7t\2\2\u0156\u0157"+
		"\7k\2\2\u0157\u0158\7p\2\2\u0158\u0159\7v\2\2\u0159j\3\2\2\2\u015a\u015b"+
		"\7r\2\2\u015b\u015c\7t\2\2\u015c\u015d\7k\2\2\u015d\u015e\7p\2\2\u015e"+
		"\u015f\7v\2\2\u015f\u0160\7n\2\2\u0160\u0161\7p\2\2\u0161l\3\2\2\2\u0162"+
		"\u0163\7e\2\2\u0163\u0164\7c\2\2\u0164\u0165\7n\2\2\u0165\u0166\7n\2\2"+
		"\u0166n\3\2\2\2\u0167\u016b\5s:\2\u0168\u016b\5u;\2\u0169\u016b\5w<\2"+
		"\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016bp\3"+
		"\2\2\2\u016c\u016d\7r\2\2\u016d\u016e\7c\2\2\u016e\u016f\7k\2\2\u016f"+
		"\u0173\7t\2\2\u0170\u0173\5u;\2\u0171\u0173\5w<\2\u0172\u016c\3\2\2\2"+
		"\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173r\3\2\2\2\u0174\u0175\7"+
		"r\2\2\u0175\u0176\7c\2\2\u0176\u0177\7k\2\2\u0177\u0178\7t\2\2\u0178\u017a"+
		"\3\2\2\2\u0179\u017b\5\u0091I\2\u017a\u0179\3\2\2\2\u017a\u017b\3\2\2"+
		"\2\u017b\u017c\3\2\2\2\u017c\u017d\7*\2\2\u017d\u017e\5q9\2\u017e\u0180"+
		"\7.\2\2\u017f\u0181\5\u0091I\2\u0180\u017f\3\2\2\2\u0180\u0181\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0183\5q9\2\u0183\u0184\7+\2\2\u0184t\3\2\2"+
		"\2\u0185\u0188\5w<\2\u0186\u0187\7]\2\2\u0187\u0189\7_\2\2\u0188\u0186"+
		"\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"v\3\2\2\2\u018c\u018d\7k\2\2\u018d\u018e\7p\2\2\u018e\u019e\7v\2\2\u018f"+
		"\u0190\7u\2\2\u0190\u0191\7v\2\2\u0191\u0192\7t\2\2\u0192\u0193\7k\2\2"+
		"\u0193\u0194\7p\2\2\u0194\u019e\7i\2\2\u0195\u0196\7d\2\2\u0196\u0197"+
		"\7q\2\2\u0197\u0198\7q\2\2\u0198\u019e\7n\2\2\u0199\u019a\7e\2\2\u019a"+
		"\u019b\7j\2\2\u019b\u019c\7c\2\2\u019c\u019e\7t\2\2\u019d\u018c\3\2\2"+
		"\2\u019d\u018f\3\2\2\2\u019d\u0195\3\2\2\2\u019d\u0199\3\2\2\2\u019ex"+
		"\3\2\2\2\u019f\u01a0\4\62;\2\u01a0z\3\2\2\2\u01a1\u01a3\t\2\2\2\u01a2"+
		"\u01a1\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a6\5y"+
		"=\2\u01a5\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a8\3\2\2\2\u01a8|\3\2\2\2\u01a9\u01ae\7$\2\2\u01aa\u01ad\5\u0081A"+
		"\2\u01ab\u01ad\5\u0083B\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b2\7$\2\2\u01b2~\3\2\2\2\u01b3\u01b6"+
		"\7)\2\2\u01b4\u01b7\5\u0081A\2\u01b5\u01b7\5\u0083B\2\u01b6\u01b4\3\2"+
		"\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\7)\2\2\u01b9"+
		"\u0080\3\2\2\2\u01ba\u01bb\n\3\2\2\u01bb\u0082\3\2\2\2\u01bc\u01bd\7^"+
		"\2\2\u01bd\u01be\t\4\2\2\u01be\u0084\3\2\2\2\u01bf\u01c0\7?\2\2\u01c0"+
		"\u0086\3\2\2\2\u01c1\u01c2\7.\2\2\u01c2\u0088\3\2\2\2\u01c3\u01c4\t\5"+
		"\2\2\u01c4\u008a\3\2\2\2\u01c5\u01c8\5\u0089E\2\u01c6\u01c8\5y=\2\u01c7"+
		"\u01c5\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c8\u008c\3\2\2\2\u01c9\u01cd\5\u0089"+
		"E\2\u01ca\u01cc\5\u008bF\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd"+
		"\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u008e\3\2\2\2\u01cf\u01cd\3\2"+
		"\2\2\u01d0\u01d4\7%\2\2\u01d1\u01d3\n\6\2\2\u01d2\u01d1\3\2\2\2\u01d3"+
		"\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2"+
		"\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01d8\bH\2\2\u01d8\u0090\3\2\2\2\u01d9"+
		"\u01db\t\7\2\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01da\3\2"+
		"\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01df\bI\2\2\u01df"+
		"\u0092\3\2\2\2\30\2\u00b6\u00ba\u00c0\u00c4\u00c8\u00e6\u016a\u0172\u017a"+
		"\u0180\u018a\u019d\u01a2\u01a7\u01ac\u01ae\u01b6\u01c7\u01cd\u01d4\u01dc"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}