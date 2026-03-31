package com.example.onix.models.dto;

import com.example.onix.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class ProductDto {


    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;
    private String description;
    private String image;
    private String comment;
    @NotBlank(message = "No puede estar vacio")
    private Double price;


}
