package compilerProject.src.ast;

import java.util.*;

public class PythonFunctionNode extends PythonNode {
    private String functionName;
    private List<String> parameters;
    private List<ASTNode> body;

    public String getFunctionName() {
        return functionName;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public List<ASTNode> getBody() {
        return body;
    }

    public PythonFunctionNode(int lineNumber, String functionName, List<String> parameters) {
        super("FunctionDef", lineNumber);
        this.functionName = functionName;
        this.parameters = parameters != null ? parameters : new ArrayList<>();
        this.body = new ArrayList<>();
    }

    public void addToBody(ASTNode node) {
        body.add(node);
        node.setParent(this);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"type\": \"PythonFunction\", ")
                .append("\"line\": ").append(lineNumber).append(", ")
                .append("\"name\": \"").append(functionName).append("\", ")
                .append("\"parameters\": [");

        for (int i = 0; i < parameters.size(); i++) {
            if (i > 0) json.append(", ");
            json.append("\"").append(parameters.get(i)).append("\"");
        }
        json.append("], \"body\": [");

        for (int i = 0; i < body.size(); i++) {
            if (i > 0) json.append(", ");
            json.append(body.get(i).toJSON());
        }
        json.append("]}");
        return json.toString();
    }
}