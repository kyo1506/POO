package view.pedido;

import controller.ItemController;
import controller.PedidoController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItensPedidoView extends JDialog {
    private JPanel mainPanel;
    private JTable tblItens;
    private JButton btnFechar;

    public ItensPedidoView(String title, Long id){
        this.setTitle(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                atualizarTabela(id);
            }
        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();

    }

    private void atualizarTabela(Long id){
        tblItens.clearSelection();
        Object[][] convertItens = null;
        ItemController itemController = new ItemController();
        var itens = itemController.listAll(id);
        if (!itens.isEmpty()) {
            convertItens = new Object[itens.size()][6];
            for (int i = 0; i < itens.size(); i++){
                for (int j = 0; j < 6; j++){
                    switch (j){
                        case 0:
                            convertItens[i][j] = itens.get(i).getId();
                            break;
                        case 1:
                            convertItens[i][j] = itens.get(i).getPedido().getId();
                            break;
                        case 2:
                            convertItens[i][j] = itens.get(i).getProduto().getId();
                            break;
                        case 3:
                            convertItens[i][j] = itens.get(i).getProduto().getPreco();
                            break;
                        case 4:
                            convertItens[i][j] = itens.get(i).getQuantidade();
                            break;
                        case 5:
                            convertItens[i][j] = itens.get(i).getDtInclusao();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        tblItens.setModel(new DefaultTableModel(convertItens, new String[]{"Id", "Pedido", "Produto", "Preço", "Qtd", "Data Inclusão"}));
        TableColumnModel columns = tblItens.getColumnModel();
        columns.getColumn(5).setMinWidth(140);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
        columns.getColumn(5).setCellRenderer(centerRenderer);
        tblItens.setEnabled(false);
    }

    public static void run(Long id){
        JDialog jDialog = new ItensPedidoView("Lista de itens", id);
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
