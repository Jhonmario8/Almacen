package com.example.onix.models.services;

import com.example.onix.exceptions.ConflictException;
import com.example.onix.exceptions.InvalidCredentialsException;
import com.example.onix.exceptions.NotFoundException;
import com.example.onix.mappers.UserMapper;
import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.models.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No se encontro ningun usuario");
        }
        return userMapper.toDtoList(users);
    }

    @Override
    public UserDto saveUser(User user) {

        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new ConflictException("El email ya está registrado");
        }

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UserDto user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getId());
        if (existingUserOpt.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado con id: " + user.getId());
        }
        User existingUser = existingUserOpt.get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userMapper.toDto(userRepository.save(existingUser));
    }

    @Override
    public UserDto login(UserDto userDto) {
        boolean exists = userRepository.existsUserByNameAndPassword(userDto.getName(),
                userDto.getPassword());

        if (!exists) {
            throw new InvalidCredentialsException("Credenciales  incorrectas");
        }
        User user = userRepository.findByName(userDto.getName()).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        return userMapper.toDto(user);
    }

    @Override
    public Boolean existUserByEmail(String email) {
        boolean exists = userRepository.existsUserByEmail(email);
        if (exists) {
            throw new ConflictException("El email ingresado ya esta registrado");
        }
        return false;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado con id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)){
            throw new NotFoundException("Usuario no encontrado con id: "+ id);
        }
        userRepository.deleteById(id);
    }

}
