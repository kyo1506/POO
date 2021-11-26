package view.produto;

import controller.HistoricoController;
import controller.ProdutoController;
import model.bean.Historico;
import model.bean.Produto;
import model.bean.StatusAtivo;
import model.bean.StatusHistorico;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.text.ParseException;

public class ProdutoDetailsView extends JDialog{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton btnAtualizar;
    private JButton btnFechar;
    private JTextField txtId;
    private JTextField txtDescricao;
    private JComboBox cbStatus;
    private JFormattedTextField txtPreco;
    private JTextField txtQtd;
    private JLabel lblId;
    private JLabel lblDescricao;
    private JLabel lblStatus;
    private JLabel lblPreco;
    private JLabel lblQtd;
    private JButton btnHistorico;
    private JRadioButton rbAdicao;
    private JRadioButton rbRemover;

    public ProdutoDetailsView(String title, Long id){
        this.setTitle(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.getById(id);
                txtId.setText(produto.getId().toString());
                txtDescricao.setText(produto.getDescricao());
                cbStatus.addItem("Inativo");
                cbStatus.addItem("Ativo");
                cbStatus.setSelectedIndex(produto.getStatusAtivo().ordinal());
                try {new MaskFormatter("##.##").install(txtPreco);} catch (ParseException ex) {ex.printStackTrace();}
                txtPreco.setText(produto.getPreco().toString());
                txtQtd.setText(produto.getQtd().toString());
            }
        });
        btnAtualizar.addActionListener(e -> {
            ProdutoController produtoController = new ProdutoController();
            HistoricoController historicoController = new HistoricoController();
            Produto novoProduto = produtoController.getById(Long.parseLong(txtId.getText()));
            novoProduto.setDescricao(txtDescricao.getText());
            if (cbStatus.getSelectedIndex() == 0)
                novoProduto.setStatusAtivo(StatusAtivo.Inativo);
            else
                novoProduto.setStatusAtivo(StatusAtivo.Ativo);
            novoProduto.setPreco(new BigDecimal(txtPreco.getText()));
            Integer qtdAtual = novoProduto.getQtd();
            if (rbAdicao.isSelected()) {
                novoProduto.setQtd(Integer.parseInt(txtQtd.getText()) + qtdAtual);
                atualizarProduto(produtoController, novoProduto);
                historicoController.insertHistorico(new Historico(novoProduto, novoProduto.getQtd(), qtdAtual, StatusHistorico.Adição));
                this.dispose();
            }else {
                if (qtdAtual - (Integer.parseInt(txtQtd.getText())) < 0)
                    JOptionPane.showMessageDialog(null, "A quantidade subtraída(" + txtQtd.getText() + ") é maior do que o estoque(" + qtdAtual + ")!", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    novoProduto.setQtd(qtdAtual - Integer.parseInt(txtQtd.getText()));
                    atualizarProduto(produtoController, novoProduto);
                    historicoController.insertHistorico(new Historico(novoProduto, novoProduto.getQtd(), qtdAtual, StatusHistorico.Exclusão));
                    this.dispose();
                }
            }
        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        btnHistorico.addActionListener(e -> {
            HistoricoView.run(id);
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();
    }

    private void atualizarProduto(ProdutoController produtoController, Produto produto){
        if (produtoController.updateProduto(produto))
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "Information", JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Falha ao atualizar produto!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void run(Long id){
        JDialog jDialog = new ProdutoDetailsView("Detalhes do Produto", id);
        jDialog.setVisible(true);
        jDialog.toFront();
    }
}
