package org.calculator;

import org.calculator.controller.CalculatorController;
import org.calculator.model.CalculatorModel;
import org.calculator.view.SwingCalculatorView;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();
            SwingCalculatorView view = new SwingCalculatorView();
            new CalculatorController(model, view);
        });
    }
}