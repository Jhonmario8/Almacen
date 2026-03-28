package com.example.onix.controllers;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.models.services.IUserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Data
public class UserController {

    private final IUserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping
    public void update(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @GetMapping("/existByEmail/{email}")
    public Boolean existByEmail(@PathVariable String email) {
        return userService.existUserByEmail(email);
    }

    @PostMapping("/login")
    public ResponseEntity<?> existByName(@RequestBody UserDto userDto) {
        try {
            UserDto user = userService.login(userDto);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
