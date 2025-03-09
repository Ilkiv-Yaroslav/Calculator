package org.calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingCalculatorView extends JFrame implements CalculatorView {
    private JTextField firstNumberField = new JTextField(10);
    private JTextField secondNumberField = new JTextField(10);
    private JComboBox<String> operationCombo = new JComboBox<>(new String[]{"+", "-", "*", "/"});
    private JButton calculateButton = new JButton("Calculate");
    private JTextArea resultArea = new JTextArea(5, 20);

    public SwingCalculatorView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("First Number:"));
        inputPanel.add(firstNumberField);
        inputPanel.add(new JLabel("Second Number:"));
        inputPanel.add(secondNumberField);
        inputPanel.add(new JLabel("Operation:"));
        inputPanel.add(operationCombo);
        inputPanel.add(calculateButton);

        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addCalculateListener(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }

    @Override
    public double getFirstNumber() {
        return Double.parseDouble(firstNumberField.getText());
    }

    @Override
    public double getSecondNumber() {
        return Double.parseDouble(secondNumberField.getText());
    }

    @Override
    public String getOperation() {
        return (String) operationCombo.getSelectedItem();
    }

    @Override
    public void showResult(double result) {
        resultArea.append("Result: " + result + "\n");
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}