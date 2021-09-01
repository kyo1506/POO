import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class ExerciseThree {
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Bem vindo", "Information" , JOptionPane.INFORMATION_MESSAGE);
        try{
            List<Double> valor = new ArrayList<>();
            for(int i = 0; i < 2; i++) {
                valor.add(parseDouble(JOptionPane.showInputDialog(null, "Digite o valor " + (i+1) + " :", "Question", JOptionPane.QUESTION_MESSAGE)));
            }
            JOptionPane.showMessageDialog(null, "A media dos valores eh " + valor.stream().mapToDouble(Double::doubleValue).reduce(1.0, (a, b) -> a * b), "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

