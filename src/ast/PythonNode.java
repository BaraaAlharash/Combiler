package compilerProject.src.ast;

public class PythonNode extends ASTNode {
    public PythonNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"type\": \"PythonNode\", ")
                .append("\"nodeName\": \"").append(nodeName).append("\", ")
                .append("\"lineNumber\": ").append(lineNumber);

        if (!children.isEmpty()) {
json.append(", \"children\": [");
            for (int i = 0; i < children.size(); i++) {
        if (i > 0) json.append(", ");
                json.append(children.get(i).toJSON());
        }
        json.append("]");
        }
                json.append("}");
        return json.toString();
    }
            }