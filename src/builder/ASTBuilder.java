package compilerProject.src.builder;
import compilerProject.src.ast.*;
import compilerProject.src.ast.ASTNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ASTBuilder {
    private ASTNode root;
    private ASTNode currentNode;
    private Stack<ASTNode> nodeStack;
    private int currentLine;

    public ASTBuilder() {
        this.nodeStack = new Stack<>();
        this.currentLine = 1;
    }

    public void setCurrentLine(int line) {
        this.currentLine = line;
    }

    public void incrementLine() {
        this.currentLine++;
    }

    public void startNode(ASTNode node) {
        if (root == null) {
            root = node;
        } else if (currentNode != null) {
            currentNode.addChild(node);
        }

        nodeStack.push(node);
        currentNode = node;
    }

    public void endNode() {
        if (!nodeStack.isEmpty()) {
            nodeStack.pop();
            currentNode = nodeStack.isEmpty() ? null : nodeStack.peek();
        }
    }

    public PythonAssignmentNode createPythonAssignment(String varName, String value) {
        PythonAssignmentNode node = new PythonAssignmentNode(currentLine, varName, value);
        addNode(node);
        return node;
    }

    public PythonFunctionNode createPythonFunction(String funcName, java.util.List<String> params) {
        PythonFunctionNode node = new PythonFunctionNode(currentLine, funcName, params);
        startNode(node);
        return node;
    }

    public Jinja2VariableNode createJinja2Variable(String varName) {
        Jinja2VariableNode node = new Jinja2VariableNode(currentLine, varName);
        addNode(node);
        return node;
    }

    public Jinja2ForNode createJinja2ForLoop(String itemVar, String iterable) {
        Jinja2ForNode node = new Jinja2ForNode(currentLine, itemVar, iterable);
        startNode(node);
        return node;
    }

    public HTMLElementNode createHTMLElement(String tagName) {
        HTMLElementNode node = new HTMLElementNode(currentLine, tagName);
        startNode(node);
        return node;
    }

    public HTMLTextNode createHTMLText(String text) {
        HTMLTextNode node = new HTMLTextNode(currentLine, text);
        addNode(node);
        return node;
    }

    public CSSRuleNode createCSSRule(String selector) {
        CSSRuleNode node = new CSSRuleNode(currentLine, selector);
        startNode(node);
        return node;
    }

    public CSSDeclarationNode createCSSDeclaration(String property, String value) {
        CSSDeclarationNode node = new CSSDeclarationNode(currentLine, property, value);
        addNode(node);
        return node;
    }

    private void addNode(ASTNode node) {
        if (currentNode != null) {
            currentNode.addChild(node);
        } else {
            root = node;
        }
    }

    public ASTNode getAST() {
        return root;
    }


    public void printAST() {
        if (root != null) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("ABSTRACT SYNTAX TREE (AST)");
            System.out.println("=".repeat(60));
            root.printTree(0);
            System.out.println("=".repeat(60));
        } else {
            System.out.println("AST is empty!");
        }
    }

    public void saveASTToFile(String filename) {
        if (root == null) {
            System.out.println("No AST to save!");
            return;
        }

        try (FileWriter writer = new FileWriter(filename)) {

            StringBuilder json = new StringBuilder();
            json.append("{\n  \"ast\": {\n");
            json.append("    \"root\": ").append(root.toJSON()).append("\n");
            json.append("  },\n  \"metadata\": {\n");
            json.append("    \"totalNodes\": ").append(countNodes(root)).append(",\n");
            json.append("    \"maxDepth\": ").append(calculateDepth(root)).append("\n");
            json.append("  }\n}");

            writer.write(json.toString());
            System.out.println("AST saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving AST: " + e.getMessage());
        }
    }

    private int countNodes(ASTNode node) {
        int count = 1;
        for (ASTNode child : node.getChildren()) {
            count += countNodes(child);
        }
        return count;
    }

    private int calculateDepth(ASTNode node) {
        if (node.getChildren().isEmpty()) {
            return 1;
        }

        int maxDepth = 0;
        for (ASTNode child : node.getChildren()) {
            maxDepth = Math.max(maxDepth, calculateDepth(child));
        }
        return maxDepth + 1;
    }

    // Store - Visitor
    public void saveWithVisitor(String filename) {
        SaveVisitor visitor = new SaveVisitor(filename);
        if (root != null) {
            root.accept(visitor);
        }
    }

    // Save Visitor
    private class SaveVisitor implements Visitor<Void> {
        private String filename;

        public SaveVisitor(String filename) {
            this.filename = filename;
        }

        @Override
        public Void visit(PythonNode node) {
            return null;
        }

        @Override
        public Void visit(Jinja2Node node) {
            return null;
        }

        @Override
        public Void visit(HTMLNode node) {
            return null;
        }

        @Override
        public Void visit(CSSNode node) {
            return null;
        }

        @Override
        public Void visit(PythonAssignmentNode node) {
            return null;
        }

        @Override
        public Void visit(PythonFunctionNode node) {
            return null;
        }

        @Override
        public Void visit(Jinja2VariableNode node) {
            return null;
        }

        @Override
        public Void visit(Jinja2ForNode node) {
            return null;
        }

        @Override
        public Void visit(HTMLElementNode node) {
            return null;
        }

        @Override
        public Void visit(CSSRuleNode node) {
            return null;
        }
    }
}
