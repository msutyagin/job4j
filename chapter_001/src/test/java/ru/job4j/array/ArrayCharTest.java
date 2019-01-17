package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 AutoTest for ArrayChar class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 17.01.19
 @version 1.0
 */
public class ArrayCharTest {
    /**
     * Test startWith. When start with.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }
    /**
     * Test startWith. When don`t start with.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
}