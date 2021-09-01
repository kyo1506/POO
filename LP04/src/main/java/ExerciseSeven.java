import javax.swing.*;
import java.util.function.Function;

public class ExerciseSeven {
    public static void main(String[] args) {
        Function<Integer, String> numberFactorial = number ->
        {
            int factorial = 1;
            StringBuilder factorialSequence = new StringBuilder();
            for(int i = number; i >= 1; i--)
            {
                if (i == number)
                    factorialSequence.append(i).append(" = ").append(i);
                else
                    factorialSequence.append(" x ").append(i);
                factorial *= i;
            }

            return factorialSequence.append(" = ").append(factorial).toString();
        };

        try {
            JOptionPane.showMessageDialog(null, numberFactorial.apply(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor: ", "Input", JOptionPane.QUESTION_MESSAGE))), "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
