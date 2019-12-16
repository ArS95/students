package kz.temirtasov.to;

public class UserTo {
    private final String login;
    private final String password;
    private final boolean logged;

    public UserTo(String login, String password, boolean logged) {
        this.login = login;
        this.password = password;
        this.logged = logged;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
