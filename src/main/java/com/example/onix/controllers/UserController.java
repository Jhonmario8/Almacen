package com.example.onix.controllers;

import com.example.onix.mappers.UserMapper;
import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.services.AuthService;
import com.example.onix.services.IUserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Data
public class UserController {

    private final IUserService userService;
    private final UserMapper userMapper;


    @GetMapping
    public List<UserDto> findAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UserDto user) {
       UserDto saveUser = userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UserDto user) {
        UserDto updateUser =  userService.updateUser(id,user);
        return ResponseEntity.ok(updateUser);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        UserDto user = userService.login(userDto);
        return ResponseEntity.ok(Map.of("message", "Login Exitoso"));
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
