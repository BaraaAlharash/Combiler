package compilerProject.src.ast;

public class CSSDeclarationNode extends CSSNode {
    private String property;
    private String value;

    public CSSDeclarationNode(int lineNumber, String property, String value) {
        super("CSSDeclaration", lineNumber);
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"type\": \"CSSDeclaration\", \"line\": %d, \"property\": \"%s\", \"value\": \"%s\"}",
                lineNumber, property, value
        );
    }
}
