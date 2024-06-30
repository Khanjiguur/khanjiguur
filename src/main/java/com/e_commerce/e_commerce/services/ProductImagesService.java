package com.e_commerce.e_commerce.services;


import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.entity.ProductImages;
import com.e_commerce.e_commerce.repository.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImagesService {

    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<ProductImages> getAllProductsImage() {
        return productImagesRepository.findAll();
    }

    public ProductImages createProductImage(ProductImages productImages) {
        return productImagesRepository.save(productImages);
    }
}
