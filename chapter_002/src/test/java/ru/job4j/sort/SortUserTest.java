package ru.job4j.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class SortUserTest {

    @Test
    public void whenInputListOfUsersThenReturnSetOfUsersSortByname() {
        SortUser obj = new SortUser();
        SortUser.User usr1 = new SortUser.User("Vasya", "18");
        SortUser.User usr2 = new SortUser.User("Max", "37");
        SortUser.User usr3 = new SortUser.User("Artem", "25");
        List<SortUser.User> input = new ArrayList<>();
        input.add(usr1);
        input.add(usr2);
        input.add(usr3);
        Set<SortUser.User> result = obj.sort(input);
        for (SortUser.User el : result) {
            System.out.println(el.getName() + " " + el.getAge());
        }
//        assertThat();
    }
}
