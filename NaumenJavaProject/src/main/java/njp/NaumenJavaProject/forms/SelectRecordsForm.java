package njp.NaumenJavaProject.forms;

public class SelectRecordsForm {
    private String firstDate;
    private String secondDate;

    public SelectRecordsForm(String firstDate, String secondDate){
        this.firstDate=firstDate;
        this.secondDate=secondDate;

    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public String getSecondDate() {
        return secondDate;
    }
}
