package ExerciseThree;

import javax.swing.*;

public class CalculadoraIMC extends JFrame{
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalcular;
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JPanel mainPanel;
    private JLabel lblResultado;
    private JTextArea txtResultado;
    private JPanel topPanel;

    public CalculadoraIMC(String title) {
        super(title);

        btnCalcular.addActionListener(e -> {
            try {
                double imc = Double.parseDouble(txtPeso.getText()) / (Math.pow(Double.parseDouble(txtAltura.getText()), 2));
                if (imc < 18.5)
                    txtResultado.setText("Você está abaixo do peso ideal");
                else if (imc >= 18.5 && imc <= 24.9)
                    txtResultado.setText("Parabéns — você está em seu peso normal!");
                else if (imc >= 25.0 && imc <= 29.9)
                    txtResultado.setText("Você está acima de seu peso (sobrepeso)");
                else if (imc >= 30.0 && imc <= 34.9)
                    txtResultado.setText("Obesidade grau I");
                else if (imc >= 35.0 && imc <= 39.9)
                    txtResultado.setText("Obesidade grau II");
                else
                    txtResultado.setText("Obesidade grau III");
            }catch(Exception ex){
                txtResultado.setText(ex.getMessage());
            }
        });

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void run() {
        JFrame frame = new CalculadoraIMC("Calculadora de IMC");
        frame.setVisible(true);
    }
}
