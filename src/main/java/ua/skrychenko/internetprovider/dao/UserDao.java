package ua.skrychenko.internetprovider.dao;

import ua.skrychenko.internetprovider.entity.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> findAll();

}