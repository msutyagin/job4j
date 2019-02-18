package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * Класс описывает логику работы приложения. Добавление фигур, их движение, очистку доски, поиск фигуры на клетке.
 * @author Maxim Sutyagin (m.sutyagin.m@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    /**
     * Метод добавляет фигуру на доску.
     * @param figure - Фигура, которую надо добавить на доску.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод реализует проверку на возможность перемещение фигуры в клетку назначения.
     * Если все правила для движения фигуры соблюдены, то вернет true. Если нет, выкинет соответствующее исключение.
     * @param source - Клетка начала движения.
     * @param dest - Клетка назначения.
     * @return - true если перемещение возможно.
     * @throws ImpossibleMoveException - Нельзя двигать фигуру таким образом, не соблюдены правила.
     * @throws OccupiedWayException - На пути движения стоит другая фигура.
     * @throws FigureNotFoundException - Фигура не найдена.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        try {
            if (index == -1) {
                throw new FigureNotFoundException("Фигура не найдена!");
            }
            Cell[] steps = this.figures[index].way(source, dest);
            for (int i = 0; i < steps.length; i++) {
                for (int j = 0; j != this.figures.length; j++) {
                    if (this.figures[j] != null && steps[i] == this.figures[j].position()) {
                        //           this.figures[index] = this.figures[index].copy(source);
                        throw new OccupiedWayException("Фигура не может проходить сквозь клетки, занятые другими фигурами");
                    }
                }
            }
            if (steps.length <= 0 || !steps[steps.length - 1].equals(dest)) {
                //    this.figures[index] = this.figures[index].copy(source);
                throw new ImpossibleMoveException("Фигура не может быть перемещена таким образом!");
            }
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        } catch (ImpossibleMoveException ime) {
            System.out.println("Фигура не может быть перемещена таким образом!");
        } catch (OccupiedWayException owe) {
            System.out.println("Фигура не может проходить сквозь клетки, занятые другими фигурами!");
        } catch (FigureNotFoundException fnfe) {
            System.out.println("Фигура не найдена!");
        }
        return rst;
    }

    /**
     * Метод очищает доску от фигур.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Метод определяет какая фигура находиться в заданной клетке.
     * @param cell - клетка, которую проверяем.
     * @return - индекс фигуры из массива фигур.
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
