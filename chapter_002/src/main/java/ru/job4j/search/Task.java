package ru.job4j.search;

/**
 * Класс описывает сущность задача. Содержит только поля задачи и геттеры.
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getPriority() {
        return this.priority;
    }
}
