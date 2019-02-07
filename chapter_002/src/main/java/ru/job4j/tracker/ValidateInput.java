package ru.job4j.tracker;

import java.util.List;

/**
 * Класс валидирующий данные вводимые пользователем.
 */
public class ValidateInput implements Input {

    private final Input input;

    /**
     * Конструктор класса.
     * @param input - ввод пользователя.
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Реализация полиморфического метода ask интерфейса Input.
     * @param question - Вопрос, в качестве ответа на который пользователь будет вводить данные.
     * @return - Вопрос для пользователя, хранящийся в поле этого класса.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
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
                value = this.input.ask(question, range);
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
