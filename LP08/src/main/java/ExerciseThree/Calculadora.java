package ExerciseThree;

public class Calculadora {
    private Double valorUm;
    private Double valorDois;
    private String operacao;
    private String message;

    public Calculadora() {
    }
    public Calculadora(Double valorUm, Double valorDois, String operacao) {
        this.valorUm = valorUm;
        this.valorDois = valorDois;
        this.operacao = operacao;
    }

    public Double getValorUm() {
        return valorUm;
    }
    public void setValorUm(Double valorUm) {
        this.valorUm = valorUm;
    }
    public Double getValorDois() {
        return valorDois;
    }
    public void setValorDois(Double valorDois) {
        this.valorDois = valorDois;
    }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String calculaValor(){
        switch (operacao) {
            case "+":
                message = "A soma dos valores " + valorUm + " e " + valorDois + " é igual a " + (valorUm + valorDois);
                break;
            case "-":
                message = "A subtracao dos valores " + valorUm + " e " + valorDois + " é igual a " + (valorUm - valorDois);
                break;
            case "*":
                message = "A multiplicacao dos valores " + valorUm + " e " + valorDois + " é igual a " + (valorUm * valorDois);
                break;
            case "/":
                try {
                    message = "A multiplicacao dos valores " + valorUm + " e " + valorDois + " é igual a " + (valorUm / valorDois);
                } catch (Exception ex) {
                    message = ex.getMessage();
                }
                break;
            default:
                break;
        }
        return message;
    }
}
