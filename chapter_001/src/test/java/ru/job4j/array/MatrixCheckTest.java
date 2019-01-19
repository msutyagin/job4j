package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *  AutoTest for MatrixCheck class
 *  @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 *  @since 18.01.19
 *  @version 1.0
 */

public class MatrixCheckTest {
    /**
     * Test mono method. 3x3. True.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test mono method. 3x3. False.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test mono method. 4x4. False.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalseEvenElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, true},
                {true, false, true, false},
                {true, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test mono method. 4x4. True.
     */
    @Test
    public void whenDataMonoByTrueThenTrueEvenElements() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, true},
                {true, true, true, false},
                {true, false, true, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
