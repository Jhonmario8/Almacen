package com.example.onix.models.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

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
