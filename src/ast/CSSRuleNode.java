package compilerProject.src.ast;

import java.util.List;
import java.util.ArrayList;

public class CSSRuleNode extends CSSNode {
    private String selector;
    private List<CSSDeclarationNode> declarations;

    public CSSRuleNode(int lineNumber, String selector) {
        super("CSSRule", lineNumber);
        this.selector = selector;
        this.declarations = new ArrayList<>();
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public List<CSSDeclarationNode> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<CSSDeclarationNode> declarations) {
        this.declarations = declarations;
    }

    public void addDeclaration(CSSDeclarationNode declaration) {
        declarations.add(declaration);
        declaration.setParent(this);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"type\": \"CSSRule\", ")
                .append("\"line\": ").append(lineNumber).append(", ")
                .append("\"selector\": \"").append(selector).append("\", ")
                .append("\"declarations\": [");

        for (int i = 0; i < declarations.size(); i++) {
            if (i > 0) json.append(", ");
            json.append(declarations.get(i).toJSON());
        }
        json.append("]}");
        return json.toString();
    }
}
