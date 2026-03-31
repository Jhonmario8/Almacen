package com.example.onix.mappers;


import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);
    Product toEntity(ProductDto dto);

    List<ProductDto> toDtoList(List<Product> products);
}
