package compilerProject.src.visitors;

import compilerProject.src.ast.*;
import compilerProject.src.symbols.*;

import java.util.List;

public class SymbolTableVisitor implements Visitor<Void> {

    private final SymbolTable table = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return table;
    }

    private void visitChildren(ASTNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public Void visit(PythonNode node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(Jinja2Node node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(HTMLNode node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(CSSNode node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(PythonAssignmentNode node) {
        boolean ok = table.define(node.getVariableName(), SymbolKind.VARIABLE, node.getLineNumber());
        if (!ok) {
            System.out.println("⚠️ Duplicate variable in same scope: " + node.getVariableName()
                    + " (line " + node.getLineNumber() + ")");
        }
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(PythonFunctionNode node) {
        boolean ok = table.define(node.getFunctionName(), SymbolKind.FUNCTION, node.getLineNumber());
        if (!ok) {
            System.out.println("⚠️ Duplicate function in same scope: " + node.getFunctionName()
                    + " (line " + node.getLineNumber() + ")");
        }

        table.enterScope("func:" + node.getFunctionName());

        List<String> params = node.getParameters();
        if (params != null) {
            for (String p : params) {
                boolean okParam = table.define(p, SymbolKind.PARAMETER, node.getLineNumber());
                if (!okParam) {
                    System.out.println("⚠️ Duplicate parameter: " + p + " in " + node.getFunctionName());
                }
            }
        }

        visitChildren(node);

        System.out.println("\n--- Scope symbols: func:" + node.getFunctionName() + " ---");
        for (Symbol s : table.getCurrentScope().getAllSymbols()) {
            System.out.println("  " + s);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(Jinja2VariableNode node) {
        table.define(node.getVariableName(), SymbolKind.JINJA_VARIABLE, node.getLineNumber());
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(Jinja2ForNode node) {
        table.enterScope("jinja_for");

        table.define(node.getItemVariable(), SymbolKind.LOOP_VARIABLE, node.getLineNumber());
        table.define(node.getIterable(), SymbolKind.JINJA_VARIABLE, node.getLineNumber());

        visitChildren(node);

        System.out.println("\n--- Scope symbols: jinja_for ---");
        for (Symbol s : table.getCurrentScope().getAllSymbols()) {
            System.out.println("  " + s);
        }

        table.exitScope();
        return null;
    }

    @Override
    public Void visit(HTMLElementNode node) {
        visitChildren(node);
        return null;
    }

    @Override
    public Void visit(CSSRuleNode node) {
        visitChildren(node);
        return null;
    }
}
