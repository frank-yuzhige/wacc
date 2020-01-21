// Generated from /homes/zy7218/wacc_51/antlr_config/BasicLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BINOP1=1, BINOP2=2, BINOP3=3, BINOP4=4, BINOP5=5, NOT=6, LEN=7, ORD=8, 
		CHR=9, FST=10, SND=11, UNARYOP=12, SKIP_STAT=13, LPAR=14, RPAR=15, LBRA=16, 
		RBRA=17, LCUR=18, RCUR=19, SEMICOLON=20, COMMENT=21, BEGIN=22, IS=23, 
		END=24, NULL=25, TRUE=26, FALSE=27, IF=28, THEN=29, ELSE=30, FI=31, WHILE=32, 
		DO=33, DONE=34, NEWPAIR=35, READ=36, FREE=37, RETURN=38, EXIT=39, PRINT=40, 
		PRINTLN=41, CALL=42, TYPE=43, INTEGER=44, STRLIT=45, CHARLIT=46, ASSIGN=47, 
		COMMA=48, IDENT=49, WS=50;
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
			"LBRA", "RBRA", "LCUR", "RCUR", "SEMICOLON", "COMMENT", "BEGIN", "IS", 
			"END", "NULL", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", 
			"DO", "DONE", "NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
			"CALL", "BASE_TYPE", "ARR_TYPE", "PAIR_ELEM_TYPE", "PAIR_TYPE", "TYPE", 
			"DIGIT", "INTEGER", "STRLIT", "CHARLIT", "NORMAL_CHAR", "ESC_CHAR", "ASSIGN", 
			"COMMA", "IDENT_HEAD", "IDENT_TAIL", "IDENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'!'", "'len'", "'ord'", "'chr'", 
			"'fst'", "'snd'", null, "'skip'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "';'", null, "'begin'", "'is'", "'end'", "'null'", "'true'", "'false'", 
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
			"RBRA", "LCUR", "RCUR", "SEMICOLON", "COMMENT", "BEGIN", "IS", "END", 
			"NULL", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", 
			"NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", 
			"TYPE", "INTEGER", "STRLIT", "CHARLIT", "ASSIGN", "COMMA", "IDENT", "WS"
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


	public BasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BasicLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01da\b\1\4\2"+
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
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\7#\u00fe\n#\f#\16#\u0101\13"+
		"#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3("+
		"\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,"+
		"\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\38\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\59"+
		"\u0182\n9\3:\3:\3:\6:\u0187\n:\r:\16:\u0188\3;\3;\3;\3;\3;\3;\5;\u0191"+
		"\n;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\5=\u01a1\n=\3>\3>\3?\5?"+
		"\u01a6\n?\3?\6?\u01a9\n?\r?\16?\u01aa\3@\3@\3@\7@\u01b0\n@\f@\16@\u01b3"+
		"\13@\3@\3@\3A\3A\3A\5A\u01ba\nA\3A\3A\3B\3B\3C\3C\3C\3D\3D\3E\3E\3F\3"+
		"F\3G\3G\5G\u01cb\nG\3H\3H\7H\u01cf\nH\fH\16H\u01d2\13H\3I\6I\u01d5\nI"+
		"\rI\16I\u01d6\3I\3I\2\2J\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2"+
		"\27\2\31\2\33\2\35\3\37\4!\5#\6%\7\'\b)\t+\n-\13/\f\61\r\63\16\65\17\67"+
		"\209\21;\22=\23?\24A\25C\26E\27G\30I\31K\32M\33O\34Q\35S\36U\37W Y![\""+
		"]#_$a%c&e\'g(i)k*m+o,q\2s\2u\2w\2y-{\2}.\177/\u0081\60\u0083\2\u0085\2"+
		"\u0087\61\u0089\62\u008b\2\u008d\2\u008f\63\u0091\64\3\2\b\4\2\f\f\17"+
		"\17\4\2--//\5\2$$))^^\13\2$$))\62\62^^ddhhppttvv\5\2C\\aac|\5\2\13\f\17"+
		"\17\"\"\2\u01e1\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2y\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0087\3\2\2\2"+
		"\2\u0089\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0095"+
		"\3\2\2\2\7\u0097\3\2\2\2\t\u0099\3\2\2\2\13\u009b\3\2\2\2\r\u009d\3\2"+
		"\2\2\17\u00a0\3\2\2\2\21\u00a2\3\2\2\2\23\u00a5\3\2\2\2\25\u00a7\3\2\2"+
		"\2\27\u00aa\3\2\2\2\31\u00ad\3\2\2\2\33\u00b0\3\2\2\2\35\u00b6\3\2\2\2"+
		"\37\u00ba\3\2\2\2!\u00c0\3\2\2\2#\u00c4\3\2\2\2%\u00c8\3\2\2\2\'\u00ca"+
		"\3\2\2\2)\u00cc\3\2\2\2+\u00d0\3\2\2\2-\u00d4\3\2\2\2/\u00d8\3\2\2\2\61"+
		"\u00dc\3\2\2\2\63\u00e6\3\2\2\2\65\u00e8\3\2\2\2\67\u00ed\3\2\2\29\u00ef"+
		"\3\2\2\2;\u00f1\3\2\2\2=\u00f3\3\2\2\2?\u00f5\3\2\2\2A\u00f7\3\2\2\2C"+
		"\u00f9\3\2\2\2E\u00fb\3\2\2\2G\u0104\3\2\2\2I\u010a\3\2\2\2K\u010d\3\2"+
		"\2\2M\u0111\3\2\2\2O\u0116\3\2\2\2Q\u011b\3\2\2\2S\u0121\3\2\2\2U\u0124"+
		"\3\2\2\2W\u0129\3\2\2\2Y\u012e\3\2\2\2[\u0131\3\2\2\2]\u0137\3\2\2\2_"+
		"\u013a\3\2\2\2a\u013f\3\2\2\2c\u0147\3\2\2\2e\u014c\3\2\2\2g\u0151\3\2"+
		"\2\2i\u0158\3\2\2\2k\u015d\3\2\2\2m\u0163\3\2\2\2o\u016b\3\2\2\2q\u0181"+
		"\3\2\2\2s\u0183\3\2\2\2u\u0190\3\2\2\2w\u0192\3\2\2\2y\u01a0\3\2\2\2{"+
		"\u01a2\3\2\2\2}\u01a5\3\2\2\2\177\u01ac\3\2\2\2\u0081\u01b6\3\2\2\2\u0083"+
		"\u01bd\3\2\2\2\u0085\u01bf\3\2\2\2\u0087\u01c2\3\2\2\2\u0089\u01c4\3\2"+
		"\2\2\u008b\u01c6\3\2\2\2\u008d\u01ca\3\2\2\2\u008f\u01cc\3\2\2\2\u0091"+
		"\u01d4\3\2\2\2\u0093\u0094\7-\2\2\u0094\4\3\2\2\2\u0095\u0096\7/\2\2\u0096"+
		"\6\3\2\2\2\u0097\u0098\7,\2\2\u0098\b\3\2\2\2\u0099\u009a\7\61\2\2\u009a"+
		"\n\3\2\2\2\u009b\u009c\7\'\2\2\u009c\f\3\2\2\2\u009d\u009e\7@\2\2\u009e"+
		"\u009f\7?\2\2\u009f\16\3\2\2\2\u00a0\u00a1\7@\2\2\u00a1\20\3\2\2\2\u00a2"+
		"\u00a3\7>\2\2\u00a3\u00a4\7?\2\2\u00a4\22\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6"+
		"\24\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8\u00a9\7?\2\2\u00a9\26\3\2\2\2\u00aa"+
		"\u00ab\7#\2\2\u00ab\u00ac\7?\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7(\2\2\u00ae"+
		"\u00af\7(\2\2\u00af\32\3\2\2\2\u00b0\u00b1\7~\2\2\u00b1\u00b2\7~\2\2\u00b2"+
		"\34\3\2\2\2\u00b3\u00b7\5\7\4\2\u00b4\u00b7\5\t\5\2\u00b5\u00b7\5\13\6"+
		"\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\36"+
		"\3\2\2\2\u00b8\u00bb\5\3\2\2\u00b9\u00bb\5\5\3\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb \3\2\2\2\u00bc\u00c1\5\21\t\2\u00bd\u00c1\5\23\n"+
		"\2\u00be\u00c1\5\r\7\2\u00bf\u00c1\5\17\b\2\u00c0\u00bc\3\2\2\2\u00c0"+
		"\u00bd\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\"\3\2\2\2"+
		"\u00c2\u00c5\5\25\13\2\u00c3\u00c5\5\27\f\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5$\3\2\2\2\u00c6\u00c9\5\31\r\2\u00c7\u00c9\5\33\16"+
		"\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9&\3\2\2\2\u00ca\u00cb"+
		"\7#\2\2\u00cb(\3\2\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf"+
		"\7p\2\2\u00cf*\3\2\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3"+
		"\7f\2\2\u00d3,\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7"+
		"\7t\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7u\2\2\u00da\u00db"+
		"\7v\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7p\2\2\u00de\u00df"+
		"\7f\2\2\u00df\62\3\2\2\2\u00e0\u00e7\5\'\24\2\u00e1\u00e7\5)\25\2\u00e2"+
		"\u00e7\5+\26\2\u00e3\u00e7\5-\27\2\u00e4\u00e7\5/\30\2\u00e5\u00e7\5\61"+
		"\31\2\u00e6\u00e0\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6"+
		"\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\64\3\2\2"+
		"\2\u00e8\u00e9\7u\2\2\u00e9\u00ea\7m\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec"+
		"\7r\2\2\u00ec\66\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee8\3\2\2\2\u00ef\u00f0"+
		"\7+\2\2\u00f0:\3\2\2\2\u00f1\u00f2\7]\2\2\u00f2<\3\2\2\2\u00f3\u00f4\7"+
		"_\2\2\u00f4>\3\2\2\2\u00f5\u00f6\7}\2\2\u00f6@\3\2\2\2\u00f7\u00f8\7\177"+
		"\2\2\u00f8B\3\2\2\2\u00f9\u00fa\7=\2\2\u00faD\3\2\2\2\u00fb\u00ff\7%\2"+
		"\2\u00fc\u00fe\n\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0103\b#\2\2\u0103F\3\2\2\2\u0104\u0105\7d\2\2\u0105\u0106\7g\2\2\u0106"+
		"\u0107\7i\2\2\u0107\u0108\7k\2\2\u0108\u0109\7p\2\2\u0109H\3\2\2\2\u010a"+
		"\u010b\7k\2\2\u010b\u010c\7u\2\2\u010cJ\3\2\2\2\u010d\u010e\7g\2\2\u010e"+
		"\u010f\7p\2\2\u010f\u0110\7f\2\2\u0110L\3\2\2\2\u0111\u0112\7p\2\2\u0112"+
		"\u0113\7w\2\2\u0113\u0114\7n\2\2\u0114\u0115\7n\2\2\u0115N\3\2\2\2\u0116"+
		"\u0117\7v\2\2\u0117\u0118\7t\2\2\u0118\u0119\7w\2\2\u0119\u011a\7g\2\2"+
		"\u011aP\3\2\2\2\u011b\u011c\7h\2\2\u011c\u011d\7c\2\2\u011d\u011e\7n\2"+
		"\2\u011e\u011f\7u\2\2\u011f\u0120\7g\2\2\u0120R\3\2\2\2\u0121\u0122\7"+
		"k\2\2\u0122\u0123\7h\2\2\u0123T\3\2\2\2\u0124\u0125\7v\2\2\u0125\u0126"+
		"\7j\2\2\u0126\u0127\7g\2\2\u0127\u0128\7p\2\2\u0128V\3\2\2\2\u0129\u012a"+
		"\7g\2\2\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u012d\7g\2\2\u012d"+
		"X\3\2\2\2\u012e\u012f\7h\2\2\u012f\u0130\7k\2\2\u0130Z\3\2\2\2\u0131\u0132"+
		"\7y\2\2\u0132\u0133\7j\2\2\u0133\u0134\7k\2\2\u0134\u0135\7n\2\2\u0135"+
		"\u0136\7g\2\2\u0136\\\3\2\2\2\u0137\u0138\7f\2\2\u0138\u0139\7q\2\2\u0139"+
		"^\3\2\2\2\u013a\u013b\7f\2\2\u013b\u013c\7q\2\2\u013c\u013d\7p\2\2\u013d"+
		"\u013e\7g\2\2\u013e`\3\2\2\2\u013f\u0140\7p\2\2\u0140\u0141\7g\2\2\u0141"+
		"\u0142\7y\2\2\u0142\u0143\7r\2\2\u0143\u0144\7c\2\2\u0144\u0145\7k\2\2"+
		"\u0145\u0146\7t\2\2\u0146b\3\2\2\2\u0147\u0148\7t\2\2\u0148\u0149\7g\2"+
		"\2\u0149\u014a\7c\2\2\u014a\u014b\7f\2\2\u014bd\3\2\2\2\u014c\u014d\7"+
		"h\2\2\u014d\u014e\7t\2\2\u014e\u014f\7g\2\2\u014f\u0150\7g\2\2\u0150f"+
		"\3\2\2\2\u0151\u0152\7t\2\2\u0152\u0153\7g\2\2\u0153\u0154\7v\2\2\u0154"+
		"\u0155\7w\2\2\u0155\u0156\7t\2\2\u0156\u0157\7p\2\2\u0157h\3\2\2\2\u0158"+
		"\u0159\7g\2\2\u0159\u015a\7z\2\2\u015a\u015b\7k\2\2\u015b\u015c\7v\2\2"+
		"\u015cj\3\2\2\2\u015d\u015e\7r\2\2\u015e\u015f\7t\2\2\u015f\u0160\7k\2"+
		"\2\u0160\u0161\7p\2\2\u0161\u0162\7v\2\2\u0162l\3\2\2\2\u0163\u0164\7"+
		"r\2\2\u0164\u0165\7t\2\2\u0165\u0166\7k\2\2\u0166\u0167\7p\2\2\u0167\u0168"+
		"\7v\2\2\u0168\u0169\7n\2\2\u0169\u016a\7p\2\2\u016an\3\2\2\2\u016b\u016c"+
		"\7e\2\2\u016c\u016d\7c\2\2\u016d\u016e\7n\2\2\u016e\u016f\7n\2\2\u016f"+
		"p\3\2\2\2\u0170\u0171\7k\2\2\u0171\u0172\7p\2\2\u0172\u0182\7v\2\2\u0173"+
		"\u0174\7u\2\2\u0174\u0175\7v\2\2\u0175\u0176\7t\2\2\u0176\u0177\7k\2\2"+
		"\u0177\u0178\7p\2\2\u0178\u0182\7i\2\2\u0179\u017a\7d\2\2\u017a\u017b"+
		"\7q\2\2\u017b\u017c\7q\2\2\u017c\u0182\7n\2\2\u017d\u017e\7e\2\2\u017e"+
		"\u017f\7j\2\2\u017f\u0180\7c\2\2\u0180\u0182\7t\2\2\u0181\u0170\3\2\2"+
		"\2\u0181\u0173\3\2\2\2\u0181\u0179\3\2\2\2\u0181\u017d\3\2\2\2\u0182r"+
		"\3\2\2\2\u0183\u0186\5q9\2\u0184\u0185\7]\2\2\u0185\u0187\7_\2\2\u0186"+
		"\u0184\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189t\3\2\2\2\u018a\u0191\5s:\2\u018b\u0191\5q9\2\u018c\u018d\7"+
		"r\2\2\u018d\u018e\7c\2\2\u018e\u018f\7k\2\2\u018f\u0191\7t\2\2\u0190\u018a"+
		"\3\2\2\2\u0190\u018b\3\2\2\2\u0190\u018c\3\2\2\2\u0191v\3\2\2\2\u0192"+
		"\u0193\7r\2\2\u0193\u0194\7c\2\2\u0194\u0195\7k\2\2\u0195\u0196\7t\2\2"+
		"\u0196\u0197\3\2\2\2\u0197\u0198\5\67\34\2\u0198\u0199\5u;\2\u0199\u019a"+
		"\7.\2\2\u019a\u019b\5u;\2\u019b\u019c\59\35\2\u019cx\3\2\2\2\u019d\u01a1"+
		"\5w<\2\u019e\u01a1\5s:\2\u019f\u01a1\5q9\2\u01a0\u019d\3\2\2\2\u01a0\u019e"+
		"\3\2\2\2\u01a0\u019f\3\2\2\2\u01a1z\3\2\2\2\u01a2\u01a3\4\62;\2\u01a3"+
		"|\3\2\2\2\u01a4\u01a6\t\3\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2"+
		"\u01a6\u01a8\3\2\2\2\u01a7\u01a9\5{>\2\u01a8\u01a7\3\2\2\2\u01a9\u01aa"+
		"\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab~\3\2\2\2\u01ac"+
		"\u01b1\7$\2\2\u01ad\u01b0\5\u0083B\2\u01ae\u01b0\5\u0085C\2\u01af\u01ad"+
		"\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b4\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7$"+
		"\2\2\u01b5\u0080\3\2\2\2\u01b6\u01b9\7)\2\2\u01b7\u01ba\5\u0083B\2\u01b8"+
		"\u01ba\5\u0085C\2\u01b9\u01b7\3\2\2\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb"+
		"\3\2\2\2\u01bb\u01bc\7)\2\2\u01bc\u0082\3\2\2\2\u01bd\u01be\n\4\2\2\u01be"+
		"\u0084\3\2\2\2\u01bf\u01c0\7^\2\2\u01c0\u01c1\t\5\2\2\u01c1\u0086\3\2"+
		"\2\2\u01c2\u01c3\7?\2\2\u01c3\u0088\3\2\2\2\u01c4\u01c5\7.\2\2\u01c5\u008a"+
		"\3\2\2\2\u01c6\u01c7\t\6\2\2\u01c7\u008c\3\2\2\2\u01c8\u01cb\5\u008bF"+
		"\2\u01c9\u01cb\5{>\2\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2\2\2\u01cb\u008e"+
		"\3\2\2\2\u01cc\u01d0\5\u008bF\2\u01cd\u01cf\5\u008dG\2\u01ce\u01cd\3\2"+
		"\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1"+
		"\u0090\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d5\t\7\2\2\u01d4\u01d3\3\2"+
		"\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01d9\bI\2\2\u01d9\u0092\3\2\2\2\26\2\u00b6\u00ba"+
		"\u00c0\u00c4\u00c8\u00e6\u00ff\u0181\u0188\u0190\u01a0\u01a5\u01aa\u01af"+
		"\u01b1\u01b9\u01ca\u01d0\u01d6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}