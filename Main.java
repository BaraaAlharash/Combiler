package compilerProject;

import compilerProject.src.builder.ASTBuilder;
import compilerProject.src.visitors.*;
import compilerProject.src.ast.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n=== Print AST Tree ===");
        try {
            ASTNode ast = buildSimpleAST();

            if (ast == null) {
                System.out.println("❌ The Ast is not built");
                return;
            }

            System.out.println("\n--- Method 1: Direct printing ---");
            ast.print();

            System.out.println("\n==============================================================================");

            System.out.println("\n--- Method 2: Using PrintVisitor ---");
            PrintVisitor printer = new PrintVisitor();
            ast.accept(printer);

            System.out.println("\n==============================================================================");

            System.out.println("\n--- Ast info : ---");
            printTreeInfo(ast);

        } catch (Exception e) {
            System.out.println("❌ Error : " + e.getMessage());
            e.printStackTrace();
        }
    }







    private static ASTNode buildSimpleAST() {
        ASTBuilder builder = new ASTBuilder();

        try {
            builder.setCurrentLine(1);
            builder.createPythonFunction("main", java.util.Arrays.asList());

            builder.setCurrentLine(2);
            builder.createPythonAssignment("name", "'Baraa'");
            builder.createPythonAssignment("name", "'Omar'");


            builder.setCurrentLine(3);
            HTMLElementNode div = builder.createHTMLElement("div");
            HTMLElementNode h1 = builder.createHTMLElement("h1");
            builder.createHTMLText("Hello ");
            builder.createJinja2Variable("name");
            builder.endNode(); // div

            builder.setCurrentLine(4);
            builder.createCSSRule(".my-class");
            builder.createCSSDeclaration("color", "red");
            builder.endNode(); // CSS rule

            builder.endNode(); // function

            return builder.getAST();

        } catch (Exception e) {
            System.out.println("There is an error in the tree structure. " + e.getMessage());
            return null;
        }
    }


    private static void printTreeInfo(ASTNode node) {
        System.out.println("• Root Node: " + node.getNodeName());
        System.out.println("• Row is: " + node.getLineNumber());
        System.out.println("• children number: " + node.getChildren().size());
        System.out.println("• Total number of nodes: " + countNodes(node));
        System.out.println("• Depth is: " + calculateDepth(node));
    }

    private static int countNodes(ASTNode node) {
        int count = 1;
        for (ASTNode child : node.getChildren()) {
            count += countNodes(child);
        }
        return count;
    }

    private static int calculateDepth(ASTNode node) {
        if (node.getChildren().isEmpty()) {
            return 1;
        }

        int maxDepth = 0;
        for (ASTNode child : node.getChildren()) {
            maxDepth = Math.max(maxDepth, calculateDepth(child));
        }
        return maxDepth + 1;
    }
}