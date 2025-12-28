package compilerProject.src.visitors;

import compilerProject.src.ast.*;
import java.util.Stack;


public class PrintVisitor implements Visitor<Void> {
    private Stack<Integer> indentStack = new Stack<>();

    public PrintVisitor() {
        indentStack.push(0);
    }

    private String getIndent() {
        return "  ".repeat(indentStack.peek());
    }

    private void increaseIndent() {
        indentStack.push(indentStack.peek() + 1);
    }

    private void decreaseIndent() {
        indentStack.pop();
    }

    @Override
    public Void visit(PythonNode node) {
        System.out.println(getIndent() + "🐍 Python: " + node.getNodeName() +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(Jinja2Node node) {
        System.out.println(getIndent() + "🌀 Jinja2: " + node.getNodeName() + " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(HTMLNode node) {
        System.out.println(getIndent() + "🌐 HTML: " + node.getNodeName() +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(CSSNode node) {
        System.out.println(getIndent() + "🎨 CSS: " + node.getNodeName() +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(PythonAssignmentNode node) {
        System.out.println(getIndent() + "📝 Assignment: " +
                node.getVariableName() + " = " + node.getValue() +
                " [Line: " + node.getLineNumber() + "]");
        return null;
    }

    @Override
    public Void visit(PythonFunctionNode node) {
        System.out.println(getIndent() + "🔧 Function: " + node.getFunctionName() +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(Jinja2VariableNode node) {
        System.out.println(getIndent() + "📊 Jinja2 Var: {{ " +
                node.getVariableName() + " }}" +
                " [Line: " + node.getLineNumber() + "]");
        return null;
    }

    @Override
    public Void visit(Jinja2ForNode node) {
        System.out.println(getIndent() + "🔄 Jinja2 For: {% for " +
                node.getItemVariable() + " in " + node.getIterable() + " %}" +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(HTMLElementNode node) {
        System.out.println(getIndent() + "🏷️ HTML Element: <" +
                node.getTagName() + ">" +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {child.accept(this);
        }
        decreaseIndent();
        return null;
    }

    @Override
    public Void visit(CSSRuleNode node) {
        System.out.println(getIndent() + "📐 CSS Rule: " + node.getSelector() +
                " [Line: " + node.getLineNumber() + "]");
        increaseIndent();
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        decreaseIndent();
        return null;
    }

//    @Override
//    public Void visit(CSSDeclarationNode node) {
//        System.out.println(getIndent() + "⚙️ CSS Property: " +
//                node.getProperty() + ": " + node.getValue() +
//                " [Line: " + node.getLineNumber() + "]");
//        return null;
//    }
}