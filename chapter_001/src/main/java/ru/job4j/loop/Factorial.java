package ru.job4j.loop;


/**
 * Factorial Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 14.01.19
 * @version 0.1
 */
public class Factorial {
    /**
     * Метод возвращает факториал числа
     * @param n - Число, факториал котрого надо вернуть
     * @return Факториал n
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        if (result == 0) {
            result = 1;
        }
        return result;
    }
}
