import java.util.Scanner;

public class ExerciseTwo {
    public static void main(String[] args) {
        String nomePessoa;
        var input = new Scanner(System.in);
        float salarioMinimo;
        float salarioPessoa;

        System.out.println("Bem vindo!");
        System.out.print("Digite o seu nome: ");
        nomePessoa = input.nextLine();
        System.out.print("Digite o valor do salário mínimo R$: ");
        salarioMinimo = input.nextFloat();
        System.out.print("Digite o valor do seu salário: ");
        salarioPessoa = input.nextFloat();
        System.out.print("Sr(a). " + nomePessoa + " você ganha a equivalente : " + String.format("%.2f", (salarioPessoa/salarioMinimo)) + " salários mínimos.");
    }
}
