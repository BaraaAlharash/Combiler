package compilerProject.src.ast;

import java.util.ArrayList;
import java.util.List;

public class PythonIfNode extends PythonNode {
    private String condition;
    private List<ASTNode> trueBody;
    private List<ASTNode> falseBody;

    public PythonIfNode(int lineNumber, String condition) {
        super("IfStatement", lineNumber);
        this.condition = condition;
        this.trueBody = new ArrayList<>();
        this.falseBody = new ArrayList<>();
    }
    public void addToTrueBody(ASTNode node) { trueBody.add(node); }
    public void addToFalseBody(ASTNode node) { falseBody.add(node); }

    @Override
    public <T> T accept(Visitor<T> visitor) {

        return visitor.visit(this);
    }

}
