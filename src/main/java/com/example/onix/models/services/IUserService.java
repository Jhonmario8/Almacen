package com.example.onix.models.services;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUsers();
    void saveUser(User user);
    void updateUser(UserDto user);
    User getUserById(Long id);
    void deleteUserById(Long id);
}
