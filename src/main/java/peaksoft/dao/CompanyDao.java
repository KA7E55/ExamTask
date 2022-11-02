package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Util;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;


public class CompanyDao implements CompanyService {

    private SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery(
                    "create table if not exists users(" +
                            "id serial primary key," +
                            "name varchar(50)  ," +
                            "last_name varchar(50) ," +
                            "age int not null );").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveCompany(Company company) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteCompanyById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Company company = session.find(Company.class, id);
            session.remove(company);
            session.getTransaction().commit();
        }
    }
}
