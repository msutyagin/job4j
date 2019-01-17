package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 AutoTest for Check class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 17.01.19
 @version 1.0
 */
public class CheckTest {
    /**
     * Test mono method. Odd array elements. True.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono method. Odd array elements. False.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Test mono method. Even array elements. True.
     */
    @Test
    public void whenDataMonoByFalseEvenThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Test mono method. Even array elements. False.
     */
    @Test
    public void whenDataNotMonoEvenThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}