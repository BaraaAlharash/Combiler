package compilerProject.src.ast;

public class HTMLTextNode extends HTMLNode {
    private String text;

    public HTMLTextNode(int lineNumber, String text) {
        super("HTMLText", lineNumber);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        return String.format(
                "{\"type\": \"HTMLText\", \"line\": %d, \"text\": \"%s\"}",
                lineNumber, text.replace("\"", "\\\"")
        );
    }
}
