import java.util.Scanner;

public class ExerciseThree {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        float primeiroValor, segundoValor;

        System.out.println("Bem vindo!");
        System.out.print("Digite o primeiro valor: ");
        primeiroValor = input.nextFloat();
        System.out.print("Digite o segundo valor: ");
        segundoValor = input.nextFloat();
        System.out.print("A média entre " + primeiroValor + " e " + segundoValor + " é " + ((primeiroValor + segundoValor)/2));
    }
}
