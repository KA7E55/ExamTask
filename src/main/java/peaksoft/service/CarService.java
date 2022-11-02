package peaksoft.service;

import peaksoft.entity.Car;
import peaksoft.entity.Company;

public interface CarService {

    void createTable();

    void saveCar(Car car);

    void deleteCarById(Long id);
}
