import java.util.Scanner;
import java.util.function.Function;

public class ExerciseFour {
    public static void main(String[] args) {
        Function<Float, Float> formulaKelvin = valor -> (9 * valor+ 160)/5;
        var input = new Scanner(System.in);
        float valorCelsius;

        System.out.println("Bem vindo!");
        System.out.print("Digite o valor em Celsius: ");
        valorCelsius = input.nextFloat();
        System.out.print(valorCelsius + " °C é igual a " + formulaKelvin.apply(valorCelsius) + " K");
    }
}
