package secondExercise;


public enum Currency {
    USD("Доллар США", "$"),
    EUR("Евро", "€"),
    GBP("Британский фунт", "£"),
    JPY("Японская иена", "¥"),
    RUB("Российский рубль", "₽");

    private final String name;
    private final String symbol;

    Currency(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}