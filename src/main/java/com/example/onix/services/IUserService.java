package com.example.onix.services;

import com.example.onix.models.dto.LoginResponse;
import com.example.onix.models.dto.UserDto;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;


public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto user);
    UserDto updateUser(Long id,UserDto user);
    LoginResponse login(UserDto userDto);
    UserDto getUserById(Long id);
    void deleteUserById(Long id);
    UserDto getCurrentUser();

}
