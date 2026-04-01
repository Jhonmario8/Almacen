package com.example.onix.models.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDto {

    @NotBlank(message = "{name.cannot_be_blank}")
    private String name;

}
