package njp.NaumenJavaProject.models;
import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

import static njp.NaumenJavaProject.models.Role.USER;


@Entity
@Table (name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
   // @Column(login = "login")
    private String login;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
  //  @Column(password = "password")
    private String password;
    private boolean active;
    @ElementCollection (targetClass = Role.class, fetch =FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn (name="users_id"))
    @Enumerated (EnumType.STRING)
    private Set <Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Users() {
    }

    public Users(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }


}