package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestSort2arrays {
    /**
     * Тестируем метод sort, когда первый массив длиннее.
     */
    @Test
    public void whenArr1longerThenMakeNewArray() {
        Sort2arrays newArray = new Sort2arrays(new int[] {1, 3, 5, 7}, new int[] {2, 4, 6});
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] rst = newArray.sort();
        assertThat(rst, is(expect));
    }

    /**
     * Тестируем метод sort, когда второй массив длиннее.
     */
    @Test
    public void whenArr2longerThenMakeNewArray() {
        Sort2arrays newArray = new Sort2arrays(new int[] {1, 3, 5}, new int[] {2, 4, 6, 7});
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] rst = newArray.sort();
        assertThat(rst, is(expect));
    }

    /**
     * Тестируем метод sortNew, когда первый массив длиннее.
     */
    @Test
    public void whenArr1longerThenMakeNewArrayBySortNew() {
        Sort2arrays newArray = new Sort2arrays(new int[] {1, 3, 5, 7, 9}, new int[] {2, 4, 6});
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 9};
        int[] rst = newArray.sortNew();
        assertThat(rst, is(expect));
    }

    /**
    * Тестируем метод sortNew, когда второй массив длиннее.
    */
    @Test
    public void whenArr2longerThenMakeNewArrayBySortNew() {
        Sort2arrays newArray = new Sort2arrays(new int[] {1, 3, 5}, new int[] {2, 4, 6, 7, 8});
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int[] rst = newArray.sortNew();
        assertThat(rst, is(expect));
    }
}
