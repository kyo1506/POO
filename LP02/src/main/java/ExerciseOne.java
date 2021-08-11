import javax.swing.*;

public class ExerciseOne {
    public static void main(String[] args) {
        verificaMultiploDeTres();
    }

    private static void verificaMultiploDeTres(){
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para saber se é múltiplo de 3"));

        if (numero % 3 == 0)
            JOptionPane.showMessageDialog(null, "O número " + numero + " é múltiplo de 3");
        else
            JOptionPane.showMessageDialog(null, "O número " + numero + " não é múltiplo de 3");
    }
}
