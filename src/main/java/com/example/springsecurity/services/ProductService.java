package com.example.springsecurity.services;

import com.example.springsecurity.DTOs.ProductDTO;
import com.example.springsecurity.entities.ProductEntity;
import com.example.springsecurity.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public ProductEntity saveProduct(ProductDTO productDTO) {
        ProductEntity product = new ProductEntity();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        return productRepository.save(product);
    }

}
