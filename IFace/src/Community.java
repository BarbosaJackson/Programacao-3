import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Community {
    private String loginMaster, communityName, communityDescription;
    private List<Message> messages;

    public Community(String loginMaster) {
        this.loginMaster = loginMaster;
        communityDescription = null;
        communityName = null;
    }

    public Community(String loginMaster, String communityDescription, String communityName) {
        this.loginMaster = loginMaster;
        this.communityDescription = communityDescription;
        this.communityName = communityName;
    }

    public void addMember(String newMemberLogin, List<User> users) {
        for(User u : users) {
            if(newMemberLogin.equals(u.getLogin())) {
                u.getCommunities().add(this);
            }
        }
    }

    public Community registerCommunity() {
        Community c = new Community(this.loginMaster);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da comunidade: ");
        c.setCommunityName(sc.nextLine());
        System.out.print("Digite a descrição da comunidade");
        c.setCommunityDescription(sc.nextLine());
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
}
