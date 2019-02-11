package ru.job4j.tracker;

import java.util.List;

public class MenuOutException extends RuntimeException  {

    public MenuOutException(String msg) {
        super(msg);
    }

    public static void exist (int key, List<Integer> range) {
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Введите число, которое соответствует меню.");
        }
    }
}
