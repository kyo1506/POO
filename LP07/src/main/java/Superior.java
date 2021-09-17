public class Superior {
    private double N1, N2, N3;

    public Superior(){}

    public Superior(double n1, double n2, double n3) {
        N1 = n1;
        N2 = n2;
        N3 = n3;
    }

    public double CalculaMedia(){
        return N1 * 0.35 + N2 * 0.5 + N3 * 0.15;
    }

    public double getN1() {
        return N1;
    }

    public void setN1(double n1) {
        N1 = n1;
    }

    public double getN2() {
        return N2;
    }

    public void setN2(double n2) {
        N2 = n2;
    }

    public double getN3() {
        return N3;
    }

    public void setN3(double n3) {
        N3 = n3;
    }
}
