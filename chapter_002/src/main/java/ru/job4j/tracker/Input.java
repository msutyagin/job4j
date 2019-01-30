package ru.job4j.tracker;

/**
 * Полиморфический интрефейс для ввода данных в приложение.
 */
public interface Input {

    String ask(String question);
}