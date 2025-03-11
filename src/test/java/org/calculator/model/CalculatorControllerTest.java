package org.calculator.model;

import org.calculator.controller.CalculatorController;
import org.calculator.model.CalculatorModel;
import org.calculator.view.CalculatorView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {
    @Mock
    private CalculatorModel model;

    @Mock
    private CalculatorView view;

    private CalculatorController controller;

    @Test
    void testValidAddition() {
        controller = new CalculatorController(model, view);

        when(view.getFirstNumber()).thenReturn(5.0);
        when(view.getSecondNumber()).thenReturn(3.0);
        when(view.getOperation()).thenReturn("+");
        when(model.add(5.0, 3.0)).thenReturn(8.0);

        controller.performCalculation();

        verify(view).showResult(8.0);
        verify(view, never()).showError(anyString());
    }

    @Test
    void testDivisionByZero() {
        controller = new CalculatorController(model, view);

        when(view.getFirstNumber()).thenReturn(10.0);
        when(view.getSecondNumber()).thenReturn(0.0);
        when(view.getOperation()).thenReturn("/");
        when(model.divide(10.0, 0.0)).thenThrow(new ArithmeticException("Cannot divide by zero"));

        controller.performCalculation();

        verify(view, never()).showResult(anyDouble());
        verify(view).showError("Cannot divide by zero");
    }

    @Test
    void testInvalidNumberFormat() {
        controller = new CalculatorController(model, view);

        when(view.getFirstNumber()).thenThrow(new NumberFormatException("Invalid input"));

        controller.performCalculation();

        verify(view, never()).showResult(anyDouble());
        verify(view).showError("Invalid number format");
    }

    @Test
    void testUnknownOperation() {
        controller = new CalculatorController(model, view);

        when(view.getFirstNumber()).thenReturn(5.0);
        when(view.getSecondNumber()).thenReturn(3.0);
        when(view.getOperation()).thenReturn("invalid");

        controller.performCalculation();

        verify(view, never()).showResult(anyDouble());
        verify(view).showError("Invalid operation");
    }
}