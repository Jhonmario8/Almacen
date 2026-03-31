package com.example.onix.services;

import com.example.onix.exceptions.NotFoundException;
import com.example.onix.mappers.ProductMapper;
import com.example.onix.models.dto.ProductDto;
import com.example.onix.models.entities.Product;
import com.example.onix.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productoRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = (List<Product>) productoRepository.findAll();
        if (products.isEmpty()){
            throw new NotFoundException("No se encontraron productos");
        }
        return productMapper.toDtoList(products);
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
       return productMapper.toDto(productoRepository.save(productMapper.toEntity(product)));
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Long id, ProductDto product) {
        Product existingProduct = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado con id: " + id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());

        return productMapper.toDto(existingProduct);
    }
    @Override
    @Transactional
    public void updateComment(Long id, String comment){
        Product existingProduct = productoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Producto no encontrado con id: "+ id));
        if (comment!= null && !comment.trim().isEmpty()) {
            existingProduct.getComments().add(comment);
        }
    }
    @Override
    public ProductDto getProductById(Long id) {
        return productMapper.toDto(productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado con id: " + id)));
    }

    @Override
    public void deleteProductById(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new NotFoundException("Producto no encontrado con id: " + id);
        }
        productoRepository.deleteById(id);
    }
}
