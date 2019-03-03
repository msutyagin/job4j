package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс преобразует двумерный массив, который подается на вход в ArrayList.
 */
public class ConvertMatrix2List {

    /**
     * Метод преобразования.
     * @param array - входящий двумерный массив.
     * @return - итоговый список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}

