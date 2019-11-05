package njp.NaumenJavaProject.forms;


import org.springframework.stereotype.Component;

@Component
public class RegistrationForm {
    private String email;
    private String login;
    private  String password;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
