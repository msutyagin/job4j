package ru.job4j.array;

/**
 * Сортировка массива пузырьком.
 * @author Maxim Sutyagin.
 */
public class BubbleSort {

    /**
     * Реализует сортировку входящего массива методом пузырька, возвращает отсортированный массив.
     * @param array - входной массив
     * @return - отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int index = 0; index < array.length - j - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
