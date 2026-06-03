package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // --- add ---

    @Test
    @DisplayName("adds two positive numbers")
    void addPositiveNumbers() {
        assertEquals(5.0, calculator.add(2, 3));
    }

    @Test
    @DisplayName("adds negative numbers")
    void addNegativeNumbers() {
        assertEquals(-1.0, calculator.add(-3, 2));
    }

    @Test
    @DisplayName("adds with zero")
    void addWithZero() {
        assertEquals(7.0, calculator.add(7, 0));
    }

    // --- subtract ---

    @Test
    @DisplayName("subtracts two numbers")
    void subtractNumbers() {
        assertEquals(6.0, calculator.subtract(10, 4));
    }

    @Test
    @DisplayName("subtract resulting in negative value")
    void subtractResultNegative() {
        assertEquals(-2.0, calculator.subtract(3, 5));
    }

    // --- multiply ---

    @Test
    @DisplayName("multiplies two numbers")
    void multiplyNumbers() {
        assertEquals(15.0, calculator.multiply(3, 5));
    }

    @Test
    @DisplayName("multiply by zero returns zero")
    void multiplyByZero() {
        assertEquals(0.0, calculator.multiply(99, 0));
    }

    @Test
    @DisplayName("multiplies two negative numbers")
    void multiplyNegativeNumbers() {
        assertEquals(6.0, calculator.multiply(-2, -3));
    }

    // --- divide ---

    @Test
    @DisplayName("divides two numbers")
    void divideNumbers() {
        assertEquals(5.0, calculator.divide(15, 3));
    }

    @Test
    @DisplayName("divide by zero throws ArithmeticException")
    void divideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    @DisplayName("divides resulting in a decimal")
    void divideDecimalResult() {
        assertEquals(0.5, calculator.divide(1, 2));
    }

    // --- power ---

    @Test
    @DisplayName("raises to a positive power")
    void powerPositive() {
        assertEquals(256.0, calculator.power(2, 8));
    }

    @Test
    @DisplayName("raises to power zero returns one")
    void powerZero() {
        assertEquals(1.0, calculator.power(5, 0));
    }

    @Test
    @DisplayName("raises to negative power")
    void powerNegative() {
        assertEquals(0.5, calculator.power(2, -1));
    }

    // --- sqrt ---

    @Test
    @DisplayName("computes square root of a perfect square")
    void sqrtPerfectSquare() {
        assertEquals(12.0, calculator.sqrt(144));
    }

    @Test
    @DisplayName("square root of zero is zero")
    void sqrtZero() {
        assertEquals(0.0, calculator.sqrt(0));
    }

    @Test
    @DisplayName("square root of negative number throws ArithmeticException")
    void sqrtNegativeThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(-1));
    }
}
