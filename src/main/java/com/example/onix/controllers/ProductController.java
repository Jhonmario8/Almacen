package com.example.onix.controllers;

import com.example.onix.models.dto.CommentDto;
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

    @GetMapping("/All")
    public List<ProductDto> findAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id,@RequestBody ProductDto product) {
        productService.updateProduct(id,product);
    }
     @PutMapping("/{id}/comment")
     public void updateComment(@PathVariable Long id, @RequestBody CommentDto dto){
        productService.updateComment(id, dto.getComment());
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
