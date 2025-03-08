package org.calculator.model;

public class CalculatorModel {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
        return num1 / num2;
    }
}