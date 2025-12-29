package compilerProject.src.symbols;

import java.util.*;

public class Scope {
    private final String name;
    private final Scope parent;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();

    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() { return name; }
    public Scope getParent() { return parent; }

    public boolean define(Symbol symbol) {
        if (symbols.containsKey(symbol.getName())) return false;
        symbols.put(symbol.getName(), symbol);
        return true;
    }

    public Symbol resolve(String name) {
        if (symbols.containsKey(name)) return symbols.get(name);
        return parent != null ? parent.resolve(name) : null;
    }

    public Collection<Symbol> getAllSymbols() {
        return symbols.values();
    }
}
