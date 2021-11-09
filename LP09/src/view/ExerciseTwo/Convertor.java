package view.ExerciseTwo;

import javax.swing.*;

public class Convertor extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JRadioButton rbEuro;
    private JRadioButton rbDolar;
    private JRadioButton rbLibra;
    private JTextField txtValor;
    private JButton btnConverter;
    private JTextField txtResult;
    private JLabel lblResult;

    public Convertor(String title){
        super(title);

        btnConverter.addActionListener(e -> {
            try{
                if(rbEuro.isSelected())
                    txtResult.setText("€ " + Double.parseDouble(txtValor.getText()) * 6.35);
                else if (rbDolar.isSelected())
                    txtResult.setText("U$ " + Double.parseDouble(txtValor.getText()) * 5.5);
                else if(rbLibra.isSelected())
                    txtResult.setText("£ " + Double.parseDouble(txtValor.getText()) * 7.48);
            }catch (Exception ex){
                txtResult.setText(ex.getMessage());
            }
        });

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new Convertor("Convertor de dinheiro");
        frame.setVisible(true);
    }
}
