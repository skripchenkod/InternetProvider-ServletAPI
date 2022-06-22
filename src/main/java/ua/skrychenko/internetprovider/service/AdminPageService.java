package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.*;

public class AdminPageService {

    TariffDao tariffDao = new TariffDaoImpl();
    UserDao userDao = new UserDaoJdbcImpl();

    public void editTariff(String id, String newName, String newPrice) {

        tariffDao.editTariff(id, newName, newPrice);
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