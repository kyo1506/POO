import ExerciseOne.CalcularValores;
import ExerciseThree.CalcularICMS;
import ExerciseTwo.AppendText;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("../src/images/relogio.png");
        String options[] = {"Exercício Um", "Exercício Dois", "Exercício Três"};
        int i = JOptionPane.showOptionDialog(null,
                "Escolha uma opção de exercício",
                "Lista 10",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                options,
                options[0]);

        switch (i){
            case 0:
                CalcularValores.run();
                break;
            case 1:
                AppendText.run();
                break;
            case 2:
                CalcularICMS.run();
                break;
            default:
                break;
        }
    }
}
