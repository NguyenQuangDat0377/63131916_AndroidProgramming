package ntu.a63131916;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public interface ActionListener {
    private JFrame frame;
    private JLabel labelHeight, labelWeight, labelResult;
    private JTextField textFieldHeight, textFieldWeight;
    private JButton buttonCalculate;

    public TinhchisoBMI() {
        frame = new JFrame("BMI Calculator");
        frame.setLayout(new GridLayout(4, 2));

        labelHeight = new JLabel("Height (m): ");
        textFieldHeight = new JTextField();
        frame.add(labelHeight);
        frame.add(textFieldHeight);

        labelWeight = new JLabel("Weight (kg): ");
        textFieldWeight = new JTextField();
        frame.add(labelWeight);
        frame.add(textFieldWeight);

        buttonCalculate = new JButton("Calculate");
        buttonCalculate.addActionListener(this);
        frame.add(buttonCalculate);

        labelResult = new JLabel();
        frame.add(labelResult);

        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCalculate) {
            try {
                double height = Double.parseDouble(textFieldHeight.getText());
                double weight = Double.parseDouble(textFieldWeight.getText());
                
                double bmi = calculateBMI(height, weight);
                String result = String.format("Your BMI is: %.2f", bmi);
                labelResult.setText(result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numbers for height and weight.");
            }
        }
    }

    private double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TinhchisoBMI();
            }
        });
    }
}
