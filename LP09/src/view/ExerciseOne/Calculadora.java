package view.ExerciseOne;

import javax.swing.*;

public class Calculadora extends JFrame{
    private JPanel topPanel;
    private JButton btnSeven;
    private JButton btnEight;
    private JButton btnNine;
    private JButton btnFive;
    private JButton btnFour;
    private JButton btnSix;
    private JButton btnThree;
    private JButton btnTwo;
    private JButton btnOne;
    private JButton btnEquals;
    private JButton btnDot;
    private JButton btnZero;
    private JButton btnMultiply;
    private JButton btnSum;
    private JButton btnSubtract;
    private JButton btnSplit;
    private JPanel bottomPanel;
    private JPanel mainPanel;

    public Calculadora(String title) {
        super(title);

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new Calculadora("Calculadora");
        frame.setVisible(true);
    }
}
