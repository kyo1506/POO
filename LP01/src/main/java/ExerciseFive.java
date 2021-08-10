import java.util.Scanner;
import java.util.function.BiFunction;

public class ExerciseFive {
    public static void main(String[] args) {

        BiFunction<Double, Double, Double> volumeCilindro = (raio, altura) -> 3.14159 * Math.pow(raio, 2) * altura;
        var input = new Scanner(System.in);
        double alturaCilindro, raioCilindro;

        System.out.println("Bem vindo!");
        System.out.print("Digite a altura do cilindro em cm: ");
        alturaCilindro = input.nextDouble();

        System.out.print("Digite o raio do cilindro em cm: ");
        raioCilindro = input.nextDouble();

        System.out.print("O volume do cilindro de raio igual a " + raioCilindro + " cm e altura " + alturaCilindro + " cm, é igual a " + String.format("%.2f",volumeCilindro.apply(raioCilindro, alturaCilindro)) + " cm³.");
    }
}
