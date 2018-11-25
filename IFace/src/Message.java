public class Message {

    private String message, loginFrom, loginTo;

    public String getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(String loginFrom) {
        this.loginFrom = loginFrom;
    }

    public String getLoginTo() {
        return loginTo;
    }

    public void setLoginTo(String loginTo) {
        this.loginTo = loginTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
        loginFrom = null;
        loginTo = null;
        message = null;
    }

    public Message(String loginFrom, String loginTo, String message) {
        this.loginTo = loginTo;
        this.loginFrom = loginFrom;
        this.message = message;
    }

}
