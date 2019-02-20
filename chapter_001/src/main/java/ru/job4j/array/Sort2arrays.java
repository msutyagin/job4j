package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс сливает два отсортированных массива в один отсортированный 2 спсобами.
 */
public class Sort2arrays {
    private int[] arr1;
    private int[] arr2;

    /**
     * Конкструктор класса.
     * @param arr1 - массив 1
     * @param arr2 - массив 2
     */
    public Sort2arrays(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    /**
     * Сортируем сначала.
     * @return - Отсортированный новый массив.
     */
    public int[] sort() {
        int[] rst = new int[this.arr1.length + this.arr2.length];
        int i = 0, j = 0, rstIndex = 0;
        while ((i < this.arr1.length) && (j < this.arr2.length)) {
            if (arr1[i] < arr2[j]) {
                rst[rstIndex] = arr1[i];
                i++;
            } else {
                rst[rstIndex] = arr2[j];
                j++;
            }
            rstIndex++;
        }
        while (rstIndex < rst.length) {
            if (arr1.length >= arr2.length) {
                rst[rstIndex] = arr1[i];
                i++;
                rstIndex++;
            } else {
                rst[rstIndex] = arr2[j];
                j++;
                rstIndex++;
            }
        }
        return rst;
    }

    /**
     * Способ 2. Через объединение массивов и сортировку пузырьком.
     * @return - Отсортированный новый массив.
     */
    public int[] sortNew() {
        int[] input = Arrays.copyOf(new int[arr1.length + arr2.length], arr1.length + arr2.length);
        System.arraycopy(arr1, 0, input, 0, arr1.length);
        System.arraycopy(arr2, 0, input, arr1.length, arr2.length);
        BubbleSort newArray = new BubbleSort();
        return newArray.sort(input);
    }
}
