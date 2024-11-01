package firstExercise;

import java.util.Random;

public class WordBank {
    private final String[] words = {
        "программирование", "java", "компьютер", "алгоритм",
        "разработка", "интерфейс", "наследование", "инкапсуляция"
    };
    private final Random random = new Random();

    public String getRandomWord() {
        return words[random.nextInt(words.length)];
    }
}