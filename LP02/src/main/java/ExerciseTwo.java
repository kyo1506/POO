import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseTwo {
    public static void main(String[] args) {
        organizaNumerosEmOrdemCrescente(3);
    }

    private static void organizaNumerosEmOrdemCrescente(int qtdInput){
        List<Integer> arrInput = new ArrayList<>();
        for (int i = 0; i < qtdInput; i++){
            arrInput.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número.")));
        }

        Collections.sort(arrInput);
        JOptionPane.showMessageDialog(null, "Números ordenados: " + arrInput);
    }
}
