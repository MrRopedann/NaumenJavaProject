package njp.NaumenJavaProject.forms;

import org.springframework.stereotype.Component;

public class Greeting {
    public Greeting(String email) {
        this.email = email;
    }
    public Greeting() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String email;


}
