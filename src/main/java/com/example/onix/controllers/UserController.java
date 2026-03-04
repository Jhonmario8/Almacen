package com.example.onix.controllers;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.models.services.IUserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Data
public class UserController {

    private final IUserService userService;

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }
    @PutMapping("/update")
    public void update(@RequestBody UserDto user) {
        userService.updateUser(user);
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
