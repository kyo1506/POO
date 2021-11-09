import view.ExerciseThree.CalcularICMS;
import controller.ClienteController;

public class Main {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        System.out.println(clienteController.listAll());
        CalcularICMS.run();
    }
}
