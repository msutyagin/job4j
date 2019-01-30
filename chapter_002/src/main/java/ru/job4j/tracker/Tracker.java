package ru.job4j.tracker;

import java.util.*;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private final static Random RN = new Random();

    /**
     * Метод генерит уникальный идентификатор записи.
     * @return - Случайно сгенирированное число + текущее время в милисекундах, преобразованное в строку.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод добавляет новую заявку.
     * @param item - Заявка, которую добавляем по ID.
     * @return - Добавленная заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Меняет содержимое заявки на новое по id.
     * @param id - Идентификатор заменяемой заяки.
     * @param item - Новая заявка на которую меняем заявку с идентификатором id.
     * @return - true если операция удалась.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int index = 0; index < this.position; index++) {
            if (id.equals(this.items[index].getId())) {
                this.items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаляет заявку из трекера.
     * @param id - идентификатор заявки на удаление.
     * @return - true если операция удалась.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Находит все элементы массива.
     * @return - Все заявки.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    /**
     * Возврящает список элементов с зааднным именем.
     * @param key - Имя для поиска.
     * @return - Массив найденных элементов.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.items.length];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[count] = this.items[index];
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    /**
     * Находит элемент по идентификатору.
     * @param id - идентификатор элемента для возврата.
     * @return - заявку с идентифкатором id.
     */
    public Item findById(String id) {
        Item result = new Item();
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = this.items[index];
                break;
            }
        }
        return result;
    }
}
