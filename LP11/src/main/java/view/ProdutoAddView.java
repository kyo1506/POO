package view;

import controller.ProdutoController;
import model.bean.Produto;
import model.bean.StatusAtivo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.math.BigDecimal;

public class ProdutoAddView extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnFechar;
    private JTextField txtDescricao;
    private JFormattedTextField txtPreco;
    private JTextField txtQtd;
    private JLabel lblDescricao;
    private JLabel lblPreco;
    private JLabel lblQtd;

    public ProdutoAddView(String title){
        super(title);
        try{new MaskFormatter("##.##").install(txtPreco);}catch(Exception ex){ex.printStackTrace();}
        btnLimpar.addActionListener(e -> {
            txtDescricao.setText(null);
            txtPreco.setText(null);
            txtQtd.setText(null);
        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        btnSalvar.addActionListener(e -> {
            ProdutoController produtoController = new ProdutoController();
            if(produtoController.insertProduto(new Produto(txtDescricao.getText(), StatusAtivo.Ativo, new BigDecimal(txtPreco.getText()), Integer.parseInt(txtQtd.getText())))) {
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Falha ao inserir produto!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.pack();
    }
    public static void run(){
        JFrame frame = new ProdutoAddView("Adicionar Produto");
        frame.setVisible(true);
    }
}
