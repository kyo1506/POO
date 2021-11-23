package view.pedido;

import controller.PedidoController;
import model.bean.Pedido;
import model.bean.StatusPedido;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PedidoDetailsView extends JDialog{
    private JPanel mainPanel;
    private JComboBox cbStatusPedido;
    private JButton btnSalvar;
    private JButton btnFechar;
    private JButton btnItens;

    public PedidoDetailsView(String title, Long id, int statusPedido){
        this.setTitle(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                cbStatusPedido.addItem("Pendente");
                cbStatusPedido.addItem("Cancelado");
                cbStatusPedido.addItem("Concluído");
                cbStatusPedido.setSelectedIndex(statusPedido);
            }
        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        btnSalvar.addActionListener(e -> {
            PedidoController pedidoController = new PedidoController();
            Pedido pedido = pedidoController.getPedido(id);
            switch (cbStatusPedido.getSelectedIndex()){
                case 0:
                    pedido.setStatusPedido(StatusPedido.Pendente);
                    break;
                case 1:
                    pedido.setStatusPedido(StatusPedido.Cancelado);
                    break;
                case 2:
                    pedido.setStatusPedido(StatusPedido.Concluído);
                    break;
                default:
                    break;
            }
            if(pedidoController.updatePedido(pedido)) {
                JOptionPane.showMessageDialog(null, "Pedido atualizado com sucesso!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else
                JOptionPane.showMessageDialog(null, "Falha ao atualizar pedido!", "Error", JOptionPane.ERROR_MESSAGE);
        });
        btnItens.addActionListener(e -> {
            ItensPedidoView.run(id);
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();

    }

    public static void run(Long id, int status){
        JDialog jDialog = new PedidoDetailsView("Detalhes do pedido", id, status);
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
