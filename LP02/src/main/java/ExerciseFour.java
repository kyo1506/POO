import javax.swing.*;

public class ExerciseFour {
    public static void main(String[] args) {
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade: "));

        if (idade < 16){
            JOptionPane.showMessageDialog(null, "Não-eleitor!");
        } else if (idade >= 18 && idade <= 65){
            JOptionPane.showMessageDialog(null, "Eleitor Obrigatório!");
        } else {
            JOptionPane.showMessageDialog(null, "Eleitor Facultativo!");
        }
    }
}
