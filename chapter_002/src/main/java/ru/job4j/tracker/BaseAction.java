package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;
    /**
     * Конструктор класса. Принимает параметры, передаваемые при создании объекта из класса, реализующего интерфейс UserAction.
     * @param key - ключ пункта меню.
     * @param name - Имя пункта меню.
     */
    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Реализация метода key из интерфейса UserAction.
     * @return - вернет ключ меню.
     */
    @Override
    public int key() {
        return this.key;
    }

    /**
     * Реализация метода info из интерфейса UserAction.
     * @return - вернет описание меню.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
