package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс описывает черного слона.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    /**
     * Конструктор класса.
     * @param position - Начальная позиция слона.
     */
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Геттер поля position.
     * @return
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Метод возвращает массив ячеек, которые прошел слон за последний ход.
     * @param source - Ячейка, где находился слон до начала движения.
     * @param dest - Ячейка назначения.
     * @return - Массив пройденных ячеек.
     * @throws ImpossibleMoveException - Если пробует пойти не по правилам выдать этото ексепшен.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Слон ходит только по диагонали!");
        }
        Cell[] steps = new Cell[Math.abs((dest.x - source.x))];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        for (int i = 0; i < steps.length; i++) {
            if (deltaX < 0 && deltaY < 0) {
                steps[i] = Cell.values()[(source.x - (i + 1)) * 8 + (source.y - (i + 1))];
            }
            if (deltaX > 0 && deltaY < 0) {
                steps[i] = Cell.values()[(source.x + (i + 1)) * 8 + (source.y - (i + 1))];
            }
            if (deltaX > 0 && deltaY > 0) {
                steps[i] = Cell.values()[(source.x + (i + 1)) * 8 + (source.y + (i + 1))];
            }
            if (deltaX < 0 && deltaY > 0) {
                steps[i] = Cell.values()[(source.x - (i + 1)) * 8 + (source.y + (i + 1))];
            }
        }
        return steps;
    }

    /**
     * Метод помещает слона на клетку назначения.
     * @param dest - Клетка назначения движения.
     * @return - Возвращает фигуру слона на новой клетке.
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * Вспомогательный метод проверки правила движения слона, он двигается только по диагонали.
     * @param source - Клетка начала движения.
     * @param dest - Клетка назначения.
     * @return - true если правило соблюдено.
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        int deltaX = Math.abs(dest.x - source.x);
        int deltaY = Math.abs(dest.y - source.y);
        if (deltaX == deltaY) {
            if (deltaX != 0) {
                rst = true;
            }
        }
        return rst;
    }
}
