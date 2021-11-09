package view.ExerciseOne;

import javax.swing.*;

public class CalcularValores extends JFrame {
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextField txtValorUm;
    private JTextField txtValorDois;
    private JLabel lblValorUm;
    private JLabel lblValorDois;
    private JTextField txtResultado;
    private JButton btnSubtract;
    private JButton btnMultiply;
    private JButton btnSum;
    private JButton btnSplit;
    private JPanel mainPanel;

    public CalcularValores(String title) {

        super(title);

        btnSum.addActionListener(e -> {
            try{
                txtResultado.setText(txtValorUm.getText() + " + " + txtValorDois.getText() + " = " +
                        (Double.parseDouble(txtValorUm.getText()) + Double.parseDouble(txtValorDois.getText())));
            }catch (Exception ex){
                txtResultado.setText(ex.getMessage());
            }
        });

        btnSubtract.addActionListener(e -> {
            try{
                txtResultado.setText(txtValorUm.getText() + " - " + txtValorDois.getText() + " = " +
                        (Double.parseDouble(txtValorUm.getText()) - Double.parseDouble(txtValorDois.getText())));
            }catch (Exception ex){
                txtResultado.setText(ex.getMessage());
            }
        });

        btnMultiply.addActionListener(e -> {
            try{
                txtResultado.setText(txtValorUm.getText() + " * " + txtValorDois.getText() + " = " +
                        (Double.parseDouble(txtValorUm.getText()) * Double.parseDouble(txtValorDois.getText())));
            }catch (Exception ex){
                txtResultado.setText(ex.getMessage());
            }
        });

        btnSplit.addActionListener(e -> {
            try{
                txtResultado.setText(txtValorUm.getText() + " / " + txtValorDois.getText() + " = " +
                        (Double.parseDouble(txtValorUm.getText()) / Double.parseDouble(txtValorDois.getText())));
            }catch (Exception ex){
                txtResultado.setText(ex.getMessage());
            }
        });

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new CalcularValores("Calcular Valores");
        frame.setVisible(true);
    }
}
