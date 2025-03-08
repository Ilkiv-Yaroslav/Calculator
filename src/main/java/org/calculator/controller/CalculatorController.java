package org.calculator.controller;

import org.calculator.model.CalculatorModel;
import org.calculator.view.CalculatorView;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        double num1 = view.getNumber();
        double num2 = view.getNumber();
        String operation = view.getOperation();

        try {
            switch (operation) {
                case "+":
                    view.showResult(model.add(num1, num2));
                    break;
                case "-":
                    view.showResult(model.subtract(num1, num2));
                    break;
                case "*":
                    view.showResult(model.multiply(num1, num2));
                    break;
                case "/":
                    view.showResult(model.divide(num1, num2));
                    break;
                default:
                    view.showError("Invalid operation");
            }
        } catch (ArithmeticException e) {
            view.showError(e.getMessage());
        }
    }
}