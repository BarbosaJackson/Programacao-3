package beans;

public class Taxa {

   private Double valorTaxa;
   private String descricao;

    public Taxa() {
        valorTaxa = null;
        descricao = null;
    }

    public Taxa(Double valorTaxa, String descricao) {
        this.valorTaxa = valorTaxa;
        this.descricao = descricao;
    }

    public Double getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(Double valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
