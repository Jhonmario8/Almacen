package com.example.onix.services;

import com.example.onix.exceptions.UnauthorizedException;
import com.example.onix.models.entities.CustomUserDetails;
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
    private final JwtService jwtService;

    public String login(String name, String password){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(name, password)
            );

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            return jwtService.generateToken(userDetails.getUsername());

        }catch (BadCredentialsException ex){
            throw new UnauthorizedException("Credenciales Invalidas");
        }
    }
}
