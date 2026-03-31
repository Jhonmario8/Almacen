package com.example.onix.models.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {


    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    @Email(message = "Formato invalido")
    private String email;
    @Size(min=8, message = "Muy corta")
    private String password;


}
