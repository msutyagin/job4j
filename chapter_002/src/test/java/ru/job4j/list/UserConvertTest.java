package ru.job4j.list;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса UserConvert.
 */
public class UserConvertTest {

    /**
     * Тест метода process.
     */
    @Test
    public void whenHaveListOfUsersThenHaspMap() {
        UserConvert map = new UserConvert();
        List<User> input = new ArrayList<>();
        User usr1 = new User(1, "Moscow");
        User usr2 = new User(2, "Yaroslavl");
        User usr3 = new User(3, "Vologda");
        input.add(usr1);
        input.add(usr2);
        input.add(usr3);
        HashMap<Integer, User> result = map.process(input);
        HashMap<Integer, User> expext = new HashMap<>();
        expext.put(1, usr1);
        expext.put(2, usr2);
        expext.put(3, usr3);
        assertThat(result, is(expext));
    }
}
