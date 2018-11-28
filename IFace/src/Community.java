import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Community {
    private String loginMaster, communityName, communityDescription;
    private List<Message> messages;
    private List<User> members;

    public Community(String loginMaster) {
        this.loginMaster = loginMaster;
        communityDescription = null;
        communityName = null;
        messages = new ArrayList<>();
        members = new ArrayList<>();
    }

    public Community(String loginMaster, String communityDescription, String communityName) {
        this.loginMaster = loginMaster;
        this.communityDescription = communityDescription;
        this.communityName = communityName;
        messages = new ArrayList<>();
        members = new ArrayList<>();
    }



    public Community registerCommunity(User u, List<Community> communities) {
        Community c = new Community(this.loginMaster);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da comunidade: ");
        c.setCommunityName(sc.nextLine());
        boolean flag = false;
        while(!flag) {
            for (Community aux : communities) {
                if (aux.getCommunityName().equals(c.getCommunityName())){
                    System.out.print("Digite o nome da comunidade: ");
                    c.setCommunityName(sc.nextLine());
                    break;
                }
            }
            flag = true;
        }
        System.out.print("Digite a descrição da comunidade: ");
        c.setCommunityDescription(sc.nextLine());
        members.add(u);
        return c;
    }

    public String getLoginMaster() {
        return loginMaster;
    }

    public void setLoginMaster(String loginMaster) {
        this.loginMaster = loginMaster;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityDescription() {
        return communityDescription;
    }

    public void setCommunityDescription(String communityDescription) {
        this.communityDescription = communityDescription;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void showMembers() {
        System.out.println("Membros da comunidade: " + this.communityName);
        for(User u : this.members) {
            System.out.println(u);
        }
    }

    public void sendMessage(String loginFrom, String message) {
        for(User u : this.getMembers()) {
            if(u.getLogin().equals(loginFrom)) {
                Message m = new Message(loginFrom, this.communityName, message);
                this.messages.add(m);
                return;
            }
        }
        System.out.println("Você não faz parte dessa comunidade\n");
    }



}
