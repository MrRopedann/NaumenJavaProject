package njp.NaumenJavaProject;

import java.text.SimpleDateFormat;
import java.util.Date;

import njp.NaumenJavaProject.servises.ReminderServises;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduledTasks {

    @Scheduled(cron = "0 0 12 * * *")
    public void reportCurrentTime() {
        ReminderServises rm=new ReminderServises();
        rm.sendReminderForToday();
    }
}
