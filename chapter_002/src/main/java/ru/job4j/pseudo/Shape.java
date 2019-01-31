package ru.job4j.pseudo;

/**
 * Интерфейс фигура - 1 шаг в терминах шаблона проектирования strategy.
 */
public interface Shape {

    /**
     * Полиморфический метод draw, возвращает строку.
     * @return - строка.
     */
    String draw();
}
