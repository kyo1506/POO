package view;

import controller.ClienteController;
import model.bean.Cliente;

import javax.swing.*;
import java.util.Optional;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel bottomPanel;
    private JButton btnEntrar;
    private JButton btnLimpar;
    private JLabel lblReset;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JLabel lblEmail;
    private JLabel lblSenha;

    public LoginView(String title) {
        super(title);

        btnLimpar.addActionListener(e -> {
            txtEmail.setText(null);
            txtSenha.setText(null);
        });

        btnEntrar.addActionListener(e -> {
            ClienteController clienteController = new ClienteController();
            Cliente cliente = clienteController.getByEmail(txtEmail.getText());
            if (txtSenha.getPassword().equals(cliente.getSenha().toCharArray()));
            {
                JOptionPane.showMessageDialog(null, "Logado com sucesso!", "CU", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new LoginView("Login");
        frame.setVisible(true);
    }
}
