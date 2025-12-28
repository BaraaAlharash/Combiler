package compilerProject.src.ast;

public abstract class CSSNode extends ASTNode {
    public CSSNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
