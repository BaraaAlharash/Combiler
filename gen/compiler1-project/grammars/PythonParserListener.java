// Generated from C:/Users/ASUS/Desktop/compiler1-project/compiler1-project/grammars/PythonParser.g4 by ANTLR 4.13.2
package compiler1-project.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PythonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PythonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimple_statement(PythonParser.Simple_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimple_statement(PythonParser.Simple_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(PythonParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(PythonParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(PythonParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(PythonParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PythonParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PythonParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void enterOr_test(PythonParser.Or_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#or_test}.
	 * @param ctx the parse tree
	 */
	void exitOr_test(PythonParser.Or_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void enterAnd_test(PythonParser.And_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#and_test}.
	 * @param ctx the parse tree
	 */
	void exitAnd_test(PythonParser.And_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void enterNot_test(PythonParser.Not_testContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#not_test}.
	 * @param ctx the parse tree
	 */
	void exitNot_test(PythonParser.Not_testContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PythonParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#arith}.
	 * @param ctx the parse tree
	 */
	void enterArith(PythonParser.ArithContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#arith}.
	 * @param ctx the parse tree
	 */
	void exitArith(PythonParser.ArithContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PythonParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PythonParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(PythonParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(PythonParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(PythonParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(PythonParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint_stmt(PythonParser.Print_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#print_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint_stmt(PythonParser.Print_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PythonParser.AssignmentContext ctx);
}