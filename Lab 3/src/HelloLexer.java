// Generated from src/Hello.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COM=2, EL=3, VAR=4, BEGIN=5, END=6, INTEGER=7, SMC=8, CLN=9, WRITE=10, 
		OBR=11, CBR=12, SET=13, AP=14, OPERATION=15, NUMBER=16, NAME=17, TEXT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COM", "EL", "VAR", "BEGIN", "END", "INTEGER", "SMC", "CLN", "WRITE", 
		"OBR", "CBR", "SET", "AP", "OPERATION", "NUMBER", "NAME", "TEXT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "' '", "','", null, "'var'", "'begin'", "'end.'", "'integer'", "';'", 
		"':'", "'write'", "'('", "')'", "':='", "'''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COM", "EL", "VAR", "BEGIN", "END", "INTEGER", "SMC", "CLN", 
		"WRITE", "OBR", "CBR", "SET", "AP", "OPERATION", "NUMBER", "NAME", "TEXT"
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


	public HelloLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\5\4-\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\7\21`\n\21\f\21\16\21c\13"+
		"\21\5\21e\n\21\3\22\6\22h\n\22\r\22\16\22i\3\23\3\23\7\23n\n\23\f\23\16"+
		"\23q\13\23\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\4\5\2,-//\61\61\7\2\""+
		"\"\60\60\62;C\\c|\2x\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7,\3\2\2\2"+
		"\t\60\3\2\2\2\13\64\3\2\2\2\r:\3\2\2\2\17?\3\2\2\2\21G\3\2\2\2\23I\3\2"+
		"\2\2\25K\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35X\3\2\2\2\37Z\3"+
		"\2\2\2!d\3\2\2\2#g\3\2\2\2%k\3\2\2\2\'(\7\"\2\2(\4\3\2\2\2)*\7.\2\2*\6"+
		"\3\2\2\2+-\7\17\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\f\2\2/\b\3\2\2\2"+
		"\60\61\7x\2\2\61\62\7c\2\2\62\63\7t\2\2\63\n\3\2\2\2\64\65\7d\2\2\65\66"+
		"\7g\2\2\66\67\7i\2\2\678\7k\2\289\7p\2\29\f\3\2\2\2:;\7g\2\2;<\7p\2\2"+
		"<=\7f\2\2=>\7\60\2\2>\16\3\2\2\2?@\7k\2\2@A\7p\2\2AB\7v\2\2BC\7g\2\2C"+
		"D\7i\2\2DE\7g\2\2EF\7t\2\2F\20\3\2\2\2GH\7=\2\2H\22\3\2\2\2IJ\7<\2\2J"+
		"\24\3\2\2\2KL\7y\2\2LM\7t\2\2MN\7k\2\2NO\7v\2\2OP\7g\2\2P\26\3\2\2\2Q"+
		"R\7*\2\2R\30\3\2\2\2ST\7+\2\2T\32\3\2\2\2UV\7<\2\2VW\7?\2\2W\34\3\2\2"+
		"\2XY\7)\2\2Y\36\3\2\2\2Z[\t\2\2\2[ \3\2\2\2\\e\7\62\2\2]a\4\63;\2^`\4"+
		"\62;\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2\2d\\"+
		"\3\2\2\2d]\3\2\2\2e\"\3\2\2\2fh\4c|\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij"+
		"\3\2\2\2j$\3\2\2\2ko\7)\2\2ln\t\3\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op"+
		"\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7)\2\2s&\3\2\2\2\b\2,adio\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}