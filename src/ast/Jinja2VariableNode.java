package compilerProject.src.ast;

public class Jinja2VariableNode extends Jinja2Node {
    private String variableName;

    public Jinja2VariableNode(int lineNumber, String variableName) {
        super("Jinja2Variable", lineNumber);
        this.variableName = variableName;
    }

    public String getVariableName() { return variableName; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"type\": \"Jinja2Variable\", \"line\": %d, \"variable\": \"%s\"}",
                lineNumber, variableName
        );
    }
}