package com.example.onix.services;

import com.example.onix.models.dto.CommentDto;
import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
    ProductDto saveProduct(Product product);
    ProductDto updateProduct(Long id, ProductDto product);
    void updateComment(Long id, String comment);
    ProductDto getProductById(Long id);
    void deleteProductById(Long id);

}
