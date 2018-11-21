package beans;

import java.util.ArrayList;

public class Vendas {
    private Double percentComissao;
    private ArrayList< Double> vendas;
    private ArrayList< String > data;

    public Vendas(Double percentComissao) {
        this.percentComissao = percentComissao;
        vendas = new ArrayList<>();
    }

    public void addVendas(String data, Double valorVenda) {
        vendas.add(valorVenda);
        this.data.add(data);
    }

    public ArrayList<Double> getVendas() {
        return vendas;
    }
}
