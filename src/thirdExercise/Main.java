package thirdExercise;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        
        
        while (true) {
            System.out.print("Введите длину пароля (от 8 до 12 символов): ");
            length = scanner.nextInt();

            if (length >= 8 && length <= 12) {
                break; 
            } else {
                System.out.println("Неверная длина. Пожалуйста, введите длину от 8 до 12 символов.");
            }
        }
        

        String password = generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        
        return password.toString();
    }
}
