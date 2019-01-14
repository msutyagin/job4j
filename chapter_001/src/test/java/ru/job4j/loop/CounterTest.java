package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 AutoTest for Counter class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 13.01.19
 @version 1.0
 */
public class CounterTest {
    /**
     * Test add method.
     */
    @Test
    public void whenStart0Finish10Then30() {
        Counter cnter = new Counter();
        int result = cnter.add(0, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}
