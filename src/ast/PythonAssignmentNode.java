package compilerProject.src.ast;

public class PythonAssignmentNode extends PythonNode {
    private String variableName;
    private String value;

    public PythonAssignmentNode(int lineNumber, String variableName, String value) {
        super("Assignment", lineNumber);
        this.variableName = variableName;
        this.value = value;
    }

    public String getVariableName() { return variableName; }
    public String getValue() { return value; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"type\": \"PythonAssignment\", \"line\": %d, \"variable\": \"%s\", \"value\": \"%s\"}",
                lineNumber, variableName, value
        );
    }
}