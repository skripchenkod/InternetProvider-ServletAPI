package ua.skrychenko.internetprovider.mapper;

import ua.skrychenko.internetprovider.dto.UserDto;
import ua.skrychenko.internetprovider.entity.BalanceEntity;
import ua.skrychenko.internetprovider.entity.RoleEntity;
import ua.skrychenko.internetprovider.entity.UserEntity;

public class UserMapper {


    public UserEntity userDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto.getUserName(), userDto.getPassword());
        RoleEntity roleEntity = new RoleEntity(2);
        userEntity.setRole(roleEntity);
        return userEntity;
    }

    public UserEntity userDtoToEntitySignIn(UserDto userDto){
        return new UserEntity(userDto.getUserName(), userDto.getPassword());
    }
}
