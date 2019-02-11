package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Метод тестирует валидацию ввода. Когда вводим текст вместо числа.
     */
    @Test
    public void whenInvalidInputText() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Выбирите пункт меню: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Неверный формат данных. Должно быть число. Повторите ввод.%n")
                )
        );
    }

    /**
     * Метод тестирует валидацию ввода. Когда вводим число за пределами диапазона меню.
     */
    @Test
    public void whenInvalidInputRange() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"55", "0"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(0);
        input.ask("Выбирите пункт меню: ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите число, которое соответствует меню%n")
                )
        );
    }
}
