package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.BalanceEntity;
import ua.skrychenko.internetprovider.entity.UserEntity;

import java.util.List;

public interface BalanceDao {
    int createBalance(UserEntity userEntity);

    void topUpBalance(String userName, int sum);

    void topDownBalance(String userName, int sum);

    List<BalanceEntity> getBalance(String userName);

}
