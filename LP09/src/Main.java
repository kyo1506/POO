import ExerciseOne.Calculadora;
import ExerciseThree.CalculadoraIMC;
import ExerciseTwo.Convertor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("../src/images/relogio.png");
        String options[] = {"Exercício Um", "Exercício Dois", "Exercício Três"};
        int i = JOptionPane.showOptionDialog(null,
                "Escolha uma opção de exercício",
                "Lista 9",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                options,
                options[0]);

        switch (i){
            case 0:
                Calculadora.run();
                break;
            case 1:
                Convertor.run();
                break;
            case 2:
                CalculadoraIMC.run();
                break;
            default:
                break;
        }
    }
}
