package view.ExerciseTwo;

import javax.swing.*;

public class AppendText extends JFrame{
    private JButton btnSeven;
    private JButton btnTwo;
    private JButton btnThree;
    private JButton btnSplit;
    private JButton btnFive;
    private JButton btnFour;
    private JButton btnSix;
    private JButton btnNine;
    private JButton btnEight;
    private JButton btnOne;
    private JButton btnHashtag;
    private JButton btnStar;
    private JButton btnZero;
    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JButton btnLimpar;
    private JTextField txtAppend;

    public AppendText(String title) {
        super(title);

        btnLimpar.addActionListener(e -> txtAppend.setText(null));
        btnOne.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "1"));
        btnTwo.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "2"));
        btnThree.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "3"));
        btnFour.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "4"));
        btnFive.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "5"));
        btnSix.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "6"));
        btnSeven.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "7"));
        btnEight.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "8"));
        btnNine.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "9"));
        btnZero.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "0"));
        btnStar.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "*"));
        btnHashtag.addActionListener(e -> txtAppend.setText(txtAppend.getText() + "#"));

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new AppendText("Teclado Telefone Digital");
        frame.setVisible(true);
    }
}
