package njp.NaumenJavaProject.dao;


import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Reminder;
import njp.NaumenJavaProject.servises.RecordServices;
import njp.NaumenJavaProject.servises.ReminderServises;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ReminderDao {
    public Reminder findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Reminder.class, id);
    }


    public void save(Reminder reminder) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(reminder);
        tx1.commit();
        session.close();
    }

    public void update(Reminder reminder) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(reminder);
        tx1.commit();
        session.close();
    }

    public void delete(Reminder reminder) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(reminder);
        tx1.commit();
        session.close();
    }

    public Reminder findByRecordId (long recordId){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Reminder where recordid = :recordId");
        query.setParameter("recordId", recordId);
        //исключение обрабатывается в editingController  48-59
        Reminder reminder= (Reminder) query.getSingleResult();
        return reminder;
    }
    public void sendReminderForToday () {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Reminder r where (r.dateReminder = :dueDate) and (r.shipped = false)");
        q.setParameter("dueDate", new Date());
        System.out.println(q.list().size());
        List<Reminder> list = q.list();

        for(Reminder el : list)
        {
            Thread treadCounter = new Thread(new Runnable(){
                ReminderServises rem  = new ReminderServises();
                public void run() {//Этот метод будет выполняться в побочном потоке
                    RecordServices r=new RecordServices();
                    Record curRecord=el.getRecord();
                    String note = curRecord.getNote();
                    String email=curRecord.getUsers().getEmail();  //
                    System.out.println(note+" "+email);
                    rem.sendReminderToEmail(note, email);
                    el.setShipped(true);
                    rem.updateReminder(el);
                }
            });
            treadCounter.start();
        }
    }
}
