package beans;

public class Main {
    public static void main(String[] args) {
        Endereco end = Endereco.cadastraEndereco();
        System.out.println(end.toString());
    }
}
