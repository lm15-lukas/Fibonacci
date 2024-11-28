package Fenster;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fibonacci extends JFrame {
    private JTextField calculatingArea;
    private JButton calculateButton;
    private JTextField resultArea;
    private JButton resetButton;

    public Fibonacci() {
        initUI();
    }

    private void initUI() {
        setTitle("Fibonacci Berechnung");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        createComponent();

        addComponentsToContentPane();

        setLocationAndSizeOfComponent();

        setVisible(true);
    }

    private void createComponent() {
        calculatingArea = new JTextField();
        calculateButton = new JButton("Calculate");
        resultArea = new JTextField();
        resultArea.setEditable(false);// Ergebnisfeld nicht bearbeitbar
        resetButton = new JButton("reset");
    }

    private void addComponentsToContentPane() {
        add(calculatingArea);
        add(calculateButton);
        add(resultArea);
        add(resetButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFibonacci();
            }
        });
    }

    private void setLocationAndSizeOfComponent() {
        calculatingArea.setBounds(150, 100, 200, 30);
        calculateButton.setBounds(20, 100, 100, 30);
        resultArea.setBounds(150, 200, 200, 30);
        resetButton.setBounds(20,200,100,30);
    }

    private void calculateFibonacci() {
        try {

            int n = Integer.parseInt(calculatingArea.getText());

            int result = fibonacci(n);

            resultArea.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this, "Bitte eine gültige ganze Zahl eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public void setResetButton(ActionEvent e){
        if(e.getSource() == resetButton){
            calculatingArea.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Fibonacci::new);
    }
}
