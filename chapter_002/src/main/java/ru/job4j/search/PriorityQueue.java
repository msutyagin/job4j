package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс описывает сущность очередь с приоритетом. Метод put добавляет элемент очереди по порядку, согласно приоритета.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int count = this.tasks.size();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getPriority() > task.getPriority()) {
                count = i;
                break;
            }
        }
        this.tasks.add(count, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
