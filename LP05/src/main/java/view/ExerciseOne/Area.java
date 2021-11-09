package view.ExerciseOne;

import javax.swing.*;

public class Area {
    public static void main(String[] args){
        double bas, alt;
        JOptionPane.showMessageDialog(null, "Bem vindo!","Information", JOptionPane.INFORMATION_MESSAGE);

        try{
            String ba = JOptionPane.showInputDialog(null, "Informe a base do triangulo: ", "Question", JOptionPane.QUESTION_MESSAGE);
            String al = JOptionPane.showInputDialog(null, "Informe a altura do triangulo: ", "Question", JOptionPane.QUESTION_MESSAGE);
            bas = Double.parseDouble(ba);
            alt = Double.parseDouble(al);
            Triangulo triangulo = new Triangulo(bas, alt);
            JOptionPane.showMessageDialog(null, "A area do triangulo eh igual a " + triangulo.getArea());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
