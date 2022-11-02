package peaksoft.impl;

import peaksoft.dao.SocialMediaDao;
import peaksoft.entity.Company;
import peaksoft.entity.SocialMedia;
import peaksoft.service.SocialMediaService;

public class SocialMediaImpl implements SocialMediaService {

    private SocialMediaDao socialMediaDao = new SocialMediaDao();

    @Override
    public void createTable() {
        socialMediaDao.createTable();
    }

    @Override
    public void saveSocialMedia(SocialMedia socialMedia) {
        socialMediaDao.saveSocialMedia(socialMedia);
    }

    @Override
    public void deleteSocialMediaById(Long id) {
        socialMediaDao.deleteSocialMediaById(id);
    }
}
