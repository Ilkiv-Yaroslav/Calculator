package org.calculator.view;

public interface CalculatorView {
    void showResult(double result);
    void showError(String message);
    double getFirstNumber();
    double getSecondNumber();
    String getOperation();
}