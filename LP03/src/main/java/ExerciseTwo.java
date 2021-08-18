import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseTwo {
    public static void main(String[] args) {
        int value1 = -1, value2 = 1, value3;
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try
        {
            int endSequence = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o limite da sequência de Fibonacci:", "Question", JOptionPane.QUESTION_MESSAGE));
            List<Integer> sequenceFibonacci = new ArrayList<>();

            for (int i = 0; i < endSequence; i++)
            {
                value3 = value1 + value2;
                value1 = value2;
                value2 = value3;
                sequenceFibonacci.add(value3);
            }

            JOptionPane.showMessageDialog(null, "Sequência de Fibonacci até o " + endSequence + " ° número = "+ sequenceFibonacci + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
