package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 AutoTest for Max class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 14.01.19
 @version 1.0
 */
public class MaxTest {

    /**
     * Test max method. When first > second
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max method. When second > first
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Test max method. When second = first
     */
    @Test
    public void whenSecondEqualFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }

    /**
     * Test max(1, 2, 3) method.
     */
    @Test
    public void whenSomeIsMax() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }

}
