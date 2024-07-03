package com.e_commerce.e_commerce.repository;


import com.e_commerce.e_commerce.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    List<ProductImages> findByProductId(Long productId);
}
