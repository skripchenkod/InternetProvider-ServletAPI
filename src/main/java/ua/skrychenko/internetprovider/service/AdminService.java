package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.*;

public class AdminService {

    TariffDao tariffDao = new TariffDaoImpl();
    UserDao userDao = new UserDaoJdbcImpl();

    public void editNameOfTariff(String id, String newName) {
        int idInt = Integer.parseInt(id);
        tariffDao.editNameOfTariff(idInt, newName);
    }

    public void editPriceOfTariff(String id, String newPrice) {
        int idInt = Integer.parseInt(id);
        int newPriceInt = Integer.parseInt(newPrice);
        tariffDao.editPriceOfTariff(idInt, newPriceInt);
    }

    public void deleteTariff(String id) {
        int idInt = Integer.parseInt(id);
        tariffDao.deleteTariff(idInt);
    }

    public void editStatusOfUserBalance(String userName, String statusOfBalance) {
        boolean status = Boolean.parseBoolean(statusOfBalance);
        userDao.editStatusOfBalance(userName, status);
    }
}
