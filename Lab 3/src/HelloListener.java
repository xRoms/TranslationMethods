// Generated from src/Hello.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#main_rule}.
	 * @param ctx the parse tree
	 */
	void enterMain_rule(HelloParser.Main_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#main_rule}.
	 * @param ctx the parse tree
	 */
	void exitMain_rule(HelloParser.Main_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#definevars}.
	 * @param ctx the parse tree
	 */
	void enterDefinevars(HelloParser.DefinevarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#definevars}.
	 * @param ctx the parse tree
	 */
	void exitDefinevars(HelloParser.DefinevarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#linevars}.
	 * @param ctx the parse tree
	 */
	void enterLinevars(HelloParser.LinevarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#linevars}.
	 * @param ctx the parse tree
	 */
	void exitLinevars(HelloParser.LinevarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#namevar}.
	 * @param ctx the parse tree
	 */
	void enterNamevar(HelloParser.NamevarContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#namevar}.
	 * @param ctx the parse tree
	 */
	void exitNamevar(HelloParser.NamevarContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(HelloParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(HelloParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HelloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HelloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(HelloParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(HelloParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMath(HelloParser.MathContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMath(HelloParser.MathContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(HelloParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(HelloParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#inwrite}.
	 * @param ctx the parse tree
	 */
	void enterInwrite(HelloParser.InwriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#inwrite}.
	 * @param ctx the parse tree
	 */
	void exitInwrite(HelloParser.InwriteContext ctx);
}