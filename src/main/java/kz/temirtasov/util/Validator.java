package kz.temirtasov.util;


public class Validator {
    private static final String ADMIN = "ADMIN";
    private static final String PASSWORD = "ADMIN";

    public boolean checkLogin(String login) {
        return login.equals(ADMIN);
    }

    public boolean checkPassword(String password) {
        return password.equals(PASSWORD);
    }
}
