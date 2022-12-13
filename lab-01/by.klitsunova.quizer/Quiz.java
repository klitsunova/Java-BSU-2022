import task_generators.TaskGenerator;
import tasks.Result;
import tasks.Task;

/**
 * Class, который описывает один тест
 */
public class Quiz {
    /**
     * @param generator генератор заданий
     * @param taskCount количество заданий в тесте
     */

    private final TaskGenerator generator;
    private final int taskCount;
    private int correctAnswerNumber = 0;
    private int wrongAnswerNumber = 0;
    private int incorrectInputNumber = 0;
    private Task currentTask;

    Quiz(TaskGenerator generator, int taskCount) {
        this.generator = generator;
        this.taskCount = taskCount;
    }

    /**
     * @return задание, повторный вызов вернет слелующее
     * @see Task
     */
    Task nextTask() {
        if (currentTask == null) {
            currentTask = generator.generate();
        }
        return currentTask;
    }

    /**
     * Предоставить ответ ученика. Если результат {@link Result#INCORRECT_INPUT}, то счетчик неправильных
     * ответов не увеличивается, а {@link #nextTask()} в следующий раз вернет тот же самый объект {@link Task}.
     */
    Result provideAnswer(String answer) {
        Result result = currentTask.validate(answer);
        switch (result) {
            case OK -> {
                correctAnswerNumber++;
                currentTask = null;
            }
            case WRONG -> {
                wrongAnswerNumber++;
                currentTask = null;
            }
            case INCORRECT_INPUT -> incorrectInputNumber++;
        }
        return result;
    }

    /**
     * @return завершен ли тест
     */
    boolean isFinished() {
        return correctAnswerNumber + wrongAnswerNumber == taskCount;
    }

    /**
     * @return количество правильных ответов
     */
    int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    /**
     * @return количество неправильных ответов
     */
    int getWrongAnswerNumber() {
        return wrongAnswerNumber;
    }

    /**
     * @return количество раз, когда был предоставлен неправильный ввод
     */
    int getIncorrectInputNumber() {
        return incorrectInputNumber;
    }

    /**
     * @return оценка, которая является отношением количества правильных ответов к количеству всех вопросов.
     * Оценка выставляется только в конце!
     */
    double getMark() {
        return correctAnswerNumber / (double) taskCount;
    }
}
