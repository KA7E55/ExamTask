package peaksoft.service;

import peaksoft.entity.Company;

public interface CompanyService {

    void createTable();

    void saveCompany(Company company);

    void deleteCompanyById(Long id);

}
