package peaksoft.impl;

import org.hibernate.Session;
import peaksoft.dao.CompanyDao;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

public class CompanyImpl implements CompanyService {

    private CompanyDao companyDao = new CompanyDao();
    @Override
    public void createTable() {
        companyDao.createTable();
    }

    @Override
    public void saveCompany(Company company) {
        companyDao.saveCompany(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyDao.deleteCompanyById(id);
    }
}
