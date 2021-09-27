package ExerciseOne;

public class Faturar {
    private Long numero;
    private String descricao;
    private Integer qtd;
    private Double valor;

    public Faturar(){}
    public Faturar(Long numero, String descricao, Integer qtd, Double valor) {
        this.numero = numero;
        this.descricao = descricao;

        if (qtd < 0)
            this.qtd = 0;
        else
            this.qtd = qtd;

        if (valor < 0)
            this.valor = 0.0;
        else
            this.valor = valor;
    }

    public Long getNumero() {
        return numero;
    }
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getQtd() {
        return qtd;
    }
    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Double getFaturaTotal(){
        return valor * qtd;
    }
}
