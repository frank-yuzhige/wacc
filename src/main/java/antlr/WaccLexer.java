// Generated from ./WaccLexer.g4 by ANTLR 4.7
package antlr;
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
		PRINT=46, PRINTLN=47, CALL=48, PAIR=49, VAR=50, BASE_TYPE=51, INTEGER=52, 
		STRLIT=53, CHARLIT=54, ASSIGN=55, COMMA=56, IDENT=57, COMMENT=58, WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ADD", "SUB", "MUL", "DIV", "MOD", "GTE", "GT", "LTE", "LT", "EQ", "NEQ", 
		"AND", "OR", "NOT", "LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", "LPAR", 
		"RPAR", "LBRA", "RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", 
		"NULL", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", "DO", "DONE", 
		"NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", 
		"PAIR", "VAR", "BASE_TYPE", "DIGIT", "INTEGER", "STRLIT", "CHARLIT", "NORMAL_CHAR", 
		"ESC_CHAR", "ASSIGN", "COMMA", "IDENT_HEAD", "IDENT_TAIL", "IDENT", "COMMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>='", "'>'", "'<='", "'<'", 
		"'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", "'fst'", 
		"'snd'", "'skip'", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "'begin'", 
		"'is'", "'end'", "'null'", "'true'", "'false'", "'if'", "'then'", "'else'", 
		"'fi'", "'while'", "'do'", "'done'", "'newpair'", "'read'", "'free'", 
		"'return'", "'exit'", "'print'", "'println'", "'call'", "'pair'", "'var'", 
		null, null, null, null, "'='", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADD", "SUB", "MUL", "DIV", "MOD", "GTE", "GT", "LTE", "LT", "EQ", 
		"NEQ", "AND", "OR", "NOT", "LEN", "ORD", "CHR", "FST", "SND", "SKIP_STAT", 
		"LPAR", "RPAR", "LBRA", "RBRA", "LCUR", "RCUR", "SEMICOLON", "BEGIN", 
		"IS", "END", "NULL", "TRUE", "FALSE", "IF", "THEN", "ELSE", "FI", "WHILE", 
		"DO", "DONE", "NEWPAIR", "READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", 
		"CALL", "PAIR", "VAR", "BASE_TYPE", "INTEGER", "STRLIT", "CHARLIT", "ASSIGN", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0192\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0153\n\64\3\65\3\65"+
		"\3\66\6\66\u0158\n\66\r\66\16\66\u0159\3\67\3\67\3\67\7\67\u015f\n\67"+
		"\f\67\16\67\u0162\13\67\3\67\3\67\38\38\38\58\u0169\n8\38\38\39\39\3:"+
		"\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\5>\u017a\n>\3?\3?\7?\u017e\n?\f?\16?\u0181"+
		"\13?\3@\3@\7@\u0185\n@\f@\16@\u0188\13@\3@\3@\3A\6A\u018d\nA\rA\16A\u018e"+
		"\3A\3A\2\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\2k\66m\67o8q\2s\2u9w:y\2{\2};\177<\u0081=\3\2\7\5\2$$))^^\13\2$$))\62"+
		"\62^^ddhhppttvv\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0197\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2"+
		"\2u\3\2\2\2\2w\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3\u0083"+
		"\3\2\2\2\5\u0085\3\2\2\2\7\u0087\3\2\2\2\t\u0089\3\2\2\2\13\u008b\3\2"+
		"\2\2\r\u008d\3\2\2\2\17\u0090\3\2\2\2\21\u0092\3\2\2\2\23\u0095\3\2\2"+
		"\2\25\u0097\3\2\2\2\27\u009a\3\2\2\2\31\u009d\3\2\2\2\33\u00a0\3\2\2\2"+
		"\35\u00a3\3\2\2\2\37\u00a5\3\2\2\2!\u00a9\3\2\2\2#\u00ad\3\2\2\2%\u00b1"+
		"\3\2\2\2\'\u00b5\3\2\2\2)\u00b9\3\2\2\2+\u00be\3\2\2\2-\u00c0\3\2\2\2"+
		"/\u00c2\3\2\2\2\61\u00c4\3\2\2\2\63\u00c6\3\2\2\2\65\u00c8\3\2\2\2\67"+
		"\u00ca\3\2\2\29\u00cc\3\2\2\2;\u00d2\3\2\2\2=\u00d5\3\2\2\2?\u00d9\3\2"+
		"\2\2A\u00de\3\2\2\2C\u00e3\3\2\2\2E\u00e9\3\2\2\2G\u00ec\3\2\2\2I\u00f1"+
		"\3\2\2\2K\u00f6\3\2\2\2M\u00f9\3\2\2\2O\u00ff\3\2\2\2Q\u0102\3\2\2\2S"+
		"\u0107\3\2\2\2U\u010f\3\2\2\2W\u0114\3\2\2\2Y\u0119\3\2\2\2[\u0120\3\2"+
		"\2\2]\u0125\3\2\2\2_\u012b\3\2\2\2a\u0133\3\2\2\2c\u0138\3\2\2\2e\u013d"+
		"\3\2\2\2g\u0152\3\2\2\2i\u0154\3\2\2\2k\u0157\3\2\2\2m\u015b\3\2\2\2o"+
		"\u0165\3\2\2\2q\u016c\3\2\2\2s\u016e\3\2\2\2u\u0171\3\2\2\2w\u0173\3\2"+
		"\2\2y\u0175\3\2\2\2{\u0179\3\2\2\2}\u017b\3\2\2\2\177\u0182\3\2\2\2\u0081"+
		"\u018c\3\2\2\2\u0083\u0084\7-\2\2\u0084\4\3\2\2\2\u0085\u0086\7/\2\2\u0086"+
		"\6\3\2\2\2\u0087\u0088\7,\2\2\u0088\b\3\2\2\2\u0089\u008a\7\61\2\2\u008a"+
		"\n\3\2\2\2\u008b\u008c\7\'\2\2\u008c\f\3\2\2\2\u008d\u008e\7@\2\2\u008e"+
		"\u008f\7?\2\2\u008f\16\3\2\2\2\u0090\u0091\7@\2\2\u0091\20\3\2\2\2\u0092"+
		"\u0093\7>\2\2\u0093\u0094\7?\2\2\u0094\22\3\2\2\2\u0095\u0096\7>\2\2\u0096"+
		"\24\3\2\2\2\u0097\u0098\7?\2\2\u0098\u0099\7?\2\2\u0099\26\3\2\2\2\u009a"+
		"\u009b\7#\2\2\u009b\u009c\7?\2\2\u009c\30\3\2\2\2\u009d\u009e\7(\2\2\u009e"+
		"\u009f\7(\2\2\u009f\32\3\2\2\2\u00a0\u00a1\7~\2\2\u00a1\u00a2\7~\2\2\u00a2"+
		"\34\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4\36\3\2\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"\u00a7\7g\2\2\u00a7\u00a8\7p\2\2\u00a8 \3\2\2\2\u00a9\u00aa\7q\2\2\u00aa"+
		"\u00ab\7t\2\2\u00ab\u00ac\7f\2\2\u00ac\"\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae"+
		"\u00af\7j\2\2\u00af\u00b0\7t\2\2\u00b0$\3\2\2\2\u00b1\u00b2\7h\2\2\u00b2"+
		"\u00b3\7u\2\2\u00b3\u00b4\7v\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7u\2\2\u00b6"+
		"\u00b7\7p\2\2\u00b7\u00b8\7f\2\2\u00b8(\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba"+
		"\u00bb\7m\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7r\2\2\u00bd*\3\2\2\2\u00be"+
		"\u00bf\7*\2\2\u00bf,\3\2\2\2\u00c0\u00c1\7+\2\2\u00c1.\3\2\2\2\u00c2\u00c3"+
		"\7]\2\2\u00c3\60\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5\62\3\2\2\2\u00c6\u00c7"+
		"\7}\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7\177\2\2\u00c9\66\3\2\2\2\u00ca"+
		"\u00cb\7=\2\2\u00cb8\3\2\2\2\u00cc\u00cd\7d\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\u00cf\7i\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1:\3\2\2\2\u00d2"+
		"\u00d3\7k\2\2\u00d3\u00d4\7u\2\2\u00d4<\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6"+
		"\u00d7\7p\2\2\u00d7\u00d8\7f\2\2\u00d8>\3\2\2\2\u00d9\u00da\7p\2\2\u00da"+
		"\u00db\7w\2\2\u00db\u00dc\7n\2\2\u00dc\u00dd\7n\2\2\u00dd@\3\2\2\2\u00de"+
		"\u00df\7v\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1\7w\2\2\u00e1\u00e2\7g\2\2"+
		"\u00e2B\3\2\2\2\u00e3\u00e4\7h\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7n\2"+
		"\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8D\3\2\2\2\u00e9\u00ea\7"+
		"k\2\2\u00ea\u00eb\7h\2\2\u00ebF\3\2\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee"+
		"\7j\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7p\2\2\u00f0H\3\2\2\2\u00f1\u00f2"+
		"\7g\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"J\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7k\2\2\u00f8L\3\2\2\2\u00f9\u00fa"+
		"\7y\2\2\u00fa\u00fb\7j\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7n\2\2\u00fd"+
		"\u00fe\7g\2\2\u00feN\3\2\2\2\u00ff\u0100\7f\2\2\u0100\u0101\7q\2\2\u0101"+
		"P\3\2\2\2\u0102\u0103\7f\2\2\u0103\u0104\7q\2\2\u0104\u0105\7p\2\2\u0105"+
		"\u0106\7g\2\2\u0106R\3\2\2\2\u0107\u0108\7p\2\2\u0108\u0109\7g\2\2\u0109"+
		"\u010a\7y\2\2\u010a\u010b\7r\2\2\u010b\u010c\7c\2\2\u010c\u010d\7k\2\2"+
		"\u010d\u010e\7t\2\2\u010eT\3\2\2\2\u010f\u0110\7t\2\2\u0110\u0111\7g\2"+
		"\2\u0111\u0112\7c\2\2\u0112\u0113\7f\2\2\u0113V\3\2\2\2\u0114\u0115\7"+
		"h\2\2\u0115\u0116\7t\2\2\u0116\u0117\7g\2\2\u0117\u0118\7g\2\2\u0118X"+
		"\3\2\2\2\u0119\u011a\7t\2\2\u011a\u011b\7g\2\2\u011b\u011c\7v\2\2\u011c"+
		"\u011d\7w\2\2\u011d\u011e\7t\2\2\u011e\u011f\7p\2\2\u011fZ\3\2\2\2\u0120"+
		"\u0121\7g\2\2\u0121\u0122\7z\2\2\u0122\u0123\7k\2\2\u0123\u0124\7v\2\2"+
		"\u0124\\\3\2\2\2\u0125\u0126\7r\2\2\u0126\u0127\7t\2\2\u0127\u0128\7k"+
		"\2\2\u0128\u0129\7p\2\2\u0129\u012a\7v\2\2\u012a^\3\2\2\2\u012b\u012c"+
		"\7r\2\2\u012c\u012d\7t\2\2\u012d\u012e\7k\2\2\u012e\u012f\7p\2\2\u012f"+
		"\u0130\7v\2\2\u0130\u0131\7n\2\2\u0131\u0132\7p\2\2\u0132`\3\2\2\2\u0133"+
		"\u0134\7e\2\2\u0134\u0135\7c\2\2\u0135\u0136\7n\2\2\u0136\u0137\7n\2\2"+
		"\u0137b\3\2\2\2\u0138\u0139\7r\2\2\u0139\u013a\7c\2\2\u013a\u013b\7k\2"+
		"\2\u013b\u013c\7t\2\2\u013cd\3\2\2\2\u013d\u013e\7x\2\2\u013e\u013f\7"+
		"c\2\2\u013f\u0140\7t\2\2\u0140f\3\2\2\2\u0141\u0142\7k\2\2\u0142\u0143"+
		"\7p\2\2\u0143\u0153\7v\2\2\u0144\u0145\7u\2\2\u0145\u0146\7v\2\2\u0146"+
		"\u0147\7t\2\2\u0147\u0148\7k\2\2\u0148\u0149\7p\2\2\u0149\u0153\7i\2\2"+
		"\u014a\u014b\7d\2\2\u014b\u014c\7q\2\2\u014c\u014d\7q\2\2\u014d\u0153"+
		"\7n\2\2\u014e\u014f\7e\2\2\u014f\u0150\7j\2\2\u0150\u0151\7c\2\2\u0151"+
		"\u0153\7t\2\2\u0152\u0141\3\2\2\2\u0152\u0144\3\2\2\2\u0152\u014a\3\2"+
		"\2\2\u0152\u014e\3\2\2\2\u0153h\3\2\2\2\u0154\u0155\4\62;\2\u0155j\3\2"+
		"\2\2\u0156\u0158\5i\65\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015al\3\2\2\2\u015b\u0160\7$\2\2\u015c"+
		"\u015f\5q9\2\u015d\u015f\5s:\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2"+
		"\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163"+
		"\3\2\2\2\u0162\u0160\3\2\2\2\u0163\u0164\7$\2\2\u0164n\3\2\2\2\u0165\u0168"+
		"\7)\2\2\u0166\u0169\5q9\2\u0167\u0169\5s:\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\7)\2\2\u016bp\3\2\2\2\u016c"+
		"\u016d\n\2\2\2\u016dr\3\2\2\2\u016e\u016f\7^\2\2\u016f\u0170\t\3\2\2\u0170"+
		"t\3\2\2\2\u0171\u0172\7?\2\2\u0172v\3\2\2\2\u0173\u0174\7.\2\2\u0174x"+
		"\3\2\2\2\u0175\u0176\t\4\2\2\u0176z\3\2\2\2\u0177\u017a\5y=\2\u0178\u017a"+
		"\5i\65\2\u0179\u0177\3\2\2\2\u0179\u0178\3\2\2\2\u017a|\3\2\2\2\u017b"+
		"\u017f\5y=\2\u017c\u017e\5{>\2\u017d\u017c\3\2\2\2\u017e\u0181\3\2\2\2"+
		"\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180~\3\2\2\2\u0181\u017f\3"+
		"\2\2\2\u0182\u0186\7%\2\2\u0183\u0185\n\5\2\2\u0184\u0183\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2"+
		"\2\2\u0188\u0186\3\2\2\2\u0189\u018a\b@\2\2\u018a\u0080\3\2\2\2\u018b"+
		"\u018d\t\6\2\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\bA\2\2\u0191"+
		"\u0082\3\2\2\2\f\2\u0152\u0159\u015e\u0160\u0168\u0179\u017f\u0186\u018e"+
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