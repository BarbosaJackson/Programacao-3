import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer opLogin, codeUsers = 1;
        List<User> users = new ArrayList<User>();
        users.add(new User("kcaj", "1234", "Jackson Barbosa", codeUsers++));
        users.add(new User("hrns", "1234", "Hiago Nunes", codeUsers++));
        users.add(new User("bcn", "1234", "Bruno Cavalcante", codeUsers++));
        users.get(1).addFriend(users, "kcaj", 1);
        users.get(2).addFriend(users, "kcaj", 2);
        do {
            opLogin = UserForms.menu();
            if(opLogin == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite o login: ");
                String login = sc.nextLine();
                System.out.print("Digite a senha: ");
                String password = sc.nextLine();

                Integer posUser = UserForms.checkLogin(login, password, users);

                if(posUser != -1) {
                    Integer opUser = UserForms.menu(users.get(posUser));
                    while(opUser != 0) {
                        if(opUser == 1) {
                            users.get(posUser).editUser();
                        } else if(opUser == 2) {
                            users.get(posUser).addFeature();
                        } else if(opUser == 3) {
                            System.out.print("Digite o nome de usuário do amigo que você deseja adicionar: ");
                            users = users.get(posUser).addFriend(users, sc.nextLine(), posUser);
                        } else if(opUser == 4) {
                            System.out.print("Digite o nome de usuário do amigo que você deseja enviar uma mensagem: ");
                            users = users.get(posUser).sendMessage(users, sc.nextLine());
                        } else if(opUser == 5) {
                            users.get(posUser).createCommunity();
                        } else if(opUser == 6) {
                            System.out.print("Digite o nome da comunidade que deseja participar: ");
                            users.get(posUser).addCommunity(sc.nextLine());
                        } else if(opUser == 7) {
                            System.out.println("Dados do perfil\n-------------------");
                            System.out.println(users.get(posUser));
                            System.out.println("Você tem " + users.get(posUser).getFriends().size() + " amigos, seus amigos são: ");
                            for(User u : users.get(posUser).getFriends()) {
                                System.out.println(u.getName() + " que tem o login: " + u.getLogin());
                            }
                            System.out.println("-------------------------\nMensagens recebidas:");
                            for(Message m : users.get(posUser).getReiceived()){
                                System.out.println("De: " + m.getLoginFrom() + "\nPara: " + m.getLoginTo() + "\n" + m.getMessage());
                            }
                        } else if(opUser == 9) {
                            users.get(posUser).checkNotifications(users);
                        }
                        opUser = UserForms.menu(users.get(posUser));
                    }
                }  else {
                    System.out.println("Usuario não encontrado, tente novamente!!");
                }
            } else if(opLogin == 2) {
                users.add(new User(codeUsers++).registerUser(users));
            } else if(opLogin == 13) {
                for(User u : users) {
                    System.out.println(u);
                }
            } else if(opLogin != 0) {
                System.out.println("Opção inválida!");
            }
        } while(opLogin != 0);
    }
}
