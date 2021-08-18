import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseFive {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try
        {
            int limit = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o limite superior:", "Question", JOptionPane.QUESTION_MESSAGE));
            int increment = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor incremental:", "Question", JOptionPane.QUESTION_MESSAGE));
            List<Integer> IncrementalList = new ArrayList<>();
            int value = 0;

            while(value < limit)
            {
                IncrementalList.add(value);
                value = value + increment;
            }

            JOptionPane.showMessageDialog(null, IncrementalList, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
