package ru.job4j.array;

public class Sort2arrays {
    private int[] arr1 = new int[] {1, 4, 6};
    private int[] arr2 = new int[] {2, 3, 5, 7};

    public int[] sort() {
        int[] rst = new int[7];
        int i = 0, j = 0, k = 0;
        while ((i != arr1.length) && (j != arr2.length)) {
            if (arr1[i] < arr2[j]) {
                rst[k] = arr1[i];
                i++;
            } else {
                rst[k] = arr2[j];
                j++;
            }
            k++;
        }
        return rst;
    }

    public static void main(String[] args) {
        Sort2arrays newArray = new Sort2arrays();
        for (int i = 0; i < newArray.sort().length; i++) {
            System.out.print(newArray.sort()[i] + ", ");
        }

    }

}
