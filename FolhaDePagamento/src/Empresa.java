import beans.Empregado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
        List<Empregado> emp = new ArrayList<Empregado>();
        Scanner input = new Scanner(System.in);
        int current_week = 1;
        while(true) {
            System.out.println("[ 1 ] Adicionar funcionario\n" +
                    "[ 2 ] Remover funcionario\n" +
                    "");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    emp.add(Empregado.cadastraEmpregado(emp.size()));
                    break;
                case 2:
                    for(Empregado e : emp) {
                        System.out.println(e);
                    }
                    if(emp.size() > 0) {
                        System.out.print("Digite o código do empregado que deseja remover: ");
                        int cod = input.nextInt();
                        if(cod < emp.size()) {
                            emp.remove(emp.get(cod));
                            System.out.println("Funcionario removido");
                        }else {
                            System.out.println("Codigo nao encontrado");
                        }
                    } else {
                        System.out.println("Nenhum funcionario cadastrado");
                    }
                    break;
            }

        }
    }

}
