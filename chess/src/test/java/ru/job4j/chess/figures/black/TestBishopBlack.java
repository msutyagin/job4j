package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования класса Logic.
 */
public class TestBishopBlack {
    /**
     * Тест на метод isDiagonal. Когда пошел по диагонали.
     */
    @Test
    public void whenBishopHasDiagonalStepThenTrue() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        boolean rst = bishop.isDiagonal(Cell.C8, Cell.D7);
        assertThat(rst, is(true));
    }

    /**
     * Тест на метод isDiagonal. Когда пошел НЕ по диагонали.
     */
    @Test
    public void whenBishopHasNotDiagonalStrepThenFalse() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        boolean rst = bishop.isDiagonal(Cell.C8, Cell.D3);
        assertThat(rst, is(false));
    }

    /**
     * Тест на метод way.
     */
    @Test
    public void whenBishopWentOneCellsThenReturnIt() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell[] extend = new Cell[] {Cell.D7, Cell.E6};
        Cell[] rst = bishop.way(Cell.C8, Cell.E6);
        assertThat(rst, is(extend));
    }
}
