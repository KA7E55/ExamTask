package peaksoft;


import peaksoft.dao.CompanyDao;


/**
 * KA7E55
 */
public class App {
    public static void main(String[] args) {

        CompanyDao companyDao = new CompanyDao();
        companyDao.createTable();

    }
}
