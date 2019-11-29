package njp.NaumenJavaProject.dao;



import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.utils.HibernateSessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


import java.util.List;


public class UserDao {

    public Users findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);

    }


    public long findIDByLogin(String login) {
        //https://habr.com/ru/post/271115/
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Criteria userCriteria = session.createCriteria(Users.class);
        userCriteria.add(Restrictions.eq("login", login));
        Users users = (Users) userCriteria.uniqueResult();
        session.close();
        if(users==null) return 0;
        return users.getId();

        // Query query = session.createQuery("FROM Users");
        //List file = query.list();
      /*
        Query query = session.createQuery(" select id from users  where login =:paramName").setParameter("paramName", login);

        List id=query.list();
        return id.get(0);
*/
    }
// метод получает список записей по логину и состоянию поля basket
    public List<Record> findAll(String login, boolean basket) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Record c where c.login=:login and c.basket = :basket");
        query.setParameter("login", login);
        query.setParameter("basket", basket);
        return        query.list();
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


}
