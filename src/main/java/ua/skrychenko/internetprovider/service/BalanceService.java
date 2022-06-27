package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.BalanceDao;
import ua.skrychenko.internetprovider.dao.BalanceDaoImpl;
import ua.skrychenko.internetprovider.dao.UserDao;
import ua.skrychenko.internetprovider.dao.UserDaoJdbcImpl;
import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.mapper.BalanceMapper;

import java.util.List;

public class BalanceService {
    private final BalanceDao balanceDao = new BalanceDaoImpl();
    private final BalanceMapper balanceMapper = new BalanceMapper();
    private final UserDao userDao = new UserDaoJdbcImpl();

    public List<BalanceDto> getBalance(String userName) {
        return balanceMapper.balanceEntitiesToDtos(balanceDao.getBalance(userName));
    }

    public void topUp(String userName, int sum) {
        balanceDao.editBalance(userName, sum);
        userDao.editStatusOfBalance(userName, true);
    }

    public String buyTariff(int id, String userName) {
        String error = "Not enough funds!";
        String success = "Connection successful!";
        if (balanceDao.checkBalance(id, userName)) {
            userDao.setService(id,userName);
            balanceDao.editBalance(userName, -balanceDao.getPriceOfTariff(id));
            return success;
        } else userDao.editStatusOfBalance(userName, false);
        return error;
    }
}
