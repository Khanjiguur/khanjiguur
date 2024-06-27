package com.e_commerce.e_commerce.services;


import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getTopRatedProducts() {
        return productRepository.findTop6ByOrderByRatingDesc();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
