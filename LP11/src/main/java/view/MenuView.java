package view;

import controller.ClienteController;
import model.bean.Cliente;

import javax.swing.*;
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
            ClienteController clienteController = new ClienteController();
            this.dispose();
            run(clienteController.getById(cliente.getId()));
        });

        btnProdutos.addActionListener(e -> {
            ProdutoView.run();
        });

        btnSair.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(null, "Deseja sair?", "Aviso", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Obrigado por usar nosso programa!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        });

        btnPedidos.addActionListener(e -> {
            PedidoView.run();
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
