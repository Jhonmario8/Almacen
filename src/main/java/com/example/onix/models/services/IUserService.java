package com.example.onix.models.services;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> getAllUsers();
    void saveUser(User user);
    void updateUser(UserDto user);
    Boolean existUserByEmail(String email);
    UserDto login(UserDto userDto);
    User getUserById(Long id);
    void deleteUserById(Long id);
}
