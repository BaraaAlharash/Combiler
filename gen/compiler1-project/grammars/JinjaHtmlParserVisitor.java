// Generated from C:/Users/ASUS/Desktop/compiler1-project/compiler1-project/grammars/JinjaHtmlParser.g4 by ANTLR 4.13.2
package compiler1-project.grammars;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JinjaHtmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JinjaHtmlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(JinjaHtmlParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#scriptletOrSeaWs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScriptletOrSeaWs(JinjaHtmlParser.ScriptletOrSeaWsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElements(JinjaHtmlParser.HtmlElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(JinjaHtmlParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#tagEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagEnd(JinjaHtmlParser.TagEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(JinjaHtmlParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContent(JinjaHtmlParser.HtmlContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlAttribute(JinjaHtmlParser.HtmlAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlChardata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlChardata(JinjaHtmlParser.HtmlChardataContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlMisc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlMisc(JinjaHtmlParser.HtmlMiscContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#htmlComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlComment(JinjaHtmlParser.HtmlCommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#script}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript(JinjaHtmlParser.ScriptContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(JinjaHtmlParser.StyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(JinjaHtmlParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#jinja_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja_var(JinjaHtmlParser.Jinja_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#jinja_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinja_stmt(JinjaHtmlParser.Jinja_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(JinjaHtmlParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(JinjaHtmlParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#set_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_stmt(JinjaHtmlParser.Set_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JinjaHtmlParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(JinjaHtmlParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(JinjaHtmlParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#not_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot_expr(JinjaHtmlParser.Not_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#compare_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_expr(JinjaHtmlParser.Compare_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#add_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expr(JinjaHtmlParser.Add_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#mul_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_expr(JinjaHtmlParser.Mul_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(JinjaHtmlParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(JinjaHtmlParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(JinjaHtmlParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(JinjaHtmlParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JinjaHtmlParser.LiteralContext ctx);
}