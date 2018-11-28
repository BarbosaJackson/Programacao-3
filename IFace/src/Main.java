import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer opLogin, codeUsers = 1;
        List<User> users = new ArrayList<User>();
        List<Community> communities = new ArrayList<>();

//        codeUsers = InitTests.init(users, codeUsers);

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
                            communities = users.get(posUser).createCommunity(communities);
                        } else if(opUser == 6) {
                            System.out.print("Digite o nome da comunidade que deseja participar: ");
                            communities = users.get(posUser).addCommunity(sc.nextLine(), communities);
                        } else if(opUser == 7) {
                            System.out.println("Dados do perfil\n-------------------");
                            System.out.println(users.get(posUser));
                            System.out.println("Você tem " + users.get(posUser).getFriends().size() + " amigos, seus amigos são: ");
                            for(User u : users.get(posUser).getFriends()) {
                                System.out.println(u.getName() + " que tem o login: " + u.getLogin());
                            }
                            System.out.println("-------------------------\nMensagens recebidas:");
                            for(Message m  : users.get(posUser).getReiceived()){
                                System.out.println("De: " + m.getLoginFrom() + "\nPara: " + m.getLoginTo() + "\n" + m.getMessage());
                            }
                            System.out.println("---------------------\n++++++++++++++++++++++++++++++++++++++++\nComunidades: ");
                            for(int i = 0; i < users.get(posUser).getCommunities().size(); i++) {
                                int posCom = 0;
                                while(!communities.get(posCom).getCommunityName().equals(users.get(posUser).getCommunities().get(i))){
                                    posCom++;
                                }
                                System.out.println("====================================================");
                                System.out.println("Nome: " + communities.get(posCom).getCommunityName() + "\nDescrição: "
                                        + communities.get(posCom).getCommunityDescription());
                                System.out.println("Mensagens da comunidade:");
                                for(Message m : communities.get(posCom).getMessages()) {
                                    System.out.println(m.getLoginFrom() + "@" + m.getLoginTo() + ": " + m.getMessage());
                                }
                                System.out.println("====================================================");
                            }
                        } else if(opUser == 8) {
                            users = users.get(posUser).removeUser(users, communities, posUser);
                            for(Integer i =  0; i < communities.size(); i++) {
                                if(communities.get(i).getLoginMaster().equals(users.get(posUser).getLogin())) {
                                    if(communities.get(i).getMembers().size() == 1) {
                                        communities.remove(communities.get(i));
                                    } else {
                                        communities.get(i).getMembers().remove(users.get(posUser));
                                        communities.get(i).setLoginMaster(communities.get(i).getMembers().get(0).getLogin());
                                        for(Integer j = 0; j < communities.get(i).getMessages().size(); j++) {
                                            if(communities.get(i).getMessages().get(j).getLoginFrom().equals(users.get(posUser).getLogin())){
                                                communities.get(i).getMessages().remove(communities.get(i).getMessages().get(j));
                                                j--;
                                            }
                                        }
                                    }
                                    i--;
                                }
                            }

                            for(User c : users) {
                                c.getNotifications().remove(posUser);
                            }
                            users.remove(users.get(posUser));
                            break;
                        } else if(opUser == 9) {
                            users.get(posUser).checkNotifications(users);
                        } else if(opUser == 10) {
                            System.out.println("Digite o nome da comunidade: ");
                            String cName = sc.nextLine();
                            for(Community c : communities) {
                                if(c.getCommunityName().equals(cName)) {
                                    System.out.println("Digite a mensagem que deseja enviar");
                                    c.sendMessage(users.get(posUser).getLogin(), sc.nextLine());
                                    break;
                                }
                            }
                        } else if(opUser == 11) {
                            System.out.print("Digite o nome da comunidade: ");
                            String cName = sc.nextLine();
                            sc = new Scanner(System.in);
                            boolean flag = false;
                            for(int i = 0; i < communities.size(); i++) {
                                if(cName.equals(communities.get(i).getCommunityName())) {
                                    flag = true;
                                    if(users.get(posUser).getLogin().equals(communities.get(i).getLoginMaster())) {
                                        for (int j = 0; j < communities.get(i).getMembers().size(); j++) {
                                            if (!communities.get(i).getMembers().get(j).getLogin().equals(users.get(posUser).getLogin())) {
                                                System.out.println(communities.get(i).getMembers().get(j));
                                                System.out.print("Gostaria de excluir este usuario da sua comunidade?\n" +
                                                        "[   1   ] Sim\n" +
                                                        "[ outro ] Não\n" +
                                                        "=> ");
                                                int op = sc.nextInt();
                                                if (op == 1) {
                                                    for(User u : users) {
                                                        if(u.getLogin().equals(communities.get(i).getMembers().get(j).getLogin())){
                                                            u.getCommunities().remove(communities.get(i).getCommunityName());
                                                        }
                                                    }
                                                    communities.get(i).getMembers().remove(j);
                                                    j--;
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("Você não é o administrador desta comunidade!");
                                    }
                                    break;
                                }
                            }
                            if(!flag) {
                                System.out.println("Comunidade não encontrada");
                            }
                            sc = new Scanner(System.in);
                        } else if(opUser == 12){
                            System.out.print("Digite o nome da comunidade: ");
                            String s = sc.nextLine();
                            boolean flag = false;
                            for(Community c : communities) {
                                if(c.getCommunityName().equals(s)) {
                                    c.showMembers();
                                    flag = true;
                                    break;
                                }
                            }
                            if(!flag) {
                                System.out.println("Comunidade não encontrada!");
                            }
                        } else {
                            System.out.println("Opção inválida!!");
                        }
                        opUser = UserForms.menu(users.get(posUser));
                    }
                }  else {
                    System.out.println("Usuario não encontrado, tente novamente!!");
                }
            } else if(opLogin == 2) {
                users.add(new User(codeUsers++).registerUser(users));
            } else if(opLogin != 0) {
                System.out.println("Opção inválida!");
            }
        } while(opLogin != 0);
    }
}
