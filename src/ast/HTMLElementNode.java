package compilerProject.src.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class HTMLElementNode extends HTMLNode {
    private String tagName;
    private Map<String, String> attributes;
    private List<Object> content;

    public HTMLElementNode(int lineNumber, String tagName) {
        super("HTMLElement:" + tagName, lineNumber);
        this.tagName = tagName;
        this.attributes = new HashMap<>();
        this.content = new ArrayList<>();
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public void addContent(Object contentItem) {
        if (contentItem instanceof ASTNode) {
            ((ASTNode) contentItem).setParent(this);
        }
        content.add(contentItem);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{")
                .append("\"type\": \"HTMLElement\", ")
                .append("\"line\": ").append(lineNumber).append(", ")
                .append("\"tag\": \"").append(tagName).append("\", ")
                .append("\"attributes\": {");

        int attrCount = 0;
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            if (attrCount++ > 0) json.append(", ");
            json.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\"");
        }
        json.append("}, \"content\": [");

        for (int i = 0; i < content.size(); i++) {
            if (i > 0) json.append(", ");
            Object item = content.get(i);
            if (item instanceof ASTNode) {
                json.append(((ASTNode) item).toJSON());
            } else {
                json.append("{\"type\": \"text\", \"value\": \"")
                        .append(item.toString().replace("\"", "\\\""))
                        .append("\"}");
            }
        }
        json.append("]}");
        return json.toString();
    }
}