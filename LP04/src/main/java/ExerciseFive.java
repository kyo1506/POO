import javax.swing.*;

public class ExerciseFive {

    public static void main(String[] args){
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do primeiro número"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do segundo número"));
        mostrarMaiorValor(num1, num2);
    }

    private static void mostrarMaiorValor(int num1, int num2){
        if (num1 > num2){
            JOptionPane.showMessageDialog(null, "O número " + num1 + " é maior que o número " + num2);
        } else if (num2 > num1){
            JOptionPane.showMessageDialog(null, "O número " + num2 + " é maior que o número " + num1);
        } else {
            JOptionPane.showMessageDialog(null,  num2 + " = " + num1);
        }

        gerenciarMenu();
    }

    private static void gerenciarMenu(){
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja testar outros números?");

        if (confirm != 0){
            System.exit(0);
        } else {
            main(null);
        }
    }
}
