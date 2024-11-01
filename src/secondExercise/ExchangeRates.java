package secondExercise;

import java.util.HashMap;
import java.util.Map;


public class ExchangeRates {
    private final Map<Currency, Map<Currency, Double>> rates;

    public ExchangeRates() {
        this.rates = new HashMap<>();
        for (Currency currency : Currency.values()) {
            rates.put(currency, new HashMap<>());
        }
    }

    public void setRate(Currency from, Currency to, double rate) {
        rates.get(from).put(to, rate);
        
        rates.get(to).put(from, 1.0 / rate);
    }

    public double getRate(Currency from, Currency to) {
        return rates.get(from).get(to);
    }

    public void initializeDefaultRates() {
        
        setRate(Currency.USD, Currency.EUR, 0.92);
        setRate(Currency.USD, Currency.GBP, 0.77);
        setRate(Currency.USD, Currency.JPY, 152.5);
        setRate(Currency.USD, Currency.RUB, 97.1);

       
        setRate(Currency.EUR, Currency.GBP, 0.84);
        setRate(Currency.EUR, Currency.JPY, 165.7);
        setRate(Currency.EUR, Currency.RUB, 105.6);
        setRate(Currency.GBP, Currency.JPY, 197.2);
        setRate(Currency.GBP, Currency.RUB, 125.7);
        setRate(Currency.JPY, Currency.RUB, 0.64);
    }
}