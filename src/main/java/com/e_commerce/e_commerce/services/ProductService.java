package com.e_commerce.e_commerce.services;

import com.e_commerce.e_commerce.dto.ProductDTO;
import com.e_commerce.e_commerce.entity.Product;
import com.e_commerce.e_commerce.entity.ProductImages;
import com.e_commerce.e_commerce.repository.ProductImagesRepository;
import com.e_commerce.e_commerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<ProductDTO> getTopRatedProducts() {
        List<Product> products = productRepository.findTop6ByOrderByRatingDesc();
        List<ProductDTO> returnProducts = new ArrayList<>();
        for (Product product : products) {
            returnProducts.add(getProductDetails(product.getId()));
        }
        return returnProducts;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> returnProducts = new ArrayList<>();
        for (Product product : products) {
            returnProducts.add(getProductDetails(product.getId()));
        }
        return returnProducts;
    }

    @Transactional
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setRating(productDTO.getRating());
        product.setDescription(productDTO.getDescription());
        product.setColor(productDTO.getColor());
        product = productRepository.save(product);
        Set<ProductImages> images = new HashSet<>();
        if (productDTO.getImageUrls() != null) {
            for (String imageUrl : productDTO.getImageUrls()) {
                ProductImages image = new ProductImages();
                image.setImageUrl(imageUrl);
                image.setProductId(product.getId());
                images.add(image);
            }
            productImagesRepository.saveAll(images);
        }
        return product;
    }

    public ProductDTO getProductDetails(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return null;
        }
        List<String> imageUrls = productImagesRepository.findByProductId(productId).stream()
                .map(ProductImages::getImageUrl)
                .collect(Collectors.toList());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        productDTO.setImageUrls(imageUrls);
        return productDTO;
    }
}
