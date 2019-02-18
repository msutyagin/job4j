package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;

public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
