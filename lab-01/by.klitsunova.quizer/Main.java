import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Quiz> quizMap = getQuizMap();
        Quiz quiz = null;
        while (quiz == null) {
            System.out.println("Введите название теста...");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            quiz = quizMap.get(input);
        }
        /* QUIZ CODE HERE
        *
        *
        */

    }

    /**
     * @return тесты в {@link Map}, где
     * ключ     - название теста {@link String}
     * значение - сам тест       {@link Quiz}
     */
    static Map<String, Quiz> getQuizMap() {
        return null;
    }
}