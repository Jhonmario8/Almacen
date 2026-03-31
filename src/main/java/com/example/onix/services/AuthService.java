package com.example.onix.services;

import com.example.onix.exceptions.InvalidCredentialsException;
import com.example.onix.models.entities.CustomUserDetails;
import com.example.onix.models.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    public User login(String name, String password){
        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(name, password)
            );

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            return userDetails.getUser();
        }catch (BadCredentialsException ex){
            throw new InvalidCredentialsException("Credenciales Invalidas");
        }
    }
}
