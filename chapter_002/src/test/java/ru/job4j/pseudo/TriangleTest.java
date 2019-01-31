package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Автотест для отрисовки квадрата
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 */
public class TriangleTest {

    /**
     * Метод тестирует отрисовку треугольника.
     */
    @Test
    public void whenShapeIsTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder expected = new StringBuilder()
                .append("   +   ")
                .append(System.lineSeparator())
                .append("  +++  ")
                .append(System.lineSeparator())
                .append(" +++++ ")
                .append(System.lineSeparator())
                .append("+++++++")
                .append(System.lineSeparator());
        assertThat(triangle.draw(), is(expected.toString()));
    }
}
