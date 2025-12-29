package compilerProject.src.symbols;

import java.util.*;

public class SymbolTable {
    private final Scope globalScope = new Scope("global", null);
    private Scope currentScope = globalScope;

    public Scope getCurrentScope() { return currentScope; }
    public Scope getGlobalScope() { return globalScope; }

    public void enterScope(String name) {
        currentScope = new Scope(name, currentScope);
    }

    public void exitScope() {
        if (currentScope.getParent() != null) {
            currentScope = currentScope.getParent();
        }
    }

    public boolean define(String name, SymbolKind kind, int line) {
        Symbol s = new Symbol(name, kind, currentScope.getName(), line);
        return currentScope.define(s);
    }
}
