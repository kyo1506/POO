import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.*;

public class ExerciseFour {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try
        {
            String name = JOptionPane.showInputDialog(null, "Digite o nome do aluno:", "Question", JOptionPane.QUESTION_MESSAGE);
            List<Double> notes = new ArrayList<>();
            List<Double> weights = new ArrayList<>();
            weights.add(0.35);
            weights.add(0.5);
            weights.add(0.15);

            Iterator<Double> iterator = weights.iterator();

            for(int i = 0; i < 3; i++) {
                notes.add(parseDouble(JOptionPane.showInputDialog(null, "Digite a nota de P " + (i+1) + " :", "Question", JOptionPane.QUESTION_MESSAGE)) * iterator.next());
            }

            JOptionPane.showMessageDialog(null, "O aluno " + name + ", possui a nota " + String.format("%.2f", notes.stream().mapToDouble(Double::doubleValue).sum()) + " de média final." , "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
