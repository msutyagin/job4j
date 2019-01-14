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
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                result = 1;
            } else {
                result = result * i;
            }
        }
        return result;
    }
}
