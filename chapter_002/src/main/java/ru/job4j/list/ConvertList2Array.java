package ru.job4j.list;

import java.util.List;

/**
 * Класс выполняет конвертацию списка List в двумерный массив с помощью массива foreach.
 */
public class ConvertList2Array {

    /**
     * Сам метод конвертации.
     * @param list Список List, который будем преобразовывать.
     * @param rows Число строк итогового массива.
     * @return - Двумерный массив с числом строк rows.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0, j = 0, k = 0;
        for (int[] row : array) {
            for (int cell : row) {
                if (k < list.size()) {
                    array[j][i] = list.get(k);
                    i++;
                    k++;
                    if (i == cells) {
                        i = 0;
                    }
                } else {
                    array[j][i] = 0;
                    i++;
                }
            }
            j++;
        }
        return array;
    }
}
