package view.pedido;

import controller.ClienteController;
import controller.ItemController;
import controller.PedidoController;
import controller.ProdutoController;
import model.bean.Item;
import model.bean.Pedido;
import model.bean.Produto;
import model.bean.StatusPedido;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.security.Key;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class AddItensPedidoListView extends JDialog{
    private JPanel mainPanel;
    private JComboBox cmbListaProdutos;
    private JTable tblListItensAdded;
    private JTextField txtQuantidadeItens;
    private JButton btnAdicionarItem;
    private JButton btnConfirmarPedido;
    private JButton btnCancelar;

    private static int nextAddedRow = 0;
    private ProdutoController produtoController = new ProdutoController();
    private HashMap<String, Produto> produtoHashMap = new HashMap<>();
    private static HashMap<String, Integer> produtosAdicionados = new HashMap<>();
    private static Object[][] convertItens = new Object[10][10];

    public AddItensPedidoListView(){


        for (Produto produto: produtoController.listAll()){
            if (produto.getQtd() > 0){
                this.cmbListaProdutos.addItem(produto.getDescricao());
                produtoHashMap.put(produto.getDescricao(), produto);
            }
        }

        btnCancelar.addActionListener(e -> {
            if (nextAddedRow > 0){
                int message = JOptionPane.showConfirmDialog(null, "Deseja remover todos os itens?");
                if (message == 0){
                    limparTabela();
                }
            } else {
                this.dispose();
            }

        });

        btnAdicionarItem.addActionListener(e-> {

            atualizarTabela(produtoHashMap.get(
                    cmbListaProdutos.getSelectedItem()),
                    nextAddedRow,
                    Integer.parseInt(txtQuantidadeItens.getText()));

            if (!produtosAdicionados.containsKey(cmbListaProdutos.getSelectedItem().toString())){
                produtosAdicionados.put(
                        cmbListaProdutos.getSelectedItem().toString(),
                        Integer.parseInt(txtQuantidadeItens.getText())
                );
            } else {
                produtosAdicionados.put(
                        cmbListaProdutos.getSelectedItem().toString(),
                        Integer.parseInt(txtQuantidadeItens.getText()) + produtosAdicionados.get(cmbListaProdutos.getSelectedItem().toString())
                );
            }

        });

        btnConfirmarPedido.addActionListener(e -> {

        boolean isCompraOk = true;
        if (nextAddedRow > 0) {
            Pedido pedido = new Pedido(0l, new ClienteController().getById(1l), StatusPedido.Pendente, new Timestamp(System.currentTimeMillis()));
            new PedidoController().insertPedido(pedido);
            Pedido tempPedido = new PedidoController().getLastAddedPedido();

            for (String key : produtosAdicionados.keySet()){
                if (produtoHashMap.get(key).getQtd() >= produtosAdicionados.get(key)){
                    new ItemController().insertItem(
                            new Item(
                                    0l,
                                    tempPedido,
                                    produtoHashMap.get(key),
                                    produtosAdicionados.get(key), new Timestamp(System.currentTimeMillis()))
                    );

                    produtoHashMap.get(key).setQtd(produtoHashMap.get(key).getQtd() - produtosAdicionados.get(key));

                    new ProdutoController().updateProduto(produtoHashMap.get(key));

                }

                else {
                    JOptionPane.showMessageDialog(null, "Produto: " + key + " não tem quantidade suficiente em estoque! \n " +
                            "Quantidade em estoque: " + produtoHashMap.get(key).getQtd());
                    limparTabela();
                    isCompraOk = false;
                    break;
                }
            }

            if (isCompraOk){
                JOptionPane.showMessageDialog(null, "Pedido confirmado! Sua encomenda está sendo preparada.");
                limparTabela();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seu carrinho está vazio!");
        }

        });

        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();

    }

    private void atualizarTabela(Produto produto, int linha, int quantidade){

        convertItens[linha][0] = produto.getDescricao();
        convertItens[linha][1] = quantidade;
        nextAddedRow += 1;

        tblListItensAdded.setModel(new DefaultTableModel(convertItens, new String[]{"Produto", "Quantidade"}));
        TableColumnModel columns = tblListItensAdded.getColumnModel();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(0).setCellRenderer(centerRenderer);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        tblListItensAdded.setEnabled(false);
    }

    private void limparTabela(){
        DefaultTableModel dm = (DefaultTableModel)this.tblListItensAdded.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        produtosAdicionados.clear();
        tblListItensAdded.setModel(new DefaultTableModel(new Object[10][10], new String[]{"Produto", "Quantidade"}));
        convertItens = new Object[10][10];
        nextAddedRow = 0;
    }

    public static void run(){
        JDialog jDialog = new AddItensPedidoListView();
        jDialog.setVisible(true);
        jDialog.toFront();
    }

}
