package ru.job4j.array;

import java.util.Arrays;
/**
 * Очищаем массив от дубликатов
 * @author Maxim Sutyagin.
 */
public class ArrayDuplicate {

    /**
     * Удаляет дубликаты из строкового массива
     * @param array - массив с дубликатами
     * @return - очищенный от дубликатов массив
     */
    public String[] remove(String[] array) {
        int toDrop = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - toDrop; j++) {
                if (array[i].equals(array[j])) {
                    String tmp = array[array.length - 1 - toDrop];
                    array[array.length - 1 - toDrop] = array[j];
                    array[j] = tmp;
                    toDrop++;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, array.length - toDrop);
    }
}
