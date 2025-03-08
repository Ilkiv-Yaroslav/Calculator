package org.calculator.view;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner = new Scanner(System.in);

    public void showResult(double result) {
        System.out.println("Result: " + result);
    }

    public double getNumber() {
        System.out.print("Enter number: ");
        return scanner.nextDouble();
    }

    public String getOperation() {
        System.out.print("Enter operation (+, -, *, /): ");
        return scanner.next();
    }

    public void showError(String message) {
        System.err.println("Error: " + message);
    }
}