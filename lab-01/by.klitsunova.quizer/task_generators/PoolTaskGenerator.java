package task_generators;

import tasks.*;

import java.util.*;

public class PoolTaskGenerator implements TaskGenerator {
    boolean allowDuplicate;
    List<Task> tasks;

    /**
     * Конструктор с переменным числом аргументов
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые в конструктор передаются через запятую
     */
    PoolTaskGenerator(
            boolean allowDuplicate,
            Task... tasks
    ) {
        this.allowDuplicate = allowDuplicate;
        this.tasks = List.of(tasks);
    }

    /**
     * Конструктор, который принимает коллекцию заданий
     *
     * @param allowDuplicate разрешить повторения
     * @param tasks          задания, которые передаются в конструктор в Collection (например, {@link LinkedList})
     */
    PoolTaskGenerator(
            boolean allowDuplicate,
            Collection<Task> tasks
    ) {
        this.tasks = new ArrayList<>(tasks);
        this.allowDuplicate = allowDuplicate;
        if (!allowDuplicate) {
            if (tasks.stream().distinct().count() != tasks.size()) {
                throw new IllegalArgumentException("Упс, дубликаты в коллекции");
            }
        }
    }

    /**
     * @return случайная задача из списка
     */
    public Task generate() {
        if (tasks.isEmpty()) {
            throw new NoSuchElementException("Нет заданий");
        }
        Random rand = new Random();
        Task task = tasks.get(rand.nextInt(tasks.size()));
        if (!allowDuplicate) {
            tasks.remove(task);
        }
        return task;
    }
}
