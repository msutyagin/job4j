package ru.job4j.tracker;

import java.util.List;

/**
 * Класс валидирующий данные вводимые пользователем.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Метод валидирующий данные вводимые пользователем.
     * @param question - Вопрос для ввода данных.
     * @param range - задает диапазон допустимых значений вводимых данных.
     * @return - введенное значение.
     */
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите число, которое соответствует меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный формат данных. Должно быть число. Повторите ввод.");
            }
        } while (invalid);
        return value;
    }
}
