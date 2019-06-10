package ru.job4j.departments;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс для класса Departments.
 */

public class DepartmentsTest {
    /**
     * Тест метод для метода convert.
     */
    @Test
    public void whenMissed() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1")),
                new Departments.Org(Arrays.asList("k2"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    /**
     * Тест метод для метода sortAsc.
     */
    @Test
    public void whenAsc() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1")),
                new Departments.Org(Arrays.asList("k2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    /**
     * Тест метод для метода sortDesc.
     */
    @Test
    public void whenDesc() {
        Departments deps = new Departments();
        List<String> input = Arrays.asList("k1/sk1", "k2");
        List<Departments.Org> expect = Arrays.asList(
                new Departments.Org(Arrays.asList("k2")),
                new Departments.Org(Arrays.asList("k1")),
                new Departments.Org(Arrays.asList("k1", "sk1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }
}