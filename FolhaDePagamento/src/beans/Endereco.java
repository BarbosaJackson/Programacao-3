package beans;

import java.util.Scanner;

public class Endereco {
    private String rua, bairro, complemento;
    private Integer numCasa;

    public Endereco() {
        this.rua = null;
        this.bairro = null;
        this.complemento = null;
        this.numCasa = null;
    }

    public Endereco (String rua, String bairro, String complemento, Integer numCasa) {
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numCasa = numCasa;
    }

    public Endereco(Endereco end) {
        this.rua = end.getRua();
        this.bairro  = end.getBairro();
        this.complemento = end.getComplemento();
        this.numCasa = end.getNumCasa();
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setNumCasa(Integer numCasa) {
        this.numCasa = numCasa;
    }
    public String getRua() {
        return this.rua;
    }
    public String getBairro() {
        return this.bairro;
    }
    public String getComplemento() {
        return this.complemento;
    }
    public  Integer getNumCasa(){
        return this.numCasa;
    }

    public static Endereco cadastraEndereco() {
        Endereco end = new Endereco();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do bairro: ");
        end.setBairro(sc.nextLine());
        System.out.print("Digite o nome da rua: ");
        end.setRua(sc.nextLine());
        System.out.print("Digite o complemento: ");
        end.setComplemento(sc.nextLine());
        System.out.print("Digite o numero da casa: ");
        end.setNumCasa(sc.nextInt());
        return end;
    }

    public String toString() {
        return "Bairro: " + this.getBairro() + "\nRua: " + this.getRua() + "\nComplemento: " + this.getComplemento() + "\nNumero da casa: " + this.getNumCasa() + "\n--------------------------\n";
    }
}
