package njp.NaumenJavaProject.servises;


import njp.NaumenJavaProject.dao.ReminderDao;
import njp.NaumenJavaProject.models.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

import static njp.NaumenJavaProject.config.MyConstants.*;

public class ReminderServises {

    private ReminderDao reminderDao = new ReminderDao();


    public ReminderServises() {
    }

    public Reminder findByRecordId(long id) {
        return reminderDao.findByRecordId(id);
    }
    public void sendReminderForToday (){reminderDao.sendReminderForToday();}

    public Reminder findById(long id) {
        return reminderDao.findById(id);
    }


    public void saveReminder(Reminder reminder) {
        reminderDao.save(reminder);
    }

    public void deleteReminder(Reminder reminder) {
        reminderDao.delete(reminder);
    }

    public void updateReminder(Reminder reminder) {
        reminderDao.update(reminder);
    }


    @Autowired
    public JavaMailSender emailSender;
    public void sendReminderToEmail(String note, String email){
            Sender tlsSender = new Sender(MY_EMAIL, MY_PASSWORD);
            tlsSender.send("Reminder", note, MY_EMAIL, email);

    }
}