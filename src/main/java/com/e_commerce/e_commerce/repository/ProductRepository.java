package com.e_commerce.e_commerce.repository;

import com.e_commerce.e_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findTop6ByOrderByRatingDesc();
}