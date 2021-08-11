import javax.swing.*;

public class ExerciseThree {
    public static void main(String[] args) {
        String nomeProduto;
        double valorProduto;

        JOptionPane.showMessageDialog(null,"Bem vindo!","Aviso",JOptionPane.INFORMATION_MESSAGE);
        nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto: ", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        valorProduto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da compra do produto R$: ", "Aviso", JOptionPane.INFORMATION_MESSAGE));
        if(valorProduto < 20)
            JOptionPane.showMessageDialog(null,"O produto " + nomeProduto + " é menor que R$ 20. Portanto, o lucro é de 45%. Valor de venda é igual a " + (valorProduto + (valorProduto * 0.45)),"Aviso",JOptionPane.WARNING_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"O produto " + nomeProduto + " é maior que R$ 20. Portanto, o lucro é de 30%. Valor de venda é igual a " + (valorProduto + (valorProduto * 0.3)),"Aviso",JOptionPane.WARNING_MESSAGE);
    }
}
