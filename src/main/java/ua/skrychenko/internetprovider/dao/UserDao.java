package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> findAll();

    void saveUser(UserEntity userEntity);

    boolean isExistUser(String userName);

    String selectRole(UserEntity userEntity);

    void editStatusOfBalance(String userName, boolean status);
}
