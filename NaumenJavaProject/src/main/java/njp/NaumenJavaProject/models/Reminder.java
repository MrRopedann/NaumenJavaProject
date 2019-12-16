package njp.NaumenJavaProject.models;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "reminder")

public class Reminder {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="recordid")
    private Record record;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "data")
    private Date dateReminder;
    boolean shipped;

    public Reminder() {
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReminder() {
        return dateReminder;
    }

    public void setDateReminder(Date dateReminder) {
        this.dateReminder = dateReminder;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
