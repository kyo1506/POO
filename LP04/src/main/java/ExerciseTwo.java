import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExerciseTwo {
    public static void main(String[] args) {
        Function<List<Double>, Double> arithmeticAverage = listDouble -> listDouble.stream().mapToDouble(Double::doubleValue).sum()/ (long) listDouble.size();

        try {
            List<Double> notes = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                notes.add(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota " + (i + 1) + " :", "Input", JOptionPane.QUESTION_MESSAGE)));
            }

            JOptionPane.showMessageDialog(null, "A média aritmética das notas " + notes + " é igual a " + arithmeticAverage.apply(notes), "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
