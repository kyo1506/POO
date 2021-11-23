package view;

import controller.ClienteController;
import model.bean.Cliente;
import model.bean.TipoUsuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;

public class ClienteView extends JDialog{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JTextField txtId;
    private JButton btnAtualizar;
    private JButton btnFechar;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JComboBox cbTipoUsuario;
    private JPasswordField txtSenha;
    private JTextField txtEndereco;
    private JTextField txtBairro;
    private JTextField txtCidade;
    private JFormattedTextField txtCep;
    private JFormattedTextField txtUF;
    private JFormattedTextField txtTelefone;
    private JFormattedTextField txtCelular;
    private JLabel lblId;
    private JLabel lblTipoUsuario;
    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblSenha;
    private JLabel lblEndereco;
    private JLabel lblBairro;
    private JLabel lblCidade;
    private JLabel lblCep;
    private JLabel lblUF;
    private JButton btnAtivo;
    private JLabel lblTelefone;
    private JLabel lblCelular;

    public ClienteView(String title, Cliente cliente){
        this.setTitle(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try{
                    new MaskFormatter("#####-###").install(txtCep);
                    MaskFormatter ufMask = new MaskFormatter("**");
                    ufMask.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                    ufMask.install(txtUF);
                    new MaskFormatter("(##)####-####").install(txtTelefone);
                    new MaskFormatter("(##)#####-####").install(txtCelular);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Erro ao formatar campos!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                txtId.setText(cliente.getId().toString());
                txtNome.setText(cliente.getNome());
                txtEmail.setText(cliente.getEmail());
                cbTipoUsuario.addItem("Cliente");
                cbTipoUsuario.addItem("Administrador");
                if (cliente.getTipoUsuario().ordinal() == 0)
                    cbTipoUsuario.setSelectedIndex(0);
                else
                    cbTipoUsuario.setSelectedIndex(1);
                txtSenha.setText(cliente.getSenha());
                txtEndereco.setText(cliente.getEndereco());
                txtBairro.setText(cliente.getBairro());
                txtCidade.setText(cliente.getCidade());
                txtCep.setText(cliente.getCep());
                txtUF.setText(cliente.getUf());
                txtTelefone.setText(cliente.getTelefone());
                txtCelular.setText(cliente.getCelular());
            }
        });
        btnAtualizar.addActionListener(e -> {
            ClienteController clienteController = new ClienteController();
            Cliente clienteNovo = clienteController.getById(cliente.getId());
            clienteNovo.setNome(txtNome.getText());
            clienteNovo.setEmail(txtEmail.getText());
            if (cbTipoUsuario.getSelectedIndex() == 0)
                clienteNovo.setTipoUsuario(TipoUsuario.Cliente);
            else
                clienteNovo.setTipoUsuario(TipoUsuario.Administrador);
            clienteNovo.setSenha(txtSenha.getText());
            clienteNovo.setEndereco(txtEndereco.getText());
            clienteNovo.setBairro(txtBairro.getText());
            clienteNovo.setCidade(txtCidade.getText());
            clienteNovo.setCep(txtCep.getText());
            clienteNovo.setUf(txtUF.getText());
            clienteNovo.setTelefone(txtTelefone.getText());
            clienteNovo.setCelular(txtCelular.getText());
            if(clienteController.updateCliente(clienteNovo)) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else
                JOptionPane.showMessageDialog(null, "Falha ao atualizar cliente!", "Error", JOptionPane.ERROR_MESSAGE);
        });
        btnFechar.addActionListener(e -> {
            this.dispose();
        });
        txtUF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (txtUF.getText().length() >= 2)
                    e.consume();
                else {
                    int position = txtUF.getCaretPosition();
                    txtUF.setText(txtUF.getText().toUpperCase());
                    txtUF.setCaretPosition(position);
                }
            }
        });
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(false);
        this.setModal(true);
        this.pack();
    }

    public static ClienteView run(Cliente cliente){
        JDialog jDialog = new ClienteView("Atualizar Cliente", cliente);
        jDialog.setVisible(true);
        return (ClienteView) jDialog;
    }
}
