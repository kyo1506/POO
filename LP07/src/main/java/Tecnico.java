public class Tecnico extends Superior{
    public Tecnico(double n1, double n2, double n3) {
        super(n1, n2, n3);
    }

    public Tecnico(){}

    @Override
    public double CalculaMedia() {
        return (getN1() + getN2()*2 + getN3()*2)/5;
    }
}
