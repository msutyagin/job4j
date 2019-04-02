package ru.job4j.list;

import java.util.ArrayList;
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
        int i = 0, j = 0;
        for (Integer el : list) {
            array[i][j++] = el;
            if (j == array[i].length) {
                i++;
                j=0;
            }
        }
        return array;
    }
    /**
     * Метод преобразует список List, элементами которого являются массивы разной длины в один общий,
     * плоский список элементов.
     * @param list - Исходный список массивов.
     * @return - Итоговый прослкий список.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int i = 0; i < array.length; i++) {
                result.add(array[i]);
            }
        }
        return result;
    }
}
