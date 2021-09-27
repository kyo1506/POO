package ExerciseSix;

public class Empregado extends Pessoa{
    private double salario;

    public Empregado(){}
    public Empregado(double salario){this.salario = salario;}

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
