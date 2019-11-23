package njp.NaumenJavaProject.dao;

import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RecordDao {

    public Record findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Record.class, id);
    }
    public Record findByLogin(String login) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Record.class, login);
    }

    public void save(Record record) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(record);
        tx1.commit();
        session.close();
    }

    public void update(Record record) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(record);
        tx1.commit();
        session.close();
    }

    public void delete(Record record) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(record);
        tx1.commit();
        session.close();
    }

}