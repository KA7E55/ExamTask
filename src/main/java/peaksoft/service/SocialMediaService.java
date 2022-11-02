package peaksoft.service;

import peaksoft.entity.Company;
import peaksoft.entity.SocialMedia;

public interface SocialMediaService {

    void createTable();

    void saveSocialMedia(SocialMedia socialMedia);

    void deleteSocialMediaById(Long id);
}
