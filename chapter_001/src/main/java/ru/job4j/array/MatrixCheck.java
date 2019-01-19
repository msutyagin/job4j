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
        for (int j = 0; j < data.length; j++) {
            if (data[0][0] != data[j][data.length - j - 1] || data[0][0] != data[j][j]
                    || data[0][data.length - 1] != data[j][data.length - j - 1]) {
                result = false;
                break;
            }
/*            if (data[0][0] != data[j][data.length - j - 1]) {
                result = false;
                break;
            }*/
        }
        return result;
    }
}
