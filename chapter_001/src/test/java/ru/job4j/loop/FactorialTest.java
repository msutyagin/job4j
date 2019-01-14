package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 AutoTest for Factorial class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 13.01.19
 @version 1.0
 */
public class FactorialTest {
    /**
     * Test calc method. 5!
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factor = new Factorial();
        int result = factor.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
    /**
     * Test calc method. 0!
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factor = new Factorial();
        int result = factor.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}
