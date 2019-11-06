package njp.NaumenJavaProject.models;
import javax.persistence.*;


@Entity
@Table (name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // @Column(login = "login")
    private String login;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
  //  @Column(password = "password")
    private String password;


    public Users() {
    }

    public Users(String login, String password) {
        this.login = login;
        this.password = password;

    }



    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }
}