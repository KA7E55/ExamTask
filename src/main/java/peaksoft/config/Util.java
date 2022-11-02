package peaksoft.config;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.*;

import java.util.Properties;

public class Util {

    public static SessionFactory getSessionFactory() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/HomeWork7JDBCHibernate");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "14021972");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(SocialMedia.class);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Garage.class);

        return configuration.buildSessionFactory();
    }

    public static EntityManager getConnection() {
        return Persistence.createEntityManagerFactory("peaksoft").createEntityManager();
    }
}
