package com.e_commerce.e_commerce.controller;


import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.entity.ProductImages;
import com.e_commerce.e_commerce.services.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products-images")
public class ProductImagesController {

    @Autowired
    private ProductImagesService productImagesService;

    @GetMapping
    public List<ProductImages> getAllProductsImages() {
        return productImagesService.getAllProductsImage();
    }

    @PostMapping
    public ProductImages createProductImages(@RequestBody ProductImages productImages) {
        return productImagesService.createProductImage(productImages);
    }
}
