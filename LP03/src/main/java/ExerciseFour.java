import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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

            for(int i = 1; i < 4; i++) {
                notes.add(parseDouble(JOptionPane.showInputDialog(null, "Digite a nota de P " + i + " :", "Question", JOptionPane.QUESTION_MESSAGE)));
            }

            JOptionPane.showMessageDialog(null, "O aluno " + name + ", possui a nota " + String.format("%.2f", notes.stream().mapToDouble(Double::doubleValue).sum() / 3) + " de média final." , "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
