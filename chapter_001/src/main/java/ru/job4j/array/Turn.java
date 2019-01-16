package ru.job4j.array;

/**
 * Turn Class. Переворачивает массив
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 16.01.19
 * @version 0.1
 */
public class Turn {

    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}

