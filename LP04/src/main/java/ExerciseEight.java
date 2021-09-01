import javax.swing.*;
import java.util.function.Function;

public class ExerciseEight {
    public static void main(String[] args) {
        Function<Integer, String> verifyPrimeNumber = primeNumber -> {
            int count = 1, validateNumber = 0;
            while(primeNumber >= count)
            {
                if(primeNumber % count == 0)
                    validateNumber++;

                count++;
            }

            if (validateNumber == 2)
                return "O número " + primeNumber + " é um número primo.";
            else
                return "O número " + primeNumber + " não é um número primo.";
        };

        try{
            JOptionPane.showMessageDialog(null, verifyPrimeNumber.apply(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor: ", "Input", JOptionPane.QUESTION_MESSAGE))), "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
