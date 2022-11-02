package peaksoft.impl;

import peaksoft.dao.CarDao;
import peaksoft.entity.Car;
import peaksoft.service.CarService;

public class CarImpl implements CarService {

    private CarDao carDao = new CarDao();
    @Override
    public void createTable() {
        carDao.createTable();
    }

    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carDao.deleteCarById(id);
    }
}
