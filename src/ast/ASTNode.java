package compilerProject.src.ast;

import java.util.ArrayList;
import java.util.List;

public abstract class ASTNode {
    protected String nodeName;
    protected int lineNumber;
    protected List<ASTNode> children;
    protected ASTNode parent;

    public ASTNode(String nodeName, int lineNumber) {
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    // Getters and Setters
    public String getNodeName() {
        return nodeName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public List<ASTNode> getChildren() {
        return children;
    }

    public ASTNode getParent() {
        return parent;
    }

    public void setParent(ASTNode parent) {
        this.parent = parent;
    }

    public void addChild(ASTNode child) {
        child.setParent(this);
        children.add(child);
    }

    public abstract <T> T accept(Visitor<T> visitor);

    public void printTree(int indent) {
        String indentation = "  ".repeat(indent);
        System.out.println(indentation + "└── " + nodeName + " (Line: " + lineNumber + ")");
        for (ASTNode child : children) {
            child.printTree(indent + 1);
        }
    }

    public void print() {
        print(0, "");
    }

    private void print(int depth, String prefix) {
        String currentPrefix = depth == 0 ? "" : prefix + "└── ";
        System.out.println(prefix + currentPrefix + nodeName + " ,[Line: " + lineNumber + "]");

        for (int i = 0; i < children.size(); i++) {
            String childPrefix = prefix + (depth == 0 ? "" : "    ");
            children.get(i).print(depth + 1, childPrefix);
        }
    }

    public abstract String toJSON();
}



