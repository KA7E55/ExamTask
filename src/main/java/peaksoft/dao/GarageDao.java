package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Util;
import peaksoft.entity.Garage;
import peaksoft.service.GarageService;

public class GarageDao implements GarageService {

    SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void createTable() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("create table garages (id bigserial not null, isEmpty boolean not null, name varchar(50), car_id biglong, primary key (id))");
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveGarage(Garage garage) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(garage);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteGarageById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Garage garage = session.find(Garage.class, id);
            session.remove(garage);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
