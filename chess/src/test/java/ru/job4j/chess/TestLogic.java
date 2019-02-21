package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования класса Logic.
 */
public class TestLogic {
    /**
     * Тест на метод move. По диагонали на пути никого нет.
     */
    @Test
    public void whenBlackBishopMoveTwoCellsDiagonalThenTrue() {
        Logic board = new Logic();
        board.add(new BishopBlack(Cell.C8));
        boolean rst = board.move(Cell.C8, Cell.E6);
        assertThat(rst, is(true));
    }

    /**
     * Тест на метод move. Не по диагонали.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackBishopMoveTwoCellsNotDiagonalThenImpossibleMoveException() {
        Logic board = new Logic();
        board.add(new BishopBlack(Cell.C8));
       board.move(Cell.C8, Cell.E5);
       // assertThat(rst, is(false));
    }

    /**
     * Тест на метод move. По диагонали на пути фигура.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBlackBishopMoveTwoCellsDiagonalButOnOneOfThemAnotherFigureStayThenException() {
        Logic board = new Logic();
        board.add(new BishopBlack(Cell.C8));
        board.add(new PawnBlack(Cell.D7));
        board.move(Cell.C8, Cell.E6);
    }
}
