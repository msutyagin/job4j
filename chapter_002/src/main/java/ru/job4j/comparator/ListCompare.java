package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Класс сравнения двух строк в лексикографическом порядке.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод сравнивает две входящие строки в лексикографическом порядке. Возвращяет 0 если строки равны,
     * 1 если первая строка должна идти после второй и -1, если первая строка должна идти перед второй.
     *
     * @param left  - первая строка.
     * @param right - вторая строка.
     * @return - 0 - строки равны, 1 - первая строка больше (стоит после 2), -1 - вторая строка больше (стоит после 1).
     */
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            rst = Character.compare(left.charAt(i), right.charAt(i));
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(left.length(), right.length());
        }
        return rst;
    }
}