package compilerProject.src.visitors;

import compilerProject.src.ast.*;
import java.util.ArrayList;
import java.util.List;

public class ValidatorVisitor implements Visitor<List<String>> {
    private List<String> errors = new ArrayList<>();

    @Override
    public List<String> visit(PythonNode node) {

        if (node.getLineNumber() <= 0) {
            errors.add("PythonNode at " + node.getNodeName() + " has invalid line number");
        }

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return errors;
    }

    @Override
    public List<String> visit(Jinja2Node node) {
        if (node.getLineNumber() <= 0) {
            errors.add("Jinja2Node at " + node.getNodeName() + " has invalid line number");
        }

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return errors;
    }

    @Override
    public List<String> visit(HTMLNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("HTMLNode at " + node.getNodeName() + " has invalid line number");
        }

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return errors;
    }

    @Override
    public List<String> visit(CSSNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("CSSNode at " + node.getNodeName() + " has invalid line number");
        }

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return errors;
    }

    @Override
    public List<String> visit(PythonAssignmentNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("PythonAssignmentNode has invalid line number");
        }
        if (node.getVariableName() == null || node.getVariableName().isEmpty()) {
            errors.add("PythonAssignmentNode has empty variable name at line " + node.getLineNumber());
        }
        if (node.getValue() == null || node.getValue().isEmpty()) {
            errors.add("PythonAssignmentNode has empty value at line " + node.getLineNumber());
        }
        return errors;
    }

    @Override
    public List<String> visit(PythonFunctionNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("PythonFunctionNode has invalid line number");
        }
        if (node.getFunctionName() == null || node.getFunctionName().isEmpty()) {
            errors.add("PythonFunctionNode has empty function name at line " + node.getLineNumber());
        }

        for (ASTNode stmt : node.getBody()) {
            stmt.accept(this);
        }

        return errors;
    }

    @Override
    public List<String> visit(Jinja2VariableNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("Jinja2VariableNode has invalid line number");
        }
        if (node.getVariableName() == null || node.getVariableName().isEmpty()) {
            errors.add("Jinja2VariableNode has empty variable name at line " + node.getLineNumber());
        }
        return errors;
    }

    @Override
    public List<String> visit(Jinja2ForNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("Jinja2ForNode has invalid line number");
        }
        if (node.getItemVariable() == null || node.getItemVariable().isEmpty()) {
            errors.add("Jinja2ForNode has empty item variable at line " + node.getLineNumber());
        }
        if (node.getIterable() == null || node.getIterable().isEmpty()) {errors.add("Jinja2ForNode has empty iterable at line " + node.getLineNumber());
        }

        for (ASTNode child : node.getLoopBody()) {
            child.accept(this);
        }

        return errors;
    }

    @Override
    public List<String> visit(HTMLElementNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("HTMLElementNode has invalid line number");
        }
        if (node.getTagName() == null || node.getTagName().isEmpty()) {
            errors.add("HTMLElementNode has empty tag name at line " + node.getLineNumber());
        }

        for (Object content : node.getContent()) {
            if (content instanceof ASTNode) {
                ((ASTNode) content).accept(this);
            }
        }

        return errors;
    }

    @Override
    public List<String> visit(CSSRuleNode node) {
        if (node.getLineNumber() <= 0) {
            errors.add("CSSRuleNode has invalid line number");
        }
        if (node.getSelector() == null || node.getSelector().isEmpty()) {
            errors.add("CSSRuleNode has empty selector at line " + node.getLineNumber());
        }

        for (CSSDeclarationNode decl : node.getDeclarations()) {
            decl.accept(this);
        }

        return errors;
    }


//    @Override
//    public List<String> visit(CSSDeclarationNode node) {
//        if (node.getLineNumber() <= 0) {
//            errors.add("CSSDeclarationNode has invalid line number");
//        }
//        if (node.getProperty() == null || node.getProperty().isEmpty()) {
//            errors.add("CSSDeclarationNode has empty property at line " + node.getLineNumber());
//        }
//        if (node.getValue() == null || node.getValue().isEmpty()) {
//            errors.add("CSSDeclarationNode has empty value at line " + node.getLineNumber());
//        }
//        return errors;
//    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}