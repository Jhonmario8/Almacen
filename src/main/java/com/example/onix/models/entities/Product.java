package com.example.onix.models.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @Nullable
    @Column(length = 700)
    private String description;
    @Nullable
    @Column(length = 500)
    private String image;
    @Nullable
    @ElementCollection
    private List<String> comments ;
    @NonNull
    private Double price;
    @ManyToMany(mappedBy = "products")
    private Set<User> users = new HashSet<>();

}
