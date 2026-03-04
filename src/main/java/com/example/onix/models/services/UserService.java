package com.example.onix.models.services;

import com.example.onix.models.dto.UserDto;
import com.example.onix.models.entities.User;
import com.example.onix.models.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return (List<UserDto>) userRepository.findAllDto();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public void updateUser(UserDto user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getId());
        if (existingUserOpt.isEmpty()){
            throw new RuntimeException("Usuario no encontrado con id: " + user.getId());
        }
            User existingUser = existingUserOpt.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            userRepository.save(existingUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
