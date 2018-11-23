package beans;

public class Taxa {

   private Double valorTaxa;
   private String descricao;
   public Integer codigoTaxa;

    public Taxa() {
        valorTaxa = null;
        descricao = null;
        codigoTaxa = 0;
    }

    public Taxa(Double valorTaxa, String descricao, Integer codigoTaxa) {
        this.valorTaxa = valorTaxa;
        this.descricao = descricao;
        this.codigoTaxa = codigoTaxa;
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
