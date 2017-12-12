// Generated from src/Hello.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COM=2, EL=3, VAR=4, BEGIN=5, END=6, INTEGER=7, SMC=8, CLN=9, WRITE=10, 
		OBR=11, CBR=12, SET=13, AP=14, OPERATION=15, NUMBER=16, NAME=17, TEXT=18;
	public static final int
		RULE_main_rule = 0, RULE_definevars = 1, RULE_linevars = 2, RULE_namevar = 3, 
		RULE_body = 4, RULE_statement = 5, RULE_assignment = 6, RULE_math = 7, 
		RULE_print = 8, RULE_inwrite = 9;
	public static final String[] ruleNames = {
		"main_rule", "definevars", "linevars", "namevar", "body", "statement", 
		"assignment", "math", "print", "inwrite"
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

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Main_ruleContext extends ParserRuleContext {
		public DefinevarsContext definevars() {
			return getRuleContext(DefinevarsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public Main_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterMain_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitMain_rule(this);
		}
	}

	public final Main_ruleContext main_rule() throws RecognitionException {
		Main_ruleContext _localctx = new Main_ruleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			definevars();
			setState(21);
			body();
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

	public static class DefinevarsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(HelloParser.VAR, 0); }
		public TerminalNode EL() { return getToken(HelloParser.EL, 0); }
		public List<LinevarsContext> linevars() {
			return getRuleContexts(LinevarsContext.class);
		}
		public LinevarsContext linevars(int i) {
			return getRuleContext(LinevarsContext.class,i);
		}
		public DefinevarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definevars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDefinevars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDefinevars(this);
		}
	}

	public final DefinevarsContext definevars() throws RecognitionException {
		DefinevarsContext _localctx = new DefinevarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definevars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(VAR);
			setState(24);
			match(EL);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				linevars();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
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

	public static class LinevarsContext extends ParserRuleContext {
		public Token NAME;
		public List<TerminalNode> NAME() { return getTokens(HelloParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HelloParser.NAME, i);
		}
		public TerminalNode CLN() { return getToken(HelloParser.CLN, 0); }
		public TerminalNode INTEGER() { return getToken(HelloParser.INTEGER, 0); }
		public TerminalNode SMC() { return getToken(HelloParser.SMC, 0); }
		public TerminalNode EL() { return getToken(HelloParser.EL, 0); }
		public List<TerminalNode> COM() { return getTokens(HelloParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(HelloParser.COM, i);
		}
		public List<TerminalNode> WS() { return getTokens(HelloParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(HelloParser.WS, i);
		}
		public LinevarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linevars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLinevars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLinevars(this);
		}
	}

	public final LinevarsContext linevars() throws RecognitionException {
		LinevarsContext _localctx = new LinevarsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_linevars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((LinevarsContext)_localctx).NAME = match(NAME);
			System.out.print("int " + (((LinevarsContext)_localctx).NAME!=null?((LinevarsContext)_localctx).NAME.getText():null));
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(32);
				match(COM);
				setState(33);
				match(WS);
				setState(34);
				((LinevarsContext)_localctx).NAME = match(NAME);
				System.out.print(", " + (((LinevarsContext)_localctx).NAME!=null?((LinevarsContext)_localctx).NAME.getText():null));
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println(";");
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(42);
				match(WS);
				}
			}

			setState(45);
			match(CLN);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(46);
				match(WS);
				}
			}

			setState(49);
			match(INTEGER);
			setState(50);
			match(SMC);
			setState(51);
			match(EL);
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

	public static class NamevarContext extends ParserRuleContext {
		public String name;
		public Token NAME;
		public TerminalNode NAME() { return getToken(HelloParser.NAME, 0); }
		public NamevarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namevar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterNamevar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitNamevar(this);
		}
	}

	public final NamevarContext namevar() throws RecognitionException {
		NamevarContext _localctx = new NamevarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namevar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			((NamevarContext)_localctx).NAME = match(NAME);
			((NamevarContext)_localctx).name =  (((NamevarContext)_localctx).NAME!=null?((NamevarContext)_localctx).NAME.getText():null);
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

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(HelloParser.BEGIN, 0); }
		public TerminalNode EL() { return getToken(HelloParser.EL, 0); }
		public TerminalNode END() { return getToken(HelloParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(BEGIN);
			System.out.print("int main() {\n");
			setState(58);
			match(EL);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WRITE || _la==NAME) {
				{
				{
				setState(59);
				statement();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(END);
			System.out.print("}");
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				assignment();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				print();
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

	public static class AssignmentContext extends ParserRuleContext {
		public Token NAME;
		public MathContext math;
		public TerminalNode NAME() { return getToken(HelloParser.NAME, 0); }
		public TerminalNode SET() { return getToken(HelloParser.SET, 0); }
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public TerminalNode SMC() { return getToken(HelloParser.SMC, 0); }
		public TerminalNode EL() { return getToken(HelloParser.EL, 0); }
		public List<TerminalNode> WS() { return getTokens(HelloParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(HelloParser.WS, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			((AssignmentContext)_localctx).NAME = match(NAME);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(73);
				match(WS);
				}
			}

			setState(76);
			match(SET);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(77);
				match(WS);
				}
			}

			setState(80);
			((AssignmentContext)_localctx).math = math();
			setState(81);
			match(SMC);
			setState(82);
			match(EL);
			System.out.println((((AssignmentContext)_localctx).NAME!=null?((AssignmentContext)_localctx).NAME.getText():null) + " = " + ((AssignmentContext)_localctx).math.out + ";");
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

	public static class MathContext extends ParserRuleContext {
		public String out;
		public Token NUMBER;
		public Token NAME;
		public Token OPERATION;
		public List<TerminalNode> WS() { return getTokens(HelloParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(HelloParser.WS, i);
		}
		public List<TerminalNode> OPERATION() { return getTokens(HelloParser.OPERATION); }
		public TerminalNode OPERATION(int i) {
			return getToken(HelloParser.OPERATION, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(HelloParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(HelloParser.NUMBER, i);
		}
		public List<TerminalNode> NAME() { return getTokens(HelloParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(HelloParser.NAME, i);
		}
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitMath(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		MathContext _localctx = new MathContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_math);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				{
				setState(85);
				((MathContext)_localctx).NUMBER = match(NUMBER);
				((MathContext)_localctx).out =  (((MathContext)_localctx).NUMBER!=null?((MathContext)_localctx).NUMBER.getText():null);
				}
				}
				break;
			case NAME:
				{
				{
				setState(87);
				((MathContext)_localctx).NAME = match(NAME);
				((MathContext)_localctx).out =  (((MathContext)_localctx).NAME!=null?((MathContext)_localctx).NAME.getText():null);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(91);
					match(WS);
					setState(92);
					((MathContext)_localctx).OPERATION = match(OPERATION);
					setState(93);
					match(WS);
					((MathContext)_localctx).out =  _localctx.out.concat(" " + (((MathContext)_localctx).OPERATION!=null?((MathContext)_localctx).OPERATION.getText():null) + " ");
					setState(99);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NUMBER:
						{
						{
						setState(95);
						((MathContext)_localctx).NUMBER = match(NUMBER);
						((MathContext)_localctx).out =  _localctx.out.concat((((MathContext)_localctx).NUMBER!=null?((MathContext)_localctx).NUMBER.getText():null));
						}
						}
						break;
					case NAME:
						{
						{
						setState(97);
						((MathContext)_localctx).NAME = match(NAME);
						((MathContext)_localctx).out =  _localctx.out.concat((((MathContext)_localctx).NAME!=null?((MathContext)_localctx).NAME.getText():null));
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class PrintContext extends ParserRuleContext {
		public InwriteContext inwrite;
		public TerminalNode WRITE() { return getToken(HelloParser.WRITE, 0); }
		public TerminalNode OBR() { return getToken(HelloParser.OBR, 0); }
		public InwriteContext inwrite() {
			return getRuleContext(InwriteContext.class,0);
		}
		public TerminalNode CBR() { return getToken(HelloParser.CBR, 0); }
		public TerminalNode SMC() { return getToken(HelloParser.SMC, 0); }
		public TerminalNode EL() { return getToken(HelloParser.EL, 0); }
		public TerminalNode WS() { return getToken(HelloParser.WS, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(WRITE);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(107);
				match(WS);
				}
			}

			setState(110);
			match(OBR);
			setState(111);
			((PrintContext)_localctx).inwrite = inwrite();
			System.out.print("printf(\"");
			          String temp = ((PrintContext)_localctx).inwrite.inside + ",";
			          String temp2 = "";
			          String temporal;
			          String part2 = "";
			          int last = -1;
			          int new1 = -1;
			          while (temp.indexOf((int)',', last + 1) != -1) {
			                new1 = temp.indexOf((int)',', last + 1);
			                temporal = temp.substring(last + 1, new1);
			                temporal = temporal.trim();
			                if (temporal.charAt(0) == '$') {
			                    part2 = part2.concat(", " + temporal.substring(1, temporal.length()));
			                    temp2 = temp2.concat("%d");
			                }
			                else {
			                    temp2 = temp2.concat(temporal.substring(1, temporal.length() - 1));
			                }
			                last = new1;
			          }
			          System.out.println(temp2 + "\"," + part2.substring(1, part2.length()) + ");");
			          
			setState(113);
			match(CBR);
			setState(114);
			match(SMC);
			setState(115);
			match(EL);
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

	public static class InwriteContext extends ParserRuleContext {
		public String inside;
		public MathContext math;
		public Token TEXT;
		public List<TerminalNode> COM() { return getTokens(HelloParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(HelloParser.COM, i);
		}
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public List<TerminalNode> TEXT() { return getTokens(HelloParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(HelloParser.TEXT, i);
		}
		public List<TerminalNode> WS() { return getTokens(HelloParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(HelloParser.WS, i);
		}
		public InwriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inwrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterInwrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitInwrite(this);
		}
	}

	public final InwriteContext inwrite() throws RecognitionException {
		InwriteContext _localctx = new InwriteContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inwrite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case NAME:
				{
				{
				setState(117);
				((InwriteContext)_localctx).math = math();
				((InwriteContext)_localctx).inside =  "$" + ((InwriteContext)_localctx).math.out;
				}
				}
				break;
			case TEXT:
				{
				{
				setState(120);
				((InwriteContext)_localctx).TEXT = match(TEXT);
				((InwriteContext)_localctx).inside =  (((InwriteContext)_localctx).TEXT!=null?((InwriteContext)_localctx).TEXT.getText():null);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS || _la==COM) {
				{
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(124);
					match(WS);
					}
				}

				setState(127);
				match(COM);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(128);
					match(WS);
					}
				}

				setState(136);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NUMBER:
				case NAME:
					{
					{
					setState(131);
					((InwriteContext)_localctx).math = math();
					((InwriteContext)_localctx).inside =  _localctx.inside.concat(",$" + ((InwriteContext)_localctx).math.out);
					}
					}
					break;
				case TEXT:
					{
					{
					{
					setState(134);
					((InwriteContext)_localctx).TEXT = match(TEXT);
					((InwriteContext)_localctx).inside =  _localctx.inside.concat("," + (((InwriteContext)_localctx).TEXT!=null?((InwriteContext)_localctx).TEXT.getText():null));
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(142);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u0092\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\3\3\6\3\35\n\3\r\3\16\3\36\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\5\4.\n\4\3\4\3\4\5\4\62\n\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\6"+
		"\3\6\3\6\3\7\3\7\5\7I\n\7\3\b\3\b\5\bM\n\b\3\b\3\b\5\bQ\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\\\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\tf\n\t\7\th\n\t\f\t\16\tk\13\t\3\n\3\n\5\no\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13}\n\13\3\13\5\13\u0080\n\13\3\13\3"+
		"\13\5\13\u0084\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u008b\n\13\7\13\u008d"+
		"\n\13\f\13\16\13\u0090\13\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2"+
		"\u0098\2\26\3\2\2\2\4\31\3\2\2\2\6 \3\2\2\2\b\67\3\2\2\2\n:\3\2\2\2\f"+
		"H\3\2\2\2\16J\3\2\2\2\20[\3\2\2\2\22l\3\2\2\2\24|\3\2\2\2\26\27\5\4\3"+
		"\2\27\30\5\n\6\2\30\3\3\2\2\2\31\32\7\6\2\2\32\34\7\5\2\2\33\35\5\6\4"+
		"\2\34\33\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\5\3\2\2"+
		"\2 !\7\23\2\2!(\b\4\1\2\"#\7\4\2\2#$\7\3\2\2$%\7\23\2\2%\'\b\4\1\2&\""+
		"\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+-\b\4\1\2"+
		",.\7\3\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\61\7\13\2\2\60\62\7\3\2\2\61"+
		"\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\t\2\2\64\65\7\n\2\2\65"+
		"\66\7\5\2\2\66\7\3\2\2\2\678\7\23\2\289\b\5\1\29\t\3\2\2\2:;\7\7\2\2;"+
		"<\b\6\1\2<@\7\5\2\2=?\5\f\7\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2"+
		"AC\3\2\2\2B@\3\2\2\2CD\7\b\2\2DE\b\6\1\2E\13\3\2\2\2FI\5\16\b\2GI\5\22"+
		"\n\2HF\3\2\2\2HG\3\2\2\2I\r\3\2\2\2JL\7\23\2\2KM\7\3\2\2LK\3\2\2\2LM\3"+
		"\2\2\2MN\3\2\2\2NP\7\17\2\2OQ\7\3\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS"+
		"\5\20\t\2ST\7\n\2\2TU\7\5\2\2UV\b\b\1\2V\17\3\2\2\2WX\7\22\2\2X\\\b\t"+
		"\1\2YZ\7\23\2\2Z\\\b\t\1\2[W\3\2\2\2[Y\3\2\2\2\\i\3\2\2\2]^\7\3\2\2^_"+
		"\7\21\2\2_`\7\3\2\2`e\b\t\1\2ab\7\22\2\2bf\b\t\1\2cd\7\23\2\2df\b\t\1"+
		"\2ea\3\2\2\2ec\3\2\2\2fh\3\2\2\2g]\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2"+
		"\2j\21\3\2\2\2ki\3\2\2\2ln\7\f\2\2mo\7\3\2\2nm\3\2\2\2no\3\2\2\2op\3\2"+
		"\2\2pq\7\r\2\2qr\5\24\13\2rs\b\n\1\2st\7\16\2\2tu\7\n\2\2uv\7\5\2\2v\23"+
		"\3\2\2\2wx\5\20\t\2xy\b\13\1\2y}\3\2\2\2z{\7\24\2\2{}\b\13\1\2|w\3\2\2"+
		"\2|z\3\2\2\2}\u008e\3\2\2\2~\u0080\7\3\2\2\177~\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\u0081\3\2\2\2\u0081\u0083\7\4\2\2\u0082\u0084\7\3\2\2\u0083"+
		"\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008a\3\2\2\2\u0085\u0086\5\20"+
		"\t\2\u0086\u0087\b\13\1\2\u0087\u008b\3\2\2\2\u0088\u0089\7\24\2\2\u0089"+
		"\u008b\b\13\1\2\u008a\u0085\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\3"+
		"\2\2\2\u008c\177\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\25\3\2\2\2\u0090\u008e\3\2\2\2\23\36(-\61@HLP[ei"+
		"n|\177\u0083\u008a\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}