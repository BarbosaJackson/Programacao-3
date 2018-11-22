package beans;

import java.util.ArrayList;

public class Vendas {
    private Double percentComissao;
    private ArrayList< Double> vendas;
    private ArrayList< Integer > week;
    private ArrayList< Integer > month;

    public Vendas(Double percentComissao) {
        this.percentComissao = percentComissao;
        vendas = new ArrayList<>();
    }

    public void addVendas(Integer week, Integer month, Double valorVenda) {
        this.vendas.add(valorVenda);
        this.week.add(week);
        this.month.add(month);
    }

    public ArrayList<Double> getVendas() {
        return vendas;
    }
}
