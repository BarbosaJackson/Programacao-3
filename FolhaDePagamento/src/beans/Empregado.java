package beans;

import java.util.Comparator;
import java.util.Scanner;

public class Empregado {
    private boolean pertenceSindicato;
    private Integer codigoEmp, codigoSindicato;
    private Endereco endereco;
    private Salario salario;
    private String nome;

    public Empregado () {
        this.codigoEmp = null;
        this.codigoSindicato = null;
        this.salario = null;
        this.endereco = null;
        this.nome = null;
    }

    public Empregado (String nome, Integer codigoEmp, Salario salario, Endereco endereco) {
        this.codigoEmp = codigoEmp;
        this.salario = salario;
        this.endereco = endereco;
        this.nome = nome;
        this.codigoSindicato = null;
    }

    public void setCodigoEmp(Integer codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public void setCodigoSindicato(Integer codigoSindicato) {
        this.codigoSindicato = codigoSindicato;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoEmp() {
        return this.codigoEmp;
    }

    public Integer getCodigoSindicato() {
        return this.codigoSindicato;
    }

    public Salario getSalario() {
        return this.salario;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isPertenceSindicato() {
        return pertenceSindicato;
    }

    public void setPertenceSindicato(boolean pertenceSindicato) {
        this.pertenceSindicato = pertenceSindicato;
    }

    public static Empregado cadastraEmpregado(Integer codigoEmp) {
        Empregado emp = new Empregado();
        Scanner sc = new Scanner(System.in);
        emp.setCodigoEmp(codigoEmp);
        System.out.print("Digite o nome do empregado: ");
        emp.setNome(sc.nextLine());
        emp.setEndereco(Endereco.cadastraEndereco());
        emp.setSalario(Salario.cadastraSalario());
        System.out.println("Pertence ao sindicato?\n[ 1 ] Sim\n[ 0 ] Não\n=>");
        emp.pertenceSindicato  = (sc.nextInt() == 1);
        if(emp.pertenceSindicato) {
            sc = new Scanner(System.in);
            System.out.println("Digite o código do sindicato: ");
            emp.codigoSindicato = sc.nextInt();
            System.out.print("Digite o valor da taxa sindical: ");
            emp.getSalario().addTaxa(sc.nextDouble(), "Taxa sindical");

        }
        return emp;
    }

    @Override
    public String toString() {
        return this.getCodigoEmp() + " " + this.getNome();
    }

    public static Comparator<Empregado> compareToId = new Comparator<Empregado>() {
        public int compare(Empregado e1, Empregado e2) {
            return e1.getCodigoEmp() > e2.getCodigoEmp() ? 1 : 0;
        }
    };
}
