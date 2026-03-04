package com.example.onix.controllers;

import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import com.example.onix.models.services.IProductService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/findAll")
    public List<ProductDto> findAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductDto product) {
        productService.updateProduct(product);
    }
    @GetMapping("/findById/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
