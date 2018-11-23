package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salario {
    private Integer tipoEmpregado;
    private Double salarioBruto;
    private List<Taxa> taxas;
    private List<CartaoDePonto> ponto;
    private Vendas vendas;

    public Salario () {
        this.tipoEmpregado = null;
        this.salarioBruto = null;
        this.taxas = new ArrayList<>();
        this.ponto = null;
    }

    public Salario(Integer tipoEmpregado, Double salarioBruto, List<Taxa> taxa) {
        this.salarioBruto = salarioBruto;
        this.taxas = taxa;
        this.tipoEmpregado = tipoEmpregado;
        this.ponto = null;
    }

    public void setTipoEmpregado(String tipoEmpregado) {
        if(tipoEmpregado.equalsIgnoreCase("hourly")) {
            this.tipoEmpregado = 1;
            this.ponto = new ArrayList<CartaoDePonto>();
        } else if(tipoEmpregado.equalsIgnoreCase("salaried")) {
            this.tipoEmpregado = 2;
        } else if(tipoEmpregado.equalsIgnoreCase("commissioned")){
            this.tipoEmpregado = 3;
            System.out.print("Digite a porcentagem em cada venda: ");
            Scanner sc = new Scanner(System.in);
            this.vendas = new Vendas(sc.nextDouble());
        }
    }

    public void setSalarioBruto(Double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void setTaxas(List<Taxa> taxa) {
        this.taxas = taxa;
    }

    public Double getSalarioBruto() {
        return  this.salarioBruto;
    }

    public List<Taxa> getTaxas() {
        return this.taxas;
    }

    public Integer getTipoEmpregado() {
        return this.tipoEmpregado;
    }

    public void setTipoEmpregado(Integer tipoEmpregado) {
        this.tipoEmpregado = tipoEmpregado;
    }

    public List<CartaoDePonto> getPonto() {
        return ponto;
    }

    public void setPonto(List<CartaoDePonto> ponto) {
        this.ponto = ponto;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Double getSalarioLiquido(Integer week) {
        Double salarioBruto = 0.0;
        if(this.getTipoEmpregado() == 1) {
            for(CartaoDePonto c : ponto) {
                if(c.getWeek() == week) {
                    salarioBruto += c.getSalario(this.salarioBruto);
                }

            }
        } else if(this.getTipoEmpregado() == 3) {
            salarioBruto = this.salarioBruto;
            for(Double v : vendas.getVendas()) {
                salarioBruto += v;
            }
        }
        return salarioBruto - this.calcTaxas();
    }

    public void setPonto(Integer horaEntrada, Integer horaSaida, Integer week) {
        this.ponto.add(new CartaoDePonto(horaEntrada, horaSaida, week));
    }

    public static Salario cadastraSalario() {
        Salario s = new Salario();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o tipo de empregado (hourly | salaried | commissioned): ");
        s.setTipoEmpregado(sc.nextLine());
        System.out.print("");
        return s;
    }
    public void addTaxa(Double valorTaxa, String descricao) {
        taxas.add(new Taxa(valorTaxa, descricao));
    }

    public Double calcTaxas() {
        Double sum = 0.0;
        for(Taxa t : taxas) {
            sum += t.getValorTaxa();
        }
        return sum;
    }
}
