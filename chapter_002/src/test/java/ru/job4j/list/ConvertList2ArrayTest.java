package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс для класса ConvertList2ArrayTest.
 */
public class ConvertList2ArrayTest {

    /**
     * Тест метода toArray 3 строки.
     */
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0 ,0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Тест метода toArray 4 строки.
     */
    @Test
    public void when10ElementsThen12() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                4
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9},
                {10, 0 ,0}
        };
        assertThat(result, is(expect));
    }
}
