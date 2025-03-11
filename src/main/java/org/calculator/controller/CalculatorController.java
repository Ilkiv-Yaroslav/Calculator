package org.calculator.controller;

import org.calculator.model.CalculatorModel;
import org.calculator.view.CalculatorView;
import org.calculator.view.SwingCalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        if (view instanceof SwingCalculatorView) {
            ((SwingCalculatorView) view).addCalculateListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        performCalculation();
    }

    public void performCalculation() {
        try {
            double num1 = view.getFirstNumber();
            double num2 = view.getSecondNumber();
            String operation = view.getOperation();

            double result = switch (operation) {
                case "+" -> model.add(num1, num2);
                case "-" -> model.subtract(num1, num2);
                case "*" -> model.multiply(num1, num2);
                case "/" -> model.divide(num1, num2);
                default -> throw new IllegalArgumentException("Invalid operation");
            };

            view.showResult(result);
        } catch (NumberFormatException ex) {
            view.showError("Invalid number format");
        } catch (ArithmeticException | IllegalArgumentException ex) {
            view.showError(ex.getMessage());
        }
    }
}