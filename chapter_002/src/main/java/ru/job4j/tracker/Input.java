package ru.job4j.tracker;

import java.util.List;

/**
 * Полиморфический интрефейс для ввода данных в приложение.
 */
public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);
}