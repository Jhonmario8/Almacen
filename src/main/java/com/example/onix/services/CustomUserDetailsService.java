package com.example.onix.services;


import com.example.onix.exceptions.NotFoundException;
import com.example.onix.models.entities.CustomUserDetails;
import com.example.onix.models.entities.User;
import com.example.onix.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        User user = userRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        return new CustomUserDetails(user);
    }

}
