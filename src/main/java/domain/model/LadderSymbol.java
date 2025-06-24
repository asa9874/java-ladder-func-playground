package domain.model;

public enum LadderSymbol {
    VERTICAL("|"),
    HORIZONTAL("-----"),
    EMPTY("     ");

    private final String symbol;

    LadderSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
