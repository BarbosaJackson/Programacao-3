import beans.Empregado;

import java.util.*;

public class Empresa {

    private static int search_employee(List<Empregado> emp, Integer start, Integer end, Integer code) {
        Integer mid = (start + end) / 2;
        if(start <= end){
            if(emp.get(mid).getCodigoEmp() == code) return mid;
            else if(emp.get(mid).getCodigoEmp() > code) return search_employee(emp, start, mid, code);
            else return search_employee(emp, mid + 1, end, code);
        }
        return -1;
    }


    public static void main(String[] args) {
        List<Empregado> emp = new ArrayList<Empregado>();
        Integer qtd_employee = 1;
        Scanner input = new Scanner(System.in);
        Integer current_week = 1, current_day = 1, current_month = 1, current_year = 1;
        while(true) {
            System.out.println("[ 1  ] Adicionar funcionario\n" + // checked
                    "[ 2  ] Remover funcionario\n" + // checked
                    "[ 3  ] Lançar um cartão de ponto\n" + // cheked
                    "[ 4  ] Lançar um resultado de venda\n" + // checked
                    "[ 5  ] Lançar uma taxa de serviço\n" + // TODO
                    "[ 6  ] Alterar os detalhes de um empregado\n" + // TODO
                    "[ 7  ] Rodar folha de pagamento\n" + // TODO
                    "[ 8  ] Undo\n" + // TODO
                    "[ 9  ] Redo\n" + // TODO
                    "[ 10 ] Agenda de pagamento\n" + // TODO
                    "[ 11 ] Criar nova agenda de pagamento\n" + // TODO
                    "[ 0  ] Sair\n");
            int op = input.nextInt();

            if(op == 0) {
                System.exit(0);
            } else if(op == 1) {
                emp.add(Empregado.cadastraEmpregado(qtd_employee++));
            } else if(op == 2) {
                if (emp.size() > 0) {
                    System.out.print("Digite o código do empregado que deseja remover: ");
                    int code = input.nextInt();
                    if (code <= emp.get(emp.size() - 1).getCodigoEmp() && code > 0) {
                        Integer pos = search_employee(emp, 0, emp.size(), code);
                        if (pos != -1) {
                            emp.remove(emp.get(pos));
                            System.out.println("Funcionario removido");
                        } else {
                            System.out.println("Codigo nao encontrado");
                        }
                    } else {
                        System.out.println("Codigo não encontrado!");
                    }
                } else {
                    System.out.println("Nenhum funcionario cadastrado");
                }
                Collections.sort(emp, Empregado.compareToId);
                for(Empregado e : emp) {
                    System.out.println(e);
                }
            } else if(op == 3) {
                System.out.print("Digite o código do funcionario: ");
                Integer code = input.nextInt();
                if(code <= emp.get(emp.size() - 1).getCodigoEmp() && code > 0) {
                    Integer horaEntrada, horaSaida;
                    horaEntrada = input.nextInt();
                    horaSaida = input.nextInt();
                    emp.get(search_employee(emp, 0, emp.size(), code)).getSalario().setPonto(horaEntrada, horaSaida, current_week);
                }
            } else if(op == 4) {
                System.out.print("Digite o código do funcionario: ");
                Integer code = input.nextInt();
                if(code <= emp.get(emp.size() - 1).getCodigoEmp() && code > 0) {
                    System.out.print("Digite o valor da venda: ");
                    emp.get(search_employee(emp, 0, emp.size(), code)).getSalario().getVendas().addVendas(current_week, current_month, input.nextDouble());
                }
            } else if(op == 5) {
                if(emp.size() > 0) {
                    System.out.print("Digite o código do fucionario: ");
                    Integer code = input.nextInt();
                    if (code <= emp.get(emp.size() - 1).getCodigoEmp() && code > 0) {
                        System.out.print("Digite o valor da taxa: ");
                        Double taxa = input.nextDouble();
                        input = new Scanner(System.in);
                        System.out.print("Digite a descrição da taxa: ");
                        String desc = input.nextLine();
                        emp.get(search_employee(emp, 0, emp.size(), code)).getSalario().addTaxa(taxa, desc);
                    }
                }
            } else if(op == 6) {
                
            } else if(op == 7) {
                current_day++;
                if (current_day == 7) {
                    current_day = 1;
                    current_week++;
                }

                if (current_day == 5) {
                    // TODO:
                    // pagamento de funcionaios que trabalham por hora semanal
                }
                if (current_week % 2 == 0) {
                    // TODO:
                    // pagamento de funcionarios que recebem por comissão
                }
                if (current_week == 4) {
                    current_month++;
                    // TODO:
                    // pagamento de funcionarios que recebem mensalmente
                }
                if (current_month % 12 == 0) {
                    current_year++;
                    current_month = 1;
                    current_week = 1;
                    current_day = 1;
                }
            }
        }
    }

}
