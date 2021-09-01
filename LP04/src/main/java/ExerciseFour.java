import javax.swing.*;
import java.util.function.Function;

public class ExerciseFour {
    public static void main(String[] args){
        Function<Double, Double> toRadians = degrees -> (degrees * 3.14)/180;
        JOptionPane.showMessageDialog(null, "Bem vindo", "Information" , JOptionPane.INFORMATION_MESSAGE);
        try{
            double grau = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o grau a ser convertido:", "Question", JOptionPane.QUESTION_MESSAGE));
            JOptionPane.showMessageDialog(null, "Em radianos teremos: " + String.format("%.2f", toRadians.apply(grau)), "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}