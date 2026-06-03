package com.example;

/**
 * A simple calculator providing basic arithmetic operations.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a first operand
     * @param b second operand
     * @return sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts b from a.
     *
     * @param a first operand
     * @param b second operand
     * @return difference of a minus b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a first operand
     * @param b second operand
     * @return product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides a by b.
     *
     * @param a dividend
     * @param b divisor
     * @return quotient of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    /**
     * Raises base to the given exponent.
     *
     * @param base     the base value
     * @param exponent the exponent
     * @return base raised to the power of exponent
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Computes the square root of a number.
     *
     * @param value the value to compute the square root of
     * @return the square root of value
     * @throws ArithmeticException if value is negative
     */
    public double sqrt(double value) {
        if (value < 0) {
            throw new ArithmeticException("Square root of a negative number is not defined");
        }
        return Math.sqrt(value);
    }
}
