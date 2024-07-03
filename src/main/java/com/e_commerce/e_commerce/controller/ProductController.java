package com.e_commerce.e_commerce.controller;

import com.e_commerce.e_commerce.dto.ProductDTO;
import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/top-rated")
    public List<ProductDTO> getTopRatedProducts() {
        return productService.getTopRatedProducts();
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.saveProduct(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ProductDTO getProductDetails(@PathVariable Long id) {
        return productService.getProductDetails(id);
    }
}