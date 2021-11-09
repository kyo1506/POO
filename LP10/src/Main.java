import view.ExerciseOne.CalcularValores;
import view.ExerciseThree.CalcularICMS;
import view.ExerciseTwo.AppendText;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("../src/images/relogio.png");
        String[] options = {"Exercício Um", "Exercício Dois", "Exercício Três"};
        int i = JOptionPane.showOptionDialog(null,
                "Escolha uma opção de exercício",
                "Lista 10",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                options,
                options[0]);

        switch (i) {
            case 0 -> CalcularValores.run();
            case 1 -> AppendText.run();
            case 2 -> CalcularICMS.run();
            default -> {
            }
        }
    }
}
