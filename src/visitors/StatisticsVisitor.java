package compilerProject.src.visitors;
import compilerProject.src.ast.*;
import java.util.HashMap;
import java.util.Map;

public class StatisticsVisitor implements Visitor<Map<String, Object>> {
    private Map<String, Integer> nodeCounts = new HashMap<>();
    private Map<String, Integer> languageCounts = new HashMap<>();
    private int totalNodes = 0;
    private int maxDepth = 0;
    private int currentDepth = 0;

    @Override
    public Map<String, Object> visit(PythonNode node) {
        return processNode(node, "Python");
    }

    @Override
    public Map<String, Object> visit(Jinja2Node node) {
        return processNode(node, "Jinja2");
    }

    @Override
    public Map<String, Object> visit(HTMLNode node) {
        return processNode(node, "HTML");
    }

    @Override
    public Map<String, Object> visit(CSSNode node) {
        return processNode(node, "CSS");
    }

    @Override
    public Map<String, Object> visit(PythonAssignmentNode node) {
        return processNode(node, "Python");
    }

    @Override
    public Map<String, Object> visit(PythonFunctionNode node) {
        return processNode(node, "Python");
    }

    @Override
    public Map<String, Object> visit(Jinja2VariableNode node) {
        return processNode(node, "Jinja2");
    }

    @Override
    public Map<String, Object> visit(Jinja2ForNode node) {
        return processNode(node, "Jinja2");
    }

    @Override
    public Map<String, Object> visit(HTMLElementNode node) {
        return processNode(node, "HTML");
    }

    @Override
    public Map<String, Object> visit(CSSRuleNode node) {
        return processNode(node, "CSS");
    }

//    @Override
//    public Map<String, Object> visit(CSSDeclarationNode node) {
//        return processNode(node, "CSS");
//    }

    private Map<String, Object> processNode(ASTNode node, String language) {
        // update counters
        totalNodes++;
        currentDepth++;

        maxDepth = Math.max(maxDepth, currentDepth);

        String nodeType = node.getClass().getSimpleName();
        nodeCounts.put(nodeType, nodeCounts.getOrDefault(nodeType, 0) + 1);

        languageCounts.put(language, languageCounts.getOrDefault(language, 0) + 1);

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        currentDepth--;

        return getStatistics();
    }

    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalNodes", totalNodes);
        stats.put("maxDepth", maxDepth);
        stats.put("nodeCounts", new HashMap<>(nodeCounts));
        stats.put("languageCounts", new HashMap<>(languageCounts));

        // others statistics
        stats.put("averageChildren", calculateAverageChildren());
        stats.put("uniqueNodeTypes", nodeCounts.size());

        return stats;
    }

    private double calculateAverageChildren() {
        if (totalNodes == 0) return 0;
        int totalChildren = 0;
        for (int count : nodeCounts.values()) {
            totalChildren += count;
        }
        return (double) totalChildren / totalNodes;
    }

    public void printStatistics() {
        Map<String, Object> stats = getStatistics();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("📊 AST STATISTICS");
        System.out.println("=".repeat(50));

        System.out.println("📈 General Statistics:");
        System.out.println("  • Total Nodes: " + stats.get("totalNodes"));System.out.println("  • Max Depth: " + stats.get("maxDepth"));
        System.out.println("  • Unique Node Types: " + stats.get("uniqueNodeTypes"));
        System.out.println("  • Average Children per Node: " +
                String.format("%.2f", stats.get("averageChildren")));

        System.out.println("\n🌍 Language Distribution:");
        Map<String, Integer> langCounts = (Map<String, Integer>) stats.get("languageCounts");
        langCounts.forEach((lang, count) -> {
            double percentage = (count * 100.0) / totalNodes;
            System.out.printf("  • %-10s: %3d nodes (%5.1f%%)\n",
                    lang, count, percentage);
        });

        System.out.println("\n🔢 Node Type Counts:");
        Map<String, Integer> nodeCounts = (Map<String, Integer>) stats.get("nodeCounts");
        nodeCounts.forEach((type, count) -> {
            System.out.printf("  • %-25s: %3d\n", type, count);
        });

        System.out.println("=".repeat(50));
    }
}