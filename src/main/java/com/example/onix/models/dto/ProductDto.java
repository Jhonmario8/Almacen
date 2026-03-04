package com.example.onix.models.dto;

import com.example.onix.models.entities.User;
import lombok.Data;
import java.util.Set;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Set<User> users;

    public ProductDto(Long id, String name, String description,String image,  Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}
