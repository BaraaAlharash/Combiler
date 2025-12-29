package compilerProject.src.symbols;

public class Symbol {
    private final String name;
    private final SymbolKind kind;
    private final String scopeName;
    private final int line;

    public Symbol(String name, SymbolKind kind, String scopeName, int line) {
        this.name = name;
        this.kind = kind;
        this.scopeName = scopeName;
        this.line = line;
    }

    public String getName() { return name; }
    public int getLine() { return line; }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-20s line=%d", name, kind, scopeName, line);
    }
}
