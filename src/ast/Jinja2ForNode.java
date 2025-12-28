package compilerProject.src.ast;

import java.util.ArrayList;
import java.util.List;

public class Jinja2ForNode extends Jinja2Node {
    private String itemVariable;
    private String iterable;
    private List<ASTNode> loopBody;

    public Jinja2ForNode(int lineNumber, String itemVariable, String iterable) {
        super("Jinja2ForLoop", lineNumber);
        this.itemVariable = itemVariable;
        this.iterable = iterable;
        this.loopBody = new ArrayList<>();
    }

    public String getItemVariable() {
        return itemVariable;
    }

    public void setItemVariable(String itemVariable) {
        this.itemVariable = itemVariable;
    }

    public String getIterable() {
        return iterable;
    }

    public void setIterable(String iterable) {
        this.iterable = iterable;
    }

    public List<ASTNode> getLoopBody() {
        return loopBody;
    }

    public void setLoopBody(List<ASTNode> loopBody) {
        this.loopBody = loopBody;
    }

    public void addToLoopBody(ASTNode node) {
        loopBody.add(node);
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
                .append("\"type\": \"Jinja2ForLoop\", ")
                .append("\"line\": ").append(lineNumber).append(", ")
                .append("\"item\": \"").append(itemVariable).append("\", ")
                .append("\"iterable\": \"").append(iterable).append("\", ")
                .append("\"body\": [");

        for (int i = 0; i < loopBody.size(); i++) {
            if (i > 0) json.append(", ");
            json.append(loopBody.get(i).toJSON());
        }
        json.append("]}");
        return json.toString();
    }
}
