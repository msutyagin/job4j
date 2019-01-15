package ru.job4j.loop;

/**
 * Board Class.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @since 15.01.19
 * @version 0.1
 */
public class Board {

    /**
     * Метод отввечает за отрисовку шахматной доски размером width х height
     * @param width - ширина шахматной доски
     * @param height - высота шахматной доски
     * @return - Возвращает отрисованную доску из строк с заданным расположение символов
     */
    public String paint(int height, int width) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
