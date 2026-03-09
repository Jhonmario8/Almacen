package com.example.onix.models.dto;

import com.example.onix.models.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String comment;
    private Double price;
    private Set<User> users;

    public ProductDto(Long id, String name, String description,String image, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public ProductDto(Long id, String name, String description, String image, String comment, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.comment = comment;
        this.price = price;
    }
    public ProductDto(Long id, String comment){
        this.id= id;
        this.comment= comment;
    }
}
