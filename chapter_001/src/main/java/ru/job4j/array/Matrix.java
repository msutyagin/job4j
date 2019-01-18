package ru.job4j.array;

/**
 * Matrix Class. Таблица умножения
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 17.01.19
 * @version 0.1
 */
public class Matrix {
    /**
     * Метод принимает размер матрицы и возвращает таблицу умножения заданного размера.
     * @param size - размер матрицы.
     * @return Возвращает таблицу умножения заданного размера.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
