// Generated from C:/Users/ASUS/Desktop/compiler1-project/compiler1-project/grammars/JinjaHtmlParser.g4 by ANTLR 4.13.2
package compiler1-project.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JinjaHtmlParser}.
 */
public interface JinjaHtmlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(JinjaHtmlParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(JinjaHtmlParser.HtmlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#scriptletOrSeaWs}.
	 * @param ctx the parse tree
	 */
	void enterScriptletOrSeaWs(JinjaHtmlParser.ScriptletOrSeaWsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#scriptletOrSeaWs}.
	 * @param ctx the parse tree
	 */
	void exitScriptletOrSeaWs(JinjaHtmlParser.ScriptletOrSeaWsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlElements}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElements(JinjaHtmlParser.HtmlElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlElements}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElements(JinjaHtmlParser.HtmlElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(JinjaHtmlParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(JinjaHtmlParser.HtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#tagEnd}.
	 * @param ctx the parse tree
	 */
	void enterTagEnd(JinjaHtmlParser.TagEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#tagEnd}.
	 * @param ctx the parse tree
	 */
	void exitTagEnd(JinjaHtmlParser.TagEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(JinjaHtmlParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(JinjaHtmlParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(JinjaHtmlParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(JinjaHtmlParser.HtmlContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterHtmlAttribute(JinjaHtmlParser.HtmlAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitHtmlAttribute(JinjaHtmlParser.HtmlAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void enterHtmlChardata(JinjaHtmlParser.HtmlChardataContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlChardata}.
	 * @param ctx the parse tree
	 */
	void exitHtmlChardata(JinjaHtmlParser.HtmlChardataContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void enterHtmlMisc(JinjaHtmlParser.HtmlMiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlMisc}.
	 * @param ctx the parse tree
	 */
	void exitHtmlMisc(JinjaHtmlParser.HtmlMiscContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void enterHtmlComment(JinjaHtmlParser.HtmlCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#htmlComment}.
	 * @param ctx the parse tree
	 */
	void exitHtmlComment(JinjaHtmlParser.HtmlCommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(JinjaHtmlParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(JinjaHtmlParser.ScriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(JinjaHtmlParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(JinjaHtmlParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(JinjaHtmlParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(JinjaHtmlParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#jinja_var}.
	 * @param ctx the parse tree
	 */
	void enterJinja_var(JinjaHtmlParser.Jinja_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#jinja_var}.
	 * @param ctx the parse tree
	 */
	void exitJinja_var(JinjaHtmlParser.Jinja_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#jinja_stmt}.
	 * @param ctx the parse tree
	 */
	void enterJinja_stmt(JinjaHtmlParser.Jinja_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#jinja_stmt}.
	 * @param ctx the parse tree
	 */
	void exitJinja_stmt(JinjaHtmlParser.Jinja_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(JinjaHtmlParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(JinjaHtmlParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(JinjaHtmlParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(JinjaHtmlParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#set_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSet_stmt(JinjaHtmlParser.Set_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#set_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSet_stmt(JinjaHtmlParser.Set_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JinjaHtmlParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JinjaHtmlParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(JinjaHtmlParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(JinjaHtmlParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(JinjaHtmlParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(JinjaHtmlParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#not_expr}.
	 * @param ctx the parse tree
	 */
	void enterNot_expr(JinjaHtmlParser.Not_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#not_expr}.
	 * @param ctx the parse tree
	 */
	void exitNot_expr(JinjaHtmlParser.Not_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#compare_expr}.
	 * @param ctx the parse tree
	 */
	void enterCompare_expr(JinjaHtmlParser.Compare_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#compare_expr}.
	 * @param ctx the parse tree
	 */
	void exitCompare_expr(JinjaHtmlParser.Compare_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#add_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expr(JinjaHtmlParser.Add_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#add_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expr(JinjaHtmlParser.Add_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#mul_expr}.
	 * @param ctx the parse tree
	 */
	void enterMul_expr(JinjaHtmlParser.Mul_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#mul_expr}.
	 * @param ctx the parse tree
	 */
	void exitMul_expr(JinjaHtmlParser.Mul_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(JinjaHtmlParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(JinjaHtmlParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(JinjaHtmlParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(JinjaHtmlParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(JinjaHtmlParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(JinjaHtmlParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#access}.
	 * @param ctx the parse tree
	 */
	void enterAccess(JinjaHtmlParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#access}.
	 * @param ctx the parse tree
	 */
	void exitAccess(JinjaHtmlParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JinjaHtmlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JinjaHtmlParser.LiteralContext ctx);
}