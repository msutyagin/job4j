package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 AutoTest for Turn class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 13.01.19
 @version 1.0
 */

public class TurnTest {
    /**
     * Test back method. Even array elements
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {44, 11, 66, 22};
        int[] result = turner.back(input);
        int[] expected = new int[] {22, 66, 11, 44};
        assertThat(result, is(expected));
    }
    /**
     * Test back method. Odd array elements
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.back(input);
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
