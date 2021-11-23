package view;

import controller.ProdutoController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;

public class ProdutoView extends JDialog{
    private JPanel mainPanel;
    private JTable tblProdutos;
    private JButton btnAdicionar;
    private JButton btnFechar;

    public ProdutoView(String title){
        this.setTitle(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                atualizarTabela();
            }
        });
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                ProdutoDetailsView.run((Long) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0));
            }
        });
        btnFechar.addActionListener(e -> {

            this.dispose();
        });
        btnAdicionar.addActionListener(e -> {
            ProdutoAddView.run();
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();
    }
    private void atualizarTabela(){
        tblProdutos.clearSelection();
        Object[][] convertProdutos = null;
        ProdutoController produtoController = new ProdutoController();
        var produtos = produtoController.listAll();
        if (!produtos.isEmpty()) {
            convertProdutos = new Object[produtos.size()][6];
            for (int i = 0; i < produtos.size(); i++){
                for (int j = 0; j < 6; j++){
                    switch (j){
                        case 0:
                            convertProdutos[i][j] = produtos.get(i).getId();
                            break;
                        case 1:
                            convertProdutos[i][j] = produtos.get(i).getDescricao();
                            break;
                        case 2:
                            convertProdutos[i][j] = produtos.get(i).getStatusAtivo().ordinal();
                            break;
                        case 3:
                            convertProdutos[i][j] = produtos.get(i).getPreco();
                            break;
                        case 4:
                            convertProdutos[i][j] = produtos.get(i).getQtd();
                            break;
                        case 5:
                            convertProdutos[i][j] = produtos.get(i).getDtInclusao();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        tblProdutos.setModel(new DefaultTableModel(convertProdutos, new String[]{"Id", "Descrição", "Status", "Preço", "Quantidade", "Data Inclusão"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        TableColumnModel columns = tblProdutos.getColumnModel();
        columns.getColumn(1).setMinWidth(200);
        columns.getColumn(4).setMinWidth(100);
        columns.getColumn(5).setMinWidth(140);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
        columns.getColumn(4).setCellRenderer(centerRenderer);
        columns.getColumn(5).setCellRenderer(centerRenderer);
    }
    public static ProdutoView run(){
        JDialog jDialog = new ProdutoView("Lista de Produtos");
        jDialog.setVisible(true);
        return (ProdutoView) jDialog;
    }
}
