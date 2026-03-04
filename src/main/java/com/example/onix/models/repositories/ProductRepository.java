package com.example.onix.models.repositories;

import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT new com.example.onix.models.dto.ProductDto(p.id, p.name, p.description,p.image, p.price) FROM Product p")
    List<ProductDto> findAllDto();



}
