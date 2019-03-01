package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса PhoneDictionary
 */
public class PhoneDictionaryTest {

    /**
     * Тестируем метод find, когда совпадение найдено в имени
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тестируем метод find, когда совпадение найдено в фамилии
     */
    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("tev");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тестируем метод find, когда совпадение найдено в телефоне
     */
    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("534");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    /**
     * Тестируем метод find, когда совпадение найдено в адресе
     */
    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Bry");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}
