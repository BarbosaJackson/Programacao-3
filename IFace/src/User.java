import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private int codeUser;
    private String login, password, name;
    private List<User> friends;
    private List<String> descriptionFeature;
    private List<String> feature;
    private List<Integer> notifications;
    private List<Message> reiceived, sent;
    private List<Integer> communities;

    public User(Integer codeUser) {
        this.codeUser = codeUser;
        this.login = null;
        this.name = null;
        this.password = null;
        friends = new ArrayList<>();
        descriptionFeature = new ArrayList<>();
        feature = new ArrayList<>();
        notifications = new ArrayList<>();
        reiceived = new ArrayList<>();
        sent = new ArrayList<>();
        communities = new ArrayList<>();
    }

    public User(String login, String password, String name, Integer codeUser) {
        this.codeUser = codeUser;
        this.login = login;
        this.password = password;
        this.name = name;
        friends = new ArrayList<>();
        descriptionFeature = new ArrayList<>();
        feature = new ArrayList<>();
        notifications = new ArrayList<>();
        reiceived = new ArrayList<>();
        sent = new ArrayList<>();
        communities = new ArrayList<>();
    }

    public String toString() {
        String user = "Login: " + login + '\n' +
                "Nome: " + name + '\n' +
                "--------------------------------\nCaracteristicas adicionais:\n--------------------------------\n";
        for(int i = 0; i < feature.size(); i++) {
            user += descriptionFeature.get(i) + ": " + feature.get(i) + '\n';
        }
        return user;
    }

    public boolean checkUserName(List<User> u, String login) {
        for(User u1 : u) {
            if(login.equals(u1.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public void addNotification(Integer posUser) {
        this.notifications.add(posUser);
    }

    public List<User> addFriend(List<User> u, String loginFriend, Integer myPos) {
        for(int i = 0; i < u.size(); i++) {
            if(loginFriend.equals(u.get(i).getLogin())) {
                u.get(i).addNotification(myPos);
                System.out.println("Solicitação enviada!");
                return u;
            }
        }
        System.out.println("Usuário não encontrado");
        return u;
    }

    public List<User> checkNotifications(List<User> users) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < this.getNotifications().size(); i++) {
            System.out.println(users.get(this.getNotifications().get(i)));
            System.out.print("Deseja aceitar a solicitação?\n[ 1 ] sim\n[ 2 ] não\n[ 3 ] ver depois\n=>");
            Integer op = sc.nextInt();
            if (op == 1) {
                this.getFriends().add(users.get(this.getNotifications().get(i)));
                users.get(this.getNotifications().get(i)).getFriends().add(this);
                this.notifications.remove(i);
                i--;
            } else if (op == 2) {
                this.notifications.remove(i);
                i--;
            }
        }
        return users;
    }

    public User registerUser(List<User> users) {
        User u = new User(this.codeUser);
        Scanner sc = new Scanner(System.in);
        System.out.print("Cadastro de usuario\n-----------------------\nDigite seu nome: ");
        u.setName(sc.nextLine());
        System.out.print("Digite seu nome de usuario: ");
        u.setLogin(sc.nextLine());
        while(checkUserName(users, u.getLogin())) {
            System.out.println("Nome de usuario já utilizado");
            System.out.print("Digite seu nome de usuario: ");
            u.setLogin(sc.nextLine());
        }
        System.out.print("Digite sua senha: ");
        u.setPassword(sc.nextLine());
        return u;
    }

    public User editUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editar conta");
        System.out.print("Digite seu nome atualizado: ");
        this.setName(sc.nextLine());
        Integer i = 0;
        for(String s : this.getDescriptionFeature()) {
            System.out.print("Digite seu(sua) " + s + " atualizado(a): ");
            this.getFeature().set(i, sc.nextLine());
        }
        return this;
    }

    public void addFeature() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual caracteristica gostaria de adicionar ao seu perfil?");
        this.getDescriptionFeature().add(sc.nextLine());
        System.out.print("seu(sua) " + this.getDescriptionFeature().get(getDescriptionFeature().size() - 1) + " é: ");
        this.getFeature().add(sc.nextLine());
    }

    public List<User> sendMessage(List<User> users, String loginFriend) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < this.getFriends().size(); i++) {
            if(loginFriend.equals(this.getFriends().get(i).getLogin())) {
                for(int j = 0; j < users.size(); j++) {
                    if(users.get(j).getLogin().equals(loginFriend)) {
                        System.out.println("Digite a mensagem que gostaria de enviar para " + users.get(j).getName());
                        String message = sc.nextLine();
                        this.getSent().add(new Message(this.getLogin(), users.get(j).getLogin(), message));
                        users.get(j).getReiceived().add(new Message(this.getLogin(), users.get(j).getLogin(), message));
                        return users;
                    }
                }
            }
        }
        System.out.println("Usuário não encontrado!");
        return users;
    }

    public void addCommunity(String communityName, List<Community> communities) {
        for(int i = 0; i < this.getCommunities().size(); i++) {
            for(Community c : communities) {
                if(c.getCommunityName().equals(communities.get(i).getCommunityName())){
                    System.out.println("Você já participa dessa comunidade");
                    return;
                }
            }
        }
        for(int i = 0; i < communities.size(); i++) {
            if(communityName.equals(communities.get(i).getCommunityName())) {
                this.getCommunities().add(i);
                communities.get(i).getMembers().add(this);
            }
        }
    }

    public void createCommunity(List<Community> communities) {
        Community c = new Community(this.login).registerCommunity(this, communities);
        communities.add(c);
        addCommunity(c.getCommunityName(), communities);
    }

    public boolean isFriend(String loginUser) {
        for(User u : friends) {
            if(loginUser.equals(u.getLogin())){
                return true;
            }
        }
        return false;
    }

    public int getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(int codeUser) {
        this.codeUser = codeUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<String> getDescriptionFeature() {
        return descriptionFeature;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void setDescriptionFeature(List<String> descriptionFeature) {
        this.descriptionFeature = descriptionFeature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public List<Integer> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Integer> notifications) {
        this.notifications = notifications;
    }

    public List<Message> getReiceived() {
        return reiceived;
    }

    public void setReiceived(List<Message> reiceived) {
        this.reiceived = reiceived;
    }

    public List<Message> getSent() {
        return sent;
    }

    public void setSent(List<Message> sent) {
        this.sent = sent;
    }

    public List<Integer> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Integer> communities) {
        this.communities = communities;
    }

    public List<User> removeUser(List<User> users, List<Community> communities, Integer myPos) {
        for(User u : this.friends) {
            for(User u2 : users) {
                if(u.getLogin().equals(u2.getLogin())) {
                    for(int i = 0; i < u2.getReiceived().size(); i++) {
                        // remove todas as mensagens que foram enviadas aos amigos do perfil deles
                        if(u2.getReiceived().get(i).getLoginFrom().equals(this.login)){
                            u2.getReiceived().remove(i);
                            i--;
                        }
                    }
                    // remove todas as mensagens enviadas dos amigos pra você
                    for(int i = 0; i < u2.getSent().size(); i++) {
                        if(u2.getSent().get(i).getLoginTo().equals(this.login)) {
                            u2.getSent().remove(i);
                        }
                    }
                    // remove seu perfil da conta dos seus amigos
                    for(int i = 0; i < u2.getFriends().size(); i++) {
                        if(u2.getFriends().get(i).getLogin().equals(this.login)) {
                            u2.getFriends().remove(i);
                            break;
                        }
                    }
                }
            }
        }
        return users;
    }
}
