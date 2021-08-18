import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseOne {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try
        {
            int initialInterval = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número inicial do intervalo:", "Question", JOptionPane.QUESTION_MESSAGE));
            int finalInterval = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número final do intervalo:", "Question", JOptionPane.QUESTION_MESSAGE));
            int temp = initialInterval;
            List<Integer> pairNumbers = new ArrayList<>();

            if (initialInterval > finalInterval)
                JOptionPane.showMessageDialog(null, "Início do intervalo é maior do que o final!", "Error", JOptionPane.ERROR_MESSAGE);

            while(temp < finalInterval)
            {
                if (temp % 2 == 0)
                    pairNumbers.add(temp);

                temp++;
            }

            JOptionPane.showMessageDialog(null, "Número pares no intervalo de " + initialInterval + " a " + finalInterval + " = " + pairNumbers + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
