import tasks.Task;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Quiz> quizMap = getQuizMap();
        Quiz quiz = null;
        Scanner scanner = new Scanner(System.in);
        while (quiz == null) {
            System.out.println("Введите название теста...");
            String input = scanner.next();
            quiz = quizMap.get(input);
        }
        while (!quiz.isFinished()) {
            Task task = quiz.nextTask();
            System.out.println(task.getText());
            String answer = scanner.nextLine();
            switch (quiz.provideAnswer(answer)) {
                case OK -> System.out.println("ОК");
                case WRONG -> System.out.println("НЕ ОК");
                case INCORRECT_INPUT -> System.out.println("Некорректный ввод, попробуйте еще раз:");
            }
        }
        System.out.println("УРА, ВЫ С ЭТИМ СПРАВИЛИСЬ! ОЦЕНКА: " + quiz.getMark());
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
