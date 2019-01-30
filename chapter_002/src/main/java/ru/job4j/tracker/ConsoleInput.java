package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Одна из реализаций ввода данных в приложение через консоль.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод выводит вопрос для пользователя и принимает его ответ, введенный с клавиатуры.
     * @param question - Вопрос для пользователя.
     * @return - Веедную пользователем на клавиатуре строку.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}