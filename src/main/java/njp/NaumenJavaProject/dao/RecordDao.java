package njp.NaumenJavaProject.dao;

import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.LongType;

import javax.persistence.Query;
import java.util.List;

public class RecordDao {

    public Record findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Record.class, id);
    }




   /* public long findIDByLogin(String paramName) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select * FROM users where login ='"+paramName+"'");
        return (long) query.getParameterValue("id");

    }


*/




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