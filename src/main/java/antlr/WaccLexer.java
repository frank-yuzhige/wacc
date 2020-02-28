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
		ARROW=1, DOUBLE_ARROW=2, COLON=3, DOT=4, ADD=5, SUB=6, MUL=7, DIV=8, MOD=9, 
		GTE=10, GT=11, LTE=12, LT=13, EQ=14, NEQ=15, AND=16, OR=17, DOTDOT=18, 
		NOT=19, LEN=20, ORD=21, CHR=22, FST=23, SND=24, SKIP_STAT=25, LPAR=26, 
		RPAR=27, LBRA=28, RBRA=29, LCUR=30, RCUR=31, SEMICOLON=32, BEGIN=33, IS=34, 
		END=35, NULL=36, TRUE=37, FALSE=38, IF=39, THEN=40, ELSE=41, FI=42, WHILE=43, 
		FOR=44, IN=45, DO=46, DONE=47, NEWPAIR=48, READ=49, FREE=50, RETURN=51, 
		EXIT=52, PRINT=53, PRINTLN=54, CALL=55, PAIR=56, VAR=57, CONST=58, NEWTYPE=59, 
		UNION=60, OF=61, WHEN=62, BASE_TYPE=63, INTEGER=64, STRLIT=65, CHARLIT=66, 
		ASSIGN=67, COMMA=68, IDENT=69, CAP_IDENT=70, COMMENT=71, WS=72;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ARROW", "DOUBLE_ARROW", "COLON", "DOT", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"GTE", "GT", "LTE", "LT", "EQ", "NEQ", "AND", "OR", "DOTDOT", "NOT", "LEN", 
		"ORD", "CHR", "FST", "SND", "SKIP_STAT", "LPAR", "RPAR", "LBRA", "RBRA", 
		"LCUR", "RCUR", "SEMICOLON", "BEGIN", "IS", "END", "NULL", "TRUE", "FALSE", 
		"IF", "THEN", "ELSE", "FI", "WHILE", "FOR", "IN", "DO", "DONE", "NEWPAIR", 
		"READ", "FREE", "RETURN", "EXIT", "PRINT", "PRINTLN", "CALL", "PAIR", 
		"VAR", "CONST", "NEWTYPE", "UNION", "OF", "WHEN", "BASE_TYPE", "DIGIT", 
		"INTEGER", "STRLIT", "CHARLIT", "NORMAL_CHAR", "ESC_CHAR", "ASSIGN", "COMMA", 
		"IDENT_HEAD", "IDENT_TAIL", "IDENT", "CAP_IDENT", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2J\u01e4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%"+
		"\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*"+
		"\3*\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\39\3:\3"+
		":\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3>\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3"+
		"@\3@\5@\u019d\n@\3A\3A\3B\6B\u01a2\nB\rB\16B\u01a3\3C\3C\3C\7C\u01a9\n"+
		"C\fC\16C\u01ac\13C\3C\3C\3D\3D\3D\5D\u01b3\nD\3D\3D\3E\3E\3F\3F\3F\3G"+
		"\3G\3H\3H\3I\3I\3J\3J\3J\5J\u01c5\nJ\3K\3K\7K\u01c9\nK\fK\16K\u01cc\13"+
		"K\3L\3L\7L\u01d0\nL\fL\16L\u01d3\13L\3M\3M\7M\u01d7\nM\fM\16M\u01da\13"+
		"M\3M\3M\3N\6N\u01df\nN\rN\16N\u01e0\3N\3N\2\2O\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"\2\u0083B\u0085C\u0087D\u0089\2\u008b\2\u008dE\u008fF\u0091\2\u0093\2"+
		"\u0095G\u0097H\u0099I\u009bJ\3\2\7\5\2$$))^^\13\2$$))\62\62^^ddhhpptt"+
		"vv\4\2aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u01eb\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2"+
		"\2\2\177\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\3\u009d\3\2\2\2\5\u00a0\3\2\2\2\7\u00a3\3\2\2\2\t\u00a5"+
		"\3\2\2\2\13\u00a7\3\2\2\2\r\u00a9\3\2\2\2\17\u00ab\3\2\2\2\21\u00ad\3"+
		"\2\2\2\23\u00af\3\2\2\2\25\u00b1\3\2\2\2\27\u00b4\3\2\2\2\31\u00b6\3\2"+
		"\2\2\33\u00b9\3\2\2\2\35\u00bb\3\2\2\2\37\u00be\3\2\2\2!\u00c1\3\2\2\2"+
		"#\u00c4\3\2\2\2%\u00c7\3\2\2\2\'\u00ca\3\2\2\2)\u00cc\3\2\2\2+\u00d0\3"+
		"\2\2\2-\u00d4\3\2\2\2/\u00d8\3\2\2\2\61\u00dc\3\2\2\2\63\u00e0\3\2\2\2"+
		"\65\u00e5\3\2\2\2\67\u00e7\3\2\2\29\u00e9\3\2\2\2;\u00eb\3\2\2\2=\u00ed"+
		"\3\2\2\2?\u00ef\3\2\2\2A\u00f1\3\2\2\2C\u00f3\3\2\2\2E\u00f9\3\2\2\2G"+
		"\u00fc\3\2\2\2I\u0100\3\2\2\2K\u0105\3\2\2\2M\u010a\3\2\2\2O\u0110\3\2"+
		"\2\2Q\u0113\3\2\2\2S\u0118\3\2\2\2U\u011d\3\2\2\2W\u0120\3\2\2\2Y\u0126"+
		"\3\2\2\2[\u012a\3\2\2\2]\u012d\3\2\2\2_\u0130\3\2\2\2a\u0135\3\2\2\2c"+
		"\u013d\3\2\2\2e\u0142\3\2\2\2g\u0147\3\2\2\2i\u014e\3\2\2\2k\u0153\3\2"+
		"\2\2m\u0159\3\2\2\2o\u0161\3\2\2\2q\u0166\3\2\2\2s\u016b\3\2\2\2u\u016f"+
		"\3\2\2\2w\u0175\3\2\2\2y\u017d\3\2\2\2{\u0183\3\2\2\2}\u0186\3\2\2\2\177"+
		"\u019c\3\2\2\2\u0081\u019e\3\2\2\2\u0083\u01a1\3\2\2\2\u0085\u01a5\3\2"+
		"\2\2\u0087\u01af\3\2\2\2\u0089\u01b6\3\2\2\2\u008b\u01b8\3\2\2\2\u008d"+
		"\u01bb\3\2\2\2\u008f\u01bd\3\2\2\2\u0091\u01bf\3\2\2\2\u0093\u01c4\3\2"+
		"\2\2\u0095\u01c6\3\2\2\2\u0097\u01cd\3\2\2\2\u0099\u01d4\3\2\2\2\u009b"+
		"\u01de\3\2\2\2\u009d\u009e\7/\2\2\u009e\u009f\7@\2\2\u009f\4\3\2\2\2\u00a0"+
		"\u00a1\7?\2\2\u00a1\u00a2\7@\2\2\u00a2\6\3\2\2\2\u00a3\u00a4\7<\2\2\u00a4"+
		"\b\3\2\2\2\u00a5\u00a6\7\60\2\2\u00a6\n\3\2\2\2\u00a7\u00a8\7-\2\2\u00a8"+
		"\f\3\2\2\2\u00a9\u00aa\7/\2\2\u00aa\16\3\2\2\2\u00ab\u00ac\7,\2\2\u00ac"+
		"\20\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\22\3\2\2\2\u00af\u00b0\7\'\2\2"+
		"\u00b0\24\3\2\2\2\u00b1\u00b2\7@\2\2\u00b2\u00b3\7?\2\2\u00b3\26\3\2\2"+
		"\2\u00b4\u00b5\7@\2\2\u00b5\30\3\2\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8"+
		"\7?\2\2\u00b8\32\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\34\3\2\2\2\u00bb\u00bc"+
		"\7?\2\2\u00bc\u00bd\7?\2\2\u00bd\36\3\2\2\2\u00be\u00bf\7#\2\2\u00bf\u00c0"+
		"\7?\2\2\u00c0 \3\2\2\2\u00c1\u00c2\7(\2\2\u00c2\u00c3\7(\2\2\u00c3\"\3"+
		"\2\2\2\u00c4\u00c5\7~\2\2\u00c5\u00c6\7~\2\2\u00c6$\3\2\2\2\u00c7\u00c8"+
		"\7\60\2\2\u00c8\u00c9\7\60\2\2\u00c9&\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb"+
		"(\3\2\2\2\u00cc\u00cd\7n\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"*\3\2\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3\7f\2\2\u00d3"+
		",\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7\7t\2\2\u00d7"+
		".\3\2\2\2\u00d8\u00d9\7h\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7v\2\2\u00db"+
		"\60\3\2\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7f\2\2\u00df"+
		"\62\3\2\2\2\u00e0\u00e1\7u\2\2\u00e1\u00e2\7m\2\2\u00e2\u00e3\7k\2\2\u00e3"+
		"\u00e4\7r\2\2\u00e4\64\3\2\2\2\u00e5\u00e6\7*\2\2\u00e6\66\3\2\2\2\u00e7"+
		"\u00e8\7+\2\2\u00e88\3\2\2\2\u00e9\u00ea\7]\2\2\u00ea:\3\2\2\2\u00eb\u00ec"+
		"\7_\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7}\2\2\u00ee>\3\2\2\2\u00ef\u00f0\7"+
		"\177\2\2\u00f0@\3\2\2\2\u00f1\u00f2\7=\2\2\u00f2B\3\2\2\2\u00f3\u00f4"+
		"\7d\2\2\u00f4\u00f5\7g\2\2\u00f5\u00f6\7i\2\2\u00f6\u00f7\7k\2\2\u00f7"+
		"\u00f8\7p\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7u\2\2\u00fb"+
		"F\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7p\2\2\u00fe\u00ff\7f\2\2\u00ff"+
		"H\3\2\2\2\u0100\u0101\7p\2\2\u0101\u0102\7w\2\2\u0102\u0103\7n\2\2\u0103"+
		"\u0104\7n\2\2\u0104J\3\2\2\2\u0105\u0106\7v\2\2\u0106\u0107\7t\2\2\u0107"+
		"\u0108\7w\2\2\u0108\u0109\7g\2\2\u0109L\3\2\2\2\u010a\u010b\7h\2\2\u010b"+
		"\u010c\7c\2\2\u010c\u010d\7n\2\2\u010d\u010e\7u\2\2\u010e\u010f\7g\2\2"+
		"\u010fN\3\2\2\2\u0110\u0111\7k\2\2\u0111\u0112\7h\2\2\u0112P\3\2\2\2\u0113"+
		"\u0114\7v\2\2\u0114\u0115\7j\2\2\u0115\u0116\7g\2\2\u0116\u0117\7p\2\2"+
		"\u0117R\3\2\2\2\u0118\u0119\7g\2\2\u0119\u011a\7n\2\2\u011a\u011b\7u\2"+
		"\2\u011b\u011c\7g\2\2\u011cT\3\2\2\2\u011d\u011e\7h\2\2\u011e\u011f\7"+
		"k\2\2\u011fV\3\2\2\2\u0120\u0121\7y\2\2\u0121\u0122\7j\2\2\u0122\u0123"+
		"\7k\2\2\u0123\u0124\7n\2\2\u0124\u0125\7g\2\2\u0125X\3\2\2\2\u0126\u0127"+
		"\7h\2\2\u0127\u0128\7q\2\2\u0128\u0129\7t\2\2\u0129Z\3\2\2\2\u012a\u012b"+
		"\7k\2\2\u012b\u012c\7p\2\2\u012c\\\3\2\2\2\u012d\u012e\7f\2\2\u012e\u012f"+
		"\7q\2\2\u012f^\3\2\2\2\u0130\u0131\7f\2\2\u0131\u0132\7q\2\2\u0132\u0133"+
		"\7p\2\2\u0133\u0134\7g\2\2\u0134`\3\2\2\2\u0135\u0136\7p\2\2\u0136\u0137"+
		"\7g\2\2\u0137\u0138\7y\2\2\u0138\u0139\7r\2\2\u0139\u013a\7c\2\2\u013a"+
		"\u013b\7k\2\2\u013b\u013c\7t\2\2\u013cb\3\2\2\2\u013d\u013e\7t\2\2\u013e"+
		"\u013f\7g\2\2\u013f\u0140\7c\2\2\u0140\u0141\7f\2\2\u0141d\3\2\2\2\u0142"+
		"\u0143\7h\2\2\u0143\u0144\7t\2\2\u0144\u0145\7g\2\2\u0145\u0146\7g\2\2"+
		"\u0146f\3\2\2\2\u0147\u0148\7t\2\2\u0148\u0149\7g\2\2\u0149\u014a\7v\2"+
		"\2\u014a\u014b\7w\2\2\u014b\u014c\7t\2\2\u014c\u014d\7p\2\2\u014dh\3\2"+
		"\2\2\u014e\u014f\7g\2\2\u014f\u0150\7z\2\2\u0150\u0151\7k\2\2\u0151\u0152"+
		"\7v\2\2\u0152j\3\2\2\2\u0153\u0154\7r\2\2\u0154\u0155\7t\2\2\u0155\u0156"+
		"\7k\2\2\u0156\u0157\7p\2\2\u0157\u0158\7v\2\2\u0158l\3\2\2\2\u0159\u015a"+
		"\7r\2\2\u015a\u015b\7t\2\2\u015b\u015c\7k\2\2\u015c\u015d\7p\2\2\u015d"+
		"\u015e\7v\2\2\u015e\u015f\7n\2\2\u015f\u0160\7p\2\2\u0160n\3\2\2\2\u0161"+
		"\u0162\7e\2\2\u0162\u0163\7c\2\2\u0163\u0164\7n\2\2\u0164\u0165\7n\2\2"+
		"\u0165p\3\2\2\2\u0166\u0167\7r\2\2\u0167\u0168\7c\2\2\u0168\u0169\7k\2"+
		"\2\u0169\u016a\7t\2\2\u016ar\3\2\2\2\u016b\u016c\7x\2\2\u016c\u016d\7"+
		"c\2\2\u016d\u016e\7t\2\2\u016et\3\2\2\2\u016f\u0170\7e\2\2\u0170\u0171"+
		"\7q\2\2\u0171\u0172\7p\2\2\u0172\u0173\7u\2\2\u0173\u0174\7v\2\2\u0174"+
		"v\3\2\2\2\u0175\u0176\7p\2\2\u0176\u0177\7g\2\2\u0177\u0178\7y\2\2\u0178"+
		"\u0179\7v\2\2\u0179\u017a\7{\2\2\u017a\u017b\7r\2\2\u017b\u017c\7g\2\2"+
		"\u017cx\3\2\2\2\u017d\u017e\7w\2\2\u017e\u017f\7p\2\2\u017f\u0180\7k\2"+
		"\2\u0180\u0181\7q\2\2\u0181\u0182\7p\2\2\u0182z\3\2\2\2\u0183\u0184\7"+
		"q\2\2\u0184\u0185\7h\2\2\u0185|\3\2\2\2\u0186\u0187\7y\2\2\u0187\u0188"+
		"\7j\2\2\u0188\u0189\7g\2\2\u0189\u018a\7p\2\2\u018a~\3\2\2\2\u018b\u018c"+
		"\7k\2\2\u018c\u018d\7p\2\2\u018d\u019d\7v\2\2\u018e\u018f\7u\2\2\u018f"+
		"\u0190\7v\2\2\u0190\u0191\7t\2\2\u0191\u0192\7k\2\2\u0192\u0193\7p\2\2"+
		"\u0193\u019d\7i\2\2\u0194\u0195\7d\2\2\u0195\u0196\7q\2\2\u0196\u0197"+
		"\7q\2\2\u0197\u019d\7n\2\2\u0198\u0199\7e\2\2\u0199\u019a\7j\2\2\u019a"+
		"\u019b\7c\2\2\u019b\u019d\7t\2\2\u019c\u018b\3\2\2\2\u019c\u018e\3\2\2"+
		"\2\u019c\u0194\3\2\2\2\u019c\u0198\3\2\2\2\u019d\u0080\3\2\2\2\u019e\u019f"+
		"\4\62;\2\u019f\u0082\3\2\2\2\u01a0\u01a2\5\u0081A\2\u01a1\u01a0\3\2\2"+
		"\2\u01a2\u01a3\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u0084"+
		"\3\2\2\2\u01a5\u01aa\7$\2\2\u01a6\u01a9\5\u0089E\2\u01a7\u01a9\5\u008b"+
		"F\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01aa\3\2"+
		"\2\2\u01ad\u01ae\7$\2\2\u01ae\u0086\3\2\2\2\u01af\u01b2\7)\2\2\u01b0\u01b3"+
		"\5\u0089E\2\u01b1\u01b3\5\u008bF\2\u01b2\u01b0\3\2\2\2\u01b2\u01b1\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\7)\2\2\u01b5\u0088\3\2\2\2\u01b6"+
		"\u01b7\n\2\2\2\u01b7\u008a\3\2\2\2\u01b8\u01b9\7^\2\2\u01b9\u01ba\t\3"+
		"\2\2\u01ba\u008c\3\2\2\2\u01bb\u01bc\7?\2\2\u01bc\u008e\3\2\2\2\u01bd"+
		"\u01be\7.\2\2\u01be\u0090\3\2\2\2\u01bf\u01c0\t\4\2\2\u01c0\u0092\3\2"+
		"\2\2\u01c1\u01c5\5\u0091I\2\u01c2\u01c5\4C\\\2\u01c3\u01c5\5\u0081A\2"+
		"\u01c4\u01c1\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5\u0094"+
		"\3\2\2\2\u01c6\u01ca\5\u0091I\2\u01c7\u01c9\5\u0093J\2\u01c8\u01c7\3\2"+
		"\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u0096\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01d1\4C\\\2\u01ce\u01d0\5\u0093"+
		"J\2\u01cf\u01ce\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d2\3\2\2\2\u01d2\u0098\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d4\u01d8\7%"+
		"\2\2\u01d5\u01d7\n\5\2\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01db\3\2\2\2\u01da\u01d8\3\2"+
		"\2\2\u01db\u01dc\bM\2\2\u01dc\u009a\3\2\2\2\u01dd\u01df\t\6\2\2\u01de"+
		"\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0\u01e1\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\bN\2\2\u01e3\u009c\3\2\2\2\r\2\u019c"+
		"\u01a3\u01a8\u01aa\u01b2\u01c4\u01ca\u01d1\u01d8\u01e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}