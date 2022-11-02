package peaksoft.service;

import peaksoft.entity.Company;
import peaksoft.entity.Person;

public interface PersonService {

    void createTable();

    void savePerson(Person person);

    void deletePersonById(Long id);
}
