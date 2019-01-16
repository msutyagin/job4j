package ru.job4j.array;

/**
 * FindLoop Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 16.01.19
 * @version 0.1
 */
public class FindLoop {

    /**
     * Метод ищет заданное число в массиве и возвращает индекс подходящего элемента массива
     * @param data - Массив для поиска
     * @param el - Данные, котореы ищем
     * @return - Индекс подходящего элемента массива
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
