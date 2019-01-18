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
        int isSortWell = 0;
        int index = 0;
        while (isSortWell != array.length - 1) {
            if (array[index] > array[index + 1]) {
                int temp = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temp;
                isSortWell = 0;
            } else {
                isSortWell++;
            }
            index++;
            if (index == array.length - 1) {
                index = 0;
            }
        }
        return array;
    }
}
