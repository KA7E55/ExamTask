package peaksoft.service;

import peaksoft.entity.Company;
import peaksoft.entity.Garage;

public interface GarageService {

    void createTable();

    void saveGarage(Garage garage);

    void deleteGarageById(Long id);
}
