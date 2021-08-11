import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseFive {
    public static void main(String[] args) {
        tabelaPlanoDeSaude();
    }

    private static void tabelaPlanoDeSaude(){
        final double TRINTA = 30d;
        final double SESSENTA = 60d;
        final double CENTO_E_VINTE = 120d;
        final double CENTO_E_CINQUENTA = 150d;
        final double DUZENTOS_E_CINQUENTA = 250d;
        final double QUATROCENTOS = 400d;

        String nome = JOptionPane.showInputDialog("Digite seu nome");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade"));

        if (idade < 10){
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + TRINTA);
        } else if (idade > 10 && idade <= 29) {
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + SESSENTA);
        } else if (idade >= 30 && idade <= 45 ) {
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + CENTO_E_VINTE);
        } else if (idade >= 46 && idade <= 59) {
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + CENTO_E_CINQUENTA);
        } else if (idade >= 60 && idade <= 65) {
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + DUZENTOS_E_CINQUENTA);
        } else {
            JOptionPane.showMessageDialog(null, nome + ", o valor a ser pago é de: R$ " + QUATROCENTOS);
        }
    }
}
