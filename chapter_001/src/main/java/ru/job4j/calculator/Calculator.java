package ru.job4j.calculator;

/**
 * Class Calculator. Simple Calculator release.
 *   @author Maxim Sutyagin (m.sutyagin.m@gmail.com).
 */

public class Calculator {

    // Class field - result of calculation
    private double result;

    /**
     * Method add. Addition two numbers.
     * @param first - first number.
     * @param second - second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract. Subtract second from first.
     * @param first - first number.
     * @param second - second number.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method multiple. Multiple first and second.
     * @param first - first number.
     * @param second - second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method div. Div first to second.
     * @param first - first number.
     * @param second - second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method add. Addition two numbers.
     * @return result - Result of calculation.
     */
    public double getResult() {
        return this.result;
    }

}
