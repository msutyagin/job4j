package ru.job4j.sort;

import java.util.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class SortUserTest {

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
}
