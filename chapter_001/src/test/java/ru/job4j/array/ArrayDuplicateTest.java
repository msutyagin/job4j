
package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
/**
 AutoTest for ArrayDuplicate class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 19.01.19
 @version 1.0
 */
public class ArrayDuplicateTest {
    /**
     * Test remove method
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Мир", "Привет", "Пока", "Мир", "Пока", "Луна"};
        String[] expect = {"Привет", "Мир", "Пока", "Луна"};
        ArrayDuplicate array = new ArrayDuplicate();
        String[] result = array.remove(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}