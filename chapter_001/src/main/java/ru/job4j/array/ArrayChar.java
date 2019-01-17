package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int j = 0; j < value.length; j++) {
            for (int i = 0; i < data.length; i++) {
                if (i == j && value[j] != data[i]) {
                        result = false;
                }
            }
        }
        return result;
    }
}