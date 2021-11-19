package view;

import model.bean.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuView extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton btnConfig;
    private JButton btnSair;
    private JButton btnProdutos;
    private JButton btnPedidos;
    private JLabel lblEnter;

    public MenuView(String title, Cliente cliente) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                if (cliente.getTipoUsuario().ordinal() == 0)
                    btnProdutos.setVisible(false);
                lblEnter.setText("Bem vindo, Sr(a). " + cliente.getNome());
            }
        });

        btnConfig.addActionListener(e -> {
            ClienteView.run(cliente);
        });

        btnProdutos.addActionListener(e -> {
            ProdutoView.run();
        });

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.pack();
    }

    public static void run(Cliente cliente){
        JFrame frame = new MenuView("Menu Principal", cliente);
        frame.setVisible(true);
    }
}
