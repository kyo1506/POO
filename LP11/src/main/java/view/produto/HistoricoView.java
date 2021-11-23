package view.produto;

import controller.HistoricoController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;

public class HistoricoView extends JDialog{
    private JPanel mainPanel;
    private JTable tblHistorico;
    private JButton btnFechar;

    public HistoricoView(String title, Long id){
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
        tblHistorico.clearSelection();
        Object[][] convertHistorico = null;
        HistoricoController historicoController = new HistoricoController();
        var historicoList = historicoController.getById(id);
        if (!historicoList.isEmpty()) {
            convertHistorico = new Object[historicoList.size()][6];
            for (int i = 0; i < historicoList.size(); i++){
                for (int j = 0; j < 6; j++){
                    switch (j){
                        case 0:
                            convertHistorico[i][j] = historicoList.get(i).getId();
                            break;
                        case 1:
                            convertHistorico[i][j] = historicoList.get(i).getProduto().getId();
                            break;
                        case 2:
                            convertHistorico[i][j] = historicoList.get(i).getStatusHistorico().ordinal();
                            break;
                        case 3:
                            convertHistorico[i][j] = historicoList.get(i).getQtdSolicitada();
                            break;
                        case 4:
                            convertHistorico[i][j] = historicoList.get(i).getQtdAtual();
                            break;
                        case 5:
                            convertHistorico[i][j] = historicoList.get(i).getDtInclusao();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        tblHistorico.setModel(new DefaultTableModel(convertHistorico, new String[]{"Id", "Produto", "Status", "Qtd. Solicitada", "Qtd. Atual", "Data Inclusão"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        TableColumnModel columns = tblHistorico.getColumnModel();
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
    public static void run(Long id){
        JDialog jDialog = new HistoricoView("Histórico do Produto", id);
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
