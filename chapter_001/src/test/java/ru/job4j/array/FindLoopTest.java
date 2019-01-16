package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 AutoTest for FindLoop class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 13.01.19
 @version 1.0
 */

public class FindLoopTest {

    /**
     * Test indexOf method. 5, 10, 3
     */
    @Test
    public void whenArrayHasLength10Then1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 10;
        int result = find.indexOf(input, value);
        int expect = 1;
        assertThat(result, is(expect));
    }

    /**
     * Test indexOf method. Element
     */
    @Test
    public void whenArrayHasLength6ThenNothing() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 6;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
