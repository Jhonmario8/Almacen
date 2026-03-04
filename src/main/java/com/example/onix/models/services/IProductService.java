package com.example.onix.models.services;

import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
    void saveProduct(Product product);
    void updateProduct(ProductDto product);
    Product getProductById(Long id);
    void deleteProductById(Long id);

}
