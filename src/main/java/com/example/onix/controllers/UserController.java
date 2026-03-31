package com.example.onix.controllers;

import com.example.onix.mappers.UserMapper;
import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.models.services.IUserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> save(@Valid @RequestBody User user) {
       UserDto saveUser = userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @PutMapping
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody UserDto user) {
        UserDto updateUser =  userService.updateUser(id,user);
        return ResponseEntity.ok(updateUser);
    }


    @PostMapping("/login")
    public ResponseEntity<?> existByName(@RequestBody UserDto userDto) {
            UserDto user = userService.login(userDto);
            return ResponseEntity.ok(user);
    }

    @GetMapping("/findById/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
