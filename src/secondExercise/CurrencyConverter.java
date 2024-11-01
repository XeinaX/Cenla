package secondExercise;


public class CurrencyConverter {
    private final ExchangeRates exchangeRates;

    public CurrencyConverter(ExchangeRates exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double convert(Currency from, Currency to, double amount) {
        double rate = exchangeRates.getRate(from, to);
        return Math.round(amount * rate * 100.0) / 100.0; 
    }

    public void displayAllConversions(Currency from, double amount) {
        System.out.printf("\nКонвертация %.2f %s (%s):%n", amount, from.getName(), from.getSymbol());
        System.out.println("----------------------------------------");

        for (Currency to : Currency.values()) {
            if (to != from) {
                double converted = convert(from, to, amount);
                System.out.printf("%s (%s): %.2f%n", to.getName(), to.getSymbol(), converted);
            }
        }
        System.out.println("----------------------------------------");
    }
}