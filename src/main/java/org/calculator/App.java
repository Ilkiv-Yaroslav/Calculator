package org.calculator;

import org.calculator.controller.CalculatorController;
import org.calculator.model.CalculatorModel;
import org.calculator.view.CalculatorView;

public class App {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.processUserInput();
    }
}