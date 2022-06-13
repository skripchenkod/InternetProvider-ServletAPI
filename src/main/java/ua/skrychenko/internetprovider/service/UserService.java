package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.UserDaoJdbcImpl;
import ua.skrychenko.internetprovider.entity.UserEntity;

import java.util.List;

public class UserService {
    UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

    public List<UserEntity> getAllUsers() {
        return userDaoJdbc.findAll();
    }

    public void saveUser(String userName, String password) {
        userDaoJdbc.saveUser(userName, password);
    }
}
