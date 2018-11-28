import java.util.List;

public class InitTests {

    public static int init(List<User> users, int codeUsers) {
        users.add(new User("kcaj", "1234", "Jackson Barbosa", codeUsers++));
        users.add(new User("hrns", "1234", "Hiago Nunes", codeUsers++));
        users.add(new User("bcn", "1234", "Bruno Cavalcante", codeUsers++));
        users.add(new User("kla", "12345", "uma pessoa", codeUsers++));
        users.add(new User("chorão", "543321", "alexandre", codeUsers++));
        users.get(1).addFriend(users, "kcaj", 1);
        users.get(2).addFriend(users, "kcaj", 2);
        users.get(2).addFriend(users, "kcaj", 2);
        return codeUsers;
    }

}
