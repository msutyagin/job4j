package ru.job4j.pseudo;

/**
 * Класс реализация квадрата. Шаг 2 в терминнах шаблона проектирования strategy.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 */
public class Square implements Shape {

    /**
     * Переопределенный метод draw интрефейса Shape. Возвращает квадрат в строке.
     * @return - Возвращает квадрат в псевдографике в виде строки.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("++++");
        pic.append(System.lineSeparator());
        return pic.toString();
    }
}
