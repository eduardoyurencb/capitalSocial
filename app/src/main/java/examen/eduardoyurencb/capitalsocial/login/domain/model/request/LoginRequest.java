package examen.eduardoyurencb.capitalsocial.login.domain.model.request;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class LoginRequest {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}