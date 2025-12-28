package compilerProject.src.ast;

public abstract class HTMLNode extends ASTNode {
    public HTMLNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}