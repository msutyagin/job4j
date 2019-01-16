package ru.job4j.array;

/**
 * Square Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 16.01.19
 * @version 0.1
 */
public class Square {

    /**
     *
     * @param bound - Длинна массива
     * @return - Массив квадратов элементов входящего массива
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst[i] = i + 1;
            rst[i] = rst[i] * rst[i];
        }
        return rst;
    }
}
