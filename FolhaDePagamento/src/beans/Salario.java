package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salario {
    private Integer tipoEmpregado;
    private Double salarioBase;
    private List<Taxa> taxas;
    private List<CartaoDePonto> ponto;
    private Vendas vendas;
    private String tipoPagamento;
    private Integer qtd_taxas;


    public Salario () {
        this.tipoEmpregado = null;
        this.salarioBase = null;
        this.taxas = new ArrayList<>();
        this.ponto = null;
        this.tipoPagamento = null;
        this.qtd_taxas = 0;

    }

    public Salario(Integer tipoEmpregado, Double salarioBruto, List<Taxa> taxa, String tipoPagamento) {
        this.salarioBase = salarioBruto;
        this.taxas = taxa;
        this.tipoEmpregado = tipoEmpregado;
        this.tipoPagamento = tipoPagamento;
        this.qtd_taxas = 0;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
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

    public void setSalarioBase(Double salarioBruto) {
        this.salarioBase = salarioBruto;
    }

    public void setTaxas(List<Taxa> taxa) {
        this.taxas = taxa;
    }

    public Double getSalarioBase() {
        return  this.salarioBase;
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
        Double salarioBruto = this.salarioBase;
        if(this.getTipoEmpregado() == 1) {
            for(CartaoDePonto c : ponto) {
                if(c.getWeek() == week) {
                    salarioBruto += c.getSalario(this.salarioBase);
                }

            }
        } else if(this.getTipoEmpregado() == 3) {
            salarioBruto = this.salarioBase;
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
        System.out.print("Digite o salario base do empregado: ");
        s.setSalarioBase(sc.nextDouble());
        return s;
    }
    public void addTaxa(Double valorTaxa, String descricao) {
        taxas.add(new Taxa(valorTaxa, descricao, ++qtd_taxas));
    }

    public Double calcTaxas() {
        Double sum = 0.0;
        for(Taxa t : taxas) {
            sum += t.getValorTaxa();
        }
        return sum;
    }
}
