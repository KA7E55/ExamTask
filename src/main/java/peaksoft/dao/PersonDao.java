package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Util;
import peaksoft.entity.Company;
import peaksoft.entity.Person;
import peaksoft.service.PersonService;

public class PersonDao implements PersonService {

    private SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("create table people (id bigserial not null, age integer not null, email varchar(50), gender varchar(15) not null, name varchar(30), company_id biglong, primary key (id))");
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void savePerson(Person person) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void deletePersonById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Person person = session.find(Person.class,id);
            session.remove(person);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
