import java.util.Scanner;

public class ExerciseOne {
    public static void main(String[] args) {
        String produto;
        var input = new Scanner(System.in);
        final float descontoProduto = 0.09F;
        float valorProduto;

        System.out.println("Bem vindo!");
        System.out.print("Digite o nome do produto: ");
        produto = input.nextLine();
        System.out.print("Digite o valor do produto R$: ");
        valorProduto = input.nextFloat();
        System.out.print("O produto " + produto + " com o desconto de 9% é obtido o valor final R$: " + valorProduto * descontoProduto);
    }
}
