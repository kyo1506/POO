package view;

import controller.ClienteController;
import model.bean.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class LoginView extends JFrame{
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JPanel bottomPanel;
    private JButton btnEntrar;
    private JButton btnLimpar;
    private JLabel lblNovo;
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
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(txtSenha.getText().equals(cliente.getSenha())) {
                this.dispose();
                MenuView.run(cliente);
            }else{
                JOptionPane.showMessageDialog(null, "Senha incorreta!", "Advise", JOptionPane.WARNING_MESSAGE);
            }
        });
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new LoginView("Login");
        frame.setVisible(true);
    }
}
