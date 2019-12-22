package njp.NaumenJavaProject.controllers;



import njp.NaumenJavaProject.forms.RecordForm;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Reminder;
import njp.NaumenJavaProject.servises.RecordServices;
import njp.NaumenJavaProject.servises.ReminderServises;
import njp.NaumenJavaProject.servises.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.persistence.NoResultException;
import java.sql.Date;
import static java.sql.Date.valueOf;

@Controller
public class EditingController {
    @RequestMapping(value = "/editing", method = RequestMethod.GET)

    public ModelAndView editGet (@ModelAttribute Record record) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/editing");
        mav.addObject("record", record);
        return mav;
    }

    @RequestMapping(value = "/editRecord", method = RequestMethod.POST)

    public String  editRecord (@ModelAttribute RecordForm recordForm){

        RecordServices recordServices = new RecordServices();
        Record record = recordServices.findById(recordForm.getId());
        record.setDate(recordForm.getDate());
        record.setNote(recordForm.getNote());
        record.setStatus(recordForm.isStatus());
        record.setBasket(recordForm.isBasket());
        record.setAttached(recordForm.isAttached());
        recordServices.updateRecord(record);
        ReminderServises reminderServises =new ReminderServises();
        if(recordForm.isRemind()&&(recordForm.getDateReminder()!="")){
            boolean reminderOld;

            Reminder reminder;
            try{
                reminder=reminderServises.findByRecordId(recordForm.getId());
                reminderOld=true;
            }
            catch (NoResultException e) {
                reminderOld =false;
                reminder =new Reminder();
            }
            reminder.setRecord(record);
            reminder.setDateReminder(valueOf(recordForm.getDateReminder()));
            reminder.setShipped(false);
            java.util.Date now = new Date((System.currentTimeMillis()) ) ;
            Date currentDate= valueOf(now.toString());
            if((reminder.getDateReminder().compareTo(currentDate)<=0)){reminder.setShipped(true);}
            if((reminder.getDateReminder().compareTo(currentDate)==0)) {
                //отправка почты в отдельный потоке
                //https://devcolibri.com/%D0%BA%D0%B0%D0%BA-%D0%BE%D1%82%D0%BF%D1%80%D0%B0%D0%B2%D0%B8%D1%82%D1%8C-email-%D0%B2-java/
                Thread sendMail = new Thread(new Runnable() {
                    ReminderServises rem = new ReminderServises();
                    public void run() {//Этот метод будет выполняться в побочном потоке
                        rem.sendReminderToEmail(recordForm.getNote(),record.getUsers().getEmail() /*usersServices.getEmail()*/);
                    }
                });
                sendMail.start();
                // выше отправка почты
            }
             if(reminderOld) {reminderServises.updateReminder(reminder);}
             else{reminderServises.saveReminder(reminder);}
        }
        return "redirect:/";
    }
}
