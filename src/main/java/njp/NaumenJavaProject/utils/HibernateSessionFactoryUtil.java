package njp.NaumenJavaProject.utils;

import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Users.class);
            //    configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Record.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("eeeИсключение!eee" + e);
            }
        }
        return sessionFactory;
    }
}

