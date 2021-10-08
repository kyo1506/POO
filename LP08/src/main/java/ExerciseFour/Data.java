package ExerciseFour;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
    }
    public Data(int dia, int mes, int ano) {
        try {
            if (dia > 1 && dia <= 31)
                this.dia = dia;
            else
                this.dia = 1;

            if (mes > 1 && mes <= 12)
                this.mes = mes;
            else
                this.mes = 1;

            this.ano = ano;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String displayData(){
        return dia + "/" + mes + "/" + ano;
    }
}
