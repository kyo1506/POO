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
    private ProdutoView produtoView;
    private ClienteView ClienteView;

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
            ClienteView = ClienteView.run(cliente);
            ClienteController clienteController = new ClienteController();
            this.dispose();
            run(clienteController.getById(cliente.getId()));
        });

        btnProdutos.addActionListener(e -> {
            produtoView = ProdutoView.run();
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
