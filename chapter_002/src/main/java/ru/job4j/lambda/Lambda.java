package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс для расчета произвольной функции с одним неизвестным в диапазоне.
 * На выходе получаем диапозон значений функции для диапазона аргументов, передающихся на вход, как граничные значения диапазона.
 */
public class Lambda {

    /**
     * Метод возвращает список значений произвольной функции.
     * @param start - Начальное значение диапазона аргумента функции. Входит в диапазон.
     * @param end - Конечное значение диапазона аргумента функции. Не входит в диапазон.
     * @param func - Функциональный интефейс типа Function, принимает и возвращает значение типа Double.
     * @return - Возвращает список значений функции при соответствующих аргументов из входящего диапазона
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double index = start; index != end; index++) {
            result.add(func.apply(index));
        }
        return result;
    }
}
