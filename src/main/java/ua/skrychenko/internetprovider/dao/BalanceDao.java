package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.UserEntity;

public interface BalanceDao {
    int createBalance(UserEntity userEntity);

    void topUpBalance(int userId, int sum);

    void topDownBalance(int userID, int sum);

}
