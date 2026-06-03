package com.example;

/**
 * Main application entry point.
 */
public class App {

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private App() {
    }

    /**
     * Main method.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("=== Calculator Demo ===");
        System.out.printf("2 + 3       = %.1f%n", calculator.add(2, 3));
        System.out.printf("10 - 4      = %.1f%n", calculator.subtract(10, 4));
        System.out.printf("3 * 5       = %.1f%n", calculator.multiply(3, 5));
        System.out.printf("15 / 3      = %.1f%n", calculator.divide(15, 3));
        System.out.printf("2 ^ 8       = %.1f%n", calculator.power(2, 8));
        System.out.printf("sqrt(144)   = %.1f%n", calculator.sqrt(144));
    }
}
