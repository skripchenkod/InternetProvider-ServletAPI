package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.BalanceDao;
import ua.skrychenko.internetprovider.dao.BalanceDaoImpl;
import ua.skrychenko.internetprovider.dto.BalanceDto;
import ua.skrychenko.internetprovider.mapper.BalanceMapper;


import java.util.List;

public class BalanceService {
    BalanceDao balanceDao = new BalanceDaoImpl();
    BalanceMapper balanceMapper = new BalanceMapper();

    public List<BalanceDto> getBalance(String userName){
        return balanceMapper.balanceEntitiesToDtos(balanceDao.getBalance(userName));
    }

    public void topUp(String userName, int sum){
         balanceDao.topUpBalance(userName, sum);
    }

    public boolean checkBalance(int id, String userName){
       return balanceDao.checkBalance(id, userName);
    }

    public void topDown(int id, String userName){
        balanceDao.topDownBalance(id, userName);
    }

}