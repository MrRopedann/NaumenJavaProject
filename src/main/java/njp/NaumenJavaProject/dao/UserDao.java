package njp.NaumenJavaProject.dao;



import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class UserDao {

    public Users findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }
    public Users findByLogin(String login) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, login);
    }

    public void save(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(users);
        tx1.commit();
        session.close();
    }

    public void update(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(users);
        tx1.commit();
        session.close();
    }

    public void delete(Users users) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(users);
        tx1.commit();
        session.close();
    }


    public Users findByEmail(String email) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, email);
    }
}