package compilerProject.src.ast;


public interface Visitor<T> {
    T visit(PythonNode node);
    T visit(Jinja2Node node);
    T visit(HTMLNode node);
    T visit(CSSNode node);

    T visit(PythonAssignmentNode node);
    T visit(PythonFunctionNode node);

    T visit(Jinja2VariableNode node);
    T visit(Jinja2ForNode node);

    T visit(HTMLElementNode node);
    T visit(CSSRuleNode node);
}
