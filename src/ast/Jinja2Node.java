package compilerProject.src.ast;

public class Jinja2Node extends ASTNode {
    public Jinja2Node(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"type\": \"Jinja2Node\", \"nodeName\": \"%s\", \"line\": %d}",
                nodeName, lineNumber
        );
    }
}