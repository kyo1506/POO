import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Superior superior = new Superior();
        Tecnico tecnico = new Tecnico();

        try {
            superior.setN1(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da P1", "")));
            superior.setN2(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da P2", "")));
            superior.setN3(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da P3", "")));

            tecnico.setN1(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da nota do 1° Trimestre", "")));
            tecnico.setN2(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da nota do 1° Trimestre", "")));
            tecnico.setN3(Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor da nota do 1° Trimestre", "")));

            JOptionPane.showMessageDialog(null, "A média das notas de P1: " + superior.getN1() + ", P2: " + superior.getN2() + " e Trabalhos: " + superior.getN3() + " é " + superior.CalculaMedia() + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "A média das notas do 1° Trimestre: " + tecnico.getN1() + ", 2° Trimestre: " + tecnico.getN2() + " e 3° Trimestre: " + tecnico.getN3() + " é " + tecnico.CalculaMedia() + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
