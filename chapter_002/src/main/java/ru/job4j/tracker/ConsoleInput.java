package ru.job4j.tracker;

import java.util.List;
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

    /**
     * Реализация перегруженного метода ask интерфейса Input.
     * @param question - Вопрос в ответ на который пользователь вводит данные.
     * @param range - Диапозон допустимых значений ввода.
     * @return - преобразованное в число введенное значение или исключение.
     * @throws NumberFormatException - Ошибка при вводе не числа.
     * @throws MenuOutException - Ошибка при вводе числа за пределами диапазона меню.
     */
    public int ask(String question, List<Integer> range) throws NumberFormatException, MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        MenuOutException.exist(key, range);
        return key;
    }
}