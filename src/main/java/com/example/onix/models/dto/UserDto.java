package com.example.onix.models.dto;

import com.example.onix.models.entities.Product;
import com.example.onix.models.entities.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Email(message = "Formato invalido")
    private String email;
    @Size(min=8, message = "Muy corta")
    private String password;


}
