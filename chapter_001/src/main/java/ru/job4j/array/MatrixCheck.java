package ru.job4j.array;

/**
 * Решение матрицы с двумя диагоналями.
 * @author Maxim Sutyagin.
 */
public class MatrixCheck {
    /**
     * Определяет одинаковость элементов 0 или 1 у квадратной матрцы по обоим диагоналям. Если одинаковые вернет true.
     * @param data - исходная матрица
     * @return - true / false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i == j || j == data.length - i - 1) {
                    if (data[0][0] != data[i][j]) {
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
