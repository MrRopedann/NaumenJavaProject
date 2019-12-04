package njp.NaumenJavaProject.forms;

import java.util.Date;

public class RecordForm {
 //   private String login; // попробовать обработать со стороны сервера если нет  то  добавить
    private  boolean status;
    private String note;
    private String date;


    public boolean isBasket() {
        return basket;
    }

    public void setBasket(boolean basket) {
        this.basket = basket;
    }

    private boolean basket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean attached;

    public RecordForm(String note, String date){
        this.note = note;
        this.date = date;
    }
//конструктор ниже для тестирования editing
    public RecordForm( String note, String date, boolean status, long id) {
        this.status = status;
        this.note = note;
        this.date = date;
        this.id =id;
    }

    public RecordForm() {
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

    public boolean isAttached() {
        return attached;
    }

    public void setAttached(boolean attached) {
        this.attached = attached;
    }
}
