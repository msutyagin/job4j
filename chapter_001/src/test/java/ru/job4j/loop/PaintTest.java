package ru.job4j.loop;


import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 AutoTest for Board class
 @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 @since 13.01.19
 @version 1.0
 */
public class PaintTest {
    /**
     * Test pyramid method. Height = 4.
     */
    @Test
    public void whenPyramid4Height() {
        Paint paint = new Paint();
        String result = paint.pyramid(4);
        System.out.println(result);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                ));
    }
}
