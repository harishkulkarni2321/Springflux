package com.example.reactivedemo;

import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static UserDto entityToDto(User user){
        UserDto userDto =new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }


    public static  User DtoToEntity(UserDto userdto){
        User user =new User();
        BeanUtils.copyProperties(userdto,user);
        return user;
    }
}
