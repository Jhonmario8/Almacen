package com.example.onix.services;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto user);
    UserDto updateUser(Long id,UserDto user);
    UserDto login(UserDto userDto);
    UserDto getUserById(Long id);
    void deleteUserById(Long id);
}
