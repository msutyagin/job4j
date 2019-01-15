package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 15.01.19
 * @version 0.1
 */
public class Paint {
    /**
     * Реализует правсторонний треугольник
     * @param height - высота треугольника
     * @return - возвращает правсторонний треуголник в псевдографике
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Реализует левосторонний треугольник
     * @param height - высота треугольника
     * @return - возвращает левосторонний треуголник в псевдографике
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Метод рисует пирамиду высотой height.
     * @param height - высота пирамиды к отрисовке.
     * @return - Отрисованную пиармиду в псевдографике.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Вспомогательный метод
     * @param height - высота пирамиды.
     * @param weight - ширина пирамиды.
     * @param predict - Условие простановки "^".
     * @return - Пирамиду
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
