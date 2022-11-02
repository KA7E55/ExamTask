package peaksoft.impl;

import peaksoft.dao.GarageDao;
import peaksoft.entity.Company;
import peaksoft.entity.Garage;
import peaksoft.service.GarageService;

public class GarageImpl implements GarageService {

    private GarageDao garageDao = new GarageDao();
    @Override
    public void createTable() {
        garageDao.createTable();
    }

    @Override
    public void saveGarage(Garage garage) {
        garageDao.saveGarage(garage);
    }

    @Override
    public void deleteGarageById(Long id) {
        garageDao.deleteGarageById(id);
    }
}
