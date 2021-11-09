package view.ExerciseTwo;

import javax.swing.*;

public class Equacao {
    private int a, b , c;

    public Equacao(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Equacao(){}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public void calcularRaiz(){
        double delta = Math.pow(b,2) - (4 * a * c);
        double rdelta = Math.sqrt(delta);
        double R1 = (-b + rdelta)/(2*a);
        double R2 = (-b - rdelta)/(2*a);
        if (delta == 0){
            JOptionPane.showMessageDialog(null, "As raizes sao iguais: " + R1);
        } else if (delta < 0){
            JOptionPane.showMessageDialog(null, "Nao existem raizes reais");
        } else {
            JOptionPane.showMessageDialog(null, "A raiz R1 e igual a: " + R1 + "\nA raiz R2 e igual a: " + R2);
        }
    }
    public void definirValores(){
        a = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de a: "));
        b = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de b: "));
        c = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor de c: "));
    }

}
