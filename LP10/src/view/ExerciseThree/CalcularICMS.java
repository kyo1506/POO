package view.ExerciseThree;

import javax.swing.*;

public class CalcularICMS extends JFrame{
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextField txtValor;
    private JTextField txtICMS;
    private JTextField txtIPI;
    private JTextField txtTotal;
    private JButton btnCalcular;
    private JButton btnLimpar;
    private JLabel lblValor;
    private JLabel lblTotal;
    private JLabel lblIPI;
    private JLabel lblICMS;
    private JPanel mainPanel;

    public CalcularICMS(String title) {
        super(title);

        btnCalcular.addActionListener(e -> {
            try{
                txtICMS.setText(String.valueOf(Double.parseDouble(txtValor.getText()) * 0.18));
                txtIPI.setText(String.valueOf(Double.parseDouble(txtValor.getText()) * 0.05));
                txtTotal.setText(String.valueOf(Double.parseDouble(txtValor.getText()) + Double.parseDouble(txtICMS.getText()) + Double.parseDouble(txtIPI.getText())));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLimpar.addActionListener(e -> {
            txtValor.setText(null);
            txtICMS.setText(null);
            txtIPI.setText(null);
            txtTotal.setText(null);
        });

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new CalcularICMS("Calculadora ICMS");
        frame.setVisible(true);
    }
}
