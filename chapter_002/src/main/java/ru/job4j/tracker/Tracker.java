package ru.job4j.tracker;

import java.util.*;
import java.util.Arrays;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(item);
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
        for (Item el : this.items) {
            if (id.equals(el.getId())) {
                int index = this.items.indexOf(el);
                this.items.set(index, item);
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
        for (Item el : this.items) {
            if (el.getId().equals(id)) {
                this.items.remove(el);
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
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Возврящает список элементов с зааднным именем.
     * @param key - Имя для поиска.
     * @return - Массив найденных элементов.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item el : this.items) {
            if (el.getName().equals(key)) {
                result.add(el);
            }
        }
        return result;
    }

    /**
     * Находит элемент по идентификатору.
     * @param id - идентификатор элемента для возврата.
     * @return - заявку с идентифкатором id.
     */
    public Item findById(String id) {
        Item result = new Item();
        for (Item el : this.items) {
            if (el.getId().equals(id)) {
                result = el;
                break;
            }
        }
        return result;
    }
}
