package secondExercise;

import java.util.Scanner;


public class UserInterface {
    private final Scanner scanner;
    private final CurrencyConverter converter;

    public UserInterface(CurrencyConverter converter) {
        this.scanner = new Scanner(System.in);
        this.converter = converter;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            
            if (choice == 0) {
                System.out.println("Программа завершена.");
                break;
            }

            processConversion();
        }
    }

    private void displayMenu() {
        System.out.println("\nКонвертер валют");
        System.out.println("1. Выполнить конвертацию");
        System.out.println("0. Выход");
    }

    private int getUserChoice() {
        System.out.print("Выберите действие: ");
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 1) {
                    return choice;
                }
                System.out.print("Некорректный выбор. Попробуйте снова: ");
            } catch (NumberFormatException e) {
                System.out.print("Некорректный ввод. Введите число: ");
            }
        }
    }

    private void processConversion() {
 
        System.out.println("\nДоступные валюты:");
        for (int i = 0; i < Currency.values().length; i++) {
            Currency currency = Currency.values()[i];
            System.out.printf("%d. %s (%s)%n", i + 1, currency.getName(), currency.getSymbol());
        }

        Currency fromCurrency = selectCurrency("Выберите исходную валюту: ");
        double amount = getAmount();

        converter.displayAllConversions(fromCurrency, amount);
    }

    private Currency selectCurrency(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= Currency.values().length) {
                    return Currency.values()[choice - 1];
                }
                System.out.println("Некорректный выбор валюты.");
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число.");
            }
        }
    }

    private double getAmount() {
        while (true) {
            System.out.print("Введите сумму: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    return amount;
                }
                System.out.println("Сумма должна быть положительной.");
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
    }
}