package com.example.onix.models.services;

import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import com.example.onix.models.repositories.ProductRepository;
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
    public void updateProduct(ProductDto product) {
        Optional<Product> existingProductOpt = productoRepository.findById(product.getId());
        if (existingProductOpt.isEmpty()) {
            throw new RuntimeException("Producto no encontrado con id: " + product.getId());
        }
        Product existingProduct = existingProductOpt.get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());
        productoRepository.save(existingProduct);
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
