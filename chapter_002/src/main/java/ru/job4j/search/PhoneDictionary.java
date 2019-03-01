package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует телефонны справочник с методом добавления абонента и поиска его по ключу.
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Метод добавляет абонента в справочник.
     * @param person - Абонент для добавления
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод ищет абонента в справочнике по ключу.
     * @param key ключ по совпадению с которым будут возвращены абоненты
     * @return - список подошедших абонентов.
     */
    public List<Person> find(String key) {
        List<Person> rst = new ArrayList<>();
        for (Person value : this.persons) {
            if (value.getName().contains(key)
                    || value.getSurname().contains(key)
                    || value.getPhone().contains(key)
                    || value.getAddress().contains(key)) {
                rst.add(value);
            }
        }
        return rst;
    }
}
