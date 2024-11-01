package secondExercise;


public class Main {
    public static void main(String[] args) {
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.initializeDefaultRates();
        
        CurrencyConverter converter = new CurrencyConverter(exchangeRates);
        UserInterface ui = new UserInterface(converter);
        
        ui.start();
    }
}