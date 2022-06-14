package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.UserEntity;

public interface BalanceDao {
    public int createBalanceAndReturnID(UserEntity userEntity);

    public void topUpBalance(int userId, int sum);

    public void topDownBalance(int userID, int sum);
}
