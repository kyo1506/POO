package view;

import javax.swing.*;

public class PedidoView extends JDialog{
    private JPanel mainPanel;
    private JButton btnNovoPedido;
    private JButton btnMeusPedidos;
    private JButton btnFechar;

    public PedidoView(String title){
        this.setTitle(title);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();
    }
    public static void run(){
        JDialog jDialog = new PedidoView("Lista de Pedidos");
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
