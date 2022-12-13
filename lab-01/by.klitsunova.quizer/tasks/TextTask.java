package tasks;
import task_generators.*;
/**
 * Задание с заранее заготовленным текстом.
 * Можно использовать {@link PoolTaskGenerator}, чтобы задавать задания такого типа.
 */
public class TextTask implements Task {
    /**
     * @param text   текст задания
     * @param answer ответ на задание
     */
    public TextTask(
            String text,
            String answer
    ) {
        // ...
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public Result validate(String answer) {
        return null;
    }

    // ...
}