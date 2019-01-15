package ru.job4j.loop;
/**
 * Paint Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 15.01.19
 * @version 0.1
 */
public class Paint {
    /**
     * Метод рисует пирамиду высотой height.
     * @param height - высота пирамиды к отрисовке.
     * @return - Отрисованную пиармиду в псевдографике.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
