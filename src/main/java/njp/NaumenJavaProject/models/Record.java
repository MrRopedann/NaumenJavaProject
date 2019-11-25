package njp.NaumenJavaProject.models;




import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table ( name = "record")
public class Record {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private long id;
    private String login;
    private boolean status;
    private String note;
    private String date;
    private boolean basket;
    private boolean attached;

    public Record() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isBasket() {
        return basket;
    }

    public void setBasket(boolean basket) {
        this.basket = basket;
    }

    public boolean isAttached() {
        return attached;
    }

    public void setAttached(boolean attached) {
        this.attached = attached;
    }
// пытаюсь переопределить тостринг для того чтоб показать объект на индекс. Если индекс работает норм, метод удалить
    @Override
    public String toString() {
        return "super";
    }
}
