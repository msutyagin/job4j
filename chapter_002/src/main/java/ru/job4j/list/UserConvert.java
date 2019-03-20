package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Класс преобразует список User в карту User.
 */
public class UserConvert {
    /**
     * Метод преобразования.
     * @param list - Входной список User.
     * @return - Итоговая  карта.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User el : list) {
            result.put(el.getId(), el);
        }
        return result;
    }
}
