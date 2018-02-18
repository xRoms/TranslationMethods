// Generated from src/Parser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#gramm}.
	 * @param ctx the parse tree
	 */
	void enterGramm(ParserParser.GrammContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#gramm}.
	 * @param ctx the parse tree
	 */
	void exitGramm(ParserParser.GrammContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mtitle}
	 * labeled alternative in {@link ParserParser#title}.
	 * @param ctx the parse tree
	 */
	void enterMtitle(ParserParser.MtitleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mtitle}
	 * labeled alternative in {@link ParserParser#title}.
	 * @param ctx the parse tree
	 */
	void exitMtitle(ParserParser.MtitleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mheader}
	 * labeled alternative in {@link ParserParser#header}.
	 * @param ctx the parse tree
	 */
	void enterMheader(ParserParser.MheaderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mheader}
	 * labeled alternative in {@link ParserParser#header}.
	 * @param ctx the parse tree
	 */
	void exitMheader(ParserParser.MheaderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mmembers}
	 * labeled alternative in {@link ParserParser#members}.
	 * @param ctx the parse tree
	 */
	void enterMmembers(ParserParser.MmembersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mmembers}
	 * labeled alternative in {@link ParserParser#members}.
	 * @param ctx the parse tree
	 */
	void exitMmembers(ParserParser.MmembersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mnonterm}
	 * labeled alternative in {@link ParserParser#nonterm}.
	 * @param ctx the parse tree
	 */
	void enterMnonterm(ParserParser.MnontermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mnonterm}
	 * labeled alternative in {@link ParserParser#nonterm}.
	 * @param ctx the parse tree
	 */
	void exitMnonterm(ParserParser.MnontermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#anyrule}.
	 * @param ctx the parse tree
	 */
	void enterAnyrule(ParserParser.AnyruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#anyrule}.
	 * @param ctx the parse tree
	 */
	void exitAnyrule(ParserParser.AnyruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#anyrule1}.
	 * @param ctx the parse tree
	 */
	void enterAnyrule1(ParserParser.Anyrule1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#anyrule1}.
	 * @param ctx the parse tree
	 */
	void exitAnyrule1(ParserParser.Anyrule1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code mterminal}
	 * labeled alternative in {@link ParserParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterMterminal(ParserParser.MterminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mterminal}
	 * labeled alternative in {@link ParserParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitMterminal(ParserParser.MterminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ParserParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ParserParser.StringContext ctx);
}