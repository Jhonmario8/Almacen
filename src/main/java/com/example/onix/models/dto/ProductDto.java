package com.example.onix.models.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {


    @NotBlank(message = "{name.cannot_be_blank}")
    private String name;
    private String description;
    private String image;
    private String comment;
    @NotBlank(message = "{product.price.cannot_be_blank}")
    private Double price;


}
