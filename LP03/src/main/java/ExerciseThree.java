import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseThree {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try
        {
            int initialInterval = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número inicial do intervalo:", "Question", JOptionPane.QUESTION_MESSAGE));
            int finalInterval = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número final do intervalo:", "Question", JOptionPane.QUESTION_MESSAGE));
            int temp = initialInterval;
            int contador = 1;
            List<Integer> cousinPrimeNumbers = new ArrayList<>();

            if (initialInterval > finalInterval)
                JOptionPane.showMessageDialog(null, "Início do intervalo é maior do que o final!", "Error", JOptionPane.ERROR_MESSAGE);

            while(temp < finalInterval)
            {
                contador = 1;
                int validateNumber = 0;

                while(temp >= contador)
                {
                    if (temp % contador == 0)
                        validateNumber++;

                    contador++;
                }

                if(validateNumber == 2)
                    cousinPrimeNumbers.add(temp);

                temp++;
            }

            JOptionPane.showMessageDialog(null, "Número primos no intervalo de " + initialInterval + " a " + finalInterval + " = " + cousinPrimeNumbers + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

