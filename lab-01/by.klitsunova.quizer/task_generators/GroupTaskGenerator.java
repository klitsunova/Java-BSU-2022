package task_generators;

import tasks.Task;

import java.util.*;

class GroupTaskGenerator implements TaskGenerator {
    List<TaskGenerator> taskGeneratorList;

    /**
     * Конструктор с переменным числом аргументов
     *
     * @param generators генераторы, которые в конструктор передаются через запятую
     */
    GroupTaskGenerator(TaskGenerator... generators) {
        this.taskGeneratorList = List.of(generators);
    }

    /**
     * Конструктор, который принимает коллекцию генераторов
     *
     * @param generators генераторы, которые передаются в конструктор в Collection (например, {@link ArrayList})
     */
    GroupTaskGenerator(Collection<TaskGenerator> generators) {
        this.taskGeneratorList = new ArrayList<>(generators);
    }

    /**
     * @return результат метода generate() случайного генератора из списка.
     * Если этот генератор выбросил исключение в методе generate(), выбирается другой.
     * Если все генераторы выбрасывают исключение, то и тут выбрасывается исключение.
     */
    public Task generate() {
        if (taskGeneratorList.isEmpty()) {
            throw new NoSuchElementException("Список генераторов пустой");
        }

        Collections.shuffle(taskGeneratorList);
        for (TaskGenerator generator : taskGeneratorList) {
            try {
                return generator.generate();
            } catch (NoSuchElementException ignored) {
            }
        }
        throw new NoSuchElementException("Все генераторы выбрасывают исключение");
    }
}