package org.calculator.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {
    private final CalculatorModel calculator = new CalculatorModel();
    private static final double DELTA = 0.0001;

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "-5, 3, -2",
            "0, 0, 0",
            "1.5, 2.5, 4.0",
            "999999, 1, 1000000"
    })
    void testAdd(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "3, 5, -2",
            "0, 0, 0",
            "10.5, 2.5, 8.0",
            "-5, -3, -2"
    })
    void testSubtract(double a, double b, double expected) {
        assertEquals(expected, calculator.subtract(a, b), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "-5, 3, -15",
            "0, 5, 0",
            "1.5, 4, 6.0",
            "100000, 100000, 10000000000"
    })
    void testMultiply(double a, double b, double expected) {
        assertEquals(expected, calculator.multiply(a, b), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "5, 2, 2.5",
            "0, 5, 0",
            "10, 4, 2.5",
            "-15, 3, -5"
    })
    void testDivideValid(double a, double b, double expected) {
        assertEquals(expected, calculator.divide(a, b), DELTA);
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testDivideZeroByNumber() {
        assertEquals(0, calculator.divide(0, 5), DELTA);
    }

    @Test
    void testExtremeValues() {
        double max = Double.MAX_VALUE;
        assertEquals(max * 2, calculator.add(max, max), DELTA);
        assertEquals(0, calculator.subtract(max, max), DELTA);
    }
}