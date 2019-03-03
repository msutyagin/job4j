package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {

    /**
     * Тест метода toList. Входный массиы 2х2.
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * Тест метода toList. Входный массиы 3х3.
     */
    @Test
    public void when3on3ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 0, 0
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}
