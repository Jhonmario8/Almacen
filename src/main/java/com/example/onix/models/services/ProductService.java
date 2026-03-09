package com.example.onix.models.services;

import com.example.onix.models.dto.CommentDto;
import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import com.example.onix.models.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productoRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return (List<ProductDto>) productoRepository.findAllDto();
    }

    @Override
    public void saveProduct(Product product) {
        productoRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductDto product) {
        Product existingProduct = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());

    }
    @Override
    @Transactional
    public void updateComment(Long id, String comment){
        Product existingProduct = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado con id: "+ id));
        if (comment!= null && !comment.trim().isEmpty()) {
            existingProduct.getComments().add(comment);
        }
    }
    @Override
    public Product getProductById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @Override
    public void deleteProductById(Long id) {
        productoRepository.deleteById(id);
    }
}
