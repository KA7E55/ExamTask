package peaksoft.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.config.Util;
import peaksoft.entity.Company;
import peaksoft.entity.SocialMedia;
import peaksoft.service.SocialMediaService;

public class SocialMediaDao implements SocialMediaService {

    private SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTable() {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createNativeQuery("create table social_media(id bigserial not null ,social_media varchar(100),primary key (id));");

        }
    }

    @Override
    public void saveSocialMedia(SocialMedia socialMedia) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(socialMedia);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteSocialMediaById(Long id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            SocialMedia socialMedia = session.find(SocialMedia.class,id);
            session.remove(socialMedia);
            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
