package com.example.onix.services;

import com.example.onix.exceptions.ConflictException;
import com.example.onix.exceptions.InvalidCredentialsException;
import com.example.onix.exceptions.NotFoundException;
import com.example.onix.mappers.UserMapper;
import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("No se encontro ningun usuario");
        }
        return userMapper.toDtoList(users);
    }

    @Override
    public UserDto saveUser(UserDto dto) {
        User user = userMapper.toEntity(dto);
        if (userRepository.existsUserByEmail(user.getEmail())) {
            throw new ConflictException("El email ya está registrado");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(Long id,UserDto user) {
        Optional<User> existingUserOpt = userRepository.findById(id);
        if (existingUserOpt.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado con id: " + id);
        }
        User existingUser = existingUserOpt.get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userMapper.toDto(userRepository.save(existingUser));
    }

    @Override
    public UserDto login(UserDto userDto) {
        User user = authService.login(userDto.getName(),userDto.getPassword());
        return userMapper.toDto(user);
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
