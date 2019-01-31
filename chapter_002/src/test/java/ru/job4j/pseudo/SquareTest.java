package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Автотест для отрисовки квадрата
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 */
public class SquareTest {

    /**
     * Метод тестирует отрисовку квадрата.
     */
    @Test
    public void whenShapeIsSquare() {
        Square square = new Square();
        StringBuilder expected = new StringBuilder()
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .append(System.lineSeparator())
                .append("++++")
                .append(System.lineSeparator());
        assertThat(square.draw(), is(expected.toString()));
    }
}
