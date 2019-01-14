package ru.job4j.loop;


/**
 * Counter Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 14.01.19
 * @version 0.1
 */
public class Counter {
    /**
     *
     * @param start - period begin.
     * @param finish - period end.
     * @return - Summ of even numbers in the period
     */
    public int add(int start, int finish) {
        int result = 0;
        while (start <= finish) {
            if (start % 2 == 0) {
                result = result + start;
            }
            start++;
        }
        return result;
    }
}
