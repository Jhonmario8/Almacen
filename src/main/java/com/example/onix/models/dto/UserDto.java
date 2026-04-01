package com.example.onix.models.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {


    @NotBlank(message = "{name.cannot_be_blank}")
    private String name;
    @Email(message = "{user.email.should_be_valid}")
    private String email;
    @NotBlank(message = "{user.password.cannot_be_blank}")
    private String password;


}
