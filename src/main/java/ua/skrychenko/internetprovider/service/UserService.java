package ua.skrychenko.internetprovider.service;

import ua.skrychenko.internetprovider.dao.UserDaoJdbcImpl;
import ua.skrychenko.internetprovider.dto.UserDto;
import ua.skrychenko.internetprovider.entity.UserEntity;
import ua.skrychenko.internetprovider.mapper.UserMapper;

import java.util.List;

public class UserService {
    private final UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
    private final UserMapper userMapper = new UserMapper();

    public List<UserEntity> getAllUsers() {
        return userDaoJdbc.findAll();
    }

    public String saveUser(UserDto userDto) {
        String isExist = "User is exist";
        String success = "Registration is success";
        if (userDaoJdbc.isExistUser(userDto.getUserName())) {

            userDaoJdbc.saveUser(userMapper.userDtoToEntity(userDto));

            return success;
        }
        return isExist;
    }

    public String chekUser(UserDto userDto) {
        return userDaoJdbc.selectRole(userMapper.userDtoToEntitySignIn(userDto));
    }
}
