package com.example.onix.services;


import com.example.onix.models.dto.ProductDto;


import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
    ProductDto saveProduct(ProductDto product);
    ProductDto updateProduct(Long id, ProductDto product);
    void updateComment(Long id, String comment);
    ProductDto getProductById(Long id);
    void deleteProductById(Long id);

}
