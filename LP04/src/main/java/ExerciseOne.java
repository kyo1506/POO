import javax.swing.JOptionPane;
import java.util.function.Function;

public class ExerciseOne {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleNumber = integer -> integer * 2;
        try {
            int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor: ", "Input", JOptionPane.QUESTION_MESSAGE));
            JOptionPane.showMessageDialog(null, "O dobro do número " + value + " é igual a " + doubleNumber.apply(value), "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
