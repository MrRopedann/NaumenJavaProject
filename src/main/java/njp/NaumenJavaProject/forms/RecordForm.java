package njp.NaumenJavaProject.forms;

import java.util.Date;

public class RecordForm {
 //   private String login; // попробовать обработать со стороны сервера если нет  то  добавить
    private  boolean status;
    private String note;
    private String date;
    private boolean basket;
    public RecordForm(String note, String date){
        this.note = note;
        this.date = date;
    }

    public RecordForm() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatusOfDone(boolean status) {
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

    public boolean getBasket() {
        return basket;
    }

    public void setBasket(boolean basket) {
        this.basket = basket;
    }
}
