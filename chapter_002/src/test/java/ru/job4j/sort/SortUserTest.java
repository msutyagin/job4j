package ru.job4j.sort;

import java.util.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class SortUserTest {

    /**
     * Метод для тестирования метода sort.
     */
    @Test
    public void whenInputListOfUsersThenReturnSetOfUsersSortByName() {
        SortUser obj = new SortUser();
        SortUser.User usr1 = new SortUser.User("Vasya", "18");
        SortUser.User usr2 = new SortUser.User("Max", "37");
        SortUser.User usr3 = new SortUser.User("Artem", "25");
        List<SortUser.User> input = new ArrayList<>();
        input.add(usr1);
        input.add(usr2);
        input.add(usr3);
        Set<SortUser.User> result = obj.sort(input);
        List<SortUser.User> ex = Arrays.asList(usr1, usr3, usr2);
        assertThat(result.toString(), is(ex.toString()));
    }

    /**
     * Метод для тестирования метода sortNameLength.
     */
    @Test
    public void whenInputListSortByLengThenSortedListByLength() {
        SortUser list = new SortUser();
        SortUser.User usr1 = new SortUser.User("Сергей", "25");
        SortUser.User usr2 = new SortUser.User("Иван", "30");
        SortUser.User usr3 = new SortUser.User("Иосиф", "20");
        SortUser.User usr4 = new SortUser.User("Ким", "25");
        List<SortUser.User> input = new ArrayList<>();
        input.add(usr1);
        input.add(usr2);
        input.add(usr3);
        input.add(usr4);
        List<SortUser.User> result = list.sortNameLength(input);
        List<SortUser.User> ex = Arrays.asList(usr4, usr2, usr3, usr1);
        assertThat(result.toString(), is(ex.toString()));
    }

    /**
     * Метод для тестирования метода sortByAllFields.
     */
    @Test
    public void whenInputListSortByAllFieldsThenSortedListByAllFields() {
        SortUser list = new SortUser();
        SortUser.User usr1 = new SortUser.User("Сергей", "25");
        SortUser.User usr2 = new SortUser.User("Иван", "30");
        SortUser.User usr3 = new SortUser.User("Сергей", "20");
        SortUser.User usr4 = new SortUser.User("Иван", "25");
        List<SortUser.User> input = new ArrayList<>();
        input.add(usr1);
        input.add(usr2);
        input.add(usr3);
        input.add(usr4);
        List<SortUser.User> result = list.sortByAllFields(input);
        List<SortUser.User> ex = Arrays.asList(usr4, usr2, usr3, usr1);
        assertThat(result.toString(), is(ex.toString()));
    }
}
