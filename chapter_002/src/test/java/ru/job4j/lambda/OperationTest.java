package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс для класса Lambda.
 */

public class OperationTest {

    /**
     * Тестовый метод для линейной функции
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тесотвый метод для квадратной функции.
     */
    @Test
    public void whenSquareFunctionThenSquareResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    /**
     * Тестовый метод для квадртиачной функции
     */
    @Test
    public void whenLogarifmicFunctionThenLogarifmicResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x) + 1);
        List<Double> expected = Arrays.asList(2.6094379124341005D, 2.791759469228055D, 2.9459101490553135D);
        assertThat(result, is(expected));
    }
}
