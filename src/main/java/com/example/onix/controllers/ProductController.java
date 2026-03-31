package com.example.onix.controllers;

import com.example.onix.models.dto.CommentDto;
import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import com.example.onix.models.services.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProductDto product) {
      return ResponseEntity.ok(productService.updateProduct(id,product));
    }
     @PutMapping("/{id}/comment")
     public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody CommentDto dto){
        productService.updateComment(id, dto.getComment());
        return ResponseEntity.noContent().build();
     }
    @GetMapping("/findById/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
