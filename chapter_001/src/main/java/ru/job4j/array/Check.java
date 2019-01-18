package ru.job4j.array;

/**
 * Turn Class. Возвращает true или false в зависимости от состояний элментов массива.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 17.01.19
 * @version 0.1
 */
public class Check {

    /**
     * @param data - массив логических элементов
     * @return - true если в масиве все элементы одного типа, все true или все false. Иначе false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 1; index < data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}