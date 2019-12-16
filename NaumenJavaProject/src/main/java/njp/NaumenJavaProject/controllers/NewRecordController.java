package njp.NaumenJavaProject.controllers;
import njp.NaumenJavaProject.forms.RecordForm;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Reminder;
import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.servises.RecordServices;
import njp.NaumenJavaProject.servises.ReminderServises;
import njp.NaumenJavaProject.servises.UsersServices;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import java.sql.Date;

import static java.sql.Date.valueOf;


@Controller



public class NewRecordController {
    @RequestMapping(value = "/newRecord", method = RequestMethod.GET)
    public String enter() {
        return "newRecord";
    }

    /* метод добывает логин текущего пользователя
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
*/
    @RequestMapping(value = "/newRecord", method = RequestMethod.POST)
    public String/*ModelAndView*/ createRecord (@ModelAttribute RecordForm recordForm){


        UsersServices usersServices = new UsersServices();


        Users users=  usersServices.findUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        Record record = new Record();
        record.setAttached(recordForm.isAttached());
        record.setDate(recordForm.getDate());
        record.setNote(recordForm.getNote());
        record.setStatus(recordForm.isStatus());
        record.setBasket(false);
        record.setLogin(users.getLogin());
        record.setUsers(users);
        RecordServices recordServices = new RecordServices();
        recordServices.saveRecord(record);
        ReminderServises reminderServises =new ReminderServises();
        if(recordForm.isRemind()&&(recordForm.getDateReminder()!="")){
            Reminder reminder =new Reminder();
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
            reminderServises.saveReminder(reminder);
        }
        ModelAndView mav = new ModelAndView();

        mav.addObject("form", recordForm);
        mav.setViewName("../static/index");
        return "redirect:/";
    }
}


