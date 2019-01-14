package ru.job4j.max;

/**
 * Класс определяет максим из двух чисел.
 */
public class Max {

    /**
     * Метод определяет максимум из двух чисел.
     * @param first первое число.
     * @param second второе число.
     * @return max. Наибольшее из двух.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
