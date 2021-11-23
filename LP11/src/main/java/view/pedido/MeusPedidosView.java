package view.pedido;

import controller.PedidoController;
import controller.ProdutoController;
import view.produto.ProdutoDetailsView;
import view.produto.ProdutoView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MeusPedidosView  extends JDialog{
    private JPanel mainPanel;
    private JTable tblPedidos;
    private JButton btnFechar;
    private JButton btnAdicionar;

    public MeusPedidosView(String title, Long id){
        this.setTitle(title);
        btnAdicionar.addActionListener(e -> {

        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                atualizarTabela(id);
            }
        });
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                PedidoDetailsView.run((Long) tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0), (Integer) tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 2));
                dispose();
                MeusPedidosView.run(id);
            }
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();
    }

    private void atualizarTabela(Long id){
        tblPedidos.clearSelection();
        Object[][] convertPedidos = null;
        PedidoController pedidoController = new PedidoController();
        var pedidos = pedidoController.getById(id);
        if (!pedidos.isEmpty()) {
            convertPedidos = new Object[pedidos.size()][4];
            for (int i = 0; i < pedidos.size(); i++){
                for (int j = 0; j < 4; j++){
                    switch (j){
                        case 0:
                            convertPedidos[i][j] = pedidos.get(i).getId();
                            break;
                        case 1:
                            convertPedidos[i][j] = pedidos.get(i).getCliente().getId();
                            break;
                        case 2:
                            convertPedidos[i][j] = pedidos.get(i).getStatusPedido().ordinal();
                            break;
                        case 3:
                            convertPedidos[i][j] = pedidos.get(i).getDtInclusao();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        tblPedidos.setModel(new DefaultTableModel(convertPedidos, new String[]{"Id", "Cliente", "Status", "Data Inclusão"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        TableColumnModel columns = tblPedidos.getColumnModel();
        columns.getColumn(3).setMinWidth(140);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
    }
    public static void run(Long id){
        JDialog jDialog = new MeusPedidosView("Meus Pedidos", id);
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
