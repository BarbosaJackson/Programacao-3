package VIEWS;

import java.util.Scanner;

public class Menu {
	public static Integer mainMenu() {
		System.out.println("[ 1  ] Adicionar funcionario\n" + // TODO
                    "[ 2  ] Remover funcionario\n" + // TODO
                    "[ 3  ] Lançar um cartão de ponto\n" + // TODO
                    "[ 4  ] Lançar um resultado de venda\n" + // TODO
                    "[ 5  ] Lançar uma taxa de serviço\n" + // TODO
                    "[ 6  ] Alterar os detalhes de um empregado\n" + // TODO
                    "[ 7  ] Rodar folha de pagamento\n" + // TODO
                    "[ 8  ] Undo\n" + // TODO
                    "[ 9  ] Redo\n" + // TODO
                    "[ 10 ] Agenda de pagamento\n" + // TODO
                    "[ 11 ] Criar nova agenda de pagamento\n" + // TODO
                    "[ 0  ] Sair\n");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}