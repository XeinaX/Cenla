package firstExercise;

import java.util.*;

public class Game {
    private final WordBank wordBank;
    private final HangmanState state;
    private final int maxLives = 6;

    public Game() {
        this.wordBank = new WordBank();
        this.state = new HangmanState(wordBank.getRandomWord(), maxLives);
    }

    public void play() {
        System.out.println("Добро пожаловать в игру Виселица!");
        Scanner scanner = new Scanner(System.in);

        while (!state.isGameOver()) {
            displayGameState();
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();
            
            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите только одну букву!");
                continue;
            }

            char letter = input.charAt(0);
            
            if (state.isLetterGuessed(letter)) {
                System.out.println("Вы уже вводили букву '" + letter + "'! Попробуйте другую.");
                continue;
            }

            boolean isCorrectGuess = state.guess(letter);
            
            if (!isCorrectGuess) {
                System.out.println("Неверно! Вы теряете жизнь!");
            } else {
                System.out.println("Правильно! Такая буква есть в слове.");
            }
        }

        displayGameResult();
    }

    private void displayGameState() {
        System.out.println("\nСлово: " + state.getDisplayWord());
        System.out.println("Осталось жизней: " + state.getLives());
        System.out.println("Использованные буквы: " + state.getGuessedLettersDisplay());
        displayHangman(state.getLives());
    }

    private void displayGameResult() {
        if (state.isWon()) {
            System.out.println("\nПоздравляем! Вы выиграли!");
            System.out.println("Загаданное слово: " + state.getWord());
        } else {
            System.out.println("\nИгра окончена! Вы проиграли!");
            System.out.println("Загаданное слово было: " + state.getWord());
        }
    }

    private void displayHangman(int lives) {
        String[] hangmanStates = {
            """
                +---+
                |   O
                |  /|\\
                |  / \\
                |
            =========
            """,
            """
                +---+
                |   O
                |  /|\\
                |  /
                |
            =========
            """,
            """
                +---+
                |   O
                |  /|\\
                |
                |
            =========
            """,
            """
                +---+
                |   O
                |  /|
                |
                |
            =========
            """,
            """
                +---+
                |   O
                |   |
                |
                |
            =========
            """,
            """
                +---+
                |   O
                |
                |
                |
            =========
            """,
            """
                +---+
                |
                |
                |
                |
            =========
            """
        };
        System.out.println(hangmanStates[lives]);
    }
}