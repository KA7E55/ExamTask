package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Util;
import peaksoft.entity.Car;
import peaksoft.service.CarService;

public class CarDao implements CarService {

    private SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("create table if not exists cars (id bigserial not null, mark int not null, " +
                    "producedCountry varchar(50), garage_id biglong, person_id biglong, primary key (id))");
            session.getTransaction().commit();
        } catch (HibernateException he) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteCarById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.find(Car.class, id);
            session.remove(car);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            throw new RuntimeException();
        }
    }
}
