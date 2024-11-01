package firstExercise;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HangmanState {
    private final String word;
    private final Set<Character> guessedLetters;
    private int lives;
    
    public HangmanState(String word, int lives) {
        this.word = word.toLowerCase();
        this.lives = lives;
        this.guessedLetters = new HashSet<>();
    }

    public boolean guess(char letter) {
        letter = Character.toLowerCase(letter);
        guessedLetters.add(letter);
        
        if (!word.contains(String.valueOf(letter))) {
            lives--;
            return false;
        }
        return true;
    }

    public boolean isLetterGuessed(char letter) {
        return guessedLetters.contains(Character.toLowerCase(letter));
    }

    public String getGuessedLettersDisplay() {
        return guessedLetters.stream()
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    }

    public String getDisplayWord() {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            display.append(guessedLetters.contains(letter) ? letter : "_").append(" ");
        }
        return display.toString().trim();
    }

    public boolean isGameOver() {
        return lives <= 0 || isWon();
    }

    public boolean isWon() {
        return word.chars()
            .mapToObj(ch -> (char) ch)
            .allMatch(guessedLetters::contains);
    }

    public int getLives() {
        return lives;
    }

    public String getWord() {
        return word;
    }
}