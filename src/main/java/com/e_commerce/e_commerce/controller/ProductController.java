package com.e_commerce.e_commerce.controller;


import com.e_commerce.e_commerce.dto.ProductDTO;
import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.entity.ProductImages;
import com.e_commerce.e_commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/top-rated")
    public List<Product> getTopRatedProducts() {
        return productService.getTopRatedProducts();
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setRating(productDTO.getRating());
        product.setColor(productDTO.getColor());

        List<ProductImages> images = productDTO.getImages().stream().map(imageDTO -> {
            ProductImages image = new ProductImages();
            image.setImageUrl1(imageDTO.getImageUrl1());
            image.setImageUrl2(imageDTO.getImageUrl2());
            image.setImageUrl3(imageDTO.getImageUrl3());
            image.setImageUrl4(imageDTO.getImageUrl4());
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList());

        product.setImages(images);

        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }
}