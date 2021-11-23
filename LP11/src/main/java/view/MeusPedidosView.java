package view;

import javax.swing.*;

public class MeusPedidosView  extends JDialog{
    private JPanel mainPanel;
    private JTable tblPedidos;

    public MeusPedidosView(String title){
        this.setTitle(title);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.pack();
    }
    public static void run(){
        JDialog jDialog = new MeusPedidosView("Meus Pedidos");
        jDialog.setVisible(true);
    }
}
