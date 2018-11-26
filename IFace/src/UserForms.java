import java.util.List;
import java.util.Scanner;

public class UserForms {

    public static Integer menu(){
        System.out.print("Login\n" +
                "-----------------\n" +
                "[ 1 ] Entrar\n" +
                "[ 2 ] Cadastrar\n" +
                "[ 0 ] Sair\nDigite a opção desejada => ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static Integer menu(User u) {
        System.out.println("Olá " + u.getName() + ", bem-vindo ao iFace\n" +
                "Você tem " + u.getNotifications().size() + " solicitações de amizade\n" +
                "Você tem " + u.getReiceived().size() + " recados recebidos\n" +
                "Você tem " + u.getFriends().size() + " amigos\n" +
                "Você participa de " + u.getCommunities().size() + " comunidades\n" +
                "O que deseja?\n" +
                "[ 1 ] Editar perfil\n" +
                "[ 2 ] Adicionar alguma informação ao perfil\n" +
                "[ 3 ] Adicionar um amigo\n" +
                "[ 4 ] Enviar uma mensagem\n" +
                "[ 5 ] Criar uma comunidade\n" +
                "[ 6 ] Adicionar uma comunidade\n" +
                "[ 7 ] verificar as informações do seu perfil\n" +
                "[ 8 ] Remover a sua conta\n" +
                "[ 9 ] Checar solicitações de amizade\n" +
                "[ 10 ] Enviar mensagem a uma comunidade\n" +
                "[ 0 ] Sair");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static Integer checkLogin(String login, String password, List<User> users) {
        Integer i = 0;
        for(User u : users) {
            if(login.equals(u.getLogin()) && password.equals(u.getPassword())) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
