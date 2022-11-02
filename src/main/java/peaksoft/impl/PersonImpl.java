package peaksoft.impl;

import peaksoft.dao.PersonDao;
import peaksoft.entity.Company;
import peaksoft.entity.Person;
import peaksoft.service.PersonService;

public class PersonImpl implements PersonService {
    private PersonDao personDao = new PersonDao();
    @Override
    public void createTable() {
        personDao.createTable();
    }

    @Override
    public void savePerson(Person person) {
        personDao.savePerson(person);
    }

    @Override
    public void deletePersonById(Long id) {
        personDao.deletePersonById(id);
    }
}
